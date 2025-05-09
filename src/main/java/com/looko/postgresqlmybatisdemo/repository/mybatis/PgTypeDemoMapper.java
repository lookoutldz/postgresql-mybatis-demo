package com.looko.postgresqlmybatisdemo.repository.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.looko.postgresqlmybatisdemo.entity.PgTypeDemo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PgTypeDemoMapper extends BaseMapper<PgTypeDemo> {

    // 根据 ID 查询
    PgTypeDemo findById(@Param("id") Long id);
    
    // 查询所有记录
    List<PgTypeDemo> findAll();
    
    // 根据字符串值查询
    List<PgTypeDemo> findByVarcharValue(@Param("value") String value);
    
    // 更新记录
    void update(PgTypeDemo pgTypeDemo);
    
    // 删除记录
    void deleteById(@Param("id") Long id);
    
    // 分页查询
    List<PgTypeDemo> findByPage(@Param("offset") int offset, @Param("limit") int limit);
    
    // 获取总记录数
    int count();
}