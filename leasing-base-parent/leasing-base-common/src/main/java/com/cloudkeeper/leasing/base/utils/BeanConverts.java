package com.cloudkeeper.leasing.base.utils;

import org.springframework.beans.BeanUtils;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * bean 转换 工具类
 * @author jerry
 */
public class BeanConverts {

    public static <T> T convert(@Nonnull Object obj, @Nonnull Class<T> clazz) {
        T t = BeanUtils.instantiateClass(clazz);
        BeanUtils.copyProperties(obj, t);
        return t;
    }

    public static <T> List<T> convert(@Nonnull Collection<?> collection, @Nonnull Class<T> clazz) {
        return collection.stream().map(item -> convert(item, clazz)).collect(Collectors.toList());
    }
}
