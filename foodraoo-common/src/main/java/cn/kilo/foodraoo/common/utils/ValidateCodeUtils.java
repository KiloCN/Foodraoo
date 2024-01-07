package cn.kilo.foodraoo.common.utils;

import java.util.Random;

/**
 * Randomly generate CAPTCHA tool class
 */
public class ValidateCodeUtils {
    /**
     * Randomly generate verification code
     * @param length The length is 4 or 6 bits
     * @return
     */
    public static Integer generateValidateCode(int length){
        Integer code =null;
        if(length == 4){
            code = new Random().nextInt(9999);//生成随机数，最大为9999
            if(code < 1000){
                code = code + 1000;//保证随机数为4位数字
            }
        }else if(length == 6){
            code = new Random().nextInt(999999);//生成随机数，最大为999999
            if(code < 100000){
                code = code + 100000;//保证随机数为6位数字
            }
        }else{
            throw new RuntimeException("Only 4-digit or 6-digit digital CAPTCHA can be generated");
        }
        return code;
    }

    /**
     * Randomly generate a string verification code of a specified length
     * @param length
     * @return
     */
    public static String generateValidateCode4String(int length){
        Random rdm = new Random();
        String hash1 = Integer.toHexString(rdm.nextInt());
        String capstr = hash1.substring(0, length);
        return capstr;
    }
}
