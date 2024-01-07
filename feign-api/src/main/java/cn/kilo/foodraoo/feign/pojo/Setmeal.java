package cn.kilo.foodraoo.feign.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * This class represents a Setmeal in the food ordering system.
 * It contains information about the Setmeal, including its id, category id, name, price, status, code, description,
 * image, create time, update time, create user, and update user.
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */

@Data
public class Setmeal implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * The unique identifier of the Setmeal.
     */
    private Long id;


    /**
     * The identifier of the category that this Setmeal belongs to.
     */
    private Long categoryId;


    /**
     * The name of the Setmeal.
     */
    private String name;


    /**
     * The price of the Setmeal.
     */
    private BigDecimal price;


    /**
     * The status of the Setmeal.
     * 0 represents stop use and 1 represents enabled.
     */
    private Integer status;


    /**
     * The code of the Setmeal.
     */
    private String code;


    /**
     The description of the Setmeal.
     */
    private String description;


    /**
     * The image of the Setmeal.
     */
    private String image;


    /**
     * The time when the Setmeal was created.
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * The time when the Setmeal was last updated.
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


    /**
     * The user who created the Setmeal.
     */
    @TableField(fill = FieldFill.INSERT)
    private Long createUser;

    /**
     * The user who last updated the Setmeal.
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateUser;

}
