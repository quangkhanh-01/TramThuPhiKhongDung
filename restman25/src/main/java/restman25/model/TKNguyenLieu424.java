package restman25.model;

import java.sql.Date;

public class TKNguyenLieu424 extends NguyenLieu424 {
	private Integer soluongnhap;
	private Float tongTien;
	private Date ngaybatdau;
	private Date ngayketthuc;
	public Integer getSoluongnhap() {
		return soluongnhap;
	}
	public void setSoluongnhap(Integer soluongnhap) {
		this.soluongnhap = soluongnhap;
	}
	public Float gettongTien() {
		return tongTien;
	}
	public void settongTien(Float tongTien) {
		this.tongTien = tongTien;
	}
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
	
}
