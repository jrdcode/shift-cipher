package com.shift.cipher.shiftcipher.controller;

import com.shift.cipher.shiftcipher.exception.FileLoadingOrWritingException;
import com.shift.cipher.shiftcipher.model.Data;
import com.shift.cipher.shiftcipher.response.CipherResponse;
import com.shift.cipher.shiftcipher.service.ShiftCipherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShiftCipherController {

    @Autowired
    private ShiftCipherService shiftCipherService;

    @PostMapping(value = "/api/encode", consumes = "application/json")
    public ResponseEntity<CipherResponse> postDataToBeEncoded(@RequestBody Data data) {
        String encodedText = "";
        CipherResponse cipherResponse = new CipherResponse();
        try {
            encodedText = shiftCipherService.encode(data);
            cipherResponse.setEncodedMessage(encodedText);
        } catch (FileLoadingOrWritingException exception) {
            cipherResponse.setEncodedMessage(encodedText);
            return new ResponseEntity<>(cipherResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(cipherResponse);
    }
}
