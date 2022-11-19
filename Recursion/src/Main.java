

/* A method is a recursive method when it calls itself
* Take a look at calculating the factorial for a number.
* As a reminder to calculate the factorial, you start with the number and then you multiply it by number - 1
* and then you multiply the result by number - 2 nd you multiply that result by number -3  etcetera until you hit zero
* and then you stop.
* So, 3! factorial would be 3 * 2 * 1 which = 6.
* zero factorial? by definition that's equal to one. 0! = 1
* the factorials for negative numbers are undefined.
* Factorial algorithm
* 1. if num is equal to zero, then the factorial is 1. Stop, we have the result.
* Otherwise..
* 2. set the multiplier to 1
* 3. set the factorial to 1
* 4. while the multiplier is not equal to num, we do steps 5 and 6.
* 5. multiply factorial by multiplier and we assign the result to factorial
* 6. and then we add 1 to multiplier
* 7. we keep going until multiplier is equal to num at which point we stop.
* We basically have a rinse-and-repeat step which is step number four.
* */

/*
     recursiveFactorial(0) -> 1
     recursiveFactorial(1) -> 1
     recursiveFactorial(2) -> 2
     recursiveFactorial(3) -> 6
Important to see that when you enter a recursive method, it might be a while before it returns.
You can go down the rabbit hole and you can go down, so when you see recursion
keep in mind that the call to a recursive method may result in many more calls before it returns,
so it's important to understand that a three-line recursive method could result in hundreds of recursive calls.
None of the recursive calls return until they receive the result from the method that they invoked recursively,
Recursive calls are ended when we pass num equals zero because when we pass in num equals zero, we don't make a
recursive call, we just return one.
If we didn't have this condition, we'd never end, we'd just keep making recursive call after recursive call
after recursive call.
So, in order for recursion to work properly, you need some condition that's going to end the recursion.
And that condition is known as the breaking condition / base case.
We say that the recursion starts to unwind so at that point it's gonna return a value and the method that
invoked it recursively will now be able to continue executing and then it will return a value and the method that
invoked it recursively will be able to continue executing et cetera.
So, when you use recursion, you need a breaking condition.
If you don't have one, what will happen is the method will keep calling itself recursively and eventually you'll
get a stack overflow exception because the call stack only has a certain amount of memory allocated to it.
And so, eventually you'll blow that memory.
     */
/* Now, when we're dealing with the recursive method, the call stack can also be referred to as the recursion stack
* when we don't have a breaking condition, we'll get a stack overflow exception. It's possible to get that exception
* even when you do have a breaking condition. If you write a recursive method and it invokes itself 1,000 times,
* you're still possibly going to get a stack overflow exception because you're not hitting that breaking condition.
* So, even if you have a breaking condition, if you call the recursive method with something that's going to cause
* the method to invoke itself a million times, you're gonna get a stack overflow error. */

public class Main {
    public static void main(String[] args) {

        System.out.println(factorial(3));
        System.out.println(recursiveFactorial(3));
    }

    /*  recursive implementation?
    * we can have the method call itself because think about it,
    * 1! =  1 * 0!
    * 2! =  1 * 2!  = 2 * 1!
    * 3! is 3 * 2!  , = 3 * 2 * 1 = 3 * 2!
    * 4! is 4 * 3 !   = 4 * 3 * 2 * 1 */


    public static int recursiveFactorial(int num) {

        // condition that's going to end the recursion -> breaking condition / base case.
        if (num == 0) {
            return 1;
        }
                        // make always the pattern  n! = n * (n-1)!

        return num * recursiveFactorial(num - 1);

    }

    /* The iterative implementation usually runs faster and it doesn't use as much memory because there's overhead
    involved with pushing method calls onto the call stack and each stack frame uses some memory but sometimes
    the iterative way isn't as intuitive or if you write the algorithm in an iterative way, it'll be like a
    500-line method so developers still use recursion because it's often the most elegant and more easier to
    understand solution.*/

    public static int iterativeFactorial(int num) {

        if (num == 0) {
            return 1;
        }

        int factorial = 1;
        for (int multiplier = 1; multiplier <= num; multiplier++) {
            factorial = factorial * multiplier;
        }
        return factorial;
    }


    public static int factorial(int num) {

        if (num == 0) {
            return 1;
        }
        int multiplier = 1;
        int factorial = 1;
        while (multiplier <= num) {
            factorial = multiplier * factorial;
            multiplier++;
        }
        return factorial;
    }
}