package com.example.sprint_2_api.controller.user;


import com.example.sprint_2_api.common.user.RandomStringGenerator;
import com.example.sprint_2_api.config.JwtTokenUtil;
import com.example.sprint_2_api.dto.user.AppUserDto;
import com.example.sprint_2_api.dto.user.FacebookMailRequest;
import com.example.sprint_2_api.dto.user.UserInfoDto;
import com.example.sprint_2_api.model.user.AppUser;
import com.example.sprint_2_api.model.user.JwtResponse;
import com.example.sprint_2_api.service.customer.ICustomerService;
import com.example.sprint_2_api.service.user.IAppUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/user")
public class AppUserController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private IAppUserService appUserService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ICustomerService customerService;


    private static final String LOGIN_FAILED = "Đăng nhập thất bại";

    /**
     * method getUserNameFormJWT
     * Create HaiBH
     * Date 18-10-2023
     * param HttpServletRequest request
     * return String
     */
    public String getUserNameFormJWT(HttpServletRequest request) {
        final String requestTokenHeader = request.getHeader("Authorization");
        String username = null;
        String jwtToken = null;
        jwtToken = requestTokenHeader.substring(7);
        username = jwtTokenUtil.getUsernameFromToken(jwtToken);
        return username;
    }


    /**
     * method showInformation
     * Create HaiBH
     * Date 12-10-2023
     * param Long id
     * return ResponseEntity<>();
     */
    @GetMapping("/information/{id}")
    public ResponseEntity<Object> showInformation(@PathVariable Long id, HttpServletRequest request) {
        AppUser appUser = appUserService.findAppUserById(id);
        String userName = getUserNameFormJWT(request);
        if (appUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (appUser.getUserName().equals(userName)) {
            return new ResponseEntity<>(appUser, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * method editInformation
     * Create HaiBH
     * Date 12-10-2023
     * param UserInfoDto userInfoDto, BindingResult bindingResult
     * return ResponseEntity<>();
     */
    @PutMapping("/information/edit")
    public ResponseEntity<Object> editInformation(@Valid @RequestBody UserInfoDto userInfoDto,
                                                  BindingResult bindingResult, HttpServletRequest request) {
        String userName = getUserNameFormJWT(request);
        AppUser appUser = appUserService.findAppUserById(userInfoDto.getId());
        if (appUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (userName.equals(appUser.getUserName())) {
            new UserInfoDto().validate(userInfoDto, bindingResult);
            if (bindingResult.hasErrors()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            BeanUtils.copyProperties(userInfoDto, appUser);
            appUserService.updateInfoUser(appUser);
            return new ResponseEntity<>(appUser, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * method loginByAccount
     * Create HaiBH
     * Date 12-10-2023
     * param AppUserDto appUserDto, BindingResult bindingResult
     * return ResponseEntity<>();
     */
    @PostMapping("/login-by-username")
    public ResponseEntity<Object> loginByAccount(@Valid @RequestBody AppUserDto appUserDto,
                                                 BindingResult bindingResult) throws MessagingException, UnsupportedEncodingException {

        new AppUserDto().validate(appUserDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(LOGIN_FAILED);
        }
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    appUserDto.getUserName(), appUserDto.getPassword()));
        } catch (DisabledException e) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body("Tài khoản của bạn đã bị vô hiệu hoá");
        } catch (BadCredentialsException e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(LOGIN_FAILED);
        }

        AppUser appUser = appUserService.findByUsername(appUserDto.getUserName()).orElse(null);

        String subject = "Yêu cầu đăng nhập - OTP có hiệu lực trong 5 phút!";

        appUserService.generateOneTimePassword(appUser, passwordEncoder, subject, "Yêu cầu đăng nhập");

        return new ResponseEntity<>(appUser, HttpStatus.OK);
    }

    /**
     * method confirm
     * Create HaiBH
     * Date 12-10-2023
     * param AppUserDto appUserDto
     * return ResponseEntity<>();
     */
    @PostMapping("/confirm")
    public ResponseEntity<Object> confirm(@RequestBody AppUserDto appUserDto) {
        try {
            AppUser appUser = appUserService.findByUsername(appUserDto.getUserName()).orElse(null);
            if (appUser != null) {
                if (passwordEncoder.matches(appUserDto.getOtp(), appUser.getOneTimePassword()) && appUser.isOTPRequired()) {

                    UserDetails userDetails = appUserService.loadUserByUsername(appUser.getUserName());

                    String jwtToken = jwtTokenUtil.generateToken(userDetails);

                    return ResponseEntity.ok().body(new JwtResponse(jwtToken));

                } else {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    /**
     * method resetOTP
     * Create HaiBH
     * Date 12-10-2023
     * param AppUserDto appUserDto
     * return ResponseEntity<>();
     */
    @PostMapping("/resetOTP")
    public ResponseEntity<Object> resetOTP(@RequestBody AppUserDto appUserDto) throws MessagingException, UnsupportedEncodingException {
        AppUser appUser = appUserService.findByUsername(appUserDto.getUserName()).orElse(null);
        if (appUser != null) {
            String subject = "Yêu cầu gửi lại OTP - OTP có hiệu lực trong 5 phút!";
            appUserService.generateOneTimePassword(appUser, passwordEncoder, subject, "Yêu cầu gửi lại OTP");
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    /**
     * method register
     * Create HaiBH
     * Date 12-10-2023
     * param AppUserDto appUserDto
     * return ResponseEntity<>();
     */
    @PutMapping("/register")
    public ResponseEntity<Object> register(@RequestBody AppUserDto appUserDto, HttpServletRequest request) throws MessagingException, UnsupportedEncodingException {
        try {
            String userName = getUserNameFormJWT(request);
            AppUser appUser = appUserService.findAppUserById(appUserDto.getId());
            if (appUser == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            if (userName.equals(appUser.getUserName())) {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                        appUserDto.getUserName(), appUserDto.getPassword()));
            }
        } catch (DisabledException e) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body("Tài khoản của bạn đã bị vô hiệu hoá");
        } catch (BadCredentialsException e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Đổi mật khẩu không thành công");
        }

        AppUser appUser = appUserService.findByUsername(appUserDto.getUserName()).orElse(null);

        String subject = "Yêu cầu đổi mật khẩu - OTP có hiệu lực trong 5 phút!";

        appUserService.generateOneTimePassword(appUser, passwordEncoder, subject, "Yêu cầu đổi mật khẩu");

        return new ResponseEntity<>(appUser, HttpStatus.OK);
    }

    /**
     * method confirmRegister
     * Create HaiBH
     * Date 12-10-2023
     * param AppUserDto appUserDto
     * return ResponseEntity<>();
     */
    @PostMapping("/confirmRegister")
    public ResponseEntity<Object> confirmRegister(@RequestBody AppUserDto appUserDto, HttpServletRequest request) {
        AppUser appUser = appUserService.findByUsername(appUserDto.getUserName()).orElse(null);
        if (appUser != null) {
            String userName = getUserNameFormJWT(request);
            if (userName.equals(appUser.getUserName())) {
                if (passwordEncoder.matches(appUserDto.getOtp(), appUser.getOneTimePassword()) && appUser.isOTPRequired()) {
                    appUser.setPassword(passwordEncoder.encode(appUserDto.getPassword()));
                    appUserService.updatePass(appUser);
                    return new ResponseEntity<>(HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    /**
     * method logout
     * Create HaiBH
     * Date 12-10-2023
     * param String userName
     * return ResponseEntity<>();
     */
    @GetMapping("/logout/{userName}")
    public ResponseEntity<Object> logout(@PathVariable String userName) {
        boolean logout = appUserService.logout(userName);
        if (logout) {
            return ResponseEntity.ok("Đăng xuất thành công");
        }
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Đăng xuất thất bại, vui lòng chờ trong giây lát");
    }

    /**
     * method getIdByAppUserName
     * Create HaiBH
     * Date 12-10-2023
     * param String userName
     * return ResponseEntity<>();
     */
    @GetMapping("/get-id-app-user/{userName}")
    public ResponseEntity<Object> getIdByAppUserName(@PathVariable String userName, HttpServletRequest request) {
        String userNameJWT = getUserNameFormJWT(request);
        Long id = appUserService.findAppUserIdByUserName(userName);
        if (id == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không có dữ liệu");
        } else if (userNameJWT.equals(userName)) {
            return ResponseEntity.ok().body(id);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không có dữ liệu");
    }

    /**
     * method create
     * Create HaiBH
     * Date 12-10-2023
     * param AppUserDto appUserDto, BindingResult bindingResult
     * return ResponseEntity<>();
     */
    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody AppUserDto appUserDto, BindingResult bindingResult) {
        new AppUserDto().validate(appUserDto, bindingResult);
        Map<String, String> errorMap = new HashMap<>();
        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()
            ) {
                errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return new ResponseEntity<>(errorMap, HttpStatus.NOT_ACCEPTABLE);
        }


        AppUser appUser = new AppUser();
        appUser.setUserName(appUserDto.getUserName());
        appUser.setPassword(passwordEncoder.encode(appUserDto.getPassword()));
        Boolean checkAddNewAppUser = appUserService.createNewAppUser(appUser, "ROLE_ADMIN");
        if (!Boolean.TRUE.equals(checkAddNewAppUser)) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Đăng ký thất bại, vui lòng chờ trong giây lát");
        }
        return new ResponseEntity<>("Thêm mới thành công", HttpStatus.OK);
    }

    @PostMapping("/login-by-facebook")
    public ResponseEntity<Object> loginByFacebook(@RequestBody FacebookMailRequest facebookMailRequest) {
        if (facebookMailRequest == null ||
                facebookMailRequest.getFacebookMail() == null ||
                facebookMailRequest.getFacebookMail().trim().equals("")) {
            return ResponseEntity
                    .badRequest()
                    .body(LOGIN_FAILED);
        }

        String facebookMail = facebookMailRequest.getFacebookMail();
        boolean checkExistAppUser = appUserService.existsByUsername(facebookMail);
        if (!checkExistAppUser) {
            AppUser appUser = new AppUser();
            appUser.setUserName(facebookMail);
            String randomPassword = RandomStringGenerator.generateRandomString();
            appUser.setPassword(passwordEncoder.encode(randomPassword));
            appUserService.createNewAppUser(appUser, "ROLE_CUSTOMER");
            Long appUserId = appUserService.findAppUserIdByUserName(appUser.getUserName());
            customerService.saveCustomerForAppUser(appUserId);
        }
        UserDetails userDetails = appUserService.loadUserByUsername(facebookMail);

        String jwtToken = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity
                .ok()
                .body(new JwtResponse(jwtToken));
    }
}
