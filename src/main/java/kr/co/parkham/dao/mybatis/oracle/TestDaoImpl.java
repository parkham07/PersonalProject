package kr.co.parkham.dao.mybatis.oracle;

import kr.co.parkham.dao.mybatis.oracle.service.OracleTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class TestDaoImpl implements TestDao {

    @Autowired
    private OracleTestService oracleTestService;

    public String selectName() {
        return oracleTestService.selectName();
    }
}