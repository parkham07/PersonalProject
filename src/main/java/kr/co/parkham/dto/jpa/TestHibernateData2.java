package kr.co.parkham.dto.jpa;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "TB_ISP_AUTH")
public class TestHibernateData2 {
    @Id
    @Column(name = "TID")
    private String tid;

    @Column(name = "MID")
    private String mid;

    @Column(name = "KVP_PGID")
    private String kvpPgid;

    @Column(name = "KVP_GOODNAME")
    private String kvpGoodname;

    @Column(name = "KVP_PRICE")
    private int kvpPrice;

    @Column(name = "KVP_CURRENCY")
    private String kvpCurrency;

    @Column(name = "KVP_NOINT_INF")
    private String kvpNointInf;

    @Column(name = "KVP_QUOTA_INF")
    private String kvpQuotaInf;

    @Column(name = "KVP_NOINT")
    private String kvpNoint;

    @Column(name = "KVP_QUOTA")
    private String kvpQuota;

    @Column(name = "KVP_CARDCODE")
    private String kvpCardcode;

    @Column(name = "KVP_CONAME")
    private String kvpConame;

    @Column(name = "SESSION_KEY")
    private String sessionKey;

    @Column(name = "ENC_DATA")
    private String encData;
}