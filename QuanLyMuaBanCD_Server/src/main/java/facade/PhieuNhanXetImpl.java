package facade;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.PhieuNhanXetDao;
import entity.PhieuNhanXet;

public class PhieuNhanXetImpl extends UnicastRemoteObject implements PhieuNhanXetFacade{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7173329685729176216L;
	private PhieuNhanXetDao phieuNhanXetDao;
	
	public PhieuNhanXetImpl() throws RemoteException{
		phieuNhanXetDao = new PhieuNhanXetDao();
	}

	public boolean themPhieuNhanXet(PhieuNhanXet pnx) throws RemoteException {
		return phieuNhanXetDao.themPhieuNhanXet(pnx);
	}

	public boolean xoaPhieuNhanXet(String maPhieuNhanXet) throws RemoteException {
		return phieuNhanXetDao.xoaPhieuNhanXet(maPhieuNhanXet);
	}

	public boolean capNhatPhieuNhanXet(PhieuNhanXet phieuNhanXet) throws RemoteException {
		return phieuNhanXetDao.capNhatPhieuNhanXet(phieuNhanXet);
	}

	public List<PhieuNhanXet> getDSPhieuNhanXet() throws RemoteException {
		return phieuNhanXetDao.getDSPhieuNhanXet();
	}

	public PhieuNhanXet timPhieuNhanXetTheoMa(String maPhieuNhanXet) throws RemoteException {
		return phieuNhanXetDao.timPhieuNhanXetTheoMa(maPhieuNhanXet);
	}

	public List<PhieuNhanXet> timPhieuNhanXetTheoSoHopDong(String soHopDong) throws RemoteException {
		return phieuNhanXetDao.timPhieuNhanXetTheoSoHopDong(soHopDong);
	}
}
