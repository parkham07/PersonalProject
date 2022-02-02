package kr.co.parkham.dto.redis;

import lombok.Data;

import java.io.Serializable;

@Data
public class TestRedisData implements Serializable {
    private static final long serialVersionUID = -7353484588260422449L;

    private String id;
    private String value;
}