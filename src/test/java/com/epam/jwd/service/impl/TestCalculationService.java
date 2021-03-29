package com.epam.jwd.service.impl;

import com.epam.jwd.entity.CustomArray;
import com.epam.jwd.exception.CustomArrayException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCalculationService {

    @DataProvider(name = "sumTestData")
    public Object[][] sumTestData() {
        return new Object[][]{
                {new CustomArray(new int[]{1, 6, 11, 4}), 22},
                {new CustomArray(new int[]{5, 0, 4, 5}), 14},
                {new CustomArray(new int[]{2, -6, 65, 5}), 66},
                {new CustomArray(new int[]{2, -50, 10, 5}), -33},
                {new CustomArray(new int[]{5, 44, 7, 5}), 61},
                {new CustomArray(new int[]{2, 3, -44, 5}), -34},
                {new CustomArray(new int[]{2, 48, 8, -6}), 52},
                {new CustomArray(new int[]{2, 3, 15, 5}), 25},
                {new CustomArray(new int[]{2, -2, 10, 5}), 15}
        };
    }

    @DataProvider(name = "averageTestData")
    public Object[][] averageTestData() {
        return new Object[][]{
                {new CustomArray(new int[]{1, 6, 11, 4}), 5},
                {new CustomArray(new int[]{5, 0, 4, 5}), 3},
                {new CustomArray(new int[]{2, -6, 65, 5}), 16},
                {new CustomArray(new int[]{2, -50, 10, 5}), -8},
                {new CustomArray(new int[]{5, 44, 7, 5}), 15},
                {new CustomArray(new int[]{2, 3, -44, 5}), -8},
                {new CustomArray(new int[]{2, 48, 8, -6}), 13},
                {new CustomArray(new int[]{2, 3, 15, 5}), 6},
                {new CustomArray(new int[]{2, -2, 10, 5}), 3},
                {new CustomArray(new int[]{15, 3, -50, 5}), -6}
        };
    }

    @DataProvider(name = "numbersCounterTestData")
    public Object[][] numbersCounterTestData() {
        return new Object[][]{
                {new CustomArray(new int[]{1, 6, 11, 4}), true, 4},
                {new CustomArray(new int[]{5, 0, 4, 5}), true, 3},
                {new CustomArray(new int[]{2, -6, 65, 5}), true, 3},
                {new CustomArray(new int[]{2, -50, 10, 5}), true, 3},
                {new CustomArray(new int[]{5, 44, 7, 5}), false, 0},
                {new CustomArray(new int[]{2, 3, -44, 5}), true, 3},
                {new CustomArray(new int[]{2, 48, 8, -6}), true, 3},
                {new CustomArray(new int[]{2, 3, 15, 5}), true, 4},
                {new CustomArray(new int[]{2, -2, 10, 5}), true, 3},
                {new CustomArray(new int[]{15, 3, -50, 5}), true, 3}
        };
    }

    @Test(dataProvider = "sumTestData")
    public void sumTest(CustomArray customArray, int expectedSum) throws CustomArrayException {
        int sum = CalculationServiceImpl.getInstance().sum(customArray);
        Assert.assertEquals(sum, expectedSum);
    }

    @Test(dataProvider = "sumTestData")
    public void sumTestStream(CustomArray customArray, int expectedSum) throws CustomArrayException {
        int sum = CalculationServiceImpl.getInstance().sumStream(customArray);
        Assert.assertEquals(sum, expectedSum);
    }

    @Test(dataProvider = "averageTestData")
    public void averageTest(CustomArray customArray, int expectedAverage) throws CustomArrayException {
        int average = CalculationServiceImpl.getInstance().average(customArray);
        Assert.assertEquals(average, expectedAverage);
    }

    @Test(dataProvider = "averageTestData")
    public void averageStreamTest(CustomArray customArray, int expectedAverage) throws CustomArrayException {
        int average = CalculationServiceImpl.getInstance().averageStream(customArray);
        Assert.assertEquals(average, expectedAverage);
    }

    @Test(dataProvider = "numbersCounterTestData")
    public void numbersCounterTest(CustomArray customArray, boolean isPositive, int expectedCounter) throws CustomArrayException {
        int counter = CalculationServiceImpl.getInstance().numbersCounter(customArray, isPositive);
        Assert.assertEquals(counter, expectedCounter);
    }

    @Test(dataProvider = "numbersCounterTestData")
    public void numbersCounterStreamTest(CustomArray customArray, boolean isPositive, int expectedCounter) throws CustomArrayException {
        int counter = CalculationServiceImpl.getInstance().numbersCounterStream(customArray, isPositive);
        Assert.assertEquals(counter, expectedCounter);
    }

    @Test
    public void sumNullTestException() {
        Assert.expectThrows(CustomArrayException.class,
                ()-> CalculationServiceImpl
                        .getInstance()
                        .sum(new CustomArray()));
    }
    @Test
    public void averageNullTestException() {
        Assert.expectThrows(CustomArrayException.class,
                ()-> CalculationServiceImpl
                        .getInstance()
                        .average(new CustomArray()));
    }
    @Test
    public void numbersCounterNullTestException() {
        Assert.expectThrows(CustomArrayException.class,
                ()-> CalculationServiceImpl
                        .getInstance()
                        .numbersCounter(new CustomArray(), true));
    }
}
