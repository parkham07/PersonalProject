package kr.co.parkham.config.database;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ChainedTxConfig {

    @Bean
    public PlatformTransactionManager bothTx(PlatformTransactionManager mysqlTransactionManager, PlatformTransactionManager oracleTransactionManager) {
        return new ChainedTransactionManager(mysqlTransactionManager, oracleTransactionManager);
    }

    @Bean
    public PlatformTransactionManager mysqlTx(PlatformTransactionManager mysqlTransactionManager) {
        return new ChainedTransactionManager(mysqlTransactionManager);
    }

    @Bean
    public PlatformTransactionManager oracleTx(PlatformTransactionManager oracleTransactionManager) {
        return new ChainedTransactionManager(oracleTransactionManager);
    }
}
