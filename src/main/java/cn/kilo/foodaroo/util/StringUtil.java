package cn.kilo.foodaroo.util;

/**
 *The StringUtil class provides utility methods for working with strings.
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
public class StringUtil {

    /**
     Returns true if the specified object is null or an empty string, false otherwise.
     @param str the object to check for emptiness, may be null
     @return true if the specified object is null or an empty string, false otherwise
     */
    public static boolean isEmpty(Object str) {
        return str == null || "".equals(str);
    }

    /**
     Returns true if the specified object is not null and not an empty string, false otherwise.
     @param str the object to check for non-emptiness, may be null
     @return true if the specified object is not null and not an empty string, false otherwise
     */
    public static boolean isNotEmpty(Object str) {
        return !StringUtil.isEmpty(str);
    }
}
