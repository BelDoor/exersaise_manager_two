package com.exercise.repository.join_table;

import com.exercise.domain.UserParametrs;
import com.exercise.repository.join_table.rowmapper.UserParametrsRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UsersJoinParametersTemplateImpl implements UsersJoinParameters {

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final UserParametrsRowMapper userParametrsRowMapper;

    @Override
    public List<UserParametrs> findUserParameters(Long id) {
        SqlParameterSource parameters = new MapSqlParameterSource("id", id);

        return namedParameterJdbcTemplate.query("SELECT u.name, u.surname," +
                "par.weight, par.fat_percent, par.max_bench, par.max_squat, " +
                "par.max_traction FROM users AS u JOIN parameters_gym AS par ON u.id = par.user_id WHERE u.id = (:id)",
                parameters, userParametrsRowMapper);
    }
}
//    query("SELECT u.name, u.surname, par.weight, par.fat_percent, par.max_bench, par.max_squat, par.max_traction FROM users AS u JOIN parameters_gym AS par ON u.id = par.user_id WHERE u.id = ?",
//          userParametrsRowMapper)