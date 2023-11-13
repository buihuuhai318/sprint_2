package com.example.sprint_2_api.repository.employee;


import com.example.sprint_2_api.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;


public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "select code_employee from employee where id = (select max(id) from employee) and flag_delete = false", nativeQuery = true)
    String getLastCodeEmployee();

    @Modifying
    @Transactional
    @Query(value = "insert into employee(code_employee,name_employee,address,phone_number,start_day,birthday,id_card,image,note,flag_delete,app_user_id) " +
            "value (:#{#employee.codeEmployee},:#{#employee.nameEmployee},:#{#employee.address},:#{#employee.phoneNumber},:#{#employee.startDay},:#{#employee.birthday},:#{#employee.idCard},:#{#employee.image},:#{#employee.note},:#{#employee.flagDelete},:app_user_id)", nativeQuery = true)
    void addEmployee(@Param(value = "employee") Employee employee,
                     @Param(value = "app_user_id") Long appUserId
    );

    @Modifying
    @Transactional
    @Query(value = "UPDATE employee SET `address` = :#{#employee.address}, `birthday` = :#{#employee.birthday}, `id_card` = :#{#employee.idCard}, `image` = :#{#employee.image}, `name_employee` = :#{#employee.nameEmployee}, `note` = :#{#employee.note}, `phone_number` = :#{#employee.phoneNumber}, `start_day` = :#{#employee.startDay} WHERE (`id` = :id) and flag_delete = false", nativeQuery = true)
    void updateEmployee(@Param(value = "employee") Employee employee,
                        @Param(value = "id") Long id
    );

    @Query(value = "SELECT * from employee where employee.phone_number = :phoneNumber and employee.flag_delete = false and employee.id <> :id", nativeQuery = true)
    Optional<Employee> findEmployeeByPhoneNumber(@Param(value = "phoneNumber") String phoneNumber, @Param(value = "id") Long id);

    @Query(value = "SELECT e.* ,uses.user_name FROM employee e " +
            "JOIN app_user uses on uses.id = e.app_user_id " +
            "JOIN user_role ur on ur.app_user_id = uses.id " +
            "JOIN app_role role on role.id = ur.app_role_id " +
            "WHERE e.flag_delete = false", nativeQuery = true)
    Page<Employee> getListEmployee(Pageable pageable);

    @Query(value = "SELECT e.*, uses.id, uses.user_name, role.name FROM employee e" +
            " JOIN app_user uses on uses.id = e.app_user_id" +
            " JOIN user_role ur on ur.app_user_id = uses.id" +
            " JOIN app_role role on role.id = ur.app_role_id" +
            " WHERE e.flag_delete = false AND" +
            " e.name_employee LIKE concat('%', :name_employee,'%')", nativeQuery = true)
    Page<Employee> searchEmployeeByNameAndRole(Pageable pageable, @Param("name_employee") String name);

    @Query(value = "SELECT * from employee where employee.id = :id and employee.flag_delete = false", nativeQuery = true)
    Optional<Employee> findEmployeeById(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "update employee set flag_delete = true where employee.id = :id", nativeQuery = true)
    void deleteEmployeeById(@Param("id") Long id);


    Optional<Employee> getEmployeeByAndAppUser_Id(Long id);
}
