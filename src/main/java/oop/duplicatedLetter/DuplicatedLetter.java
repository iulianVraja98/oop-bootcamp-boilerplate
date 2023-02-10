package oop.duplicatedLetter;

import java.util.*;

public class DuplicatedLetter {
    public static Set<String> findDuplicates(List<String> stringList) {
        Map<String, Integer> letterFoundMap = new HashMap<>();
        Set<String> duplicateList = new HashSet<>();

        for (String letter : stringList) {
            if (letterFoundMap.get(letter) == null) {
                letterFoundMap.put(letter, 1);
            } else {
                duplicateList.add(letter);
            }
        }
        return duplicateList;
    }
}
