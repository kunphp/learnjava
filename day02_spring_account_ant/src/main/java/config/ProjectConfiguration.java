package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(value = "com.kunjava")
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class ProjectConfiguration {

}
