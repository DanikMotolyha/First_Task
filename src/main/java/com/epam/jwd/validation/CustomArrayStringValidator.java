package com.epam.jwd.validation;

public class CustomArrayStringValidator {
    static String validateDigits = "(-?\\d{0,10} *)+";

    public static boolean validate(String input){
            return input.matches(validateDigits);
    }
}
