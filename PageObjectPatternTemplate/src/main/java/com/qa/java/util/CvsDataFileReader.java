package com.qa.java.util;

import java.io.FileNotFoundException;
import java.io.*;
import java.io.IOException;

public class CvsDataFileReader {

    public static void main(String[] args) {

        final String fileName = "src/tests/resources/TestsDataFiles/registerData.csv";

        try {
            FileInputStream myFile = new FileInputStream(fileName);

            int myData;
            while ((myData = myFile.read()) != -1) {
                System.out.print((char)myData);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

