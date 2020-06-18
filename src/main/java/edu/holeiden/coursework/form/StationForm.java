package edu.holeiden.coursework.form;

import java.time.LocalDateTime;

public class StationForm {
    private String name;
    private String place;
    private String descriction;

    public StationForm() {
    }

    public StationForm(String name, String place, String descriction) {
        this.name = name;
        this.place = place;
        this.descriction = descriction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDescriction() {
        return descriction;
    }

    public void setDescriction(String descriction) {
        this.descriction = descriction;
    }

    @Override
    public String toString() {
        return "StationForm{" +
                "name='" + name + '\'' +
                ", place='" + place + '\'' +
                ", descriction='" + descriction + '\'' +
                '}';
    }
}
