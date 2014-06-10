<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html> 
<html> 
<head> 
	<title>Player Rankings</title> 
	<meta name="viewport" content="width=device-width, initial-scale=1"> 
	<%@include file="/resources/include/common.html"%>
	<script data-main="<spring:url value='/resources/js/players'/>" src="<spring:url value='/resources/js/lib/require.js'/>"></script>
</head> 
<body> 

	<div id="playersView" data-role="page">
	
		<div data-role="header">
			<h1 id="header">Player Rankings</h1>
		</div>
	
		<div data-role="content">	
			<div class="content-primary">
				<ul id="playersList" data-role="listview"
					data-filter="true" data-filter-placeholder="Search..."></ul>
			</div>		
		</div>
	
	</div>

</body>
</html>