package kr.co.parkham.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@Data
public class SampleData {
    private String name;
    private String pw;
}