<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="students" class="pacote.StudentsBean">
		<jsp:setProperty name="students" property="firstName" value="Jack" />
		<jsp:setProperty name="students" property="lastName" value="Smith" />
	    <jsp:setProperty name="students" property="age" value="24" />
	</jsp:useBean>

	<p>
		Student First Name:
		<jsp:getProperty name="students" property="firstName" />
	</p>
	<p>
		Student Last Name:
		<jsp:getProperty name="students" property="lastName" />
	</p>
	
	Student Age:
		<jsp:getProperty name="students" property="age" />
	</p>
	
</body>
</html>