

/* write a piece of code that accepts a string and returns whether that string is valid or not.
* The string that our code will accept, will be composed of a specific alphabet.
* The string can only contain one of six different types of characters. It can contain either the open
* or the close round brackets (), the curly brackets {} or the square brackets [].
* our solution needs to determine whether the input string is a properly nested string or not.
* properly nested : "[()()]" Every inner bracket that has been open has been closed before we close the outer ones.
* in this case if we give this particular string to our solution it should output 'valid'.
* "[(]()]" -  an example where our string is not properly nested.square bracket is being closed before we close
* the round bracket.
* "[{()}]" example of a properly nested string. Every single bracket that we have open has been closed
* before the other one.
* "[]" invalid one. because we are closing the square bracket in this case before we are opening it.
* ()[]{}()[]{} properly nested string.
* We need to write a function or a method called solution excepting one parameter called a. And a is our
* input string. Our code should determine whether the string is valid or not and return 1 if the string
* is correctly nested or 0if it's not.*/

import java.util.Stack;

public class Brackets {

    public static void main(String[] args) {

        System.out.println("Solution: " + solution("[({})]()"));
        System.out.println("Solution: " + solution("[(]()]"));


    }

    //return 1 if the string is correctly nested or 0 if it's not.
    public static int solution(String a){

        // is our bracket an open or a closed one ?
        char openRoundBracket = '(';
        char openCurlyBracket = '{';
        char openSquareBracket = '[';
        char closedRoundBracket = ')';
        char closedCurlyBracket = '}';
        char closedSquareBracket = ']';

        // need to iterate over all the brackets from out string
        Stack<Character> chars = new Stack<>();

        for (int i = 0; i < a.length(); i++) {

            char ch = a.charAt(i);

            if ((ch == openRoundBracket) || (ch == openCurlyBracket) || (ch == openSquareBracket)) {
                chars.push(ch);
            }

            if ((ch == closedRoundBracket) || (ch == closedCurlyBracket) || (ch == closedSquareBracket)) {
                char stackChar = chars.pop();

                if ((stackChar == openCurlyBracket) && (ch != closedCurlyBracket)) {
                    return 0;
                }
                if (stackChar == openRoundBracket && ch != closedRoundBracket) {
                    return 0;
                }
                if ((stackChar == openSquareBracket) && (ch != closedSquareBracket)) {
                    return 0;
                }
            }
        }
        return chars.isEmpty() ? 1 : 0;
    }
}
