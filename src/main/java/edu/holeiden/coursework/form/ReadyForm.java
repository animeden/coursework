package edu.holeiden.coursework.form;

import edu.holeiden.coursework.model.Train;

import java.time.LocalDateTime;

public class ReadyForm {
    private String trainID;
    private String review;
    private String clear;
    private String food;
    private String descriction;

    public ReadyForm() {
    }

    public ReadyForm(String trainID, String review, String clear, String food, String descriction) {
        this.trainID = trainID;
        this.review = review;
        this.clear = clear;
        this.food = food;
        this.descriction = descriction;
    }

    public String getTrainID() {
        return trainID;
    }

    public void setTrainID(String trainID) {
        this.trainID = trainID;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getClear() {
        return clear;
    }

    public void setClear(String clear) {
        this.clear = clear;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getDescriction() {
        return descriction;
    }

    public void setDescriction(String descriction) {
        this.descriction = descriction;
    }

    @Override
    public String toString() {
        return "ReadyForm{" +
                "trainID=" + trainID +
                ", review='" + review + '\'' +
                ", clear='" + clear + '\'' +
                ", food='" + food + '\'' +
                ", descriction='" + descriction + '\'' +
                '}';
    }
}
