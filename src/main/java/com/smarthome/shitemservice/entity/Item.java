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

    @JoinColumn(nullable = false)
    private Boolean isActive;

    private String description;

    @NaturalId
    @Column(unique = true, updatable = false, nullable = false)
    private String sku;

    private String imageUrl;

    private String name;
    private String instructionUrl;

    @Column(updatable = false, nullable = false)
    private String ownerId;
    private String characteristics;

    public Item() { super(); }

    public Item(String description, String sku, String imageUrl, String name, String instructionUrl, String ownerId, String characteristics) {
        this.description = description;
        this.sku = sku;
        this.imageUrl = imageUrl;
        this.name = name;
        this.instructionUrl = instructionUrl;
        this.ownerId = ownerId;
        this.characteristics = characteristics;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
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
