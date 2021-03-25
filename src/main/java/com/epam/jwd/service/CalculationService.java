package com.epam.jwd.service;

import com.epam.jwd.entity.CustomArray;

public interface CalculationService {

    int average(CustomArray customArray);

    int sum(CustomArray customArray);

    int numbersCounter(CustomArray customArray, boolean isPositive);
}
