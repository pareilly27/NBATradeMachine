package com.trademachine.nba_trade_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;    
import org.springframework.stereotype.Repository;
import com.trademachine.nba_trade_api.entity.Player;
import org.springframework.data.jpa.repository.Query; 

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>{
	@Query(value = "SELECT idPlayer as id_player, PlayerName as player_name, TeamName as team_name, Athleticism as athleticism, Height as height, Shooting as shooting, PostDefense as post_defense, perimeterDefense as perimeter_defense, passing, ballHandling as ball_handling, rebounding, Age as age, image_id FROM Player", nativeQuery = true)
	List<Player> findAllPlayers();

	@Query(value = "SELECT idPlayer as id_player, PlayerName as player_name, TeamName as team_name, Athleticism as athleticism, Height as height, Shooting as shooting, PostDefense as post_defense, perimeterDefense as perimeter_defense, passing, ballHandling as ball_handling, rebounding, Age as age, image_id FROM Player WHERE TeamName = (SELECT name FROM teams WHERE idTeam = ?1 LIMIT 1)", nativeQuery = true)
	List<Player> findPlayersByTeam(Long teamId);
	
	
}
