<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>gdChiTietHoaDonNhap424</title>
	<link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet">
</head>
<body>
<div class="container text-center mt-5">
    <h1 class="mt-4 fs-1">Chi tiết nhà cung cấp</h1>
    <p class="fs-5">Xin chào, ${quanly.hoTen}</p>
</div>
<div class="container">
    <div class="row">
        <div class="col-6">
            <a class="btn btn-primary" href="<c:url value='/quanly/chitietnhacungcap?idNCC=${nhaCungCap.id}'/>">Quay lại</a>
        </div>
    </div>
    <div class="mt-3">
        <div class="col">
            <div class="mb-1 fs-5">
            	<span class="fw-bold">Mã hóa đơn:</span>
            	<span>${hoaDonNhap.id}</span>
            </div>
        	<div class="mb-1 fs-5">
            	<span class="fw-bold">Mã nhân viên kho:</span>
            	<span>${hoaDonNhap.nhanvienkho.id}</span>
            </div>
            <div class="mb-1 fs-5">
            	<span class="fw-bold">Ngày tạo:</span>
            	<span><fmt:formatDate value="${hoaDonNhap.ngayTao}" pattern="dd-MM-yyyy HH:mm:ss" /></span>
            </div>

            <div class="mb-1 fs-5">
            	<span class="fw-bold">Ngày bắt đầu:</span>
            	<span><fmt:formatDate value="${ngaybatdau1}" pattern="dd-MM-yyyy" /></span>
            </div>
            <div class="mb-1 fs-5">
            	<span class="fw-bold">Ngày kết thúc:</span>
            	<span><fmt:formatDate value="${ngayketthuc1}" pattern="dd-MM-yyyy" /></span>
            </div>	
            <div class="mb-1 fs-5">
            	<span class="fw-bold">Tổng tiền:</span>
            	<span><fmt:formatNumber type="number" value="${hoaDonNhap.tongTien}" pattern="#,###.##"/></span>
            </div>
        </div>
    </div>
    <table class="table table-bordered text-center fs-5">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Tên nguyên liệu</th>
                <th>Số lượng</th>
                <th>Giá tiền</th>
                <th>Tổng tiền</th>
            </tr>
        </thead>
        <tbody>
            <c:if test="${!empty hoaDonNhap.nguyenLieuNhap}">
                <c:forEach var="nguyenlieu" items="${hoaDonNhap.nguyenLieuNhap}">
                    <tr>
                        <td>${nguyenlieu.id}</td>
                        <td>${nguyenlieu.nguyenLieu.ten}</td>
                        <td>${nguyenlieu.soluong}</td>
                        <td><fmt:formatNumber type="number" value="${nguyenlieu.giaTien}" pattern="#,###.##"/></td>
                        <td><fmt:formatNumber type="number" value="${nguyenlieu.tongTien}" pattern="#,###.##"/></td>
                    </tr>
                </c:forEach>
            </c:if>
        </tbody>
    </table>
</div>
</body>
</html>