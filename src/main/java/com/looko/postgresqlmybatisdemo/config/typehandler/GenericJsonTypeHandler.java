package com.looko.postgresqlmybatisdemo.config.typehandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.postgresql.util.PGobject;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 通用的 JSON 类型处理器，可以处理 PostgreSQL 的 json、jsonb 和自定义复合类型
 * @param <T> 要转换的 Java 类型
 *
 * TODO 以下待测试
 *
 * XML 中使用：
 * <result property="addressValue" column="address_value" typeHandler="com.looko.postgresqlmybatisdemo.config.typehandler.GenericJsonTypeHandler">
 *     <constructor>
 *         <arg javaType="java.lang.String"/>
 *         <arg javaType="java.lang.String" value="json"/>
 *     </constructor>
 * </result>
 *
 * 如果将 addressValue 映射到一个特定的 Java 类，比如 Address 类
 *
 * @Data
 * public class Address {
 *     private String street;
 *     private String city;
 *     private String state;
 *     private String zipCode;
 *     private String country;
 * }
 * 则 XML 中：
 * <result property="addressValue" column="address_value" typeHandler="com.looko.postgresqlmybatisdemo.config.typehandler.GenericJsonTypeHandler">
 *     <constructor>
 *         <arg javaType="com.looko.postgresqlmybatisdemo.entity.Address"/>
 *         <arg javaType="java.lang.String" value="json"/>
 *     </constructor>
 * </result>
 *
 */
public class GenericJsonTypeHandler<T> extends BaseTypeHandler<T> {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private final Class<T> type;
    private final String pgType;

    /**
     * 构造函数
     * @param type Java 类型
     * @param pgType PostgreSQL 类型名称，如 "json", "jsonb", "address" 等
     */
    public GenericJsonTypeHandler(Class<T> type, String pgType) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
        this.pgType = pgType;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException {
        PGobject pgObject = new PGobject();
        pgObject.setType(pgType);
        try {
            pgObject.setValue(OBJECT_MAPPER.writeValueAsString(parameter));
        } catch (JsonProcessingException e) {
            throw new SQLException("Error converting Java object to JSON: " + e.getMessage(), e);
        }
        ps.setObject(i, pgObject);
    }

    @Override
    public T getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return fromJson(rs.getString(columnName));
    }

    @Override
    public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return fromJson(rs.getString(columnIndex));
    }

    @Override
    public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return fromJson(cs.getString(columnIndex));
    }

    private T fromJson(String json) {
        if (json == null) {
            return null;
        }
        try {
            if (type == String.class) {
                // 如果目标类型是 String，直接返回 JSON 字符串
                @SuppressWarnings("unchecked")
                T result = (T) json;
                return result;
            } else {
                // 否则，将 JSON 转换为目标类型
                return OBJECT_MAPPER.readValue(json, type);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error parsing JSON: " + e.getMessage(), e);
        }
    }
}