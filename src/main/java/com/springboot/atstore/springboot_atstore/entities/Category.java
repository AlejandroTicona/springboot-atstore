package com.springboot.atstore.springboot_atstore.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Embedded
    private Audit audit = new Audit();
    public Category() {
    }
    public Category(Long id, String description, Audit audit) {
        this.id = id;
        this.description = description;
        this.audit = audit;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Audit getAudit() {
        return audit;
    }
    public void setAudit(Audit audit) {
        this.audit = audit;
    }
    @Override
    public String toString() {
        return "Category [id=" + id + ", description=" + description + ", audit=" + audit + "]";
    }

    
}
