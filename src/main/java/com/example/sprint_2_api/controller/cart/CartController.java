package com.example.sprint_2_api.controller.cart;

import com.example.sprint_2_api.config.JwtTokenUtil;
import com.example.sprint_2_api.dto.bill.BillDto;
import com.example.sprint_2_api.dto.cart.CartDto;
import com.example.sprint_2_api.dto.cart.ICartDto;
import com.example.sprint_2_api.model.bill.Bill;
import com.example.sprint_2_api.model.bill.Payment;
import com.example.sprint_2_api.model.cart.Cart;
import com.example.sprint_2_api.model.project.CharitableProject;
import com.example.sprint_2_api.model.user.AppUser;
import com.example.sprint_2_api.service.bill.IBillService;
import com.example.sprint_2_api.service.cart.ICartService;
import com.example.sprint_2_api.service.company.ICompanyService;
import com.example.sprint_2_api.service.project.ICharitableProjectService;
import com.example.sprint_2_api.service.project.ICharitableTypeService;
import com.example.sprint_2_api.service.user.IAppUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private ICharitableProjectService charitableProjectService;

    @Autowired
    private ICompanyService companyService;

    @Autowired
    private ICharitableTypeService charitableTypeService;

    @Autowired
    private ICartService cartService;

    @Autowired
    private IBillService billService;

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

    @GetMapping("/getMoneyCart")
    public ResponseEntity<?> getMoney(HttpServletRequest request) {
        AppUser appUser = getUserNameFormJWT(request);
        if (appUser != null) {
            return new ResponseEntity<>(cartService.sumCart(appUser.getId(), 0) , HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getCarts")
    public ResponseEntity<?> getCarts(HttpServletRequest request) {
        AppUser appUser = getUserNameFormJWT(request);
        if (appUser != null) {
            return new ResponseEntity<>(cartService.findCartsDto(appUser.getId()) , HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteCart/{id}")
    public ResponseEntity<?> removeCart(@PathVariable Long id) {
        cartService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addToCart(@RequestBody CartDto cartDto, HttpServletRequest request) {
        AppUser appUser = getUserNameFormJWT(request);
        CharitableProject charitableProject = charitableProjectService.findById(cartDto.getProjectId()).orElse(null);
        if (appUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Cart cart = cartService.findCartByUser(cartDto.getProjectId(), 0, appUser.getId()).orElse(null);
            if (cart != null) {
                cart.setMoney(cart.getMoney() + cartDto.getMoney());
                cart.setCreateDate(new Date());
                cartService.save(cart);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                cart = new Cart();
                cart.setMoney(cartDto.getMoney());
                cart.setAppUser(appUser);
                cart.setCreateDate(new Date());
                cart.setPayStatus(0);
                cart.setCharitableProject(charitableProject);
                cartService.save(cart);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
    }

    @GetMapping("/getBill")
    public ResponseEntity<?> getBill(HttpServletRequest request) {
        AppUser appUser = getUserNameFormJWT(request);
        Payment payment = new Payment();
        payment.setId(1L);
        Bill bill = new Bill();
        bill.setPaymentDate(new Date());
        bill.setTotalProject(cartService.findCartsDto(appUser.getId()).size());
        bill.setTotalMoney(cartService.sumCart(appUser.getId(), 0));
        bill.setPayment(payment);
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }

    @PostMapping("/getBillDone")
    public ResponseEntity<?> getBillWhenPaymentSuccess(HttpServletRequest request, @RequestBody Bill bill) {
        AppUser appUser = getUserNameFormJWT(request);
        List<Cart> list = cartService.findCarts(appUser.getId(), 0);
        bill.setStatusPayment(1);
        billService.save(bill);
        list.forEach(cart -> {
            cart.setBill(bill);
            cart.setPayStatus(1);
            cart.getCharitableProject().setCount(cart.getCharitableProject().getCount() + 1);
            cart.getCharitableProject().setNow(cart.getCharitableProject().getNow() + cart.getMoney());
            cartService.save(cart);
        });
        List<ICartDto> cartDtoList = cartService.findCartsDtoByBill(bill.getId());
        for (ICartDto cartDto : cartDtoList) {
            charitableProjectService.changeStatus(cartDto.getProjectId());
        }
        BillDto billDto = new BillDto();
        BeanUtils.copyProperties(bill, billDto);
        billDto.setList(cartDtoList);
        return new ResponseEntity<>(billDto, HttpStatus.OK);
    }
}
