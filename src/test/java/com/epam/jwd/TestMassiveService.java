package com.epam.jwd;

import com.epam.jwd.entity.Massive;
import com.epam.jwd.service.impl.CalculationServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class TestMassiveService {
    static final Logger LOGGER = LogManager.getLogger(TestMassiveService.class);


    @DataProvider(name = "sumTestData")
    public Object[][] dataProviderMethod() {
        return new Object[][] {
                { new Massive(new int[]{1, 2, 3, 4}), 2 },
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
                { new Massive(new int[]{1, 3, 3, 5}), 13 },
                { new Massive(new int[]{1, 2, 3, 4}), 10 },
                { new Massive(new int[]{1, 2, 3, 4}), 10 },
                { new Massive(new int[]{1, 2, 3, 4}), 10 },
                { new Massive(new int[]{1, 2, 3, 4}), 10 },
                { new Massive(new int[]{1, 2, 3, 4}), 10 },
                { new Massive(new int[]{1, 2, 3, 4}), 10 }
        };
    }



    @Test(dataProvider = "sumTestData")
    public void testMethod(Massive massive, int expectedSum) {
        int sum = CalculationServiceImpl.getInstance().sum(massive);
        LOGGER.log(Level.INFO, new StringBuilder()
                .append("test with data: ").append(massive.toString()));
        Assert.assertEquals(sum, expectedSum);
    }

}
