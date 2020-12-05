package com.beyond.todolist.infrastructure.repository;

import com.beyond.todolist.core.model.Profession;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfessionMapper implements RowMapper<Profession> {
    @Override
    public Profession mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Profession prof = new Profession();
        prof.id = rs.getInt("id");
        prof.name = rs.getString("name");
        return prof;
    }
}
