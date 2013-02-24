<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html> 
<html> 
<head> 
	<title>Player Rankings</title> 
	<meta name="viewport" content="width=device-width, initial-scale=1"> 
	
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.2.0/jquery.mobile-1.2.0.min.css" />
	
	<script src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.2.0/jquery.mobile-1.2.0.min.js"></script>
	<script src="<spring:url value='/resources/js/PlayersController.js'/>"></script>
	<script src="<spring:url value='/resources/js/PlayersView.js'/>"></script>
</head> 
<body> 

	<div id="playersView" data-role="page">
	
		<div data-role="header">
			<h1 id="pageHeader">Player Rankings</h1>
		</div>
	
		<div data-role="content">	
			<div class="content-primary">
				<ol id="playersList" data-role="listview"></ol>
			</div>		
		</div>
	
	</div>

</body>
</html>