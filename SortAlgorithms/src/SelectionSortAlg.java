
/* selection sort algorithm.
* Now this algorithm divides the array into sorted and unsorted partitions
* And what we do is we traverse the array and we look for the largest element in the unsorted partition.
* And when we find it, we swap it with the last element in the unsorted partition.
* And at that point, that swapped element will be its correct sorted position.
* At the beginning of the algorithm, the entire array is unsorted so the last unsorted index is six
* we're going to grow the sorted partition from right to left. We're going to initialise a largest field to zero
* INNER LOOP
* so when we start we say you know what, 20 is the largest element that we know about so far,
* so whatever is at position zero will be the largest element.
* And we're going to start by comparing the element at position one to whatever is at position zero,
* We're going to use i to traverse the unsorted partition and find the largest element
* So we're going to compare 35 to 20 and we're gonna say hey, 35 is larger than 20 and because of that,
* we're going to change largest to one and then we're gonna increment i to two and we're gonna compare
* minus 15 to the largest element which is now at position one and we're gonna say well minus 15 is less than 35
* so we're just gonna increment i to three. We're gonna compare seven to the largest element which is still at
* position one. Seven is less than 35 so we just increment i to four. We're now gonna compare 55 to 35
* and 55 is greater than 35 so at this point we're going to change largest to four because the largest element
* we found so far  in the unsorted partition is at index four and we increment i to five....
* And at this point, i is equal to the last unsorted index and so we have completed our first traversal of the array.
* So we're going to swap the largest element that we found in the unsorted partition and that's at position four
* with the last element in the unsorted partition and that's at position six. swap 55 and minus 22
* 55 is in its correct sorted position and so we're gonna decrement last unsorted index to five
* and we're gonna re-initialize i to one and
* OUTER LOOP -> we're going to say the largest element in the unsorted partition
* is at position zero  repeat the process.
 *  */

import java.util.Arrays;

public class SelectionSortAlg {

    public static void main(String[] args) {

        int[] initialArray = {20, 35, -15, 7, 55, 1, -22};

        System.out.println(Arrays.toString(solutionSchool(initialArray)));
        System.out.println(Arrays.toString(solution(initialArray)));

    }

    // Bubble sort O(n^2) / Ω(n)
    /* Repeat n-1 times
    *       For i from 0 to n-2
    *           Compare every one again and again and swap them if they're out of order
    *           If numbers[i] and numbers[i+1] out if order
    *               Swap them
    *       If no swap (boolean)
    *           Quit
    *       */

    /* For i from 0 to n-1
    *       Find smallest number between numbers[i] and numbers[n-1]
    *       Swap smallest number with numbers[i] */
    public static int[] solutionSchool(int[] array) {

        for (int lastUnsortedIndex = array.length -1; lastUnsortedIndex > 0; lastUnsortedIndex--) {

            int largest = 0;

            for (int i = 1; i <= lastUnsortedIndex; i++) {
                if (array[i] > array[largest]){
                    largest = i;
                }
            }
            swap(array, largest,  lastUnsortedIndex);
        }
        return array;
    }

    public static int[] solution(int[] array) {

        int lastUnsortedIndex = array.length -1 ;
// use i to traverse the unsorted partition and find the largest element
        for (int i = lastUnsortedIndex; i > 0; i--) {
            int largest = 0; // index of the largest element in unsorted partition
            int j = 0;
            while (j <= lastUnsortedIndex){
                if (array[j] > array[largest]){
                    largest = j;
                }
                j++;
            }
            //swap the largest element that we found in the unsorted partition with the last element
            swap(array, largest, lastUnsortedIndex);
            lastUnsortedIndex--;

        }
        return array;

    }

    public static int[] swap(int[] array, int i, int j) {

        if (i == j){
            return array;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

        return array;
    }
}
