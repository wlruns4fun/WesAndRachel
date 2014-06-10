define(['jquery', 'common/Utils', 'controller/PlayersController', 'model/PlayersModel'], 
function($, Utils, PlayersController, PlayersModel) {

	var sortByElo = function(player1, player2) {
		var elo1 = player1.elo;
		var elo2 = player2.elo;
		return (elo2 - elo1);
	};
	
	var sortByTotalNumGames = function(player1, player2) {
		var totalNumGames1 = PlayersModel.getTotalNumGames(player1);
		var totalNumGames2 = PlayersModel.getTotalNumGames(player2);
		return (totalNumGames2 - totalNumGames1);
	};
	
	var sortPlayers = function(player1, player2) {
		var compareElos = PlayersView.sortByElo(player1, player2);
		if (0 == compareElos) {
			var compareTotalNumGames = PlayersView.sortByTotalNumGames(player1, player2);
			return compareTotalNumGames;
		} else {
			return compareElos;
		}
	};
	
	var populatePlayersList = function(data) {
		data.sort(PlayersView.sortPlayers);
		
		var playersList = "";
		$.each(data, function(index, player) {
			var rank = (index + 1);
			var firstName = player.firstName;
			var lastName = player.lastName;
			var totalWins = PlayersModel.getTotalNumWins(player);
			var totalLosses = PlayersModel.getTotalNumLosses(player);
			var elo = player.elo;
			var categories = PlayersModel.getCategoriesString(player);
			
			playersList += "<li>";
			playersList += "<span name='rank'>" + rank + ".</span>" + " ";
			playersList += "<span name='firstName'>" + firstName + "</span>" + " ";
			playersList += "<span name='lastName'>" + lastName + "</span>" + " (";
			playersList += "<span name='totalWins'>" + totalWins + "</span>" + "-";
			playersList += "<span name='totalLosses'>" + totalLosses + "</span>" + ")";
			playersList += "<span name='elo' class='ui-li-count'>" + elo + "</span>";
			playersList += "<span name='categories' class='hidden'>" + categories + "</span>";
			playersList += "</li>";
		});
		
		$("#playersList").html(playersList);
		Utils.refreshListview($("#playersList"));
	};
	
	var onPageInitCallback = function() {
		PlayersController.getPlayers(PlayersView.getPlayersCallback);
	};
	
	var getPlayersCallback = function(data) {
		PlayersView.populatePlayersList(data);
	};
	
	var PlayersView = {
		sortByElo: sortByElo,
		sortByTotalNumGames: sortByTotalNumGames,
		sortPlayers: sortPlayers,
		populatePlayersList: populatePlayersList,
		onPageInitCallback: onPageInitCallback,
		getPlayersCallback: getPlayersCallback
	};
	
	return PlayersView;
});