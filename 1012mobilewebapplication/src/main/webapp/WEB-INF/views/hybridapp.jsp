<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>하이브리드 앱을 위한 페이지</title>
</head>
<body>
	<h2>네이티브 앱에서 받은 메시지</h2>
	메시지<div id="nativemassage" style="height:200px; overflow:auto"></div>
	
	<h2>네이티브 앱의 메소드 호출</h2>
	메세지<input type="text" id="input" /><br/>
	<input type="button" id="nativecall" value="네이티브 앱 메소드 호출" /><br/><br/>
	
</body>
<script>
function showDisplayMessage(message){
	document.getElementById("nativemassage").innerHTML += message + "<br/>"
}

document.getElementById("nativecall").addEventListener("click", function(){
	var message = document.getElementById("input").value;
	//네이티브 앱의 메소드 호출
	MYAPP.showToastMessage(message);
});
</script>
</html>