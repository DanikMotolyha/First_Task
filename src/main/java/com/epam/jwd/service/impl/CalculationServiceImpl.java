package com.epam.jwd.service.impl;

import com.epam.jwd.entity.Massive;
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
    public int average(Massive massive) {
        LOGGER.log(Level.INFO,
                new StringBuilder().append("func average with obj: ")
                        .append(massive.toString()));
        return sum(massive) / massive.getData().length;
    }

    @Override
    public int sum(Massive massive) {
        LOGGER.log(Level.INFO,
                new StringBuilder().append("func sum with obj: ")
                        .append(massive.toString()));
        int sum = 0;
        for (int value : massive.getData()) {
            sum += value;
        }
        return sum;
    }

    @Override
    public int numbersCounter(Massive massive, boolean isPositive) {
        LOGGER.log(Level.INFO,
                new StringBuilder().append("func numbersCounter with obj: ")
                        .append(massive.toString()));
        int counter = 0;
        if (isPositive) {
            for (int value : massive.getData()) {
                if (value > 0) {
                    counter += value;
                }
            }
        } else {
            for (int value : massive.getData()) {
                if (value < 0) {
                    counter += value;
                }
            }
        }
        return counter;
    }
}
