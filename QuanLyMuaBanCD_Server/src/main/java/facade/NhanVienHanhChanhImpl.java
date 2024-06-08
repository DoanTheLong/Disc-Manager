package facade;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.NhanVienHanhChanhDao;
import entity.NhanVienHanhChanh;

public class NhanVienHanhChanhImpl extends UnicastRemoteObject implements NhanVienHanhChanhFacade{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8797329291742072974L;
	private NhanVienHanhChanhDao nhanVienHanhChanhDao;
	
	public NhanVienHanhChanhImpl() throws RemoteException{
		nhanVienHanhChanhDao = new NhanVienHanhChanhDao();
	}
	
	public boolean themNhanVienHanhChanh(NhanVienHanhChanh nv) throws RemoteException {
		return nhanVienHanhChanhDao.themNhanVienHanhChanh(nv);
	}

	public boolean xoaNhanVienHanhChanh(String maNV) throws RemoteException {
		return nhanVienHanhChanhDao.xoaNhanVienHanhChanh(maNV);
	}

	public boolean capNhatNhanVienHanhChanh(NhanVienHanhChanh nhanVienHanhChanh) throws RemoteException {
		return nhanVienHanhChanhDao.capNhatNhanVienHanhChanh(nhanVienHanhChanh);
	}

	public List<NhanVienHanhChanh> timNhanVienHanhChanhTheoTextSearch(String keywords) throws RemoteException {
		return nhanVienHanhChanhDao.timNhanVienHanhChanhTheoTextSearch(keywords);
	}

	public List<NhanVienHanhChanh> getDSNhanVienHanhChanh() throws RemoteException {
		return nhanVienHanhChanhDao.getDSNhanVienHanhChanh();
	}

	public NhanVienHanhChanh timNhanVienHanhChanhTheoMa(String maNV) throws RemoteException {
		return nhanVienHanhChanhDao.timNhanVienHanhChanhTheoMa(maNV);
	};
}
