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
			
			if (category != null) {
				categoriesString += category.name;
				if (index < categories.length-1) {
					categoriesString += " ";
				}
			}
		});
		
		return categoriesString;
	};
	
	this.getCommonCategoriesString = function(players) {
		var commonCategories = {categories: []};
		
		var firstPlayer = players[0];
		var firstPlayerCategories = firstPlayer.categories;
		$.each(firstPlayerCategories, function(index, category) {
			commonCategories.categories.push(category);
		});
		
		// check all the other Players
		for (var i=1; i<players.length; i++) {
			
			var otherPlayer = players[i];
			if (otherPlayer != null) {

				// check each of the common Categories...
				$.each(commonCategories.categories, function(commonCategoryIndex, commonCategory) {
					
					if (commonCategory != null) {
						var hasCategoryInCommon = false;
						
						// ...against the other Player's Categories...
						var otherCategories = otherPlayer.categories;
						$.each(otherCategories, function(otherCategoryIndex, otherCategory) {
							
							// ...to see if they have the Category in common
							var commonCategoryName = commonCategory.name;
							var otherCategoryName = otherCategory.name;
							var indexOfCategory = commonCategoryName.indexOf(otherCategoryName);
							if (indexOfCategory >= 0) {
								hasCategoryInCommon = true;
							}
						});
						
						// remove the common Category if other Players don't have it in common
						if (!hasCategoryInCommon) {
							commonCategories.categories[commonCategoryIndex] = null;
						}
					}
				});
			}
		}
		
		commonCategoriesString = this.getCategoriesString(commonCategories);
		return commonCategoriesString;
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