import java.io.*;
import java.util.*;

public class Solution {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> allWords = new ArrayList<>();
        int numberOfTestsCase = scanner.nextInt();

        scanner.nextLine();
        for (int timesToTest = 1; timesToTest <= numberOfTestsCase; timesToTest++) {
            String oddWord = "";
            String evenWord = "";
            String word = scanner.nextLine();

            for (int index = 0; index < word.length(); index++) {
                if (isEven(index)) {
                    evenWord += word.charAt(index);
                } else {
                    oddWord += word.charAt(index);
                }
            }
            allWords.add(evenWord + " " + oddWord);
        }
        allWords.forEach(System.out::println);
        scanner.close();
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}


