package com.epam.jwd.validation;

import com.epam.jwd.exception.CustomArrayException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CustomArrayFileValidator {


    public boolean validate(String input) throws CustomArrayException {
        try {
            FileInputStream fis = new FileInputStream("src\\main\\resources\\reader.properties");
            Properties property = new Properties();
            property.load(fis);
            String regex = property.getProperty("validator_regex");
            return input.matches(regex);
        }catch (IOException e){
            throw new CustomArrayException("Cannot read properties from property file");
        }
    }
}
