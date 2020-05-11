package edu.holeiden.coursework.form;

import edu.holeiden.coursework.model.Department;

import java.time.LocalDateTime;

public class BrigadeForm {
    private String mission;
    private Integer numberOfWorkers;
    private Department departmentId;
    private String descriction;

    public BrigadeForm() {
    }

    public BrigadeForm(String mission, Integer numberOfWorkers, Department departmentId, String descriction) {
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

    public Integer getNumberOfWorkers() {
        return numberOfWorkers;
    }

    public void setNumberOfWorkers(Integer numberOfWorkers) {
        this.numberOfWorkers = numberOfWorkers;
    }

    public Department getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Department departmentId) {
        this.departmentId = departmentId;
    }

    public String getDescriction() {
        return descriction;
    }

    public void setDescriction(String descriction) {
        this.descriction = descriction;
    }

    @Override
    public String toString() {
        return "BrigadeForm{" +
                "mission='" + mission + '\'' +
                ", numberOfWorkers=" + numberOfWorkers +
                ", departmentId=" + departmentId +
                ", descriction='" + descriction + '\'' +
                '}';
    }
}
