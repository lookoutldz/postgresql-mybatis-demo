package com.looko.postgresqlmybatisdemo.controller;

import com.looko.postgresqlmybatisdemo.entity.PgTypeDemo;
import com.looko.postgresqlmybatisdemo.service.PgTypeDemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/pg-type-demo")
@RequiredArgsConstructor
public class PgTypeDemoController {
    
    private final PgTypeDemoService pgTypeDemoService;
    
    // MyBatis 接口
    @PostMapping("/mybatis")
    public ResponseEntity<Void> createWithMyBatis(@RequestBody PgTypeDemo pgTypeDemo) {
        pgTypeDemoService.saveWithMyBatis(pgTypeDemo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @GetMapping("/mybatis/{id}")
    public ResponseEntity<PgTypeDemo> getByIdWithMyBatis(@PathVariable Long id) {
        PgTypeDemo pgTypeDemo = pgTypeDemoService.findByIdWithMyBatis(id);
        return pgTypeDemo != null ? ResponseEntity.ok(pgTypeDemo) : ResponseEntity.notFound().build();
    }
    
    @GetMapping("/mybatis")
    public ResponseEntity<List<PgTypeDemo>> getAllWithMyBatis() {
        return ResponseEntity.ok(pgTypeDemoService.findAllWithMyBatis());
    }
    
    @DeleteMapping("/mybatis/{id}")
    public ResponseEntity<Void> deleteByIdWithMyBatis(@PathVariable Long id) {
        pgTypeDemoService.deleteByIdWithMyBatis(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/mybatis/page")
    public ResponseEntity<Map<String, Object>> getPageWithMyBatis(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(pgTypeDemoService.findPageWithMyBatis(page, size));
    }
    
    // 新增修改记录的接口
    @PutMapping("/mybatis/{id}")
    public ResponseEntity<Void> updateWithMyBatis(@PathVariable Long id, @RequestBody PgTypeDemo pgTypeDemo) {
        // 确保ID一致
        pgTypeDemo.setId(id);
        pgTypeDemoService.saveWithMyBatis(pgTypeDemo);
        return ResponseEntity.ok().build();
    }
}