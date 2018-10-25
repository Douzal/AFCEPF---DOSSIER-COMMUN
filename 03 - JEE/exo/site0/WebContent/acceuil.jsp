<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	String nom = (String) session.getAttribute("leLogin");
	out.println("bonjour " +nom);
%>




<form action="ServTravail"  method="post">

<input type="submit" value="Travailler">
</form>

</body>
</html>