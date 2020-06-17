package edu.holeiden.coursework.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Document
public class Timetable {
    @Id
    private String id;
    private String timeOfGoing;
    private String timeOfCome;
    private Route numberOfRoute;
    private String ticketPrice;
    private Ready readyID;
    private String numberOfPassager;
    private String freeSpace;
    private LocalDateTime create;
    private LocalDateTime modified;
    private String descriction;

    public Timetable() {
    }

    public Timetable(String id, String timeOfGoing, String timeOfCome, Route numberOfRoute, String ticketPrice, Ready readyID, String numberOfPassager, String freeSpace, LocalDateTime create, LocalDateTime modified, String descriction) {
        this.id = id;
        this.timeOfGoing = timeOfGoing;
        this.timeOfCome = timeOfCome;
        this.numberOfRoute = numberOfRoute;
        this.ticketPrice = ticketPrice;
        this.readyID = readyID;
        this.numberOfPassager = numberOfPassager;
        this.freeSpace = freeSpace;
        this.create = create;
        this.modified = modified;
        this.descriction = descriction;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getTimeOfGoing() {
        return timeOfGoing;
    }

    public void setTimeOfGoing(String timeOfGoing) {
        this.timeOfGoing = timeOfGoing;
    }

    public String getTimeOfCome() { return timeOfCome; }

    public void setTimeOfCome(String timeOfCome) {
        this.timeOfCome = timeOfCome;
    }

    public Route getNumberOfRoute() {
        return numberOfRoute;
    }

    public void setNumberOfRoute(Route numberOfRoute) {
        this.numberOfRoute = numberOfRoute;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Ready getReadyID() {
        return readyID;
    }

    public void setReadyID(Ready readyID) {
        this.readyID = readyID;
    }

    public String getNumberOfPassager() {
        return numberOfPassager;
    }

    public void setNumberOfPassager(String numberOfPassager) {
        this.numberOfPassager = numberOfPassager;
    }

    public String getFreeSpace() { return freeSpace; }

    public void setFreeSpace(String freeSpace) { this.freeSpace = freeSpace; }

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
        Timetable timetable = (Timetable) o;
        return getId().equals(timetable.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Timetable{" +
                "timeID='" + id + '\'' +
                ", timeOfGoing='" + timeOfGoing + '\'' +
                ", timeOfCome='" + timeOfCome + '\'' +
                ", numberOfRoute=" + numberOfRoute +
                ", ticketPrice=" + ticketPrice +
                ", readyID=" + readyID +
                ", numberOfPassager=" + numberOfPassager +
                ", freeSpace=" + freeSpace +
                ", create=" + create +
                ", modified=" + modified +
                ", descriction='" + descriction + '\'' +
                '}';
    }
}
