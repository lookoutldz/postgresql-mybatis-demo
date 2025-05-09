package com.looko.postgresqlmybatisdemo.config.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.*;
import java.time.Duration;

@MappedTypes(Duration.class)
public class DurationTypeHandler extends BaseTypeHandler<Duration> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Duration parameter, JdbcType jdbcType) throws SQLException {
        ps.setObject(i, parameter.toString(), Types.OTHER);
    }

    @Override
    public Duration getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String interval = rs.getString(columnName);
        return interval == null ? null : parseDuration(interval);
    }

    @Override
    public Duration getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String interval = rs.getString(columnIndex);
        return interval == null ? null : parseDuration(interval);
    }

    @Override
    public Duration getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String interval = cs.getString(columnIndex);
        return interval == null ? null : parseDuration(interval);
    }

    private Duration parseDuration(String interval) {
        // PostgreSQL interval 格式可能是 "1 day 02:03:04" 或 "02:03:04" 等
        // 这里提供一个简单的解析实现，实际项目中可能需要更复杂的解析逻辑
        try {
            // 处理包含天数的情况
            if (interval.contains("day") || interval.contains("days")) {
                String[] parts = interval.split(" ");
                long days = 0;
                String timeStr = "";
                
                for (int i = 0; i < parts.length; i++) {
                    if (parts[i].equals("day") || parts[i].equals("days")) {
                        days = Long.parseLong(parts[i-1]);
                    } else if (parts[i].contains(":")) {
                        timeStr = parts[i];
                    }
                }
                
                String[] timeParts = timeStr.split(":");
                long hours = Long.parseLong(timeParts[0]);
                long minutes = Long.parseLong(timeParts[1]);
                long seconds = Long.parseLong(timeParts[2]);
                
                return Duration.ofDays(days)
                        .plusHours(hours)
                        .plusMinutes(minutes)
                        .plusSeconds(seconds);
            } 
            // 处理只有时间的情况
            else if (interval.contains(":")) {
                String[] parts = interval.split(":");
                long hours = Long.parseLong(parts[0]);
                long minutes = Long.parseLong(parts[1]);
                long seconds = parts.length > 2 ? Long.parseLong(parts[2]) : 0;
                
                return Duration.ofHours(hours)
                        .plusMinutes(minutes)
                        .plusSeconds(seconds);
            }
            // 其他格式，尝试直接解析
            else {
                return Duration.parse(interval);
            }
        } catch (Exception e) {
            // 解析失败时返回零时长
            return Duration.ZERO;
        }
    }
}