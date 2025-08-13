NBA Trade Machine

A web-based application that simulates NBA player trades using a sophisticated evaluation algorithm. Users can select teams, propose player trades, and see whether the trade would be accepted based on team preferences and player attributes.

Features
Interactive Web Interface: Clean, responsive UI for selecting teams and players
Dynamic Team Selection: Dropdown menus populated with NBA teams from database
Player Management: View players by team with Add/Remove functionality for trade proposals
Trade Calculation Engine: Advanced algorithm that evaluates trade proposals based on:
Player attributes (athleticism, height, shooting, defense, passing, etc.)
Team preferences and values
Age/youth considerations
Real-time Feedback: Instant trade evaluation with success/failure messaging
Player Images: Integration with NBA player headshots using official player IDs

Technology Stack

Backend
Java 17 
Spring Boot 3.5.4 
Spring Data JPA 
Hibernate 
MySQL 8 
Maven 

Frontend
HTML5/CSS3 
JavaScript (ES6+) 
Bootstrap 5.3.2 
Fetch API 

Project Structure

nba-trade-api/
 src/main/java/com/trademachine/nba_trade_api/
     entity/          # JPA entities (Player, Franchise)
      repository/      # Data access layer
      service/         # Business logic layer
      controller/      # REST API endpoints
      model/           # DTOs (TradeRequest, TradeResult)
      
  src/main/resources/
      static/          # Frontend files (HTML, CSS, JS)
      application.properties  # Database configuration
      pom.xml             # Maven dependencies

Database Schema
Teams Table: Stores franchise information and preference values
Players Table: Contains player stats, attributes, and NBA image IDs
Relationships: Players linked to teams for roster management

API Endpoints
GET /api/teams - Retrieve all teams
GET /api/teams/{id}/players - Get players for specific team
GET /api/players - Retrieve all players
POST /api/trade/calculate - Evaluate trade proposal


Usage
Select Teams: Choose two teams from dropdown menus
View Players: Click "View Players" to see rosters
Build Trade: Use +/- buttons to add/remove players from trade proposal
Calculate: Click "Calculate Trade" to evaluate the proposal
Review Results: See if trade is accepted or rejected with reasoning

Trade Algorithm
The system evaluates trades based on:
Player Value Calculation: Each player's worth to receiving team
Team Preferences: Teams value different attributes (shooting, defense, etc.)
Trade Balance: Difference in total value between proposed player packages
Acceptance Threshold: Trades succeed if value difference is within acceptable range
