package com.example.sprint_2_api.repository.customer;

import com.example.sprint_2_api.dto.customer.ICustomerDto;
import com.example.sprint_2_api.dto.customer.ICustomerDtoForProject;
import com.example.sprint_2_api.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update customer set name = :#{#customer.name}, email = :#{#customer.email}," +
            "address = :#{#customer.address}, phone_number = :#{#customer.phoneNumber}, note = :#{#customer.note} " +
            "where id = :#{#customer.id}")
    int updateOnlineCustomer(@Param("customer") Customer customer);

    boolean existsByEmailAndIdNotAndFlagDeleteIsFalse(String email, Long id);

    boolean existsByPhoneNumberAndIdNotAndFlagDeleteIsFalse(String phoneNumber, Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO customer(code,name,birth_day,address,phone_number,email,point,note,flag_delete,app_user_id) VALUES(:code,:name,:birth_day,:address,:phone_number,:email,:point,:note,:flag_delete,:app_user_id)", nativeQuery = true)
    void saveCustomerHasAppUser(@Param(value = "code") String code, @Param(value = "name") String name, @Param(value = "birth_day") String birthDay, @Param(value = "address") String address, @Param(value = "phone_number") String phoneNumber, @Param(value = "email") String email, @Param(value = "point") Long point, @Param(value = "note") String note, @Param(value = "flag_delete") Boolean flagDetele, @Param(value = "app_user_id") Long appUserId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO customer(code,name,birth_day,address,phone_number,email,point,note,flag_delete) VALUES(:code,:name,:birth_day,:address,:phone_number,:email,:point,:note,:flag_delete)", nativeQuery = true)
    void saveCustomer(@Param(value = "code") String code, @Param(value = "name") String name, @Param(value = "birth_day") String birthDay, @Param(value = "address") String address, @Param(value = "phone_number") String phoneNumber, @Param(value = "email") String email, @Param(value = "point") Long point, @Param(value = "note") String note, @Param(value = "flag_delete") Boolean flagDelete);

    @Modifying
    @Transactional
    @Query(value = "UPDATE customer set name = :name,birth_day = :birth_day ,address = :address ,phone_number = :phone_number,email = :email,note= :note  WHERE id =:id and flag_delete = false", nativeQuery = true)
    void updateCustomer(@Param(value = "name") String name, @Param(value = "birth_day") String birthDay, @Param(value = "address") String address, @Param(value = "phone_number") String phoneNumber, @Param(value = "email") String email, @Param(value = "note") String note, @Param(value = "id") Long id);

    @Query(value = "SELECT id,code,name,birth_day,address,phone_number,email,point,note,flag_delete,app_user_id from customer where id =:id and flag_delete = false", nativeQuery = true)
    Optional<Customer> findCustomerById(@Param(value = "id") Long id);

    @Query(value = "SELECT id,code,name,birth_day,address,phone_number,email,point,note,flag_delete,app_user_id from customer where phone_number =:phone_number and flag_delete = false", nativeQuery = true)
    Optional<Customer> findCustomerByPhoneNumber(@Param(value = "phone_number") String phoneNumber);

    @Query(value = "SELECT id,code,name,birth_day,address,phone_number,email,point,note,flag_delete,app_user_id from customer where email =:email and flag_delete = false", nativeQuery = true)
    Optional<Customer> findCustomerByEmail(@Param(value = "email") String email);

    @Query(value = "SELECT id,code,name,birth_day,address,phone_number,email,point,note,flag_delete,app_user_id from customer where code =:code and flag_delete = false", nativeQuery = true)
    Optional<Customer> findCustomerByCode(@Param(value = "code") String code);

    @Query(value = "SELECT id,code,name,birth_day,address,phone_number,email,point,note,flag_delete,app_user_id from customer where app_user_id =:app_user_id and flag_delete = false", nativeQuery = true)
    Optional<Customer> findCustomerByAppUser(@Param(value = "app_user_id") Long app_user_id);

    @Query(value = " SELECT c.id, c.code, c.name, c.birth_day as birthDay, c.address, c.phone_number as phoneNumber, c.note, " +
            "CASE WHEN c.app_user_id is null then 'Khách offline' ELSE 'Khách online' END AS customerType " +
            "FROM customer c " +
            "WHERE c.flag_delete = false AND c.name LIKE :name AND c.code LIKE :code AND c.address LIKE :address AND c.phone_number LIKE :phoneNumber AND " +
            "CASE WHEN :groupValue = '0' THEN (c.app_user_id is null) " +
            "     WHEN :groupValue = '1' THEN (c.app_user_id is not null) " +
            "     ELSE (c.app_user_id is null or c.app_user_id is not null) " +
            "END ",
            countQuery = " SELECT COUNT(*) from  customer c WHERE c.flag_delete = false AND c.name LIKE :name AND c.code LIKE :code AND c.address LIKE :address AND c.phone_number LIKE :phoneNumber AND " +
                    "CASE WHEN :groupValue = '0' THEN (c.app_user_id is null) " +
                    "     WHEN :groupValue = '1' THEN (c.app_user_id is not null) " +
                    "     ELSE (c.app_user_id is null or c.app_user_id is not null) " +
                    "END ", nativeQuery = true)
    Page<ICustomerDto> findAllCustomer(@Param(value = "name") String name, @Param(value = "code") String code, @Param(value = "address") String address, @Param(value = "phoneNumber") String phoneNumber, @Param(value = "groupValue") String groupValue, Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = " UPDATE  customer set flag_delete = true WHERE id = :id ", nativeQuery = true)
    void removeCustomer(@Param(value = "id") Long id);

    @Query(value = "SELECT au.id as id, c.name as name, ca.money as money ,ca.create_date as date, cp.title as title, cp.id as projectId, au.email as email,  SUM(ca.money) OVER (PARTITION BY au.id) as moneySum, COUNT(*) OVER (PARTITION BY au.id) as count " +
            "FROM app_user au " +
            "JOIN customer c ON c.app_user_id = au.id " +
            "JOIN cart ca ON ca.user_id = au.id " +
            "JOIN charitable_project cp ON cp.id = ca.charitable_project_id " +
            "WHERE ca.pay_status = 1 and au.id = :id " +
            "ORDER BY ca.create_date desc ", nativeQuery = true)
    Page<ICustomerDtoForProject> findHistory(Pageable pageable, Long id);
}
