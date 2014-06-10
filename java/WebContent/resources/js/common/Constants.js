define([], function() {
	
	var DEV = "http://localhost:8080/WesAndRachel";
	var PROD = "http://wesandrachel.com";
	
	var Constants = {
		ENV: DEV,
		DEFAULT_GAMES_PER_PAGE: 100
	};
	
	return Constants;
});