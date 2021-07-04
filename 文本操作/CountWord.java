import java.util.*;

import java.util.regex.Matcher;

import java.util.regex.Pattern;

public class CountWord {
    public static void main(String[] args) {

        String str = "Statistics suggest that the population of this country will be double in ten years' time this country will Statistics suggest that the population of this country will be double in ten years' time this country will";
        String string[] = str.split(" ");
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < string.length; i++) {
//			System.out.println(string[i]);
            if (!map.containsKey(string[i])) {
                map.put(string[i], 1);
            } else {
                map.put(string[i], map.get(string[i]) + 1);
            }

        }

        Set<String> set = map.keySet();
        Iterator<String> iter = set.iterator();
        while (iter.hasNext()) {

            String word = iter.next();
            int count = map.get(word);
            System.out.println(word + "---" + count);


        }

    }

}
