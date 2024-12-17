package com.example.productmanager.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String imagePath;


    public void setName(String name) {
        this.name = name;
    }
    public  String getName(){
        return name;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    public  String getImagePath(){
        return imagePath;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription(){
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
