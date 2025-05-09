package com.looko.postgresqlmybatisdemo.entity;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.*;
import org.postgresql.geometric.PGbox;
import org.postgresql.geometric.PGcircle;
import org.postgresql.geometric.PGline;
import org.postgresql.geometric.PGpoint;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
// 移除JPA注解
public class PgTypeDemo {

    // 数值类型
    private Long id;
    
    private Integer intValue;
    private Short smallintValue;
    private Long bigintValue;
    private BigDecimal decimalValue;
    private BigDecimal numericValue;
    private Float realValue;
    private Double doubleValue;
    
    // 货币类型
    private BigDecimal moneyValue;
    
    // 字符类型
    private String charValue;
    private String varcharValue;
    private String textValue;
    
    // 日期/时间类型
    private LocalDate dateValue;
    private Time timeValue;
    private LocalDateTime timestampValue;
    private OffsetDateTime timestamptzValue;
    private Duration intervalValue;
    
    // 布尔类型
    private Boolean booleanValue;
    
    // 枚举类型
    private MoodEnum moodValue;
    
    // 几何类型
    private PGpoint pointValue;
    private PGline lineValue;
    private PGbox boxValue;
    private PGcircle circleValue;
    
    // 网络地址类型
    private String inetValue;
    private String cidrValue;
    private String macaddrValue;
    
    // 文本搜索类型
    private String tsvectorValue;
    
    // XML 类型
    private String xmlValue;
    
    // UUID 类型
    private UUID uuidValue;
    
    // JSON 类型
    private String jsonValue;
    private JsonNode jsonbValue;
    
    // 数组类型
    private Integer[] intArray;
    private String[] textArray;
    
    // 范围类型
    private String intRange;
    private String timestampRange;
    
    // 对象标识符类型
    private Long oidValue;
    
    // 复合类型 (使用 JSON 表示)
    private String addressValue;
    
    // 创建和更新时间
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    
    // 枚举定义
    @Getter
    public enum MoodEnum {
        HAPPY("happy"),
        SAD("sad"),
        NEUTRAL("neutral");
        
        private final String value;
        
        MoodEnum(String value) {
            this.value = value;
        }

    }
}