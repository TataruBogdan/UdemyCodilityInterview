
/* We are given an input list of numbers and these numbers can be negative or positive integers.
 * And we need to find two of these numbers represented over a year by the Pointer P and Q such that when
 * you sum the value at P and the value at Q, you get a result.
 * And if you put that result into an absolute function, the result will be at a minimum.
 * Basically we need to find a pair from these numbers that when you sum them together, the absolute value
 * is at a minimum.
 * [ 1, 4, -3]
 *   0  1  2        value @P    1
 *  |   |          +value @Q    1
 *  P   Q          |result|     2
 * Let's say we start from P and Q at index zero. So basically we are choosing P and Q to be the value of one,
 * and if we sum them together, we get the result of two.
 * The absolute value of two is, of course, to remember that the absolute function simply changes
 * a negative value into a positive one.
 * Let's say P is at zero and Q is that one and 1 plus 4 gives us 5 and the absolute of 5 is 5
 * Move Q one more position and now we have 1 and -3 three. If you sum them up they give you -1 and
 * the absolute value of -2 is 2.
 * Now we put P and Q both at index position 1 which gives us 4 + 4. This gives us 8.
 * The absolute value of 8 is of course 8.
 * And again, we move, the pointer is P is at 1 and Q is at 2. If we summon these two together,
 * 4 and -3 gives us 1, the absolute value of 1 is 1.
 * And let's try the last combination, which is P and Q both at index position 2 this gives us -3 + -3
 * resulting in -6 and an absolute value of 6.
 * return the minimum out of all of these is the value of 1.
 *
 * */

import java.util.Arrays;
import java.util.IllegalFormatCodePointException;

public class MinAbsSum {


    public static void main(String[] args) {

        int[] a = {-8, 4, 5, -10, 3};
        int[] b = {1, 4, -3};
        int[] c = {-7, 3, -1, 5, -11, 4, -9, 14, -2, 6 };

        //System.out.println(solution2(a));
        System.out.println(solution2(c));
    }

    // return min absolute sum of two
    // CPU O(n log n) MEM O(1)
    // [-10, -8, 3, 4, 5]

    // the minAbsValue is the smallest negative number - biggest positive number
    // -8 + 5 = -3 Abs(-3) = 3
    public static int solution2(int[] array) {

        /*int smallestNegNumber = Integer.MAX_VALUE;
        int biggestPosNumber = Integer.MIN_VALUE;*/
        Arrays.sort(array); // O(n log(n))

        // int mid = array.length / 2;
        // int indexLastNumber = array.length - 1;

        int q = array.length -1;
        int p = 0;


        int minAbsSum = Integer.MAX_VALUE;


        while (q >= p) {

            if (array[p] == 0 || array[q] == 0) {
                return 0;
            }

            int absSum = Math.abs(array[p] + array[q]);
            if (absSum < minAbsSum) {
                minAbsSum = absSum;
            }
            if (Math.abs(array[p]) > array[q]){
                p++;
            } else {
                q--;
            }
        }
        return minAbsSum;
    }

        // O(n^2)
        public static int solution1 ( int[] array){

            int minAbsSum = Integer.MAX_VALUE;

            for (int i = 0; i < array.length; i++) {
                int j = i;
                while (j < array.length) {
                    int absSum = Math.abs(array[i] + array[j]);
                    if (absSum < minAbsSum) {
                        minAbsSum = absSum;
                    }
                    j++;
                }
            }
            return minAbsSum;
        }
}
