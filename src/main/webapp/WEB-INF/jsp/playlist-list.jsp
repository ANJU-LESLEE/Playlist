<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<script src="/js/playlist-list.js"></script>
<link href="/css/playlist-list.css" rel="stylesheet" />
<title>Playlist</title>
</head>
<body>
	<h1>My playlist</h1>
	<table border=1>
		<tr>
			<td>playlist</td>
			<td>Songs</td>
		</tr>
		<c:forEach items="${playlistNametList}" var="playlistNameItem">
			<tr>
				<td><c:out value="${playlistNameItem.playlistName}" /></td>
				<td><c:if test="${not empty playlistNameItem.songList}">
						<c:forEach items="${playlistNameItem.songList}" var="songItem">
							<c:out value="${songItem.songName}" /> : 
							<c:out value="${songItem.singerName}" />
							<br>
						</c:forEach>
					</c:if></td>
			</tr>
		</c:forEach>

		<tr>
			<td colspan="2">
				<button id="add-playlist-btn" onclick="openDialog();">Add
					Playlist</button>
				<div id="playlist-dlg" title="Add Playlist"></div>
			</td>
		</tr>
	</table>
</body>
</html>