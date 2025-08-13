package com.trademachine.nba_trade_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.trademachine.nba_trade_api.repository.PlayerRepository;
import com.trademachine.nba_trade_api.entity.Player;
import java.util.List;

@Service
public class PlayerService {
	
	 @Autowired
	    private PlayerRepository playerRepository;
	    
	    public List<Player> getAllPlayers() {
	    	return playerRepository.findAllPlayers(); 
	    }
	    
	    public Player getPlayerById(Long id) {
	        List<Player> allPlayers = playerRepository.findAllPlayers();
	        return allPlayers.stream()
	            .filter(player -> player.getId().equals(id))
	            .findFirst()
	            .orElse(null);
	    }
	    
	    
	    public Player savePlayer(Player player) {
	        return playerRepository.save(player);
	    }
	    
	    public void deletePlayer(Long id) {
	        playerRepository.deleteById(id);
	    }
	    
	    public List<Player> getPlayersByTeam(Long teamId) {
	        return playerRepository.findPlayersByTeam(teamId);
	    }

}
