function GamesView() {
	
	this.populateGamesList = function(data) {
		var gamesList = "";
		$.each(data, function(index, game) {
			var date = new Date(game.date);
			
			gamesList += "<li>";
			gamesList += "<span name='date'>" + utils.getDateString(date) + "</span>" + ": ";
			gamesList += "<span name='winner1'>" + playersModel.getFullName(game.winner1) + "</span>";
			if (game.winner2 != null) {
				gamesList += "/<span name='winner2'>" + playersModel.getFullName(game.winner2) + "</span>";
			}
			gamesList += " - ";
			gamesList += "<span name='loser1'>" + playersModel.getFullName(game.loser1) + "</span>";
			if (game.loser2 != null) {
				gamesList += "/<span name='loser2'>" + playersModel.getFullName(game.loser2) + "</span>";
			}
			gamesList += "</li>";
		});
		
		$("#gamesList").html(gamesList);
		utils.refreshListview($("#gamesList"));
	};
};

var gamesView = new GamesView();

$(document).on("pageinit", function(event) {
	gamesController.getGames(gamesView.populateGamesList);
});