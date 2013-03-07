function PlayersModel() {
	
	this.getTotalNumGames = function(player) {
		var totalNumGames = 0;
		totalNumGames += player.doublesWins;
		totalNumGames += player.doublesLosses;
		totalNumGames += player.singlesWins;
		totalNumGames += player.singlesLosses;
		totalNumGames += player.prevWins;
		totalNumGames += player.prevLosses;
		
		return totalNumGames;
	};
	
	this.getTotalNumWins = function(player) {
		var totalNumWins = 0;
		totalNumWins += player.doublesWins;
		totalNumWins += player.singlesWins;
		totalNumWins += player.prevWins;
		
		return totalNumWins;
	};
	
	this.getTotalNumLosses = function(player) {
		var totalNumLosses = 0;
		totalNumLosses += player.doublesLosses;
		totalNumLosses += player.singlesLosses;
		totalNumLosses += player.prevLosses;
		
		return totalNumLosses;
	};
};

var playersModel = new PlayersModel();