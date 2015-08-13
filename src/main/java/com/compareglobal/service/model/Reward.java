package com.compareglobal.service.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "reward")
public class Reward {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull
    @DecimalMin("0.0")
    @DecimalMax("99999.99")
    @Digits(integer = 5, fraction = 2)
    private BigDecimal value;

    @Size(max = 1000)
    @Column(name = "description")
    private String description;

    @Column(name = "type_value")
    private String typeValue;

    @Size(max = 1000)
    @Column(name = "additional_info")
    private String additionalInfo;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="creditcard_id")
    private CreditCard creditcard;

    public BigDecimal getValue() {
        return this.value;
    }

    public String getDescription() {
        return this.description;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(String typeValue) {
        this.typeValue = typeValue;
    }

    public String getAdditional_info() { return additionalInfo; }

    public void setAdditional_info(String additional_info) { this.additionalInfo = additional_info; }
}
