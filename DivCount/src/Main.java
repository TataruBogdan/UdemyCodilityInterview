

/*
Write a function:

class Solution { public int solution(int A, int B, int K); }

that, given three integers A, B and K, returns the number of integers within the range [A..B]
that are divisible by K, i.e.:

{ i : A ≤ i ≤ B, i mod K = 0 }

For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers
divisible by 2 within the range [6..11], namely 6, 8 and 10.

Write an efficient algorithm for the following assumptions:

A and B are integers within the range [0..2,000,000,000];
K is an integer within the range [1..2,000,000,000];
A ≤ B.

In the div count problem we are given a sequence of number incrementing by 1 each time
and we need to find the number of multiples that exist in the sequence of a particular factor.*/

public class Main {

    public static void main(String[] args) {

        System.out.println(solution(6, 11, 2));

    }

    // solution 100 %
    public static int solution(int A, int B, int K) {

        int firstNumber = A;
        int lastNumber = B;
        while (lastNumber % K != 0) {
            lastNumber--;
        }

        int maxDivNumbers = (lastNumber / K);


        while (firstNumber % K != 0) {
            firstNumber++;
        }
        int minDivNumbers = (firstNumber / K) - 1;

        return maxDivNumbers - minDivNumbers;

    }



    // not very efficient for big numbers
    public static int solution1(int A, int B, int K) {

        if(A > B) {
            return -1;
        }

        int count = 0;

        // we go up to the sqare root of the number ?
        // if we have very big numbers Math.sqrt(B)
        for (int i = A; i <= B; i++) {
            if ( i % K == 0) {
                count++;
            }
        }
        return count;
    }
}