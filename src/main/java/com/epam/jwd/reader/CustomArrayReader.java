package com.epam.jwd.reader;

import com.epam.jwd.exception.CustomArrayException;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class CustomArrayReader implements AutoCloseable {
    private Scanner scan;
    private FileReader reader;
    private String fileName;

    public CustomArrayReader() throws CustomArrayException {
        try {
            initFileName();
            reader = new FileReader(fileName);
            scan = new Scanner(reader);
        } catch (IOException e) {
            throw new CustomArrayException("Custom reader cant read file property or cant read the file");
        }
    }

    public String getNextLine(){
        return scan.hasNextLine() ? scan.nextLine() : null;
    }

    public boolean hasNextLine(){
        return scan.hasNextLine();
    }

    private void initFileName() throws IOException {
        FileInputStream fis = new FileInputStream("src\\main\\resources\\reader.properties");
        Properties property = new Properties();
        property.load(fis);
        fileName = property.getProperty("reader_path");
    }

    @Override
    public void close() throws Exception {
        reader.close();
    }
}
