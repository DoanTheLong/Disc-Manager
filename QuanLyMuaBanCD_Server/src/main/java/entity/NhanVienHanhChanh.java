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
@Table(name = "dsNhanVienHanhChanh", indexes = {
		@Index(columnList = "maNV, tenNV, soDienThoaiNV", name = "maNV_tenNV_soDienThoaiNV_idx")
})
@IndexOptions(@IndexOption(forIndex = "maNV_tenNV_soDienThoaiNV_idx", options = "{text:true}"))
@NamedNativeQueries({
	@NamedNativeQuery(name = "getDSNhanVienHanhChanhNative", query = "{}", resultClass = NhanVienHanhChanh.class),
})
public class NhanVienHanhChanh extends NhanVien implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3952591246797434273L;
	private String chucVu;
	private String phongBan;
	private String trinhDoHocVan;
	public NhanVienHanhChanh(String maNV, String tenNV, String diaChiNV, String soDienThoaiNV, String chucVu,
			String phongBan, String trinhDoHocVan) {
		super(maNV, tenNV, diaChiNV, soDienThoaiNV);
		this.chucVu = chucVu;
		this.phongBan = phongBan;
		this.trinhDoHocVan = trinhDoHocVan;
	}
	public NhanVienHanhChanh() {
		this("", "", "", "", "", "", "");
	}
	public NhanVienHanhChanh(String maNV) {
		this(maNV, "", "", "", "", "", "");
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public String getPhongBan() {
		return phongBan;
	}
	public void setPhongBan(String phongBan) {
		this.phongBan = phongBan;
	}
	public String getTrinhDoHocVan() {
		return trinhDoHocVan;
	}
	public void setTrinhDoHocVan(String trinhDoHocVan) {
		this.trinhDoHocVan = trinhDoHocVan;
	}
	@Override
	public String toString() {
		return "NhanVienHanhChanh [chucVu=" + chucVu + ", phongBan=" + phongBan + ", trinhDoHocVan=" + trinhDoHocVan
				+ "]";
	}
	
}