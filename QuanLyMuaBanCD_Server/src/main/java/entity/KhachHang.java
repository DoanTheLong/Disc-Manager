package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import org.hibernate.ogm.options.shared.IndexOption;
import org.hibernate.ogm.options.shared.IndexOptions;

@Entity
@Table(name = "dsKhachHang", indexes = {
		@Index(columnList = "maKH, tenKH, soDienThoaiKH", name = "maKH_tenKH_soDienThoaiKH_idx")
})
@IndexOptions(@IndexOption(forIndex = "maKH_tenKH_soDienThoaiKH_idx", options = "{text:true}"))
@NamedNativeQueries({
	@NamedNativeQuery(name = "getDSKhachHangNative", query = "{}", resultClass = KhachHang.class),
})
public class KhachHang implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5619351602174073192L;
	@Id
	private String maKH;
	private String tenKH;
	private String diaChiKH;
	private String soDienThoaiKH;
	public KhachHang(String maKH, String tenKH, String diaChiKH, String soDienThoaiKH) {
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.diaChiKH = diaChiKH;
		this.soDienThoaiKH = soDienThoaiKH;
	}
	public KhachHang() {
		this("", "", "", "");
	}
	public KhachHang(String maKH) {
		this(maKH, "", "", "");
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getDiaChiKH() {
		return diaChiKH;
	}
	public void setDiaChiKH(String diaChiKH) {
		this.diaChiKH = diaChiKH;
	}
	public String getSoDienThoaiKH() {
		return soDienThoaiKH;
	}
	public void setSoDienThoaiKH(String soDienThoaiKH) {
		this.soDienThoaiKH = soDienThoaiKH;
	}
	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", tenKH=" + tenKH + ", diaChiKH=" + diaChiKH + ", soDienThoaiKH="
				+ soDienThoaiKH + "]";
	}

	
}