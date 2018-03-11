package com.baljinder;

import java.util.Scanner;

/**
 * A subarray of an -element array is an array composed from a contiguous block of the original array's elements.
 * For example, if array = [1,2,3], then the subarrays are [1],[2],[3],[1,2],[2,3], and [1,2,3]. Something like
 * would not be a subarray as it's not a contiguous subsection of the original array.
 */

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter the length of the array");
        int arrayLength = scanner.nextInt();

        int[] arrayOfNum = new int[arrayLength];
        System.out.println("Enter the values of array");
        for(int i =0; i<arrayOfNum.length;i++){
            System.out.println("Number #" + (i+1));
            arrayOfNum[i] = scanner.nextInt();
        }

        System.out.println(getNegativeSumOfSubArray(arrayOfNum));
    }

    /**
     * Return number of subarray sum is less than 0
     * @param arrayOfNum User input array
     * @return count (number of subarray having sum <0)
     */

    private static int getNegativeSumOfSubArray(int[] arrayOfNum){
        int count = 0;
        int sum;
        for(int i=0;i<arrayOfNum.length;i++){
            if(arrayOfNum[i] < 0){
                count++;
            }
        }
        for(int i=0;i<arrayOfNum.length-1;i++){
            sum = 0;
            sum += arrayOfNum[i];
            for(int j=i+1;j<arrayOfNum.length;j++){
                sum += arrayOfNum[j];
                if(sum < 0){
                    count++;
                }
            }
        }

        return count;
    }
}
