package com.trademachine.nba_trade_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.trademachine.nba_trade_api.entity.Player;
import com.trademachine.nba_trade_api.entity.Franchise;
import java.util.List;
import com.trademachine.nba_trade_api.model.TradeResult;

@Service
public class TradeService {
    
    @Autowired
    private PlayerService playerService;
    
    @Autowired
    private FranchiseService franchiseService;
    
    public TradeResult calculateTrade(Long team1Id, Long team2Id, 
                                    List<Long> team1PlayerIds, 
                                    List<Long> team2PlayerIds) {
        // Get the franchises
        Franchise team1 = franchiseService.getFranchiseById(team1Id);
        Franchise team2 = franchiseService.getFranchiseById(team2Id);
        
        // Get the players
        List<Player> team1Players = team1PlayerIds.stream()
            .map(id -> playerService.getPlayerById(id))
            .toList();
        List<Player> team2Players = team2PlayerIds.stream()
            .map(id -> playerService.getPlayerById(id))
            .toList();
            
        // Calculate trade values (from your original logic)
        double team1Value = calculateTradeValue(team1Players, team2);
        double team2Value = calculateTradeValue(team2Players, team1);
        
        // Calculate net value
        double netValue = Math.abs(team1Value - team2Value);
        
        // Create result
        TradeResult result = new TradeResult();
        result.setTeam1Value(team1Value);
        result.setTeam2Value(team2Value);
        
        // Determine if trade succeeds (your original logic)
        if (netValue < 50) {
            result.setValid(true);
            result.setMessage("The trade succeeds!");
        } else if (team2Value > team1Value) {
            result.setValid(false);
            result.setMessage(team2.getName() + " do not accept the trade.");
        } else {
            result.setValid(false);
            result.setMessage(team1.getName() + " do not accept the trade.");
        }
        
        return result;
    }
    
    private double calculateTradeValue(List<Player> players, Franchise evaluatingTeam) {
        return players.stream()
            .mapToDouble(player -> 
                player.getAthleticism() * evaluatingTeam.getValuesAthleticism() +
                player.getHeight() * evaluatingTeam.getValuesHeight() +
                player.getShooting() * evaluatingTeam.getValuesShooting() +
                player.getPostDefense() * evaluatingTeam.getValuesPostDefense() +
                player.getPerimeterDefense() * evaluatingTeam.getValuesPerimeterDefense() +
                player.getPassing() * evaluatingTeam.getValuesPassing() +
                player.getBallHandling() * evaluatingTeam.getValuesBallHandling() +
                player.getAge() * evaluatingTeam.getValuesYouth() +
                player.getRebounding() * evaluatingTeam.getValuesRebounding()
            ).sum();
    }
}