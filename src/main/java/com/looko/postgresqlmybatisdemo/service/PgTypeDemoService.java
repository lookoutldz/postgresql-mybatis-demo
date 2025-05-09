package com.looko.postgresqlmybatisdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.looko.postgresqlmybatisdemo.entity.PgTypeDemo;

import java.util.List;
import java.util.Map;

public interface PgTypeDemoService extends IService<PgTypeDemo> {
    
    // 移除JPA方法
    
    // MyBatis 方法
    void saveWithMyBatis(PgTypeDemo pgTypeDemo);
    PgTypeDemo findByIdWithMyBatis(Long id);
    List<PgTypeDemo> findAllWithMyBatis();
    void deleteByIdWithMyBatis(Long id);
    
    // 分页查询
    Map<String, Object> findPageWithMyBatis(int page, int size);
}