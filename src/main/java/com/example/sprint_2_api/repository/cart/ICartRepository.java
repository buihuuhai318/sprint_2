package com.example.sprint_2_api.repository.cart;

import com.example.sprint_2_api.dto.cart.ICartDto;
import com.example.sprint_2_api.dto.customer.ICustomerDtoForProject;
import com.example.sprint_2_api.dto.history.IHistoryDto;
import com.example.sprint_2_api.model.cart.Cart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ICartRepository extends JpaRepository<Cart, Long> {

    Optional<Cart> findCartByCharitableProject_IdAndPayStatusAndAppUser_Id(Long id, int status, Long userId);

    List<Cart> findCartsByAppUser_IdAndPayStatus(Long id, int status);

    @Query(value = "select c.id as id, cp.title as title, datediff(cp.end_date, curdate()) as date, c.money as money, cp.id as projectId " +
            "from cart c " +
            "join charitable_project cp on c.charitable_project_id = cp.id " +
            "where c.user_id = :id and c.pay_status = 0 ", nativeQuery = true)
    List<ICartDto> findCartsDto(Long id);

    @Query(value = "select c.id as id, cp.title as title, datediff(cp.end_date, curdate()) as date, c.money as money, cp.id as projectId " +
            "from cart c " +
            "join charitable_project cp on c.charitable_project_id = cp.id " +
            "join bill b on b.id = c.bill_id " +
            "where b.id = :id ", nativeQuery = true)
    List<ICartDto> findCartsDtoByBill(Long id);

    @Query(value = "SELECT au.id as id, c.name as name, SUM(ca.money) AS money " +
            "FROM app_user au " +
            "JOIN customer c ON c.app_user_id = au.id " +
            "JOIN cart ca ON ca.user_id = au.id " +
            "JOIN charitable_project cp ON cp.id = ca.charitable_project_id " +
            "WHERE ca.pay_status = 1 AND cp.id = :id " +
            "GROUP BY au.id, c.name " +
            "order by money desc limit 10 ", nativeQuery = true)
    List<ICustomerDtoForProject> findCustomerMost(Long id);

    @Query(value = "SELECT au.id as id, c.name as name, ca.money as money ,ca.create_date " +
            "FROM app_user au " +
            "JOIN customer c ON c.app_user_id = au.id " +
            "JOIN cart ca ON ca.user_id = au.id " +
            "JOIN charitable_project cp ON cp.id = ca.charitable_project_id " +
            "WHERE ca.pay_status = 1 AND cp.id = :id " +
            "ORDER BY ca.create_date desc limit 10 ", nativeQuery = true)
    List<ICustomerDtoForProject> findCustomerLast(Long id);

    @Query(value = "select c.id as id, cp.title as title, c.create_date as date, c.money as money, cp.id as projectId, cu.name as name, cu.id as customerId, au.id as userId " +
            "from cart c " +
            "join charitable_project cp on c.charitable_project_id = cp.id " +
            "join project_type pt on pt.project_id = cp.id " +
            "join app_user au on au.id = c.user_id " +
            "join customer cu on cu.app_user_id = au.id " +
            "where c.pay_status = 1 " +
            "group by c.id " +
            "order by c.id ", nativeQuery = true)
    Page<IHistoryDto> findAllHistory(Pageable pageable);
}
