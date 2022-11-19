

/* we have a two way road with some cars travelling to the west and some cars travelling to the east.
And the aim of this problem is to count the number of times opposite facing cars pass each other.
So the cars start moving and immediately two of the cars going west are in line with two other cars going east.
So we can add 2 to the total number of counts and we continue.
Again we have another car passing another one. So we add the pass count to 3.
Continuing further we have again another car passing another one. So now we have pass count of 4.
And again this happens once more with the last two cars passing each other bringing up the total number
of pass counts to 5. In this problem the cars going to the west are encoded with a number of 1
and the cars going east have a number of 0.
The idea here is that we put all of these numbers into an array and use it as an input to our solution.
[0, 1, 0, 1, 1] - input variable, this array  of 0 and 1 containing a length of n.
return the count of the passing car pairs
If the number of passing cars exceeds 1 billion we need to return -1.
CPU O(n) MEM O(n)

* */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PassingCars {


    public static void main(String[] args) {

        int[] A = {0, 1, 0, 1, 1};

        //int passingCars = solution(A);
        //System.out.println(passingCars);

        int school = suffixSolution(A);
        System.out.println(school);
    }

    /* for every car going in one direction you need to calculate how many cars
    * are going in the opposite direction that are in front of it.
    * This can be done by using the prefix sums.
    * We can for example compute the prefix sums over here we start with a zero the prefix sum array
    * always starts with a zero then the first one is zero plus zero.
    *    [0, 1, 0, 1, 1] input
    * [0, 0, 1, 1, 2, 3] prefix
    * If we need to find out how many cars are going to the west direction from a particular position
    * we just need to calculate all the ones that are in front of a particular place
    * find the next element in the prefix sum so if you are at i zero you find the prefix sum of i 1 which is a 0.
    * Then you subtract that from the end element which is a 3. 3 - 0 gives us 3
    * we have i at position 2. So we check the prefix sum at position 3 which is a 1 and we subtract
    * that 1 from 3 so 3 - 1 gives us 2.
    *  If we sum these up the result is 5 which is the solution to our input problem.
    *
    * use the suffix sums instead of the prefix. We can calculate the suffix sum of the input starting
    * [0, 1, 0, 1, 1] input
    * [3, 3, 2, 2, 1, 0] suffix
    * from the other side with a zero and then having zero plus 1 giving
    * us 1, then 1 plus 1 giving us 2, 2 plus 0 giving us 2, 2 plus 1 giving us 3 and so on 3 plus 0 giving us also 3.
    * And using a suffix sum array is even easier because all we need to do to find out how many cars are
    * in front of us for example from position 0 we just need to check also the suffix array at position 0,
    * which in this example is also 3. Over here at position 2 we also need to check the suffix array at position 2
    * which happens to be 2 and 3 plus 2 also gives us 5; the same solution as if we were using the prefix*/


    public static int suffixSolution(int[] A) {

        int[] suffix = new int[A.length + 1];
        Arrays.fill(suffix, 0);
        int count = 0;

        for (int i = A.length - 1; i >= 0; i--) {
            suffix[i]= suffix[i+1] + A[i];

        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                count += suffix[i];
            }
        }

        return count > 1000000000 ? -1 : count;
    }



    // return count of passing cars pairs
    // result  + optimization O^n ? - better ?
    // hint -
    // wherever you are in the array you just have to count the number of cars that are oncoming in the opposite direction.
    // problem is to calculate how many cars are in front of each car in order n time. CPU O(n)
    /*   1    1   1
    0     0*/

    // key value pair
    // O key - value is each time found a 1 value increment
    public static int solution(int[] array) {

        int count = 0;

        Map<Integer, Integer> passingCars = new HashMap<>();

        // if a car is going west has 1
        // if a car is going east has 0

        // need to traverse the array
        // for each car
        // if direction is east a[0] == 0
        // go and check if the are cars int the array that have opposite direction a[1] == 1
        for (int i = 0; i < array.length; i++) {
            //int j = array.length - 1;
            // we count if the car going east is passing opposite car coming from west
            // start from index 0 and if the next car encountered has a value of 1
            // if value of the cars is opposite 0 - 1 then count++
            /*if (array[i] == 0){
                while (j > i) {
                    if (array[j] - array[i] == 1) {
                        count++;
                    }
                    j--;
                }
            }*/
            // solution O(n) - 90 %
            if (array[i] == 0) {
                if (!passingCars.isEmpty()) {
                    int value = passingCars.get(0);
                    passingCars.put(array[i], ++value);
                } else {
                    passingCars.put(array[i], 1);
                }

            }
            if (array[i] == 1) {
                int tempCount = 0;
                if (!passingCars.isEmpty()) {
                    tempCount = passingCars.get(0);
                }
                count += tempCount;
            }

        }
        return count > 1000000000 ? -1 : count;
    }



}
