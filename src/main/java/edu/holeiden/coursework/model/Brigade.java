package edu.holeiden.coursework.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Document
public class Brigade {
    @Id
    private String id;
    private String number;
    private String mission;
    private String numberOfWorkers;
    private Department departmentId;
    private LocalDateTime create;
    private LocalDateTime modified;
    private String descriction;

    public Brigade() {
    }

    public Brigade(String id, String number, String mission, String numberOfWorkers, Department departmentId, LocalDateTime create, LocalDateTime modified, String descriction) {
        this.id = id;
        this.number = number;
        this.mission = mission;
        this.numberOfWorkers = numberOfWorkers;
        this.departmentId = departmentId;
        this.create = create;
        this.modified = modified;
        this.descriction = descriction;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Department getDepartmentId() { return departmentId; }

    public void setDepartmentId(Department departmentId) { this.departmentId = departmentId; }

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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brigade brigade = (Brigade) o;
        return getId().equals(brigade.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Brigade{" +
                "id='" + id + '\'' +
                ", number='" + number + '\'' +
                ", mission='" + mission + '\'' +
                ", numberOfWorkers='" + numberOfWorkers + '\'' +
                ", departmentId=" + departmentId +
                ", create=" + create +
                ", modified=" + modified +
                ", descriction='" + descriction + '\'' +
                '}';
    }
}
