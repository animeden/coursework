package edu.holeiden.coursework.form;

import edu.holeiden.coursework.model.Ready;
import edu.holeiden.coursework.model.Route;

import java.time.LocalDateTime;

public class TimetableForm {
    private String timeOfGoing;
    private String timeOfCome;
    private String numberOfRoute;
    private String ticketPrice;
    private String readyID;
    private String numberOfPassager;
    private String freeSpace;
    private String descriction;

    public TimetableForm() {
    }

    public TimetableForm(String timeOfGoing, String timeOfCome, String numberOfRoute, String ticketPrice, String readyID, String numberOfPassager, String freeSpace, String descriction) {
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

    public String getNumberOfRoute() {
        return numberOfRoute;
    }

    public void setNumberOfRoute(String numberOfRoute) {
        this.numberOfRoute = numberOfRoute;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getReadyID() {
        return readyID;
    }

    public void setReadyID(String readyID) {
        this.readyID = readyID;
    }

    public String getNumberOfPassager() {
        return numberOfPassager;
    }

    public void setNumberOfPassager(String numberOfPassager) {
        this.numberOfPassager = numberOfPassager;
    }

    public String getFreeSpace() {
        return freeSpace;
    }

    public void setFreeSpace(String freeSpace) {
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
