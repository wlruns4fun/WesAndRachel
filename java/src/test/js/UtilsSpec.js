describe("Utils:", function() {
	
	describe("refreshListview(list):", function() {
		
		it("refreshes the listview of the corresponding list object", function() {
			affix("#list");
			
			var list = $("#list");
			spyOn(list, "listview");
			
			utils.refreshListview(list);
			
			expect(list.listview).toHaveBeenCalled();
		});
	});
	
	describe("showLoadingWidget():", function() {
		
		it("shows the loading widget", function() {
			spyOn($.mobile, "loading");
			
			utils.showLoadingWidget();
			
			expect($.mobile.loading).toHaveBeenCalledWith("show");
		});
	});
	
	describe("hideLoadingWidget():", function() {
		
		it("hides the loading widget", function() {
			spyOn($.mobile, "loading");
			
			utils.hideLoadingWidget();
			
			expect($.mobile.loading).toHaveBeenCalledWith("hide");
		});
	});
});