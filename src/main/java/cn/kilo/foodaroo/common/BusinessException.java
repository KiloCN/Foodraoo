package cn.kilo.foodaroo.common;
/**
 * Constructs a new BusinessException with the specified detail message.
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
public class BusinessException extends RuntimeException{
    public BusinessException(String message) {
        super(message);
    }
}
