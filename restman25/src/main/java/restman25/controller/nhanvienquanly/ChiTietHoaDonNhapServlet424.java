package restman25.controller.nhanvienquanly;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import restman25.dao.HoaDonNhapDAO424;
import restman25.model.HoaDonNhap424;

@WebServlet("/quanly/chitiethoadonnhap")
public class ChiTietHoaDonNhapServlet424 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private HoaDonNhapDAO424 hoaDonNhapDAO424;
	public void init() {
		hoaDonNhapDAO424 = new HoaDonNhapDAO424();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idHoaDonNhap = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		Date ngaybatdau = Date.valueOf((String) session.getAttribute("ngaybatdau"));
		Date ngayketthuc = Date.valueOf((String) session.getAttribute("ngayketthuc"));
		request.setAttribute("ngaybatdau1", ngaybatdau);
		request.setAttribute("ngayketthuc1", ngayketthuc);
		HoaDonNhap424 hoaDonNhap424 = hoaDonNhapDAO424.getThongTinHoaDonNhap(idHoaDonNhap);
		request.setAttribute("hoaDonNhap", hoaDonNhap424);
		RequestDispatcher rd= request.getRequestDispatcher("/views/nhanvienquanly/gdChiTietHoaDonNhap424.jsp");
		rd.forward(request, response);
	}
}
