
/* The idea over here is that there are a number of hungry fish in a river or if you prefer the term voracious.
* Some of these fish are swimming in the same direction and others are swimming in the opposite direction.
* None of these fish are the same size. They all have different sizes and the rule over here is that if a fish
* encounters another fish swimming in the opposite direction the fish with the bigger size eats the smaller one.
* The aim of this puzzle is to find out how many fish survive at the end.
* how our inputs are encoded so we can represent these types of fish.
* A fish swimming to the left is given a value of 0 whereas a fish swimming to the right is given a value of 1.
* So one of our first input is simply an array whereas each item represents the direction of each fish
* [0, 1, 0, 0, 0]
* Most of the elements are 0 because most of the fish are swimming towards the left.
* We also have another input which represents the weight or the size of each fish.
* Over here I'm showing that one of the fish has a weight of 3 whereas the smaller one has a weight 1
* All of these weights or sizes are represented by a separate array in our input.
* [4, 3, 2, 1, 5]
* Since all of the fish are unique the elements of this array are also unique.
* None of the fish will be the same size as any other.
* We need to implement a function or a method accepting two parameters a and b.
* The first parameter a is the weight of each fish, the weights or the size of each fish.
* The second parameter is the direction of travel of the fish. So 0 means left and 1 means right,
* The return is simply an integer giving us the number of survivors at the end.
* Efficient algorithm. runtime O(n) space O(n)*/

import java.util.Stack;

public class Main {


    public static void main(String[] args) {

        int[] A = {4, 3, 2, 1, 5};
        int[] B = {0, 1, 0, 0, 0};

        System.out.println(solution1(A, B));

        A = new int[]{4, 8, 2, 6, 7};
        B = new int[]{0, 1, 1, 0, 0};
        System.out.println(solution1(A, B));


    }

    public static int solution1(int[] weight, int[] direction) {

        // for each fish that has the direction and weight
        // fish 0 with direction a has weight b
        int survivedFishes = 0;


        Stack<Integer> weightRight = new Stack<>();

        for (int fish = 0; fish < direction.length; fish++) {

            int fishWeight = weight[fish];

            //if fish direction si right
            if (direction[fish] == 1) {
                weightRight.push(weight[fish]);
            } else {
                // exists a fish in out stack ? yes - give me the fish
                int oppositeFishWeight = weightRight.isEmpty() ? -1 : weightRight.pop();
                /* Remember that we need to keep on consuming from the stack while the stack is not empty and the weight
                 * of the fish swimming downstream is smaller than the weight of the fish going upstream.*/
                while (oppositeFishWeight != -1 && fishWeight > oppositeFishWeight) {
                    oppositeFishWeight = weightRight.isEmpty() ? -1 : weightRight.pop();
                }

                // if the stack is empty theo our fish survived
                if (oppositeFishWeight == -1) {
                    survivedFishes++;
                } else {
                    // if the fish in the stack is bigger the fish on the river, fish from stack is bigger
                    // and eat the smaller fish
                    weightRight.push(oppositeFishWeight);
                }
            }
            // if fish direction is left and the fish is first then survive fish

        }
        return survivedFishes ;
    }
}