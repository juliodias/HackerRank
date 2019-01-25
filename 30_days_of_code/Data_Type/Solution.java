import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
    public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";
		
        Scanner scan = new Scanner(System.in);

        int integer = i + scan.nextInt();
        double doubl = d + scan.nextDouble();
        scan.nextLine();
        String string = s + scan.nextLine();
        
        System.out.println(integer);
        System.out.println(doubl);
        System.out.println(string);

        scan.close();
    }
}
