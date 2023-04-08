package com.exercise.repository.join_table;

import com.exercise.configuration.DataBaseProperties;
import com.exercise.domain.UserParametrs;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.exercise.repository.columns.UserParametrsColumns.FAT_PERCENT;
import static com.exercise.repository.columns.UserParametrsColumns.MAX_BENCH;
import static com.exercise.repository.columns.UserParametrsColumns.MAX_SQUAT;
import static com.exercise.repository.columns.UserParametrsColumns.MAX_TRACTION;
import static com.exercise.repository.columns.UserParametrsColumns.NAME;
import static com.exercise.repository.columns.UserParametrsColumns.SURNAME;
import static com.exercise.repository.columns.UserParametrsColumns.WEIGHT;

@Repository
@Primary
@RequiredArgsConstructor
public class UsersJoinParametersImpl implements UsersJoinParameters {

    private final DataBaseProperties dataBaseProperties;

    private void registeredDriver() {
        try {
            Class.forName(dataBaseProperties.getPostgresDriverName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("JDBC Driver Cannot be loaded!");
        }
    }

    private Connection getConnection() {
        String jdbcURL = StringUtils.join(dataBaseProperties.getUrl(), dataBaseProperties.getPort(),
                dataBaseProperties.getName());
        try {
            return DriverManager.getConnection(jdbcURL, dataBaseProperties.getLogin(),
                    dataBaseProperties.getPassword());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private UserParametrs parseUserParameters(ResultSet rs) {
        UserParametrs userParametrs;

        try {
            userParametrs = new UserParametrs();

            userParametrs.setName(rs.getString(NAME));
            userParametrs.setSurname(rs.getString(SURNAME));
            userParametrs.setWeight(rs.getFloat(WEIGHT));
            userParametrs.setFatPercent(rs.getFloat(FAT_PERCENT));
            userParametrs.setMaxBench(rs.getFloat(MAX_BENCH));
            userParametrs.setMaxSquat(rs.getFloat(MAX_SQUAT));
            userParametrs.setMaxTraction(rs.getFloat(MAX_TRACTION));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return userParametrs;
    }

    @Override
    public List<UserParametrs> findUserParameters(Long id) {
        String userJoinParametersQuery = "SELECT u.name, u.surname," +
                "par.weight, par.fat_percent, par.max_bench, par.max_squat, " +
                "par.max_traction FROM users AS u JOIN parameters_gym AS par ON u.id = par.user_id WHERE u.id = ?";

        List<UserParametrs> userParametrs = new ArrayList<>();

        registeredDriver();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(userJoinParametersQuery)) {
            preparedStatement.setLong(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    userParametrs.add(parseUserParameters(resultSet));
                }

            } catch (SQLException e) {
                throw new RuntimeException();
            }

        } catch (SQLException e) {
            throw new RuntimeException("Exception in findUserParameters");
        }

        return userParametrs;
    }
}
