package restman25.model;

import java.sql.Timestamp;

public class HoaDon424 {
	private Integer id;
	private Float tongTien;
	private Timestamp ngayTao;
	private NhanVienBanHang424 nvbanhang;
	private DonDat424 donDat;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Float getTongTien() {
		return tongTien;
	}
	public void setTongTien(Float tongTien) {
		this.tongTien = tongTien;
	}
	public Timestamp getNgayTao() {
		return ngayTao;
	}
	public void setNgayTao(Timestamp ngayTao) {
		this.ngayTao = ngayTao;
	}
	public NhanVienBanHang424 getNvbanhang() {
		return nvbanhang;
	}
	public void setNvbanhang(NhanVienBanHang424 nvbanhang) {
		this.nvbanhang = nvbanhang;
	}
	public DonDat424 getDonDat() {
		return donDat;
	}
	public void setDonDat(DonDat424 donDat) {
		this.donDat = donDat;
	}
}
