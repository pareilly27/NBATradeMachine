package com.trademachine.nba_trade_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.trademachine.nba_trade_api.repository.FranchiseRepository;
import com.trademachine.nba_trade_api.entity.Franchise;
import java.util.List;


@Service
public class FranchiseService {
    
    @Autowired
    private FranchiseRepository franchiseRepository;
    
    public List<Franchise> getAllFranchises() {
    	return franchiseRepository.findAllTeams();
    }
    
    public Franchise getFranchiseById(Long id) {
        List<Franchise> allFranchises = franchiseRepository.findAllTeams();
        return allFranchises.stream()
            .filter(franchise -> franchise.getId().equals(id))
            .findFirst()
            .orElse(null);
    }
    
    public Franchise saveFranchise(Franchise franchise) {
        return franchiseRepository.save(franchise);
    }
    
    public void deleteFranchise(Long id) {
        franchiseRepository.deleteById(id);
    }
}
