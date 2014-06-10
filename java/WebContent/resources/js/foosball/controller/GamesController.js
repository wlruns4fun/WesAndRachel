define(['jquery', 'common/Constants'], function ($, Constants) {
	
	var gamesService = Constants.ENV + "/foosball/services/games/" + Constants.DEFAULT_GAMES_PER_PAGE + "/page/1";
	
	var getGames = function(onSuccessCallback) {
		$.getJSON(GamesController.gamesService, onSuccessCallback);
	};
	
	var GamesController = {
		gamesService: gamesService,
		getGames: getGames
	};
	
	return GamesController;
});
