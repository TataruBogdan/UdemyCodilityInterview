import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        /*System.out.println("Regular price: ");
        double regular = Double.parseDouble(scanner.next());
        scanner.nextLine();
        System.out.println("Percent off: ");
        double percentOff = Double.parseDouble(scanner.next());

        double sale = discount(regular, percentOff);

        System.out.printf("Sales Price %.2f\n", sale);*/

        /*System.out.println("Dollar amount: ");
        double amount = scanner.nextDouble();
        double pennies = amount * 100;
        System.out.printf("Pennies %.2f\n", pennies );*/


        /* RECURSION
        *   Think of a pyramid - physical structure - is a recursive structure
        *   a structure that's defined in terms of itself
        *   what does a pyramid of height 4 look like?
        *   it's a pyramid of height of 3 plus 1 row
        *   so on ...
        *   base case
        *   it's a pyramid of height of 1 ?
        *   it's a pyramid of no height plus 1 row */

        char c1 = 'H';
        char c2 = 'J';
        char c3 = 'K';
        String someString = "Hi you are stupid";
        for (int i = 0; i < someString.length(); i++) {
            System.out.print(someString.charAt(i));
        }

        System.out.println();

        System.out.println("char\0" + someString.charAt(0));


        System.out.printf("Chars: %c %c %c\n", c1, c2, c3);
        System.out.printf("char H " + Character.getNumericValue(c1) + "\n");

        System.out.println(someString.charAt(1));
        String newString = someString.replace('i', 'y');
        if (newString.equals(someString)) {
            System.out.println("Same string");;
        } else {
            System.out.println("Not the same string");
        }
        System.out.println(someString.length());

    }

    public static double discount(double price, double percentage ) {

        return price * (100 - percentage) /  100;

    }
}