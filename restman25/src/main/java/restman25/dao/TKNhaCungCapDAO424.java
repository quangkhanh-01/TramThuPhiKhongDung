package restman25.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import restman25.model.TKNhaCungCap424;

public class TKNhaCungCapDAO424 extends DAO424{
	
	public TKNhaCungCapDAO424() {
		super();
	}
	public List<TKNhaCungCap424> getTKNhaCungCap(Date ngaybatdau, Date ngayketthuc) {
		List<TKNhaCungCap424> listTkNhaCungCap = new ArrayList<>();
		String sql = "SELECT tblnhacungcap424.id, tblnhacungcap424.ten, tblnhacungcap424.soDienThoai, tblnhacungcap424.diaChi, "
				+ "SUM(tblnguyenlieunhap424.soluong) as sohangnhap,"
				+ "SUM(DISTINCT tblhoadonnhap424.tongTien) as tongtien "
				+ "FROM tblnhacungcap424 "
				+ "LEFT JOIN tblhoadonnhap424 ON tblnhacungcap424.id = tblhoadonnhap424.tblNhaCungCap424id "
				+ "LEFT JOIN tblnguyenlieunhap424 ON tblhoadonnhap424.id = tblnguyenlieunhap424.tblHoaDonNhap424id "
				+ "WHERE tblhoadonnhap424.ngayTao BETWEEN ? AND ? "
				+ "GROUP BY tblnhacungcap424.id "
				+ "UNION "
				+ "SELECT tblnhacungcap424.id, tblnhacungcap424.ten, tblnhacungcap424.soDienThoai, tblnhacungcap424.diaChi, 0 as sohangnhap, 0 as tongtien "
				+ "FROM tblnhacungcap424 "
				+ "WHERE tblnhacungcap424.id NOT IN "
				+ "(SELECT DISTINCT tblhoadonnhap424.tblNhaCungCap424id "
				+ "FROM tblhoadonnhap424 "
				+ "WHERE tblhoadonnhap424.ngayTao BETWEEN ? AND ?) ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDate(1, ngaybatdau);
			ps.setDate(2, ngayketthuc);
			ps.setDate(3, ngaybatdau);
			ps.setDate(4, ngayketthuc);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				TKNhaCungCap424 tkNhaCungCap424 = new TKNhaCungCap424();
				tkNhaCungCap424.setId(rs.getInt("id"));
				tkNhaCungCap424.setTen(rs.getString("ten"));
				tkNhaCungCap424.setSoDienThoai(rs.getString("soDienThoai"));
				tkNhaCungCap424.setSoLuongHangNhap(rs.getInt("sohangnhap"));
				tkNhaCungCap424.setTongTien(rs.getFloat("tongtien"));
				tkNhaCungCap424.setDiaChi(rs.getString("diaChi"));
				tkNhaCungCap424.setNgaybatdau(ngaybatdau);
				tkNhaCungCap424.setNgayketthuc(ngayketthuc);
				listTkNhaCungCap.add(tkNhaCungCap424);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(listTkNhaCungCap.size()==0) {
			return null;
		}else {
			return listTkNhaCungCap;
		}
	}

}
