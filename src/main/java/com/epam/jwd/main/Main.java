package com.epam.jwd.main;

import com.epam.jwd.entity.CustomArray;
import com.epam.jwd.exception.CustomArrayException;
import com.epam.jwd.parser.CustomArrayStringParser;
import com.epam.jwd.reader.CustomArrayReader;
import com.epam.jwd.validation.CustomArrayStringValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//TODO delete this class
public class Main {
    private final static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws CustomArrayException {
        CustomArray array = null;
        try (CustomArrayReader reader =
                     new CustomArrayReader(
                             "src\\main\\resources\\data\\inputParameters.txt")) {
            while (reader.hasNextLine()) {
                String line = reader.getNextLine();
                if (CustomArrayStringValidator.validate(line)) {
                    array = new CustomArray(CustomArrayStringParser.parse(line));
                    break;
                }
            }
            LOGGER.log(Level.INFO, array);
        } catch (Exception e) {
            LOGGER.log(Level.FATAL, "cannot create from file CustomArray");
            throw new CustomArrayException("cannot create from file CustomArray");
        }
    }
}
