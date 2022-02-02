package kr.co.parkham.vo;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class TestData {
    @Min(10)
    private int value;
    @NotBlank
    private String date;
    @NotEmpty @Email
    private String email;
    @NotNull
    private String pw;
}