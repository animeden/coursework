package edu.holeiden.coursework.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Document
public class Worker {
    @Id
    private String id;
    private String fullName;
    private String phone;
    private String adress;
    private String birth;
    private String subclass;
    private Brigade brigateID;
    private String experience;
    private LocalDateTime create;
    private LocalDateTime modified;
    private String descriction;

    public Worker() {
    }

    public Worker(String id, String fullName, String phone, String adress, String birth, String subclass, Brigade brigateID, String experience, LocalDateTime create, LocalDateTime modified, String descriction) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.adress = adress;
        this.birth = birth;
        this.subclass = subclass;
        this.brigateID = brigateID;
        this.experience = experience;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getSubclass() {
        return subclass;
    }

    public void setSubclass(String subclass) {
        this.subclass = subclass;
    }

    public Brigade getBrigateID() { return brigateID; }

    public void setBrigateID(Brigade brigateID) { this.brigateID = brigateID; }

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

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return getId().equals(worker.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", adress='" + adress + '\'' +
                ", birth='" + birth + '\'' +
                ", subclass='" + subclass + '\'' +
                ", brigateID=" + brigateID +
                ", experience='" + experience + '\'' +
                ", create=" + create +
                ", modified=" + modified +
                ", descriction='" + descriction + '\'' +
                '}';
    }
}