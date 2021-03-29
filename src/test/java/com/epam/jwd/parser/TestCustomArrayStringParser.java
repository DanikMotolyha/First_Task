package com.epam.jwd.parser;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCustomArrayStringParser {
    @DataProvider(name = "parseTestData")
    public Object[][] parseTestData() {
        return new Object[][]{
                {"1 5 54 8 74 -4 54 51 2 3", new int[]{1, 5, 54, 8, 74, -4, 54, 51, 2, 3}},
                {"6 54 1 3 5 13 5 4", new int[]{6, 54, 1, 3, 5, 13, 5, 4}},
                {"13 43 -4 -564 54 6 1", new int[]{13, 43, -4, -564, 54, 6, 1}}
        };
    }

    @Test(dataProvider = "parseTestData")
    public void parseTest(String parseString, int[] expected) {
        CustomArrayStringParser parser = new CustomArrayStringParser();
        int[] actual = parser.parse(parseString);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void parseTestFail() {
        CustomArrayStringParser parser = new CustomArrayStringParser();
        int[] actual = parser.parse("1 5 54 8 74 -4 54 51 2 3");
        int[] expected = new int[]{1, 5};
        Assert.assertNotEquals(actual, expected);
    }
}
