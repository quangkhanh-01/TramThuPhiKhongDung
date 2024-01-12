package restman25.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import restman25.model.NguoiDung424;

public class NguoiDungDAO424 extends DAO424{
	
	public NguoiDungDAO424() {
		super();
	}
	public NguoiDung424 kiemTraDangNhap(NguoiDung424 nguoiDung424) {
		boolean ketqua = false;
		NguoiDung424 nguoiDung1 = null;
		String sql = "select * from tblnguoidung424 where taiKhoan=? and matKhau=?";
		try {
			nguoiDung1 = new NguoiDung424();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, nguoiDung424.getTaiKhoan());
			ps.setString(2, nguoiDung424.getMatKhau());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				nguoiDung1.setId(rs.getInt("id"));
				nguoiDung1.setHoTen(rs.getString("hoTen"));
				nguoiDung1.setEmail(rs.getString("email"));
				nguoiDung1.setDiaChi(rs.getString("diaChi"));
				nguoiDung1.setSoDienThoai(rs.getString("soDienThoai"));
				nguoiDung1.setNgaySinh(rs.getDate("ngaySinh"));
				nguoiDung1.setVaitro(rs.getString("vaitro"));
			}
			ketqua = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ketqua = false;
		}
		if(ketqua) {
			return nguoiDung1;
		}else {
			return null;
		}
	}
}
