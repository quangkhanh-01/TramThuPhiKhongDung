<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
 <link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet"> 
</head>

<body>
	<div class="container mt-5">
	    <div class="row justify-content-center">
	        <div class="col-md-6">
	            <h2 class="text-center mb-4">Đăng nhập:</h2>
	            <form method="post" action="xulydangnhap">
	                <div class="mb-3">
	                    <label for="username" class="form-label">Tên đăng nhập:</label>
	                    <input type="text" class="form-control" name="taiKhoan"  placeholder="Nhập tên đăng nhập">
	                </div>
	                <div class="mb-3">
	                    <label for="password" class="form-label">Mật khẩu</label>
	                    <input type="password" class="form-control" name="matKhau" placeholder="Nhập mật khẩu">
	                </div>
	                <button type="submit" class="btn btn-primary">Đăng nhập</button>
	            </form>
	        </div>
	    </div>
	</div>
</body>
</html>