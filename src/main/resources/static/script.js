// Add event listeners when page loads
document.addEventListener('DOMContentLoaded', function() {
    loadTeams();
    
    // Add event listener for View Players button
    document.getElementById('seePlayers').addEventListener('click', viewPlayers);
    
    // Add event listener for Calculate Trade button
    document.getElementById('calcTrade').addEventListener('click', calculateTrade);
});

// Track players and their proposal status
let playersData = {
    team1: [],
    team2: []
};

// Store team information for displaying names
let teamNames = {
    team1: '',
    team2: ''
};

// Fetch teams from backend and populate dropdowns
async function loadTeams() {
    const response = await fetch('/api/teams');
    const teams = await response.json();
    populateDropdowns(teams);
}

// Add teams to both dropdown menus
function populateDropdowns(teams) {
    const team1Select = document.getElementById('teamOneInput');
    const team2Select = document.getElementById('teamTwoInput');
    
    teams.forEach(team => {
        const option = new Option(team.name, team.id);
        team1Select.add(option.cloneNode(true));
        team2Select.add(option);
    });
}

// View Players button functionality
async function viewPlayers() {
    const team1Id = document.getElementById('teamOneInput').value;
    const team2Id = document.getElementById('teamTwoInput').value;
    
    if (!team1Id || !team2Id) {
        alert('Please select both teams first!');
        return;
    }
    
    try {
        // Get team names from the dropdowns
        const team1Select = document.getElementById('teamOneInput');
        const team2Select = document.getElementById('teamTwoInput');
        teamNames.team1 = team1Select.options[team1Select.selectedIndex].text.toUpperCase();
        teamNames.team2 = team2Select.options[team2Select.selectedIndex].text.toUpperCase();
        
        const team1Response = await fetch(`/api/teams/${team1Id}/players`);
        const team2Response = await fetch(`/api/teams/${team2Id}/players`);
        
        if (!team1Response.ok || !team2Response.ok) {
            console.error('API call failed');
            return;
        }
        
        const team1Players = await team1Response.json();
        const team2Players = await team2Response.json();
        
        // Add isPartOfProposal property to each player
        playersData.team1 = team1Players.map(player => ({...player, isPartOfProposal: false}));
        playersData.team2 = team2Players.map(player => ({...player, isPartOfProposal: false}));
        
        displayPlayers();
    } catch (error) {
        console.error('Error fetching players:', error);
    }
}

// Display players from both teams with Add/Remove buttons
function displayPlayers() {
    const teamLeft = document.getElementById('teamLeft');
    const teamRight = document.getElementById('teamRight');
    
    teamLeft.innerHTML = `
    <h3>${teamNames.team1}</h3>
    ${playersData.team1.map((player, index) => 
        `<div class="player">
            <img src="https://cdn.nba.com/headshots/nba/latest/1040x760/${player.imageId}.png" 
                 alt="${player.name}" 
                 class="player-image"
                 onerror="this.src='https://via.placeholder.com/40x40/cccccc/333333?text=?'">
            <span class="player-name">${player.name}</span>
            <div class="player-buttons">
                <button id="add-1-${index}" onclick="addPlayer(1, ${index})" 
                        style="background-color: ${player.isPartOfProposal ? 'lightgreen' : ''};">+</button>
                <button id="remove-1-${index}" onclick="removePlayer(1, ${index})">-</button>
            </div>
        </div>`
    ).join('')}
`;
    
    teamRight.innerHTML = `
    <h3>${teamNames.team2}</h3>
    ${playersData.team2.map((player, index) => 
        `<div class="player">
            <img src="https://cdn.nba.com/headshots/nba/latest/1040x760/${player.imageId}.png" 
                 alt="${player.name}" 
                 class="player-image"
                 onerror="this.src='https://via.placeholder.com/40x40/cccccc/333333?text=?'">
            <span class="player-name">${player.name}</span>
            <div class="player-buttons">
                <button id="add-2-${index}" onclick="addPlayer(2, ${index})" 
                        style="background-color: ${player.isPartOfProposal ? 'lightgreen' : ''};">+</button>
                <button id="remove-2-${index}" onclick="removePlayer(2, ${index})">-</button>
            </div>
        </div>`
    ).join('')}
`;
    
    document.getElementById('results').style.display = 'flex';
}

// Add player to trade
function addPlayer(teamNumber, playerIndex) {
    const teamKey = `team${teamNumber}`;
    playersData[teamKey][playerIndex].isPartOfProposal = true;
    
    // Update button color
    const addButton = document.getElementById(`add-${teamNumber}-${playerIndex}`);
    addButton.style.backgroundColor = 'lightgreen';
    
    console.log(`Added ${playersData[teamKey][playerIndex].name} to proposal`);
    logCurrentProposal();
}

// Remove player from trade
function removePlayer(teamNumber, playerIndex) {
    const teamKey = `team${teamNumber}`;
    playersData[teamKey][playerIndex].isPartOfProposal = false;
    
    // Reset button color
    const addButton = document.getElementById(`add-${teamNumber}-${playerIndex}`);
    addButton.style.backgroundColor = '';
    
    console.log(`Removed ${playersData[teamKey][playerIndex].name} from proposal`);
    logCurrentProposal();
}

// Helper function to log current proposal
function logCurrentProposal() {
    const proposal = {
        team1: playersData.team1.filter(p => p.isPartOfProposal),
        team2: playersData.team2.filter(p => p.isPartOfProposal)
    };
    console.log('Current proposal:', proposal);
}

// Calculate Trade functionality
async function calculateTrade(event) {
    event.preventDefault();
    
    // Get players in proposal
    const team1Players = playersData.team1.filter(p => p.isPartOfProposal);
    const team2Players = playersData.team2.filter(p => p.isPartOfProposal);
    
    if (team1Players.length === 0 || team2Players.length === 0) {
        alert('Please select players from both teams!');
        return;
    }
    
    // Create trade request
    const tradeRequest = {
        team1Id: parseInt(document.getElementById('teamOneInput').value),
        team2Id: parseInt(document.getElementById('teamTwoInput').value),
        team1PlayerIds: team1Players.map(p => p.id),
        team2PlayerIds: team2Players.map(p => p.id)
    };
    
    console.log('Sending trade request:', tradeRequest);
    
    try {
        const response = await fetch('/api/trade/calculate', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(tradeRequest)
        });
        
        if (!response.ok) {
            throw new Error('Trade calculation failed');
        }
        
        const result = await response.json();
        displayTradeResult(result);
    } catch (error) {
        console.error('Error calculating trade:', error);
        alert('Error calculating trade. Please try again.');
    }
}

// Display the trade calculation result
function displayTradeResult(result) {
    const messageDiv = document.getElementById('message');
    messageDiv.textContent = result.message;
    messageDiv.style.color = result.isValid ? 'green' : 'red';
}