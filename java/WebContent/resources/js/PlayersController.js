function PlayersController() {
	
	this.playersService = $ENV + "/foosball/services/players";
	
	this.getPlayers = function(onSuccessCallback) {
		$.getJSON(this.playersService, onSuccessCallback);
		utils.showLoadingWidget();
	};
};

var playersController = new PlayersController();