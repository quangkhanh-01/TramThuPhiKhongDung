package restman25.controller.khachhang;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import restman25.dao.MonAnDAO424;
import restman25.model.MonAn424;

@WebServlet("/khachhang/timkiemmonan")
public class TimKiemServlet424 extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private MonAnDAO424 monAnDAO424;
	public void init() {
		monAnDAO424 = new MonAnDAO424();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tukhoa = request.getParameter("tukhoa");
		HttpSession session = request.getSession();
		if(tukhoa!=null && !tukhoa.equals("")) {			
			session.setAttribute("tukhoa1", tukhoa);
			List<MonAn424> monans = monAnDAO424.timMonAn(tukhoa);
			request.setAttribute("monans", monans);
		}else {
			String tukhoa1 = (String) session.getAttribute("tukhoa1");
			if(tukhoa1!=null) {
				session.removeAttribute("tukhoa1");
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/khachhang/gdTimKiem424.jsp");
		rd.forward(request, response);
	}
}
