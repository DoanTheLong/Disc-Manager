package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import entity.HopDong;
import entity.NhanVienKyThuat;
import entity.PhieuNhanXet;
import util.HibernateUtil;

public class PhieuNhanXetDao {
	private OgmSessionFactory sessionFactory;
	public PhieuNhanXetDao() {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}
	public boolean themPhieuNhanXet(PhieuNhanXet pnx) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		
		try {
			tr.begin();
			
			session.save(pnx);
			
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
	
	public boolean xoaPhieuNhanXet(String maPhieuNhanXet) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		
		try {
			tr.begin();
			
			session.delete(session.find(PhieuNhanXet.class, maPhieuNhanXet));
			
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
	
	public boolean capNhatPhieuNhanXet(PhieuNhanXet phieuNhanXet) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		
		try {
			tr.begin();
			
			session.update(phieuNhanXet);
			
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
	
	public PhieuNhanXet timPhieuNhanXetTheoMa(String maPhieuNhanXet) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		PhieuNhanXet phieuNhanXet = new PhieuNhanXet();
		try {
			tr.begin();
			
			Object obj = session.createNativeQuery("db.dsPhieuNhanXet.find({_id:'"+maPhieuNhanXet+"'})").getSingleResult();
			Object[] o = (Object[]) obj;
			String maPhieu = (String) o[0];
			double giaTien = (Double) o[1];
			String liDo = (String) o[2];
			String soHopDong = (String) o[3];
			String tenLinhKien = (String) o[4];
			boolean loi = (Boolean) o[5];
			String maNV = (String) o[6];
			
			phieuNhanXet.setMaPhieu(maPhieu);
			phieuNhanXet.setGiaTien(giaTien);
			phieuNhanXet.setLiDoBaoHanh(liDo);
			phieuNhanXet.setHopDong(new HopDong(soHopDong));
			phieuNhanXet.setTenLinhKien(tenLinhKien);
			phieuNhanXet.setLoiThuoc(loi);
			phieuNhanXet.setNhanVienKT(new NhanVienKyThuat(maNV));
			
			tr.commit();
			return phieuNhanXet;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		
		return null;
	}
	
	public List<PhieuNhanXet> getDSPhieuNhanXet() {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		List<PhieuNhanXet> dsPhieuNhanXet = new ArrayList<PhieuNhanXet>();
		try {
			tr.begin();
			
			List<?> list = session.createNativeQuery("db.dsPhieuNhanXet.find({})").getResultList();
			
			for (Object obj : list) {
				Object[] o = (Object[]) obj;
				String maPhieu = (String) o[0];
				double giaTien = (Double) o[1];
				String liDo = (String) o[2];
				String soHopDong = (String) o[3];
				String tenLinhKien = (String) o[4];
				boolean loi = (Boolean) o[5];
				String maNV = (String) o[6];
				PhieuNhanXet phieuNhanXet = new PhieuNhanXet(maPhieu, tenLinhKien, liDo, loi, giaTien);
				phieuNhanXet.setHopDong(new HopDong(soHopDong));
				phieuNhanXet.setNhanVienKT(new NhanVienKyThuat(maNV));
				dsPhieuNhanXet.add(phieuNhanXet);
			}
			
			tr.commit();
			return dsPhieuNhanXet;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		
		return dsPhieuNhanXet;
	}
	
	public List<PhieuNhanXet> timPhieuNhanXetTheoSoHopDong(String soHopDong) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		List<PhieuNhanXet> dsPhieuNhanXet = new ArrayList<PhieuNhanXet>();
		try {
			tr.begin();
			
			List<?> list = session.createNativeQuery("db.dsPhieuNhanXet.find({soHopDong:'"+soHopDong+"'})").getResultList();
			
			for (Object obj : list) {
				Object[] o = (Object[]) obj;
				String maPhieu = (String) o[0];
				double giaTien = (Double) o[1];
				String liDo = (String) o[2];
				String soHD = (String) o[3];
				String tenLinhKien = (String) o[4];
				boolean loi = (Boolean) o[5];
				String maNV = (String) o[6];
				PhieuNhanXet phieuNhanXet = new PhieuNhanXet(maPhieu, tenLinhKien, liDo, loi, giaTien);
				phieuNhanXet.setHopDong(new HopDong(soHD));
				phieuNhanXet.setNhanVienKT(new NhanVienKyThuat(maNV));
				dsPhieuNhanXet.add(phieuNhanXet);
			}
			
			tr.commit();
			return dsPhieuNhanXet;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		
		return dsPhieuNhanXet;
	}
}
