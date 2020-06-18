package edu.holeiden.coursework.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

public class Ftrains {
    @Id
    private String id;
    private String model;
    private Brigade trainBrigade;
    private Brigade recoveryBrigade;
    private String yearOfManufacture;
    private String loadCapasity;
    private LocalDateTime create;
    private LocalDateTime modified;
    private String descriction;

    public Ftrains() {
    }

    public Ftrains(String id, String model, Brigade trainBrigade, Brigade recoveryBrigade, String yearOfManufacture, String loadCapasity, LocalDateTime create, LocalDateTime modified, String descriction) {
        this.id = id;
        this.model = model;
        this.trainBrigade = trainBrigade;
        this.recoveryBrigade = recoveryBrigade;
        this.yearOfManufacture = yearOfManufacture;
        this.loadCapasity = loadCapasity;
        this.create = create;
        this.modified = modified;
        this.descriction = descriction;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Brigade getTrainBrigade() {
        return trainBrigade;
    }

    public void setTrainBrigade(Brigade trainBrigade) {
        this.trainBrigade = trainBrigade;
    }

    public Brigade getRecoveryBrigade() {
        return recoveryBrigade;
    }

    public void setRecoveryBrigade(Brigade recoveryBrigade) {
        this.recoveryBrigade = recoveryBrigade;
    }

    public String getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(String yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getLoadCapasity() {
        return loadCapasity;
    }

    public void setLoadCapasity(String loadCapasity) {
        this.loadCapasity = loadCapasity;
    }

    public LocalDateTime getCreate() {
        return create;
    }

    public void setCreate(LocalDateTime create) {
        this.create = create;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public String getDescriction() {
        return descriction;
    }

    public void setDescriction(String descriction) {
        this.descriction = descriction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ftrains ftrains = (Ftrains) o;
        return getId().equals(ftrains.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Ftrains{" +
                "id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", trainBrigade=" + trainBrigade +
                ", recoveryBrigade=" + recoveryBrigade +
                ", yearOfManufacture='" + yearOfManufacture + '\'' +
                ", loadCapasity='" + loadCapasity + '\'' +
                ", create=" + create +
                ", modified=" + modified +
                ", descriction='" + descriction + '\'' +
                '}';
    }
}


