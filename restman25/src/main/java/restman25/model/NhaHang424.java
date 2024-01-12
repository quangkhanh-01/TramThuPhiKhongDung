package restman25.model;

import java.util.List;

public class NhaHang424 {
	private Integer id;
	private String ten;
	private String diaChi;
	private String soDienThoai;
	private String moTa;
	private List<Ban424> ban;
	private List<MonAn424> monAn;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public List<Ban424> getBan() {
		return ban;
	}
	public void setBan(List<Ban424> ban) {
		this.ban = ban;
	}
	public List<MonAn424> getMonAn() {
		return monAn;
	}
	public void setMonAn(List<MonAn424> monAn) {
		this.monAn = monAn;
	}
}
