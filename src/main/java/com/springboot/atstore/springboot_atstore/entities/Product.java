package com.springboot.atstore.springboot_atstore.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = true) 
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Category category;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "stock")
    private Integer stock;
    @Column(name = "price")
    private Float price;
    @Column(name = "active")
    private Boolean active;
    @Embedded
    private Audit audit = new Audit();
    public Product() {
    }
    public Product(Long id, Category category, String name, String description, Integer stock, Float price,
            Boolean active) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.price = price;
        this.active = active;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
    public Audit getAudit() {
        return audit;
    }
    public void setAudit(Audit audit) {
        this.audit = audit;
    }
    @Override
    public String toString() {
        return "Product [id=" + id + ", category=" + category + ", name=" + name + ", description=" + description
                + ", stock=" + stock + ", price=" + price + ", active=" + active + ", audit=" + audit + "]";
    }

    
}
