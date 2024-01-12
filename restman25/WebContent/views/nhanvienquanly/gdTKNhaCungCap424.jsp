<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>gdTKNhaCungCap424</title>
	 <link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet"> 
</head>
<body>
    <div class="container text-center mt-5">
        <h1>Thống kê nhà cung cấp theo số lượng hàng nhập</h1>
        <p class="fs-5">Xin chào, ${quanly.hoTen}</p>
    </div>
    <div class="container fs-5">
        <form action="<c:url value='/quanly/tknhacungcap'/>" method="get">
            <div class="row mb-3">
                <label class="col-sm-2 col-form-label">Ngày bắt đầu:</label>
                <div class="col-sm-4">
                    <input type="date" name="ngaybatdau" value="${ngaybatdau}" class="form-control fs-5">
                </div>
                <label class="col-sm-2 col-form-label">Ngày kết thúc:</label>
                <div class="col-sm-4">
                    <input type="date" name="ngayketthuc" value="${ngayketthuc}" class="form-control fs-5">
                </div>
            </div>
            <div class="text-center">
                <button type="submit" class="btn btn-primary">Thống kê</button>
            </div>
        </form>
    </div>
    <c:if test="${listTKNCC != null }">
        <div class="container mt-5 fs-5">
            <table class="table table-bordered text-center">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Tên</th>
                        <th>Số lượng hàng nhập</th>
                        <th>Tổng tiền</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="ncc" items="${listTKNCC}">
                        <tr>
                            <td>${ncc.id}</td>
                            <td>
                                <a href="<c:url value='/quanly/chitietnhacungcap?idNCC=${ncc.id}'/>">${ncc.ten}</a>
                            </td>
                            <td>${ncc.soLuongHangNhap}</td>
                            <td><fmt:formatNumber type="number" value="${ncc.tongTien}" pattern="#,###.##" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </c:if>
</body>
</html>