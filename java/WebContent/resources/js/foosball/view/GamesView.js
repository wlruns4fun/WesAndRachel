define(['jquery', 'common/Utils', 'controller/PlayersController', 'model/PlayersModel', 'controller/GamesController'], 
function($, Utils, PlayersController, PlayersModel, GamesController) {
	
	var sortByDate = function(game1, game2) {
		var date1 = game1.date;
		var date2 = game2.date;
		return (date2 - date1);
	};
	
	var sortById = function(game1, game2) {
		var id1 = game1.id;
		var id2 = game2.id;
		return (id2 - id1);
	};
	
	var sortGames = function(game1, game2) {
		var compareDates = GamesView.sortByDate(game1, game2);
		if (0 == compareDates) {
			var compareIds = GamesView.sortById(game1, game2);
			return compareIds;
		} else {
			return compareDates;
		}
	};
	
	var populateGamesList = function(data) {
		data.sort(GamesView.sortGames);
		
		var gamesList = "";
		$.each(data, function(index, game) {
			var date = new Date(game.date);
			var winner1 = PlayersModel.getPlayer(game.winner1);
			var winner2 = PlayersModel.getPlayer(game.winner2);
			var loser1 = PlayersModel.getPlayer(game.loser1);
			var loser2 = PlayersModel.getPlayer(game.loser2);
			var players = [winner1, winner2, loser1, loser2];
			
			var dateString = Utils.getDateString(date);
			var winner1FullName = PlayersModel.getFullName(winner1);
			var winner2FullName = (winner2 != null ? "/" + PlayersModel.getFullName(winner2) : "");
			var loser1FullName = PlayersModel.getFullName(loser1);
			var loser2FullName = (loser2 != null ? "/" + PlayersModel.getFullName(loser2) : "");
			var shutoutMessage = (game.shutout == true ? "(WALL OF SHAME!)" : "");
			var commonCategories = PlayersModel.getCommonCategoriesString(players);
			
			gamesList += "<li>";
			gamesList += "<span name='date'>" + dateString + "</span>" + ": ";
			gamesList += "<span name='winner1'>" + winner1FullName + "</span>";
			gamesList += "<span name='winner2'>" + winner2FullName + "</span>" + " - ";
			gamesList += "<span name='loser1'>" + loser1FullName + "</span>";
			gamesList += "<span name='loser2'>" + loser2FullName + "</span>" + " ";
			gamesList += "<span name='shutout'>" + shutoutMessage + "</span>";
			gamesList += "<span name='commonCategories' class='hidden'>" + commonCategories + "</span>";
			gamesList += "</li>";
		});
		
		$("#gamesList").html(gamesList);
		Utils.refreshListview($("#gamesList"));
	};
	
	var onPageInitCallback = function() {
		PlayersController.getPlayers(GamesView.getPlayersCallback);
	};
	
	var getPlayersCallback = function(data) {
		PlayersModel.setPlayersMap(data);
		GamesController.getGames(GamesView.getGamesCallback);
	};
	
	var getGamesCallback = function(data) {
		GamesView.populateGamesList(data);
	};
	
	var GamesView = {
		sortByDate: sortByDate,
		sortById: sortById,
		sortGames: sortGames,
		populateGamesList: populateGamesList,
		onPageInitCallback: onPageInitCallback,
		getPlayersCallback: getPlayersCallback,
		getGamesCallback: getGamesCallback
	};
	
	return GamesView;
});