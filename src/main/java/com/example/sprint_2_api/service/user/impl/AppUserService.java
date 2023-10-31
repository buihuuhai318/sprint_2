package com.example.sprint_2_api.service.user.impl;

import com.example.sprint_2_api.common.email.EmailTemplate;
import com.example.sprint_2_api.dto.user.JwtResponseUserDetails;
import com.example.sprint_2_api.model.employee.Employee;
import com.example.sprint_2_api.model.customer.Customer;
import com.example.sprint_2_api.model.user.AppUser;
import com.example.sprint_2_api.model.user.UserRole;
import com.example.sprint_2_api.repository.user.IAppUserRepository;
import com.example.sprint_2_api.service.customer.ICustomerService;
import com.example.sprint_2_api.service.employee.IEmployeeService;
import com.example.sprint_2_api.service.user.IAppUserService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AppUserService implements IAppUserService {

    @Autowired
    private IAppUserRepository appUserRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IEmployeeService employeeService;


    /**
     * method loadUserByUsername
     * Create HaiBH
     * Date 12-10-2023
     * param String username
     * return userDetails
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findAppUserByName(username);
        if (appUser == null) {
            throw new UsernameNotFoundException("User name or password is wrong");
        }

        List<GrantedAuthority> grantList = new ArrayList<>();
        for (UserRole userRole : appUser.getUserRoleSet()) {
            grantList.add(new SimpleGrantedAuthority(userRole.getAppRole().getName()));
        }
        UserDetails userDetails = new JwtResponseUserDetails(
                appUser.getUserName(),
                appUser.getPassword(),
                appUser.getFlagOnline(),
                grantList);
        appUserRepository.updateAppUserIsOnline(appUser);
        return userDetails;
    }


    /**
     * method existsByUsername
     * Create HaiBH
     * Date 12-10-2023
     * param String userName
     * return boolean
     */
    @Override
    public Boolean existsByUsername(String userName) {
        AppUser appUser = appUserRepository.findAppUserByName(userName);
        return appUser != null;
    }


    /**
     * method createNewAppUser
     * Create HaiBH
     * Date 12-10-2023
     * param AppUser appUser,String role
     * return boolean
     */
    @Override
    public Boolean createNewAppUser(AppUser appUser, String role) {
        AppUser currentAppUser = appUserRepository.findAppUserByName(appUser.getUserName());
        if (currentAppUser == null) {
            Integer amountAppUserCreated = appUserRepository.addNewAppUser(appUser);
            Long roleId = appUserRepository.findAppRoleIdByName(role);
            currentAppUser = appUserRepository.findAppUserByName(appUser.getUserName());
            appUserRepository.insertRoleForCustomer(roleId, currentAppUser.getId());
            return amountAppUserCreated > 0;
        }
        return false;
    }


    /**
     * method logout
     * Create HaiBH
     * Date 12-10-2023
     * param String userName
     * return boolean
     */
    @Override
    public Boolean logout(String userName) {
        return appUserRepository.updateAppUserIsOffline(userName) > 0;
    }

    /**
     * method findAppUserIdByUserName
     * Create HaiBH
     * Date 12-10-2023
     * param String userName
     * return long
     */
    @Override
    public Long findAppUserIdByUserName(String userName) {
        return appUserRepository.findIdByUserName(userName);
    }

    /**
     * method existsById
     * Create HaiBH
     * Date 12-10-2023
     * param Long id
     * return boolean
     */
    @Override
    public boolean existsById(Long id) {
        return appUserRepository.existsById(id);
    }

    /**
     * method generateOneTimePassword
     * Create HaiBH
     * Date 12-10-2023
     * param AppUser appUser, PasswordEncoder passwordEncoder
     * return void
     */
    @Override
    public void generateOneTimePassword(AppUser appUser, PasswordEncoder passwordEncoder, String subject, String title) throws MessagingException, UnsupportedEncodingException {
        String OTP = RandomString.make(8);
        String encodedOTP = passwordEncoder.encode(OTP);

        appUser.setOneTimePassword(encodedOTP);
        appUser.setOtpRequestedTime(new Date());

        appUserRepository.updateOtp(appUser);

        sendOTPEmail(appUser, OTP, subject, title);
    }

    /**
     * method sendOTPEmail
     * Create HaiBH
     * Date 12-10-2023
     * param AppUser appUser, String OTP
     * return void
     */
    @Override
    public void sendOTPEmail(AppUser appUser, String OTP, String subject, String title) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("thehome@gmail.com", "#Thehome - " + title);
        helper.setTo(appUser.getEmail());

//        String subject = "Xác thực mật khẩu (OTP) - Expire in 5 minutes!";
        String content;

        Customer customer = customerService.findCustomerByAppUser(appUser.getId()).orElse(null);

        if (customer != null) {
            if (customer.getName() == null) {
                content = EmailTemplate.getTemplateEmail(appUser.getUserName(), OTP);
            } else {
                if (customer.getName().trim().equals("")) {
                    content = EmailTemplate.getTemplateEmail(appUser.getUserName(), OTP);
                } else {
                    content = EmailTemplate.getTemplateEmail(customer.getName(), OTP);
                }
            }
        } else {
            Employee employee = employeeService.getEmployeeByUserName(appUser.getUserName()).orElse(null);
            if (employee == null) {
                content = EmailTemplate.getTemplateEmail(appUser.getUserName(), OTP);
            } else {
                if (employee.getNameEmployee().trim().equals("")) {
                    content = EmailTemplate.getTemplateEmail(appUser.getUserName(), OTP);
                } else {
                    content = EmailTemplate.getTemplateEmail(employee.getNameEmployee(), OTP);
                }
            }
        }


        helper.setSubject(subject);

        helper.setText(content, true);

        mailSender.send(message);
    }

    /**
     * method findByUsername
     * Create HaiBH
     * Date 12-10-2023
     * param String name
     * return Optional
     */
    @Override
    public Optional<AppUser> findByUsername(String name) {
        return appUserRepository.findAppUserByUserName(name);
    }

    /**
     * method findAppUserById
     * Create HaiBH
     * Date 12-10-2023
     * param Long id
     * return AppUser
     */
    @Override
    public AppUser findAppUserById(Long id) {
        return appUserRepository.findAppUserById(id);
    }

    /**
     * method updateInfoUser
     * Create HaiBH
     * Date 12-10-2023
     * param AppUser appUser
     * return void
     */
    @Override
    public void updateInfoUser(AppUser appUser) {
        appUserRepository.updateInfoUser(appUser);
    }

    /**
     * method updatePass
     * Create HaiBH
     * Date 12-10-2023
     * param AppUser appUser
     * return void
     */
    @Override
    public void updatePass(AppUser appUser) {
        appUserRepository.updatePass(appUser);
    }
}