package facade;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.NhanVienKyThuatDao;
import entity.NhanVienKyThuat;

public class NhanVienKyThuatImpl extends UnicastRemoteObject implements NhanVienKythuatFacade{
	/**
	 * 
	 */
	private static final long serialVersionUID = -359987110222386321L;
	private NhanVienKyThuatDao nhanVienKyThuatDao;
	
	public NhanVienKyThuatImpl() throws RemoteException{
		nhanVienKyThuatDao = new NhanVienKyThuatDao();
	}

	public boolean themNhanVienKyThuat(NhanVienKyThuat nv) throws RemoteException {
		return nhanVienKyThuatDao.themNhanVienKyThuat(nv);
	}

	public boolean xoaNhanVienKyThuat(String maNV) throws RemoteException {
		return nhanVienKyThuatDao.xoaNhanVienKyThuat(maNV);
	}

	public boolean capNhatNhanVienKyThuat(NhanVienKyThuat nhanVienKyThuat) throws RemoteException {
		return nhanVienKyThuatDao.capNhatNhanVienKyThuat(nhanVienKyThuat);
	}

	public List<NhanVienKyThuat> timNhanVienKyThuatTheoTextSearch(String keywords) throws RemoteException {
		return nhanVienKyThuatDao.timNhanVienKyThuatTheoTextSearch(keywords);
	}

	public List<NhanVienKyThuat> getDSNhanVienKyThuat() throws RemoteException {
		return nhanVienKyThuatDao.getDSNhanVienKyThuat();
	}

	public NhanVienKyThuat timNhanVienKyThuatTheoMa(String maNV) throws RemoteException {
		return nhanVienKyThuatDao.timNhanVienKyThuatTheoMa(maNV);
	}
}
