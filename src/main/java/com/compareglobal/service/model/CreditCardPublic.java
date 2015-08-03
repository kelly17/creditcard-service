/*
 * Copyright (c) 2015.
 * Compare Asia Group
 */
package com.compareglobal.service.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CreditCardPublic {
    private Long id;
    private String locale;
    private String name;
    private String brand;

    private List<FeePublic> fees;
    //private JSONObject productInfo;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<FeePublic> getFees() {
        return fees;
    }

    public void setFees(List<FeePublic> fees) {
        this.fees = fees;
    }
}
