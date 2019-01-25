import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int number = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        if (isEven(number) && inRangeOf(number, 2, 5)) {
            System.out.println("Not Weird");
        } else if (isEven(number) && inRangeOf(number, 6, 20)) {
            System.out.println("Weird");
        } else if (isEven(number) && number > 20) {
            System.out.println("Not Weird");
        } else {
            System.out.println("Weird");
        }
        scanner.close();
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static boolean inRangeOf(int number, int initialNumber, int finalNumber) {
        return number >= initialNumber && number <= finalNumber; 
    }

}

