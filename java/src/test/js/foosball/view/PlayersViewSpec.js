define(['jquery', 'common/Utils', 'view/PlayersView', 'controller/PlayersController'], 
function($, Utils, PlayersView, PlayersController) {

	describe("PlayersView", function() {
		
		var player1 = {
			id: 1,
			elo: 1000, 
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
			elo: 1000, 
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
			elo: 2000, 
			doublesWins: 0,
			doublesLosses: 0,
			singlesWins: 0,
			singlesLosses: 0,
			prevWins: 0,
			prevLosses: 0,
			categories: []
		};
		
		var playersData = [];
		var emptyData = [];
		
		beforeEach(function() {
			playersData = [player1, player2, player3];
		});
		
		describe(".sortByElo(player1, player2)", function() {
			
			it("sorts Players by Elo rating in decreasing order", function() {
				playersData.sort(PlayersView.sortByElo);
				
				expect(playersData[0].id).toBe(3);
				expect(playersData[1].id).toBe(1);
				expect(playersData[2].id).toBe(2);
			});
		});
		
		describe(".sortByTotalNumGames(player1, player2)", function() {
			
			it("sorts Players by total number of games in decreasing order", function() {
				playersData.sort(PlayersView.sortByTotalNumGames);
				
				expect(playersData[0].id).toBe(2);
				expect(playersData[1].id).toBe(1);
				expect(playersData[2].id).toBe(3);
			});
		});
		
		describe(".sortPlayers(player1, player2)", function() {
			
			it("sorts Players by decreasing Elo rating, then by decreasing total number of games", function() {
				playersData.sort(PlayersView.sortPlayers);
				
				expect(playersData[0].id).toBe(3);
				expect(playersData[1].id).toBe(2);
				expect(playersData[2].id).toBe(1);
			});
		});
		
		describe(".populatePlayersList(data)", function() {
			
			beforeEach(function() {
				affix("#playersList");
				spyOn(Utils, "refreshListview");
			});
			
			it("sorts Players data", function() {
				spyOn(playersData, "sort");
				
				PlayersView.populatePlayersList(playersData);
				
				expect(playersData.sort).toHaveBeenCalledWith(PlayersView.sortPlayers);
			});
			
			it("creates a list item for each Player", function() {
				PlayersView.populatePlayersList(playersData);
				var numPlayers = $("#playersList li").length;
				
				expect(numPlayers).toBe(3);
			});
			
			it("refreshes the listview after populating list", function() {
				PlayersView.populatePlayersList(playersData);
				
				expect(Utils.refreshListview).toHaveBeenCalled();
			});
		});
		
		describe(".onPageInitCallback()", function() {
			
			it("calls the function to get all the Players", function() {
				spyOn(PlayersController, "getPlayers");
				spyOn(PlayersView, "getPlayersCallback");
				
				PlayersView.onPageInitCallback();
				
				expect(PlayersController.getPlayers).toHaveBeenCalledWith(PlayersView.getPlayersCallback);
			});
		});
		
		describe(".getPlayersCallback(data)", function() {
			
			it("calls the function to populate the Players list", function() {
				spyOn(PlayersView, "populatePlayersList");
				
				PlayersView.getPlayersCallback(emptyData);
				
				expect(PlayersView.populatePlayersList).toHaveBeenCalledWith(emptyData);
			});
		});
	});
});