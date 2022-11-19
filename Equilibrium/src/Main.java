
/* we are given an input array containing n items and the aim of this problem is to find the point in this array.
 * We call it point P or the pivot if you like that divides the array into two.
 * It is divided into a left and right part. The left part is every item contained before P.
 *   <-  n  ->
 * [3, 1, 2, 4, 3]
 *  0  1  2  3  4
 * left   p  right
 * In this example here on this slide when P is at index position number 2 the left side contains the item
 * 3 and 1, the items at the index position 0 and 1.The right part contains the item starting at P up till
 * the end of the array. In this example the right part contains the item 2, the item 4 and the item 3.
 * When P is at index position 2 the right part contains all the items at the index position 2, 3 and 4 in this example.
 * The aim of this puzzle is to find the point where the left and the right part of the array are in balance.
 * What we mean by that is when you sum the left part of the array and you sum the right part of the array
 * the difference between those two sums is at a minimum. And keeping with the same example,
 * if we sum the left part over here we get a result of 4 and if we sum the right part (the 2, the 4 and
 * the 3) we get a result of 9. When we see the absolute difference between those two it gives us 5, right,
 * so 4 minus 9 gives us minus 5 and when we do the absolute of that it gives us the result of 5.
 * The aim, as I said before, is to divide the array in a way where this result where this absolute difference is
 * at a minimum. What we need to return in our function is the absolute difference between the left and the right
 * when this is at a minimum.
 * The size of the array can be in the range between two elements and 100.000 elements [2, 100.000]
 * each item in this array is in the range between negative 1.000 and positive 1.000.
 * solution O(n), O(n) */



public class Main {

    public static void main(String[] args) {

        int[] arrayA = {3, 1, 2, 4, 3};

        //System.out.println("Absolut difference: " + solutionMy(arrayA));
        System.out.println("Absolut difference: " + solutionHint(arrayA));
    }

    //  a is the input array of size n and we need to return the absolute difference between the left and the right
    // where this difference split by the pointer P is at a minimum.

    /* re-encode the problem.
    * hint for you to be able to solve this problem is to think about scales.
    * All right I'm talking about the old school type of scales here where they have a left and the right
    * cup where he can put weights on top of them.
    * And in this analogy the weights are the actual values of each item in our array.
    * If you have a value of 1 you assign it a weight of 1 a value of 3 weight of 3. The negative value
    * you assign it something that has a negative weight. In this example I have put here a helium balloon.
    * The scales represent the left and the right part of our array. We would place each value of the left
    * and the right parts of the array on these scales and then you would measure the difference between the left
    * and the right side. Whenever the difference is at the minimum you have the index of the array that you have
    * to return.*/

    public static int solutionHint(int[] a) {

        int valueArrayLeft = a[0];
        int valueArrayRight = 0;

        for (int i = 1; i < a.length; i++) {
            valueArrayRight += a[i];
        }

        long difference = Math.abs(valueArrayLeft  - valueArrayRight);

        for (int i = 1; i < a.length - 1; i++) {
            valueArrayLeft += a[i];
            valueArrayRight -= a[i];
            int currentDifference = Math.abs(valueArrayLeft  - valueArrayRight);
            if (currentDifference < difference) {
                difference = currentDifference;
            }

        }
        return (int) difference;


        /*for (int i = start; i < pointer; i++) {
            valueArrayLeft += a[i];
        }
        for (int j = pointer; j < a.length; j++) {
            valueArrayRight += a[j];

        }*/

    }


    // not very efficient
    /* because if we're iterating for every value of P that gives us another n and n times n would result
    in an algorithm that performs quadratic in an order of n squared. O(n^2)*/
    public static int solutionMy(int[] a) {

        int absoluteDifference = Integer.MAX_VALUE;

        int start = 0;
        int end = a.length;

        for (int p = 1; p < a.length; p++) {

            int minDifference = Math.abs(sum(a, start, p) - sum(a, p, end));

            if (minDifference < absoluteDifference) {
                absoluteDifference = minDifference;
            }
        }
        return absoluteDifference;
    }

    public static int sum(int[] array, int start, int end) {

        int arraySum = 0;
        for (int i = start; i < end; i++) {
            arraySum += array[i];
        }
        return arraySum;
    }

}