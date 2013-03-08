describe("PlayersModel", function() {
	
	var player = {
		doublesWins: 1,
		doublesLosses: 2,
		singlesWins: 3,
		singlesLosses: 4,
		prevWins: 5,
		prevLosses: 6,
		categories: [{name: "category1"}, {name: "category2"}]
	};
	
	describe(".getTotalNumGames(player)", function() {
		
		it("returns the total number of games for a Player", function() {
			var totalNumGames = playersModel.getTotalNumGames(player);
			
			expect(totalNumGames).toBe(21);
		});
	});
	
	describe(".getTotalNumWins(player)", function() {
		
		it("returns the total number of wins for a Player", function() {
			var totalNumWins = playersModel.getTotalNumWins(player);
			
			expect(totalNumWins).toBe(9);
		});
	});
	
	describe(".getTotalNumLosses(player)", function() {
		
		it("retruns the total number of losses for a Player", function() {
			var totalNumLosses = playersModel.getTotalNumLosses(player);
			
			expect(totalNumLosses).toBe(12);
		});
	});
	
	describe(".getCategoriesNames(player)", function() {
		
		it("returns a list of all the Player categories' names", function() {
			var expectedCategoriesNames = player.categories[0].name + " " + player.categories[1].name;
			
			var categoriesNames = playersModel.getCategoriesNames(player);
			
			expect(categoriesNames).toEqual(expectedCategoriesNames);
		});
	});
});