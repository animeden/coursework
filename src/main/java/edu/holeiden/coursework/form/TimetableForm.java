package edu.holeiden.coursework.form;

import edu.holeiden.coursework.model.Ready;
import edu.holeiden.coursework.model.Route;

import java.time.LocalDateTime;

public class TimetableForm {
    private String timeOfGoing;
    private String timeOfCome;
    private Route numberOfRoute;
    private Integer ticketPrice;
    private Ready readyID;
    private Integer numberOfPassager;
    private Integer freeSpace;
    private String descriction;

    public TimetableForm() {
    }

    public TimetableForm(String timeOfGoing, String timeOfCome, Route numberOfRoute, Integer ticketPrice, Ready readyID, Integer numberOfPassager, Integer freeSpace, String descriction) {
        this.timeOfGoing = timeOfGoing;
        this.timeOfCome = timeOfCome;
        this.numberOfRoute = numberOfRoute;
        this.ticketPrice = ticketPrice;
        this.readyID = readyID;
        this.numberOfPassager = numberOfPassager;
        this.freeSpace = freeSpace;
        this.descriction = descriction;
    }

    public String getTimeOfGoing() {
        return timeOfGoing;
    }

    public void setTimeOfGoing(String timeOfGoing) {
        this.timeOfGoing = timeOfGoing;
    }

    public String getTimeOfCome() {
        return timeOfCome;
    }

    public void setTimeOfCome(String timeOfCome) {
        this.timeOfCome = timeOfCome;
    }

    public Route getNumberOfRoute() {
        return numberOfRoute;
    }

    public void setNumberOfRoute(Route numberOfRoute) {
        this.numberOfRoute = numberOfRoute;
    }

    public Integer getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Integer ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Ready getReadyID() {
        return readyID;
    }

    public void setReadyID(Ready readyID) {
        this.readyID = readyID;
    }

    public Integer getNumberOfPassager() {
        return numberOfPassager;
    }

    public void setNumberOfPassager(Integer numberOfPassager) {
        this.numberOfPassager = numberOfPassager;
    }

    public Integer getFreeSpace() {
        return freeSpace;
    }

    public void setFreeSpace(Integer freeSpace) {
        this.freeSpace = freeSpace;
    }

    public String getDescriction() {
        return descriction;
    }

    public void setDescriction(String descriction) {
        this.descriction = descriction;
    }

    @Override
    public String toString() {
        return "TimetableForm{" +
                "timeOfGoing='" + timeOfGoing + '\'' +
                ", timeOfCome='" + timeOfCome + '\'' +
                ", numberOfRoute=" + numberOfRoute +
                ", ticketPrice=" + ticketPrice +
                ", readyID=" + readyID +
                ", numberOfPassager=" + numberOfPassager +
                ", freeSpace=" + freeSpace +
                ", descriction='" + descriction + '\'' +
                '}';
    }
}
