package com.baljinder;

import java.util.ArrayList;
import java.util.List;

/**
 * Add only the unique number from a given list to the new list
 * Example: list--> [1,2,1,2], new list will be--> [2,3]
 */

public class Main {
    public static void main(String[] args) {
        List<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(1);
        numberList.add(3);
        numberList.add(2);
        numberList.add(4);
        numberList.add(5);
        numberList.add(3);

        List<Integer> uniqueNumberList = getUniqueNumberList(numberList);
        for (Integer i : uniqueNumberList) {
            System.out.println(i);
        }
    }

    private static List<Integer> getUniqueNumberList(List<Integer> numberList){
        boolean status = false;
        List<Integer> uniqueNumberList = new ArrayList<>();

        for (int i = 0; i < numberList.size(); i++) {
            for (int j = 0; j < numberList.size(); j++) {
                if (i == j) {
                    continue;
                } else if (numberList.get(i) == numberList.get(j)) {
                    status = true;
                    break;
                } else {
                    status = false;
                }
            }
            if (!status) {
                uniqueNumberList.add(numberList.get(i));
            }
        }
        return uniqueNumberList;
    }
}
