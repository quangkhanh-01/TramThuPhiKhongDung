<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gdChinhKhachHang424</title>
 <link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet"> 
</head>
<body>
	<div class="container text-center mt-5 fs-5">
		<h1>Trang chủ khách hàng</h1>
		<p>Xin chào, ${khachhang.hoTen}<p>
		<a href="<c:url value='/khachhang/timkiemmonan'/>">Tìm kiếm món ăn</a>
	</div>
</body>
</html>