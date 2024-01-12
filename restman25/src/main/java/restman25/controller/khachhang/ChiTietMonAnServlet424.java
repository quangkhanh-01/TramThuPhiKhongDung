package restman25.controller.khachhang;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import restman25.dao.MonAnDAO424;
import restman25.model.MonAn424;


@WebServlet("/khachhang/chitietmonan")
public class ChiTietMonAnServlet424 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MonAnDAO424 monAnDAO;
    public void init() {
    	monAnDAO = new MonAnDAO424();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idMonAn = request.getParameter("idMonAn");
		MonAn424 monAn = monAnDAO.getThongTinMonAn(Integer.parseInt(idMonAn));
		request.setAttribute("monan", monAn);
		RequestDispatcher rd = request.getRequestDispatcher("/views/khachhang/gdChiTietMonAn424.jsp");
		rd.forward(request, response);
	}
}
