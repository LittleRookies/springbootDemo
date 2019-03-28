package com.springbootdemo.springbootjpa.repository.impl;


import com.springbootdemo.springbootjpa.repository.BaseRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Author: Little Rookies
 * @Date: 2018/11/20 16:37
 */
public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

    //实体管理类，对持久化实体做增删改查，自动义sq操作模板所需要的核心类
    private final EntityManager entityManager;

    public BaseRepositoryImpl(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Map> findAllByParams(String sql, Object... args) {
        //获取session
        Session session = (Session) entityManager.getDelegate();
        Query q = session.createNativeQuery(sql);
        //查询结果转map
        q.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        int i = 1;
        for (Object arg : args
        ) {
            q.setParameter(i++, arg);
        }
        return q.list();
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Page<Map> findPageByParams(String sql, Pageable pageable, Object... args) {
        Session session = (Session) entityManager.getDelegate();
        Query q = session.createNativeQuery(sql);
        q.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        int i = 0;
        for (Object arg : args
        ) {
            q.setParameter(i++, arg);
        }

        List<Map> totalCount = q.list();
        q.setFirstResult(pageable.getPageSize() * pageable.getPageNumber());
        q.setMaxResults(pageable.getPageSize());
        List<Map> pageCount = q.list();
        return new PageImpl<>(pageCount, pageable, totalCount.size());
    }

}
