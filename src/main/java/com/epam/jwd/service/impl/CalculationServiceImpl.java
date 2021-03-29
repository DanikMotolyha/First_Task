package com.epam.jwd.service.impl;

import com.epam.jwd.entity.CustomArray;
import com.epam.jwd.exception.CustomArrayException;
import com.epam.jwd.service.CalculationService;
import com.epam.jwd.validation.CustomArrayServiceValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.IntStream;

public class CalculationServiceImpl implements CalculationService {
    private final static CalculationService INSTANCE = new CalculationServiceImpl();
    private final static Logger LOGGER = LogManager.getLogger(CalculationServiceImpl.class);
    private static CustomArrayServiceValidator validator = new CustomArrayServiceValidator();

    private CalculationServiceImpl() {
    }

    public static CalculationService getInstance() {
        return INSTANCE;
    }

    @Override
    public int average(CustomArray customArray) throws CustomArrayException {
        validator.validateNotNullOrEmpty(customArray);
        LOGGER.log(Level.INFO,
                new StringBuilder().append("func average with obj: ")
                        .append(customArray.toString()));
        return sum(customArray) / customArray.getData().length;
    }

    public int averageStream(CustomArray customArray) throws CustomArrayException {
        validator.validateNotNullOrEmpty(customArray);
        LOGGER.log(Level.INFO,
                new StringBuilder().append("func average with obj: ")
                        .append(customArray.toString()));
        return (int) IntStream.of(customArray.getData())
                .average().orElseThrow();
    }

    @Override
    public int sum(CustomArray customArray) throws CustomArrayException {
        validator.validateNotNullOrEmpty(customArray);
        LOGGER.log(Level.INFO,
                new StringBuilder().append("func sum with obj: ")
                        .append(customArray.toString()));
        int sum = 0;
        for (int value : customArray.getData()) {
            sum += value;
        }
        return sum;
    }

    public int sumStream(CustomArray customArray) throws CustomArrayException {
        validator.validateNotNullOrEmpty(customArray);
        LOGGER.log(Level.INFO,
                new StringBuilder().append("func sum with obj: ")
                        .append(customArray.toString()));
        return IntStream.of(customArray.getData()).sum();
    }

    @Override
    public int numbersCounter(CustomArray customArray, boolean isPositive) throws CustomArrayException {
        validator.validateNotNullOrEmpty(customArray);
        LOGGER.log(Level.INFO,
                new StringBuilder().append("func numbersCounter with obj: ")
                        .append(customArray.toString()));
        int counter = 0;
        if (isPositive) {
            for (int value : customArray.getData()) {
                if (value > 0) {
                    counter++;
                }
            }
        } else {
            for (int value : customArray.getData()) {
                if (value < 0) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public int numbersCounterStream(CustomArray customArray, boolean isPositive) throws CustomArrayException {
        validator.validateNotNullOrEmpty(customArray);
        LOGGER.log(Level.INFO,
                new StringBuilder().append("func numberCounter with obj: ")
                        .append(customArray.toString()));
        IntStream stream = IntStream.of(customArray.getData());
        return (int) (isPositive
                        ? stream.filter(elem -> elem > 0).count()
                        : stream.filter(elem -> elem < 0).count());
    }
}
