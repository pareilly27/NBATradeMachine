package com.trademachine.nba_trade_api.model;

public class TradeResult {
    private boolean isValid;
    private String message;
    private double team1Value;
    private double team2Value;
    
    // Constructor
    public TradeResult() {}
    
    // Getters and Setters
    public boolean isValid() {
        return isValid;
    }
    
    public void setValid(boolean valid) {
        isValid = valid;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public double getTeam1Value() {
        return team1Value;
    }
    
    public void setTeam1Value(double team1Value) {
        this.team1Value = team1Value;
    }
    
    public double getTeam2Value() {
        return team2Value;
    }
    
    public void setTeam2Value(double team2Value) {
        this.team2Value = team2Value;
    }
}