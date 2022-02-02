package kr.co.parkham.dao.mybatis.oracle.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class OracleTestService {
    protected static final String PACKAGE_NAME = OracleTestService.class.getPackage().getName();

    @Autowired
    @Qualifier("oracleSqlSessionTemplate")
    private SqlSession sqlSession;

    public String selectName() {
        return sqlSession.selectOne(PACKAGE_NAME + ".selectName");
    }
}
