package kr.co.parkham.dto.jpa;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "DEFAULT_TABLE")
public class TestHibernateData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long seq;

    @Column
    private String data;
}