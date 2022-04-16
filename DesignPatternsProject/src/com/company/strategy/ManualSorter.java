package com.company.strategy;

import java.util.List;

public class ManualSorter implements Sorter {
    @Override
    public List<String> sort(List<String> list) {
        for (int i = 0; i < list.size() - 1; ++i) {
            for (int j = i + 1; j < list.size(); ++j) {
                char charArray1[] = list.get(i).toCharArray();
                char charArray2[] = list.get(j).toCharArray();
                int length = Math.min(list.get(i).length(), list.get(j).length());
                int isFirstInOrder = 0;
                for(int k=0;k<length;++k){
                    if(charArray1[k]<charArray2[k]){
                        isFirstInOrder = -1;
                        break;
                    }
                    else if (charArray1[k]>charArray2[k]){
                        isFirstInOrder = 1;
                        break;
                    }
                }
                if(isFirstInOrder==0){
                    if(list.get(i).length() < list.get(j).length())
                        isFirstInOrder = -1;
                    else
                        isFirstInOrder = 1;
                }
                if (isFirstInOrder == 1) {
                    String x = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, x);
                }
            }
        }

        return list;
    }
}
