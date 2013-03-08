describe("Utils", function() {
	
	describe(".refreshListview(list)", function() {
		
		it("refreshes the listview of the corresponding list object", function() {
			affix("#list");
			
			var list = $("#list");
			spyOn(list, "listview");
			
			utils.refreshListview(list);
			
			expect(list.listview).toHaveBeenCalled();
		});
	});
	
	describe(".showLoadingWidget()", function() {
		
		it("shows the loading widget", function() {
			spyOn($.mobile, "loading");
			
			utils.showLoadingWidget();
			
			expect($.mobile.loading).toHaveBeenCalledWith("show");
		});
	});
	
	describe(".hideLoadingWidget()", function() {
		
		it("hides the loading widget", function() {
			spyOn($.mobile, "loading");
			
			utils.hideLoadingWidget();
			
			expect($.mobile.loading).toHaveBeenCalledWith("hide");
		});
	});
	
	describe(".addLeadingZeros(value, digits)", function() {
		
		it("adds leading zeros if necessary", function() {
			var expectedNineWithOneDigit = "9";
			var expectedNineWithTwoDigits = "09";
			var expectedNineWithThreeDigits = "009";
			
			var expectedTenWithOneDigit = "10";
			var expectedTenWithTwoDigits = "10";
			var expectedTenWithThreeDigits = "010";
			
			var nineWithOneDigit = utils.addLeadingZeros(9, 1);
			var nineWithTwoDigits = utils.addLeadingZeros(9, 2);
			var nineWithThreeDigits = utils.addLeadingZeros(9, 3);
			
			var tenWithOneDigit = utils.addLeadingZeros(10, 1);
			var tenWithTwoDigits = utils.addLeadingZeros(10, 2);
			var tenWithThreeDigits = utils.addLeadingZeros(10, 3);
			
			expect(nineWithOneDigit).toBe(expectedNineWithOneDigit);
			expect(nineWithTwoDigits).toBe(expectedNineWithTwoDigits);
			expect(nineWithThreeDigits).toBe(expectedNineWithThreeDigits);
			
			expect(tenWithOneDigit).toBe(expectedTenWithOneDigit);
			expect(tenWithTwoDigits).toBe(expectedTenWithTwoDigits);
			expect(tenWithThreeDigits).toBe(expectedTenWithThreeDigits);
		});
	});
	
	describe(".getDateString(date)", function() {
		
		it("returns a date string in the 'YYYY-MM-DD' format", function() {
			var date = new Date(2000, 0, 1);
			var expectedDateString = "2000-01-01";
			
			var dateString = utils.getDateString(date);
			
			expect(dateString).toBe(expectedDateString);
		});
	});
});