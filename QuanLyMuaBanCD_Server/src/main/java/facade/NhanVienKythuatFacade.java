package facade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.NhanVienKyThuat;

public interface NhanVienKythuatFacade extends Remote{
	public boolean themNhanVienKyThuat(NhanVienKyThuat nv) throws RemoteException;
	public boolean xoaNhanVienKyThuat(String maNV) throws RemoteException;
	public boolean capNhatNhanVienKyThuat(NhanVienKyThuat nhanVienKyThuat) throws RemoteException;
	public List<NhanVienKyThuat> timNhanVienKyThuatTheoTextSearch(String keywords) throws RemoteException;
	public NhanVienKyThuat timNhanVienKyThuatTheoMa(String maNV) throws RemoteException;
	public List<NhanVienKyThuat> getDSNhanVienKyThuat() throws RemoteException;
}
