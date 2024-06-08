package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import entity.NhanVienKyThuat;
import util.HibernateUtil;

public class NhanVienKyThuatDao {
	private OgmSessionFactory sessionFactory;
	public NhanVienKyThuatDao() {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}
	public boolean themNhanVienKyThuat(NhanVienKyThuat nv) {
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
	public boolean xoaNhanVienKyThuat(String maNV) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		
		try {
			tr.begin();
			
			session.delete(session.find(NhanVienKyThuat.class, maNV));
			
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		
		return false;
	}
	public boolean capNhatNhanVienKyThuat(NhanVienKyThuat nhanVienKyThuat) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		
		try {
			tr.begin();
			
			session.update(nhanVienKyThuat);
			
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
	public List<NhanVienKyThuat> timNhanVienKyThuatTheoTextSearch(String keywords) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		List<NhanVienKyThuat> dsNhanVienKyThuat = new ArrayList<NhanVienKyThuat>();
		try {
			tr.begin();
			String query = "db.dsNhanVienKyThuat.find({$text:{$search:'"+keywords+"'}})";
			
			dsNhanVienKyThuat = session.createNativeQuery(query, NhanVienKyThuat.class).getResultList();
			
			tr.commit();
			return dsNhanVienKyThuat;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		
		return dsNhanVienKyThuat;
	}
	public List<NhanVienKyThuat> getDSNhanVienKyThuat() {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		List<NhanVienKyThuat> dsNhanVienKyThuat = new ArrayList<NhanVienKyThuat>();
		try {
			tr.begin();
			
			dsNhanVienKyThuat = session.createNamedQuery("getDSNhanVienKyThuatNative", NhanVienKyThuat.class).getResultList();
			
			tr.commit();
			return dsNhanVienKyThuat;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		
		return dsNhanVienKyThuat;
	}
	
	public NhanVienKyThuat timNhanVienKyThuatTheoMa(String maNV) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		NhanVienKyThuat nhanVienKyThuat = new NhanVienKyThuat();
		try {
			tr.begin();
			
			nhanVienKyThuat = session.createNativeQuery("db.dsNhanVienKyThuat.find({_id:'"+maNV+"'})", NhanVienKyThuat.class).getSingleResult();
			
			tr.commit();
			return nhanVienKyThuat;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		
		return null;
	}
}
