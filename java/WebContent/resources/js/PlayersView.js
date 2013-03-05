function PlayersView() {
	
	this.populatePlayersList = function(data) {
		var playersList = "";
		$.each(data, function(index, player) {
			playersList += "<li>" + player.lastName + "</li>";
		});
		
		$("#playersList").html(playersList);
		utils.refreshListview($("#playersList"));
	};
};

var playersView = new PlayersView();

$(document).live("pageinit", function(event) {
	playersController.getPlayers(playersView.populatePlayersList);
});