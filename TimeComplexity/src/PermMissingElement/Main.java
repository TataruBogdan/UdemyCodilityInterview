package PermMissingElement;

import java.util.Arrays;

/* Perm Missing element
* We are given a list of numbers starting from one. And in this list of numbers, we have a missing element.
* The aim of this problem is to find that missing number.
* The problem is made a little bit more difficult because the numbers are not in order.
* They can be in any arbitrary order.
* 1, 2, 3 4 5 7 8 9
* 6 is missing
* get arbitrary input 2 4 7 8 1 5 3
* input to our function We are given an array of size n and in the range of each element in this array or list
* is between one and n + 1 - [1, n + 1] from this range and the input we simply need to find the missing number.
* [2, 3, 1, 5]  - n the size of our array is 4 n -> [0....100k]
*  0  1  2  3
* the range is between one and five because n plus 1 is, of course
* write a function called solution(a) a - Is this array, this area of numbers
* - Can I re-encode the inputs to make the algorithm faster?
 *       - Can I use a better data structure.
 *       - Can I fit the solution in a common design paradigm. Such as divide and conquer ...*/
public class Main {

    public static void main(String[] args) {

        int[] a = {2, 4, 7, 8, 1, 5, 3};
        int[] b = { 1, 2, 3, 4, 5, 6, 7, 8, 9};


        //System.out.println(solutionMy(a));
        System.out.println(solutionSchoolMy(a));
        System.out.println(solutionSchoolMy(b));
        System.out.println(solution(b));
    }


    public static int solution(int[] A) {
        long actualSum = 0;
        for (int number: A) {
            actualSum += number;
        }
        long maxNumber = A.length + 1;
        long expectedSum = (maxNumber * (maxNumber + 1) / 2);
        return (int) (expectedSum - actualSum);
    }

    /* solution: We have all been out in a restaurant, maybe with family or friends.
    * And sometimes when you go with a large group of people to a restaurant, there might be one person that
    * decides not to pay his bill. So imagine in this example, every single person at the table has ordered
    * an item from the menu that costs the friend amount of money, just like this example that I have on the slide.
    * Eventually, the bill arrives. Everyone puts the money on the table except that one person that decides not to pay.
    * But then you realize that there is a problem, right? You don't have enough money to pay with the bill.
    * There is a system here that you can tell who hasn't paid because everyone has ordered a different item
    * on the menu that costs different money. You can determine the person that hasn't paid.
    * If you manage to figure out how to find the person that hasn't paid. you will be able to come up
    * with an algorithm for the original problem that doesn't use any memory or in fact, uses constant
    * memory instead of linear.
    * adun toti banii de pe masa - valoarea fiecarui prieten
    * index-ul este index+1 - range of each element
    * Triangular numbers is that you can get the same amount of objects and arrange them in a way that will
    * form an equilateral triangle. */

    public static int solutionSchoolMy(int[] a) {

        long actualSum = 0; // range of each element n + 1
        long totalValue = 0;
        long expectedSum;
        for (int i = 0; i < a.length; i++) {
            actualSum += (i+1);
            totalValue += a[i];
        }
        expectedSum = (actualSum + (a.length + 1)) - totalValue;
        return (int) expectedSum;
    }


    //return the missing element from the sequence of the array elements
    public static int solutionMy(int[] a) {
        // the array is not ordered array
        Arrays.sort(a);
        int missingElement = Integer.MIN_VALUE;
        //  n the size of our array
        for (int i = 0; i < a.length; i++) {
            // 6 is missing
            if (!(a[i] == i + 1)){
                missingElement = i + 1;
                break;
            }
        }
        return missingElement;
    }

    /* data structure will let us store which numbers we have processed and which we haven't.
    * We could just instead create an array with size n + 2
    * So, for example, if we have an input array of four, we create a array of size six.
    * And we use this as a lookup table - because we start with value of element 1 not 0
    * And the way this would work is we would start from position zero.
    * We read the value, add that position, which in this example is two.
    * And we mark in our reference area that particular position.
    * This will tell us that the number two is present in our input.
    * at the end we do is scan this array We just loop through it one time and we find that
    * the one that hasn't been marked in this case, it is the number four in this algorithm.
    * runtime complexity -> n + n + 2 -> O(n)
    * because we have an input of size N And the reference array(presentNumbers) which is.n + 2
    * we are using quite a bit of memory we are creating this extra structure, which has a size of N + 2
    * Constants using order and memory  O(n) Our memory consumption will grow linear with our inputs.*/
    public static int solutionHint(int[] a) {
        boolean[] presentNumbers = new boolean[a.length + 2];

        for (int i = 0; i < a.length; i++) {
            int currentValue = a[i];
            presentNumbers[currentValue] = true;
        }
        for (int j = 1; j < presentNumbers.length - 1; j++) {
            if (!presentNumbers[j]){
                return j;
            }
        }
        return 0;
    }

    // runtime complexity -> (n + 1)n = n^2 + n - O(n^2)
    // memory - not creating any other structure that increases with the size of our inputs.
    // consuming a constant amount of memory. O(1)
    // It doesn't matter how large our input is, the amount of memory that we use does not vary.
    public static int solutionBruteForce(int[] a) {

        // (n + 1) - steps
        for (int i = 0; i < a.length; i++) {
            boolean found = false;
            // n -steps
            for (int j = i; j < a.length - 1; j++) {
                if (a[i] == a[j]) {
                    found = true;
                }
            }
            if (!found) {
                return i;
            }
        }
        return 0;
    }
}
