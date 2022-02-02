package kr.co.parkham.config.database;

import kr.co.parkham.dao.mybatis.mysql.TestDao;
import kr.co.parkham.dao.mybatis.mysql.TestDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbConfig {

    @Bean
    TestDao mysqlTestDao() {
        return new TestDaoImpl();
    }

    @Bean
    kr.co.parkham.dao.mybatis.oracle.TestDao oracleTestDao() {
        return new kr.co.parkham.dao.mybatis.oracle.TestDaoImpl();
    }
}
