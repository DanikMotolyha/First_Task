package com.epam.jwd.validation;

//(-{0,1}\\d{0,10} *)+
public class CustomArrayStringValidator {
    static String validateDigits = "(-?\\d{0,10} *)+";

    public boolean validate(String input){
            return input.matches(validateDigits);
    }
}
