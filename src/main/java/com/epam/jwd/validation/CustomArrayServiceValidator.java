package com.epam.jwd.validation;

import com.epam.jwd.entity.CustomArray;
import com.epam.jwd.exception.CustomArrayException;

public class CustomArrayServiceValidator {

    public void validateNotNullOrEmpty(CustomArray customArray) throws CustomArrayException {
        if(customArray.getData() == null){
            throw new CustomArrayException("incorrect CustomArray: cannot be null");
        }
        if(customArray.getData().length == 0){
            throw new CustomArrayException("CustomArray is empty");
        }
    }
    public void validateUpdate(CustomArray customArray, int from, int to, int... values) throws CustomArrayException {
        int length = Math.abs(Math.abs(from) - Math.abs(to));
        if (from < 0 || to < 0
                || from > to
                || values.length != length
                || customArray.getData().length < to) {
            throw new CustomArrayException("incorrect input");
        }
    }
}
