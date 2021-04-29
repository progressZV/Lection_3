package com.senla.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileStreamWriter {

    private final String path;
    public FileStreamWriter(String path){
        this.path = path;
    }

    private  boolean checkFile(final String path){
        final File file = new File(path);
        return file.exists();
    }

    public void write(String str, boolean append){

        boolean flag = checkFile(path);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, append))) {
            if (flag) {
                bw.write(str);
            }
        }
            catch(IOException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }
