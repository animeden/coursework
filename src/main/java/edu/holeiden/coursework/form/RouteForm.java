package edu.holeiden.coursework.form;

import java.time.LocalDateTime;

public class RouteForm {
    private String start;
    private String end;
    private String stations;
    private String typeOfRoute;
    private String descriction;

    public RouteForm() {
    }

    public RouteForm(String start, String end, String stations, String typeOfRoute, String descriction) {
        this.start = start;
        this.end = end;
        this.stations = stations;
        this.typeOfRoute = typeOfRoute;
        this.descriction = descriction;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getStations() {
        return stations;
    }

    public void setStations(String stations) {
        this.stations = stations;
    }

    public String getTypeOfRoute() {
        return typeOfRoute;
    }

    public void setTypeOfRoute(String typeOfRoute) {
        this.typeOfRoute = typeOfRoute;
    }

    public String getDescriction() {
        return descriction;
    }

    public void setDescriction(String descriction) {
        this.descriction = descriction;
    }

    @Override
    public String toString() {
        return "RouteForm{" +
                "start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", stations='" + stations + '\'' +
                ", typeOfRoute='" + typeOfRoute + '\'' +
                ", descriction='" + descriction + '\'' +
                '}';
    }
}
