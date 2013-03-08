function Utils() {

	this.refreshListview = function(list) {
		if (list != null) {
			list.listview("refresh");
		}
	};
	
	this.showLoadingWidget = function() {
		$.mobile.loading("show");
	};
	
	this.hideLoadingWidget = function() {
		$.mobile.loading("hide");
	};
	
	this.addLeadingZeros = function(value, digits) {
		var valueString = String(value);
		while (valueString.length < digits) {
			valueString = "0" + valueString;
		}
		
		return valueString;
	};
	
	this.getDateString = function(date) {
		var dateString = "";
		if (date != null) {
			dateString += date.getUTCFullYear() + "-";
			dateString += utils.addLeadingZeros(date.getUTCMonth()+1, 2) + "-";
			dateString += utils.addLeadingZeros(date.getUTCDate(), 2);
		}
		
		return dateString;
	};
};

var utils = new Utils();

$(document).ajaxStart(function() {
	utils.showLoadingWidget();
});

$(document).ajaxStop(function() {
	utils.hideLoadingWidget();
});