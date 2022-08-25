package com.example.demo.configuration;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
public class DataBaseConfiguration {

    @Bean
    public DataSource dataSource() {
      DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
      dataSourceBuilder.driverClassName("org.postgresql.Driver");
      dataSourceBuilder.url("jdbc:postgresql://localhost:5432/postgres");
      dataSourceBuilder.username("postgres");
      dataSourceBuilder.password("password");
      return dataSourceBuilder.build();
  }
  }