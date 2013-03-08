describe("GamesView", function() {
	
	var game1 = {
		date: Date(2013, 2, 1),
		winner1: {},
		winner2: {},
		loser1: {},
		loser2: {},
		shutout: false
	};
	
	var game2 = {
		date: Date(2013, 2, 2),
		winner1: {},
		winner2: {},
		loser1: {},
		loser2: {},
		shutout: false
	};
	
	var game3 = {
		date: Date(2013, 2, 3),
		winner1: {},
		winner2: {},
		loser1: {},
		loser2: {},
		shutout: false
	};
	
	var gamesData = [];
	beforeEach(function() {
		gamesData = [game1, game2, game3];
	});
	
	describe(".populateGamesList(data)", function() {
		
		beforeEach(function() {
			affix("#gamesList");
		});
		
		it("creates a list item for each Game", function() {
			spyOn(utils, "refreshListview");
			
			gamesView.populateGamesList(gamesData);
			var numGames = $("#gamesList li").length;
			
			expect(numGames).toBe(3);
		});
		
		it("refreshes the listview after populating list", function() {
			spyOn(utils, "refreshListview");
			
			gamesView.populateGamesList(gamesData);
			
			expect(utils.refreshListview).toHaveBeenCalled();
		});
	});
});