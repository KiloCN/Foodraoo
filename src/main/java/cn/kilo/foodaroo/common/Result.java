package cn.kilo.foodaroo.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;


/**
 * General class for return result, which is used to encapsulate the corresponding data on the server side
 * @param <T>
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@Data
public class Result<T> {

    /**
     * code represent whether is success
     * Encoding: 1 success, 0 and other digits represent  failure
     */
    private Integer code;

    /**
     * msg carry message to report the info of error
     */
    private String msg;

    /**
     * data is used to carry data
     */
    private T data;

    /**
     * map is used for dynamic data
     */
    private Map map = new HashMap();

    /**
     * Get a Result object for successful request
     * @param object is the target object which returns to the requester
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T object) {
        Result<T> r = new Result<T>();
        r.data = object;
        r.code = 1;
        return r;
    }

    /**
     * Get a Result object for unsuccessful request
     * @param msg carries the error's info
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(String msg) {
        Result r = new Result();
        r.msg = msg;
        r.code = 0;
        return r;
    }

    /**
     * Add dynamic data in this Result object
     * @param key
     * @param value
     * @return
     */
    public Result<T> add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }

}
