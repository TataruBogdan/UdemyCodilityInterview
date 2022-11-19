
/* for anything to do with counting.
* This includes problems where we count occurrences of certain properties possibly building histograms
* or frequency tables. Sometimes the problem involves simply count putting the most or least occurring element
* or which element is first repeated.
* Common tricks and tools
* A common approach is to consume the list one by one and use a data structure such a hash table
* to store the occurrences of the items.
* This table is sometimes called a frequency table and can be used to come up with a histogram.
* Choosing the right data structure is crucial.
* Although a hash table on average has a great performance in the worst case it can perform poorly and
* have an order O(n) and for inserts and searches.
* Keep in mind that some strict interviewers might be looking for better ways case performance.
* Using an array instead of a hash table is possible depending on the type of elements present in the list.
* Suppose we are asked to count the occurrences of integers present in a list.
* If the range of these integers is small enough to fit a memory we might be better off
* using direct addressing in an array. In this example
* [4, 3, 0, 4, 3, 9, 2, 4]
* the range is between 0 and 9 so we can insert an array of size 10
* [0, 0, 1, 2, 3, 0, 0, 0, 0, 1]
*  0  1  2  3  4  5  6  7  8  9
* and then map each item in the list to the index of the array, incrementing the value as we process the list of numbers.
* Using an array instead of a hash table guarantees that every INSERT and SEARCH will have a constant runtime performance.
* Building the entire frequency table results in a linear O(n) runtime performance, in the worst case.
* This trick of using an array as our frequency table can also be used if our range contains negative numbers.
* When this is the case we just need to shift the elements so the range starts from the zero index.
* This is simply achieved by adding the negative range to each item.
* [-4, 3, -1, 2, -1, 5, 2, 4] - [-4, 5] -> 4+5=9
*   0  1   2  3   4  5  6  7
* [1, 1, 0, 1, 0, 0, 2, 1, 1, 1]
*  0  1  2  3  4  5  6  7  8  9
* Here we show an example with a range from - 4 to 5 where we shift everything by 4 so
* -4 would map to our array at the 0 index, minus 3 would map to 1 and so on.
* When our input range is too large we cannot use an array as this would result in a huge waste of memory.
* Just to give you an example if the input can be any integer typically between 0 and 2 to the power of 32
* using an array would result in our solution consuming something like 16 gigabytes of memory.
* In such cases it's better to use other key value data structures such as hash tables or balanced by an increase.
* Let's examine some more problems and solutions in the following videos.
* */

public class Main {


    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}