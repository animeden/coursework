package edu.holeiden.coursework.form;

import edu.holeiden.coursework.model.Brigade;

import java.time.LocalDateTime;

public class TrainForm {
    private String model;
    private Brigade trainBrigade;
    private Brigade recoveryBrigade;
    private String descriction;

    public TrainForm() {
    }

    public TrainForm(String model, Brigade trainBrigade, Brigade recoveryBrigade, String descriction) {
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

    public Brigade getTrainBrigade() {
        return trainBrigade;
    }

    public void setTrainBrigade(Brigade trainBrigade) {
        this.trainBrigade = trainBrigade;
    }

    public Brigade getRecoveryBrigade() {
        return recoveryBrigade;
    }

    public void setRecoveryBrigade(Brigade recoveryBrigade) {
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
