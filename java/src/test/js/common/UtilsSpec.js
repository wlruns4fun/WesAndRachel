define(['jquery', 'jqueryMobile', 'jasmineFixture', 'common/Utils'], 
function($, jqueryMobile, jasmineFixture, Utils) {
	
	describe("Utils", function() {

	
		describe(".refreshListview(list)", function() {
			
			it("refreshes the listview of the corresponding list object", function() {
				affix("#list");
				
				var list = $("#list");
				spyOn(list, "listview");
				
				Utils.refreshListview(list);
				
				expect(list.listview).toHaveBeenCalled();
			});
		});
		
		describe(".showLoadingWidget()", function() {
			
			it("shows the loading widget", function() {
				spyOn($.mobile, "loading");
				
				Utils.showLoadingWidget();
				
				expect($.mobile.loading).toHaveBeenCalledWith("show");
			});
		});
		
		describe(".hideLoadingWidget()", function() {
			
			it("hides the loading widget", function() {
				spyOn($.mobile, "loading");
				
				Utils.hideLoadingWidget();
				
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
				
				var nineWithOneDigit = Utils.addLeadingZeros(9, 1);
				var nineWithTwoDigits = Utils.addLeadingZeros(9, 2);
				var nineWithThreeDigits = Utils.addLeadingZeros(9, 3);
				
				var tenWithOneDigit = Utils.addLeadingZeros(10, 1);
				var tenWithTwoDigits = Utils.addLeadingZeros(10, 2);
				var tenWithThreeDigits = Utils.addLeadingZeros(10, 3);
				
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
				
				var dateString = Utils.getDateString(date);
				
				expect(dateString).toBe(expectedDateString);
			});
		});
	});
});