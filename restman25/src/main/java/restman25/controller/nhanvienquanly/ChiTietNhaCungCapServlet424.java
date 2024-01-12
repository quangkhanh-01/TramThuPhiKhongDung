package restman25.controller.nhanvienquanly;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import restman25.dao.HoaDonNhapDAO424;
import restman25.model.HoaDonNhap424;
import restman25.model.TKNhaCungCap424;

@WebServlet("/quanly/chitietnhacungcap")
public class ChiTietNhaCungCapServlet424 extends HttpServlet{	
	private static final long serialVersionUID = 1L;
	
	private HoaDonNhapDAO424 hoaDonNhapDAO424;
	public void init() {
		hoaDonNhapDAO424 = new HoaDonNhapDAO424();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idNCC = Integer.parseInt(request.getParameter("idNCC"));
		HttpSession session = request.getSession();
		List<TKNhaCungCap424> listTkNhaCungCap424 = (List<TKNhaCungCap424>) session.getAttribute("listTKNCC");
		for(TKNhaCungCap424 ncc: listTkNhaCungCap424) {
			if(idNCC == ncc.getId()) {
				session.setAttribute("nhaCungCap", ncc);
				List<HoaDonNhap424> listHoaDon = hoaDonNhapDAO424.getHoaDonNhap(idNCC, ncc.getNgaybatdau(), ncc.getNgayketthuc());
				request.setAttribute("listHoaDon", listHoaDon);
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/nhanvienquanly/gdChiTietNhaCungCap424.jsp");
		rd.forward(request, response);
	}
	
	
}
