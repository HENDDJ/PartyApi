package com.cloudkeeper.leasing.base.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import javax.annotation.Nonnull;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 基础dto
 * @author jerry
 */
@Getter
@Setter
@Slf4j
public abstract class BaseDTO implements Serializable {

    /**
     * dto 转实体类
     * @param clazz 实体类
     * @param <T> 泛型
     * @return 实体类
     */
    @Nonnull
    public <T> T convert(@Nonnull Class<T> clazz) {
        T t = null;
        try {
            t = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            log.error("对象转换出错, 目标类:" + clazz.getName());
        }
        BeanUtils.copyProperties(this, t);
        return t;
    }

    /**
     * dto 转实体类
     * @param collection dto 集合
     * @param clazz 实体类
     * @param <T> 泛型
     * @return 实体类集合
     */
    @Nonnull
    public static <T> List<T> convert(@Nonnull Collection<? extends BaseDTO> collection, @Nonnull Class<T> clazz) {
        return collection.stream().map(entity -> entity.convert(clazz)).collect(Collectors.toList());
    }

}
