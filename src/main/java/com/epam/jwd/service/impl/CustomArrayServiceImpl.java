package com.epam.jwd.service.impl;

import com.epam.jwd.entity.CustomArray;
import com.epam.jwd.exception.CustomArrayException;
import com.epam.jwd.service.CustomArrayService;
import com.epam.jwd.validation.CustomArrayServiceValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomArrayServiceImpl implements CustomArrayService {
    private final static CustomArrayService INSTANCE = new CustomArrayServiceImpl();
    private final static Logger LOGGER = LogManager.getLogger(CustomArrayServiceImpl.class);
    private static CustomArrayServiceValidator validator = new CustomArrayServiceValidator();

    private CustomArrayServiceImpl() {

    }

    public static CustomArrayService getInstance() {
        return INSTANCE;
    }

    @Override
    public int min(CustomArray customArray) throws CustomArrayException {
        validator.validateNotNullOrEmpty(customArray);
        int min = customArray.getData()[0];
        for (int value : customArray.getData()) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    @Override
    public int max(CustomArray customArray) throws CustomArrayException {
        validator.validateNotNullOrEmpty(customArray);
        int max = customArray.getData()[0];
        for (int value : customArray.getData()) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    /**

     @param customArray array for update
     @param from must be bigger then to
     @param to   must be less than from
     @param values values.length must be equal to (from - to)

     @return length count of updated elements
     */
    @Override
    public int update(CustomArray customArray, int from, int to, int... values) throws CustomArrayException {
        validator.validateNotNullOrEmpty(customArray);
        validator.validateUpdate(customArray, from, to, values);
        int[] mas = customArray.getData();
        for (int i = from, j = 0; i < to; i++) {
            mas[i] = values[j++];
        }
        customArray.setData(mas);
        return Math.abs(Math.abs(from) - Math.abs(to));
    }
}
