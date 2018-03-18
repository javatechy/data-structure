package interviews;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
Largest Sum Contiguous Subarray
Pair Sum
*/
class BlackRockClass {

    public static void main(String[] argv) throws Exception {
        List<String> list = Arrays.asList("Alex", "Michel", "Harry", "Dave", "Michel", "Victor", "Harry", "Alex", "Mary", "Mary");
        Map<String, Long> map = list.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

       Map<String, Long> map2 = map.entrySet()
            .stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

         map2.entrySet().forEach( entry -> {
         print(entry.getKey() + ":" + entry.getValue());
        });
    }

    public static void print(Object o) {
        System.out.println(o);
    }
}