package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import org.hibernate.ogm.options.shared.IndexOption;
import org.hibernate.ogm.options.shared.IndexOptions;

@Entity
@Table(name = "dsNhanVienKyThuat", indexes = {
		@Index(columnList = "maNV, tenNV, soDienThoaiNV", name = "maNV_tenNV_soDienThoaiNV_idx")
})
@IndexOptions(@IndexOption(forIndex = "maNV_tenNV_soDienThoaiNV_idx", options = "{text:true}"))
@NamedNativeQueries({
	@NamedNativeQuery(name = "getDSNhanVienKyThuatNative", query = "{}", resultClass = NhanVienKyThuat.class),
})
public class NhanVienKyThuat extends NhanVien implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7535119801248013613L;
	private String chucVu;
	private String bacTho;
	private int soNamKN;
	
	public NhanVienKyThuat(String maNV, String tenNV, String diaChiNV, String soDienThoaiNV, String chucVu,
			String bacTho, int soNamKN) {
		super(maNV, tenNV, diaChiNV, soDienThoaiNV);
		this.chucVu = chucVu;
		this.bacTho = bacTho;
		this.soNamKN = soNamKN;
	}
	public NhanVienKyThuat(String maNV) {
		this(maNV, "", "", "", "", "", 0);
	}
	public NhanVienKyThuat() {
		this("", "", "", "", "", "", 0);
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public String getBacTho() {
		return bacTho;
	}
	public void setBacTho(String bacTho) {
		this.bacTho = bacTho;
	}
	public int getSoNamKN() {
		return soNamKN;
	}
	public void setSoNamKN(int soNamKN) {
		this.soNamKN = soNamKN;
	}
	@Override
	public String toString() {
		return "NhanVienKyThuat [chucVu=" + chucVu + ", bacTho=" + bacTho + ", soNamKN=" + soNamKN + "]";
	}
	
	
}