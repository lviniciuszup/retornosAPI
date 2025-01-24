package com.example.retornosAPI.models;

import jakarta.persistence.*;

@Entity
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private String description;
    private Integer quantity;
    @Enumerated(EnumType.STRING)
    private Categories categories;

    public ProductEntity(Long id, String name, Double price, String description, Integer quantity, Categories categories) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.categories = categories;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDescription(String description) { this.description = description; }

    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public void setCategories(Categories categories){this.categories = categories;}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescription() { return description; }

    public Integer getQuantity() { return quantity; }

    public Categories getCategories(){return categories;}

}