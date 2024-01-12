<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gdTimKiem424</title>
 <link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet"> 
</head>
<body>
    <div class="container text-center mt-5 fs-5">
        <h1>Tìm kiếm món ăn</h1>
        <p>Xin chào, ${khachhang.hoTen}</p>
        <form action="<c:url value='/khachhang/timkiemmonan'/>" method="get">
	        <div class="d-flex justify-content-center">
	            <div class="input-group w-50">
	                <input type="text" name="tukhoa" value="${tukhoa1}" class="form-control fs-5" placeholder="Nhập từ khóa">
	                <button type="submit" class="btn btn-primary">Tìm Kiếm</button>
	            </div>
	        </div>

        </form>
    </div>

    <c:if test="${monans != null}">
        <div class="container mt-5 fs-5">
            <table class="table table-bordered text-center">
                <thead class="table-dark bg-primary	">
                    <tr>
                        <th>ID</th>
                        <th>Tên</th>
                        <th>Giá tiền</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="monan" items="${monans}">
                        <tr>
                            <td>${monan.id}</td>
                            <td>
                                <a href="<c:url value='/khachhang/chitietmonan?idMonAn=${monan.id}'/>">${monan.ten}</a>
                            </td>
                            <td>
                                <fmt:formatNumber type="number" value="${monan.giaTien}" pattern="#,###.##" />
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </c:if>

</body>
</html>