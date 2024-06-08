package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import entity.HopDong;
import entity.KhachHang;
import util.HibernateUtil;

public class HopDongDao {
	private OgmSessionFactory sessionFactory;
	public HopDongDao() {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}
	public boolean themHopDong(HopDong hd) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		
		try {
			tr.begin();
			
			session.save(hd);
			
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}
		
		return false;
	}
	public boolean xoaHopDong(String maHD) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		
		try {
			tr.begin();
			
			session.delete(session.find(HopDong.class, maHD));
			
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}
		
		return false;
	}
	public boolean capNhatHopDong(HopDong hopDong) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		
		try {
			tr.begin();
			
			session.update(hopDong);
			
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}
		
		return false;
	}
	public HopDong timHopDongTheoMaHopDong(String maHD) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		HopDong hd = new HopDong();
		try {
			tr.begin();
			
			hd = session.createNativeQuery("db.dsHopDong.find({_id:'"+maHD+"'})", HopDong.class).getSingleResult();
			
//			Object obj = session.createNativeQuery("db.dsHopDong.find({_id:'"+maHD+"'})").getSingleResult();
//			
//			Object[] o = (Object[]) obj;
//			String maHDTK = (String) o[0];
//			int thoiGianBH = (Integer) o[6];
//			String maKH = (String) o[3];
//			Date ngayHD = (Date) o[5];
//			String maNV = (String) o[4];
//			
//			HopDong hopDong = new HopDong(maHDTK, ngayHD, thoiGianBH);
//			hopDong.setKhDaiDien(new KhachHang(maKH));
//			hopDong.setNhanVienLapHD(new NhanVienHanhChanh(maNV));
//			
//			List<Document> listCTHD = (List<Document>) o[1];
//			for (Document doc : listCTHD) {
//				String maXe = doc.getString("maXe");
//				double donGia = doc.getDouble("donGia");
//				int soLuong = doc.getInteger("soLuong");
//				hopDong.themChiTietHopDong(soLuong, donGia, new Xe(maXe));
//			}
//			
//			List<Document> listCTTT = (List<Document>) o[2];
//			for (Document doc : listCTTT) {
//				double tienTra = doc.getDouble("tienTra");
//				String tenNguoiTra = doc.getString("tenNguoiTra");
//				int lanTra = doc.getInteger("lanTra");
//				hopDong.themChiTietThanhToan(lanTra, tienTra, tenNguoiTra);
//			}
			
			tr.commit();
			return hd;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		
		return null;
	}
	public List<HopDong> getDSHopDong() {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		List<HopDong> dsHopDong = new ArrayList<HopDong>();
		try {
			tr.begin();
			
			dsHopDong = session.createNativeQuery("db.dsHopDong.find({})",HopDong.class).getResultList();
			
//			List<Object[]> list = session.createNativeQuery("db.dsHopDong.find({})").getResultList();
//			List<String> jsons = new ArrayList<String>();
//			ObjectMapper mapper = new ObjectMapper();
//			System.out.println("Trước khi parse:");
//			for (Object[] obj : list) {
//				String json = mapper.writeValueAsString(obj);
//				jsons.add(json);
//			    System.out.println(json);
//			}
//			System.out.println("Sau khi parse:");
//			for (String string : jsons) {
//				System.out.println(Document.parse(string));
//			}
//			for (Object obj : list) {
//				Object[] o = (Object[]) obj;
//				String maHDTK = (String) o[0];
//				int thoiGianBH = (Integer) o[6];
//				String maKH = (String) o[3];
//				Date ngayHD = (Date) o[5];
//				String maNV = (String) o[4];
//				
//				HopDong hopDong = new HopDong(maHDTK, ngayHD, thoiGianBH);
//				hopDong.setKhDaiDien(new KhachHang(maKH));
//				hopDong.setNhanVienLapHD(new NhanVienHanhChanh(maNV));
//				
//				List<Document> listCTHD = (List<Document>) o[1];
//				for (Document doc : listCTHD) {
//					String maXe = doc.getString("maXe");
//					double donGia = doc.getDouble("donGia");
//					int soLuong = doc.getInteger("soLuong");
//					hopDong.themChiTietHopDong(soLuong, donGia, new Xe(maXe));
//				}
//				
//				List<Document> listCTTT = (List<Document>) o[2];
//				for (Document doc : listCTTT) {
//					double tienTra = doc.getDouble("tienTra");
//					String tenNguoiTra = doc.getString("tenNguoiTra");
//					int lanTra = doc.getInteger("lanTra");
//					hopDong.themChiTietThanhToan(lanTra, tienTra, tenNguoiTra);
//				}
//				dsHopDong.add(hopDong);
//			}
			
			
			tr.commit();
			return dsHopDong;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		
		return dsHopDong;
	}
	
	public List<HopDong> timHopDongTheoTextSearch(String keywords) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		List<HopDong> dsHopDong = new ArrayList<HopDong>();
		try {
			tr.begin();
			String query = "db.dsHopDong.find({$text:{$search:'"+keywords+"'}})";
			
			dsHopDong = session.createNativeQuery(query, HopDong.class).getResultList();
			
			tr.commit();
			return dsHopDong;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		
		return dsHopDong;
	}
}
