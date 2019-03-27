package com.cloudkeeper.leasing.base.service;

import com.cloudkeeper.leasing.base.dto.BaseSearchable;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Optional;

/**
 * 基础service
 * @param <T> 实体泛型
 * @author jerry
 */
public interface BaseService<T> {

    /**
     * 保存/更新
     * @param entity 实体
     * @return 实体
     */
    @Nonnull
    T save(@Nonnull T entity);

    /**
     * 保存/更新，立即刷新到数据库
     * @param entity 实体
     * @return 实体
     */
    @Nonnull
    T saveAndFlush(@Nonnull T entity);

    /**
     * 删除
     * @param entity 实体
     */
    void delete(@Nonnull T entity);

    /**
     * 删除
     * @param id 实体id
     */
    void deleteById(@Nonnull String id);

    /**
     * 查询实体
     * @param id 实体id
     * @return 实体 未加载数据库数据
     */
    T getOne(@Nonnull String id);

    /**
     * 查询实体
     * @param id 实体id
     * @return 实体
     */
    T findById(@Nonnull String id);

    /**
     * 查询实体
     * @param id 实体id
     * @return 实体
     */
    @Nonnull
    Optional<T> findOptionalById(@Nonnull String id);

    /**
     * 查询列表
     * @return 实体集合
     */
    @Nonnull
    List<T> findAll();

    /**
     * 根据查询条件，查询列表
     * @param detachedCriteria 查询条件
     * @return 实体集合
     */
    @Nonnull
    List<T> findAll(@Nonnull DetachedCriteria detachedCriteria);

    /**
     * 根据查询条件，查询分页
     * @param detachedCriteria 查询条件
     * @param pageable 分页参数
     * @return 分页实体
     */
    @Nonnull
    Page<T> findAll(@Nonnull DetachedCriteria detachedCriteria, @Nonnull Pageable pageable);

    /**
     * 查询列表
     * @param sort 排序
     * @return 实体集合
     */
    @Nonnull
    List<T> findAll(@Nonnull Sort sort);

    /**
     * 根据id集合，查询实体列表
     * @param ids id集合
     * @return 实体集合
     */
    @Nonnull
    List<T> findAllById(@Nonnull Iterable<String> ids);

    /**
     * 查询列表
     * @param searchable 查询条件
     * @return 实体集合
     */
    @Nonnull
    List<T> findAll(@Nonnull BaseSearchable searchable);

    /**
     * 查询列表
     * @param searchable 查询条件
     * @param sort 排序
     * @return 实体集合
     */
    @Nonnull
    List<T> findAll(@Nonnull BaseSearchable searchable, @Nonnull Sort sort);

    /**
     * 查询列表
     * @param example 查询条件
     * @param <S> 泛型
     * @return 实体集合
     */
    @Nonnull
    <S extends T> List<S> findAll(@Nonnull Example<S> example);

    /**
     * 查询列表
     * @param example 查询条件
     * @param sort 排序
     * @param <S> 泛型
     * @return 实体集合
     */
    @Nonnull
    <S extends T> List<S> findAll(@Nonnull Example<S> example, @Nonnull Sort sort);

    /**
     * 查询分页
     * @param pageable 分页条件
     * @return 分页实体
     */
    @Nonnull
    Page<T> findAll(@Nonnull Pageable pageable);

    /**
     * 查询分页
     * @param searchable 查询条件
     * @param pageable 分页条件
     * @return 分页实体
     */
    @Nonnull
    Page<T> findAll(@Nonnull BaseSearchable searchable, @Nonnull Pageable pageable);

    /**
     * 查询分页
     * @param example 查询条件
     * @param pageable 分页条件
     * @return 分页实体
     */
    @Nonnull
    Page<T> findAll(@Nonnull Example<T> example, @Nonnull Pageable pageable);

    /**
     * 查询列表
     * @param specification 查询条件
     * @return 实体集合
     */
    @Nonnull
    List<T> findAll(@Nonnull Specification<T> specification);

    /**
     * 查询分页
     * @param specification 查询条件
     * @param pageable 分页条件
     * @return 分页实体
     */
    @Nonnull
    Page<T> findAll(@Nonnull Specification<T> specification, @Nonnull Pageable pageable);

    /**
     * 默认查询规则
     * @return 查询规则
     */
    ExampleMatcher defaultExampleMatcher();

    /**
     * 默认查询条件
     * @param searchable 查询条件 dto
     * @return 查询条件
     */
    Example<T> defaultExample(@Nonnull BaseSearchable searchable);

    /**
     * 默认查询条件
     * @param searchable 查询条件 dto
     * @param exampleMatcher 查询规则
     * @return 查询条件
     */
    Example<T> defaultExample(@Nonnull BaseSearchable searchable, @Nonnull ExampleMatcher exampleMatcher);

}
