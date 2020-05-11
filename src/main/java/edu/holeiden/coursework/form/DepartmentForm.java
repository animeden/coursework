package edu.holeiden.coursework.form;

import edu.holeiden.coursework.model.Administration;

import java.time.LocalDateTime;

public class DepartmentForm {
    private String name;
    private String adress;
    private Administration administrationID;
    private Integer numberOfBrigates;
    private String descriction;

    public DepartmentForm() {
    }

    public DepartmentForm(String name, String adress, Administration administrationID, Integer numberOfBrigates, String descriction) {
        this.name = name;
        this.adress = adress;
        this.administrationID = administrationID;
        this.numberOfBrigates = numberOfBrigates;
        this.descriction = descriction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Administration getAdministrationID() {
        return administrationID;
    }

    public void setAdministrationID(Administration administrationID) {
        this.administrationID = administrationID;
    }

    public Integer getNumberOfBrigates() {
        return numberOfBrigates;
    }

    public void setNumberOfBrigates(Integer numberOfBrigates) {
        this.numberOfBrigates = numberOfBrigates;
    }

    public String getDescriction() {
        return descriction;
    }

    public void setDescriction(String descriction) {
        this.descriction = descriction;
    }

    @Override
    public String toString() {
        return "DepartmentForm{" +
                "name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", administrationID=" + administrationID +
                ", numberOfBrigates=" + numberOfBrigates +
                ", descriction='" + descriction + '\'' +
                '}';
    }
}
