package cn.kilo.foodaroo.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public Result sqlIntegrityConstraintViolationExceptionHandler(SQLIntegrityConstraintViolationException ex){
        log.info(ex.fillInStackTrace().toString());

        if(ex.getMessage().contains("Duplicate entry")){
            String[] duplicateInfo = ex.getMessage().replaceAll("\'","").split(" ");
            return Result.error("The \""+duplicateInfo[2]+"\" is already exist, please try a new one.");

        }
        return Result.error("Unhandled SQL exception");
    }


}
