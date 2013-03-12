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
			playersList += "<li>";
			playersList += "<span name='rank'>" + (index+1) + ".</span>" + " ";
			playersList += "<span name='firstName'>" + player.firstName + "</span>" + " ";
			playersList += "<span name='lastName'>" + player.lastName + "</span>" + " (";
			playersList += "<span name='totalWins'>" + playersModel.getTotalNumWins(player) + "</span>" + "-";
			playersList += "<span name='totalLosses'>" + playersModel.getTotalNumLosses(player) + "</span>" + ")";
			playersList += "<span name='eloRating' class='ui-li-count'>" + player.eloRating + "</span>";
			playersList += "<span name='categories' class='hidden'>" + playersModel.getCategoriesNames(player) + "</span>";
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

$(document).on("pageinit", function(event) {
	playersView.onPageInitCallback();
});