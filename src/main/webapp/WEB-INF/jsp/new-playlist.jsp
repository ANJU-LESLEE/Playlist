<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Playlist</title>
</head>
<body>
		<form:form action="aaddplaylist" method="post" modelAttribute="playlistItem">
			<form:label >Playlist Name:</form:label>
			<form:input path="playlistItem.playlistName" />
			<form:button>Create playlist</form:button>
		</form:form>
</body>
</html>