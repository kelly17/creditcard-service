package com.compareglobal.service.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "fee")
public class Fee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull
    @DecimalMin("0.0")
    @DecimalMax("99999.99")
    @Digits(integer = 5, fraction = 2)
    private BigDecimal amount;

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
    @JoinColumn(name="creditcard_id",referencedColumnName="id")
    //@JsonManagedReference
    private CreditCard creditcard;
    public CreditCard getCreditCard() {
        return creditcard;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public String getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(String typeValue) {
        this.typeValue = typeValue;
    }

    public Integer getTypeKey() { return typeKey; }
}
