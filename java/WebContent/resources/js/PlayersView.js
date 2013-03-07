function PlayersView() {

	this.sortByTotalNumGames = function(player1, player2) {
		var totalNumGames1 = playersModel.getTotalNumGames(player1);
		var totalNumGames2 = playersModel.getTotalNumGames(player2);
		return (totalNumGames2 - totalNumGames1);
	};
	
	this.sortByEloRating = function(player1, player2) {
		var eloRating1 = player1.eloRating;
		var eloRating2 = player2.eloRating;
		return (eloRating2 - eloRating1);
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
			playersList += "<li>";
			playersList += "<span name='rank'>" + (index+1) + ".</span>";
			playersList += " ";
			playersList += "<span name='firstName'>" + player.firstName + "</span> ";
			playersList += " ";
			playersList += "<span name='lastName'>" + player.lastName + "</span>";
			playersList += " (";
			playersList += "<span name='totalWins'>" + playersModel.getTotalNumWins(player) + "</span>";
			playersList += "-";
			playersList += "<span name='totalLosses'>" + playersModel.getTotalNumLosses(player) + "</span>";
			playersList += ")";
			playersList += "<span name='eloRating' class='ui-li-count'>" + player.eloRating + "</span>";
			playersList += "</li>";
		});
		
		$("#playersList").html(playersList);
		utils.refreshListview($("#playersList"));
		utils.hideLoadingWidget();
	};
};

var playersView = new PlayersView();

$(document).on("pageinit", function(event) {
	playersController.getPlayers(playersView.populatePlayersList);
});