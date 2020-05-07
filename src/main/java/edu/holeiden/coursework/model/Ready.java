package edu.holeiden.coursework.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Document
public class Ready {
    @Id
    private String id;
    private Train trainID;
    private String review;
    private String clear;
    private String food;
    private LocalDateTime create;
    private LocalDateTime modified;
    private String descriction;

    public Ready() {
    }

    public Ready(String id, Train trainID, String review, String clear, String food, LocalDateTime create, LocalDateTime modified, String descriction) {
        this.id = id;
        this.trainID = trainID;
        this.review = review;
        this.clear = clear;
        this.food = food;
        this.create = create;
        this.modified = modified;
        this.descriction = descriction;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public Train getTrainID() { return trainID; }

    public void setTrainID(Train trainID) { this.trainID = trainID; }

    public String getReview() { return review; }

    public void setReview(String review) { this.review = review; }

    public String getClear() { return clear; }

    public void setClear(String clear) { this.clear = clear; }

    public String getFood() { return food; }

    public void setFood(String food) { this.food = food; }

    public LocalDateTime getCreate() { return create; }

    public void setCreate(LocalDateTime create) { this.create = create; }

    public LocalDateTime getModified() { return modified; }

    public void setModified(LocalDateTime modified) { this.modified = modified; }

    public String getDescriction() { return descriction; }

    public void setDescriction(String descriction) { this.descriction = descriction; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ready ready = (Ready) o;
        return getId().equals(ready.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Ready{" +
                "readyID='" + id + '\'' +
                ", trainID=" + trainID +
                ", review=" + review +
                ", clear=" + clear +
                ", food=" + food +
                ", create=" + create +
                ", modified=" + modified +
                ", descriction='" + descriction + '\'' +
                '}';
    }
}

