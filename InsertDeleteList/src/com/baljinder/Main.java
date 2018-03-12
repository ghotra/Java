package com.baljinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Given a list, L , of N integers, perform Q queries on the list. Once all queries are completed,
 * print the modified list as a single line of space-separated integers.
 *
 * The first line contains an integer, N (the initial number of elements in L).
 * The second line contains N space-separated integers describing L.
 * The third line contains an integer, Q (the number of queries).
 * The 2Q subsequent lines describe the queries, and each query is described over two lines:

 * If the first line of a query contains the String Insert, then the second line contains two space separated integers,
 * x y, and the value y must be inserted into L at index x.
 * If the first line of a query contains the String Delete, then the second line contains index x, whose element must be
 * deleted from L.
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> listOfNum = new ArrayList<>();
        System.out.println("Enter the length of list: ");
        int listLength = scanner.nextInt();
        for(int i=0;i<listLength;i++){
            System.out.println("Enter the number #" + (i+1));
            listOfNum.add(scanner.nextInt());
        }
        System.out.println("Enter the number of queries: ");
        int numQueries = scanner.nextInt();

        for(int i=0;i<numQueries;i++) {
            System.out.println("Enter the string insert or delete : ");
            String inputString = scanner.next();
            if (inputString.equalsIgnoreCase("Insert")) {
                System.out.println("Enter the index and new number");
                listOfNum = insertNum(listOfNum, scanner.nextInt(), scanner.nextInt());
            } else if (inputString.equalsIgnoreCase("Delete")) {
                System.out.println("Enter the index number");
                listOfNum = deleteNum(listOfNum, scanner.nextInt());
            }else{
                System.out.println("Invalid Entry...Exiting program");
                System.exit(0);
            }
        }
        scanner.close();
        for(Integer num : listOfNum){
            System.out.println(num.intValue());
        }
    }

    private static List<Integer> insertNum(List<Integer> listOfNum,int indexNum,int newNumber){
        listOfNum.add(indexNum,newNumber);
        return listOfNum;
    }

    private static List<Integer> deleteNum(List<Integer> listOfNum,int indexNum){
        listOfNum.remove(indexNum);
        return listOfNum;
    }
}
