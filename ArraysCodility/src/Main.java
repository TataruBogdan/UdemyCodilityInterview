

/* An array is the most basic of data structures. Arrays are often used as a base to build more complex
data structures such as fixed size stacks or queues.
Arrays are usually modeled as continuous chunks of memory.
Let's say you have an array storing three 32 bit Integers. Typically this would require 12 twelve bytes
of continuous memory. An item in an array can be accessed in a random direct manner
simply by multiplying the size of the item by its index.
Here we are showing an example of an initialized array of integers. To access the item at index position 2
the array libraries would simply multiply the size of an integer. In this case 4 bytes by the index and
add it to the start memory offset. So here 2 times 4 plus 21008 gives us 21016.
This is the start of the memory allocation of the item at index 2.
It's important to remember that arrays are static structures. This means that you allocate space
in the beginning once and that's all you've got. After that you're typically not allowed to resize that space.
If you need more space common strategy is to allocate a bigger chunk of memory and copy over the contents
of your old array to the new space. Some languages provide array libraries that resize arrays
in this manner automatically for you whenever you need more space.
These are sometimes called amortized array or more commonly known as growable arrays.
The array list in Java and the default area in Ruby are examples of such data structures.
However, keep in mind that usually resizing arrays has a performance penalty. It's worth considering that
arrays might not be the right data structure for you if you're not certain how much data you have. */
public class Main {


    public static void main(String[] args) {
        System.out.println("Hello world!");



    }
}