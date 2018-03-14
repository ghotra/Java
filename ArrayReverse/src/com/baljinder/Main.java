package com.baljinder;

import java.util.Scanner;

/**
 * Created by bghotra on 9/9/2017.
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter the size of array ");
        int[] array = new int[scanner.nextInt()];

        System.out.println("Original Array values");
        for(int i=0; i<array.length;i++){
            System.out.println("Enter the #" + (i+1));
            array[i] = scanner.nextInt();
            scanner.nextLine();
        }

        System.out.println("Original Array values");
        for(int i=0; i<array.length;i++){
            System.out.println("Index #" + i + ": " + array[i]);
        }

        int[] array1 = reverseArray(array);

        System.out.println("Reverse Array values");
        for(int i=0; i<array1.length;i++){
            System.out.println("Index #" + i + ": " + array1[i]);
        }

    }

    public static int[] reverseArray(int[] array){
        for(int i=0; i<array.length/2;i++){
            int temp = array[i];
            array[i] = array[array.length-(i+1)];
            array[array.length-(i+1)] = temp;
        }
        return array;
    }
}

