package com.baljinder;

import java.util.Scanner;

/**
 * An abstract class to define items that can be stored in a list.
 * The class should contain 2 references to items which will represent the next and previous
   items (in the case of a linked list).
 * The class will also need methods to move to the next item and back to the previous item,
   and methods to set the next and previous items.
 * Create a concrete class from the abstract list item class and use this in a LinkedList
  class to implement a linked list that will add items in order (so that they are sorted
  alphabetically). Duplicate values are not added.

 * If the head of the list is null, make the head refer to the item to be added.
 * If the item to be added is less than the current item in the list, add the item before the
   current item (i.e., make the previous item's "next" refer to the new item, and the new item's "next" refer to
   the current item).
 * If the item to be added is greater than the current item, move onto the next item and compare
   again (if there is no next item then that is where the new item belongs).
 */

public class Main {
    private static Node list = new Node(null);
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String stringData = "5 7 3 9 8 2 1 0 4 6";
        String[] data = stringData.split(" ");
        for (String s : data) {
            list.addItem(new ItemList(s));
        }

        boolean quit = true;
        while(quit){
            printMenu();
            System.out.println("Enter a choice");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = false;
                    System.out.println("Exiting");
                    break;
                case 1:
                    addItem();
                    break;
                case 2:
                    removeItem();
                    break;
                case 3:
                    traverseList();
                    break;
                case 4:
                    printMenu();
                    break;
                default:
                    System.out.println("Invalid input...Exiting");
                    System.exit(0);
                    break;
            }
        }
    }

    private static void printMenu(){
        System.out.println( "0  - to quit\n"
                          + "1  - add item to list\n"
                          + "2  - remove item from list\n"
                          + "3  - traverse list\n"
                          + "4  - print menu");
    }

    private static void addItem(){
        System.out.println("Enter an item to add to the list");
        if(list.addItem(new ItemList(String.valueOf(scanner.nextInt())))){
            System.out.println("Added Successfully");
        }else{
            System.out.println("Can't add, duplicate item value");
        }
    }

    private static void removeItem(){
        System.out.println("Enter an item to remove from the list");
        if(list.removeItem(new ItemList(String.valueOf(scanner.nextInt())))){
            System.out.println("Removed Successfully");
        }else{
            System.out.println("Can't removed, item not found");
        }
    }

    private static void traverseList(){
        list.traverse(list.getRoot());
    }
}
