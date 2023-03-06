package cn.kilo.foodaroo.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
/**
 * The Dish class represents a dish in the Foodaroo system.
 *
 * @version 0.0.1-SNAPSHOT
 * @author kilo
 */

@Data
public class Dish implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * The ID of the dish.
     */
    private Long id;

    /**
     * The name of the dish.
     */
    private String name;

    /**
     * The ID of the category that this dish belongs to.
     */
    private Long categoryId;

    /**
     * The price of the dish.
     */
    private BigDecimal price;

    /**
     * The code of the dish.
     */
    private String code;

    /**
     * The image of the dish.
     */
    private String image;

    /**
     * The description of the dish.
     */
    private String description;


    /**
     * The status of the dish.
     * 0: stop sale
     * 1: on sale
     */
    private Integer status;

    /**
     * The sort order of the dish.
     */
    private Integer sort;


    /**
     * The date and time when the dish was created.
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;


    /**
     * The date and time when the dish was last updated.
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * The user who created the dish.
     */
    @TableField(fill = FieldFill.INSERT)
    private Long createUser;

    /**
     * The user who last updated the dish.
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateUser;

//    @TableLogic
//    private Integer isDeleted;
}
