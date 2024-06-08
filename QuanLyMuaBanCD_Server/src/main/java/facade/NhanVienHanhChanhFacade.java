package facade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.NhanVienHanhChanh;

public interface NhanVienHanhChanhFacade extends Remote{
	public boolean themNhanVienHanhChanh(NhanVienHanhChanh nv) throws RemoteException;
	public boolean xoaNhanVienHanhChanh(String maNV) throws RemoteException;
	public boolean capNhatNhanVienHanhChanh(NhanVienHanhChanh nhanVienHanhChanh) throws RemoteException;
	public List<NhanVienHanhChanh> timNhanVienHanhChanhTheoTextSearch(String keywords) throws RemoteException;
	public NhanVienHanhChanh timNhanVienHanhChanhTheoMa(String maNV) throws RemoteException;
	public List<NhanVienHanhChanh> getDSNhanVienHanhChanh() throws RemoteException;
}
