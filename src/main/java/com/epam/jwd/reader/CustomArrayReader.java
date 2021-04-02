package com.epam.jwd.reader;

import com.epam.jwd.exception.CustomArrayException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CustomArrayReader implements AutoCloseable {
    private Scanner scan;
    private FileReader reader;

    public CustomArrayReader(String fileName) throws CustomArrayException {
        try {
            reader = new FileReader(fileName);
            scan = new Scanner(reader);
        } catch (IOException e) {
            throw new CustomArrayException("Custom reader cant read file property or cant read the file");
        }
    }

    public String getNextLine() {
        return scan.hasNextLine() ? scan.nextLine() : null;
    }

    public boolean hasNextLine() {
        return scan.hasNextLine();
    }

    @Override
    public void close() throws Exception {
        reader.close();
    }
}
