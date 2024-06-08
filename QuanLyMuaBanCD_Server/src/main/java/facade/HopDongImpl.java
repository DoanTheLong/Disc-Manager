package facade;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.HopDongDao;
import entity.HopDong;

public class HopDongImpl extends UnicastRemoteObject implements HopDongFacade{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3785079817758495661L;
	private HopDongDao hopDongDao;
	
	public HopDongImpl() throws RemoteException{
		hopDongDao = new HopDongDao();
	}

	public boolean themHopDong(HopDong hd) throws RemoteException {
		return hopDongDao.themHopDong(hd);
	}

	public boolean xoaHopDong(String maHD) throws RemoteException {
		return hopDongDao.xoaHopDong(maHD);
	}

	public boolean capNhatHopDong(HopDong hopDong) throws RemoteException {
		return hopDongDao.capNhatHopDong(hopDong);
	}

	public HopDong timHopDongTheoMaHopDong(String maHD) throws RemoteException {
		return hopDongDao.timHopDongTheoMaHopDong(maHD);
	}

	public List<HopDong> getDSHopDong() throws RemoteException {
		return hopDongDao.getDSHopDong();
	}

	public List<HopDong> timHopDongTheoTextSearch(String keywords) throws RemoteException {
		return hopDongDao.timHopDongTheoTextSearch(keywords);
	}
}
