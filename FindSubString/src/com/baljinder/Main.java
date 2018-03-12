package com.baljinder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Find the smallest and largest subString without using inbuilt functions
 * given a String and length of substring
 * For example, ball < cat, dog < dorm, Happy < happy, Zoo < ball
 */

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the String");
        String inputString = scan.next();
        System.out.println("Enter the values of K: ");
        int subStringLength = scan.nextInt();
        scan.close();


        //Method to find smallest and largest without using in-built functions
        System.out.println(getSmallestAndLargest(inputString, subStringLength));
        //Method to find smallest and largest using Collections library
        //System.out.println(getSmallestAndLargestUsingFunctions(inputString,subStringLength));

        scan.close();

    }

    /**
     * Find smallest and largest substrings without using in-built functions
     * @param inputString :  User input String
     * @param subStringLength : Length of the subStrings to divide (endIndex number)
     * @return smallest and largest substrings
     */
    public static String getSmallestAndLargest(String inputString, int subStringLength) {
        String smallest = "";
        String largest = "";
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
        return "smallest substring: " + smallest + " \nlargest substring: " + largest;
    }

    /**
     *
     * @param subStringValues : List of Substrings
     * @param small : smallest current subString
     * @return smallest substring
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
     * @return largest substring
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

    /**
     * Find smallest and largest substrings using in-built functions
     * @param inputString :  User input String
     * @param subStringLength : Length of the subStrings to divide (endIndex number)
     * @return smallest and largest substring
     */

    private static String getSmallestAndLargestUsingFunctions(String inputString, int subStringLength){
        String smallest;
        String largest;
        List<String> subStringValues = new ArrayList<>();
        if(inputString.length() <= subStringLength){
            smallest = largest = inputString;
        }else{
            for(int i =0;i<inputString.length()-(subStringLength-1);i++){
                subStringValues.add(inputString.substring(i,i+subStringLength));
            }
            Collections.sort(subStringValues);
            smallest = subStringValues.get(0);
            largest = subStringValues.get(subStringValues.size()-1);
        }
        return "smallest substring: " + smallest + " \nlargest substring: " + largest;
    }
}


