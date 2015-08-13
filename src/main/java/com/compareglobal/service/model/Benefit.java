package com.compareglobal.service.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "benefit")
public class Benefit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Size(max = 1000)
    private String description;

    @Size(max = 1000)
    @Column(name = "additional_info")
    private String additionalInfo;
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

    public String getDescription() {
        return description;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public Integer getTypeKey() {
        return typeKey;
    }

    public String getTypeValue() {
        return typeValue;
    }
}
