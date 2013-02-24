function PlayersView() {
	
	this.populatePlayersList = function(data) {
		var playersList = "";
		$.each(data, function(index, player) {
			playersList += "<li>" + player.lastName + "</li>";
		});
		
		$("#playersList").html(playersList).listview("refresh");
	};
};

var playersView = new PlayersView();

$(document).ready(function() {
	playersController.getPlayers(playersView.populatePlayersList);
});