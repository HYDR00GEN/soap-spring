package it.siav.SpringSOAPws.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;
@Configuration
public class JdbcConfig {
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource driver = new DriverManagerDataSource();
        driver.setDriverClassName("org.h2.Driver");
        driver.setUrl("jdbc:h2:file:./prova");
        driver.setUsername("sb");
        driver.setPassword("");
        return driver;
    }
}
