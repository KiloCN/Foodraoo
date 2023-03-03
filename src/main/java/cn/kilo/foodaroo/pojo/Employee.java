package cn.kilo.foodaroo.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * A Plain Ordinary Java Object Class for Employee
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@Component
@Data
public class Employee {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    private String name;

//    @TableField(select = false)
    private String password;

    private String phone;

    private String sex;

    private String idNumber;

    private Integer status;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    @TableField(fill = FieldFill.INSERT)
    private Long createUser;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateUser;

}
