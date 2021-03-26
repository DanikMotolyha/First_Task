package com.epam.jwd.entity;

import com.epam.jwd.exception.CustomArrayException;

import java.util.Arrays;

public class CustomArray {

    private int[] data;

    public CustomArray() {
        data = new int[]{};
    }

    /**
     * or int ... data
     */
    public CustomArray(int[] data) {
        this.data = Arrays.copyOf(data, data.length);
    }

    public int[] getData() {
        return data != null ? Arrays.copyOf(data, data.length) : null;
    }


    public void setData(int[] data) {
        this.data = Arrays.copyOf(data, data.length);
    }

    public int getElement(int index) throws CustomArrayException {
        if (index <= 0 || index > data.length) {
            throw new CustomArrayException("index is not correct or array is empty");
        }
        return this.data[index];
    }

    public void setElement(int index, int element) throws CustomArrayException {
        if (index < 0 || index > data.length) {
            throw new CustomArrayException("index is not correct");
        }
        this.data[index] = element;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = result + 10 * (data != null ? data.length : 0);
        return result;
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
        return Arrays.equals(customArray.data, this.data);
    }

    @Override
    public String toString() {
        return " data: " + Arrays.toString(data);
    }
}
