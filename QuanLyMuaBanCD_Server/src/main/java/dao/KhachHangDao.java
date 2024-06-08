package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import entity.KhachHang;
import util.HibernateUtil;

public class KhachHangDao {
	private OgmSessionFactory sessionFactory;
	public KhachHangDao() {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}
	public boolean themKhachHang(KhachHang kh) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		
		try {
			tr.begin();
			
			session.save(kh);
			
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
	
	public boolean xoaKhachHang(String maKH) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		
		try {
			tr.begin();
			
			session.delete(session.find(KhachHang.class, maKH));
			
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
	public boolean capNhatKhachHang(KhachHang khachHang) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		
		try {
			tr.begin();
			
			session.update(khachHang);
			
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
	public List<KhachHang> timKhachHangTheoTextSearch(String keywords) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		List<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
		try {
			tr.begin();
			String query = "db.dsKhachHang.find({$text:{$search:'"+keywords+"'}})";
			
			dsKhachHang = session.createNativeQuery(query, KhachHang.class).getResultList();
			
			tr.commit();
			return dsKhachHang;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		
		return dsKhachHang;
	}
	public List<KhachHang> getDSKhachHang() {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		List<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
		try {
			tr.begin();
			
			dsKhachHang = session.createNamedQuery("getDSKhachHangNative", KhachHang.class).getResultList();
			
			tr.commit();
			return dsKhachHang;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		
		return dsKhachHang;
	}
	
	public KhachHang timKhachHangTheoMa(String maKH) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		KhachHang khachHang = new KhachHang();
		try {
			tr.begin();
			
			khachHang = session.createNativeQuery("db.dsKhachHang.find({_id:'"+maKH+"'})", KhachHang.class).getSingleResult();
			
			tr.commit();
			return khachHang;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		
		return null;
	}
}
