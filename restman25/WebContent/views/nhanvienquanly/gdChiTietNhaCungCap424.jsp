<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>gdChiTietNhaCungCap424</title>
	 <link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet"> 
</head>
<body>
    <div class="container text-center mt-5">
        <h1>Chi tiết nhà cung cấp</h1>
        <p class="fs-5">Xin chào, ${quanly.hoTen}</p>
    </div>
    <div class="container">
        <form action="<c:url value='/quanly/tknhacungcap'/>" method="get">
            <input type="hidden" name="ngaybatdau" value="${nhaCungCap.ngaybatdau}">
            <input type="hidden" value="${nhaCungCap.ngayketthuc}" name="ngayketthuc">
            <button type="submit" class="btn btn-primary">Quay lại</button>
        </form>
        <div class="mt-3 fs-5">
            <div class="mb-1">
                <span class="fw-bold">Mã nhà cung cấp:</span>
                <span>${nhaCungCap.id}</span>
            </div>
            <div class="mb-1">
                <span class="fw-bold">Tên nhà cung cấp:</span>
                <span>${nhaCungCap.ten}</span>
            </div>
            <div class="mb-1">
                <span class="fw-bold">Số điện thoại:</span>
                <span>${nhaCungCap.soDienThoai}</span>
            </div>
            <div class="mb-1">
                <span class="fw-bold">Địa chỉ:</span>
                <span>${nhaCungCap.diaChi}</span>
            </div>
            <div class="mb-1">
                <span class="fw-bold">Ngày bắt đầu:</span>
                <span><fmt:formatDate value="${nhaCungCap.ngaybatdau}" pattern="dd-MM-yyyy" /></span>
            </div>
           <div class="mb-1">
                <span class="fw-bold">Ngày kết thúc:</span>
                <span><fmt:formatDate value="${nhaCungCap.ngayketthuc}" pattern="dd-MM-yyyy" /></span>
            </div>
        </div>
        <c:if test="${listHoaDon != null}">
            <div class="table-container mt-3">
                <table class="table table-bordered text-center fs-5">
                    <thead class="table-dark">
                        <tr>
                            <th>ID</th>
                            <th>Ngày tạo</th>
                            <th>Tổng tiền</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="hoadon" items="${listHoaDon}">
                            <tr>
                                <td>
                                    <a href="<c:url value='/quanly/chitiethoadonnhap?id=${hoadon.id}'/>">${hoadon.id}</a>
                                </td>
                                <td><fmt:formatDate value="${hoadon.ngayTao}" pattern="dd-MM-yyyy HH:mm:ss" /></td>
                                <td><fmt:formatNumber type="number" value="${hoadon.tongTien}" pattern="#,###.##" /></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>
    </div>
</body>
</html>