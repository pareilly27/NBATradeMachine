package com.trademachine.nba_trade_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.trademachine.nba_trade_api.service.TradeService;
import com.trademachine.nba_trade_api.model.TradeResult;
import com.trademachine.nba_trade_api.model.TradeRequest;  // Add this line

@RestController
@RequestMapping("/api/trade")
public class TradeController {

    @Autowired
    private TradeService tradeService;

    @PostMapping("/calculate")
    public TradeResult calculateTrade(@RequestBody TradeRequest request) {
        return tradeService.calculateTrade(
            request.getTeam1Id(),
            request.getTeam2Id(),
            request.getTeam1PlayerIds(),
            request.getTeam2PlayerIds()
        );
    }
}