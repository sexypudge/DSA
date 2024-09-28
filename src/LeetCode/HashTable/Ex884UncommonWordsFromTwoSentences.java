package LeetCode.HashTable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Ex884UncommonWordsFromTwoSentences {

    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> count = new HashMap<>();

        for (String word : A.split(" "))
            count.put(
                    word,
                    count.getOrDefault(word, 0) + 1
            );
        for (String word : B.split(" "))
            count.put(
                    word,
                    count.getOrDefault(word, 0) + 1
            );

        List<String> ans = new LinkedList<>();
        for (String word : count.keySet())
            if (count.get(word) == 1) ans.add(
                    word
            );

        return ans.toArray(new String[0]);
    }
}
