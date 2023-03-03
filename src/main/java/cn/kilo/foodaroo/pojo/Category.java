package cn.kilo.foodaroo.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A Plain Ordinary Java Object Class for Category of dish or combo
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */

@Data
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;


    /**
     * type=1: dish category
     * type=2: combo category
     */
    private Integer type;


    /**
     * Category name
     */
    private String name;


    /**
     * Category sort
     */
    private Integer sort;


    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;


    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


    @TableField(fill = FieldFill.INSERT)
    private Long createUser;


    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateUser;

}
