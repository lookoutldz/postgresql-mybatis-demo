package com.looko.postgresqlmybatisdemo.config.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(BigDecimal.class)
public class MoneyTypeHandler extends BaseTypeHandler<BigDecimal> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, BigDecimal parameter, JdbcType jdbcType) throws SQLException {
        // 将 BigDecimal 转换为 PostgreSQL money 格式
        ps.setObject(i, parameter);
    }

    @Override
    public BigDecimal getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String moneyStr = rs.getString(columnName);
        return moneyStr == null ? null : parseMoney(moneyStr);
    }

    @Override
    public BigDecimal getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String moneyStr = rs.getString(columnIndex);
        return moneyStr == null ? null : parseMoney(moneyStr);
    }

    @Override
    public BigDecimal getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String moneyStr = cs.getString(columnIndex);
        return moneyStr == null ? null : parseMoney(moneyStr);
    }
    
    /**
     * 将 PostgreSQL money 格式字符串转换为 BigDecimal
     * 例如: "$1,234.56" -> 1234.56
     */
    private BigDecimal parseMoney(String moneyStr) {
        try {
            // 移除货币符号、千位分隔符等非数字字符（保留小数点和负号）
            String cleanedStr = moneyStr.replaceAll("[^-\\d.]", "");
            return new BigDecimal(cleanedStr);
        } catch (Exception e) {
            // 解析失败时返回零
            return BigDecimal.ZERO;
        }
    }
}