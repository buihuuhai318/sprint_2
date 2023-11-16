package com.example.sprint_2_api.repository.user;



import com.example.sprint_2_api.model.user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


public interface IAppUserRepository extends JpaRepository<AppUser, Long> {


    /**
     * method findAppUserByName
     * Create HaiBH
     * Date 12-10-2023
     * param String username
     * return AppUser
     */
    @Transactional
    @Query(value = "select * from app_user where user_name = :name and flag_deleted = 0 ", nativeQuery = true)
    AppUser findAppUserByName(@Param("name") String userName);

    /**
     * method findAppUserById
     * Create HaiBH
     * Date 12-10-2023
     * param Long id
     * return AppUser
     */
    @Transactional
    @Query(value = "select * from app_user where id = :id and flag_deleted = 0 ", nativeQuery = true)
    AppUser findAppUserById(@Param("id") Long id);


    /**
     * method addNewAppUser
     * Create HaiBH
     * Date 12-10-2023
     * param AppUser appUser
     * return Integer
     */
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO app_user (user_name, password, email, flag_online, flag_deleted) " +
            "VALUES (:#{#appUser.userName},:#{#appUser.password}, :#{#appUser.email}, 0, 0)", nativeQuery = true)
    Integer addNewAppUser(AppUser appUser);

    /**
     * method updateAppUserIsOnline
     * Create HaiBH
     * Date 12-10-2023
     * param AppUser appUser
     * return Integer
     */
    @Modifying
    @Transactional
    @Query(value = "update app_user set flag_online = 1 where id = :#{#appUser.id} ",nativeQuery = true)
    Integer updateAppUserIsOnline(AppUser appUser);

    /**
     * method updateAppUserIsOffline
     * Create HaiBH
     * Date 12-10-2023
     * param String userName
     * return Integer
     */
    @Modifying
    @Transactional
    @Query(value = "update app_user set flag_online = 0 where user_name = :userName ",nativeQuery = true)
    Integer updateAppUserIsOffline(@Param("userName") String userName);

    /**
     * method findIdByUserName
     * Create HaiBH
     * Date 12-10-2023
     * param String userName
     * return Long
     */
    @Transactional
    @Query(value = " select au.id from app_user au where au.user_name = :userName ",nativeQuery = true)
    Long findIdByUserName(@Param("userName") String userName);

    /**
     * method findAppRoleIdByName
     * Create HaiBH
     * Date 12-10-2023
     * param String name
     * return Long
     */
    @Transactional
    @Query(value =  " select r.id from app_role r where r.name = :name " ,nativeQuery = true)
    Long findAppRoleIdByName(@Param("name") String name);

    /**
     * method insertRoleForCustomer
     * Create HaiBH
     * Date 12-10-2023
     * param Long appRoleId, Long appUserId
     * return void
     */
    @Modifying
    @Transactional
    @Query(value = " insert into user_role (app_role_id, app_user_id) values (:appRoleId, :appUserId)",nativeQuery = true)
    void insertRoleForCustomer(@Param("appRoleId") Long appRoleId,@Param("appUserId") Long appUserId);


    @Override
    boolean existsById(Long aLong);


    @Transactional
    Optional<AppUser> findAppUserByUserName(String name);

    /**
     * method updateOtp
     * Create HaiBH
     * Date 12-10-2023
     * param AppUser appUser
     * return void
     */
    @Modifying
    @Transactional
    @Query(value = "update app_user " +
            "set " +
            "one_time_password = :#{#appUser.oneTimePassword}, " +
            "otp_requested_time = :#{#appUser.otpRequestedTime} " +
            "where id = :#{#appUser.id} ",nativeQuery = true)
    void updateOtp(AppUser appUser);

    @Modifying
    @Transactional
    @Query(value = "update app_user " +
            "set " +
            "url_reset_pass_word = :#{#appUser.urlResetPassWord}, " +
            "date_reset_pass_word = :#{#appUser.dateResetPassWord} " +
            "where id = :#{#appUser.id} ",nativeQuery = true)
    void updateUrlResetPass(AppUser appUser);

    /**
     * method updateInfoUser
     * Create HaiBH
     * Date 12-10-2023
     * param AppUser appUser
     * return void
     */
    @Modifying
    @Transactional
    @Query(value = "update app_user " +
            "set " +
            "employee_address = :#{#appUser.employeeAddress}, " +
            "employee_birthday = :#{#appUser.employeeBirthday}, " +
            "employee_name = :#{#appUser.employeeName}, " +
            "employee_phone = :#{#appUser.employeePhone}, " +
            "email = :#{#appUser.email} " +
            "where id = :#{#appUser.id} ",nativeQuery = true)
    void updateInfoUser(AppUser appUser);

    /**
     * method updatePass
     * Create HaiBH
     * Date 12-10-2023
     * param AppUser appUser
     * return void
     */
    @Modifying
    @Transactional
    @Query(value = "update app_user " +
            "set " +
            "password = :#{#appUser.password} " +
            "where id = :#{#appUser.id} ",nativeQuery = true)
    void updatePass(AppUser appUser);

    @Modifying
    @Transactional
    Optional<AppUser> findAppUserByEmail(String email);

    @Modifying
    @Transactional
    Optional<AppUser> findAppUserByUrlResetPassWord(String urlResetPassWord);
}
