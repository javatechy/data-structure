package interviews;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/* IMPORTANT: Multiple classes and nested private classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility  classes
import java.util.*;
*/

class TestClass {

    public static void main(String[] argv) throws Exception {

        new TestClass().logic();
    }

    private  void logic() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.next();
        int N = Integer.parseInt(line);
        List<String> inputs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            inputs.add(scanner.next());
        }
        // List<String> inputs = Arrays.asList("abcd" , "aabc", "abcdcf", "aAcbAZd", "xuVaSva");
        for (String input : inputs) {
            if (input.length() <= 2) {
                print2("" + input.length());
                continue;
            }
            String newInput = input.substring(0, 2);

            long finalCount = 1;

            char[] inputCharArray = input.toCharArray();
            for (int index = 2; index < inputCharArray.length; index++) {
                long dupCount = findDuplicate(newInput);
                long disctinctLength = getUniqeCount(newInput);
                finalCount = disctinctLength + finalCount + dupCount;
                newInput = newInput + inputCharArray[index];
            }
            print2("" + finalCount);
            finalCount = 0;
        }
        scanner.close();
    }

    public  int getUniqeCount(String arg) {
        ArrayList<Character> unique = new ArrayList<Character>();
        for (int i = 0; i < arg.length(); i++)
            if (!unique.contains(arg.charAt(i)))
                unique.add(arg.charAt(i));
        return unique.size();
    }

   
    private void print2(String str) {
        System.out.println("" + str);
    }

    private long findDuplicate(String str) {
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        char[] arr = str.toCharArray();

        for (char value : arr) {

            if (Character.isAlphabetic(value)) {
                if (charMap.containsKey(value)) {
                    charMap.put(value, charMap.get(value) + 1);

                } else {
                    charMap.put(value, 1);
                }
            }
        }
        int count = 0;
        for (int num : charMap.values()) {
            if (num > 1) {
                count++;
            }
        }
        // print2("1 Count "+count);

        return count;
    }

}
