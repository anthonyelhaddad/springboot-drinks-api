package com.thebois.springbootdrinksapi.domain;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
public class Drink {
    @Id
    @SequenceGenerator(
            name = "drink_sequence",
            sequenceName = "drink_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "drink_sequence"
    )
    @Column(
            name = "id"
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false
    )
    private String name;

    @Column(
            name = "imageUrl",
            columnDefinition = "TEXT"
    )
    private String imageUrl;

    @Column(
            name = "videoUrl",
            columnDefinition = "TEXT"
    )
    private String videoUrl;

    @Column(
            name = "isAlcoholic",
            nullable = false
    )
    private boolean isAlcoholic;

    @Column(
            name = "instructions",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String instructions;

    public Drink() {

    }

    public Drink(String name, String imageUrl, String videoUrl, boolean isAlcoholic, String instructions) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.videoUrl = videoUrl;
        this.isAlcoholic = isAlcoholic;
        this.instructions = instructions;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public boolean isAlcoholic() {
        return isAlcoholic;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public void setAlcoholic(boolean alcoholic) {
        isAlcoholic = alcoholic;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", isAlcoholic=" + isAlcoholic +
                ", instructions='" + instructions + '\'' +
                '}';
    }
}