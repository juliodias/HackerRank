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

        for (int multiple = 1; multiple <= 10; multiple++) {
            System.out.println(number + " x " + multiple + " = " + multiply(number, multiple));
        }
        scanner.close();
    }

    private static int multiply(int number, int multiple) {
        return number * multiple;
    }
}
