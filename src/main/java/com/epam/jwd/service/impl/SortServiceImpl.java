package com.epam.jwd.service.impl;

import com.epam.jwd.entity.CustomArray;
import com.epam.jwd.exception.CustomArrayException;
import com.epam.jwd.service.SortService;
import com.epam.jwd.validation.CustomArrayServiceValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.IntStream;

public class SortServiceImpl implements SortService {
    private final static SortService INSTANCE = new SortServiceImpl();
    private final static Logger LOGGER = LogManager.getLogger(SortServiceImpl.class);
    private static CustomArrayServiceValidator validator = new CustomArrayServiceValidator();

    private SortServiceImpl() {

    }

    public static SortService getInstance() {
        return INSTANCE;
    }


    @Override
    public void bubbleSort(CustomArray customArray) throws CustomArrayException {
        validator.validateNotNullOrEmpty(customArray);
        int[] array = customArray.getData();
        int length = array.length;
        int temp;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < (length - i); j++) {
                if (array[j - 1] > array[j]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        customArray.setData(array);
    }

    public void SteamSort(CustomArray customArray) throws CustomArrayException{
        validator.validateNotNullOrEmpty(customArray);
        int[] custom = IntStream.of(customArray.getData()).sorted().toArray();
        customArray.setData(custom);
    }

    @Override
    public void shakeSort(CustomArray customArray) throws CustomArrayException {
        validator.validateNotNullOrEmpty(customArray);
        int[] array = customArray.getData();
        int buff;
        int left = 0;
        int right = array.length - 1;
        do {
            for (int i = left; i < right; i++) {
                if (array[i] > array[i + 1]) {
                    buff = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buff;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (array[i] < array[i - 1]) {
                    buff = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = buff;
                }
            }
            left++;
        } while (left < right);
        customArray.setData(array);
    }

    @Override
    public void CombSort(CustomArray customArray) throws CustomArrayException {
        validator.validateNotNullOrEmpty(customArray);
        int[] array = customArray.getData();
        int gap = array.length;
        boolean swapped = true;
        while (gap > 1 || swapped) {
            if (gap > 1)
                gap = (int) (gap / 1.247330950103979);

            int i = 0;
            swapped = false;
            while (i + gap < array.length) {
                if (array[i] > array[i + gap]) {
                    int buf = array[i];
                    array[i] = array[i + gap];
                    array[i + gap] = buf;
                    swapped = true;
                }
                i++;
            }
        }
        customArray.setData(array);
    }
}
