
/* It's partitions the array into sorted and unsorted partitions. [20, 35, -15, 7, 55, 1, 22]
* the implementation grows the sorted partition from left to right.
* So it grows a sorted partition from the front of the array.
* Well, it starts out by saying that the element position zero is in the sorted partition.
* And because this sorted partition is of length one, by default, the element is sorted.
* Coz if you have an array of length one, or a partition of length one, it's sorted, right? There's only one element.
* So at the beginning, the elements from position 1 into the right or in the unsorted partition.
* And so we're going to set a first unsorted index field to 1.
* Now on each iteration, we take the first element in the unsorted partition which will be the element
* at array of first unsorted index - OUTER LOOP
* and we insert it into the sorted partition INNER LOOP. And so at the end of each iteration
* we will have grown this sorted partition by one. And so what we'll do on the first iteration is we will take 35,
* because that's the first unsorted value. And we will insert it into the sorted partition.
* And at the end of the iteration, the first two elements in the array will be sorted.
* So how is each element inserted? -- INNER LOOP
* Well, what we do is we compare the value we're inserting with the values in the sorted partition.
* And we traverse the sorted partition from right to left, and we look for a value that is less than
* or equal to the one we're trying to insert because once we find that value, we can stop looking we have found
* the correct insertion position for the new value that we're trying to insert. Because remember, when we're inserting
* the value we are working within the sorted partition. And so if the element at index i in the sorted partition
* is less than or equal to the element we're trying to insert, then all of the values to the left of element i
* will be less than or equal to the value we're trying to insert, because all the values are in sorted order.
* So as we look for the correct insertion position, we shift values in the sorted partition to the right.
* we're going to assign 35 to a new element field because 35 is the first element in the unsorted partition.
* And then we use i to traverse the sorted partition from right to left. So we compare 35 to 20.
* Now 35 is greater than 20 so 35 is already in its correct position in the sorted partition.
* It's not in its correct position in the array, but it is in the sorted partition.
* So after the first iteration, the sorted partition has been grown to two lengths two and the first two elements
* are in their correct position. And now the first unsorted index is at index two and i is assigned one,
* because that's the right most index in the sorted partition. So we assign -15 to new element.
* And now we need to insert -15 into the sorted partition. So we compare -15 against 35 ,-15 is less than 35.
* And so we want to shift -15 down the array. is we're gonna shift 35 to the right to make room for -15.
* So now we're going to compare -15 to 20, 15 is less than 20 so we're gonna shift 20 to the right
* to make room for-15. And at this point, we've hit the front of the array so we have nothing else to compare -15 to
* basically we have the smallest element in the sorted partition and because we've hit the front of the array,
* this is where we're going to insert -15.....
* */


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] array = new int[]{20, 35, -15, 7, 55, 1, -22};

        System.out.println(Arrays.toString(insertionSort(array)));

    }

    /*we shift elements. */

    public static int[] insertionSort(int[] array) {

        for (int firstUnsortedIndex = 1; firstUnsortedIndex < array.length; firstUnsortedIndex++) {
            // save the value of the element we're going to insert into sorted partition newElement
            // do the shifting, that position, the element, is going to be overwritten.
            int newElement  = array[firstUnsortedIndex];
            int i;
            // loop traversal of the sorted partition and looks for the correct position to insert new element.
            // the element we want to insert is that first inserted index,
            //  keep looking for the insertion position as long as we haven't hit the front of the array

            for(i = firstUnsortedIndex; i > 0 && array[i - 1] > newElement; i--) {
                array[i] = array[i - 1];
            }
            array[i] = newElement;

        }
        return array;

    }
}