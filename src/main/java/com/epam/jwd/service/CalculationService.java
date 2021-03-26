package com.epam.jwd.service;

import com.epam.jwd.entity.CustomArray;
import com.epam.jwd.exception.CustomArrayException;

public interface CalculationService {

    int average(CustomArray customArray) throws CustomArrayException;

    int sum(CustomArray customArray) throws CustomArrayException;

    int numbersCounter(CustomArray customArray, boolean isPositive) throws CustomArrayException;
}
