package com.springboot.atstore.springboot_atstore.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "stores")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "address", length = 150)
    private String address;
    @Column(name = "city", length = 150)
    private String city;
    @Column(name = "opening_hours", length = 50)
    private String openingHours;
    @Embedded
    private Audit audit = new Audit();

    public Store() {
    }

    public Store(String name, String address, String city, String openingHours) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.openingHours = openingHours;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    @Override
    public String toString() {
        return "Store [id=" + id + ", name=" + name + ", address=" + address + ", city=" + city + ", openingHours="
                + openingHours + ", audit=" + audit + "]";
    }

}
