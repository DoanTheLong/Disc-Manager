package entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Embeddable
@Table(name = "dsChiTietHopDong")
public class ChiTietHopDong implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1567527710693371632L;
	private int soLuong;
	private double donGia;
	private double thanhTien;
	
	@ManyToOne
	@JoinColumn(name = "maXe")
	private Xe xe;

	public ChiTietHopDong(int soLuong, double donGia) {
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.thanhTien = donGia * soLuong;
	}

	public ChiTietHopDong() {
		this(0, 0);
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
		this.thanhTien = soLuong * this.donGia;
	}

	public double getThanhTien() {
		return thanhTien;
	}

	public Xe getXe() {
		return xe;
	}

	public void setXe(Xe xe) {
		this.xe = xe;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
		this.thanhTien = this.soLuong * donGia;
	}

	@Override
	public String toString() {
		return "ChiTietHopDong [soLuong=" + soLuong + ", donGia=" + donGia + ", thanhTien=" + thanhTien
				+ "]";
	}
	
}