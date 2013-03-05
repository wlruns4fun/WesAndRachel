describe("Utils:", function() {
	
	describe("refreshListview(list):", function() {
		
		it("refreshes listview", function() {
			affix("#list");
			
			var list = $("#list");
			spyOn(list, "listview");
			
			utils.refreshListview(list);
			
			expect(list.listview).toHaveBeenCalled();
		});
	});
});