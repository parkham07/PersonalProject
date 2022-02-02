package kr.co.parkham.dao.mybatis.mysql;

import kr.co.parkham.dao.mybatis.mysql.service.MysqlTestService;
import kr.co.parkham.common.Common;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class TestDaoImpl implements TestDao {

    @Autowired
    private MysqlTestService mysqlTestService;

    public String selectName() {
        return mysqlTestService.selectName();
    }

    public int tranTestInsert() {
        return mysqlTestService.tranTestInsert();
    }

    public int tranTestInsertError() {
        try {
            return mysqlTestService.tranTestInsertError();
        } catch (Exception e) {
            log.error(Common.getPrintStackTrace(e));
        }

        return 0;
    }
}