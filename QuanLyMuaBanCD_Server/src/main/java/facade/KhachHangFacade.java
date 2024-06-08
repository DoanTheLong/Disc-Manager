package facade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.KhachHang;

public interface KhachHangFacade extends Remote{
	public boolean themKhachHang(KhachHang kh) throws RemoteException;
	public boolean xoaKhachHang(String maKH) throws RemoteException;
	public boolean capNhatKhachHang(KhachHang khachHang) throws RemoteException;
	public List<KhachHang> timKhachHangTheoTextSearch(String keywords) throws RemoteException;
	public KhachHang timKhachHangTheoMa(String maKH) throws RemoteException;
	public List<KhachHang> getDSKhachHang() throws RemoteException;
}
