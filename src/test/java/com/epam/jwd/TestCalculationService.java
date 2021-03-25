package com.epam.jwd;

import com.epam.jwd.entity.Massive;
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
                { new Massive(new int[]{1, 2, 3, 4}), 10 },
                { new Massive(new int[]{2, 3, 4, 5}), 14 },
                { new Massive(new int[]{1, 2, 3, 4}), 10 },
                { new Massive(new int[]{1, 2, 3, 4}), 10 },
                { new Massive(new int[]{1, 2, 3, 4}), 10 },
                { new Massive(new int[]{1, 2, 3, 4}), 10 },
                { new Massive(new int[]{1, 2, 3, 4}), 10 },
                { new Massive(new int[]{1, 2, 3, 4}), 10 },
                { new Massive(new int[]{1, 2, 3, 4}), 10 },
                { new Massive(new int[]{1, 2, 3, 4}), 10 },
                { new Massive(new int[]{1, 2, 3, 4}), 10 },
                { new Massive(new int[]{1, 2, 3, 4}), 10 },
                { new Massive(new int[]{1, 2, 3, 4}), 10 },
                { new Massive(new int[]{1, 3, 3, 5}), 12 },
                { new Massive(new int[]{1, 2, 3, 4}), 10 },
                { new Massive(new int[]{1, 2, 3, 4}), 10 },
                { new Massive(new int[]{1, 2, 3, 4}), 10 },
                { new Massive(new int[]{1, 2, 3, 4}), 10 },
                { new Massive(new int[]{1, 2, 3, 4}), 10 },
                { new Massive(new int[]{1, 2, 3, 4}), 10 }
        };
    }

    @DataProvider(name = "averageTestData")
    public Object[][] averageTestData() {
        return new Object[][] {
                { new Massive(new int[]{1, 2, 3, 4}), 2 },
                { new Massive(new int[]{2, 3, 4, 5}), 3 },
                { new Massive(new int[]{1, 2, 3, 4}), 2 },
                { new Massive(new int[]{1, 2, 3, 4}), 2 },
                { new Massive(new int[]{1, 2, 3, 4}), 2 },
                { new Massive(new int[]{1, 2, 3, 4}), 2 },
                { new Massive(new int[]{1, 2, 3, 4}), 2 },
                { new Massive(new int[]{1, 2, 3, 4}), 2 },
                { new Massive(new int[]{1, 2, 3, 4}), 2 },
                { new Massive(new int[]{1, 2, 3, 4}), 2 },
                { new Massive(new int[]{1, 2, 3, 4}), 2 },
                { new Massive(new int[]{1, 2, 3, 4}), 2 },
                { new Massive(new int[]{1, 2, 3, 4}), 2 },
                { new Massive(new int[]{1, 3, 3, 5}), 3 },
                { new Massive(new int[]{1, 2, 3, 4}), 2 },
                { new Massive(new int[]{1, 2, 3, 4}), 2 },
                { new Massive(new int[]{1, 2, 3, 4}), 2 },
                { new Massive(new int[]{1, 2, 3, 4}), 2 },
                { new Massive(new int[]{1, 2, 3, 4}), 2 },
                { new Massive(new int[]{1, 2, 3, 4}), 2 }
        };
    }

    @DataProvider(name = "numbersCounterTestData")
    public Object[][] numbersCounterTestData() {
        return new Object[][] {
                { new Massive(new int[]{1, 2, 3, 4}), true, 4 },
                { new Massive(new int[]{2, 3, 4, 5}), true, 4 },
                { new Massive(new int[]{1, 2, 3, 4}), true, 4 },
                { new Massive(new int[]{1, 2, 3, 4}), true, 4 },
                { new Massive(new int[]{1, 2, 3, 4}), false, 0 },
                { new Massive(new int[]{1, 2, 3, 4}), true, 4 },
                { new Massive(new int[]{1, 2, 3, 4}), true, 4 },
                { new Massive(new int[]{1, 2, 3, 4}), true, 4 },
                { new Massive(new int[]{1, 2, 3, 4}), true, 4 },
                { new Massive(new int[]{1, 2, 3, 4}), true, 4 },
                { new Massive(new int[]{-2, -1, -4, 4}), true, 1 },
                { new Massive(new int[]{-2, -1, -4, 4}), false, 3 },
                { new Massive(new int[]{1, 2, 3, 4}), true, 4 },
                { new Massive(new int[]{1, 2, 3, 4}), true, 4 },
                { new Massive(new int[]{1, 3, 3, 5}), true, 4 },
                { new Massive(new int[]{1, 2, 3, 4}), true, 4 },
                { new Massive(new int[]{1, 2, 3, 4}), true, 4 },
                { new Massive(new int[]{1, 2, 3, 4}), true, 4 },
                { new Massive(new int[]{1, 2, 3, 4}), true, 4 },
                { new Massive(new int[]{1, 2, 3, 4}), true, 4 },
                { new Massive(new int[]{1, 2, 3, 4}), true, 4 }
        };
    }

    @Test(dataProvider = "sumTestData")
    public void sumTest(Massive massive, int expectedSum) {
        int sum = CalculationServiceImpl.getInstance().sum(massive);
        LOGGER.log(Level.INFO, new StringBuilder()
                .append("test with data: ").append(massive.toString()));
        Assert.assertEquals(sum, expectedSum);
    }

    @Test(dataProvider = "averageTestData")
    public void averageTest(Massive massive, int expectedAverage) {
        int average = CalculationServiceImpl.getInstance().average(massive);
        LOGGER.log(Level.INFO, new StringBuilder()
                .append("test with data: ").append(massive.toString()));
        Assert.assertEquals(average, expectedAverage);
    }

    @Test(dataProvider = "numbersCounterTestData")
    public void numbersCounterTest(Massive massive, boolean isPositive, int expectedCounter) {
        int counter = CalculationServiceImpl.getInstance().numbersCounter(massive, isPositive);
        LOGGER.log(Level.INFO, new StringBuilder()
                .append("test with data: ").append(massive.toString()));
        Assert.assertEquals(counter, expectedCounter);
    }
}
