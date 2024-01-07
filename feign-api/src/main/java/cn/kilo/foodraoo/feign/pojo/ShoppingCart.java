package cn.kilo.foodraoo.feign.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.DurationSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * The ShoppingCart class represents the ShoppingCart of a User in the Foodaroo system.
 *
 * @version 0.0.1-SNAPSHOT
 * @author kilo
 */
@Data
public class ShoppingCart implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private Long userId;

    private Long dishId;

    private Long setmealId;

    private String dishFlavor;

    private Integer number;

    private BigDecimal amount;

    private String image;

    private LocalDateTime createTime;
}
