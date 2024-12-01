package com.springboot.atstore.springboot_atstore.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "store_id")
    @JsonIgnore
    private Store store;
    @Column(name = "name")
    private String name;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "shipping_address")
    private String shippingAddress;
    @Column(name = "is_delivery")
    private Boolean idDelivery;
    @Embedded
    private Audit audit = new Audit();

    public Order() {
    }

    public Order(Long id, Store store, String name, LocalDate date, String shippingAddress, Boolean idDelivery) {
        this.id = id;
        this.store = store;
        this.name = name;
        this.date = date;
        this.shippingAddress = shippingAddress;
        this.idDelivery = idDelivery;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Boolean getIdDelivery() {
        return idDelivery;
    }

    public void setIdDelivery(Boolean idDelivery) {
        this.idDelivery = idDelivery;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    @Override
    public String toString() {
        return "Orders [id=" + id + ", store=" + store + ", name=" + name + ", date=" + date + ", shippingAddress="
                + shippingAddress + ", idDelivery=" + idDelivery + ", audit=" + audit + "]";
    }

}
