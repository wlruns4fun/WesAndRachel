define(['jquery'], function($) {
	
	var playersMap = {};
	
	var setPlayersMap = function(players) {
		playersMap = {};
		$.each(players, function(index, player) {
			playersMap[player.id] = player;
		});
	};
	
	var getPlayer = function(id) {
		return playersMap[id];
	};
	
	var getTotalNumGames = function(player) {
		var totalNumGames = 0;
		totalNumGames += player.doublesWins;
		totalNumGames += player.doublesLosses;
		totalNumGames += player.singlesWins;
		totalNumGames += player.singlesLosses;
		totalNumGames += player.prevWins;
		totalNumGames += player.prevLosses;
		
		return totalNumGames;
	};
	
	var getTotalNumWins = function(player) {
		var totalNumWins = 0;
		totalNumWins += player.doublesWins;
		totalNumWins += player.singlesWins;
		totalNumWins += player.prevWins;
		
		return totalNumWins;
	};
	
	var getTotalNumLosses = function(player) {
		var totalNumLosses = 0;
		totalNumLosses += player.doublesLosses;
		totalNumLosses += player.singlesLosses;
		totalNumLosses += player.prevLosses;
		
		return totalNumLosses;
	};
	
	var getCategoriesString = function(player) {
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
	
	var getCommonCategoriesString = function(players) {
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
	
	var getFullName = function(player) {
		var fullName = "";
		if (player != null) {
			fullName = player.firstName + " " + player.lastName;
		}
		
		return fullName;
	};
	
	var PlayersModel = {
		setPlayersMap: setPlayersMap,
		getPlayer: getPlayer,
		getTotalNumGames: getTotalNumGames,
		getTotalNumWins: getTotalNumWins,
		getTotalNumLosses: getTotalNumLosses,
		getCategoriesString: getCategoriesString,
		getCommonCategoriesString: getCommonCategoriesString,
		getFullName: getFullName
	};
	
	return PlayersModel;
});