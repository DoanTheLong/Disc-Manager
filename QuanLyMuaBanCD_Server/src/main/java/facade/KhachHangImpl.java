package facade;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.KhachHangDao;
import entity.KhachHang;

public class KhachHangImpl extends UnicastRemoteObject implements KhachHangFacade{
	/**
	 * 
	 */
	private static final long serialVersionUID = -198761228891680667L;
	private KhachHangDao khachHangDao;
	
	public KhachHangImpl() throws RemoteException{
		khachHangDao = new KhachHangDao();
	}
	
	public boolean themKhachHang(KhachHang kh) throws RemoteException {
		return khachHangDao.themKhachHang(kh);
	}

	public boolean xoaKhachHang(String maKH) throws RemoteException {
		return khachHangDao.xoaKhachHang(maKH);
	}

	public boolean capNhatKhachHang(KhachHang khachHang) throws RemoteException {
		return khachHangDao.capNhatKhachHang(khachHang);
	}

	public List<KhachHang> timKhachHangTheoTextSearch(String keywords) throws RemoteException {
		return khachHangDao.timKhachHangTheoTextSearch(keywords);
	}

	public List<KhachHang> getDSKhachHang() throws RemoteException {
		return khachHangDao.getDSKhachHang();
	}

	public KhachHang timKhachHangTheoMa(String maKH) throws RemoteException {
		return khachHangDao.timKhachHangTheoMa(maKH);
	};
}
