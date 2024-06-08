package entity;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class NhanVien implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7612177231118089287L;
	@Id
	private String maNV;
	private String tenNV;
	private String diaChiNV;
	private String soDienThoaiNV;
	
	@Embedded
	private TaiKhoan taiKhoan;
	
	public NhanVien(String maNV, String tenNV, String diaChiNV, String soDienThoaiNV) {
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.diaChiNV = diaChiNV;
		this.soDienThoaiNV = soDienThoaiNV;
	}
	public NhanVien() {
		this("", "", "", "");
	}
	public NhanVien(String maNV) {
		this(maNV, "", "", "");
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public String getDiaChiNV() {
		return diaChiNV;
	}
	public void setDiaChiNV(String diaChiNV) {
		this.diaChiNV = diaChiNV;
	}
	public String getSoDienThoaiNV() {
		return soDienThoaiNV;
	}
	public void setSoDienThoaiNV(String soDienThoaiNV) {
		this.soDienThoaiNV = soDienThoaiNV;
	}
	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", diaChiNV=" + diaChiNV + ", soDienThoaiNV="
				+ soDienThoaiNV + "]";
	}
	
}