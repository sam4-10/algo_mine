import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortByOccurance {
    public static String characterSort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (map.containsKey(a)) {
                int count = map.get(a);
                map.put(a, ++count);
            } else {
                map.put(a, 1);
            }
        }
        System.out.println("map: " + map);
        return map.entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .map(e -> String.valueOf(e.getKey()).repeat(e.getValue()))
                .collect(Collectors.joining(""));

    }

    public static String characterSort2(String s) {
        Map<Character, Integer> map = new HashMap<>();

        // Count frequency
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Sort by frequency (descending) and build output
        return map.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .map(e -> String.valueOf(e.getKey()).repeat(e.getValue()))
                .collect(Collectors.joining(""));
    }


    public static void main(String args[]) {

        String s = "orchastrator";
        String expected = "rrrooaattchs";
        System.out.println("sorted by occurance list : " + characterSort(s));
        System.out.println("sorted by occurance list2 : " + characterSort2(s));
    }
}
