
/* we are given an input containing a list of numbers
and we need to find the total number of distinct slices in this list.
slice is a portion of this list of this input where none of the elements repeat.
[3, 4, 5, 5, 2]
3, 4, 5 - distinct slice all of the items in this slice are unique.
5, 2 - distinct slice
And so is one item by itself. The slice containing just the number 4 at index position 1.
4, 5, 5 - in not a distinct slice Because we have the 5 repeating right.
our aim and this problem is to count the total number of distinct slices.
[3, 4, 5, 5, 2]
{3}         {4}     {5}
{3, 4}      {4, 5}  {5, 2}
{3, 4, 5}   {5}     {2}
{5} - are not the same slice right because one of them is at index position 2 and the other one is at index position 3
results of this particular arrangement of this particular input is 9 we have 9 different distinct slices.
in this list each element has to be equal or less than an N being the range between zero and 100000
*/


// M is the upper bound of each element in our list - every item in input a will be less or equal to M
// return total count of all the distinct slices.
// if the count exceeds the value of 1 billion.(1.000.000.000) return 1.000.000.000
// CPU O(n) MEM O(m)


import java.util.HashMap;
import java.util.Map;

public class CountDistinctSlices {

    public static void main(String[] args) {

        int[] array = { 3, 4, 5, 5, 2};
        int[] array2 = {2, 4, 1, 7, 4, 9, 7, 3, 5, 5, 8, 7, 1};
        int m = 9;
        //System.out.println(solution(m, array));
        // System.out.println(solutionTip(m, array));
        System.out.println(solutionSchool(m, array2));

    }

    public static int solutionSchool(int m, int[] a) {

        int count = 0;
        int head = 0;

        // we keep on moving the front point or forward until we meet duplicate
        boolean[] duplicates = new boolean[m+1];

        for (int tail = 0; tail < a.length; tail++) {
            while (head < a.length && !duplicates[a[head]])  {
                duplicates[a[head]] = true;
                count += (head - tail) + 1;
                head ++;
                if (count > 1000000000) {
                    count = 1000000000;
                }

            }
            duplicates[a[tail]] = false;
        }
        return count;
    }


    // so every time we enlarge our list we can update this count variable by saying
    // count = count + size


    // result 50 %
    public static int solution(int m, int[] a) {

        Map<Integer, Integer> distinctElements = new HashMap<>(m);

        int count = 0;

        for (int start = 0; start < a.length; start++) {
            int end = start;
            while (end < a.length) {
                if (distinctElements.containsValue(a[end])) {
                    break;
                }else {
                    distinctElements.put(end, a[end]);
                    end++;
                }
            }
            count += distinctElements.size();
            distinctElements.clear();
        }

        return count;
    }

}
