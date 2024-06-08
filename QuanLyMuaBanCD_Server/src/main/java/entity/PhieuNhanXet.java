package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name = "dsPhieuNhanXet")
@NamedNativeQueries({
	@NamedNativeQuery(name = "getDSPhieuNhanXetNative", query = "{}", resultClass = PhieuNhanXet.class),
})
public class PhieuNhanXet implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1546351173513844325L;
	@Id
	private String maPhieu;
	private String tenLinhKien;
	private String liDoBaoHanh;
	private boolean loiThuoc;
	private double giaTien;
	
	@ManyToOne
	@JoinColumn(name = "soHopDong")
	private HopDong hopDong;
	
	@ManyToOne
	@JoinColumn(name = "maNV")
	private NhanVienKyThuat nhanVienKT;

	public PhieuNhanXet(String maPhieu, String tenLinhKien, String liDoBaoHanh, boolean loiThuoc, double giaTien) {
		super();
		this.maPhieu = maPhieu;
		this.tenLinhKien = tenLinhKien;
		this.liDoBaoHanh = liDoBaoHanh;
		this.loiThuoc = loiThuoc;
		this.giaTien = giaTien;
	}

	public PhieuNhanXet(String maPhieu) {
		this(maPhieu, "", "", true, 0);
	}

	public PhieuNhanXet() {
		this("", "", "", true, 0);
	}

	public String getMaPhieu() {
		return maPhieu;
	}

	public void setMaPhieu(String maPhieu) {
		this.maPhieu = maPhieu;
	}

	public String getTenLinhKien() {
		return tenLinhKien;
	}

	public void setTenLinhKien(String tenLinhKien) {
		this.tenLinhKien = tenLinhKien;
	}

	public String getLiDoBaoHanh() {
		return liDoBaoHanh;
	}

	public void setLiDoBaoHanh(String liDoBaoHanh) {
		this.liDoBaoHanh = liDoBaoHanh;
	}

	public boolean isLoiThuoc() {
		return loiThuoc;
	}

	public void setLoiThuoc(boolean loiThuoc) {
		this.loiThuoc = loiThuoc;
	}

	public double getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(double giaTien) {
		this.giaTien = giaTien;
	}

	public HopDong getHopDong() {
		return hopDong;
	}

	public void setHopDong(HopDong hopDong) {
		this.hopDong = hopDong;
	}

	public NhanVienKyThuat getNhanVienKT() {
		return nhanVienKT;
	}

	public void setNhanVienKT(NhanVienKyThuat nhanVienKT) {
		this.nhanVienKT = nhanVienKT;
	}

	@Override
	public String toString() {
		return "PhieuNhanXet [maPhieu=" + maPhieu + ", tenLinhKien=" + tenLinhKien + ", liDoBaoHanh=" + liDoBaoHanh
				+ ", loiThuoc=" + loiThuoc + ", giaTien=" + giaTien + "]";
	}
	
}