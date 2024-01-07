package cn.kilo.foodraoo.feign.pojo;

import lombok.Data;

@Data
public class DeliveryDetail {

        private double[] customerPos;
        private double[] deliverPos;
        private double[] shopPos;
}
