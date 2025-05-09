package com.looko.postgresqlmybatisdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.looko.postgresqlmybatisdemo.entity.PgTypeDemo;
import com.looko.postgresqlmybatisdemo.repository.mybatis.PgTypeDemoMapper;
import com.looko.postgresqlmybatisdemo.service.PgTypeDemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PgTypeDemoServiceImpl extends ServiceImpl<PgTypeDemoMapper, PgTypeDemo> implements PgTypeDemoService {

    private final PgTypeDemoMapper mybatisMapper;
    
    // MyBatis 实现
    @Override
    public void saveWithMyBatis(PgTypeDemo pgTypeDemo) {
        if (pgTypeDemo.getId() == null) {
            mybatisMapper.insert(pgTypeDemo);
        } else {
            mybatisMapper.update(pgTypeDemo);
        }
    }
    
    @Override
    public PgTypeDemo findByIdWithMyBatis(Long id) {
        return mybatisMapper.findById(id);
    }
    
    @Override
    public List<PgTypeDemo> findAllWithMyBatis() {
        return mybatisMapper.findAll();
    }
    
    @Override
    public void deleteByIdWithMyBatis(Long id) {
        mybatisMapper.deleteById(id);
    }
    
    @Override
    public Map<String, Object> findPageWithMyBatis(int page, int size) {
        int offset = (page - 1) * size;
        List<PgTypeDemo> records = mybatisMapper.findByPage(offset, size);
        int total = mybatisMapper.count();
        
        Map<String, Object> result = new HashMap<>();
        result.put("records", records);
        result.put("total", total);
        result.put("page", page);
        result.put("size", size);
        result.put("pages", (total + size - 1) / size);
        
        return result;
    }
}