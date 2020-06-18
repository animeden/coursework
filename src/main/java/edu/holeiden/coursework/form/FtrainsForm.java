package edu.holeiden.coursework.form;

import edu.holeiden.coursework.model.Brigade;

import java.time.LocalDateTime;

public class FtrainsForm {
    private String model;
    private String trainBrigade;
    private String recoveryBrigade;
    private String yearOfManufacture;
    private String loadCapasity;
    private String descriction;

    public FtrainsForm() {
    }

    public FtrainsForm(String model, String trainBrigade, String recoveryBrigade, String yearOfManufacture, String loadCapasity, String descriction) {
        this.model = model;
        this.trainBrigade = trainBrigade;
        this.recoveryBrigade = recoveryBrigade;
        this.yearOfManufacture = yearOfManufacture;
        this.loadCapasity = loadCapasity;
        this.descriction = descriction;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTrainBrigade() {
        return trainBrigade;
    }

    public void setTrainBrigade(String trainBrigade) {
        this.trainBrigade = trainBrigade;
    }

    public String getRecoveryBrigade() {
        return recoveryBrigade;
    }

    public void setRecoveryBrigade(String recoveryBrigade) {
        this.recoveryBrigade = recoveryBrigade;
    }

    public String getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(String yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getLoadCapasity() {
        return loadCapasity;
    }

    public void setLoadCapasity(String loadCapasity) {
        this.loadCapasity = loadCapasity;
    }

    public String getDescriction() {
        return descriction;
    }

    public void setDescriction(String descriction) {
        this.descriction = descriction;
    }

    @Override
    public String toString() {
        return "FtrainsForm{" +
                "model='" + model + '\'' +
                ", trainBrigade=" + trainBrigade +
                ", recoveryBrigade=" + recoveryBrigade +
                ", yearOfManufacture='" + yearOfManufacture + '\'' +
                ", loadCapasity='" + loadCapasity + '\'' +
                ", descriction='" + descriction + '\'' +
                '}';
    }
}
