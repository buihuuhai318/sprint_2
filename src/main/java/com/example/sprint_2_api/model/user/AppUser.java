package com.example.sprint_2_api.model.user;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    private Boolean flagDeleted;
    private Boolean flagOnline;
    private String email;

    private static final int OTP_VALID_DURATION = 5 * 60 * 1000;   // 5 minutes

    @Column(name = "one_time_password")
    private String oneTimePassword;

    @Column(name = "otp_requested_time")
    private Date otpRequestedTime;

    private String urlResetPassWord;
    private Date dateResetPassWord;

    @JsonBackReference
    @OneToMany(mappedBy = "appUser", fetch = FetchType.EAGER)
    private Set<UserRole> userRoleSet;

    public boolean isOTPRequired() {
        if (this.getOneTimePassword() == null) {
            return false;
        }
        long currentTimeInMillis = System.currentTimeMillis();
        long otpRequestedTimeInMillis = this.otpRequestedTime.getTime();

        // OTP expires
        return otpRequestedTimeInMillis + OTP_VALID_DURATION >= currentTimeInMillis;
    }

    public boolean isResetPassRequired() {
        if (this.getUrlResetPassWord() == null) {
            return false;
        }
        long currentTimeInMillis = System.currentTimeMillis();
        long otpRequestedTimeInMillis = this.dateResetPassWord.getTime();

        // OTP expires
        return otpRequestedTimeInMillis + OTP_VALID_DURATION >= currentTimeInMillis;
    }
}
