package kr.co.parkham.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
public class SampleResult {
	private String resultCode;
	private String resultMsg;
}
