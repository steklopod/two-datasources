package ru.steklopod.databaseapp;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DatabaseConfig {

    @Bean(name = "dbprofileservice")
    @ConfigurationProperties(prefix="spring.dbprofileservice")
    @Primary
    public HikariDataSource createProfileServiceDataSource(
            @Qualifier("profileprops") DataSourceProperties properties) {

        return properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean(name = "profileprops")
    @ConfigurationProperties(prefix="spring.dbprofileservice")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }



//    @Bean(name="dbprofileservice")
//    @ConfigurationProperties(prefix="spring.dbprofileservice")
//    @Primary
//    public DataSource createProfileServiceDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name="dbTaskService")
//    @ConfigurationProperties(prefix="spring.dbTaskService")
//    public DataSource createTaskServiceDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name="jdbcProfileService")
//    @Autowired
//    public JdbcTemplate createJdbcTemplate_ProfileService(@Qualifier("dbprofileservice") DataSource profileServiceDS) {
//        return new JdbcTemplate(profileServiceDS);
//    }
//
//    @Bean(name="jdbcTaskService")
//    @Autowired
//    public JdbcTemplate createJdbcTemplate_TaskService(@Qualifier("dbTaskService") DataSource taskServiceDS) {
//        return new JdbcTemplate(taskServiceDS);
//    }


}
