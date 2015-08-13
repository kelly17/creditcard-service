package com.compareglobal.service.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "promotion")
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;

    @Size(max = 1000)
    @Column(name = "description")
    private String description;

    @Column(name = "type_key")
    private Integer typeKey;

    @Column(name = "type_value")
    private String typeValue;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="creditcard_id")
    private CreditCard creditcard;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTypeValue() {
        return typeValue;
    }

    public Integer getTypeKey() {
        return typeKey;
    }
}
