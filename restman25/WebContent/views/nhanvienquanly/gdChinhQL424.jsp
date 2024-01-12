<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>gdChinhQuanLy424</title>
 <link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet"> 
</head>
<body>
	<div class="container text-center mt-5">
		<h1>Trang chủ quản lý</h1>
		<p class="fs-5">Xin chào, ${quanly.hoTen}</p>
		<a class="fs-5" href="<c:url value='/quanly/chonthongke'/>">Xem báo cáo</a>
	</div>
</body>
</html>