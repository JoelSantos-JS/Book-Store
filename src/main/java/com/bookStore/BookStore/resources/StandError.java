package com.bookStore.BookStore.resources;

public class StandError {

    private long timeStanps;
    private Integer status;
    private String errString;

    public StandError() {

    }

    public StandError(long timeStanps, Integer status, String errString) {
        this.timeStanps = timeStanps;
        this.status = status;
        this.errString = errString;
    }

    public long getTimeStanps() {
        return timeStanps;
    }

    public void setTimeStanps(long timeStanps) {
        this.timeStanps = timeStanps;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getErrString() {
        return errString;
    }

    public void setErrString(String errString) {
        this.errString = errString;
    }

}
