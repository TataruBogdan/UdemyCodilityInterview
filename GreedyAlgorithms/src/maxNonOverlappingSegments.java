
/* And this problem we are given a number of segments and we need to find the maximum number of these segments
* that do not overlap another one.
* These segments that we are given in the inputs of our function are ordered by the ending position of each segment
* Two segments overlap each other If the beginning of one of them is behind the ending of the other one
* for example this segment over
* So the ending of this segment is segment with id 0 has an ending after the beginning of the segment at
* id position 1. So these two are overlapping.
* What we need to return in our solution is the maximum number of segments that are not overlapping.
* So we had to choose some of these segments which selection or which choice we would have that would
* result in the maximum segments chosen for this particular example.
* to solve this problem we are given an input containing all the beginnings and end of each segment.
* The way this input is fed into our function is by using two array this list of beginning and end is
* parameters into arrays.
* Array A and array B and each element in these two arrays represents one segment with a beginning the element
* at A and end then the element at B the function signature that we need to write is called solution excepting
* the two parameters it two arrays A and B
* return account of the maximum number of non overlapping segments
* CPU O(n)*/

public class maxNonOverlappingSegments {

    public static void main(String[] args) {

        int[] A = {1, 3, 7, 9, 9};
        int[] B = {5, 6, 8, 9, 10};

        System.out.println(solution1(A,B));

    }

       // return max count nonoverlapping segments
    // 40 % - ok ... problem ?
    public static int solution1(int[] A, int[] B) {

        int i = 1;
        int count = 1;

        for (int j = 0; j < B.length && i < A.length; j++) {
            if (A[i] > B[j]) {
                count++;
            }
            i++;
        }
        return count;
    }
}
