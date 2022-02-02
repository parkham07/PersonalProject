package kr.co.parkham.controller.http;

import kr.co.parkham.dto.jpa.TestHibernateData;
import kr.co.parkham.dto.jpa.TestHibernateData2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.EntityManagerFactoryUtils;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Slf4j
@RestController
@RequestMapping(value = "/hiber/")
public class HibernateController {

    @Autowired
    private EntityManagerFactory mysqlEntityManagerFactory;

    @Autowired
    private EntityManagerFactory oracleEntityManagerFactory;

    @Autowired
    private JpaTransactionManager mysqlJpaTransactionManager;

    @Autowired
    private JpaTransactionManager oracleJpaTransactionManager;

    @GetMapping("/test")
    public String test() {
        TransactionTemplate mysqlTransactionTemplate = new TransactionTemplate(mysqlJpaTransactionManager);

        mysqlTransactionTemplate.execute(transactionStatus -> {
            EntityManager entityManager = EntityManagerFactoryUtils.getTransactionalEntityManager(mysqlEntityManagerFactory);
            TestHibernateData testHibernateData = new TestHibernateData();

            testHibernateData.setData("ewfwefewfew");

            entityManager.persist(testHibernateData);
            entityManager.flush();

            return testHibernateData;
        });

        TransactionTemplate oracleTransactionTemplate = new TransactionTemplate(oracleJpaTransactionManager);

        oracleTransactionTemplate.execute(transactionStatus -> {
            EntityManager entityManager = EntityManagerFactoryUtils.getTransactionalEntityManager(oracleEntityManagerFactory);
            TestHibernateData2 testHibernateData = new TestHibernateData2();

            testHibernateData.setTid("ewfwefewfew");
            testHibernateData.setMid("ewfwefew");
            testHibernateData.setKvpPgid("ewf");
            testHibernateData.setKvpGoodname("ewfwefewfew");
            testHibernateData.setKvpPrice(10000);
            testHibernateData.setKvpCurrency("ew");
            testHibernateData.setKvpNointInf("ewfwefewfew");
            testHibernateData.setKvpQuotaInf("ewfwefewfew");
            testHibernateData.setKvpNoint("ew");
            testHibernateData.setKvpQuota("e");
            testHibernateData.setKvpCardcode("ewfwefewfew");
            testHibernateData.setKvpConame("ewfwefewfew");
            testHibernateData.setSessionKey("ewfwefewfew");
            testHibernateData.setEncData("ewfwefewfew");

            entityManager.persist(testHibernateData);
            entityManager.flush();

            return testHibernateData;
        });

        log.info("test end");

        return "test end!!!!!!!!!!";
    }
}