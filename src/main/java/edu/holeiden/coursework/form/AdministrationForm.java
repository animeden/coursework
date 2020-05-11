package edu.holeiden.coursework.form;

public class AdministrationForm {
    private String name;
    private String birth;
    private String phoneNumber;
    private String adress;
    private String descriction;

    public AdministrationForm() {
    }

    public AdministrationForm(String name, String birth, String phoneNumber, String adress, String descriction) {
        this.name = name;
        this.birth = birth;
        this.phoneNumber = phoneNumber;
        this.adress = adress;
        this.descriction = descriction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getDescriction() {
        return descriction;
    }

    public void setDescriction(String descriction) {
        this.descriction = descriction;
    }

    @Override
    public String toString() {
        return "AdministrationForm{" +
                "name='" + name + '\'' +
                ", birth='" + birth + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", adress='" + adress + '\'' +
                ", descriction='" + descriction + '\'' +
                '}';
    }
}
