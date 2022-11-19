
/* We have a number of chocolates arranged in a circular fashion.
* And there is a manner in which we can eat these chocolates.
* Each chocolate, it is identified by a number. The number is sequential.
* So we start from zero. Then we have one, two and so on, up to the number of chocolates that we have,
* minus one. Because we started from zero.
* And in this particular example that I have displayed here on this slide, we have 10 chocolates.
* N = number of chocolates is 10.
* The manner in which we can eat these chocolates depends on another variable, the variable M..
* example of M is equal to four.
* So we always start from chocolates with id 0 and we eat it all right.
* And we mark that as eaten and then we move forward 4 spaces.
* So our current position plus M, which in this example is four.
* And we end up on the chocolate with I.D. 4. We eat that one as well. Market as eaten.
* And moved forward to position eight. We have added another four.
* And now since we have wrapped around, we have called around the circle.
* We are on position I.D. 2 We eat that one as well.
* Move forward four spaces.
* We eat the chocolate with 6 and then we move forward another four spaces.
* However, at this time, the chocolate has already been eaten.
* This is our signal to stop eating chocolates.
* When we do a full cycle and encounter a chocolate that has already been eaten,
* we stop consuming more chocolate and we return the number of chocolates that were consumed.
* The way we are moving and hopping from one chocolate to the other is by using this expression we determined
* the next chocolate to eat by the current position, which is represented by this x.
* add M our step variable, which in this case is 4. mode N
* this will give us this wrap around mechanism that will come around after we complete this cycle.
* next  = (X + M) % N
* We need to return the total number of chocolates that we have eaten.
* N total number of chocolates that we have.
* M is the steps that we need to jump/manner in which we can eat these chocolates *
* both inputs N and M are in the range between one and one billion.
* output of our function is to return the total number of chocolates eaten moving through the chocolates
* lead us to encounter an already eaten chocolate.
* N 10 * 2 = 20
* M 4 * 5 = 20
* M * x = N * M / GCD -> x = N * M / GCG * M -> x = N / GCD
* -> result = N / GCD (N, M)
* 20  Least Common Multiple - The smallest number that is a common multiple between our two inputs.
* LCM = N * M  / GCD */


public class Main {
    public static void main(String[] args) {

        //System.out.println(solutionMy(10, 4));

        System.out.println(solution(10, 4));

    }

    public static int solution(int N, int M) {

        return N / findGcd(N, M);

    }

    public static int findGcd(int A, int B) {

        if (B == 0) {
            return A;
        }

        return findGcd(B, A % B);

    }

    // 62 %
    public static int solutionMy(int N, int M) {

        boolean[] chocolates = new boolean[N]; // nr of chocolates that will be eaten - false is not ate
        int count = 0; // count how many chocolates are ate
        // if we come to the end of the array we must go back at the beginning + the difference

        for (int i = 0; i < chocolates.length; i = (i + M) % N) {
            System.out.print(i + ",");
            if (!chocolates[i]) {
                chocolates[i] = true;
                count++;
            } else {
                break;
            }
        }
        return count;

    }
}