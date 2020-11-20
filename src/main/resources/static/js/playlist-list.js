	
var addmodal = document.getElementById("playlist-add-model");
var addBtn = document.getElementById("add-playlist-btn");
var spanAdd = document.getElementById("add-playlist-span");


addBtn.onclick = function() {
  addmodal.style.display = "block";
}

spanAdd.onclick = function() {
  addmodal.style.display = "none";
}
window.onclick = function(event) {
  if (event.target == addmodal) {
    addmodal.style.display = "none";
  }
}
var delButtons = document.querySelectorAll('*[id^="del-btn_"]');

for (var i=0;i<delButtons.length;i++) {
	delButtons[i].addEventListener("click", clickHandler);

}
function clickHandler(event) {
	var buttonId = event.target.id;	
	var rowId = buttonId.split("_")[1];
	var delmodal = document.getElementById('playlist-del-model_'+rowId);
	delmodal.style.display = "block";
	
}
var spanButtons = document.querySelectorAll('*[id^="del-playlist-span_"]');

for (var i=0;i<spanButtons.length;i++) {
	spanButtons[i].addEventListener("click", clickHandlerClose);

}
var cancelButtons = document.querySelectorAll('*[id^="cancel-del-btn_"]');

for (var i=0;i<cancelButtons.length;i++) {
	cancelButtons[i].addEventListener("click", clickHandlerClose);

}
function clickHandlerClose(event) {
	buttonId = event.target.id;	
	rowId = buttonId.split("_")[1];
	var delmodal = document.getElementById('playlist-del-model_'+rowId);
	delmodal.style.display = "none";
	
}
var addsongButtons = document.querySelectorAll('*[id^="add-song-btn_"]');

for (var i=0;i<addsongButtons.length;i++) {
	addsongButtons[i].addEventListener("click", clickHandlerSong);

}
function clickHandlerSong(event) {
	var buttonId = event.target.id;	
	var rowId = buttonId.split("_")[1];
	var addSongmodal = document.getElementById('song-add-model_'+rowId);
	addSongmodal.style.display = "block";
	
}
var spanSongButtons = document.querySelectorAll('*[id^="add-song-span_"]');

for (var i=0;i<spanSongButtons.length;i++) {
	spanSongButtons[i].addEventListener("click", clickHandlerSongClose);

}
function clickHandlerSongClose(event) {
	buttonId = event.target.id;	
	rowId = buttonId.split("_")[1];
	var addSongmodal = document.getElementById('song-add-model_'+rowId);
	addSongmodal.style.display = "none";
	
}
