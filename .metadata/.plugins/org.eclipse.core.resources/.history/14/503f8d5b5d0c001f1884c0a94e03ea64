package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import entity.Xe;
import util.HibernateUtil;

public class XeDao {
	private OgmSessionFactory sessionFactory;
	public XeDao() {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}
	public boolean themXe(Xe xe) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		
		try {
			tr.begin();
			
			session.save(xe);
			
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
	
	public boolean xoaXe(String maXe) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		
		try {
			tr.begin();
			
			session.delete(session.find(Xe.class, maXe));
			
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
	
	public boolean capNhatXe(Xe xe) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		
		try {
			tr.begin();
			
			session.update(xe);
			
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
	
	public List<Xe> timXeTheoTextSearch(String keywords) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		List<Xe> dsXe = new ArrayList<Xe>();
		try {
			tr.begin();
			String query = "db.dsXe.find({$text:{$search:'"+keywords+"'}})";
			
			dsXe = session.createNativeQuery(query, Xe.class).getResultList();
			
			tr.commit();
			return dsXe;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		
		return dsXe;
	}
	
	public List<Xe> getDSXe() {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		List<Xe> dsXe = new ArrayList<Xe>();
		try {
			tr.begin();
			
			dsXe = session.createNamedQuery("getDSXeNative", Xe.class).getResultList();
			
			tr.commit();
			return dsXe;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		
		return dsXe;
	}
	
	public Xe timXeTheoMa(String maXe) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		Xe xe = new Xe();
		try {
			tr.begin();
			
			xe = session.createNativeQuery("db.dsXe.find({_id:'"+maXe+"'})", Xe.class).getSingleResult();
			
			tr.commit();
			return xe;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		
		return null;
	}
}
