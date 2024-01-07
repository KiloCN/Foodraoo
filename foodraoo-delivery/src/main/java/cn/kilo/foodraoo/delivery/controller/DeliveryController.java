package cn.kilo.foodraoo.delivery.controller;

import cn.kilo.foodraoo.common.Result;
import cn.kilo.foodraoo.feign.client.OrderClient;
import cn.kilo.foodraoo.feign.pojo.DeliveryDetail;
import cn.kilo.foodraoo.feign.pojo.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delivery")
@Slf4j
public class DeliveryController {
    @Autowired
    private OrderClient orderClient;

    @GetMapping("/postions")
    public Result<DeliveryDetail> postions(@RequestParam("id") Long id) {
        // 假设后端返回的数据结构是 { customerPos: [116.440655, 39.878694], deliverPos: [116.397933, 39.844818], shopPos: [116.377933, 39.824818] }
        Order data = orderClient.getOrderById(id).getData();
        DeliveryDetail deliveryDetail = new DeliveryDetail();
        String position = data.getPosition();
        String[] split = position.split(",");
        double[] customerPos = new double[2];
        customerPos[0] = Double.parseDouble(split[0]);
        customerPos[1] = Double.parseDouble(split[1]);


        deliveryDetail.setCustomerPos(customerPos);
        deliveryDetail.setDeliverPos(new double[]{customerPos[0] - 0.05d, customerPos[1] - 0.03d});
        deliveryDetail.setShopPos(new double[]{customerPos[0] - 0.06d, customerPos[1] - 0.04d});
        return Result.success(deliveryDetail);
    }
}
