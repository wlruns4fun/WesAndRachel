function PlayersView() {

	this.sortByElo = function(player1, player2) {
		var elo1 = player1.elo;
		var elo2 = player2.elo;
		return (elo2 - elo1);
	};
	
	this.sortByTotalNumGames = function(player1, player2) {
		var totalNumGames1 = playersModel.getTotalNumGames(player1);
		var totalNumGames2 = playersModel.getTotalNumGames(player2);
		return (totalNumGames2 - totalNumGames1);
	};
	
	this.sortPlayers = function(player1, player2) {
		var compareElos = playersView.sortByElo(player1, player2);
		if (0 == compareElos) {
			var compareTotalNumGames = playersView.sortByTotalNumGames(player1, player2);
			return compareTotalNumGames;
		} else {
			return compareElos;
		}
	};
	
	this.populatePlayersList = function(data) {
		data.sort(playersView.sortPlayers);
		
		var playersList = "";
		$.each(data, function(index, player) {
			var rank = (index + 1);
			var firstName = player.firstName;
			var lastName = player.lastName;
			var totalWins = playersModel.getTotalNumWins(player);
			var totalLosses = playersModel.getTotalNumLosses(player);
			var elo = player.elo;
			var categories = playersModel.getCategoriesString(player);
			
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
		utils.refreshListview($("#playersList"));
	};
	
	this.onPageInitCallback = function() {
		playersController.getPlayers(playersView.getPlayersCallback);
	};
	
	this.getPlayersCallback = function(data) {
		playersView.populatePlayersList(data);
	};
};

var playersView = new PlayersView();

$(document).ready(function() {
	playersView.onPageInitCallback();
});