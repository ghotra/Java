package com.baljinder;

import java.util.Scanner;

/**
 * Print "Anagrams" if String1 and String2  are case-insensitive anagrams of each other; otherwise, print "Not Anagrams" instead
 */

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter the first string");
        String inputString1 = scanner.nextLine();
        System.out.println("Enter the second string");
        String inputString2 = scanner.nextLine();

        inputString1 = sortCharacters(inputString1);
        inputString2 = sortCharacters(inputString2);
        if(inputString1.equalsIgnoreCase(inputString2)){
            System.out.println("String are anagrams");
        }else{
            System.out.println("String are not anagrams");
        }

        scanner.close();
    }

    /**
     *
     * @param inputString UserInput string to sort characters
     * @return a string with sorted characters
     */
    private static String sortCharacters(String inputString){
        char temp;
        //Remove this if the strings are case sensitive
        inputString = inputString.toLowerCase();
        char[] charArray = new char[inputString.length()];
        for(int i=0; i<inputString.length();i++){
            charArray[i] = inputString.charAt(i);
        }
        for(int i =0; i<charArray.length-1;i++){
            for(int j=i+1;j<charArray.length;j++){
                if(charArray[j] < charArray[i]){
                    temp = charArray[i];
                    charArray[i] = charArray[j];
                    charArray[j] = temp;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(char c : charArray){
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
