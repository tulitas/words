package com.company;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class ValueComparator implements Comparator<String> {
    private Map<String, Integer> base;

    ValueComparator(HashMap<String, Integer> base) {
        this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with
    // equals.
    public int compare(String a, String b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        }
    }
}
