describe("PlayersModel", function() {
	
	var player1 = {
		id: 1,
		firstName: "firstName1",
		lastName: "lastName1",
		doublesWins: 1,
		doublesLosses: 2,
		singlesWins: 3,
		singlesLosses: 4,
		prevWins: 5,
		prevLosses: 6,
		categories: [{name: "category1"}, {name: "category2"}]
	};
	
	var player2 = {
		id: 2,
		firstName: "firstName2",
		lastName: "lastName2",
		doublesWins: 6,
		doublesLosses: 5,
		singlesWins: 4,
		singlesLosses: 3,
		prevWins: 2,
		prevLosses: 1,
		categories: [{name: "category3"}]
	}; 
	
	var players = [];
	
	beforeEach(function() {
		players = [player1, player2];
	});
	
	describe(".setPlayersMap(players)", function() {
		
		it("adds the list of Players to the map", function() {
			playersModel.setPlayersMap(players);
			var playerFromMap1 = playersModel.getPlayer(player1.id);
			var playerFromMap2 = playersModel.getPlayer(player2.id);
			
			expect(playerFromMap1).not.toBe(undefined);
			expect(playerFromMap2).not.toBe(undefined);
		});
	});
	
	describe(".getPlayer(id)", function() {
		
		it("returns the Player object with the corresponding id", function() {
			playersModel.setPlayersMap(players);
			var playerFromMap1 = playersModel.getPlayer(player1.id);
			var playerFromMap2 = playersModel.getPlayer(player2.id);
			
			expect(playerFromMap1.id).toBe(player1.id);
			expect(playerFromMap2.id).toBe(player2.id);
		});
	});
	
	describe(".getTotalNumGames(player)", function() {
		
		it("returns the total number of games for a Player", function() {
			var totalNumGames = playersModel.getTotalNumGames(player1);
			
			expect(totalNumGames).toBe(21);
		});
	});
	
	describe(".getTotalNumWins(player)", function() {
		
		it("returns the total number of wins for a Player", function() {
			var totalNumWins = playersModel.getTotalNumWins(player1);
			
			expect(totalNumWins).toBe(9);
		});
	});
	
	describe(".getTotalNumLosses(player)", function() {
		
		it("retruns the total number of losses for a Player", function() {
			var totalNumLosses = playersModel.getTotalNumLosses(player1);
			
			expect(totalNumLosses).toBe(12);
		});
	});
	
	describe(".getCategoriesNames(player)", function() {
		
		it("returns a list of all the Player categories' names", function() {
			var expectedCategoriesNames = player1.categories[0].name + " " + player1.categories[1].name;
			
			var categoriesNames = playersModel.getCategoriesNames(player1);
			
			expect(categoriesNames).toEqual(expectedCategoriesNames);
		});
	});
	
	describe(".getFullName(player)", function() {
		
		it("returns the full name of the Player", function() {
			var expectedFullName = player1.firstName + " " + player1.lastName;
			
			var fullName = playersModel.getFullName(player1);
			
			expect(fullName).toBe(expectedFullName);
		});
	});
});