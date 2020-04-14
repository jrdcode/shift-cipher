package com.shift.cipher.shiftcipher.service;

import com.shift.cipher.shiftcipher.exception.FileLoadingOrWritingException;
import com.shift.cipher.shiftcipher.model.Data;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class ShiftCipherService {

    public String encode(Data data) throws FileLoadingOrWritingException {
        System.out.println("Starting the encoding for the data using shift cipher approach");
        String plaintext = data.getMessage();
        int shift = data.getShift();
        String cipherText = "";
        char alphabet;
        for (int i = 0; i < plaintext.length(); i++) {
            // Shift one character at a time
            alphabet = plaintext.charAt(i);
            // if alphabet lies between a and z
            if (alphabet >= 'a' && alphabet <= 'z') {
                // shift alphabet
                alphabet = (char) (alphabet + shift);
                // if shift alphabet greater than 'z'
                if (alphabet > 'z') {
                    // reshift to starting position
                    alphabet = (char) (alphabet + 'a' - 'z' - 1);
                }
                cipherText = cipherText + alphabet;
            }
            // if alphabet lies between 'A'and 'Z'
            else if (alphabet >= 'A' && alphabet <= 'Z') {
                // shift alphabet
                alphabet = (char) (alphabet + shift);
                // if shift alphabet greater than 'Z'
                if (alphabet > 'Z') {
                    //reshift to starting position
                    alphabet = (char) (alphabet + 'A' - 'Z' - 1);
                }
                cipherText = cipherText + alphabet;
            } else {
                cipherText = cipherText + alphabet;
            }
        }
        System.out.println("CipherText :" + cipherText);
        writeTheEncodedDataToFile(cipherText);
        return cipherText;
    }

    private void writeTheEncodedDataToFile(String cipherText) throws FileLoadingOrWritingException {
        try {
            File file = new File("EncodedData.txt");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
            FileWriter fileWriter = new FileWriter("EncodedData.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(cipherText+ System.getProperty("line.separator"));
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred while creating and writing a file.");
            throw new FileLoadingOrWritingException();
        }
    }
}
