function PlayersController() {
	
	this.playersService = $ENV + "/foosball/services/players";
	
	this.getPlayers = function(onSuccessCallback) {
		$.getJSON(playersController.playersService, onSuccessCallback);
	};
};

var playersController = new PlayersController();