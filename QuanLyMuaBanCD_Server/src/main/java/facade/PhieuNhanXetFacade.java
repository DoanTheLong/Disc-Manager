package facade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.PhieuNhanXet;

public interface PhieuNhanXetFacade extends Remote{
	public boolean themPhieuNhanXet(PhieuNhanXet pnx) throws RemoteException;
	public boolean xoaPhieuNhanXet(String maPhieuNhanXet) throws RemoteException;
	public boolean capNhatPhieuNhanXet(PhieuNhanXet phieuNhanXet) throws RemoteException;
	public PhieuNhanXet timPhieuNhanXetTheoMa(String maPhieuNhanXet) throws RemoteException;
	public List<PhieuNhanXet> timPhieuNhanXetTheoSoHopDong(String soHopDong) throws RemoteException;
	public List<PhieuNhanXet> getDSPhieuNhanXet() throws RemoteException;
}
