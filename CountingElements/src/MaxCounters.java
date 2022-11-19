

/* we are given two inputs n the size of our counters and the set of instructions to perform on those counters.
* We will walk through an example and in this example we are assuming that n equals 5.
* 1  2  3  4  5 - Counters
* 0  0  0  0  0 - Initially these counters are initialized to 0.
* The instructions that we receive can be of two different types. It can be an increase of a particular counter
* or a max counter.
* assume we receive n equals 5. Five counters and walk through a simple list of instructions for this particular problem.
* The first instruction that we receive is an increase where X equals 3.
* This means that we need to find our third counter and increment it by 1.
* 1  2  3  4  5 - Counters
* 0  0  1  0  0 - increase(3)
*
* 1  2  3  4  5 - Counters
* 0  0  1  1  0 - increase(4)
*
* 1  2  3  4  5 - Counters
* 0  0  1  2  0 - increase(4)
*
* 1  2  3  4  5 - Counters
* 0  0  1  2  0 - max counter
* max counter instruction. What we do in this instruction is that we reset all the counter values to be the value
* of our maximum counter. In this case our maximum counter is 2 represented by counter 4.
* So we go through every counter and reset this to the value of to 2
* 1  2  3  4  5 - Counters
* 2  2  2  2  2 - max counter
* Our next instruction is increase of counter 1. So we go to counter 1 and we increase this to 3.
* 1  2  3  4  5 - Counters
* 3  2  2  2  2 - increase(1)
*
* 1  2  3  4  5 - Counters
* 3  2  2  3  2 - increase(4)
*
* 1  2  3  4  5 - Counters
* 3  2  2  4  2 - increase(4)
* Once we consume all our instructions all that's left is to return the result.
* The result of this problem is the list of counters that we have just executed.
* The problem has two inputs:
*      - one is the number of counters that we want (5)
*      - other one is a set of instructions. is represented in a second parameter where we receive an array.
* Each element in the array is a number representing our counter index.
* So for example our second element in the array -number 4 - is telling us that we need to increment the fourth
* counter. In the same way our fifth position in the array is saying increase counter number 1,
* increase the first counter. The middle entry in our array, number 6, is telling us that we should perform
* a max counter instruction .This is when the number in the array is bigger than the number of counters.
* Function name should be called solution and should take in two parameters;
* a the second parameter is simply our set or array of instructions. These instructions must be performed
* in the order they are in the array.
* The first parameter n is simply the size of our counters.
* Once we perform our algorithm all we need to do is simply return the array with the counter results. */


import java.util.Arrays;

public class MaxCounters {

    public static void main(String[] args){

        int counters = 5;
        int[] instructions = {3, 4, 4, 6, 1, 4, 4};

        System.out.println(Arrays.toString(solution(counters, instructions)));
    }


    // initially out counters array is empty
    // N - array with counters
    // A - array with instructions
    public static int[] solution (int N, int[] instructions) {

        int[] counters = new int[N];
        int maxCounter = 0;
        int counterPosition = 0;
        int maxOperation = instructions.length ;
        int indexOperation = 0;


        // if A[K] = N + 1 then operation K is max counter.
        // for each instruction
        while (indexOperation < maxOperation){
            int valueOperation = instructions[indexOperation - 1];
            // in the value of instruction is bigger than the length of our counters array, value is maxCounter
            if (instructions[indexOperation] > N) {
                // all counters are set to the maximum value of any counter
                // this requires n steps -> algorithm is quadratic
                for (int c = 0; c < counters.length; c++) {
                    counters[c] = maxCounter;
                }
                // counters[valueOperation] = maxCounter;
            }
            // else go and increment the value at our counters array by one
            else {
                counters[valueOperation] += 1;
                counterPosition = counters[instructions[indexOperation] - 1];
                // need the index if the operation to take the incremented value
                if (counterPosition > maxCounter) {
                    // need the maxCounter
                    maxCounter = counterPosition;
                }
            }
            indexOperation++;
        }
        return counters;
    }

    /**
     * We construct our array of counters- an array of type integer of size n.
     * we go about filling these counters with zeros. initialize our counters to have a value of zero.
     * create a variable called start line representing our moving start line, initialize to be zero.
     * current max and this will hold the value of our maximum counter.
     * we start a loop iterating over every single instruction that we receive in array A
     *  the first thing we do is that we decrease i by one - because i is pointing to a counter ID starting from 1.
     *  X will be our pointer pointing to each counter in our array
     *  if the instruction that we have received is a max counter instruction.
     *      move the start line and we set the start line to be the current max.
     */
    public static int[] solutionSchool(int N, int[] A){

        int[] counters = new int[N];
        Arrays.fill(counters,0);
        int startLine = 0;
        int currentMax = 0;

        for (int i : A ) {
            int x = i - 1;
            if (i > N) {
                startLine = currentMax; //  because i is greater than N
            }
            // if we need to increment a counter that is behind the start line.
            // when the value of the counter at position x is less than the start line.
            // we set the counter value to be at the start line plus 1.
            else if (counters[x] < startLine) {
                counters[x] = startLine + 1;
            }
            // when the counter is ahead of the start line.
            // we just need to increment the value of that counter by 1
            else {
                counters[x] += 1;
            }
            // we keep track of our maximum value of the counter.
            // first checking whether the instruction is a max counter i <= N
            // checking the current value of the counter that we're currently modifying is greater than the current max
            // we reset the current max to be the value of the current counter.
            if (i <= N && counters[x] > currentMax) {
                currentMax = counters[x];
            }
        }
        // set any counters that are behind the start line to be the value of at least the start line.
        // by looping through every counter.
        for (int i = 0; i < counters.length; i++) {
            //  If the counters at position i is less than the value of the start line -
            // set the value of that counter, counter position i, to be equal to the start line.
            if (counters[i] < startLine) {
                counters[i] = startLine;
            }
        }
        return counters;
    }
}
