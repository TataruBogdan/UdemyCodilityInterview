
/*we are given an input representing different heights at different points on this mountain range and
* we need to find the peaks of these mountains. In addition to that we need to place a number of flags
* on these peaks using a specific placement scheme.
* Each input point given to us for this problem represents a specific height of our mountains and each
* of these points are equidistant horizontally meaning that if you pick any point the distance between
* the previous one and the next one and any other distance in between the two points is the same.
* The only difference is of course the height, each point is at a different height.
* We have to decide how many flags we can put on our mountain range.
* If we take with us three flags we can separate the flags by at least three spaces or more. So in this
* if this point(after the third position) is not a peak we have to place it on the next available peak
* Equally on the next flag we have to move three units and place the flag over here on the next available peak.
* The aim of this task is to find a particular placement where we can place the maximum flags
* We need to return the maximum number of flags that can be placed on the given input.
* If we take with us three flags, we can place the first one on the first peak then move three spaces
* and place it on the next available peak Then the final one goes on to the final peak.
* This is because the final peak over here is more than three units away from the previous one.
* If we have run out of space and actually we have run out of peaks as well.
* So we cannot place the fourth flag so we cannot place four flags in this particular instance.
* So the solution to this particular problem input is that we can place a maximum of three flags. return the number 3.
* The input to our function is the different heights at different points of this mountain.
* So the input is represented as an array containing the different heights at different points.
* [1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2]
* We can tell whether a point is a peak or not by comparing it to the neighboring points.
* If both neighboring points have a height of lower than that point it means that the point is a peak.
* return the maximum number of flags that can be placed on the given input. CPU O(n)
* */

/* How much space would these flags take using the scheme
* start by placing the first flag at position 0, move 5 units, because we have 5 flags, then move
* another 5, place another one, move another 5, place another one and move another 5 and place the 5th
* How much space in total are we occupying? The answer is of course 20 units.
* This is because for five flags we need four of these spaces, 4 of 5 units giving us 20 units.
* One way to express this from the point of view of the number of flags is to say that we have five flags
* squared minus 5, giving us 20. 5^2 - 5 = 20
* Or in other words we say x squared minus x giving us n.
* x is the number of flags that we have and n is the total number of space that we have.
* We say what if I have 20 units of space how many flags can I fit?
* And the upper limit of this is square root of 20 plus 2.
* We can never place more flags than the square root of 20 plus 2.*/


public class Flags {


    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
        //int[] a = { 1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
        System.out.println(solution(a));
        //System.out.println(solutionSchool(a));
    }


    public static int solutionSchool(int[] A) {
        int[] peaks = new int[A.length];
        int nextPeak = A.length;
        peaks[A.length - 1] = nextPeak;
        for (int i = A.length - 2; i > 0 ; i--) {
            if (A[i] > A[i-1] && A[i] > A[i+1])
                nextPeak = i;
            peaks[i] = nextPeak;
        }
        peaks[0] = nextPeak;

        int currentGuess = 0;
        int nextGuess = 0;
        while (canPlaceFlags(peaks, nextGuess)){
            currentGuess = nextGuess;
            nextGuess +=1;
        }
        return currentGuess;
    }

    public static boolean canPlaceFlags (int[] peaks, int flagsToPlace) {
        int currentPosition = 1 - flagsToPlace;

        for (int i = 0; i < flagsToPlace; i++) {
            if (currentPosition + flagsToPlace > peaks.length -1) {
                return false;
            }
            currentPosition = peaks[currentPosition + flagsToPlace];
        }
        return currentPosition < peaks.length;
    }



    //TODO - solution este de la problema Flags si nu Peaks
    // [1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2]
    /* how many peeks can be ? mountain can have only 5 peeks - max*/
    // return the maximum number of flags
    public static int solution(int[] array) {

        int numberOfPeaks = 0;
        int maxNumberOfFlags = 0;

        boolean[] peaks = new boolean[array.length];

        for (int height = 1; height < array.length; height++) {
            if(array[height] > array[height-1] && array[height] > array[height + 1]) {
                peaks[height] = true;
                numberOfPeaks++;
            }
        }
        int numberOfFlags = numberOfPeaks;

        // i have the number of flags = number of peaks
        // I have al the peaks where I can place a flag
        // 20 units
        // flag ......... flag ....... flag ....... flag ......
        // how many flags can I use so that I fill as many peak with flags
        // take the first peak
        // set a flag
        // count the number of elements between
        while(numberOfFlags > 0) {
            // because we go to element + 1
                int p = numberOfFlags;
                int i = 1;
                // we take 1 flag - we put the flag on fist available peek
                int localNumberOfFlags = 0;
                while (i < peaks.length && i <= p) {
                    //if we have a peak but the distance from the first elem it's not bigger than number of flags
                    if (peaks[i]) {
                        localNumberOfFlags++;
                        // divide this array into blocks containing the same number of elements
                        // after we find the first peek
                        // ask - the number of element right
                        p = i + numberOfFlags;
                        continue;
                    }
                    i++;
                }
                if (localNumberOfFlags > maxNumberOfFlags) {
                    maxNumberOfFlags = localNumberOfFlags;
                }
            if (numberOfFlags < localNumberOfFlags) {
                break;
            } else {
                numberOfFlags--;
            }
        }
        return maxNumberOfFlags;
        
    }
    
}
