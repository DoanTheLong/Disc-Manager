package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import facade.HopDongFacade;
import facade.KhachHangFacade;
import facade.XeFacade;

public class PanelQuanLyHopDong extends JPanel {
	
	private PanelLapHopDong panelLapHoaDon;
	private PanelDanhSachHopDong panelDanhSachHoaDon;

//	private String maNVDangNhap;

//	private KhachHangFacade khachHangFacade;
//	private XeFacade xeFacade;
//	private HopDongFacade hopDongFacade;


	/**
	 * Create the panel.
	 */
	public PanelQuanLyHopDong(KhachHangFacade khachHangFacade, XeFacade xeFacade
			, HopDongFacade hopDongFacade, String maNVDangNhap) {
		
//		this.khachHangFacade = khachHangFacade;
//		this.xeFacade = xeFacade;
//		this.hopDongFacade = hopDongFacade;
//		this.maNVDangNhap = maNVDangNhap;
		
		setBounds(1, 0, 1087, 706);
		setLayout(null);
		
		panelLapHoaDon = new PanelLapHopDong(khachHangFacade, xeFacade, hopDongFacade, maNVDangNhap);
		panelDanhSachHoaDon = new PanelDanhSachHopDong(hopDongFacade, xeFacade, khachHangFacade, maNVDangNhap);
		
		JTabbedPane tabMainContent = new JTabbedPane(JTabbedPane.TOP);
		tabMainContent.setBounds(0, 0, 1087, 706);
		add(tabMainContent);
		
		JPanel pnTabLapHoaDon = new JPanel();
		pnTabLapHoaDon.setForeground(new Color(50, 205, 50));
		tabMainContent.addTab("Lập hoá đơn", null, pnTabLapHoaDon, null);
		tabMainContent.setForegroundAt(0, new Color(255, 69, 0));
		tabMainContent.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pnTabLapHoaDon.setLayout(null);
		
		pnTabLapHoaDon.add(panelLapHoaDon);
		
		JPanel pnTabDanhSachHoaDon = new JPanel();
		tabMainContent.addTab("Danh sách hoá đơn", null, pnTabDanhSachHoaDon, null);
		tabMainContent.setForegroundAt(1, new Color(255, 69, 0));
		pnTabDanhSachHoaDon.setLayout(null);
		
		pnTabDanhSachHoaDon.add(panelDanhSachHoaDon);
		
		setVisible(true);	
		
		
		
	}
	
	
	
}

