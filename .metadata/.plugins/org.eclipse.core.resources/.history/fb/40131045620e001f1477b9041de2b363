package app;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import facade.HopDongFacade;
import facade.HopDongImpl;
import facade.KhachHangFacade;
import facade.KhachHangImpl;
import facade.NhanVienHanhChanhFacade;
import facade.NhanVienHanhChanhImpl;
import facade.NhanVienKyThuatImpl;
import facade.NhanVienKythuatFacade;
import facade.PhieuNhanXetFacade;
import facade.PhieuNhanXetImpl;
import facade.XeFacade;
import facade.XeImpl;

public class ServerApp {

	public static void main(String[] args) {
		String a ="rmi://192.168.1.17:4491";
		SecurityManager securityManager = System.getSecurityManager();
		if (securityManager == null) {
			System.setProperty("java.security.policy", "policy/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}
		
		try {
			LocateRegistry.createRegistry(4491);
			KhachHangFacade khachHangFacade = new KhachHangImpl();
			XeFacade xeFacade = new XeImpl();
			NhanVienHanhChanhFacade nhanVienHanhChanhFacade = new NhanVienHanhChanhImpl();
			NhanVienKythuatFacade nhanVienKythuatFacade = new NhanVienKyThuatImpl();
			HopDongFacade hopDongFacade = new HopDongImpl();
			PhieuNhanXetFacade phieuNhanXetFacade = new PhieuNhanXetImpl();
			
			
			
			Naming.bind(a + "/khachHangFacade", khachHangFacade);
			Naming.bind(a + "/xeFacade", xeFacade);
			Naming.bind(a + "/nhanVienHanhChanhFacade", nhanVienHanhChanhFacade);
			Naming.bind(a + "/nhanVienKythuatFacade", nhanVienKythuatFacade);
			Naming.bind(a + "/hopDongFacade", hopDongFacade);
			Naming.bind(a + "/phieuNhanXetFacade", phieuNhanXetFacade);
			System.out.println("Server bound in RMIRegistry");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
