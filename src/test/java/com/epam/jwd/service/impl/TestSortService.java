package com.epam.jwd.service.impl;

import com.epam.jwd.entity.CustomArray;
import com.epam.jwd.exception.CustomArrayException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestSortService {
    @DataProvider(name = "TestData")
    public Object[][] TestData() {
        return new Object[][]{
                {new CustomArray(new int[]{1, 6, 11, 4}), new CustomArray(new int[]{1, 4, 6, 11})},
                {new CustomArray(new int[]{5, 0, 4, 5}), new CustomArray(new int[]{0, 4, 5, 5})},
                {new CustomArray(new int[]{2, -6, 65, 5}), new CustomArray(new int[]{-6, 2, 5, 65})},
                {new CustomArray(new int[]{2, -50, 10, 5}), new CustomArray(new int[]{-50, 2, 5, 10})},
                {new CustomArray(new int[]{5, 44, 7, 5}), new CustomArray(new int[]{5, 5, 7, 44})},
                {new CustomArray(new int[]{2, 3, -44, 5}), new CustomArray(new int[]{-44, 2, 3, 5})},
                {new CustomArray(new int[]{2, 48, 8, -6}), new CustomArray(new int[]{-6, 2, 8, 48})},
                {new CustomArray(new int[]{2, 3, 15, 5}), new CustomArray(new int[]{2, 3, 5, 15})},
                {new CustomArray(
                        new int[]{1, 2, 3, 4, 6, 5, 4, 7, 9, 8,
                                7, 4, 5, 7, 5, 9, 12, 45, 35, -65,
                                44, -78, -10, -1, 10, 48, 24, 10,
                                100, 156, -7, 15, -35}),
                        new CustomArray(new int[]{-78, -65, -35, -10, -7, -1, 1, 2, 3, 4,
                                4, 4, 5, 5, 5, 6, 7, 7, 7, 8,
                                9, 9, 10, 10, 12, 15, 24, 35,
                                44, 45, 48, 100, 156})},
                {new CustomArray(new int[]{15, 897, 156, 234, 1456, 231, 5, 4, 3, 9,
                        7, 6, 1, 2, -5, -6, -7, -45, -142,
                        -234, -100, -1554, 154}),
                        new CustomArray(new int[]{-1554, -234, -142, -100, -45, -7, -6, -5, 1, 2, 3
                                , 4, 5, 6, 7, 9, 15, 154, 156, 231,
                                234, 897, 1456})},
                {new CustomArray(new int[]{2, -2, 10, 5}), new CustomArray(new int[]{-2, 2, 5, 10})}
        };
    }


    @Test(dataProvider = "TestData")
    public void BubbleSortTest(CustomArray customArray, CustomArray expected) throws CustomArrayException {
        SortServiceImpl.getInstance().bubbleSort(customArray);
        Assert.assertEquals(customArray, expected);
    }

    @Test(dataProvider = "TestData")
    public void ShakeSortTest(CustomArray customArray, CustomArray expected) throws CustomArrayException {
        SortServiceImpl.getInstance().shakeSort(customArray);
        Assert.assertEquals(customArray, expected);
    }

    @Test(dataProvider = "TestData")
    public void CombSortTest(CustomArray customArray, CustomArray expected) throws CustomArrayException {
        SortServiceImpl.getInstance().CombSort(customArray);
        Assert.assertEquals(customArray, expected);
    }

    @Test(dataProvider = "TestData")
    public void StreamSort(CustomArray customArray, CustomArray expected) throws CustomArrayException {
        SortServiceImpl.getInstance().SteamSort(customArray);
        Assert.assertEquals(customArray, expected);
    }
}
