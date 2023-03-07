package cn.kilo.foodaroo.pojo;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
/**
 * A Plain Ordinary Java Object Class for User
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;


    private String name;


    private String phone;


    private String sex;


    private String idNumber;


    private String avatar;


    private Integer status;
}
