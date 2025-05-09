package com.looko.postgresqlmybatisdemo.config.typehandler;

import com.looko.postgresqlmybatisdemo.entity.PgTypeDemo.MoodEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.postgresql.util.PGobject;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MoodEnumTypeHandler extends BaseTypeHandler<MoodEnum> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, MoodEnum parameter, JdbcType jdbcType) throws SQLException {
        // 使用 PGobject 设置自定义类型
        PGobject pgObject = new PGobject();
        pgObject.setType("mood");
        pgObject.setValue(parameter.getValue());
        ps.setObject(i, pgObject);
    }

    @Override
    public MoodEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        return getMoodEnum(value);
    }

    @Override
    public MoodEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);
        return getMoodEnum(value);
    }

    @Override
    public MoodEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String value = cs.getString(columnIndex);
        return getMoodEnum(value);
    }
    
    private MoodEnum getMoodEnum(String value) {
        if (value == null) {
            return null;
        }
        
        for (MoodEnum mood : MoodEnum.values()) {
            if (mood.getValue().equals(value)) {
                return mood;
            }
        }
        
        return null;
    }
}