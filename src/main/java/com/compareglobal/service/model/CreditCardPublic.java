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

    private List<Fee> fees;
    private List<Reward> rewards;
    private List<Benefit> benefits;
    private List<Promotion> promotions;
    private List<Criteria> criterias;
    private List<GeneralInfo> generalInfos;

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

    public List<Fee> getFees() { return fees; }

    public void setFees(List<Fee> fees) { this.fees = fees; }

    public List<Reward> getRewards() { return rewards;}

    public void setRewards(List<Reward> rewards) { this.rewards = rewards; }

    public List<Benefit> getBenefits() { return benefits; }

    public void setBenefits(List<Benefit> benefits) { this.benefits = benefits; }

    public List<Criteria> getCriterias() { return criterias; }

    public void setCriterias(List<Criteria> criterias) { this.criterias = criterias; }

    public List<Promotion> getPromotions() { return promotions; }

    public void setPromotions(List<Promotion> promotions) { this.promotions = promotions; }

    public List<GeneralInfo> getGeneralInfos() { return generalInfos; }

    public void setGeneralInfos(List<GeneralInfo> generalInfos) { this.generalInfos = generalInfos; }
}
