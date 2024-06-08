package util;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.ogm.OgmSessionFactory;
import org.hibernate.ogm.boot.OgmSessionFactoryBuilder;
import org.hibernate.ogm.cfg.OgmProperties;
import org.hibernate.service.ServiceRegistry;

import entity.ChiTietHopDong;
import entity.ChiTietThanhToan;
import entity.HopDong;
import entity.KhachHang;
import entity.NhanVien;
import entity.NhanVienHanhChanh;
import entity.NhanVienKyThuat;
import entity.PhieuNhanXet;
import entity.TaiKhoan;
import entity.Xe;

public class HibernateUtil {
	private static HibernateUtil instance = null;
	private OgmSessionFactory sessionFactory;
	private HibernateUtil() {
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySetting(OgmProperties.ENABLED, true)
				.configure()
				.build();
		Metadata metadata = new MetadataSources(serviceRegistry)
				.addAnnotatedClass(ChiTietHopDong.class)
				.addAnnotatedClass(ChiTietThanhToan.class)
				.addAnnotatedClass(HopDong.class)
				.addAnnotatedClass(KhachHang.class)
				.addAnnotatedClass(NhanVien.class)
				.addAnnotatedClass(NhanVienHanhChanh.class)
				.addAnnotatedClass(NhanVienKyThuat.class)
				.addAnnotatedClass(PhieuNhanXet.class)
				.addAnnotatedClass(Xe.class)
				.addAnnotatedClass(TaiKhoan.class)
				.getMetadataBuilder()
				.build();
		
		sessionFactory = metadata.getSessionFactoryBuilder()
				.unwrap(OgmSessionFactoryBuilder.class)
				.build();
	}
	public synchronized static HibernateUtil getInstance() {
		if (instance == null)
			instance = new HibernateUtil();
		return instance;
	}
	public OgmSessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
