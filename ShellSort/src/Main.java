
/* Shell sort algorithm
* It's a variation of insertion sort - witch chooses which element to insert using a gap value of one.
* So every time insertion sort runs, it picks off the first unsorted value and then it compares that value to
* its neighbour and it keeps shifting the neighbours to the right until it finds the correct insertion point
* for the element that it's inserting. Shell sort starts out using a larger gap value, so instead of comparing
* elements to their neighbours, it compares elements that are farther apart from each other in the array.
* And then as the algorithm runs, it reduces the gap that it's using. And the goal is to reduce the amount of
* shifting that's required.
* Shell sort traverses the array with a certain gap value and after it's done its first traversal with the
* initial gap value, it decreases the gap and it does it again and it does this and this is very important,
* it keeps reducing the gap value until the gap value is one. Now when the gap value is one, we're essentially
* doing an insertion sort. So the last iteration of the gap value will actually perform an insertion sort.
* But at that point, the array will be more sorted than it was at the beginning.
* And so essentially what Shell sort does is it does some preliminary work using gap values that are greater than one
* and that preliminary work puts the elements in the array and perhaps closer to their sorted positions
* and then at the very last iteration when the gap value becomes one, it does an insertion sort.
* But that final insertion sort will be working with values that have had some preliminary sorting done on them.
* And because of that, there will be a lot less shifting required.
* So one question is well, what do we use for the gap value? https://en.wikipedia.org/wiki/Shellsort
* The important thing to note is that the way that you calculate the gap can influence the time complexity.
* calculate the gap value - common sequence that's used for the gap value and the gap is also called the interval
* Knuth sequence (3^k - 1) /2 - set k based on the length of the array
* use the value of k that's going to calculate to a value that's as close as possible to the length of the array
* without going over. If we had an array of let's say 20 elements, we would wanna start with k equal to 3.
* If we were to start with k equals four, the gap would be 40 and that's greater than the length of the array
* so that won't work. And so when you want to use this sequence, you want to start with the value of k
* that's going to result in a gap value that is as close to the array's length as possible without going over.
* we're going to base our gap on the array's length and we're going to initialise the gap to array.length / 2.
* And then on each iteration, we're going to divide the gap value by two until we hit one.
*
* */


public class Main {
    public static void main(String[] args) {

        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        /* So the first loop we're gonna have is the one that's going to initialise the gap value
         and then reduce it on each iteration.
         we're gonna keep going as long the gap is greater is zero because if the gap is zero,
         then that means that we're gonna be comparing elements against themselves.
         So we need a gap of one. For the final iteration, remember for shell sort, the final iteration always
         has to have a gap of one because we want the final iteration to essentially be insertion sort.
         And on each iteration, we're going to divide the gap value by two.  it's essentially insertion sort,*/

        for (int gap = intArray.length / 2; gap > 0; gap = gap /2){

            for (int i = gap; i < intArray.length; i++) {
                //i is the value that we're going to be looking at (intArray[gap])
                int newElement = intArray[i];
                // use j to do the traversing.
                int j = i;
                // because if j becomes less than the gap, that means that we've hit the front of the array.
                while (j >= gap && intArray[j - gap] > newElement) {
                    // shift the element at intArray j minus gap up gap positions.
                    intArray[j] = intArray[j - gap];
                    // because we're saying that now we're going to want to compare newElement
                    // with whatever comes three positions over.
                    j -= gap;
                }
                intArray[j] = newElement;
            }


        }




    }


}