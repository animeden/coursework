package edu.holeiden.coursework.form;

import edu.holeiden.coursework.model.Brigade;

import java.time.LocalDateTime;

public class WorkerForm {
    private String fullName;
    private String phone;
    private String adress;
    private String birth;
    private String subclass;
    private String brigateID;
    private String descriction;

    public WorkerForm() {
    }

    public WorkerForm(String fullName, String phone, String adress, String birth, String subclass, String brigateID, String descriction) {
        this.fullName = fullName;
        this.phone = phone;
        this.adress = adress;
        this.birth = birth;
        this.subclass = subclass;
        this.brigateID = brigateID;
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

    public String getSubclass() {
        return subclass;
    }

    public void setSubclass(String subclass) {
        this.subclass = subclass;
    }

    public String getBrigateID() {
        return brigateID;
    }

    public void setBrigateID(String brigateID) {
        this.brigateID = brigateID;
    }

    public String getDescriction() {
        return descriction;
    }

    public void setDescriction(String descriction) {
        this.descriction = descriction;
    }

    @Override
    public String toString() {
        return "WorkerForm{" +
                "fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", adress='" + adress + '\'' +
                ", birth='" + birth + '\'' +
                ", subclass='" + subclass + '\'' +
                ", brigateID=" + brigateID +
                ", descriction='" + descriction + '\'' +
                '}';
    }
}
