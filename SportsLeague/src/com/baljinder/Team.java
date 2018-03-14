package com.baljinder;
/**
 * Created by bghotra on 8/8/2017.
 */
public class Team {
    private String teamName;
    private int teamScore;

    public Team(String teamName, int teamScore){
        this.teamName = teamName;
        this.teamScore = teamScore;
    }

    public String getTeamName(){
        return this.teamName;
    }

    public int getTeamScore(){
        return this.teamScore;
    }
}
