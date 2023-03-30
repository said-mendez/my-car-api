package com.mycar.mycarapi.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

// The @Configuration annotation indicates that this class will hold a collection of beans for our application.
@Configuration
public class DatasourceConfig {
    // The @Bean annotation to this method indicates that it will be managed by the spring context and we do not need to create a new instance whenever we want to use it.
    @Bean
    // Primary is here because we can have many data sources, so this is the mainone
    @Primary
    // Configuration from application.yml
    @ConfigurationProperties("app.datasource.main")
    public HikariDataSource hikariDataSource() { // Recommended datasource by Spring Boot
        return DataSourceBuilder
                .create()
                .type(HikariDataSource.class)
                .build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(HikariDataSource hikariDataSource) {
        return new JdbcTemplate((hikariDataSource));
    }
}
