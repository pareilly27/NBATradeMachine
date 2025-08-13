package com.trademachine.nba_trade_api.model;

import java.util.List;

public class TradeRequest {
    private Long team1Id;
    private Long team2Id;
    private List<Long> team1PlayerIds;
    private List<Long> team2PlayerIds;

    // Getters and Setters
    public Long getTeam1Id() {
        return team1Id;
    }

    public void setTeam1Id(Long team1Id) {
        this.team1Id = team1Id;
    }

    public Long getTeam2Id() {
        return team2Id;
    }

    public void setTeam2Id(Long team2Id) {
        this.team2Id = team2Id;
    }

    public List<Long> getTeam1PlayerIds() {
        return team1PlayerIds;
    }

    public void setTeam1PlayerIds(List<Long> team1PlayerIds) {
        this.team1PlayerIds = team1PlayerIds;
    }

    public List<Long> getTeam2PlayerIds() {
        return team2PlayerIds;
    }

    public void setTeam2PlayerIds(List<Long> team2PlayerIds) {
        this.team2PlayerIds = team2PlayerIds;
    }
}