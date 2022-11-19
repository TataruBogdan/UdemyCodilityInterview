


/*  If a single share was bought on day P and sold on day Q, where 0 ≤ P ≤ Q < N, then the profit of such transaction
is equal to A[Q] − A[P], provided that A[Q] ≥ A[P]. Otherwise, the transaction brings loss of A[P] − A[Q].*/
/* MAXIMUM SUB ARRAY ALGORITHM
* [7, -8, 4, -1, 6, -2, 3, -6, 5]
* array containing 9 elements. A subArray is a continuous portion of an array.
* these three elements make up one such sub array. -8, 4, -1,
* another one that has four elements. -1, 6, -2, 3,
* The important thing is that the sub array must be continuous and not have any gaps.
* Now in the maximum sub array problem we sum up the numbers together.
* In this example we are summing up the -8, the 4 and the -1, giving us a sum of -5.
* The aim is to find the sub array that has the maximum sum.
* In our example the maximum is 4, -1, 6, -2, 3
* This is because there is no other sub array that results in a sum bigger than 10.
* It is important to understand that this problem only makes sense if our input contains negative values.
* If our array only contains positive values the maximum sub array is the entire array itself, leaving any
* portion out of the array with just positive values would actually result in a smaller sum.
* The first algorithm examines every possible sub array, computes the sum and finds the maximum one.
* Staying with the same array in this algorithm we would start with the sub array containing just the number 7
* and computing the sum which is of course also 7.
* Next we move to the sub array containing the 7 and the -8 and sum it up
* Then we sum up the 7, the -8 and the 4 and so on continuing until the end of the array,
* summing everything up. Then we repeat the process this time starting from the second element the
* Faster algorithm that makes use of a divide and conquer technique.
* The idea of the algorithm is to keep on dividing the array in the middle in two parts until it becomes
* small enough that it's trivial to solve This is when we end up with an array of size 1 and the maximal sub array
* of an array with size 1 is that item by itself. We then merge the sub solutions together when we're backtracking
* in the algorithm.
* Kadane came up with an algorithm that can find us the maximum subArray in linear time.
* If we plot these daily prices on a time versus money we would get a chart similar to this one depending
* Using these historical daily prices we need to identify the buying opportunities.
*  uptrend over here is one such buying opportunity. If we were an investor we would buy stock over here and
* sell it over here to make a profit. In a similar we have another buying opportunity over here where we would buy
* and sell at the peak.
* To implement Kadane's algorithm we need two main variables.
* GlobalMax stores the sum of the maximum sub array and we also need a local Max.
* LocalMAx This represents a temporary sub array that we will use while we are processing the input array.
* We initialize both of these variables to be the initial value of our array, the value at index position 0.
* In this example the index at position 0 is 5
* We move on to the next item the index position 1 which happens to be -4 in this array and every
* time we pick an item from our array we need to make a choice. The choice is: do we pick this new entry,
* the -4 value or do we choose to have the -4 plus the 5? The 5 being this particular value, the local max variable.
* Here we're just adding the -4 plus the local max variable and we choose one of these.
* Basically we choose whatever is bigger. In this case we choose either -4 or 1 and we choose 1.
* So what we do is we set the local max to be 1 and this means we have chosen the sub array to have the
* 5 and the -4 resulting in 1. We move on to the next item which happens to be an 8 and we do the same choice:
* do we pick 8 or 8 + 1 In this case we choose the 1 plus 8 because it results in 9 and 9 is bigger than 8.
* And this represents the summation of the first three items.
* Notice that now we have the local max variable being larger than the Global Max.
* And when that happens we need to reset the Global Max to be the same as the local max.
* We move on to the item representing -10, the item at index position 3, and we have the same choice to make:
* do we choose the -10 or -10 plus 9 resulting in -1? -1 is bigger than -10
* We enlarge the sub array again having a resulting sum of -1. If you add these four up it will give you a -1.
* We move on to the next item which is a -2 and we have the same choice: do choose -2 or do we choose -2 plus -1
* giving us a -3? Obviously the -2 is bigger than -3 so now we have to do a different action.
* Up until this point we have always chosen the right hand side of this choice resulting in enlarging
* the sub array and modifying this value. Now we need to do a different action.
* reEncode our input so we can use the algorithm on it. The way to do this is to calculate the delta
* between each and every item in our array.
* We start from position 1 and we subtract the previous position from it.*/
public class Main {

    public static void main(String[] args) {

                // delta    [   0,  -2160,  112,   243,   -353,   354]
        int[] dailyPrices = {23171, 21011, 21123, 21366, 21013, 21367};
        //System.out.println(solution(dailyPrices));
        System.out.println(solutionHint(dailyPrices));

        // if a share was bought on day 0 and sold on day 2, a loss of 2048 would occur
        // because A[2] − A[0] = 21123 − 23171 = −2048.
        //                          2      0

        /* need the maxValue of the share and the min value of the share
        * if index of maxValue > index of minValue - profit*/

    }


    public static int solutionHint(int[] A) {

        int[] delta = new int[A.length];
        for (int i = 1; i < A.length; i++) {
            delta[i] = A[i] - A[i-1];
        }

        int globalMax = delta[0];
        int localMax = delta[0];

        for (int i = 1; i < delta.length; i++) {

            // every time we pick an item from our array we need to make a choice.
            // The choice is: do we pick this new entry, the -4 value or do we choose to have the -4 plus the 5?
            // we choose the biggest
            int tempValue = localMax + delta[i];
            if (tempValue > delta[i]) {
                localMax = tempValue;
            } else {
                localMax = delta[i];
            }
            if (localMax > globalMax) {
                globalMax = localMax;
            }

        }
        return globalMax;
    }

    public static int solution(int[] A) {

        int maxProfit = 0;

        //if the index of the maxValue is bigger then the index of the minValue -> Profit
        for (int i = 0; i < A.length; i++) {
            int period = A.length -1;
            int maxValue = A[i];
            while (period > i) {
                int currentMaxValue = A[period];
                if (currentMaxValue > maxValue) {
                    int currentProfit = currentMaxValue - maxValue;
                    if (currentProfit > maxProfit) {
                        maxProfit = currentProfit;
                    }
                }
                period--;
            }
        }
        return maxProfit;
    }

}