package com.epam.jwd.entity;

import com.epam.jwd.exception.CustomArrayException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCustomArray {

    @DataProvider(name = "initCustomArrayTest")
    public Object[][] initCustomArrayTestData() {
        return new Object[][]{
                {new int[]{1, 6, 11, 4}},
                {new int[]{5, 0, 4, 5}},
                {new int[]{2, -6, 65, 5}},
                {new int[]{2, -50, 10, 5}},
                {new int[]{5, 44, 7, 5}},
                {new int[]{2, 3, -44, 5}},
                {new int[]{2, 48, 8, -6}},
                {new int[]{2, 3, 15, 5}},
                {new int[]{2, -2, 10, 5}},
                {new int[]{15, 3, -50, 5}}
        };
    }

    @Test
    public void initEmptyCustomArrayTest() {
        CustomArray array = new CustomArray();
        Assert.assertNotNull(array);
    }

    @Test(dataProvider = "initCustomArrayTest")
    public void initCustomArrayTest(int... params) {
        CustomArray array = new CustomArray(params);
        Assert.assertNotNull(array);
    }

    @Test
    public void getElementCustomArrayTest() throws CustomArrayException {
        CustomArray array = new CustomArray(new int[]{1, 2, 3, 4});
        array.getElement(2);
    }

    @Test
    public void setElementCustomArrayTest() throws CustomArrayException {
        CustomArray array = new CustomArray(new int[]{1, 2, 3, 4});
        array.setElement(2, 45);
    }
}
