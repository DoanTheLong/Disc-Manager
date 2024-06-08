package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import entity.NhanVienHanhChanh;
import util.HibernateUtil;

public class NhanVienHanhChanhDao {
	private OgmSessionFactory sessionFactory;
	public NhanVienHanhChanhDao() {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}
	public boolean themNhanVienHanhChanh(NhanVienHanhChanh nv) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		
		try {
			tr.begin();
			
			session.save(nv);
			
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
	
	public boolean xoaNhanVienHanhChanh(String maNV) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		
		try {
			tr.begin();
			
			session.delete(session.find(NhanVienHanhChanh.class, maNV));
			
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		
		return false;
	}
	public boolean capNhatNhanVienHanhChanh(NhanVienHanhChanh nhanVienHanhChanh) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		
		try {
			tr.begin();
			
			session.update(nhanVienHanhChanh);
			
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
	public List<NhanVienHanhChanh> timNhanVienHanhChanhTheoTextSearch(String keywords) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		List<NhanVienHanhChanh> dsNhanVienHanhChanh = new ArrayList<NhanVienHanhChanh>();
		try {
			tr.begin();
			String query = "db.dsNhanVienHanhChanh.find({$text:{$search:'"+keywords+"'}})";
			
			dsNhanVienHanhChanh = session.createNativeQuery(query, NhanVienHanhChanh.class).getResultList();
			
			tr.commit();
			return dsNhanVienHanhChanh;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		
		return dsNhanVienHanhChanh;
	}
	public List<NhanVienHanhChanh> getDSNhanVienHanhChanh() {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		List<NhanVienHanhChanh> dsNhanVienHanhChanh = new ArrayList<NhanVienHanhChanh>();
		try {
			tr.begin();
			
			dsNhanVienHanhChanh = session.createNamedQuery("getDSNhanVienHanhChanhNative", NhanVienHanhChanh.class).getResultList();
			
			tr.commit();
			return dsNhanVienHanhChanh;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		
		return dsNhanVienHanhChanh;
	}
	
	public NhanVienHanhChanh timNhanVienHanhChanhTheoMa(String maNV) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		NhanVienHanhChanh nhanVienHanhChanh = new NhanVienHanhChanh();
		try {
			tr.begin();
			
			nhanVienHanhChanh = session.createNativeQuery("db.dsNhanVienHanhChanh.find({_id:'"+maNV+"'})"
					, NhanVienHanhChanh.class).getSingleResult();
			
			tr.commit();
			return nhanVienHanhChanh;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		
		return null;
	}
}
