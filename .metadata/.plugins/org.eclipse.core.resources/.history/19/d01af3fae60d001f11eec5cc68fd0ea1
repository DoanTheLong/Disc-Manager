package app;

import java.awt.EventQueue;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import entity.ChiTietHopDong;
import entity.ChiTietThanhToan;
import entity.HopDong;
import entity.KhachHang;
import entity.NhanVienHanhChanh;
import entity.NhanVienKyThuat;
import entity.PhieuNhanXet;
import entity.TaiKhoan;
import entity.Xe;
import facade.HopDongFacade;
import facade.KhachHangFacade;
import facade.NhanVienHanhChanhFacade;
import facade.NhanVienKythuatFacade;
import facade.PhieuNhanXetFacade;
import facade.XeFacade;
import gui.FrmLogin;

public class ClientApp {

	public static void main(String[] args) {
		String a = "rmi://192.168.1.17:4491";
		SecurityManager securityManager = System.getSecurityManager();
		if (securityManager == null) {
			System.setProperty("java.security.policy", "policy/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}

		try {
			KhachHangFacade khachHangFacade = (KhachHangFacade) Naming.lookup(a + "/khachHangFacade");
			XeFacade xeFacade = (XeFacade) Naming.lookup(a + "/xeFacade");
			NhanVienHanhChanhFacade nhanVienHanhChanhFacade = (NhanVienHanhChanhFacade) Naming
					.lookup(a + "/nhanVienHanhChanhFacade");
			NhanVienKythuatFacade nhanVienKythuatFacade = (NhanVienKythuatFacade) Naming
					.lookup(a + "/nhanVienKythuatFacade");
			HopDongFacade hopDongFacade = (HopDongFacade) Naming.lookup(a + "/hopDongFacade");
			PhieuNhanXetFacade phieuNhanXetFacade = (PhieuNhanXetFacade) Naming.lookup(a + "/phieuNhanXetFacade");
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						NhanVienHanhChanh nvhc = new NhanVienHanhChanh("1");
						nvhc.setTaiKhoan(new TaiKhoan("2", "Quản lý"));
						nhanVienHanhChanhFacade.xoaNhanVienHanhChanh("1");
						nhanVienHanhChanhFacade.themNhanVienHanhChanh(nvhc);
						NhanVienKyThuat nvkt = new NhanVienKyThuat("2");
						nvkt.setTaiKhoan(new TaiKhoan("2", "Quản lý"));
						nhanVienKythuatFacade.xoaNhanVienKyThuat("2");
						nhanVienKythuatFacade.themNhanVienKyThuat(nvkt);
//						Xe x = new Xe("1");
//						xeFacade.xoaXe("1");
//						xeFacade.themXe(x);
//						KhachHang kh = new KhachHang("1");
//						khachHangFacade.xoaKhachHang("1");
//						khachHangFacade.themKhachHang(kh);

						FrmLogin frame = new FrmLogin(khachHangFacade, xeFacade, nhanVienHanhChanhFacade,
								nhanVienKythuatFacade, hopDongFacade, phieuNhanXetFacade);
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});

		} catch (MalformedURLException | RemoteException | NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
