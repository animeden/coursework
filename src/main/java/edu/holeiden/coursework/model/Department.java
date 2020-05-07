package edu.holeiden.coursework.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Document
public class Department {
    @Id
    private String id;
    private String name;
    private String adress;
    private Administration administrationID;
    private Integer numberOfBrigates;
    private LocalDateTime create;
    private LocalDateTime modified;
    private String descriction;

    public Department() {
    }

    public Department(String id, String name, String adress, Administration administrationID, Integer numberOfBrigates, LocalDateTime create, LocalDateTime modified, String descriction) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.administrationID = administrationID;
        this.numberOfBrigates = numberOfBrigates;
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

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getAdress() { return adress; }

    public void setAdress(String adress) { this.adress = adress; }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Department{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", administrationID=" + administrationID +
                ", numberOfBrigates=" + numberOfBrigates +
                ", create=" + create +
                ", modified=" + modified +
                ", descriction='" + descriction + '\'' +
                '}';
    }
}
