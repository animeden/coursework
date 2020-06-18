package edu.holeiden.coursework.form;

public class PassengerForm {
    private String status;
    private String timetableID;
    private String baggageStatus;
    private String descriction;

    public PassengerForm() {
    }

    public PassengerForm(String status, String timetableID, String baggageStatus, String descriction) {
        this.status = status;
        this.timetableID = timetableID;
        this.baggageStatus = baggageStatus;
        this.descriction = descriction;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimetableID() {
        return timetableID;
    }

    public void setTimetableID(String timetableID) {
        this.timetableID = timetableID;
    }

    public String getDescriction() {
        return descriction;
    }

    public void setDescriction(String descriction) {
        this.descriction = descriction;
    }

    public String getBaggageStatus() {
        return baggageStatus;
    }

    public void setBaggageStatus(String baggageStatus) {
        this.baggageStatus = baggageStatus;
    }

    @Override
    public String toString() {
        return "PassengerForm{" +
                "status='" + status + '\'' +
                ", timetableID='" + timetableID + '\'' +
                ", baggageStatus='" + baggageStatus + '\'' +
                ", descriction='" + descriction + '\'' +
                '}';
    }
}
