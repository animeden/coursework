package edu.holeiden.coursework.form;

import edu.holeiden.coursework.model.Brigade;

import java.time.LocalDateTime;

public class CarmanForm {
    private String fullName;
    private String phone;
    private String adress;
    private String birth;
    private String brigateID;
    private String driveExperience;
    private String typeOfTrains;
    private String descriction;

    public CarmanForm() {
    }

    public CarmanForm(String fullName, String phone, String adress, String birth, String brigateID, String driveExperience, String typeOfTrains, String descriction) {
        this.fullName = fullName;
        this.phone = phone;
        this.adress = adress;
        this.birth = birth;
        this.brigateID = brigateID;
        this.driveExperience = driveExperience;
        this.typeOfTrains = typeOfTrains;
        this.descriction = descriction;
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

    public String getBrigateID() {
        return brigateID;
    }

    public void setBrigateID(String brigateID) {
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

    public String getDescriction() {
        return descriction;
    }

    public void setDescriction(String descriction) {
        this.descriction = descriction;
    }

    @Override
    public String toString() {
        return "CarmanForm{" +
                "fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", adress='" + adress + '\'' +
                ", birth='" + birth + '\'' +
                ", brigateID='" + brigateID + '\'' +
                ", driveExperience='" + driveExperience + '\'' +
                ", typeOfTrains='" + typeOfTrains + '\'' +
                ", descriction='" + descriction + '\'' +
                '}';
    }
}