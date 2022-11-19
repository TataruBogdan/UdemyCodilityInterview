
/* We have a river, we have a frog, and we have a place where the frog wants to be, which is on the
* opposite side of this river to get to the other side. The frog needs to cross a number of these virtual spaces
* numbered from one up to a certain distance. In this example over here, we have from one to five.
* Now, what's happening is that leaves are falling in these exact spaces and we can assume that the river
* has zero current. And the reverse of the leaves stay exactly in that position.
* And eventually a leaf falls in every single space that we have. And the frog is able to cross this river
* by jumping on each one of these leaves.
* However, the problem mentions that the frog can only get to the other side by going over these leaves.
* One of the input variables to our solution will be X. X is the width of our river.
* It means we have five spaces that the frog has to cross over. We also have an input list called a representing.
* Where and when will the leaves fall in their positions?
* The time of when aly leaf Falls is represented by the index of this array and the value of the array represents
* the position of where the leaf falls. So in this particular example, at time zero, we have a leaf falling
* at position one at a time 1 we have a leaf falling at position tree.
*    A = [1, 3, 1, 4, 2, 3, 5, 4] <- positions where the leaf will fall
* time =  0, 1, 2, 3, 4, 5, 6, 7
* And at the time too, we have another leaf falling in the same position of one. So there are two leaves in that position.
* It doesn't matter whether there is one or two leaves, the frog can still cross at time three.
* We have a leaf falling at position for a time before we have a leaf falling in position....
* at times six we have a leaf finally falling at position five.
* And since now we have a leaf in every single position that we have, the frog can finally cross from one side to the other.
* What we need to return as an output of our function is the time of when a path opens the river.
* In this example, we should return the result of six, because at times six, we have a complete path
* from where the frog is sitting to the other side. */

/*  solution, excepting those two parameters, X and A
X is the size of the river.
A is the input list of when and where the leaves are falling.
This list has a size of n and both X and A have a size limit between one and one hundred thousand.
So both the river size and the list have a minimum of one item or one hundred thousands.
Each element in the input list of A is in the range between 1 and X, so we don't need to worry about validations

need to return the time of when the frog can cross.
If we process the entire input list and there are still gaps in the river where the frog cannot cross,
we should return the result of minus one.
CPU O(n) , MEM O(n)
*/

public class FroRiverOne {

    public static void main(String[] args) {

        int[] a = {1, 3, 1, 4, 2, 3, 5, 4}; // positions
               //  0  1  2  3  4  5  6  7  // moment 1 leaf falls at pos 1
        // another leaf can fall at the same position
        // did the leaf fell at a position where exist already a leaf ? position is already true ?

        System.out.println(new FroRiverOne().solution(5, a));

    }

    //return the time when a frog can jump on the other side of the river
    //at time k, exists a leaf that fall at a position
    public int solution(int x, int[] A) {

        // was the lief that fall
        boolean[] time = new boolean[x+1];
        time[0] = true; // the frog at position 0
        int counter = time.length - 1;
        // for each time when a leaf falls go the that position in the array of time and set pos true
        // there is at least a leaf that fell at that position
        for (int i = 0; i < A.length - 1; i++) {
            // when are all positions occupied ? when oll positions are true !
            // how do I count - counter
            // each time a leaf falls into a position deduct a position and set true in the array

            if (!time[A[i]]) {
                time[A[i]] = true;
                counter--;
                if (counter == 0) {
                    return i; // return the moment when all leafs have occupied all places
                }
            }

        }
        // must eliminate the first position 0 - initial position
        return -1; // the frog cannot cross the river


    }


}
