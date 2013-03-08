<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html> 
<html> 
<head> 
	<title>Game History</title> 
	<meta name="viewport" content="width=device-width, initial-scale=1"> 
	
	<%@include file="/resources/include/jqueryMobile.html"%>
	<%@include file="/resources/include/common.html"%>
	
	<script src="<spring:url value='/resources/js/PlayersModel.js'/>"></script>
	<script src="<spring:url value='/resources/js/GamesController.js'/>"></script>
	<script src="<spring:url value='/resources/js/GamesView.js'/>"></script>
</head> 
<body> 

	<div id="gamesView" data-role="page">
	
		<div data-role="header">
			<h1 id="header">Game History</h1>
		</div>
	
		<div data-role="content">	
			<div class="content-primary">
				<ul id="gamesList" data-role="listview"
					data-filter="true" data-filter-placeholder="Search..."></ul>
			</div>		
		</div>
	
	</div>

</body>
</html>