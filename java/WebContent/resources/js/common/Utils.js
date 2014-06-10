define(['jquery'], function($) {
	
	var refreshListview = function(list) {
		if (list != null) {
			list.listview("refresh");
		}
	};

	var showLoadingWidget = function() {
		$.mobile.loading("show");
	};
	
	var hideLoadingWidget = function() {
		$.mobile.loading("hide");
	};
	
	var addLeadingZeros = function(value, digits) {
		var valueString = String(value);
		while (valueString.length < digits) {
			valueString = "0" + valueString;
		}
		return valueString;
	};
	
	var getDateString = function(date) {
		var dateString = "";
		if (date != null) {
			dateString += date.getUTCFullYear() + "-";
			dateString += Utils.addLeadingZeros(date.getUTCMonth()+1, 2) + "-";
			dateString += Utils.addLeadingZeros(date.getUTCDate(), 2);
		}
		return dateString;
	};
	
	var Utils = {
		refreshListview: refreshListview,
		showLoadingWidget: showLoadingWidget,
		hideLoadingWidget: hideLoadingWidget,
		addLeadingZeros: addLeadingZeros,
		getDateString: getDateString
	};
	
	return Utils;
});