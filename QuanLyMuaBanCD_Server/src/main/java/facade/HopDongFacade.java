package facade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.HopDong;

public interface HopDongFacade extends Remote{
	public boolean themHopDong(HopDong hd) throws RemoteException;
	public boolean xoaHopDong(String maHD) throws RemoteException;
	public boolean capNhatHopDong(HopDong hopDong) throws RemoteException;
	public HopDong timHopDongTheoMaHopDong(String maHD) throws RemoteException;
	public List<HopDong> getDSHopDong() throws RemoteException;
	public List<HopDong> timHopDongTheoTextSearch(String keywords) throws RemoteException;
}
