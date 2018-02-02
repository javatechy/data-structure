package geeksforgeeks;

import java.util.Arrays;

/**
Largest Sum Contiguous Subarray
Pair Sum
*/
class AdobeClass2 {

    public static void main(String[] argv) throws Exception {
        String str = "ADBCDDD";
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        
        for(char c: charArray) {
            print(c);
        }
        //print(wordCount);
    }

    public static void print(Object o) {
        System.out.print(o);
    }
}