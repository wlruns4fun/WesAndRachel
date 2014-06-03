function GamesController() {
	
	this.gamesService = $ENV + "/foosball/services/games/page/0/100";
	
	this.getGames = function(onSuccessCallback) {
		$.getJSON(gamesController.gamesService, onSuccessCallback);
	};
};

var gamesController = new GamesController();