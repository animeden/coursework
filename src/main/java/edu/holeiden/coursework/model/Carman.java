package edu.holeiden.coursework.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.Objects;

public class Carman {
    @Id
    private String id;
    private String fullName;
    private String phone;
    private String adress;
    private String birth;
    private Brigade brigateID;
    private String driveExperience;
    private String typeOfTrains;
    private LocalDateTime create;
    private LocalDateTime modified;
    private String descriction;

    public Carman() {
    }

    public Carman(String id, String fullName, String phone, String adress, String birth, Brigade brigateID, String driveExperience, String typeOfTrains, LocalDateTime create, LocalDateTime modified, String descriction) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.adress = adress;
        this.birth = birth;
        this.brigateID = brigateID;
        this.driveExperience = driveExperience;
        this.typeOfTrains = typeOfTrains;
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

    public Brigade getBrigateID() {
        return brigateID;
    }

    public void setBrigateID(Brigade brigateID) {
        this.brigateID = brigateID;
    }

    public String getDriveExperience() {
        return driveExperience;
    }

    public void setDriveExperience(String driveExperience) {
        this.driveExperience = driveExperience;
    }

    public String getTypeOfTrains() {
        return typeOfTrains;
    }

    public void setTypeOfTrains(String typeOfTrains) {
        this.typeOfTrains = typeOfTrains;
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
        Carman carman = (Carman) o;
        return getId().equals(carman.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "CarmanForm{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", adress='" + adress + '\'' +
                ", birth='" + birth + '\'' +
                ", brigateID=" + brigateID +
                ", driveExperience='" + driveExperience + '\'' +
                ", typeOfTrains='" + typeOfTrains + '\'' +
                ", create=" + create +
                ", modified=" + modified +
                ", descriction='" + descriction + '\'' +
                '}';
    }
}
