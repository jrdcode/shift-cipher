package com.shift.cipher.shiftcipher.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CipherResponse {

    @JsonProperty(value = "EncodedMessage")
    private String encodedMessage;

    public String getEncodedMessage() {
        return encodedMessage;
    }

    public void setEncodedMessage(String encodedMessage) {
        this.encodedMessage = encodedMessage;
    }
}
