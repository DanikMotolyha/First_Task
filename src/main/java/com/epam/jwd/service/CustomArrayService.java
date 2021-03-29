package com.epam.jwd.service;

import com.epam.jwd.entity.CustomArray;
import com.epam.jwd.exception.CustomArrayException;

public interface CustomArrayService {

    int min(CustomArray customArray) throws CustomArrayException;

    int minStream(CustomArray customArray) throws CustomArrayException;

    int max(CustomArray customArray) throws CustomArrayException;

    int maxStream(CustomArray customArray) throws CustomArrayException;

    int update(CustomArray customArray, int from, int to, int ... values) throws CustomArrayException;
}
