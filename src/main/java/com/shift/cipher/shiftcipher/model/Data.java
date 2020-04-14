package com.shift.cipher.shiftcipher.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {

    @JsonProperty(value = "Shift")
    private int shift;

    @JsonProperty(value = "Message")
    private String message;

    public int getShift() {
        return shift;
    }

    public String getMessage() {
        return message;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
