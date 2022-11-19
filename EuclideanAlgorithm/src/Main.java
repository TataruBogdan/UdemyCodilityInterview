
/* Euclidean algorithm
* this algorithm is useful when you want to find the greatest common divisor between two numbers.
* for example, you have a fraction, the number of 27 over 39. And you want to simplify this fraction.
* What you do, you would divide both the numerator and the denominator by three and you would get a result
* of nine over twelve. This number 3 is the greatest common divisor between these two numbers.
* You cannot find any other number that's bigger than three that would exactly divide both the numerator
* and the denominator.
*  we want to find the greatest common divisor between these two.
*  we can think about these two as being two separate variables, input variables to our greatest common divisor function.
* The Euclidean algorithm works by finding out how many times the number B in this case, 27, fits into the number A.
* And in this example, the number 27 fits just once.
* The next step in our algorithm is to move everything to the left.
* And the idea over here is that we move the value of B into A. So A becomes the value of 27, right?
* We throw away the 39. And the value of B takes over the value of the remainder of the value of R.
* And then we just need to repeat the operation that we did before.
* We say how many times does 12 fit into 27? 27 divided by 12 gives us 2
* And again we shift everything to the left.
* So A becomes 12. B becomes 3
* We say, how many times does 3 fit into 12th? No leftover in this case.
* And now one final step to shift everything to the left,
* A become 3 and B becomes 0.
* When B is zero, we stop calculating this algorithm and we take the results from A
*
*  A    B         R
* 39   27   1 -> 12  the number 27 fits just once. remainder of 12.
* 27   12   2 -> 3   27 divided by 12 gives us 2
* 12    3   4 -> 0
*  3    0   0 -> our stopping condition, right?
*
* Every time we are decreasing the problem size by a fixed ratio, we have a logarithmic reduction.
* Pseudocode  in a recursive manner.
* GCD(A, B)
* if B == 0 return A
* else
*  return GCD (B, A % B)
* */

public class Main {
    public static void main(String[] args) {

        System.out.println(gcd(39, 27));
    }


    public static int gcd(int A, int B) {

        if (B == 0) {
            return A;
        }

        return gcd(B, A % B);
    }
}