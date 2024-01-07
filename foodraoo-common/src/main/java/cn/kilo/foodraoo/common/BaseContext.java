package cn.kilo.foodraoo.common;

/**
 * Based on the ThreadLocal encapsulation tool class, the user saves and acquires the currently logged-in user id
 */
public class BaseContext {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    /**
     * Set vale
     * @param id
     */
    public static void setCurrentId(Long id){
        threadLocal.set(id);
    }

    /**
     * get value
     * @return
     */
    public static Long getCurrentId(){
        return threadLocal.get();
    }
}