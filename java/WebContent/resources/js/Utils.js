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
};

var utils = new Utils();

$(document).ajaxStart(function() {
	utils.showLoadingWidget();
});

$(document).ajaxStop(function() {
	utils.hideLoadingWidget();
});