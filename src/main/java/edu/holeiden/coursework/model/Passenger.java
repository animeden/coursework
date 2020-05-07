package edu.holeiden.coursework.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Document
public class Passenger {
    @Id
    private String id;
    private String status;
    private Route routeID;
    private LocalDateTime create;
    private LocalDateTime modified;
    private String descriction;

    public Passenger() {
    }

    public Passenger(String id, String status, Route routeID, LocalDateTime create, LocalDateTime modified, String descriction) {
        this.id = id;
        this.status = status;
        this.routeID = routeID;
        this.create = create;
        this.modified = modified;
        this.descriction = descriction;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Route getRouteID() {
        return routeID;
    }

    public void setRouteID(Route routeID) {
        this.routeID = routeID;
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
        Passenger passenger = (Passenger) o;
        return getId().equals(passenger.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passengID='" + id + '\'' +
                ", status='" + status + '\'' +
                ", routeID=" + routeID +
                ", create=" + create +
                ", modified=" + modified +
                ", descriction='" + descriction + '\'' +
                '}';
    }
}
