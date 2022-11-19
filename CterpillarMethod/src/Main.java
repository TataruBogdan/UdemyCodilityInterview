
/* Caterpillar method
* the problems that you encounter in this lesson use kind of technique that resembles the movement of a caterpillar.
* I have a list of numbers
* [ 2, 4, 1, 7, 3, 9, 6, 3, 2, 5, 8, 7, 1]
*   |           |
* back        front
* in the Caterpillar method - We have two pointers
* We have a front and the back and we typically only operate on the numbers between the back and the front.
* The manner in which we move the back and front pointer resemble kind of the movement that's a caterpillar
* would do with its head and its tail the head would be at the front and the tail would be at the back.
* And we can perform certain operations on the numbers between the back and the front and the output certain
* results depending on the problem that we're trying to solve.
* Use a - sliding window - a technique that puts a window in front of your list of items or a list of numbers.
* And typically you operate only on the items within that window the window as you guessed also has a
* front and the back pointer and it can also be variable.
* Concept of a moving average.
* we can smooth this noise is to use what is called moving average.
* trend line over a year - giving me a linear trend line or moving average trend line.
* Period = 15 days is our average window size.
* increasing this period makes it smoother and reducing it makes it follow more the original data.
* The way to calculate this moving average you can make use of an algorithm that makes use of sliding
* Just like in the Caterpillar method we have a back and the front pointer and our sliding window is all
* the numbers in between the back and the front pointer and in the moving average we simply calculate
* the total of all of these numbers. We divide by 5 The variable 5 is the same period variable
* You can change that depending on whether you want it smooth or more matching the original data.
* Once you calculate the average you move both back and front pointer forward.
* And you do this again you calculate the total and you calculate the average well
* you can do as a shortcut and optimization is that you get the 17 you add 9 to it and subtract 2 from it.
* The back pointer and different points are valuable.
* *[ 2, 4, 1, 7, 3, 9, 6, 3, 2, 5, 8, 7, 1]
 *   |              |
 * back           front
 * The average is up here would represent the moving average results.
 * You can plot these, and they will give you a smooth her line in the moving average algorithm.
 * This sliding window the size of the sliding window is fixed right. We just move it along the list of numbers
 * we never vary the size of it.
 * The caterpillar method is a little bit more flexible than that right because the back and the front pointer
 * move independently.
 *
 * Imagine in a clothing interview you were asked to write some code that would accept a list of numbers
 * and calculate whether that list of numbers has a sub array totalling exactly a specific amount
 * [ 2, 4, 1, 7, 3, 9, 6, 3, 2, 5, 8, 7, 1]
 * try to find out whether this list contains a sub array totalling 16.
 * A subarray is a sub portion of our list of our array - It needs to be continuous
 * tail and the head the pointer starting at position 0 one item between the back and the front pointer
 * we have one item the total will be the value of that item.
 * if our sum is less than the total that we want to find the value of 16 we move the front pointer forward
 * and after we move we just update our total. In this case we just need to add 4 so 4 plus 2 gives us 6
 * is again smaller than 16. So again we move the front pointer we add 1 to 6 giving us 7 and
 * 7 again is smaller than 16. So we move the front pointer forward we add 7 to 7 giving us 14
 * 14 is smaller than 16 we move the front pointer forward again and we add 3 giving us 17 now
 * 17 is actually bigger than 16 We exclude two from our window right.
 * we need to subtract 2 from it and now 15 again is smaller than 16.
 * So we advance the front pointer at 9 and giving us 24, 24 is now bigger than 16
 * so we move the back pointer etc
 *
 * */

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] a = {2, 4, 1, 7, 3, 9, 6, 3, 2, 5, 8, 7, 1};

        System.out.println(Arrays.toString(solutionMy(a, 16)));


    }

    // find the value inside our array
    public static int[] solutionMy (int[] array, int value) {

        // need to create the subarray from the original array
        // subarray has a start and an end pointers
        // the start and the end starts initially at 0
        int start = 0;
        int end = 0;
        // take the value at position initial
        // if the total value at position is smaller the value increment end
        // if the total value at position is bigger than the value increment start
        int totalValue = array[start];

        int[] returnArray = {};

        while(end < array.length - 1 ) {

            if (totalValue > value) {
                totalValue -= array[start];
                start++;
            } else {
                end++;
                totalValue += array[end];
            }
            if (totalValue == value) {
                return Arrays.copyOfRange(array, start, end + 1);
            }
        }
        return returnArray;
    }
}