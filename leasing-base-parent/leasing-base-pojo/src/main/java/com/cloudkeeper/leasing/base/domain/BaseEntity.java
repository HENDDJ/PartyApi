package com.cloudkeeper.leasing.base.domain;

import com.cloudkeeper.leasing.base.enumeration.BooleanEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.annotation.Nonnull;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 基础实体类
 * @author jerry
 */
@Getter
@Setter
@Accessors(chain = true)
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Slf4j
public abstract class BaseEntity implements Serializable {

    /**
     * 主键id
     * GenericGenerator 注解 strategy 参数设置参考如下
     * @see org.hibernate.id.factory.internal.DefaultIdentifierGeneratorFactory
     * 参考网站：https://blog.csdn.net/mafian/article/details/53968878
     */
    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "uuid2")
    @Column(length = 36)
    @ApiModelProperty(value = "主键id", position = 1)
    private String id;

    /** 创建时间*/
    @CreatedDate
    @ApiModelProperty(value = "创建时间", position = 2)
    private LocalDateTime createdAt;

    /** 更新时间*/
    @LastModifiedDate
    @ApiModelProperty(value = "更新时间", position = 3)
    private LocalDateTime modifiedAt;

    /** 创建人*/
    @Column(length = 36)
    @CreatedBy
    @ApiModelProperty(value = "创建人", position = 4)
    private String createdBy;

    /** 更新人*/
    @Column(length = 36)
    @LastModifiedBy
    @ApiModelProperty(value = "更新人", position = 5)
    private String modifiedBy;

    /** 版本（乐观锁）*/
    @Version
    @ApiModelProperty(value = "版本（乐观锁）", position = 6)
    private Integer version;

    /** 逻辑删除*/
    @ApiModelProperty(value = "逻辑删除", position = 7)
    private Integer isDelete = BooleanEnum.FALSE.ordinal();

    /**
     * 实体类转换
     * @param clazz 目标对象class
     * @param <T> 泛型
     * @return 目标对象
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
     * 实体类转换
     * @param collection 实体集合
     * @param clazz 目标对象
     * @param <T> 泛型
     * @return 目标集合
     */
    @Nonnull
    public static <T> List<T> convert(@Nonnull Collection<? extends BaseEntity> collection, @Nonnull Class<T> clazz) {
        return collection.stream().map(entity -> entity.convert(clazz)).collect(Collectors.toList());
    }

    /**
     * 实体分页转换
     * @param page 实体分页
     * @param clazz 目标对象
     * @param <T> 泛型
     * @return 目标分页
     */
    @Nonnull
    public static <T> Page<T> convert(@Nonnull Page<? extends BaseEntity> page, @Nonnull Class<T> clazz) {
        List<T> eList = BaseEntity.convert(page.getContent(), clazz);
        return new PageImpl<>(eList, page.getPageable(), page.getTotalElements());
    }

}
