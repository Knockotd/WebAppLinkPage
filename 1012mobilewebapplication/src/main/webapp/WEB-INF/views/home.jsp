<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 출력</title>
<!-- 모바일 웹 페이지를 만들 때 가로 방향으로 화면을 가득 채우고 핀치를 이용해서 확대나 축소를 못하도록 설정 -->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no, maximum-scale=2.0, minimum-scale=1.0"  />

<!-- jquery mobile 사용을 위한 설정 -->
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>

<!-- jstl 사용을 위한 설정 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


</head>
<body>

	<div data-role="page">
		<div data-role="header">
			<h2>과일 정보</h2>
		</div>
		<div data-role="content">
			<div data-role="collapsible-set">
				<c:forEach var="item" items="${list}">
					<div data-role="collapsible">
						<h1>${item.name}</h1>
						<p>가격:${item.price}</p>
						<p>설명:${item.description}</p>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>