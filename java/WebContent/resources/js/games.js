require(['./mainConfig'], function() {
	require(['jquery', 'domReady!', 'view/GamesView'], function($, domReady, GamesView) {
		GamesView.onPageInitCallback();	
	});
});