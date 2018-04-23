package com.tigerit.evr.migration.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by nishat on 24/04/18
 */
@Configuration
@PropertySource({"classpath:datasource-${spring.profiles.active}.properties"})
public class DataSourceConfiguration {
    @Autowired
    private Environment env;

    @Bean
    @Primary
    public DataSource dataSourceMETA() {
        return DataSourceBuilder.create()
                .driverClassName(env.getProperty("meta.jdbc.driver"))
                .url(env.getProperty("meta.jdbc.url"))
                .username(env.getProperty("meta.jdbc.user"))
                .password(env.getProperty("meta.jdbc.password"))
                .build();
    }

    @Bean
    public DataSource dataSourceIN() {
        return DataSourceBuilder.create()
                .driverClassName(env.getProperty("source.jdbc.driver"))
                .url(env.getProperty("source.jdbc.url"))
                .username(env.getProperty("source.jdbc.user"))
                .password(env.getProperty("source.jdbc.password"))
                .build();
    }

    @Bean
    public DataSource dataSourceOUT() {
        return DataSourceBuilder.create()
                .driverClassName(env.getProperty("dest.jdbc.driver"))
                .url(env.getProperty("dest.jdbc.url"))
                .username(env.getProperty("dest.jdbc.user"))
                .password(env.getProperty("dest.jdbc.password"))
                .build();
    }

    @Bean
    public JdbcTemplate metaJdbcTemplate(@Qualifier("dataSourceMETA") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public JdbcTemplate inJdbcTemplate(@Qualifier("dataSourceIN") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public JdbcTemplate outJdbcTemplate(@Qualifier("dataSourceOUT") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
