package cn.mimik.finance.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by liugang on 2017/9/13.
 */
@Configuration
@EnableTransactionManagement
@Slf4j
public class DatabaseConfig implements EnvironmentAware {

    private RelaxedPropertyResolver propertyResolver;

    @Value("${app.datasource.username}")
    private String username;

    @Value("${app.datasource.password}")
    private String password;

    @Value("${app.datasource.url}")
    private String url;

    @Value("${app.datasource.driverclass}")
    private String driverClass;

    //我们只需要配置一个数据源即可，mybatis-spring-boot-starter会自动帮我们创建SqlSessionFactory和SqlSessionTemplate
    @Bean(name="dataSource", destroyMethod = "close", initMethod="init")
    public DataSource druidDataSource(){
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClass);
        log.debug("Druid DataSource create success .... url {} , username {} ,driverClass {}", url, username, driverClass);
        return dataSource;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.propertyResolver = new RelaxedPropertyResolver(environment,"app.datasource");
    }
}
