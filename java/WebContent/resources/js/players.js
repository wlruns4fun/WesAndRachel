require(['./mainConfig'], function() {
	require(['jquery', 'domReady!', 'view/PlayersView'], function($, domReady, PlayersView) {
		PlayersView.onPageInitCallback();		
	});
});