package restman25.model;

import java.sql.Timestamp;
import java.util.List;

public class HoaDonNhap424 {
	private Integer id;
	private Timestamp ngayTao;
	private Float tongTien;
	private NhaCungCap424 nhaCungCap;
	private NhanVienKho424 nhanvienkho;
	private List<NguyenLieuNhap424> nguyenLieuNhap;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Timestamp getNgayTao() {
		return ngayTao;
	}
	public void setNgayTao(Timestamp ngayTao) {
		this.ngayTao = ngayTao;
	}
	public Float getTongTien() {
		return tongTien;
	}
	public void setTongTien(Float tongTien) {
		this.tongTien = tongTien;
	}
	public NhaCungCap424 getNhaCungCap() {
		return nhaCungCap;
	}
	public void setNhaCungCap(NhaCungCap424 nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}
	public NhanVienKho424 getNhanvienkho() {
		return nhanvienkho;
	}
	public void setNhanvienkho(NhanVienKho424 nhanvienkho) {
		this.nhanvienkho = nhanvienkho;
	}
	public List<NguyenLieuNhap424> getNguyenLieuNhap() {
		return nguyenLieuNhap;
	}
	public void setNguyenLieuNhap(List<NguyenLieuNhap424> nguyenLieuNhap) {
		this.nguyenLieuNhap = nguyenLieuNhap;
	}
}
