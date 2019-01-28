import java.util.*;
import java.io.*;

class Solution{

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String []args) {
        int totalOfElements = scanner.nextInt();

        Map<String, Integer> phoneBook = new HashMap<>();
        for (int i = 0; i < totalOfElements; i++) {
            String name = scanner.next();
            int phone = scanner.nextInt();
            phoneBook.put(name, phone);
        }

        while (scanner.hasNext()) {
            String name = scanner.next();
            Integer value = phoneBook.get(name);
            if (value == null) {
                System.out.println("Not found");
            } else {
                System.out.println(name + "=" + value);
            }
        }
        scanner.close();
    }
}


