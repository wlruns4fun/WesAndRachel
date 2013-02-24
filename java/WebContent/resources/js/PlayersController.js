function PlayersController() {

	var domain = "http://localhost:8080/WesAndRachel";
	
	this.playersService = domain + "/foosball/services/players";
	
	this.getPlayers = function(onSuccessCallback) {
		$.getJSON(this.playersService, onSuccessCallback);
	};
};

var playersController = new PlayersController();