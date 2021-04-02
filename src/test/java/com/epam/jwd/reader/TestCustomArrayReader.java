package com.epam.jwd.reader;

import com.epam.jwd.exception.CustomArrayException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Scanner;

public class TestCustomArrayReader {

    @DataProvider(name = "customArrayReaderData")
    public Object[][] customArrayReaderData() {
        return new Object[][]{
                {"src\\main\\resources\\data\\inputParameters.txt", "1 2 3 4 5 -4 a2"},
                {"src\\main\\resources\\data\\inputTest2.txt", "2 34 54 65 768 23 -4 35 45 48 88"},
                {"src\\main\\resources\\data\\inputTest3.txt", "1 3 4 5 6 2"},
        };
    }

    @Test(dataProvider = "customArrayReaderData")
    public void customArrayReader(String fileName, String expected) throws CustomArrayException {
        try (CustomArrayReader reader =
                     new CustomArrayReader(fileName)) {
            String actual = reader.getNextLine();
            Assert.assertEquals(actual, expected);
        } catch (Exception e) {
            throw new CustomArrayException("cannot read from file");
        }
    }
}
