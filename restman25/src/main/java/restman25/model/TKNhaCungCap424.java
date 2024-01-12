package restman25.model;

import java.sql.Date;

public class TKNhaCungCap424 extends NhaCungCap424 {
	private Integer soLuongHangNhap;
	private Float tongTien;
	private Date ngaybatdau;
	private Date ngayketthuc;
	
	public Date getNgaybatdau() {
		return ngaybatdau;
	}

	public void setNgaybatdau(Date ngaybatdau) {
		this.ngaybatdau = ngaybatdau;
	}

	public Date getNgayketthuc() {
		return ngayketthuc;
	}

	public void setNgayketthuc(Date ngayketthuc) {
		this.ngayketthuc = ngayketthuc;
	}


	public Float getTongTien() {
		return tongTien;
	}

	public void setTongTien(Float tongTien) {
		this.tongTien = tongTien;
	}

	public Integer getSoLuongHangNhap() {
		return soLuongHangNhap;
	}

	public void setSoLuongHangNhap(Integer soLuongHangNhap) {
		this.soLuongHangNhap = soLuongHangNhap;
	}
	
}
