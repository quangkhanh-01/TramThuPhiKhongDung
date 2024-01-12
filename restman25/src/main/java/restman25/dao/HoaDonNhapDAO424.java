package restman25.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import restman25.model.HoaDonNhap424;
import restman25.model.NguyenLieu424;
import restman25.model.NguyenLieuNhap424;
import restman25.model.NhanVienKho424;

public class HoaDonNhapDAO424 extends DAO424 {
	public HoaDonNhapDAO424() {
		super();
	}
	public List<HoaDonNhap424> getHoaDonNhap(int idNCC, Date ngaybatdau, Date ngayketthuc) {
		List<HoaDonNhap424> listHoaDonNhap = new ArrayList<>();
		String sqlHoaDon = "select * from tblhoadonnhap424 where tblNhaCungCap424id = ? and ngayTao between ? and ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sqlHoaDon);
			ps.setInt(1, idNCC);
			ps.setDate(2, ngaybatdau);
			ps.setDate(3, ngayketthuc);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				HoaDonNhap424 hoadon = new HoaDonNhap424();
				hoadon.setId(rs.getInt("id"));
				hoadon.setNgayTao(rs.getTimestamp("ngayTao"));
				hoadon.setTongTien(rs.getFloat("tongTien"));
				listHoaDonNhap.add(hoadon);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(listHoaDonNhap.size()==0) {
			return null;
		}else {
			return listHoaDonNhap;
		}
	}
	public HoaDonNhap424 getThongTinHoaDonNhap(int idHoaDonNhap) {
		HoaDonNhap424 hoaDonNhap = new HoaDonNhap424();
		String sqlHoaDon = "select * from tblhoadonnhap424 where id = ?";
		String sqlNguyenLieuNhap = "select * from tblnguyenlieunhap424 where tblHoaDonNhap424id = ?";
		String sqlNVKho = "select * from tblnguoidung424 where id = ?";
		String sqlNguyenLieu = "select * from tblnguyenlieu424 where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sqlHoaDon);
			ps.setInt(1, idHoaDonNhap);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				hoaDonNhap.setId(rs.getInt("id"));
				hoaDonNhap.setNgayTao(rs.getTimestamp("ngayTao"));
				hoaDonNhap.setTongTien(rs.getFloat("tongTien"));
				int idNVKho = rs.getInt("tblNguoiDung424id");
				PreparedStatement pskho = conn.prepareStatement(sqlNVKho);
				pskho.setInt(1, idNVKho);
				ResultSet rskho = pskho.executeQuery();
				while(rskho.next()) {
					NhanVienKho424 nvkho = new NhanVienKho424();
					nvkho.setId(rskho.getInt("id"));
					nvkho.setHoTen(rskho.getString("hoTen"));
					nvkho.setVaitro(rskho.getString("vaitro"));
					hoaDonNhap.setNhanvienkho(nvkho);
				}
				List<NguyenLieuNhap424> nguyenlieunhap = new ArrayList<>(); 
				PreparedStatement psNL = conn.prepareStatement(sqlNguyenLieuNhap);
				psNL.setInt(1, idHoaDonNhap);
				ResultSet rsNL = psNL.executeQuery();
				while(rsNL.next()) {
					NguyenLieuNhap424 nl = new NguyenLieuNhap424();
					nl.setId(rsNL.getInt("id"));
					nl.setSoluong(rsNL.getInt("soluong"));
					nl.setGiaTien(rsNL.getFloat("giaTien"));
					nl.setTongTien(nl.getGiaTien()*nl.getSoluong());
					int idNguyenLieu = rsNL.getInt("tblNguyenLieu424id");
					PreparedStatement psnl = conn.prepareStatement(sqlNguyenLieu);
					psnl.setInt(1, idNguyenLieu);
					ResultSet rsnl = psnl.executeQuery();
					while(rsnl.next()) {
						NguyenLieu424 nguyenlieu = new NguyenLieu424();
						nguyenlieu.setId(rsnl.getInt("id"));
						nguyenlieu.setTen(rsnl.getString("ten"));
						nguyenlieu.setGiaTien(rsnl.getFloat("giaTien"));
						nguyenlieu.setMoTa(rsnl.getString("moTa"));
						nl.setNguyenLieu(nguyenlieu);
					}
					nguyenlieunhap.add(nl);
				}
				hoaDonNhap.setNguyenLieuNhap(nguyenlieunhap);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(hoaDonNhap.getId()==null) {
			return null;
		}else {
			return hoaDonNhap;
		}
	}
}
