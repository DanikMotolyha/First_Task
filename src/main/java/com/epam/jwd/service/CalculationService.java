package com.epam.jwd.service;

import com.epam.jwd.entity.Massive;

public interface CalculationService {

    int average(Massive massive);

    int sum(Massive massive);

    int numbersCounter(Massive massive, boolean isPositive);
}
