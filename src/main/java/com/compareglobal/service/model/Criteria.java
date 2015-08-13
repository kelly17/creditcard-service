package com.compareglobal.service.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "criteria")
public class Criteria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    public Long getId() {
        return id;
    }

    @NotNull
    @Min(0L)
    @Max(9999999L)
    @Column(name = "minimum")
    private Integer minimum;

    @NotNull
    @Min(0L)
    @Max(9999999L)
    @Column(name = "maximum")
    private Integer maximum;

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

    public String getDescription() {
        return description;
    }

    public Integer getMinimum() { return minimum; }

    public Integer getMaximum() {
        return maximum;
    }

    public Integer getTypeKey() { return typeKey; }

    public String getTypeValue() { return typeValue; }

    public String getAdditionalInfo() { return additionalInfo; }
}
