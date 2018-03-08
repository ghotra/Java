package com.baljinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the String");
        String s = scan.next();
        System.out.println("Enter the values of K: ");
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }

    /**
     *
     * @param input :  User input String
     * @param subStringLength : Length of the subStrings to divide (endIndex number)
     * @return
     */
    public static String getSmallestAndLargest(String input, int subStringLength) {
        String smallest = "";
        String largest = "";
        String inputString = input;
        List<String> subStringListArray = new ArrayList<>();
        if (inputString.length() <= subStringLength) {
            smallest = largest = inputString;
        } else {
            for (int i = 0; i < inputString.length() - (subStringLength - 1); i++) {
                subStringListArray.add(inputString.substring(i, i + subStringLength));
            }
            for (int j = 0; j < subStringLength; j++) {
                if (subStringListArray.get(0).equalsIgnoreCase(subStringListArray.get(1))) {
                    smallest = subStringListArray.get(0);
                    largest = subStringListArray.get(0);
                } else if (subStringListArray.get(0).charAt(j) == subStringListArray.get(1).charAt(j)) {
                    continue;
                } else if (subStringListArray.get(0).charAt(j) > subStringListArray.get(1).charAt(j)) {
                    largest = subStringListArray.get(0);
                    smallest = subStringListArray.get(1);
                    break;
                } else {
                    smallest = subStringListArray.get(0);
                    largest = subStringListArray.get(1);
                    break;
                }
            }
            for (int i = 2; i < subStringListArray.size(); i++) {
                for (int j = 0; j < subStringListArray.get(i).length(); j++) {
                    if(subStringListArray.get(i).charAt(j)>smallest.charAt(j)
                            && subStringListArray.get(i).charAt(j)<largest.charAt(j)){
                        break;
                    }else if(subStringListArray.get(i).charAt(j)==smallest.charAt(j)
                            && subStringListArray.get(i).charAt(j)==largest.charAt(j)){
                        continue;
                    }else if(subStringListArray.get(i).charAt(j)<smallest.charAt(j)){
                        smallest = subStringListArray.get(i);
                        break;
                    }else if(subStringListArray.get(i).charAt(j)>largest.charAt(j)){
                        largest = subStringListArray.get(i);
                        break;
                    }else if(subStringListArray.get(i).charAt(j) == smallest.charAt(j)){
                        smallest = getSmallest(subStringListArray,smallest);
                        break;
                    }else if(subStringListArray.get(i).charAt(j) == largest.charAt(j)){
                        largest = getLargest(subStringListArray,largest);
                        break;
                    }
                }
            }
        }
        return smallest + "\n" + largest;
    }

    /**
     *
     * @param subStringValues : List of Substrings
     * @param small : smallest current subString
     * @return
     */

    private static String getSmallest(List<String> subStringValues, String small){
        String smallest = small;
        for (int i = 2; i < subStringValues.size(); i++) {
            for (int j = 0; j < subStringValues.get(i).length(); j++) {
                if (subStringValues.get(i).charAt(j) == smallest.charAt(j)){
                    continue;
                }else if(subStringValues.get(i).charAt(j)<smallest.charAt(j)){
                    smallest = subStringValues.get(i);
                    break;
                }else{
                    break;
                }
            }
        }
        return smallest;
    }

    /**
     *
     * @param subStringValues : List of Substrings
     * @param large : largest current subString
     * @return
     */

    private static String getLargest(List<String> subStringValues, String large){
        String largest = large;
        for (int i = 2; i < subStringValues.size(); i++) {
            for (int j = 0; j < subStringValues.get(i).length(); j++) {
                if (subStringValues.get(i).charAt(j) == largest.charAt(j)){
                    continue;
                }else if(subStringValues.get(i).charAt(j)>largest.charAt(j)) {
                    largest = subStringValues.get(i);
                    break;
                }else{
                    break;
                }
            }
        }

        return largest;
    }
}


