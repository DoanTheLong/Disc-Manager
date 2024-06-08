package facade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.Xe;

public interface XeFacade extends Remote{
	public boolean themXe(Xe xe) throws RemoteException;
	public boolean xoaXe(String maXe) throws RemoteException;
	public boolean capNhatXe(Xe xe) throws RemoteException;
	public List<Xe> timXeTheoTextSearch(String keywords) throws RemoteException;
	public Xe timXeTheoMa(String maXe) throws RemoteException;
	public List<Xe> getDSXe() throws RemoteException;
}
