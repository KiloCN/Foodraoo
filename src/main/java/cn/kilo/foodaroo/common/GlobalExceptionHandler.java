package cn.kilo.foodaroo.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Global Exception Handler
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@RestControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    /**
     * Handler for SQL Integrity Exception
     * @param ex
     * @return
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public Result sqlIntegrityConstraintViolationExceptionHandler(SQLIntegrityConstraintViolationException ex){
        log.info(ex.fillInStackTrace().toString());

        if(ex.getMessage().contains("Duplicate entry")){
            String regex = "Duplicate entry '([\\s\\S]*)' for key";

            String redundantContent = "";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(ex.getMessage());
            while (matcher.find()) {
                redundantContent = matcher.group(1);
            }
            System.out.println(redundantContent);
            return Result.error("The \""+redundantContent+"\" is already exist, please try a new one.");

        }
        return Result.error("Unhandled SQL exception");
    }

    /**
     * Handler for Custom Business Exception
     * @param ex
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public Result businessExceptionHandler(BusinessException ex){
        return Result.error(ex.getMessage());
    }


}
