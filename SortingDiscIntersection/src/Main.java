

/* In this problem will have a number of disks all lying on the same y axis.
* Just having a different center each. In this example over here we have three circles one at center 0
* the other one at center 3 and the other one at center 5. And they have different radius as these two have
* a radius of one.And this one has a radius of zero.
* We are given a number of these disks and we need to find the number of intersections.
* More specifically we need to find the pairs of different intersections.
* For example using this current scenario we have the red one intersecting with this orange one.
* So here we have an intersecting pair counting as one.
* If we enlist all the different colors that we have and we start from each one of them we see that the orange
* one intersects with all the other disks that we have, intersects with five different ones.
* The yellow one intersects also with four. In the second set over here would not include the orange one again
* because the intersection is already represented in this relationship over here. So we can omit the orange one from this set.
* The blue one is intersecting with the red and the green one. Again we are omitting once we've already specified for
* example the green one is also intersecting with the yellow one. However we don't need to specify it again here.
* And the other three are not intersecting again with anything else.
* Their intersections are already represented in these three sets.
* If we count the sizes of these three sets we end up with a total of 11 and 11 would be the answer to this particular
* example.
* Let's now have a look at how this problem is encoded so we can write the algorithm to solve it.
* The input will be just an array containing integers.
* [1, 5, 2, 1, 4, 0] <- RADIUS
*  0  1  2  3  4  5  <- POSITION
* Each integer in this array represents the radius of a particular disk and the index position represents the x
* position on our x axis.
* Solution accepting one parameter, a parameter name a. The input parameter is the array that we have just seen
* in the previous slide containing n elements.
* We need to return the count of intersection first just as we have shown in the previous example.
* If the count is bigger than 10 million we need to return -1.
* solution - O(n log n)
 * */

/* disc log event
* The idea over here is that at every start and end position of each disc we create an event
* or a log saying that a disk has started or disk has ended.
* So for example we say that at disc has been added Okay we are representing this with a blue arrow.
* Over here we also have another starting disc, again another blue arrow and two more over here, the yellow and the blue.
* Over here a disc has finished it is the ending position of that disc and we represent this and this diagram
* with a red arrow. Over here another starting disc, another blue arrow over here two discs that have
* finished at position 4 meaning two red arrows. This one over here having a radius of zero has both
* starting and ending at the position 5.
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    private static ArrayList<int[]> listDiscs = new ArrayList<>();

    public static void main(String[] args) {

        int[] array = {1, 5, 2, 1, 4, 0};

        createDiscs(array);

        for (int[] disc : listDiscs ) {
            System.out.println(Arrays.toString(disc));
        }
        // need to sort the arrays from list of discs
        SortDiscs(listDiscs);

        System.out.println();
        for (int[] disc : listDiscs ) {
            System.out.println(Arrays.toString(disc));
        }

        for (int[] disc : listDiscs) {
            int start = disc[0];
            int end = disc[disc.length - 1];


        }
    }

    // return the numbers of intersections
    // input array with disc's - transform each disk
    public static void createDiscs(int[] array) {

        for (int i = 0; i < array.length; i++) {
            // create a new discArray for each disc
            // need to initialize with numbers from -i to i
            // i - the start position of our disk
            // array[i] - length of numbers inside our array
            int lengthA = (array[i] * 2) + 1;
            int[] disk = new int[lengthA];
            int value = -array[i];
            for (int j = 0; j < disk.length; j++) {
                    // i = 0
                    // array[i] = 4
                    //[-4, -3, -2, -1, 0, 1, 2, 3, 4]
                    disk[j] = value++;
            }
            listDiscs.add(disk);
        }
    }

    public static void SortDiscs(ArrayList<int[]> listDiscs){
        Collections.sort(listDiscs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                return Integer.compare(o1[0],o2[0]);
            }
        });
    }
}

