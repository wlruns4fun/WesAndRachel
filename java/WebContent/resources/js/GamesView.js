function GamesView() {
	
	this.sortByDate = function(game1, game2) {
		var date1 = game1.date;
		var date2 = game2.date;
		return (date2 - date1);
	};
	
	this.sortById = function(game1, game2) {
		var id1 = game1.id;
		var id2 = game2.id;
		return (id2 - id1);
	};
	
	this.sortGames = function(game1, game2) {
		var compareDates = gamesView.sortByDate(game1, game2);
		if (0 == compareDates) {
			var compareIds = gamesView.sortById(game1, game2);
			return compareIds;
		} else {
			return compareDates;
		}
	};
	
	this.populateGamesList = function(data) {
		data.sort(gamesView.sortGames);
		
		var gamesList = "";
		$.each(data, function(index, game) {
			var date = new Date(game.date);
			var winner1 = playersModel.getPlayer(game.winner1);
			var winner2 = playersModel.getPlayer(game.winner2);
			var loser1 = playersModel.getPlayer(game.loser1);
			var loser2 = playersModel.getPlayer(game.loser2);
			
			var dateString = utils.getDateString(date);
			var winner1FullName = playersModel.getFullName(winner1);
			var winner2FullName = (winner2 != null ? "/"+playersModel.getFullName(winner2) : "");
			var loser1FullName = playersModel.getFullName(loser1);
			var loser2FullName = (loser2 != null ? "/"+playersModel.getFullName(loser2) : "");
			var shutoutMessage = (game.shutout == true ? "(WALL OF SHAME!)" : "");
			
			gamesList += "<li>";
			gamesList += "<span name='date'>" + dateString + "</span>" + ": ";
			gamesList += "<span name='winner1'>" + winner1FullName + "</span>";
			gamesList += "<span name='winner2'>" + winner2FullName + "</span>" + " - ";
			gamesList += "<span name='loser1'>" + loser1FullName + "</span>";
			gamesList += "<span name='loser2'>" + loser2FullName + "</span>";
			gamesList += " <span name='shutout'>" + shutoutMessage + "</span>";
			gamesList += "</li>";
		});
		
		$("#gamesList").html(gamesList);
		utils.refreshListview($("#gamesList"));
	};
	
	this.onPageInitCallback = function() {
		playersController.getPlayers(gamesView.getPlayersCallback);
	};
	
	this.getPlayersCallback = function(data) {
		playersModel.setPlayersMap(data);
		gamesController.getGames(gamesView.getGamesCallback);
	};
	
	this.getGamesCallback = function(data) {
		gamesView.populateGamesList(data);
	};
};

var gamesView = new GamesView();

$(document).on("pageinit", function(event) {
	gamesView.onPageInitCallback();
});