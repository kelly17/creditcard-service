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

    @OneToMany(targetEntity=Fee.class,fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "creditcard")
    //@JsonBackReference
    private List<Fee> fees = new LinkedList<>();

    public Long getId() {
        return id;
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

    public List<Fee> getFees() { return fees; }

    public void setFees(List<Fee> fees) { this.fees = fees; }

    public Boolean getActive() { return active; }

    public void setActive(Boolean active) { this.active = active; }

}
