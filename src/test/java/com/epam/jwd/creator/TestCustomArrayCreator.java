package com.epam.jwd.creator;

import com.epam.jwd.entity.CustomArray;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCustomArrayCreator {

    @DataProvider(name = "customArrayCreateTestData")
    public Object[][] customArrayCreateTestData() {
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

    @Test(dataProvider = "customArrayCreateTestData")
    public void customArrayCreateTest(int... params) {
        CustomArrayCreator creator = new CustomArrayCreator();
        CustomArray array = creator.create(params);
        Assert.assertNotNull(array);
    }
}
