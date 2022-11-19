package com.bogdantataru;

import java.util.Arrays;

public class MergeSort {

    // sort an array with 1 or two elements
    public static int[] sortSimple(int[] input) {

        if (input.length == 1) {
            return input;
        }

        if (input[0] < input[1]) {
            return input;

        } else {
            int temp = input[0];
            input[0] = input[1];
            input[1] = temp;
        }
        return input;
    }

    // use mergeSort Algorithm
    public static int[] mergeSort(int[] array, int start, int end) {

        if (end == start || end == start + 1) {
            //TODO - array[left : right]
            return sortSimple(array);
        }

        int range = (end - start) +1; // range = n + 1
        int mid = range / 2 ;

        //TODO - FIX FOR THE SECOND ARRAY - RANGE =3 MID = 4 ???
        int[] leftArray = Arrays.copyOfRange(array,start , mid);
        int[] rightArray = Arrays.copyOfRange(array,mid,range);

        for (int i = 0; i < mid; i++) {
            leftArray[i] = array[i];
        }

        for (int i = mid; i < range; i++) {
            rightArray[i - mid] = array[i];
        }

        leftArray = mergeSort(leftArray, start, mid-1);
        rightArray = mergeSort(rightArray, mid, end);

        return merge(leftArray, rightArray);
    }

    public static int[] merge(int[] arrayLeft, int[] arrayRight) {

        int arrayLeftSize = arrayLeft.length;
        int arrayRightSize = arrayRight.length;

        int i = 0;
        int j = 0;
        int k = 0;

        int[] arrayResult = new int[arrayLeftSize + arrayRightSize];

        while (i <= arrayLeftSize - 1 && j <= arrayRightSize - 1) {

            if (arrayLeft[i] <= arrayRight[j]) {
                arrayResult[k] = arrayLeft[i];
                i++;
            } else {
                arrayResult[k] = arrayRight[j];
                j++;
            }
            k++;
        }

        if (i > arrayLeftSize-1) {
            System.arraycopy(arrayRight, j, arrayResult, k, arrayLeftSize -j-1);
        }

        if (j > arrayRightSize-1) {
            System.arraycopy(arrayLeft, i, arrayResult, k, arrayRightSize -i-1);
        }


        return arrayResult;


    }


}
