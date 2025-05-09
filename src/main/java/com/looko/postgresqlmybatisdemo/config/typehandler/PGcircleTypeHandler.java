package com.looko.postgresqlmybatisdemo.config.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.postgresql.geometric.PGcircle;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(PGcircle.class)
public class PGcircleTypeHandler extends BaseTypeHandler<PGcircle> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, PGcircle parameter, JdbcType jdbcType) throws SQLException {
        ps.setObject(i, parameter);
    }

    @Override
    public PGcircle getNullableResult(ResultSet rs, String columnName) throws SQLException {
        Object obj = rs.getObject(columnName);
        return obj == null ? null : (PGcircle) obj;
    }

    @Override
    public PGcircle getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        Object obj = rs.getObject(columnIndex);
        return obj == null ? null : (PGcircle) obj;
    }

    @Override
    public PGcircle getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        Object obj = cs.getObject(columnIndex);
        return obj == null ? null : (PGcircle) obj;
    }
}