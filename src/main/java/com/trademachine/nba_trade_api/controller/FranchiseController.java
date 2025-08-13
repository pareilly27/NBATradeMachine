package com.trademachine.nba_trade_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.trademachine.nba_trade_api.service.FranchiseService;
import com.trademachine.nba_trade_api.entity.Franchise;
import com.trademachine.nba_trade_api.service.PlayerService;
import com.trademachine.nba_trade_api.entity.Player;
import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class FranchiseController {

    @Autowired
    private FranchiseService franchiseService;
    
    @Autowired
    private PlayerService playerService;  // ADD THIS LINE

    @GetMapping
    public List<Franchise> getAllFranchises() {
        return franchiseService.getAllFranchises();
    }

    @GetMapping("/{id}")
    public Franchise getFranchiseById(@PathVariable Long id) {
        return franchiseService.getFranchiseById(id);
    }

    @PostMapping
    public Franchise createFranchise(@RequestBody Franchise franchise) {
        return franchiseService.saveFranchise(franchise);
    }

    @DeleteMapping("/{id}")
    public void deleteFranchise(@PathVariable Long id) {
        franchiseService.deleteFranchise(id);
    }
    
    @GetMapping("/{id}/players")
    public List<Player> getPlayersByTeam(@PathVariable Long id) {
        return playerService.getPlayersByTeam(id);  // CHANGE THIS LINE (remove the capital S)
    }
}