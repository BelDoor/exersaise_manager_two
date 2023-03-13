package com.exersaise.repository;

import com.exersaise.domain.Users;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository{

    public static final String POSTRGES_DRIVER_NAME = "org.postgresql.Driver";
    public static final String DATABASE_URL = "jdbc:postgresql://localhost:";
    public static final int DATABASE_PORT = 5432;
    public static final String DATABASE_NAME = "/exercise_manager";
    public static final String DATABASE_LOGIN = "pablito";
    public static final String DATABASE_PASSWORD = "pablito";

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String DATE_BIRTH = "date_birth";
    private static final String SEX = "sex";
    private static final String HEIGHT = "height";
    private static final String ROLE_ID = "role_id";

    @Override
    public List<Users> findAll() {
        final String findAllQuery = "select * from users order by id desc";

        List<Users> result = new ArrayList<>();

        registredDriver();
        try(Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(findAllQuery)) {

            while (rs.next()) {
                result.add(parseResultSet(rs));
            }

            return result;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("SQL Issues!");
        }
    }

    private void registredDriver(){
        try {
            Class.forName(POSTRGES_DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver Cannot be loaded!");
            throw new RuntimeException("JDBC Driver Cannot be loaded!");
        }
    }

    private Connection getConnection(){
        String jdbcURL = StringUtils.join(DATABASE_URL, DATABASE_PORT, DATABASE_NAME);
        try {
            return DriverManager.getConnection(jdbcURL, DATABASE_LOGIN, DATABASE_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Users parseResultSet(ResultSet rs){
        Users user;

        try{
            user = new Users();
            user.setId(rs.getLong(ID));
            user.setName(rs.getString(NAME));
            user.setSurname(rs.getString(SURNAME));
            user.setDateBirth(rs.getTimestamp(DATE_BIRTH));
            user.setSex(rs.getString(SEX));
            user.setHeight(rs.getInt(HEIGHT));
            user.setRoleId(rs.getLong(ROLE_ID));
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public Users findOne(Long id) {
        return null;
    }

    @Override
    public Users create(Users object) {
        return null;
    }

    @Override
    public Users update(Users object) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void serchUser() {

    }
}
