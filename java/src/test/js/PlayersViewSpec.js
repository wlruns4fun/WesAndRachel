describe("PlayersView", function() {
	
	var player1 = {
		id: 1,
		eloRating: 1000, 
		doublesWins: 1,
		doublesLosses: 1,
		singlesWins: 1,
		singlesLosses: 1,
		prevWins: 1,
		prevLosses: 1,
		categories: []
	};
	
	var player2 = {
		id: 2,
		eloRating: 1000, 
		doublesWins: 2,
		doublesLosses: 2,
		singlesWins: 2,
		singlesLosses: 2,
		prevWins: 2,
		prevLosses: 2,
		categories: []
	};
	
	var player3 = {
		id: 3,
		eloRating: 2000, 
		doublesWins: 0,
		doublesLosses: 0,
		singlesWins: 0,
		singlesLosses: 0,
		prevWins: 0,
		prevLosses: 0,
		categories: []
	};
	
	var playersData = [];
	beforeEach(function() {
		playersData = [player1, player2, player3];
	});
	
	describe(".sortByTotalNumGames(player1, player2)", function() {
		
		it("sorts Players by total number of games in decreasing order", function() {
			playersData.sort(playersView.sortByTotalNumGames);
			
			expect(playersData[0].id).toBe(2);
			expect(playersData[1].id).toBe(1);
			expect(playersData[2].id).toBe(3);
		});
	});
	
	describe(".sortByEloRating(player1, player2)", function() {
		
		it("sorts Players by Elo rating in decreasing order", function() {
			playersData.sort(playersView.sortByEloRating);
			
			expect(playersData[0].id).toBe(3);
			expect(playersData[1].id).toBe(1);
			expect(playersData[2].id).toBe(2);
		});
	});
	
	describe(".sortPlayers(player1, player2)", function() {
		
		it("sorts Players by decreasing Elo rating, then by decreasing total number of games", function() {
			playersData.sort(playersView.sortPlayers);
			
			expect(playersData[0].id).toBe(3);
			expect(playersData[1].id).toBe(2);
			expect(playersData[2].id).toBe(1);
		});
	});
	
	describe(".populatePlayersList(data)", function() {
		
		beforeEach(function() {
			affix("#playersList");
		});
		
		it("sorts Players data", function() {
			spyOn(playersData, "sort");
			spyOn(utils, "refreshListview");
			
			playersView.populatePlayersList(playersData);
			
			expect(playersData.sort).toHaveBeenCalledWith(playersView.sortPlayers);
		});
		
		it("creates a list item for each Player", function() {
			spyOn(utils, "refreshListview");
			
			playersView.populatePlayersList(playersData);
			var numPlayers = $("#playersList li").length;
			
			expect(numPlayers).toBe(3);
		});
		
		it("refreshes the listview after populating list", function() {
			spyOn(utils, "refreshListview");
			
			playersView.populatePlayersList(playersData);
			
			expect(utils.refreshListview).toHaveBeenCalled();
		});
	});
});