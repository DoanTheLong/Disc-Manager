package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.ogm.options.shared.IndexOption;
import org.hibernate.ogm.options.shared.IndexOptions;

@Entity
@Table(name = "dsHopDong", indexes = {
		@Index(columnList = "soHopDong, maNV, maKH", name = "soHopDong_maNV_maKH_idx")
})
@IndexOptions(@IndexOption(forIndex = "soHopDong_maNV_maKH_idx", options = "{text:true}"))
public class HopDong implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9043459689839057355L;
	@Id
	private String soHopDong;
	private Date ngayHopDong;
	private int thoiGianBH;
	private double tienDaThanhToan;
	private boolean tinhTrangThanhToan;
	private double tongThanhTien;
	private double tienThua;
	private double tienPhaiTra;
	
	@Embedded
	@ElementCollection(fetch = FetchType.EAGER)
	private List<ChiTietHopDong> dsCTHD;
	
	@Embedded
	@ElementCollection(fetch = FetchType.EAGER)
	private List<ChiTietThanhToan> dsCTTT;
	
	@ManyToOne
	@JoinColumn(name = "maNV")
	private NhanVienHanhChanh nhanVienLapHD;
	@ManyToOne
	@JoinColumn(name = "maKH")
	private KhachHang khDaiDien;

	public HopDong(String soHopDong, Date ngayHopDong, int thoiGianBH) {
		this.soHopDong = soHopDong;
		this.ngayHopDong = ngayHopDong;
		this.thoiGianBH = thoiGianBH;
		this.tinhTrangThanhToan = false;
		this.tienDaThanhToan = 0;
		this.tongThanhTien = 0;
		this.tienPhaiTra = 0;
		this.tienThua = 0;
		this.dsCTTT = new ArrayList<ChiTietThanhToan>();
		this.dsCTHD = new ArrayList<ChiTietHopDong>();
	}

	public HopDong() {
		this("", new Date(), 0);
	}
	
	public HopDong(String soHopDong) {
		this(soHopDong, new Date(), 0);
	}
	
	public String getSoHopDong() {
		return soHopDong;
	}

	public void setSoHopDong(String soHopDong) {
		this.soHopDong = soHopDong;
	}

	public Date getNgayHopDong() {
		return ngayHopDong;
	}

	public void setNgayHopDong(Date ngayHopDong) {
		this.ngayHopDong = ngayHopDong;
	}

	public int getThoiGianBH() {
		return thoiGianBH;
	}

	public void setThoiGianBH(int thoiGianBH) {
		this.thoiGianBH = thoiGianBH;
	}

	public boolean isTinhTrangThanhToan() {
		return tinhTrangThanhToan;
	}

	public List<ChiTietHopDong> getDsCTHD() {
		return dsCTHD;
	}

	public void setDsCTHD(List<ChiTietHopDong> dsCTHD) {
		this.dsCTHD = dsCTHD;
	}

	public List<ChiTietThanhToan> getDsCTTT() {
		return dsCTTT;
	}

	public void setDsCTTT(List<ChiTietThanhToan> dsCTTT) {
		this.dsCTTT = dsCTTT;
	}

	public NhanVienHanhChanh getNhanVienLapHD() {
		return nhanVienLapHD;
	}

	public void setNhanVienLapHD(NhanVienHanhChanh nhanVienLapHD) {
		this.nhanVienLapHD = nhanVienLapHD;
	}

	public KhachHang getKhDaiDien() {
		return khDaiDien;
	}

	public void setKhDaiDien(KhachHang khDaiDien) {
		this.khDaiDien = khDaiDien;
	}

	public double getTienDaThanhToan() {
		return tienDaThanhToan;
	}

	public double getTongThanhTien() {
		return tongThanhTien;
	}

	public double getTienThua() {
		return tienThua;
	}

	public double getTienPhaiTra() {
		return tienPhaiTra;
	}

	public void themChiTietHopDong(int soLuong, double donGia, Xe xe) {
		ChiTietHopDong chiTietHopDong = new ChiTietHopDong(soLuong, donGia);
		chiTietHopDong.setXe(xe);
		dsCTHD.add(chiTietHopDong);
		this.tongThanhTien += chiTietHopDong.getThanhTien();
		updateTienPhaiTra();
	}
	
	public void xoaHetChiTietHopDong() {
		this.dsCTHD = new ArrayList<ChiTietHopDong>();
		this.tongThanhTien = 0;
		updateTienPhaiTra();
	}
	
	public void themChiTietThanhToan(int lanTra, double tienTra, String tenNguoiTra) {
		ChiTietThanhToan chiTietThanhToan = new ChiTietThanhToan(lanTra, tienTra, tenNguoiTra);
		dsCTTT.add(chiTietThanhToan);
		this.tienDaThanhToan += chiTietThanhToan.getTienTra();
		updateTinhTrangThanhToan();
		updateTienPhaiTra();
	}
	
	public void xoaHetChiTietThanhToan() {
		this.dsCTTT = new ArrayList<ChiTietThanhToan>();
		this.tienDaThanhToan = 0;
		updateTinhTrangThanhToan();
		updateTienPhaiTra();
	}
	
	public void updateTinhTrangThanhToan() {
		if (this.tienDaThanhToan >= this.tongThanhTien) {
			this.tinhTrangThanhToan = true;
		}
		else {
			this.tinhTrangThanhToan = false;
		}
	}
	public void updateTienThua() {
		this.tienThua = this.tienDaThanhToan - this.tienPhaiTra;
		if (this.tienThua < 0) {
			this.tienThua = 0;
		}
	}
	public void updateTienPhaiTra() {
		int soLuongXe = 0;
		int soLanThanhToan = dsCTTT.size();
		for (ChiTietHopDong chiTietHopDong : dsCTHD) {
			soLuongXe += chiTietHopDong.getSoLuong(); 
		}
		updateTinhTrangThanhToan();
		if (soLanThanhToan == 1 && tinhTrangThanhToan) {
			if (soLuongXe >= 3)
				this.tienPhaiTra = this.tongThanhTien - (this.tongThanhTien * 5.0)/100.0;
			else
				this.tienPhaiTra = this.tongThanhTien - (this.tongThanhTien * 3.0)/100.0;
		} else {
			this.tienPhaiTra = this.tongThanhTien;			
		}
		updateTienThua();
	}

	@Override
	public String toString() {
		return "HopDong [soHopDong=" + soHopDong + ", ngayHopDong=" + ngayHopDong + ", thoiGianBH=" + thoiGianBH
				+ ", tienDaThanhToan=" + tienDaThanhToan + ", tinhTrangThanhToan=" + tinhTrangThanhToan
				+ ", tongThanhTien=" + tongThanhTien + ", tienThua=" + tienThua + ", tienPhaiTra=" + tienPhaiTra
				+ ", dsCTHD=" + dsCTHD + ", dsCTTT=" + dsCTTT + "]";
	}
	
}