define(['jquery', 'common/Constants'], function($, Constants) {
	
	var playersService = Constants.ENV + "/foosball/services/players";
	
	var getPlayers = function(onSuccessCallback) {
		$.getJSON(PlayersController.playersService, onSuccessCallback);
	};
	
	var PlayersController = {
		playersService: playersService,
		getPlayers: getPlayers	
	};
	
	return PlayersController;
});