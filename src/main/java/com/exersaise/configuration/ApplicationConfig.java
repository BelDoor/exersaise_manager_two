package com.exersaise.configuration;


import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class ApplicationConfig {
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource){
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public DataSource hikariDataSource(DBProperties dbProperties){
        HikariDataSource hikariDataSource = new HikariDataSource();

        hikariDataSource.setUsername(dbProperties.getLogin());
        hikariDataSource.setPassword(dbProperties.getPassword());
        hikariDataSource.setDriverClassName(dbProperties.getPostgresDriverName());
        hikariDataSource.setMaximumPoolSize(dbProperties.getPoolSize());
        hikariDataSource.setJdbcUrl(dbProperties.getJdbcUrl());

        return hikariDataSource;
    }
}
