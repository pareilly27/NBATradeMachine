package com.trademachine.nba_trade_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.trademachine.nba_trade_api.entity.Franchise;
import java.util.List;     
import org.springframework.data.jpa.repository.Query; 

@Repository
public interface FranchiseRepository extends JpaRepository<Franchise, Long> {
	@Query(value = "SELECT idTeam as id_team, name, valuesAthleticism as values_athleticism, valuesHeight as values_height, valuesShooting as values_shooting, valuesPostDefense as values_post_defense, valuesPerimeterDefense as values_perimeter_defense, valuesPassing as values_passing, valuesBallHandling as values_ball_handling, valuesRebounding as values_rebounding, valuesYouth as values_youth FROM teams", nativeQuery = true)
	List<Franchise> findAllTeams();
}