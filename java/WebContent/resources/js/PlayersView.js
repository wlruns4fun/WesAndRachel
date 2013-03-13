function PlayersView() {

	this.sortByEloRating = function(player1, player2) {
		var eloRating1 = player1.eloRating;
		var eloRating2 = player2.eloRating;
		return (eloRating2 - eloRating1);
	};
	
	this.sortByTotalNumGames = function(player1, player2) {
		var totalNumGames1 = playersModel.getTotalNumGames(player1);
		var totalNumGames2 = playersModel.getTotalNumGames(player2);
		return (totalNumGames2 - totalNumGames1);
	};
	
	this.sortPlayers = function(player1, player2) {
		var compareEloRatings = playersView.sortByEloRating(player1, player2);
		if (0 == compareEloRatings) {
			var compareTotalNumGames = playersView.sortByTotalNumGames(player1, player2);
			return compareTotalNumGames;
		} else {
			return compareEloRatings;
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
			var eloRating = player.eloRating;
			var categories = playersModel.getCategoriesString(player);
			
			playersList += "<li>";
			playersList += "<span name='rank'>" + rank + ".</span>" + " ";
			playersList += "<span name='firstName'>" + firstName + "</span>" + " ";
			playersList += "<span name='lastName'>" + lastName + "</span>" + " (";
			playersList += "<span name='totalWins'>" + totalWins + "</span>" + "-";
			playersList += "<span name='totalLosses'>" + totalLosses + "</span>" + ")";
			playersList += "<span name='eloRating' class='ui-li-count'>" + eloRating + "</span>";
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