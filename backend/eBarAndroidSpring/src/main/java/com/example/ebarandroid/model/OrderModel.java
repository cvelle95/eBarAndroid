package com.example.ebarandroid.model;

import lombok.Data;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "order")
@Data

public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer id;

    @Column(name = "ukupno")
    private Float ukupno;

    @Column(name = "table_id")
    private Integer table_id;

    @Column(name = "status")
    private String status;

    @OneToMany(cascade=CascadeType.ALL,mappedBy = "order_id",fetch=FetchType.EAGER)
    private List<StavkaModel> stavkePorudzbine;

    public OrderModel(Float ukupno,Integer table_id,String status){
        this.setStatus(status);
        this.setUkupno(ukupno);
        this.setTable_id(table_id);
    }

    public OrderModel() {

    }
}
