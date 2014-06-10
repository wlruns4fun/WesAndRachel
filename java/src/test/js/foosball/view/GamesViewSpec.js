define(['jquery', 'common/Utils', 'view/GamesView', 'controller/GamesController', 'model/PlayersModel', 'controller/PlayersController'], 
function($, Utils, GamesView, GamesController, PlayersModel, PlayersController) {

	describe("GamesView", function() {
		
		var player1 = {id: 1, categories: []};
		
		var game1 = {
			id: 3,
			date: new Date(2000, 1, 1),
			winner1: player1,
			winner2: player1,
			loser1: player1,
			loser2: player1,
			shutout: false
		};
		
		var game2 = {
			id: 1,
			date: new Date(2000, 1, 1),
			winner1: player1,
			winner2: player1,
			loser1: player1,
			loser2: player1,
			shutout: false
		};
		
		var game3 = {
			id: 2,
			date: new Date(2000, 1, 2),
			winner1: player1,
			winner2: player1,
			loser1: player1,
			loser2: player1,
			shutout: false
		};
		
		var gamesData = [];
		var emptyData = [];
		
		beforeEach(function() {
			gamesData = [game1, game2, game3];
		});
		
		describe(".sortByDate(game1, game2)", function() {
			
			it("sorts games by date in decreasing order", function() {
				gamesData.sort(GamesView.sortByDate);
				
				expect(gamesData[0].id).toBe(2);
				expect(gamesData[1].id).toBe(3);
				expect(gamesData[2].id).toBe(1);
			});
		});
		
		describe(".sortById(game1, game2)", function() {
			
			it("sorts games by id in decreasing order", function() {
				gamesData.sort(GamesView.sortById);
				
				expect(gamesData[0].id).toBe(3);
				expect(gamesData[1].id).toBe(2);
				expect(gamesData[2].id).toBe(1);
			});
		});
		
		describe(".sortGames(game1, game2)", function() {
			
			it("sorts games by decreasing date, then by decreasing id", function() {
				gamesData.sort(GamesView.sortGames);
				
				expect(gamesData[0].id).toBe(2);
				expect(gamesData[1].id).toBe(3);
				expect(gamesData[2].id).toBe(1);
			});
		});
		
		describe(".populateGamesList(data)", function() {
			
			beforeEach(function() {
				affix("#gamesList");
				spyOn(PlayersModel, "getCommonCategoriesString");
				spyOn(Utils, "refreshListview");
			});
			
			it("sorts Games data", function() {
				spyOn(gamesData, "sort");
				
				GamesView.populateGamesList(gamesData);
				
				expect(gamesData.sort).toHaveBeenCalledWith(GamesView.sortGames);
			});
			
			it("creates a list item for each Game", function() {
				GamesView.populateGamesList(gamesData);
				var numGames = $("#gamesList li").length;
				
				expect(numGames).toBe(3);
			});
			
			it("refreshes the listview after populating list", function() {
				GamesView.populateGamesList(gamesData);
				
				expect(Utils.refreshListview).toHaveBeenCalled();
			});
		});
		
		describe(".onPageInitCallback()", function() {
			
			it("calls the function to get all Players", function() {
				spyOn(PlayersController, "getPlayers");
				spyOn(GamesView, "getPlayersCallback");
				
				GamesView.onPageInitCallback();
				
				expect(PlayersController.getPlayers).toHaveBeenCalledWith(GamesView.getPlayersCallback);
			});
		});
		
		describe(".getPlayersCallback(data)", function() { 
			
			it("calls the function to set the Players map", function() {
				spyOn(PlayersModel, "setPlayersMap");
				
				GamesView.getPlayersCallback(emptyData);
				
				expect(PlayersModel.setPlayersMap).toHaveBeenCalledWith(emptyData);
			});
			
			it("calls the function to get all the Games", function() {
				spyOn(GamesController, "getGames");
				spyOn(GamesView, "getGamesCallback");
				
				GamesView.getPlayersCallback(emptyData);
				
				expect(GamesController.getGames).toHaveBeenCalledWith(GamesView.getGamesCallback);
			});
		});
		
		describe(".getGamesCallback(data)", function() {
			
			it("calls the function to populate the Games list", function() {
				spyOn(GamesView, "populateGamesList");
				
				GamesView.getGamesCallback(emptyData);
				
				expect(GamesView.populateGamesList).toHaveBeenCalledWith(emptyData);
			});
		});
	});
});