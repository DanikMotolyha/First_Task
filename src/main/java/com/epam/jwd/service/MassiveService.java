package com.epam.jwd.service;

import com.epam.jwd.entity.CustomArray;

public interface MassiveService {

    int min(CustomArray customArray);

    int max(CustomArray customArray);

    int update(CustomArray customArray, int from, int to, int ... values);
}
