package cn.kilo.foodaroo.controller;

import cn.kilo.foodaroo.service.OrderDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * The OrderDetailController class handles HTTP requests related to OrderDetail management.
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@RestController
@RequestMapping
@Slf4j
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;
}
