
/* Prime numbers are numbers greater than 1 that have no factors except 1 and themselves.
* These are the numbers like 2, 3, 5 and 7. Composite numbers are all the remaining numbers.
* It's important to realize that you can make up any composite number by simply multiplying together
* different prime numbers.
* Let's say we pick a random number, the number 574.
* We can build the number by multiplying together the prime numbers of 2, 7 and 41.
* This set of prime numbers is the only prime set that can be used to produce the number 574.
* This means that we can build any composite number from a unique set of prime numbers.
* This is an important property used in public key encryption algorithms.
* The basic idea behind public key encryption is to have two keys.
* One is used to encrypt the message and the other one used to decrypt it back to the original.
* You then keep the decryption key private known only to yourself and give away the public key so that
* anyone that wants to send you a message can use it to encrypt this message.
* But how do you generate this public private key pair in a way that you cannot derive the private key
* from the public key.
* The answer is to have two very large prime numbers and use them as your private key.
* {public key    >     private key } Primes
*                       492876847
*                       512927357
* 252810018458203379
* Then you multiply these two primes together and use the answer as your public key.
* Since the algorithm to find out the unique prime factor set from a large composite is very slow
* it is very difficult for an attacker to discover the private key just from the public key.
* The best known algorithm for prime factorization has an exponential time complexity. O(k ^ n)
* This means that the time taken to find the prime factors of a composite number increases exponentially
* with the size of the number.
* Typically public key encryption uses lengths of 2048 bits or larger making it very difficult to find the prime factors.
* A composite number can also have non prime factors.
* For example consider the number 64. It has the factors of 16 and 4, both of which are not prime.
* Notice that on any pair of factors there will always be at least one of them that is less than the square root
* of the main number. For example the square root of 64 is 8.
* 4 is the factor in this pair that has a smaller number than this. This rule is valid for all numbers.
* And it's easy to visualize with an example. Again consider the number 64.
* 64 is a square number having 8 and 8 as the two square factors. 8 x 8 = 64
* If we increase one of the factors to say 16 we need to reduce the other 1 to 4
* increasing the first factor further to 32 the other one goes down to 2.
* There is simply no way to produce two factors where both of them are greater than the square root as
* multiplying them will result in a bigger number.
* */

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}