package restman25.controller.nhanvienquanly;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import restman25.dao.TKNhaCungCapDAO424;
import restman25.model.TKNhaCungCap424;


@WebServlet("/quanly/tknhacungcap")
public class TKNhaCungCapServlet424 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TKNhaCungCapDAO424 tkNhaCungCapDAO424; 
    
	public void init() {
		tkNhaCungCapDAO424 = new TKNhaCungCapDAO424();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); 
		String batdau = request.getParameter("ngaybatdau");
		String ketthuc = request.getParameter("ngayketthuc");
		if(batdau!=null && ketthuc!=null) {
			session.setAttribute("ngaybatdau", batdau);
			session.setAttribute("ngayketthuc", ketthuc);
			Date ngaybatdau = Date.valueOf(batdau);
			Date ngayketthuc = Date.valueOf(ketthuc);			
			List<TKNhaCungCap424> listTKNhaCungCap = tkNhaCungCapDAO424.getTKNhaCungCap(ngaybatdau, ngayketthuc);
			session.setAttribute("listTKNCC", listTKNhaCungCap);
		}else {
			String bd = (String) session.getAttribute("ngaybatdau");
			String kt = (String) session.getAttribute("ngayketthuc");
			if(bd!=null && kt!=null) {
				session.removeAttribute("ngaybatdau");
				session.removeAttribute("ngayketthuc");
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/nhanvienquanly/gdTKNhaCungCap424.jsp");
		rd.forward(request, response);
		
	}

}
