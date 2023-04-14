package com.example.Layered.Architecture.entity;

import javax.persistence.*;

@Entity
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String street;
    private String nameShop;
    private int numberEmployees;
    private boolean hasWebsite;

    public Shop() {
    }

    public Shop(Long id, String city, String street, String nameShop, int numberEmployees, boolean hasWebsite) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.nameShop = nameShop;
        this.numberEmployees = numberEmployees;
        this.hasWebsite = hasWebsite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNameShop() {
        return nameShop;
    }

    public void setNameShop(String nameShop) {
        this.nameShop = nameShop;
    }

    public int getNumberEmployees() {
        return numberEmployees;
    }

    public void setNumberEmployees(int numberEmployees) {
        this.numberEmployees = numberEmployees;
    }

    public boolean isHasWebsite() {
        return hasWebsite;
    }

    public void setHasWebsite(boolean hasWebsite) {
        this.hasWebsite = hasWebsite;
    }
}
