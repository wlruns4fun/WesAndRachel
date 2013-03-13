function PlayersModel() {
	
	var playersMap = {};
	
	this.setPlayersMap = function(players) {
		playersMap = {};
		$.each(players, function(index, player) {
			playersMap[player.id] = player;
		});
	};
	
	this.getPlayer = function(id) {
		return playersMap[id];
	};
	
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
	
	this.getCategoriesString = function(player) {
		var categoriesString = "";
		
		var categories = player.categories;
		$.each(categories, function(index, category) {
			
			categoriesString += category.name;
			if (index < categories.length-1) {
				categoriesString += " ";
			}
		});
		
		return categoriesString;
	};
	
	this.getUniqueCategoriesString = function(players) {
		var uniqueCategoriesString = "";
		
		$.each(players, function(index, player) {
			
			if (player != null) {
				var categories = player.categories;
				$.each(categories, function(index, category) {
					
					var indexOfCategory = uniqueCategoriesString.indexOf(category.name);
					if (-1 == indexOfCategory) {
						if (uniqueCategoriesString.length > 0) {
							uniqueCategoriesString += " ";
						}
						uniqueCategoriesString += category.name;
					}
				});
			}
		});
		
		return uniqueCategoriesString;
	};
	
	this.getFullName = function(player) {
		var fullName = "";
		if (player != null) {
			fullName = player.firstName + " " + player.lastName;
		}
		
		return fullName;
	};
};

var playersModel = new PlayersModel();