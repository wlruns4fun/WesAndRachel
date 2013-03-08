function GamesController() {
	
	this.gamesService = $ENV + "/foosball/services/games";
	
	this.getGames = function(onSuccessCallback) {
		$.getJSON(gamesController.gamesService, onSuccessCallback);
	};
};

var gamesController = new GamesController();