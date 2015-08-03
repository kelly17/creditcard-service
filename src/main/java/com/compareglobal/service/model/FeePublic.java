package com.compareglobal.service.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class FeePublic {

    protected String title;
    protected String type;
    protected String value;
    private final BigDecimal amount;
    private final String additionalInfo;
    protected String description;

    public FeePublic(Fee fee) {
        this.description = fee.getDescription();
        this.value = fee.getDescription();
        this.type = String.valueOf(fee.getTypeValue());
        this.amount = fee.getAmount();
        this.additionalInfo = fee.getAdditionalInfo();
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }
}
