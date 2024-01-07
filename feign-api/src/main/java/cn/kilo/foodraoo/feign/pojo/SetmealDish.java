package cn.kilo.foodraoo.feign.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
/**
 * The SetmealDish class represents a relationship between a set meal and a dish.
 * It contains information such as the set meal id, dish id, name, price, number of copies, sort order,
 * and metadata such as create time, update time, and user IDs for creation and updates.
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@Data
public class SetmealDish implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;


    private Long setmealId;


    private Long dishId;


    private String name;

    private BigDecimal price;

    private Integer copies;


    private Integer sort;


    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;


    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


    @TableField(fill = FieldFill.INSERT)
    private Long createUser;


    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateUser;


    private Integer isDeleted;
}
