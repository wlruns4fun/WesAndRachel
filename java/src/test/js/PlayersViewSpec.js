describe("PlayersView:", function() {
	
	describe("populatePlayersList(data):", function() {
		
		var playersJson = [{lastName: 1}, {lastName: 2}, {lastName: 3}];
		var doNothing = function(){};
		
		beforeEach(function() {
			affix("#playersList");
		});
		
		it("creates a list item for each Player", function() {
			spyOn(utils, "refreshListview").andCallFake(doNothing);
			
			playersView.populatePlayersList(playersJson);
			var numPlayers = $("#playersList li").length;
			
			expect(numPlayers).toBe(3);
		});
		
		it("refreshes the listview after populating list", function() {
			spyOn(utils, "refreshListview").andCallFake(doNothing);
			
			playersView.populatePlayersList(playersJson);
			
			expect(utils.refreshListview).toHaveBeenCalled();
		});
	});
});