package edu.holeiden.coursework.form;

import edu.holeiden.coursework.model.Route;

import java.time.LocalDateTime;

public class PassengerForm {
    private String status;
    private String routeID;
    private String descriction;

    public PassengerForm() {
    }

    public PassengerForm(String status, String routeID, String descriction) {
        this.status = status;
        this.routeID = routeID;
        this.descriction = descriction;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRouteID() {
        return routeID;
    }

    public void setRouteID(String routeID) {
        this.routeID = routeID;
    }

    public String getDescriction() {
        return descriction;
    }

    public void setDescriction(String descriction) {
        this.descriction = descriction;
    }

    @Override
    public String toString() {
        return "PassengerForm{" +
                "status='" + status + '\'' +
                ", routeID=" + routeID +
                ", descriction='" + descriction + '\'' +
                '}';
    }
}
