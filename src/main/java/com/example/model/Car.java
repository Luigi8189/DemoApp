package com.example.model;

import jakarta.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String modelName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CarType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CarColor color;

    private String description;

    // 🔽 Costruttori
    public Car() {}

    public Car(Long id, String modelName, CarType type, CarColor color, String description) {
        this.id = id;
        this.modelName = modelName;
        this.type = type;
        this.color = color;
        this.description = description;
    }

    // 🔽 Getter e Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    public CarColor getColor() {
        return color;
    }

    public void setColor(CarColor color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}