package com.example.sprint_2_api.controller.customer;

import com.example.sprint_2_api.config.JwtTokenUtil;
import com.example.sprint_2_api.dto.customer.ICustomerDtoForProject;
import com.example.sprint_2_api.model.customer.Customer;
import com.example.sprint_2_api.model.user.AppUser;
import com.example.sprint_2_api.service.customer.ICustomerService;
import com.example.sprint_2_api.service.user.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private IAppUserService appUserService;

    public AppUser getUserNameFormJWT(HttpServletRequest request) {
        final String requestTokenHeader = request.getHeader("Authorization");
        String username = null;
        String jwtToken = null;
        jwtToken = requestTokenHeader.substring(7);
        username = jwtTokenUtil.getUsernameFromToken(jwtToken);
        return appUserService.findByUsername(username);
    }

    @GetMapping("/infoHistory")
    public ResponseEntity<?> getInfo(@RequestParam(name = "limit") int limit, HttpServletRequest request) {
        AppUser appUser = getUserNameFormJWT(request);
        Pageable pageable = PageRequest.of(0, limit);
        Page<ICustomerDtoForProject> page = customerService.findHistory(pageable, appUser.getId());
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @GetMapping("/infoCustomer")
    public ResponseEntity<?> getInfo(HttpServletRequest request) {
        AppUser appUser = getUserNameFormJWT(request);
        Customer customer = customerService.findCustomerByAppUser(appUser.getId()).orElse(null);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PutMapping("/editCustomer")
    public ResponseEntity<?> edit(HttpServletRequest request, @RequestBody Customer customer) {
        AppUser appUser = getUserNameFormJWT(request);
        Customer cusTemp = customerService.findCustomerByAppUser(appUser.getId()).orElse(null);
        if (cusTemp != null) {
            cusTemp.setName(customer.getName());
            customerService.save(customer);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
