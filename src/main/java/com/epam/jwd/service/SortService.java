package com.epam.jwd.service;

import com.epam.jwd.entity.CustomArray;
import com.epam.jwd.exception.CustomArrayException;

public interface SortService {

   void bubbleSort(CustomArray customArray) throws CustomArrayException;

   void shakeSort(CustomArray customArray) throws CustomArrayException;

   void CombSort(CustomArray customArray) throws CustomArrayException;

}
