package com.epam.jwd.service.impl;

import com.epam.jwd.entity.CustomArray;
import com.epam.jwd.service.MassiveService;

public class MassiveServiceImpl implements MassiveService {
    @Override
    public int min(CustomArray customArray) {
        int min = customArray.getData()[0];
        for(int value : customArray.getData()){
            if(value < min){
                min = value;
            }
        }
        return min;
    }

    @Override
    public int max(CustomArray customArray) {
        int max = customArray.getData()[0];
        for(int value : customArray.getData()){
            if(value > max){
                max = value;
            }
        }
        return max;
    }

    //TODO add exceptions for if
    @Override
    public int update(CustomArray customArray, int from, int to, int... values) {
        int length = Math.abs(Math.abs(from) - Math.abs(to));
        if(from < 0 || to < 0
                || from > to
                || values.length != length
                || customArray.getData().length < to){
            return 0;
        }
        int[] mas = customArray.getData();
        for(int i = from, j = 0; i < to; i++){
            mas[i] = values[j++];
        }
        customArray.setData(mas);
        return length;
    }
}
