package kr.co.parkham.dao.mybatis.mysql.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Repository
@Transactional(transactionManager = "mysqlTx")
public class MysqlTestService {
    protected static final String PACKAGE_NAME = MysqlTestService.class.getPackage().getName();

    @Autowired
    @Qualifier("mysqlSqlSessionTemplate")
    private SqlSession sqlSession;

    public String selectName() {
        return sqlSession.selectOne(PACKAGE_NAME + ".selectName");
    }

    public int tranTestInsert() {
        return sqlSession.insert(PACKAGE_NAME + ".insertName", "1111");
    }

    public int tranTestInsertError() throws SQLException {
        sqlSession.insert(PACKAGE_NAME + ".insertName", "2222");

        return sqlSession.insert(PACKAGE_NAME + ".insertNameError");
    }

}
