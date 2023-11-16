package com.example.sprint_2_api.controller.admin;

import com.example.sprint_2_api.dto.history.IHistoryDto;
import com.example.sprint_2_api.service.cart.ICartService;
import com.example.sprint_2_api.service.project.ICharitableProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/admin")
public class HomeAdminController {

    @Autowired
    private ICharitableProjectService charitableProjectService;

    @Autowired
    private ICartService cartService;


    @GetMapping("/home/chart")
    public ResponseEntity<?> listTypes() {
        List<List<Long>> list = charitableProjectService.listByDay();
        list.add(new ArrayList<>());
        list.add(charitableProjectService.mapChartTypeMonth().get(0));
        list.add(charitableProjectService.mapChartTypeMonth().get(1));
        list.get(2).add(charitableProjectService.countOfToDay());
        list.get(2).add(charitableProjectService.sumMoneyOfToDay());
        list.get(2).add(charitableProjectService.countOfMonth());
        list.get(2).add(charitableProjectService.sumMoneyOfMonth());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/history")
    public ResponseEntity<?> listHistory() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<IHistoryDto> page = cartService.findAllHistory(pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }


}
