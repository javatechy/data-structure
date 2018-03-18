package interviews;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
Largest Sum Contiguous Subarray
Pair Sum
*/
class AdobeClass {

    public static void main(String[] argv) throws Exception {
        String str = "I am a Boy I am a";
        String[] splitStr = str.split(" ");
        Map<String, Integer> wordCount = new HashMap<>();
        print(wordCount.size());
        for (String word : splitStr) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }

        for (Entry<String, Integer> map : wordCount.entrySet()) {
            print(map.getKey() + " " + map.getValue());
        }
        // print(wordCount);
    }

    public static void print(Object o) {
        System.out.println(o);
    }
}