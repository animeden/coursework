package edu.holeiden.coursework.form;

import edu.holeiden.coursework.model.Brigade;

import java.time.LocalDateTime;

public class TrainForm {
    private String model;
    private String trainBrigade;
    private String recoveryBrigade;
    private String yearOfManufacture;
    private String numberOfPassengers;
    private String descriction;

    public TrainForm() {
    }

    public TrainForm(String model, String trainBrigade, String recoveryBrigade, String yearOfManufacture, String numberOfPassengers, String descriction) {
        this.model = model;
        this.trainBrigade = trainBrigade;
        this.recoveryBrigade = recoveryBrigade;
        this.yearOfManufacture = yearOfManufacture;
        this.numberOfPassengers = numberOfPassengers;
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

    public String getDescriction() {
        return descriction;
    }

    public void setDescriction(String descriction) {
        this.descriction = descriction;
    }

    public String getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(String yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(String numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public String toString() {
        return "TrainForm{" +
                "model='" + model + '\'' +
                ", trainBrigade='" + trainBrigade + '\'' +
                ", recoveryBrigade='" + recoveryBrigade + '\'' +
                ", yearOfManufacture='" + yearOfManufacture + '\'' +
                ", numberOfPassengers='" + numberOfPassengers + '\'' +
                ", descriction='" + descriction + '\'' +
                '}';
    }
}
