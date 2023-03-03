package cn.kilo.foodaroo.common;

/**
 * ThreadLocalUserId is a utility class for storing and retrieving the ID of the current user
 * in a thread-safe way using a ThreadLocal object.
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
public class ThreadLocalUserId {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    /**
     * Returns the ID of the current user.
     * @return The ID of the current user.
     */
    public static Long getUserId() {
        return threadLocal.get();
    }

    /**
     * Sets the ID of the current user.
     * @param id The ID of the current user.
     */
    public static void setUserId(Long id) {
        threadLocal.set(id);
    }
}
