describe("PlayersController:", function() {
	
	describe("getPlayers(onSuccessCallback):", function() {
		var doNothing = function() {};

		it("calls ajax request to get Players data", function() {
			spyOn($, "getJSON");
			spyOn(utils, "showLoadingWidget");
			
			playersController.getPlayers(doNothing);
			
			expect($.getJSON).toHaveBeenCalled();
		});
		
		it("shows the loading widget", function() {
			spyOn(utils, "showLoadingWidget");
			
			playersController.getPlayers(doNothing);
			
			expect(utils.showLoadingWidget).toHaveBeenCalled();
		});
	});
});