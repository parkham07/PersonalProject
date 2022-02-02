package kr.co.parkham.validator;

import kr.co.parkham.vo.TestData;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class DateValidator {
    public void validate(TestData testData, Errors errors) {
        if(testData.getDate().equals("20200217") == false) {
            errors.rejectValue("date", "wrong value", "date is wrong");

            return;
        }
    }
}
