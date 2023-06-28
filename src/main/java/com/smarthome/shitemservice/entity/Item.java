package com.smarthome.shitemservice.entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item extends DateAudit {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    @Column(unique = true, updatable = false, nullable = false)
    private String sku;
    @JoinColumn(nullable = false)
    private Boolean isActive;

    @Column(updatable = false, nullable = false)
    private String ownerId;

    private String name;

    private String description;

    private String characteristics;

    private String imageUrl;

    private String instructionUrl;

    public Item() { super(); }

    public Item(String ownerId,
                String name,
                String description,
                String characteristics,
                String imageUrl,
                String instructionUrl) {
        this.ownerId = ownerId;
        this.name = name;
        this.description = description;
        this.characteristics = characteristics;
        this.imageUrl = imageUrl;
        this.instructionUrl = instructionUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isActive() {
        return isActive;
    }

    public void setActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructionUrl() {
        return instructionUrl;
    }

    public void setInstructionUrl(String instructionUrl) {
        this.instructionUrl = instructionUrl;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

}
