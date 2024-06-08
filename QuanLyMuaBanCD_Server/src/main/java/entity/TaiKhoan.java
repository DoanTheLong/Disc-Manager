package entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "taiKhoan")
public class TaiKhoan implements Serializable{
	/**	
	 * 
	 */
	private static final long serialVersionUID = -1830004166970190404L;
	private String matKhau;
	private String loaiTaiKhoan;
	
	public TaiKhoan(String matKhau, String loaiTaiKhoan) {
		this.matKhau = matKhau;
		this.loaiTaiKhoan = loaiTaiKhoan;
	}
	public TaiKhoan() {
		this("", "");
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getLoaiTaiKhoan() {
		return loaiTaiKhoan;
	}
	public void setLoaiTaiKhoan(String loaiTaiKhoan) {
		this.loaiTaiKhoan = loaiTaiKhoan;
	}
}
