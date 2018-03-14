package com.baljinder;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Create a generic class to implement a league table for a sport.
  The class should allow teams to be added to the list, and store
  a list of teams that belong to the league.

  The class should have a method to print out the teams in order,
  with the team at the top of the league printed first.

  Only teams of the same type should be added to any particular
  instance of the league class - the program should fail to compile
  if an attempt is made to add an incompatible team.
 */

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Cricket cricketTeam;
    private static Football footballTeam;
    private static Swimming swimmingTeam;
    private static League<Cricket> cricketLeague = new League<>("WC2017");
    private static League<Football> footballLeague = new League<>("FIFA WC2017");
    private static League<Swimming> swimmingLeague = new League<>("Olympics 2017");

    public static void main(String [] args){
       boolean quit = false;
       while(!quit){
           printMenu();
           System.out.println("Enter the choice : ");
           int choice = scanner.nextInt();
           scanner.nextLine();
           switch (choice){
               case 0:
                   printMenu();
                   break;
               case 1:
                   addCricketTeam();
                   break;
               case 2:
                   addFootballTeam();
                   break;
               case 3:
                   addSwimmingTeam();
                   break;
               case 4:
                   printTeams();
                   break;
               case 5:
                   sortTeam();
                   break;
               case 6:
                   quit = true;
                   break;
           }
       }


    }

    public static void printMenu(){
        System.out.println("0 - to print Menu" +
                            "\n1 - to add a Cricket team" +
                            "\n2 - to add a football team" +
                            "\n3 - to add a swimming team" +
                            "\n4 - to print teams in the league" +
                            "\n5 - to sort teams" +
                            "\n6 - to quit");
    }

    public static void addCricketTeam(){
        System.out.println("Enter the name of cricket team you want to add");
        String team = scanner.nextLine();
        System.out.println("Enter the score of team " + team);
        int teamScore = scanner.nextInt();
        scanner.nextLine();
        cricketTeam = new Cricket(team,teamScore);
        cricketLeague.addTeam(cricketTeam);
    }

    public static void addFootballTeam(){
        System.out.println("Enter the name of football team you want to add");
        String team = scanner.nextLine();
        System.out.println("Enter the score of team " + team);
        int teamScore = scanner.nextInt();
        scanner.nextLine();
        footballTeam = new Football(team,teamScore);
        footballLeague.addTeam(footballTeam);
    }

    public static void addSwimmingTeam(){
        System.out.println("Enter the name of swimming team you want to add");
        String team = scanner.nextLine();
        System.out.println("Enter the score of team " + team);
        int teamScore = scanner.nextInt();
        scanner.nextLine();
        swimmingTeam = new Swimming(team,teamScore);
        swimmingLeague.addTeam(swimmingTeam);
    }

    public static void printTeams(){
        printTeamList();
        boolean quit = false;
        while(!quit){
            System.out.println("Enter the league for which you want to print the teams of: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    printTeamList();
                    break;
                case 1:
                    ArrayList<Cricket> cricTeam = cricketLeague.getTeamList();
                    for(int i=0; i<cricTeam.size();i++){
                        System.out.println("Team # " + (i+1) + " is " + cricTeam.get(i).getTeamName()
                        + "-->" + cricTeam.get(i).getTeamScore());
                    }
                    break;
                case 2:
                    ArrayList<Football> footballTeam = footballLeague.getTeamList();
                    for(int i=0; i<footballTeam.size();i++){
                        System.out.println("Team # " + (i+1) + " is " + footballTeam.get(i).getTeamName()
                                + "-->" + footballTeam.get(i).getTeamScore());
                    }
                    break;
                case 3:
                    ArrayList<Swimming> swimmingTeam = swimmingLeague.getTeamList();
                    for(int i=0; i<swimmingTeam.size();i++){
                        System.out.println("Team # " + (i+1) + " is " + swimmingTeam.get(i).getTeamName()
                                + "-->" + swimmingTeam.get(i).getTeamScore());
                    }
                  break;
                case 4:
                    quit = true;
                    break;
            }
        }
    }

    public static void printTeamList(){
        System.out.println("0- to print menu"
                + "\n 1- for Cricket WC2017"
                + "\n 2- for Football FIFA 2017"
                + "\n 3- for Swimming olympics"
                + "\n4- to quit");
    }

    public static void sortTeam(){
        System.out.println("Enter the type of league for teams to sort: ");
        String input = scanner.nextLine();
        if(input.equalsIgnoreCase("Cricket")){
            ArrayList<Cricket> cricTeam = cricketLeague.getTeamList();
            cricketLeague.rankTeam(cricTeam);
        }else if(input.equalsIgnoreCase("Football")){
            ArrayList<Football> footballTeam = footballLeague.getTeamList();
            footballLeague.rankTeam(footballTeam);
        }else if(input.equalsIgnoreCase("Swimming")){
            ArrayList<Swimming> swimmingTeam = swimmingLeague.getTeamList();
            swimmingLeague.rankTeam(swimmingTeam);
        }else{
            System.out.println("Please enter a valid type of team");
        }
    }

}
