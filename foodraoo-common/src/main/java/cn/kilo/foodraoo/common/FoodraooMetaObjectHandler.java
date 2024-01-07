package cn.kilo.foodraoo.common;

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
        metaObject.setValue("createTime", LocalDateTime.now());
        metaObject.setValue("updateTime", LocalDateTime.now());
        metaObject.setValue("createUser", BaseContext.getCurrentId());
        metaObject.setValue("updateUser", BaseContext.getCurrentId());
    }

    /**
     * Fills in the update time and update user fields for an entity.
     * @param metaObject The meta object to fill in the fields for.
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        metaObject.setValue("updateTime", LocalDateTime.now());
        metaObject.setValue("updateUser", BaseContext.getCurrentId());
    }
}
