<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html> 
<head> 
	<title>WesAndRachel</title> 
	<meta name="viewport" content="width=device-width, initial-scale=1"> 
	<%@include file="/resources/include/common.html"%>
	<script data-main="<spring:url value='/resources/js/home'/>" src="<spring:url value='/resources/js/lib/require.js'/>"></script>
</head> 
<body> 

	<div data-role="page">
	
		<div data-role="header">
			<h1 id="header">WesAndRachel</h1>
		</div>
	
		<div data-role="content">	
			<p>Hello world</p>		
		</div>
	
	</div>

</body>
</html>