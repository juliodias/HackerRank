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
        int totalOfElements = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] numbers = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String reverse = "";
        for (int i = totalOfElements - 1; i >= 0; i--) {
            int number = Integer.parseInt(numbers[i]);
            reverse += number + " ";
        }
        System.out.println(reverse);
        scanner.close();
    }
}

