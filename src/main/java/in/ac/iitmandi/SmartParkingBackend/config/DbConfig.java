package in.ac.iitmandi.SmartParkingBackend.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Properties;

@Configuration
public class DbConfig {

    @Value("${smartparkngSIH.datasource.smartParkingDB.read.url}")
    private String smartParkingReadDbURL;

    @Value("${smartparkngSIH.datasource.smartParkingDB.read.driverclassname}")
    private String smartParkingReadDriverClassName;

    @Value("${smartparkngSIH.datasource.smartParkingDB.read.username}")
    private String smartParkingReadUserName;

    @Value("${smartparkngSIH.datasource.smartParkingDB.read.password}")
    private String smartParkingReadPassword;

    @Value("${smartparkngSIH.datasource.smartParkingDB.read.poolName}")
    private String smartParkingReadPoolName;

    @Value("${smartparkngSIH.datasource.smartParkingDB.read.maxPoolSize}")
    private String smartParkingReadMaxPoolSize;

    @Value("${smartparkngSIH.datasource.smartParkingDB.read.minimumIdle}")
    private String smartParkingReadMinIdle;

    @Value("${smartparkngSIH.datasource.smartParkingDB.read.connectionTimeout}")
    private String smartParkingReadConnectionTimeout;

    @Value("${smartparkngSIH.datasource.smartParkingDB.read.idleTimeout}")
    private String smartParkingReadIdleTimeout;

    @Value("${smartparkngSIH.datasource.smartParkingDB.write.url}")
    private String smartParkingWriteDbURL;

    @Value("${smartparkngSIH.datasource.smartParkingDB.write.driverclassname}")
    private String smartParkingWriteDriverClassName;

    @Value("${smartparkngSIH.datasource.smartParkingDB.write.username}")
    private String smartParkingWriteUserName;

    @Value("${smartparkngSIH.datasource.smartParkingDB.write.password}")
    private String smartParkingWritePassword;

    @Value("${smartparkngSIH.datasource.smartParkingDB.write.poolName}")
    private String smartParkingWritePoolName;

    @Value("${smartparkngSIH.datasource.smartParkingDB.write.maxPoolSize}")
    private String smartParkingWriteMaxPoolSize;

    @Value("${smartparkngSIH.datasource.smartParkingDB.write.minimumIdle}")
    private String smartParkingWriteMinIdle;

    @Value("${smartparkngSIH.datasource.smartParkingDB.write.connectionTimeout}")
    private String smartParkingWriteConnectionTimeout;

    @Value("${smartparkngSIH.datasource.smartParkingDB.write.idleTimeout}")
    private String smartParkingWriteIdleTimeout;

    private HikariDataSource smartParkingReadDataSource() {
        Properties dsProps = new Properties();
        dsProps.put("url", smartParkingReadDbURL);
        dsProps.put("user", smartParkingReadUserName);
        dsProps.put("password", smartParkingReadPassword);

        Properties configProps = new Properties();
        configProps.put("dataSourceClassName", smartParkingReadDriverClassName);
        configProps.put("poolName", smartParkingReadPoolName);
        configProps.put("maximumPoolSize", smartParkingReadMaxPoolSize);
        configProps.put("minimumIdle", smartParkingReadMinIdle);
        configProps.put("connectionTimeout", smartParkingReadConnectionTimeout);
        configProps.put("idleTimeout", smartParkingReadIdleTimeout);
        configProps.put("dataSourceProperties", dsProps);

        HikariConfig hc = new HikariConfig(configProps);
        HikariDataSource ds = new HikariDataSource(hc);
        return ds;
    }

    private HikariDataSource smartParkingWriteDataSource() {
        Properties dsProps = new Properties();
        dsProps.put("url", smartParkingWriteDbURL);
        dsProps.put("user", smartParkingWriteUserName);
        dsProps.put("password", smartParkingWritePassword);

        Properties configProps = new Properties();
        configProps.put("dataSourceClassName", smartParkingWriteDriverClassName);
        configProps.put("poolName", smartParkingWritePoolName);
        configProps.put("maximumPoolSize", smartParkingWriteMaxPoolSize);
        configProps.put("minimumIdle", smartParkingWriteMinIdle);
        configProps.put("connectionTimeout", smartParkingWriteConnectionTimeout);
        configProps.put("idleTimeout", smartParkingWriteIdleTimeout);
        configProps.put("dataSourceProperties", dsProps);

        HikariConfig hc = new HikariConfig(configProps);
        HikariDataSource ds = new HikariDataSource(hc);
        return ds;
    }
    @Bean(name = "smartParkingJdbcTemplateRead")
    @Lazy
    public JdbcTemplate smartParkingJdbcTemplateRead() {
        return new JdbcTemplate(smartParkingReadDataSource());
    }

    @Bean(name = "smartParkingJdbcTemplateWrite")
    @Lazy
    public JdbcTemplate smartParkingJdbcTemplateWrite() {
        return new JdbcTemplate(smartParkingWriteDataSource());
    }
}
