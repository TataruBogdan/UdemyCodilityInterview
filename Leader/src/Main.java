
/* finding the leader elements in a list.
* It all centers around the idea of finding an element in a list of items having a particular property
* which we call the leader.
* An element c in our list is set to be a leader if the count of occurrences in that element is more than
* half the size of the list. Notice that with this definition we can only have a maximum of one leader.
* This is because you cannot have two items both occurring more than half the size of the list.
* [3, 4, 2, 3, 3, 2, 3] - size = 7
* Element 3 occurs four times making it the leader since 4 is > 7/2
* [5, 1, 5, 3, 1, 5, 4]
* In this array 5 is the most occurring element. However, it only occurs three times.
* Since three is less than half the size of the array, therefore this list doesn't have any leader.
* So how do we go about finding the leader of the array?
* The simple way to find a leader is to count the occurrences of each item and return the first
* Let's see an example for an array of size 7.
* [2, 4, 3, 3, 3, 2, 3]
* You can use two variables storing the count and the leader candidate starting a pointer from left
* we can then check how often the item at the pointer occurs in the array. To do this
* we can get another pointer and advance it while counting the number of matches. Here
* the item with a value 2 has a count of two.
* Since this is less than half of 7 we move on to the next item. Using the item number 4
* we again count the number of occurrences and discard 4 since the count is only 1.
* Next we move on to the item with a value of 3. And again count the number of matches.
* This time the count is greater than half of 7. So in this example the item with a value of 3
* is the leader of the array.
* Another method to find a leader in an array involves sorting the array first.
* [2, 2, 3, 3, 3, 3, 4]
* Here we have sorted this example array low to high.
* Notice that if the array contains a leader then the elements in the middle of the array would also be the leader.
* This is because if the item occurs for more than half of the size of the array the middle element in a sorted list
* has to be that item. So we can pick the middle elements of a sorted list and count the matches of the item
* to check if it's the leader. If we pick an efficient sorting algorithm such as the merge sort the runtime
* performance of this method O(n log n)
* Can we build an algorithm that is faster than this? It turns out that we can.
* In the Codility puzzle called dominator we need to find the leader of an array just
* returns index of any element of array A in which the dominator of A occurs
* The catch is that our algorithm needs to have a linear runtime and space complexity. */


import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[] array = {2, 4, 3, 3, 3, 2, 3};
        int[] array1= {2};

        // System.out.println(solution1(array));
        System.out.println(solutionMy(array));
        System.out.println(solutionMy(array1));

        //System.out.println(solutionSchool(array));
    }

    /* Hint - if we pick two non equal elements from the array and remove them the leader will still be the same.
     * So here in our example if from our array we remove three and two we still have a resulting array containing
     * the same leader. This array with those two elements removed still has the item number 3 as the leader.
     * rule - if two different animals are next to each other they will fight.
     *        So we have to remove them from the array.
     * if we remove the eagle and the wolf because they're adjacent and they're not the same the resulting array
     * is still an array which contains the wolf as the leader.
     * Using a stack and start processing our array from left to right,
     * if our stack is empty we simply insert it in our stack.
     * We move on to the next and this time our stack is not empty.
     * So we pop that entry from the stack and if both items are of different value as in this case
     * we simply get rid of them, we simply throw them away.
     * next and we compare it with whatever we have on our stack. Since both items are of the same value
     * we push them back to the stack.
     * We need to do is take out the topmost entry of our stack and count the number of occurrences in
     * our original array.
     * runtime complexity of order n. consuming a lot of memory.
     * It can consume the same amount of memory as our input array.
     * The worst case for memory consumption is when every single entry in our array is the same,
     * forcing us to push every single thing on our stack.
     * Using a candidate and we just have a counter of the number*/

    public static int solutionSchool(int[] A) {

        int consecutiveSize = 0;
        int candidate = 0;

        for (int item: A) {
            if (consecutiveSize == 0) {
                candidate = item;
                consecutiveSize += 1;
            } else if (candidate == item) {
                consecutiveSize += 1;
            } else {
                consecutiveSize -= 1;
            }
        }

        int occurrence = 0;
        int index = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == candidate) {
                occurrence++;
                index = i;
            }
        }
        return (occurrence > (A.length / 2)) ? index : -1;
    }


    // solution 100 %
    public static int solutionMy(int[] A) {

        Map<Integer, Integer> mapInteger = new HashMap<>();

        int leader = 0; // index where we can find the leader
        int leaderIndex = 0;
        for (int i = 0; i < A.length; i++) {
            if (!mapInteger.containsKey(A[i])) {
                mapInteger.put(A[i], 1);
            } else {
                int currentCount = mapInteger.get(A[i]);
                mapInteger.put(A[i], currentCount + 1);
            }

            int count = mapInteger.get(A[i]);
            if (count > leader) {
                leader = count;
                leaderIndex = i;
            }
        }

        return (leader > (A.length / 2)) ? leaderIndex : -1;
    }



    // runtime complexity is quadratic.
    public static int solution1(int[] A) {

        int leader = 0;
        for (int i = 0; i < A.length; i++) {

            int count = 0;
            int value = A[i];
            int pointer = i;
            while (pointer < A.length) {
                if (value == A[pointer]) {
                    count++;
                }
                pointer++;
            }
            if (count > leader) {
                leader = count;
            }
        }
        return (leader > (A.length / 2) ) ? leader : -1 ;
    }


}