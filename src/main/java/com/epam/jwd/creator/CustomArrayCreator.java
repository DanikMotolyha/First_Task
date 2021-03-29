package com.epam.jwd.creator;

import com.epam.jwd.entity.CustomArray;

public class CustomArrayCreator {

    public CustomArray create(int... params) {
        return new CustomArray(params);
    }
}
