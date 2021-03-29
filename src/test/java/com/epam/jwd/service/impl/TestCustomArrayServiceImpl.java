package com.epam.jwd.service.impl;

import com.epam.jwd.entity.CustomArray;
import com.epam.jwd.exception.CustomArrayException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCustomArrayServiceImpl {

    @DataProvider(name = "minTestData")
    public Object[][] minTestData() {
        return new Object[][]{
                {new CustomArray(new int[]{1, 6, 11, 4}), 1},
                {new CustomArray(new int[]{5, 0, 4, 5}), 0},
                {new CustomArray(new int[]{2, -6, 65, 5}), -6},
                {new CustomArray(new int[]{2, -50, 10, 5}), -50},
                {new CustomArray(new int[]{5, 44, 7, 5}), 5},
                {new CustomArray(new int[]{2, 3, -44, 5}), -44},
                {new CustomArray(new int[]{2, 48, 8, -6}), -6},
                {new CustomArray(new int[]{2, 3, 15, 5}), 2},
                {new CustomArray(new int[]{2, -2, 10, 5}), -2}
        };
    }

    @DataProvider(name = "maxTestData")
    public Object[][] maxTestData() {
        return new Object[][]{
                {new CustomArray(new int[]{1, 6, 11, 4}), 11},
                {new CustomArray(new int[]{5, 0, 4, 5}), 5},
                {new CustomArray(new int[]{2, -6, 65, 5}), 65},
                {new CustomArray(new int[]{2, -50, 10, 5}), 10},
                {new CustomArray(new int[]{5, 44, 7, 5}), 44},
                {new CustomArray(new int[]{2, 3, -44, 5}), 5},
                {new CustomArray(new int[]{2, 48, 8, -6}), 48},
                {new CustomArray(new int[]{2, 3, 15, 5}), 15},
                {new CustomArray(new int[]{2, -2, 10, 5}), 10},
                {new CustomArray(new int[]{15, 3, -50, 5}), 15}
        };
    }

    @DataProvider(name = "updateTestData")
    public Object[][] updateTestData() {
        return new Object[][]{
                {new CustomArray(new int[]{1, 6, 11, 4}), 2, 4, new int[]{0, 0}, 2},
                {new CustomArray(new int[]{1, 6, 11, 4}), 1, 4, new int[]{0, 0, 0}, 3}
        };
    }

    @Test(dataProvider = "minTestData")
    public void minTest(CustomArray customArray, int expected) throws CustomArrayException {
        int actual = CustomArrayServiceImpl.getInstance().min(customArray);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "minTestData")
    public void minStreamTest(CustomArray customArray, int expected) throws CustomArrayException {
        int actual = CustomArrayServiceImpl.getInstance().minStream(customArray);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "maxTestData")
    public void maxTest(CustomArray customArray, int expected) throws CustomArrayException {
        int actual = CustomArrayServiceImpl.getInstance().max(customArray);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "maxTestData")
    public void maxStreamTest(CustomArray customArray, int expected) throws CustomArrayException {
        int actual = CustomArrayServiceImpl.getInstance().maxStream(customArray);
        Assert.assertEquals(actual, expected);
    }

    //int update(CustomArray customArray, int from, int to, int ... values);
    @Test(dataProvider = "updateTestData")
    public void numbersCounterTest(CustomArray customArray, int from, int to, int[] values, int expected) throws CustomArrayException {
        int actual = CustomArrayServiceImpl.getInstance().update(customArray, from, to, values);
        Assert.assertEquals(actual, expected);
    }


    @Test
    public void minNullTestException() {
        Assert.expectThrows(CustomArrayException.class,
                ()-> CustomArrayServiceImpl
                        .getInstance()
                        .min(new CustomArray()));
    }
    @Test
    public void maxNullTestException() {
        Assert.expectThrows(CustomArrayException.class,
                ()-> CustomArrayServiceImpl
                        .getInstance()
                        .max(new CustomArray()));
    }
    @Test
    public void updateNullTestException() {
        Assert.expectThrows(CustomArrayException.class,
                ()-> CustomArrayServiceImpl
                        .getInstance()
                        .update(new CustomArray(),
                                1, 2, 3));
    }

    @Test
    public void updateInputTestException() {
        Assert.expectThrows(CustomArrayException.class,
                ()-> CustomArrayServiceImpl
                        .getInstance()
                        .update(new CustomArray(new int[]{1,2,3}),
                                2, 1, 3));
    }
}
