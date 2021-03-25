package com.epam.jwd.service.impl;

import com.epam.jwd.entity.Massive;
import com.epam.jwd.service.MassiveService;

public class MassiveServiceImpl implements MassiveService {
    @Override
    public int min(Massive massive) {
        int min = massive.getData()[0];
        for(int value : massive.getData()){
            if(value < min){
                min = value;
            }
        }
        return min;
    }

    @Override
    public int max(Massive massive) {
        int max = massive.getData()[0];
        for(int value : massive.getData()){
            if(value > max){
                max = value;
            }
        }
        return max;
    }

    //TODO add exceptions for if
    @Override
    public int update(Massive massive, int from, int to, int... values) {
        int length = Math.abs(Math.abs(from) - Math.abs(to));
        if(from < 0 || to < 0
                || from > to
                || values.length != length
                || massive.getData().length < to){
            return 0;
        }
        int[] mas = massive.getData();
        for(int i = from, j = 0; i < to; i++){
            mas[i] = values[j++];
        }
        massive.setData(mas);
        return length;
    }
}
