package cn.kilo.foodraoo.feign.pojo;

import lombok.Data;

import java.io.Serializable;
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
