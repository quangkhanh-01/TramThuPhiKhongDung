package restman25.model;

import java.sql.Timestamp;
import java.util.List;

public class DonDat424 {
	private Integer id;
	private Timestamp thoiGianToi;
	private Float tongTien;
	private Timestamp ngayDat;
	private String kieuDat;
	private List<ComBoDat424> comboDat;
	private List<MonAnDat424> monAnDat;
	private List<BanDat424> banDat;
	private KhachHang424 khachHang;
	public KhachHang424 getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang424 khachHang) {
		this.khachHang = khachHang;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Timestamp getThoiGianToi() {
		return thoiGianToi;
	}
	public void setThoiGianToi(Timestamp thoiGianToi) {
		this.thoiGianToi = thoiGianToi;
	}
	public Float getTongTien() {
		return tongTien;
	}
	public void setTongTien(Float tongTien) {
		this.tongTien = tongTien;
	}
	public Timestamp getNgayDat() {
		return ngayDat;
	}
	public void setNgayDat(Timestamp ngayDat) {
		this.ngayDat = ngayDat;
	}
	public String getKieuDat() {
		return kieuDat;
	}
	public void setKieuDat(String kieuDat) {
		this.kieuDat = kieuDat;
	}
	public List<ComBoDat424> getComboDat() {
		return comboDat;
	}
	public void setComboDat(List<ComBoDat424> comboDat) {
		this.comboDat = comboDat;
	}
	public List<MonAnDat424> getMonAnDat() {
		return monAnDat;
	}
	public void setMonAnDat(List<MonAnDat424> monAnDat) {
		this.monAnDat = monAnDat;
	}
	public List<BanDat424> getBanDat() {
		return banDat;
	}
	public void setBanDat(List<BanDat424> banDat) {
		this.banDat = banDat;
	}
}
