package com.example.sprint_2_api.repository.cart;

import com.example.sprint_2_api.dto.cart.ICartDto;
import com.example.sprint_2_api.model.cart.Cart;
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
}
