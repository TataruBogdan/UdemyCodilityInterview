package CyclicRotation;

import java.util.Arrays;

/* we are given an input array where we need to perform a cyclic operation on this array.
A cyclic operation is simply shifting every single item of the list to the right.
The number of cyclic rotations that we need to do is determined by the second parameter.
In this problem the second parameter is named as the variable k.
What we mean by cyclic rotation is that every item in our list shifts to the right.
[5, 7, 2, 8, 3] becomes [3, 5, 7, 2, 8] This is a cyclic rotation of one step.
K is the number of cyclic rotations that we need to perform. k = 1
k = 1 -> [8, 3, 5, 7, 2]
*/
public class Main {

    public static void main(String[] args) {

        int[] a = {5, 7, 2, 8, 3};
        int k = 2;

        System.out.println(Arrays.toString(a));


        int[] arrayWithCycles = solution(a, k);

        System.out.println(Arrays.toString(arrayWithCycles));

        int[] arrayWithCyclesSchool = schoolSolution(a, k);

        System.out.println(Arrays.toString(arrayWithCyclesSchool));
    }

    /* cyclic rotation. This problem is quite hard to solve unless you know a very simple trick.
    * remainder trick : Imagine we have a number in this example we have 501 and we divide it by 2.
    * It's going to give us 250 with a remainder of 1. 501 divided by 10 is going to give us 50
    * with a leftover of 1. Let's pick another example of 509 divided by 10. It's going to give
    * us 50 remainder 9. 510 divided by ten - This gives us 51 leftover 0 -  509 % 10 == 9
    * Basically here the idea is that the remainder can never be greater than the divider.
    * If we're dividing by 10 we cannot have a leftover of 11 or 12 or even 10.
    * The biggest number that we can get is 9. So the range is always between 0 and 9 if we are dividing by 10.
    * The way to extract the remainder from a division operation is to use the modulus operator %
    *
    * construct a new array of the same size (size 5) and start iterating through every single item
    * in the original list. At each position we perform in this simple operation:
    * (0+2) % 5 - k= 2, size = 5
    * We get the index of the item we add it to K and we mod it by the size.
    * whenever you need to do any wrapping around think about Pacman but also think about
    * using the modulus operator because it gives you this in an easy way to implement.
    * In fact the modulus It is used in the circular buffers and also in hashing algorithms.*/
    public static int[] schoolSolution(int[] A, int k ) {


        int[] newArray = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            newArray[(i + k) % A.length] = A[i];
        }

        return newArray;
    }

    // a - our input array
    // k number of cycling rotation to perform on this array.
    // return an array , with content rotated by k times to the right
    // O(n) - O(n)
    public static int[] solution(int[] a, int k) {

        while (k > 0) {
            int len = a.length - 1;
            int lastElement = a[len];
            for (int i = a.length - 1; i > 0 ; i--) {
                swap(a, i-1, i);
            }
            a[0] = lastElement;
            k--;
        }
        return a;
    }

    public static void swap (int[] a, int previousElement, int currentElement) {

        if(currentElement != previousElement) {
            int temp = a[currentElement];
            a[currentElement] = a[previousElement];
            a[previousElement] = temp;
        }


    }

}
