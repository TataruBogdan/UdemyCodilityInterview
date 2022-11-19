package com.bogdantataru;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Arrays.sort;

public class Solution {



    public static void main(String[] args) {

        int[] array = {2, 3, 1, 5};

        //System.out.println(solution(array));

        System.out.println(solution2(array));

    }


    public static int solution(int[] A) {

        int sum = 0;
        for (int x = 1; x <= A.length + 1; x++){
            sum = sum + x;
        }


        int value = 0;
        for (int i : A) {
            value += i;
        }

        return sum - value;

    }

        public static int solution2(int[] A) {

            int lastElement = A.length + 1;

            int sum =  (lastElement * (lastElement+1)) / 2;

            int value = 0;
            for (int i : A) {
                value += i;
            }

            return sum - value;





        }
}
