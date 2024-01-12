package restman25.controller.nguoidung;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import restman25.dao.NguoiDungDAO424;
import restman25.model.NguoiDung424;

@WebServlet(urlPatterns = {"/dangnhap","/xulydangnhap"})
public class NguoiDungServlet424 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private NguoiDungDAO424 nguoiDungDAO424;
	
	public void init() {
		nguoiDungDAO424 = new NguoiDungDAO424();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		if(action.equals("/dangnhap")) {
			RequestDispatcher rq = request.getRequestDispatcher("/views/nguoidung/gddangnhap424.jsp");
			rq.forward(request, response);
		}else if(action.equals("/xulydangnhap")){
			HttpSession session = request.getSession();
			String taiKhoan = request.getParameter("taiKhoan");
			String matKhau = request.getParameter("matKhau");
			NguoiDung424 nguoiDung1 = new NguoiDung424();
			nguoiDung1.setTaiKhoan(taiKhoan);
			nguoiDung1.setMatKhau(matKhau);
			NguoiDung424 nguoiDung = nguoiDungDAO424.kiemTraDangNhap(nguoiDung1);
			if(nguoiDung!=null) {
				if(nguoiDung.getVaitro().equals("khachhang")) {				
					session.setAttribute("khachhang", nguoiDung);
					response.sendRedirect(request.getContextPath()+"/khachhang/trangchu");
				}else if(nguoiDung.getVaitro().equals("quanly")){
					session.setAttribute("quanly", nguoiDung);
					response.sendRedirect(request.getContextPath()+"/quanly/trangchu");
				}
			}
		}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
