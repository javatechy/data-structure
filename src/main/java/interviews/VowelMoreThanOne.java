package interviews;

import java.util.HashMap;
import java.util.Map;

/**
 * microsoft
 * @author deepak
 *
 */
public class VowelMoreThanOne {

    // Driver program to test above functions
    public static void main(String[] args) {
        print("heel " + findVowel("heel"));
        print("cate " + findVowel("cat"));
        print("deepak " + findVowel("deepak"));
        print("preti " + findVowel("preti"));

    }

    private static void print(Object string) {
        System.out.println(string);

    }

    private static boolean findVowel(String input) {
        Map<Character, Boolean> map = new HashMap<>();
        map.put('a', false);
        map.put('e', false);
        map.put('i', false);
        map.put('o', false);
        map.put('u', false);
        char[] chars = input.toCharArray();
        for (char c : chars) {
            char charcter = Character.toLowerCase(c);
            // print(charcter);
            if (map.get(charcter) == null) {
                continue;
            }
            if (map.get(charcter) == false) {
                map.put(charcter, true);
                continue;
            }
            if (map.get(charcter) == true) {
                return false;
            }
        }
        return true;
    }
}
