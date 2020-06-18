package edu.holeiden.coursework.form;

import edu.holeiden.coursework.model.Ready;
import edu.holeiden.coursework.model.Route;

import java.time.LocalDateTime;

public class TimetableForm {
    private String timeOfGoing;
    private String dateOfGoing;
    private String timeOfCome;
    private String dateOfCome;
    private String numberOfRoute;
    private String ticketPrice;
    private String numberOfPassager;
    private String descriction;

    public TimetableForm() {
    }

    public TimetableForm(String timeOfGoing, String dateOfGoing, String timeOfCome, String dateOfCome, String numberOfRoute, String ticketPrice, String numberOfPassager, String descriction) {
        this.timeOfGoing = timeOfGoing;
        this.dateOfGoing = dateOfGoing;
        this.timeOfCome = timeOfCome;
        this.dateOfCome = dateOfCome;
        this.numberOfRoute = numberOfRoute;
        this.ticketPrice = ticketPrice;
        this.numberOfPassager = numberOfPassager;
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

    public String getNumberOfPassager() {
        return numberOfPassager;
    }

    public void setNumberOfPassager(String numberOfPassager) {
        this.numberOfPassager = numberOfPassager;
    }

    public String getDescriction() {
        return descriction;
    }

    public void setDescriction(String descriction) {
        this.descriction = descriction;
    }

    public String getDateOfGoing() {
        return dateOfGoing;
    }

    public void setDateOfGoing(String dateOfGoing) {
        this.dateOfGoing = dateOfGoing;
    }

    public String getDateOfCome() {
        return dateOfCome;
    }

    public void setDateOfCome(String dateOfCome) {
        this.dateOfCome = dateOfCome;
    }

    @Override
    public String toString() {
        return "TimetableForm{" +
                "timeOfGoing='" + timeOfGoing + '\'' +
                ", dateOfGoing='" + dateOfGoing + '\'' +
                ", timeOfCome='" + timeOfCome + '\'' +
                ", dateOfCome='" + dateOfCome + '\'' +
                ", numberOfRoute='" + numberOfRoute + '\'' +
                ", ticketPrice='" + ticketPrice + '\'' +
                ", numberOfPassager='" + numberOfPassager + '\'' +
                ", descriction='" + descriction + '\'' +
                '}';
    }
}
