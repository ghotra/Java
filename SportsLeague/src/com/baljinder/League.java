package com.baljinder;

import java.util.ArrayList;

/**
 * Created by bghotra on 8/8/2017.
 */
public class League<T extends Team> {
    private String leagueName;
    private ArrayList<T> teamList = new ArrayList<>();

    public League(String leagueName){
        this.leagueName = leagueName;
    }

    public void addTeam(T team){
        //check if the team is already existed
        if(teamList.contains(team.getTeamName())){
            System.out.println("Team already existed in the league " + this.leagueName);
        }else{
            teamList.add(team);
            System.out.println("Team " + team.getTeamName() + " successfully added in the league " + this.leagueName);
        }
    }

    public ArrayList<T> getTeamList(){
        return teamList;
    }

    public void rankTeam(ArrayList<T> team){
        T highestTeam = team.get(0);
        for(int i=0; i<team.size()-1;i++){
            for(int j=(i+1);j<team.size();j++){
                if(team.get(j).getTeamScore()>highestTeam.getTeamScore()){
                    highestTeam = team.get(j);
                    team.set(j,team.get(i));
                    team.set(i, highestTeam);
                }
            }
        }

        System.out.println("Sorted List of team are; ");
        for(int i=0; i<team.size();i++){
            System.out.println("Team #" + (i+1) + " " + teamList.get(i).getTeamName() + "-->" + teamList.get(i).getTeamScore());
        }
    }

}
