package com.epam.jwd.validation;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCustomArrayStringValidator {
    @DataProvider(name = "validateTestData")
    public Object[][] validateTestData() {
        return new Object[][]{
                {"1 5 54 8 74 -4 54 51 2 3"},
                {"6 54 1 3 5 13 5 4"},
                {"13 43 -4 -564 54 6 1"}
        };
    }

    @Test(dataProvider = "validateTestData")
    public void validateTest(String validateString) {
        CustomArrayStringValidator validator = new CustomArrayStringValidator();
        Assert.assertTrue(validator.validate(validateString));
    }

    @Test
    public void validateTestFail() {
        CustomArrayStringValidator validator = new CustomArrayStringValidator();
        Assert.assertFalse(validator.validate("12 12 -5 a5 -5 124"));
    }
}
