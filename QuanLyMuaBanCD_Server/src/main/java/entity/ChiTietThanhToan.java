package entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "dsChiTietThanhToan")
public class ChiTietThanhToan implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4077806758599515423L;
	private int lanTra;
	private double tienTra;
	private String tenNguoiTra;
	
	
	
	public ChiTietThanhToan(int lanTra, double tienTra, String tenNguoiTra) {
		this.lanTra = lanTra;
		this.tienTra = tienTra;
		this.tenNguoiTra = tenNguoiTra;
	}
	public ChiTietThanhToan() {
		this( 0, 0, "");
	}
	public int getLanTra() {
		return lanTra;
	}
	public void setLanTra(int lanTra) {
		this.lanTra = lanTra;
	}
	public double getTienTra() {
		return tienTra;
	}
	public void setTienTra(double tienTra) {
		this.tienTra = tienTra;
	}
	public String getTenNguoiTra() {
		return tenNguoiTra;
	}
	public void setTenNguoiTra(String tenNguoiTra) {
		this.tenNguoiTra = tenNguoiTra;
	}
	@Override
	public String toString() {
		return "ChiTietThanhToan [lanTra=" + lanTra + ", tienTra=" + tienTra + ", tenNguoiTra=" + tenNguoiTra + "]";
	}
	
}