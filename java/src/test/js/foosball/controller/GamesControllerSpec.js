define(['jquery', 'controller/GamesController'], function($, GamesController) {

	describe("GamesController", function() {
		
		describe(".getGames(onSuccessCallback)", function() {
			var doNothing = function() {};
	
			it("calls ajax request to get Games data", function() {
				spyOn($, "getJSON");
				
				GamesController.getGames(doNothing);
				
				expect($.getJSON).toHaveBeenCalled();
			});
		});
	});
});