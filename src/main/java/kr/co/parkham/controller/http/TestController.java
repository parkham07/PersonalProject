package kr.co.parkham.controller.http;

import com.google.gson.JsonObject;
import kr.co.parkham.dao.mybatis.oracle.TestDao;
import kr.co.parkham.dto.SampleResult;
import kr.co.parkham.vo.SampleData;
import kr.co.parkham.vo.TestData;
import kr.co.parkham.dao.redis.RedisTestDataService;
import kr.co.parkham.dao.redis.RedisTestService;
import kr.co.parkham.validator.DateValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
public class TestController {

    @Autowired
    private kr.co.parkham.dao.mybatis.mysql.TestDao mysqlTestDao;

    @Autowired
    private TestDao oracleTestDao;

    @Autowired
    private RedisTestService redisTestService;

    @Autowired
    private RedisTestDataService redisTestDataService;

    @Autowired
    private DateValidator dateValidator;

    @PostMapping("/test")
    public String test(@RequestBody @Valid TestData testData, Errors errors) {
        if (errors.hasErrors() == true) {
            log.error("errors : " + errors.toString());

            JsonObject error = new JsonObject();

            error.addProperty("code", 404);

            return error.toString();
        }

        dateValidator.validate(testData, errors);

        if (errors.hasErrors() == true) {
            log.error("errors : " + errors.toString());

//            JsonObject error = new JsonObject();
//
//            error.addProperty(errors.toString(), 404);

            return errors.toString();
        }

        System.out.println("TestData : " + testData.toString());
        System.out.println("pw : " + testData.getPw());

        JsonObject result = new JsonObject();

        result.addProperty("test", testData.getValue());

        log.info(this.getClass().getPackage().getName() + " : " + mysqlTestDao.selectName());
        log.info("mysql : " + mysqlTestDao.selectName());
        log.info("oracle : " + oracleTestDao.selectName());

        log.info("test insert");
        log.info("insert success : " + mysqlTestDao.tranTestInsert());

        log.info("test insert error");
        log.info("insert success : " + mysqlTestDao.tranTestInsertError());

        redisTestService.test();
        redisTestDataService.test();

        log.info("test end");

        return result.toString();
    }
}