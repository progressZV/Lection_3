package com.senla.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileStreamReader {
    private final String path;

    public FileStreamReader(String path) {
        this.path = path;
    }

    public String readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String str;
            StringBuilder fileData = new StringBuilder();
            br.readLine(); // читаем со 2 строки
            while ((str = br.readLine()) != null)
                fileData.append(str).append("\n");
            return fileData.toString();
        } catch (IOException ex){
            return ex.getMessage();
        }
    }
}
