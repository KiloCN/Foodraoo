package cn.kilo.foodaroo.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * FoodraooMetaObjectHandler is a Mybatis Plus MetaObjectHandler implementation
 * that fills in create and update time and user fields for entities.
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@Component
@Slf4j
public class FoodraooMetaObjectHandler implements MetaObjectHandler {

    /**
     * Fills in the create time, update time, and create and update user fields for an entity.
     * @param metaObject The meta object to fill in the fields for.
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        Long creatorId = ThreadLocalUserId.getUserId();
        metaObject.setValue("createTime", LocalDateTime.now());
        metaObject.setValue("updateTime", LocalDateTime.now());
        metaObject.setValue("createUser", creatorId);
        metaObject.setValue("updateUser",creatorId);
    }

    /**
     * Fills in the update time and update user fields for an entity.
     * @param metaObject The meta object to fill in the fields for.
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        Long updaterId = ThreadLocalUserId.getUserId();

        metaObject.setValue("updateTime", LocalDateTime.now());
        metaObject.setValue("updateUser", updaterId);
    }
}
