<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
	    <title>Narew</title>
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/main.css" >
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/font.css" >
	    <meta charset="UTF-8">
	<meta name="description"
	content="Całoroczny domek do wynajęcia Nad Narwią w Dobrołęce">
		
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
	</head> 
	<body>
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
		<tiles:insertAttribute name="content"></tiles:insertAttribute>
		<hr />
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</body>
</html>