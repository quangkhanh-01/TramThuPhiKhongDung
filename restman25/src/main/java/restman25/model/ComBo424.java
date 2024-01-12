package restman25.model;

import java.util.List;

public class ComBo424 {
	private Integer id;
	private String ten;
	private Float giaTien;
	private String moTa;
	private List<ComBoMonAn424> monan;
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
	public Float getGiaTien() {
		return giaTien;
	}
	public void setGiaTien(Float giaTien) {
		this.giaTien = giaTien;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public List<ComBoMonAn424> getMonan() {
		return monan;
	}
	public void setMonan(List<ComBoMonAn424> monan) {
		this.monan = monan;
	}
	
}
