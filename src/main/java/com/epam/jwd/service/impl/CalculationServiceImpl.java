package com.epam.jwd.service.impl;

import com.epam.jwd.entity.CustomArray;
import com.epam.jwd.service.CalculationService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CalculationServiceImpl implements CalculationService {
    private final static CalculationService INSTANCE = new CalculationServiceImpl();
    private final static Logger LOGGER = LogManager.getLogger(CalculationServiceImpl.class);

    private CalculationServiceImpl() {

    }

    public static CalculationService getInstance() {
        return INSTANCE;
    }

    @Override
    public int average(CustomArray customArray) {
        LOGGER.log(Level.INFO,
                new StringBuilder().append("func average with obj: ")
                        .append(customArray.toString()));
        return sum(customArray) / customArray.getData().length;
    }

    @Override
    public int sum(CustomArray customArray) {
        LOGGER.log(Level.INFO,
                new StringBuilder().append("func sum with obj: ")
                        .append(customArray.toString()));
        int sum = 0;
        for (int value : customArray.getData()) {
            sum += value;
        }
        return sum;
    }

    @Override
    public int numbersCounter(CustomArray customArray, boolean isPositive) {
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
}
