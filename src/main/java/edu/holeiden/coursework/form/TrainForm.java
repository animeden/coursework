package edu.holeiden.coursework.form;

import edu.holeiden.coursework.model.Brigade;

import java.time.LocalDateTime;

public class TrainForm {
    private String model;
    private String trainBrigade;
    private String recoveryBrigade;
    private String descriction;

    public TrainForm() {
    }

    public TrainForm(String model, String trainBrigade, String recoveryBrigade, String descriction) {
        this.model = model;
        this.trainBrigade = trainBrigade;
        this.recoveryBrigade = recoveryBrigade;
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

    @Override
    public String toString() {
        return "TrainForm{" +
                "model='" + model + '\'' +
                ", trainBrigade=" + trainBrigade +
                ", recoveryBrigade=" + recoveryBrigade +
                ", descriction='" + descriction + '\'' +
                '}';
    }
}
