package com.epam.jwd.entity;

import java.util.Arrays;

public class CustomArray {
    int[] data;

    public CustomArray(int[] a) {
        data = a;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return super.toString() + " data: " + Arrays.toString(data) +  " length: " +
                data.length;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        CustomArray customArray = (CustomArray) obj;
        return customArray.data == this.data;
    }
}
