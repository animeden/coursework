package edu.holeiden.coursework.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Document
public class Train {
    @Id
    private String id;
    private String model;
    private Brigade trainBrigade;
    private Brigade recoveryBrigade;
    private LocalDateTime create;
    private LocalDateTime modified;
    private String descriction;

    public Train() {
    }

    public Train(String id, String model, Brigade trainBrigade, Brigade recoveryBrigade, LocalDateTime create, LocalDateTime modified, String descriction) {
        this.id = id;
        this.model = model;
        this.trainBrigade = trainBrigade;
        this.recoveryBrigade = recoveryBrigade;
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
        Train train = (Train) o;
        return getId().equals(train.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", brigadeID=" + trainBrigade +
                ", recoveryBrigade=" + recoveryBrigade +
                ", create='" + create + '\'' +
                ", modified='" + modified + '\'' +
                ", descriction='" + descriction + '\'' +
                '}';
    }
}
