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
		categories: [{name: "category1"}, {name: "category2"}, {name: "category3"}]
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
		categories: [{name: "category2"}, {name: "category3"}]
	}; 
	
	var player3 = {
		id: 3,
		firstName: "firstName3",
		lastName: "lastName3",
		doublesWins: 3,
		doublesLosses: 3,
		singlesWins: 3,
		singlesLosses: 3,
		prevWins: 3,
		prevLosses: 3,
		categories: [{name: "category2"}, {name: "category3"}]
	};
	
	var players = [];
	
	beforeEach(function() {
		players = [player1, player2, player3];
	});
	
	describe(".setPlayersMap(players)", function() {
		
		it("adds the list of Players to the map", function() {
			playersModel.setPlayersMap(players);
			var playerFromMap1 = playersModel.getPlayer(player1.id);
			var playerFromMap2 = playersModel.getPlayer(player2.id);
			var playerFromMap3 = playersModel.getPlayer(player3.id);
			
			expect(playerFromMap1).not.toBe(undefined);
			expect(playerFromMap2).not.toBe(undefined);
			expect(playerFromMap3).not.toBe(undefined);
		});
	});
	
	describe(".getPlayer(id)", function() {
		
		it("returns the Player object with the corresponding id", function() {
			playersModel.setPlayersMap(players);
			var playerFromMap1 = playersModel.getPlayer(player1.id);
			var playerFromMap2 = playersModel.getPlayer(player2.id);
			var playerFromMap3 = playersModel.getPlayer(player3.id);
			
			expect(playerFromMap1.id).toBe(player1.id);
			expect(playerFromMap2.id).toBe(player2.id);
			expect(playerFromMap3.id).toBe(player3.id);
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
	
	describe(".getCategoriesString(player)", function() {
		
		it("returns a string of all the Player's Categories", function() {
			var expectedCategoriesString = "category1 category2 category3";
			
			var categoriesString = playersModel.getCategoriesString(player1);
			
			expect(categoriesString).toEqual(expectedCategoriesString);
		});
	});
	
	describe(".getCommonCategoriesString(players)", function() {
		
		it("returns a string of only the Categories common to all the Players", function() {
			var expectedCommonCategoriesString = "category2 category3";
			
			var commonCategoriesString = playersModel.getCommonCategoriesString(players);
		
			expect(commonCategoriesString).toEqual(expectedCommonCategoriesString);
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