package edu.holeiden.coursework.form;

import edu.holeiden.coursework.model.Department;

import java.time.LocalDateTime;

public class BrigadeForm {
    private String number;
    private String mission;
    private String numberOfWorkers;
    private String departmentId;
    private String descriction;

    public BrigadeForm() {
    }

    public BrigadeForm(String number, String mission, String numberOfWorkers, String departmentId, String descriction) {
        this.number = number;
        this.mission = mission;
        this.numberOfWorkers = numberOfWorkers;
        this.departmentId = departmentId;
        this.descriction = descriction;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getNumberOfWorkers() {
        return numberOfWorkers;
    }

    public void setNumberOfWorkers(String numberOfWorkers) {
        this.numberOfWorkers = numberOfWorkers;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDescriction() {
        return descriction;
    }

    public void setDescriction(String descriction) {
        this.descriction = descriction;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "BrigadeForm{" +
                "number='" + number + '\'' +
                ", mission='" + mission + '\'' +
                ", numberOfWorkers='" + numberOfWorkers + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", descriction='" + descriction + '\'' +
                '}';
    }
}
