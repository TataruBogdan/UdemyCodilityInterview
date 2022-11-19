import java.util.Arrays;

public class MergeSortMy {


    public static void main(String[] args) {

        int[] array = {20, 35, -15, 7, 55, 1, -22};

        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }


    public static int[] sortSimple(int[] array, int l, int r) {


        // if our array contains one element - sorted array
        if (l == r){
            return array;
        }

        // if our array contains two elements
        if (array[l]  <= array[r]) {
            return array;
        } else {
            int temp = array[l];
            array[l] = array[r];
            array[r] = temp;
        }
        return array;
    }

    public static int[] merge (int[] arrayLeft, int[] arrayRight) {

        //create return array
        int l = arrayLeft.length + arrayRight.length;
        int[] resultArray = new int[l];

        int i = 0; // pointer for left array
        int j = 0; // pointer for right array
        int k = 0; // pointer for result array

        while(i < arrayLeft.length && j < arrayRight.length) {
            // compare the values from the two array
            if (arrayLeft[i] <= arrayRight[j]) {
                resultArray[k] = arrayLeft[i];
                i++;
            } else {
                resultArray[k] = arrayRight[j];
                j++;
            }
            k++;
        }
        /* if we have numbers in the left array
        copy the left over from the left array if eny */
        if (i < arrayLeft.length) {
            System.arraycopy(arrayLeft, i,resultArray,k , arrayLeft.length - i);
        }

        // check to see if srcPos and destPos are correct ?
        if (j < arrayRight.length) {
            System.arraycopy(arrayRight, j,resultArray, k, arrayRight.length - j);
        }

        return resultArray;
    }

    // de modificat - ori creez in mergeSort doua noua array-uri left and right
    // de fiecare data cand se apeleaza mergesort - pentru ca trbuie sa injumataesc array-ul principal
    // si apoi sa creez doua array-uri pana ajung la base case ??
    // practic creez doua array-uri cu elem de ala l pana la r
    //
    public static int[] mergeSort(int[] array, int l, int r) {

        if ((r == l) || (r == l + 1)){
            return sortSimple(array, l, r);
        }

        int range = r - l + 1;
        int m = l + (int) (range / 2);

        //
        int[] arrayLeft = mergeSort(array, l, m - 1);
        int[] arrayRight = mergeSort(array,m , r);

        return merge(arrayLeft, arrayRight);
    }



}
