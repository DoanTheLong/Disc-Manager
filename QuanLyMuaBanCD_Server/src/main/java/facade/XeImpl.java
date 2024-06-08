package facade;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.XeDAO;
import entity.Xe;

public class XeImpl extends UnicastRemoteObject implements XeFacade{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7778804376763956428L;
	private XeDAO xeDao;
	
	public XeImpl() throws RemoteException{
		xeDao = new XeDAO();
	}

	public boolean themXe(Xe xe) throws RemoteException {
		return xeDao.themXe(xe);
	}

	public boolean xoaXe(String maXe) throws RemoteException {
		return xeDao.xoaXe(maXe);
	}

	public boolean capNhatXe(Xe xe) throws RemoteException {
		return xeDao.capNhatXe(xe);
	}

	public List<Xe> timXeTheoTextSearch(String keywords) throws RemoteException {
		return xeDao.timXeTheoTextSearch(keywords);
	}

	public List<Xe> getDSXe() throws RemoteException {
		return xeDao.getDSXe();
	}

	public Xe timXeTheoMa(String maXe) throws RemoteException {
		return xeDao.timXeTheoMa(maXe);
	}
}
