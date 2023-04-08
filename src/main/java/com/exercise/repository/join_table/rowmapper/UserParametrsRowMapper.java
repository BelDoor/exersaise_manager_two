package com.exercise.repository.join_table.rowmapper;

import com.exercise.domain.UserParametrs;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.exercise.repository.columns.UserParametrsColumns.FAT_PERCENT;
import static com.exercise.repository.columns.UserParametrsColumns.MAX_BENCH;
import static com.exercise.repository.columns.UserParametrsColumns.MAX_SQUAT;
import static com.exercise.repository.columns.UserParametrsColumns.MAX_TRACTION;
import static com.exercise.repository.columns.UserParametrsColumns.NAME;
import static com.exercise.repository.columns.UserParametrsColumns.SURNAME;
import static com.exercise.repository.columns.UserParametrsColumns.WEIGHT;

@Component
public class UserParametrsRowMapper implements RowMapper<UserParametrs> {
    @Override
    public UserParametrs mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserParametrs userParametrs = new UserParametrs();

        userParametrs.setName(rs.getString(NAME));
        userParametrs.setSurname(rs.getString(SURNAME));
        userParametrs.setWeight(rs.getFloat(WEIGHT));
        userParametrs.setFatPercent(rs.getFloat(FAT_PERCENT));
        userParametrs.setMaxBench(rs.getFloat(MAX_BENCH));
        userParametrs.setMaxSquat(rs.getFloat(MAX_SQUAT));
        userParametrs.setMaxTraction(rs.getFloat(MAX_TRACTION));

        return userParametrs;
    }
}
