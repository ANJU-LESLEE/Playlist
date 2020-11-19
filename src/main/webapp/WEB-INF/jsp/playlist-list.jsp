<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<script src="/js/playlist-list.js" defer="defer"></script>
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
							<div id="song-div_${songItem.songId}">
								<c:out value="${songItem.songName}" />
								:
								<c:out value="${songItem.singerName}" />
								<a href="deleteSong/${playlistNameItem.playlistId}/"><span
									id="del-song-span_${playlistNameItem.playlistId}" class="close">&times;</span>
								</a>
							</div>
							<br>
						</c:forEach>
					</c:if></td>
				<td>
					<button id="del-btn_${playlistNameItem.playlistId}">Delete
						playlist</button>
					<div id="playlist-del-model_${playlistNameItem.playlistId}"
						class="modal">
						<div class="modal-content">
							<span id="del-playlist-span_${playlistNameItem.playlistId}"
								class="close">&times;</span> Are you sure to delete
							<c:out value="${playlistNameItem.playlistName}" />
							? <a href="deletePlaylist/${playlistNameItem.playlistId}">
								<button id="submit-del-btn_${playlistNameItem.playlistId}">Delete</button>
							</a>
							<button id="cancel-del-btn_${playlistNameItem.playlistId}">Cancel</button>
						</div>
					</div>
				</td>
			</tr>
		</c:forEach>

		<tr>
			<td colspan="2">
				<button id="add-playlist-btn">Add Playlist</button>
				<div id="playlist-add-model" class="modal">
					<div class="modal-content">
						<span id="add-playlist-span" class="close">&times;</span>
						<form:form id="playlist-add-form" action="addplaylist"
							method="post" modelAttribute="playlistItem">
							Playlist Name:
							<form:input path="playlistName" />
							<form:button>Create playlist</form:button>
						</form:form>
					</div>

				</div>
			</td>
		</tr>
	</table>
	<!-- 	<div id=msg-div> -->
	<%-- 		<c:if test="${not empty insertMsg}"> --%>
	<%-- 			<c:out value="${insertMsg}" /> --%>
	<%-- 		</c:if> --%>
	<!-- 	</div> -->
</body>
</html>