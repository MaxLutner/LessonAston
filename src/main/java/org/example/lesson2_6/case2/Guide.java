package org.example.lesson2_6.case2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Guide {
    private Map<String, List<String>> directory;

    public Guide() {
        directory = new HashMap<>();
    }

    public void add(String lastName, String phoneNumber) {

        if (!directory.containsKey(lastName)) {
            directory.put(lastName, new ArrayList<>());
        }
        directory.get(lastName).add(phoneNumber);
    }

    public List<String> get(String lastName) {
        return directory.getOrDefault(lastName, new ArrayList<>());
    }
}
