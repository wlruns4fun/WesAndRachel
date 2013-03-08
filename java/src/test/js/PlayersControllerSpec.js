describe("PlayersController", function() {
	
	describe(".getPlayers(onSuccessCallback)", function() {
		var doNothing = function() {};

		it("calls ajax request to get Players data", function() {
			spyOn($, "getJSON");
			
			playersController.getPlayers(doNothing);
			
			expect($.getJSON).toHaveBeenCalled();
		});
	});
});