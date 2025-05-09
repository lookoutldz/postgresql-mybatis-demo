package com.looko.postgresqlmybatisdemo.config.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.postgresql.util.PGobject;

import java.sql.*;
import java.util.Arrays;

@MappedTypes(Integer[].class)
public class IntegerArrayTypeHandler extends BaseTypeHandler<Integer[]> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Integer[] parameter, JdbcType jdbcType) throws SQLException {
        if (parameter == null) {
            ps.setNull(i, Types.ARRAY);
            return;
        }

        try {
            // 使用 Connection.createArrayOf 方法创建 PostgreSQL 数组
            Array array = ps.getConnection().createArrayOf("integer", parameter);
            ps.setArray(i, array);
        } catch (SQLException e) {
            // 如果 createArrayOf 方法失败，回退到使用 PGobject
            PGobject pgObject = new PGobject();
            pgObject.setType("integer[]");

            StringBuilder sb = new StringBuilder();
            sb.append("{");
            for (int j = 0; j < parameter.length; j++) {
                if (j > 0) {
                    sb.append(",");
                }
                if (parameter[j] != null) {
                    sb.append(parameter[j]);
                } else {
                    sb.append("NULL");
                }
            }
            sb.append("}");

            pgObject.setValue(sb.toString());
            ps.setObject(i, pgObject);
        }
    }

    @Override
    public Integer[] getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return toIntegerArray(rs.getString(columnName));
    }

    @Override
    public Integer[] getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return toIntegerArray(rs.getString(columnIndex));
    }

    @Override
    public Integer[] getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return toIntegerArray(cs.getString(columnIndex));
    }

    private Integer[] toIntegerArray(String arrayStr) {
        if (arrayStr == null || arrayStr.isEmpty()) {
            return new Integer[0];
        }

        // 移除首尾的 {}
        String strippedArray = arrayStr;
        if (strippedArray.startsWith("{") && strippedArray.endsWith("}")) {
            strippedArray = strippedArray.substring(1, strippedArray.length() - 1);
        }

        if (strippedArray.isEmpty()) {
            return new Integer[0];
        }

        // 分割字符串，注意处理 NULL 值和引号
        String[] strArray = strippedArray.split(",");
        Integer[] result = new Integer[strArray.length];

        for (int i = 0; i < strArray.length; i++) {
            String item = strArray[i].trim();
            if (item.equalsIgnoreCase("NULL") || item.isEmpty()) {
                result[i] = null;
            } else {
                try {
                    result[i] = Integer.parseInt(item);
                } catch (NumberFormatException e) {
                    // 处理无法解析的值
                    result[i] = null;
                }
            }
        }

        return result;
    }
}