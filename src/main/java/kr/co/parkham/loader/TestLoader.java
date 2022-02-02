package kr.co.parkham.loader;

import kr.co.parkham.dao.mybatis.mysql.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class TestLoader implements ApplicationRunner {

    @Autowired
    private TestDao mysqlTestDao;

    @Override
    public void run(ApplicationArguments args) throws Exception{
        System.out.println(TestLoader.class.getName() + " : start : " + mysqlTestDao.selectName());
    }

}
