describe("GamesController", function() {
	
	describe(".getGames(onSuccessCallback)", function() {
		var doNothing = function() {};

		it("calls ajax request to get Games data", function() {
			spyOn($, "getJSON");
			
			gamesController.getGames(doNothing);
			
			expect($.getJSON).toHaveBeenCalled();
		});
	});
});