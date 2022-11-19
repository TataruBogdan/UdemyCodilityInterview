package com.bogdantataru;

public class Main {

    public static void main(String[] args) {

        // Time and position of  Where and when will the leaves fall in their positions
        int[] listAOfLeaves = {1, 3, 1, 4, 2, 5, 4};
        // we have five spaces that the frog has to cross over.
        int riverDimension = 5;

//        System.out.println(solution(5, listAOfLeaves));

//        int[] listAOfLeaves1 = {1, 1, 1};
//        System.out.println(solution(1, listAOfLeaves1));

        int[] listAOfLeaves2 = {1, 2, 1};
        System.out.println(solution(3, listAOfLeaves2));
    }

    //return time when the frog can cross th river
    public static int solution(int width, int[] listOfLeaves) {

        //positions need to start at position 1
        boolean[] countArray = new boolean[width + 1];
        for (int i=0; i<countArray.length;i++){
            System.out.print(countArray[i]);
        }

        //for each time when a leave will fall in the river
        for (int time = 0; time < listOfLeaves.length ; time++) {
            int pos = listOfLeaves[time];
            // if we can't find a number in list of leaves (corresponding to timing witch is matching the place where a leave will fall)
            if (!countArray[pos]) {
                countArray[pos] = true;
                width--;
            }

             if (width == 0) {
                return time;
            }

        }
        return -1;
    }
}
