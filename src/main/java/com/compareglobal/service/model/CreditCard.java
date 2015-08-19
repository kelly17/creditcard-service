package com.compareglobal.service.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Table(name = "credit_card")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(min = 5,max = 6)
    private String locale;

    @NotNull
    @Size(min = 3,max = 100)
    private String name;

    private Boolean active;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "creditcard")
    private List<Fee> fees = new LinkedList<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "creditcard")
    private List<Reward> rewards = new LinkedList<>();

    @OneToMany(targetEntity=Benefit.class,fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "creditcard")
    private List<Benefit> benefits = new LinkedList<>();

    @OneToMany(targetEntity=Promotion.class,fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "creditcard")
    private List<Promotion> promotions = new LinkedList<>();

    @OneToMany(targetEntity=Criteria.class,fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "creditcard")
    private List<Criteria> criterias = new LinkedList<>();

    @OneToMany(targetEntity=GeneralInfo.class,fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "creditcard")
    private List<GeneralInfo> generalInfos = new LinkedList<>();

    public Long getId() { return id; }

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

    public List<Fee> getFees() { return fees; }

    public void setFees(List<Fee> fees) { this.fees = fees; }

    public Boolean getActive() { return active; }

    public void setActive(Boolean active) { this.active = active; }

    public List<Reward> getRewards() { return rewards; }

    public void setRewards(List<Reward> rewards) { this.rewards = rewards; }

    public List<Benefit> getBenefits() { return benefits; }

    public void setBenefits(List<Benefit> benefits) { this.benefits = benefits; }

    public List<Criteria> getCriterias() { return criterias;  }

    public void setCriterias(List<Criteria> criterias) { this.criterias = criterias; }

    public List<Promotion> getPromotions() { return promotions; }

    public void setPromotions(List<Promotion> promotions) { this.promotions = promotions; }

    public List<GeneralInfo> getGeneralInfos() { return generalInfos; }

    public void setGeneralInfos(List<GeneralInfo> generalInfos) { this.generalInfos = generalInfos; }
}
