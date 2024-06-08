/**
	 * @param Nguyễn Minh Quang 19487761
	 **/

package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import facade.HopDongFacade;
import facade.KhachHangFacade;
import facade.NhanVienHanhChanhFacade;
import facade.NhanVienKythuatFacade;
import facade.PhieuNhanXetFacade;
import facade.XeFacade;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class FrmMainNhanVienHanhChanh extends JFrame {

	private Image img_Logo = new ImageIcon(FrmMainNhanVienHanhChanh.class.getResource("../image/car-dealer.png")).getImage()
			.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
	private Image img_Intro = new ImageIcon(FrmMainNhanVienHanhChanh.class.getResource("../image/introduction.png")).getImage()
			.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
	private Image img_Logout = new ImageIcon(FrmMainNhanVienHanhChanh.class.getResource("../image/logout.png")).getImage()
			.getScaledInstance(34, 30, java.awt.Image.SCALE_SMOOTH);
	private Image img_Xe = new ImageIcon(FrmMainNhanVienHanhChanh.class.getResource("../image/motorcycle.png")).getImage()
			.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
	private Image img_KhachHang = new ImageIcon(FrmMainNhanVienHanhChanh.class.getResource("../image/target.png")).getImage()
			.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
	private Image img_HopDong = new ImageIcon(FrmMainNhanVienHanhChanh.class.getResource("../image/agreement.png")).getImage()
			.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
	private Image img_Account = new ImageIcon(FrmMainNhanVienHanhChanh.class.getResource("../image/profile.png")).getImage()
			.getScaledInstance(50, 45, java.awt.Image.SCALE_SMOOTH);

	private JPanel contentPane;
	private JLabel lblTitleChucNang;

	private PanelGioiThieu panelGioiThieu;
	private PanelXe panelXe;
	private PanelQuanLyKhachHang panelQuanLyKhachHang;
	private PanelQuanLyHopDong panelQuanLyHopDong;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		SecurityManager securityManager = System.getSecurityManager();
//		if (securityManager == null) {
//			System.setProperty("java.security.policy", "policy/policy.policy");
//			System.setSecurityManager(new SecurityManager());
//		}
//		
//		try {
//			KhachHangFacade khachHangFacade = (KhachHangFacade) Naming.lookup("rmi://192.168.1.10:4491/khachHangFacade");
//			XeFacade xeFacade = (XeFacade) Naming.lookup("rmi://192.168.1.10:4491/xeFacade");
//			NhanVienHanhChanhFacade nhanVienHanhChanhFacade = (NhanVienHanhChanhFacade) Naming.lookup("rmi://192.168.1.10:4491/nhanVienHanhChanhFacade");
//			NhanVienKythuatFacade nhanVienKythuatFacade = (NhanVienKythuatFacade) Naming.lookup("rmi://192.168.1.10:4491/nhanVienKythuatFacade");
//			HopDongFacade hopDongFacade = (HopDongFacade) Naming.lookup("rmi://192.168.1.10:4491/hopDongFacade");
//			PhieuNhanXetFacade phieuNhanXetFacade = (PhieuNhanXetFacade) Naming.lookup("rmi://192.168.1.10:4491/phieuNhanXetFacade");
//			EventQueue.invokeLater(new Runnable() {
//				public void run() {
//					try {
//						FrmMain frame = new FrmMain(khachHangFacade, xeFacade
//							, nhanVienHanhChanhFacade, nhanVienKythuatFacade, hopDongFacade
//							, phieuNhanXetFacade);
//						frame.setVisible(true);
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				}
//			});
//		
//		} catch (MalformedURLException | RemoteException | NotBoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
	}

	/**
	 * Create the frame.
	 */
	public FrmMainNhanVienHanhChanh(KhachHangFacade khachHangFacade, XeFacade xeFacade
			, NhanVienHanhChanhFacade nhanVienHanhChanhFacade
			, NhanVienKythuatFacade nhanVienKythuatFacade, HopDongFacade hopDongFacade
			, PhieuNhanXetFacade phieuNhanXetFacade, String maNVDangNhap, String tenNV) {
		
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 728);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(65, 105, 225), 2));
		contentPane.setBackground(new Color(102, 205, 170));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelGioiThieu = new PanelGioiThieu();
		panelXe = new PanelXe(xeFacade);
		panelQuanLyKhachHang = new PanelQuanLyKhachHang(khachHangFacade);
		panelQuanLyHopDong = new PanelQuanLyHopDong(khachHangFacade, xeFacade, hopDongFacade, maNVDangNhap);

		JPanel pnlMenu = new JPanel();
		pnlMenu.setBackground(new Color(100, 149, 237));
		pnlMenu.setBounds(0, 0, 279, 728);
		contentPane.add(pnlMenu);
		pnlMenu.setLayout(null);

		JPanel pnlXeMay = new JPanel();
		pnlXeMay.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlXeMay.setBackground(new Color(70, 130, 180));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				pnlXeMay.setBackground(new Color(100, 149, 237));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				pnlXeMay.setBackground(new Color(0, 191, 255));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				pnlXeMay.setBackground(new Color(70, 130, 180));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelXe);
			}
		});
		pnlXeMay.setBackground(new Color(100, 149, 237));
		pnlXeMay.setBounds(0, 202, 279, 50);
		pnlMenu.add(pnlXeMay);
		pnlXeMay.setLayout(null);

		JLabel lblXeMay = new JLabel("XE MÁY");
		lblXeMay.setForeground(new Color(255, 255, 255));
		lblXeMay.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblXeMay.setBounds(74, 11, 132, 25);
		pnlXeMay.add(lblXeMay);

		JLabel lblIconXeMay = new JLabel("");
		lblIconXeMay.setBounds(10, 0, 54, 50);
		lblIconXeMay.setIcon(new ImageIcon(img_Xe));
		pnlXeMay.add(lblIconXeMay);

		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogo.setBounds(10, 11, 259, 120);
		lblIconLogo.setIcon(new ImageIcon(img_Logo));
		pnlMenu.add(lblIconLogo);

		JPanel pnlGioiThieu = new JPanel();
		pnlGioiThieu.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlGioiThieu.setBackground(new Color(70, 130, 180));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				pnlGioiThieu.setBackground(new Color(100, 149, 237));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				pnlGioiThieu.setBackground(new Color(0, 191, 255));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				pnlGioiThieu.setBackground(new Color(70, 130, 180));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				lblTitleChucNang.setText("");
				menuClicked(panelGioiThieu);
			}
		});

		pnlGioiThieu.setBackground(new Color(100, 149, 237));
		pnlGioiThieu.setBounds(0, 152, 279, 50);
		pnlMenu.add(pnlGioiThieu);
		pnlGioiThieu.setLayout(null);

		JLabel lblGioiThieu = new JLabel("GI\u1EDAI THI\u1EC6U");
		lblGioiThieu.setForeground(new Color(255, 255, 255));
		lblGioiThieu.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGioiThieu.setBounds(74, 11, 127, 25);
		pnlGioiThieu.add(lblGioiThieu);

		JLabel lblInconIntro = new JLabel("");
		lblInconIntro.setBounds(10, 0, 54, 50);
		lblInconIntro.setIcon(new ImageIcon(img_Intro));
		pnlGioiThieu.add(lblInconIntro);

		JPanel pnlLogout = new JPanel();
		pnlLogout.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlLogout.setBackground(new Color(70, 130, 180));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				pnlLogout.setBackground(new Color(100, 149, 237));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				pnlLogout.setBackground(new Color(0, 191, 255));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				pnlLogout.setBackground(new Color(70, 130, 180));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn ĐĂNG XUẤT khỏi ứng dụng?") == 0) {
					FrmLogin frmLogin = new FrmLogin(khachHangFacade, xeFacade
							, nhanVienHanhChanhFacade, nhanVienKythuatFacade, hopDongFacade
							, phieuNhanXetFacade);
					frmLogin.setVisible(true);
					FrmMainNhanVienHanhChanh.this.dispose();
				}
			}
		});
		pnlLogout.setBackground(new Color(100, 149, 237));
		pnlLogout.setBounds(0, 678, 279, 50);
		pnlMenu.add(pnlLogout);
		pnlLogout.setLayout(null);

		JLabel lblLogOut = new JLabel("ĐĂNG XUẤT");
		lblLogOut.setForeground(new Color(255, 255, 255));
		lblLogOut.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLogOut.setBounds(74, 11, 130, 25);
		pnlLogout.add(lblLogOut);

		JLabel lblIconLogout = new JLabel("");
		lblIconLogout.setBounds(10, 0, 54, 50);
		lblIconLogout.setIcon(new ImageIcon(img_Logout));
		pnlLogout.add(lblIconLogout);

		JPanel pnlKhachHang = new JPanel();
		pnlKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlKhachHang.setBackground(new Color(70, 130, 180));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				pnlKhachHang.setBackground(new Color(100, 149, 237));

			}

			@Override
			public void mousePressed(MouseEvent e) {
				pnlKhachHang.setBackground(new Color(0, 191, 255));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				pnlKhachHang.setBackground(new Color(70, 130, 180));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelQuanLyKhachHang);
			}
		});
		pnlKhachHang.setLayout(null);
		pnlKhachHang.setBackground(new Color(100, 149, 237));
		pnlKhachHang.setBounds(0, 252, 279, 50);
		pnlMenu.add(pnlKhachHang);

		JLabel lblKhachHang = new JLabel("KHÁCH HÀNG");
		lblKhachHang.setForeground(Color.WHITE);
		lblKhachHang.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblKhachHang.setBounds(74, 11, 132, 25);
		pnlKhachHang.add(lblKhachHang);

		JLabel lblIconKhachHang = new JLabel("");
		lblIconKhachHang.setBounds(10, 0, 54, 50);
		lblIconKhachHang.setIcon(new ImageIcon(img_KhachHang));
		pnlKhachHang.add(lblIconKhachHang);

		JPanel pnlHopDong = new JPanel();
		pnlHopDong.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlHopDong.setBackground(new Color(70, 130, 180));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				pnlHopDong.setBackground(new Color(100, 149, 237));

			}

			@Override
			public void mousePressed(MouseEvent e) {
				pnlHopDong.setBackground(new Color(0, 191, 255));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				pnlHopDong.setBackground(new Color(70, 130, 180));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelQuanLyHopDong);
			}
		});
		pnlHopDong.setLayout(null);
		pnlHopDong.setBackground(new Color(100, 149, 237));
		pnlHopDong.setBounds(0, 301, 279, 50);
		pnlMenu.add(pnlHopDong);

		JLabel lblHopDong = new JLabel("HỢP ĐỒNG");
		lblHopDong.setForeground(Color.WHITE);
		lblHopDong.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHopDong.setBounds(74, 11, 132, 25);
		pnlHopDong.add(lblHopDong);

		JLabel lblIconHopDong = new JLabel("");
		lblIconHopDong.setBounds(10, 0, 54, 50);
		lblIconHopDong.setIcon(new ImageIcon(img_HopDong));
		pnlHopDong.add(lblIconHopDong);

		JLabel lblIconAccount = new JLabel("");
		lblIconAccount.setBounds(0, 630, 50, 44);
		lblIconAccount.setIcon(new ImageIcon(img_Account));
		pnlMenu.add(lblIconAccount);

		JPanel pnAccount = new JPanel();
		pnAccount.setBackground(new Color(100, 149, 237));
		pnAccount.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnAccount.setBounds(56, 638, 213, 30);
		pnlMenu.add(pnAccount);
		pnAccount.setLayout(null);

		JLabel lblAccountDetail = new JLabel(tenNV);
		lblAccountDetail.setBounds(0, 0, 213, 30);
		pnAccount.add(lblAccountDetail);
		lblAccountDetail.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccountDetail.setFont(new Font("Times New Roman", Font.BOLD, 17));

		JPanel pnlMainContent = new JPanel();
		pnlMainContent.setBounds(278, 22, 1088, 706);
		contentPane.add(pnlMainContent);
		pnlMainContent.setLayout(null);

		JPanel pnlMenuTop = new JPanel();
		pnlMenuTop.setBounds(277, 0, 1089, 23);
		contentPane.add(pnlMenuTop);
		pnlMenuTop.setLayout(null);
		pnlMenuTop.setBackground(new Color(100, 149, 237));

		JLabel lblMinimize = new JLabel("—");
		lblMinimize.setBounds(1043, 0, 20, 21);
		pnlMenuTop.add(lblMinimize);
		lblMinimize.setVerticalAlignment(SwingConstants.TOP);
		lblMinimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setExtendedState(JFrame.ICONIFIED);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblMinimize.setForeground(Color.RED);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblMinimize.setForeground(Color.WHITE);
			}
		});
		lblMinimize.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinimize.setForeground(Color.WHITE);
		lblMinimize.setFont(new Font("Comic Sans MS", Font.BOLD, 16));

		JLabel lblExit = new JLabel("X");
		lblExit.setBounds(1068, 1, 20, 20);
		pnlMenuTop.add(lblExit);
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn ĐÓNG ứng dụng?", "Xác nhận",
						JOptionPane.YES_NO_OPTION) == 0) {
					FrmMainNhanVienHanhChanh.this.dispose();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblExit.setForeground(Color.RED);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblExit.setForeground(Color.WHITE);
			}
		});
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setForeground(Color.WHITE);
		lblExit.setFont(new Font("Comic Sans MS", Font.BOLD, 16));

		lblTitleChucNang = new JLabel("");
		lblTitleChucNang.setBackground(new Color(100, 149, 237));
		lblTitleChucNang.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleChucNang.setForeground(new Color(255, 215, 0));
		lblTitleChucNang.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitleChucNang.setBounds(1, 0, 1087, 23);
		pnlMenuTop.add(lblTitleChucNang);

		pnlMainContent.add(panelGioiThieu);
		pnlMainContent.add(panelXe);
		pnlMainContent.add(panelQuanLyKhachHang);
		pnlMainContent.add(panelQuanLyHopDong);

	}

	public void menuClicked(JPanel panel) {
		panelGioiThieu.setVisible(false);
		panelXe.setVisible(false);
		panelQuanLyKhachHang.setVisible(false);
		panelQuanLyHopDong.setVisible(false);

		panel.setVisible(true);
	}
}
