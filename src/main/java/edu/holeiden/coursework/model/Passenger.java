package edu.holeiden.coursework.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Document
public class Passenger {
    @Id
    private String id;
    private String ticketStatus;
    private Timetable timetableID;
    private String baggageStatus;
    private LocalDateTime create;
    private LocalDateTime modified;
    private String descriction;

    public Passenger() {
    }

    public Passenger(String id, String ticketStatus, Timetable timetableID, String baggageStatus, LocalDateTime create, LocalDateTime modified, String descriction) {
        this.id = id;
        this.ticketStatus = ticketStatus;
        this.timetableID = timetableID;
        this.baggageStatus = baggageStatus;
        this.create = create;
        this.modified = modified;
        this.descriction = descriction;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public Timetable getTimetableID() {
        return timetableID;
    }

    public void setTimetableID(Timetable timetableID) {
        this.timetableID = timetableID;
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

    public String getBaggageStatus() {
        return baggageStatus;
    }

    public void setBaggageStatus(String baggageStatus) {
        this.baggageStatus = baggageStatus;
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
                "id='" + id + '\'' +
                ", ticketStatus='" + ticketStatus + '\'' +
                ", timetableID=" + timetableID +
                ", baggageStatus='" + baggageStatus + '\'' +
                ", create=" + create +
                ", modified=" + modified +
                ", descriction='" + descriction + '\'' +
                '}';
    }
}
