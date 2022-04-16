package com.company.strategy;

import java.util.Collections;
import java.util.List;

public class AutomaticSorter implements Sorter{
    @Override
    public List<String> sort(List<String> list) {
        Collections.sort(list);
        return list;
    }
}
