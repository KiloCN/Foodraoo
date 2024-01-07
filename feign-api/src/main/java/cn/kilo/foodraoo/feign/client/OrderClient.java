package cn.kilo.foodraoo.feign.client;

import cn.kilo.foodraoo.common.Result;
import cn.kilo.foodraoo.feign.pojo.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "foodraoo-order")
public interface OrderClient {

    /**
     * Get Order by id
     * @param id
     * @return
     */
    @GetMapping("/order/getOrderById")
    public Result<Order> getOrderById(@RequestParam("id") Long id);
}
