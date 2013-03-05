describe("PlayersController:", function() {
	
	describe("getPlayers(onSuccessCallback):", function() {
		
		var onSuccessCallback = function() {};

		it("calls ajax request to get Players data", function() {
			spyOn($, "getJSON");
			
			playersController.getPlayers(onSuccessCallback);
			
			expect($.getJSON).toHaveBeenCalled();
		});
	});
});