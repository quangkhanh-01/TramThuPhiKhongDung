<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>gdChiTietMonAn424</title>
 	 <link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet"> 
</head>
<body>
    <div class="container mt-5 text-center fs-5">     
        <h1>Chi tiết món ăn</h1>
        <p>Xin chào, ${khachhang.hoTen}</p>
    </div>
    <div class="container mt-3">
        <form action="<c:url value='/khachhang/timkiemmonan'/>" method="get">
            <input type="hidden" value="${tukhoa1}" name="tukhoa">
            <button type="submit" class="btn btn-primary">Quay lại</button>
        </form>
    </div>
    
    <div class="container mt-3  fs-5">
        <div class="card">
            <div class="card-body">
                <h3 class="card-title">Tên món ăn:</h3>
                <p class="card-text">${monan.ten}</p>
                
                <h3 class="card-title">Giá tiền:</h3>
                <p class="card-text"><fmt:formatNumber type="number" value="${monan.giaTien}" pattern="#,###.##" /></p>
                
                <h3 class="card-title">Mô tả:</h3>
                <p class="card-text">${monan.moTa}</p>
            </div>
        </div>
    </div>
</body>
</html>