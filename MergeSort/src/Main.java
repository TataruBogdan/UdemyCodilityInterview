

/* merge sort is a divide and conquer algorithm because it involves splitting the array
* you wanna sort into a bunch of smaller arrays, and it's usually implemented using recursion.
* Merge sort involves two major phases.
* The first phase is the splitting phase, and second phase is the merging phase.
* We do the sorting during the merging phase. The splitting phase is a preparation phase to make sorting
* faster during the merging phase.
* Now, I wanna make it clear that the splitting is logical. We don't create new arrays when we do the splitting.
* We use indices to keep track of where the array has been split. So when during the splitting phase,
* we're not actually creating new array instances.
* The splitting phase. We start with the unsorted array, and we divide the array into two arrays,
* and remember, both of the arrays will be unsorted, and we call the first array, the left array
* and second array, the right array, and we generally just divide the array down the middle. If you have
* an odd number of elements, it will depend on the implementation. Some implementation will put the extra element
* into the left array, and some implementations will put the extra element into the right array,
* but the important point is you're dividing the array or splitting the array into two arrays,
* the left array and the right array, and then, once you've done that, you keep splitting down even further.
* So now you go to the left array, and you split that into a left and a right array, and then, you split that left array
* into a left and a right array, and you keep going, splitting all the arrays and the sub-arrays until you split
* the original array into a bunch of one-element arrays, and remember from our discussion of insertion sort,
* a one-element array is sorted by default because there's only one element in it.
* So in the splitting phase, you're taking the array,you're dividing it in half, and then, you're dividing
* the two sub-arrays in half, and you're dividing those four sub-arrays in half, etcetera, until you get down
* to a bunch of one-element arrays, and that is the splitting phase.
* Once you've done that, you're going to enter the merging phase, you're going to merge every left/right pair
* into a sorted array. So let's say we have an array of four elements
* So we're gonna split that into two sub-arrays of length two each, and then, we're gonna split those two sub-arrays
* into two arrays of one element. So from that four-element array, we're gonna end up with four one-element sub-arrays.
* So we split the original array into a left and right sub-array, and then, we split the left sub-array into left and right.
* and the right sub-array into left and right, and then what we do is we take the two one-element arrays
* from the left sub-array, and we merge them back into a two-element array. The merged two-element array will be sorted,
* so when we do the merge, that's the point when we do the sort, and then, we'll take the two elements from the
* right sub-array, and we'll merge them into a two-element sub-array. So now we have, we're back to two arrays,
* a left and a right array, except this time, the left and the right array are sorted, and then, we'll merge the
* left and right array, which are now two elements each, back into a four-element array, and at that point,
* when we do the merge, we sort, so we get a four-element array that's sorted, and we have sorted our array.
* Now the merging phase does not happen in place. It uses temporary arrays.
* So the splitting phase is in place, but we need temporary arrays to do the merge.
* Merging step  -
* we merge backwards, so we merge bottom up, and we're gonna merge sibling arrays,
* So we're gonna merge all these one-element arrays. We always merge sibling left and right, and each merged array
* will be sorted,
* we merge sibling left and right arrays,
* we create a temporary array large enough to hold all the elements in the arrays we're merging.
* So on the first round, our temporary arrays will be of length two
*  we set i to the first index of the left array, and j to the first index of the right array, and when I say left
* and right array, I mean the two arrays we're merging,
* we compare the value at the i position in left to the value at the j position in the right array, and if the value
* in the left array is smaller, we copy that to the temporary array, and we increment i by 1. If the value on the
* right array is smaller, then we copy that to the temporary array and increment j by one.
* So essentially, what we're doing is we're stepping through the left and right arrays, and we're taking the
* smallest value between the left and the right and copying it into the temporary array, and if we keep doing that,
* that temporary array will contain the values in sorted order.
* So we're gonna repeat that until all the elements in both arrays have been processed,
* at that point, the temporary array will contain the merged values in sorted order,
* one final step to do.
* Remember, we've been copying these values into a temporary array, so we then have to copy the sorted values
* back into the original input array, the one that we're sorting, at the correct positions, and so, if the left array
* is at positions x to y in the original array, and the right array is at positions y plus one to z, then after
* the copy, positions x to z will be sorted in the original array. So we're gonna overwrite what's there in
* the original array with the sorted values.
* */

/* If no doors
*       Return false
* if number behind middle door
*       return true
* else if number < middle door
*       SEARCH left half
* else if number > middle door
*       SEARCH right half
* RECURSION thinking*/

/* Pick up phone book
* Open to middle of phone book
* Look at page
* If person is on page
*   Call person
* Else if person is earlier in book
*   SEARCH left half of book
* Else if person is later in book
*   SEARCH right half of book
* Else
*   Quit*/

import java.util.Arrays;

public class Main {


    public static void main(String[] args) {


        int[] initialArray = {20, 35, -15, 7, 55, 1, -22};

        int start = 0;
        int end = initialArray.length ;

        mergeSort(initialArray,start, end);

        System.out.println(Arrays.toString(initialArray));

    }

    /*  If only one number
            Quit
        Split left half of numbers
    *   Split right half of numbers
    *   Merge sorted halves*/
    public static void mergeSort (int[] array, int start, int end) {

        // base case -> if we have array of 1 element, start equals end
        // we have one element array - sorted array - return 1 element array
        if (end - start < 2) {
            return;
        }


        int middle = (start + end) /2;
        // keep on splitting the original array until we have arrays of 1 element (sorted)

        mergeSort(array, start, middle);
        mergeSort(array, middle, end);

        merge(array, start, middle, end);

    }

    //20, 35, -15, 7, 55, 1, -22
    public static void merge(int[] input, int start, int mid, int end) {
        // is the first element in the right side and it's one greater than the last element in the left side.
        // input[mid - 1] - is the last element in the left partition.
        // input[mid] - is the first element in the right partition.
        /* Now, if the last element in the left partition is less than or equal the first element
        in the right partition that means all the elements in the left partition are less than or equal
        than the smallest element in the right partition, because both of these guys are sorted.*/
        if (input[mid - 1] <= input[mid]){
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        // hold the number of elements in the left and right partitions
        int[] temp = new int[end - start];
        // 1. step through the left and right arrays and we're gonna compare whatever is at index I,
        // in the left array, with whatever is at index J, in the right array.
        // 2. write the smaller of the two
        while(i < mid && j < end) {
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }
        /*  optimization is that
        if we have elements remaining in the left partition, we have to copy them into the temp array.
        if we have elements remaining in the right partition we don't have to do anything.*/
        System.arraycopy(input,i,input,start + tempIndex,mid- i);
        System.arraycopy(temp, 0, input, start,tempIndex);

    }



}