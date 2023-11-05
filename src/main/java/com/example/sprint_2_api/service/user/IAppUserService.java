package com.example.sprint_2_api.service.user;



import com.example.sprint_2_api.model.user.AppUser;
import com.example.sprint_2_api.service.IGenerateService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.Optional;


public interface IAppUserService extends UserDetailsService, IGenerateService<AppUser> {

    Boolean existsByUsername(String userName);

    Boolean createNewAppUser(AppUser appUser,String role);

    Boolean logout(String userName);

    Long findAppUserIdByUserName(String userName);

    boolean existsById(Long id);

    void generateOneTimePassword(AppUser appUser, PasswordEncoder passwordEncoder, String subject, String title) throws MessagingException, UnsupportedEncodingException;

    void sendOTPEmail(AppUser appUser, String OTP, String subject, String title) throws MessagingException, UnsupportedEncodingException;

    void sendResetPassEmail(AppUser appUser, String OTP, String subject, String title) throws MessagingException, UnsupportedEncodingException;

    void generateResetPass(AppUser appUser, PasswordEncoder passwordEncoder, String subject, String title) throws MessagingException, UnsupportedEncodingException;


    AppUser findByUsername(String name);

    AppUser findAppUserById(Long id);
    void updateInfoUser(AppUser appUser);

    void updatePass(AppUser appUser);

    Optional<Object> getObjByAppUser(AppUser appUser);

    Optional<AppUser> findAppUserByEmail(String email);

    Optional<AppUser> findAppUserByUrlResetPassWord(String urlResetPassWord);
}