

/* Prefix sums is the process of cumulatively summing up the sequence into another one.
 From the list of numbers you have a running total producing another list.
 We have a list of integers on which we want to compute the prefix sums.
 [6, 3, 1, 7, 4, 3]
 We start with the list containing just the value of 0. And then we take the 0 and sum it up with the first item
 in our input list giving us the value of 6. Then we use this last value and sum it up with the next item in our
 input, the number 3. This gives us 9 which we sum up to 1, the next item. The result is 10.
 And we continue in this fashion, 10 plus 7 is 17, 17 plus 4 is 21, 21 plus 3
 In a similar way we can calculate this suffix sums. The suffix sums are just the reverse.
 They are the cumulative additions starting from the end of our input list.

 Suffix
 As in the prefix sums we start with the list containing just zero.
 Then we take this zero and sum it up with the last item in our input which has a value of 3.
 This gives us 3. Then we sum up 3 together with 4 giving us 7. 7 plus 7 gives
 us 14, 14 and 1 gives us 15, 15 and 3 is 18, 18 and 6 result

 Imagine for example we wanted to sum up a slice from an array of integers,
 a slice starting at position i and finishing at j.
 We can just calculate the prefix sums and store them in another array.
 Then we would just need to read the element at j plus 1 and subtract that from the element at i.
 In this example we have 21 - 6 giving us 15. This is equal to the total of all the elements in our slice.
 The prefix and suffix sums are a simple trick used in many algorithms. For example the counting sort
 which uses prefix sums is a very fast sorting algorithm that is suitable for when the input contains
 only small integers.
*/

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] A = {6, 3, 1, 7, 4, 3};

        System.out.println(Arrays.toString(prefixSum(A)));
        System.out.println(Arrays.toString(suffixSum(A)));

    }

    public static int[] prefixSum (int[] array) {

        int[] sums = new int[array.length + 1];
        Arrays.fill(sums, 0);
        int j = 1;
        for(int i = 0; i < array.length; i++) {
            sums[j] = sums[j-1] + array[i];
            j++;
        }

        return sums;
    }

    public static int[] suffixSum (int[] array) {
        int[] sums = new int[array.length + 1];

        int j = sums.length - 2;

        for (int i = array.length - 1; i >= 0 ; i--) {
            sums[j] = sums[j + 1] + array[i];
            j--;
        }

        return sums;
    }
}