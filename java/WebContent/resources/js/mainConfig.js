require.config({
	baseUrl: 'resources/js/lib',
	paths: {
		jquery:			'jquery-1.9.1.min',
		jqueryMobile:	'jquery.mobile-1.3.0.min',
		common:			'../common',
		controller:		'../foosball/controller',
		model:			'../foosball/model',
		view:			'../foosball/view'
	}
});

require(['jquery', 'jqueryMobile', 'common/Utils'], function($, jqueryMobile, Utils) {
	
	$(document).ajaxStart(function() {
		Utils.showLoadingWidget();
	});

	$(document).ajaxStop(function() {
		Utils.hideLoadingWidget();
	});
});