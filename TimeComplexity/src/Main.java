
/* Complexity Theory
* Computational complexity -  is about measuring how well your algorithm scales in regard to its input size.
*
* The algorithm would then compare these arrays and output the common elements between them.
* Essentially computing the intersection.
* [3,1,4,2,7]
* [8,2,5,4,6]
* One approach to implement this would be to start processing each element from the first array, left to right.
* Then for each item in the array you compare it to every item in the second array.
* The outer loop occurs once for every element in array a. The inner loop goes through every element
* in b for every element in a.
* if statement is executed a * b. a and b being the sizes of the input arrays
* Now assuming that the input areas are the same size we can see that the algorithm performs
* n squared steps. n being the size of the array.
*  runtime complexity of big O of N squared. O(n^) - this algorithm is quadratic.
* complexity classes :
*    - Exponential O(k^n) -  have the worst scalability. Just a small increase in the input size
 *     resides in a large slowdown of performance.
 *   - Quadratic O(n^2)
 *   - Log linear O(n log n)
 *   - linear O(n)
 *   - logarithmic O(log n)
*    - Constant O(1) - offers the best scalability. No matter how large the input size gets,
*     the time taken to terminate is always the same.
* improve its runtime complexity? - intersection ?
* Imagine we further restrict our problem to accept areas only if they are sorted.
* We can make use of this ordering to improve the solution.
* The idea is to keep two pointers, one on each array, comparing the two elements.
* After the comparison we advanced the pointer of the array with the lowest value.
* O(n log n + n log n + n)
* O (2(n log n) + n) // drop the constants and keep only the highest orders.
* O (n log n)
* The solution that has the complexity class and not the problem.
* Interviu:
*       - Can I re-encode the inputs to make the algorithm faster?
*       - Can I use a better data structure.
*       - Can I fit the solution in a common design paradigm. Such as divide and conquer ...
* */

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] a = {3,1,4,2,7};
        int[] b = {8,2,5,4,6};

        int[] ints = intersection(a, b);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + ", ");
        }
        System.out.println();

        int[] intsImpr = intersectionImproved(a, b);
        for (int i = 0; i < intsImpr.length; i++) {
            System.out.print(ints[i] + ", ");
        }
    }

    /* complexity O(n log n)*/
    
    public static int[] intersectionImproved (int[] a, int[] b) {
        Arrays.sort(a); // O(a log n)
        Arrays.sort(b); // O(a log n)
        int[] intersection = new int[compare(a, b)];
        // perform a merge sort algorithm
        int index = 0;
        for (int i = 0; i < a.length - 1; i++) {
            while (b[index] < a[i]) {
                index++;
            }
            if (b[index] == a[i]) {
                intersection[i] = b[index];
            }
        }
        return intersection;
    }

    public static int compare (int[] a, int[] b) {
        if (a.length < b.length) {
            return a.length;
        }else if (a.length > b.length) {
            return b.length;
        }
        return a.length;
    }

    public static int[] intersection(int[] a, int[] b) {

        int[] intersection = new int[a.length];
        int indexIntersection = 0;

        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < b.length-1; j++) {
                if (a[i] == b[j]) {
                    intersection[indexIntersection] = a[i];
                    indexIntersection++;
                }
            }
        }
        return intersection;
    }
}