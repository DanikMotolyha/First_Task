package com.epam.jwd;

import com.epam.jwd.entity.CustomArray;
import com.epam.jwd.service.impl.CalculationServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCalculationService {
    static final Logger LOGGER = LogManager.getLogger(TestCalculationService.class);


    @DataProvider(name = "sumTestData")
    public Object[][] sumTestData() {
        return new Object[][] {
                { new CustomArray(new int[]{1, 2, 3, 4}), 10 },
                { new CustomArray(new int[]{2, 3, 4, 5}), 14 },
                { new CustomArray(new int[]{1, 2, 3, 4}), 10 },
                { new CustomArray(new int[]{1, 2, 3, 4}), 10 },
                { new CustomArray(new int[]{1, 2, 3, 4}), 10 },
                { new CustomArray(new int[]{1, 2, 3, 4}), 10 },
                { new CustomArray(new int[]{1, 2, 3, 4}), 10 },
                { new CustomArray(new int[]{1, 2, 3, 4}), 10 },
                { new CustomArray(new int[]{1, 2, 3, 4}), 10 },
                { new CustomArray(new int[]{1, 2, 3, 4}), 10 },
                { new CustomArray(new int[]{1, 2, 3, 4}), 10 },
                { new CustomArray(new int[]{1, 2, 3, 4}), 10 },
                { new CustomArray(new int[]{1, 2, 3, 4}), 10 },
                { new CustomArray(new int[]{1, 3, 3, 5}), 12 },
                { new CustomArray(new int[]{1, 2, 3, 4}), 10 },
                { new CustomArray(new int[]{1, 2, 3, 4}), 10 },
                { new CustomArray(new int[]{1, 2, 3, 4}), 10 },
                { new CustomArray(new int[]{1, 2, 3, 4}), 10 },
                { new CustomArray(new int[]{1, 2, 3, 4}), 10 },
                { new CustomArray(new int[]{1, 2, 3, 4}), 10 }
        };
    }

    @DataProvider(name = "averageTestData")
    public Object[][] averageTestData() {
        return new Object[][] {
                { new CustomArray(new int[]{1, 2, 3, 4}), 2 },
                { new CustomArray(new int[]{2, 3, 4, 5}), 3 },
                { new CustomArray(new int[]{1, 2, 3, 4}), 2 },
                { new CustomArray(new int[]{1, 2, 3, 4}), 2 },
                { new CustomArray(new int[]{1, 2, 3, 4}), 2 },
                { new CustomArray(new int[]{1, 2, 3, 4}), 2 },
                { new CustomArray(new int[]{1, 2, 3, 4}), 2 },
                { new CustomArray(new int[]{1, 2, 3, 4}), 2 },
                { new CustomArray(new int[]{1, 2, 3, 4}), 2 },
                { new CustomArray(new int[]{1, 2, 3, 4}), 2 },
                { new CustomArray(new int[]{1, 2, 3, 4}), 2 },
                { new CustomArray(new int[]{1, 2, 3, 4}), 2 },
                { new CustomArray(new int[]{1, 2, 3, 4}), 2 },
                { new CustomArray(new int[]{1, 3, 3, 5}), 3 },
                { new CustomArray(new int[]{1, 2, 3, 4}), 2 },
                { new CustomArray(new int[]{1, 2, 3, 4}), 2 },
                { new CustomArray(new int[]{1, 2, 3, 4}), 2 },
                { new CustomArray(new int[]{1, 2, 3, 4}), 2 },
                { new CustomArray(new int[]{1, 2, 3, 4}), 2 },
                { new CustomArray(new int[]{1, 2, 3, 4}), 2 }
        };
    }

    @DataProvider(name = "numbersCounterTestData")
    public Object[][] numbersCounterTestData() {
        return new Object[][] {
                { new CustomArray(new int[]{1, 2, 3, 4}), true, 4 },
                { new CustomArray(new int[]{2, 3, 4, 5}), true, 4 },
                { new CustomArray(new int[]{1, 2, 3, 4}), true, 4 },
                { new CustomArray(new int[]{1, 2, 3, 4}), true, 4 },
                { new CustomArray(new int[]{1, 2, 3, 4}), false, 0 },
                { new CustomArray(new int[]{1, 2, 3, 4}), true, 4 },
                { new CustomArray(new int[]{1, 2, 3, 4}), true, 4 },
                { new CustomArray(new int[]{1, 2, 3, 4}), true, 4 },
                { new CustomArray(new int[]{1, 2, 3, 4}), true, 4 },
                { new CustomArray(new int[]{1, 2, 3, 4}), true, 4 },
                { new CustomArray(new int[]{-2, -1, -4, 4}), true, 1 },
                { new CustomArray(new int[]{-2, -1, -4, 4}), false, 3 },
                { new CustomArray(new int[]{1, 2, 3, 4}), true, 4 },
                { new CustomArray(new int[]{1, 2, 3, 4}), true, 4 },
                { new CustomArray(new int[]{1, 3, 3, 5}), true, 4 },
                { new CustomArray(new int[]{1, 2, 3, 4}), true, 4 },
                { new CustomArray(new int[]{1, 2, 3, 4}), true, 4 },
                { new CustomArray(new int[]{1, 2, 3, 4}), true, 4 },
                { new CustomArray(new int[]{1, 2, 3, 4}), true, 4 },
                { new CustomArray(new int[]{1, 2, 3, 4}), true, 4 },
                { new CustomArray(new int[]{1, 2, 3, 4}), true, 4 }
        };
    }

    @Test(dataProvider = "sumTestData")
    public void sumTest(CustomArray customArray, int expectedSum) {
        int sum = CalculationServiceImpl.getInstance().sum(customArray);
        LOGGER.log(Level.INFO, new StringBuilder()
                .append("test with data: ").append(customArray.toString()));
        Assert.assertEquals(sum, expectedSum);
    }

    @Test(dataProvider = "averageTestData")
    public void averageTest(CustomArray customArray, int expectedAverage) {
        int average = CalculationServiceImpl.getInstance().average(customArray);
        LOGGER.log(Level.INFO, new StringBuilder()
                .append("test with data: ").append(customArray.toString()));
        Assert.assertEquals(average, expectedAverage);
    }

    @Test(dataProvider = "numbersCounterTestData")
    public void numbersCounterTest(CustomArray customArray, boolean isPositive, int expectedCounter) {
        int counter = CalculationServiceImpl.getInstance().numbersCounter(customArray, isPositive);
        LOGGER.log(Level.INFO, new StringBuilder()
                .append("test with data: ").append(customArray.toString()));
        Assert.assertEquals(counter, expectedCounter);
    }
}
