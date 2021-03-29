package com.epam.jwd.creator;

import com.epam.jwd.entity.CustomArray;
import com.epam.jwd.parser.CustomArrayFileParser;
import com.epam.jwd.reader.CustomArrayReader;
import com.epam.jwd.validation.CustomArrayFileValidator;

public class CustomArrayCreator {

    public CustomArray createFromFile() {
        CustomArray array = null;
        CustomArrayFileValidator validator = new CustomArrayFileValidator();
        CustomArrayFileParser parser = new CustomArrayFileParser();
        try (CustomArrayReader reader = new CustomArrayReader()) {
            while (reader.hasNextLine()) {
                String line = reader.getNextLine();
                if (validator.validate(line)) {
                    array = new CustomArray(parser.parse(line));
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }
}
