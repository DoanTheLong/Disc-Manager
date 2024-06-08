package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import entity.NhanVienHanhChanh;
import entity.NhanVienKyThuat;
import facade.HopDongFacade;
import facade.KhachHangFacade;
import facade.NhanVienHanhChanhFacade;
import facade.NhanVienKythuatFacade;
import facade.PhieuNhanXetFacade;
import facade.XeFacade;

public class FrmLogin extends JFrame {

	private Image img_Logo = new ImageIcon(FrmLogin.class.getResource("../image/car-dealer.png")).getImage()
			.getScaledInstance(100, 90, java.awt.Image.SCALE_SMOOTH);
	private Image img_Login = new ImageIcon(FrmLogin.class.getResource("../image/key.png")).getImage()
			.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
	private Image img_Username = new ImageIcon(FrmLogin.class.getResource("../image/manager.png")).getImage()
			.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
	private Image img_Password = new ImageIcon(FrmLogin.class.getResource("../image/password.png")).getImage()
			.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);

	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField txtPassword;
	private JLabel lblLogMessage = new JLabel("");
	
	/**
	 * Create the frame.
	 */
	public FrmLogin(KhachHangFacade khachHangFacade, XeFacade xeFacade
			, NhanVienHanhChanhFacade nhanVienHanhChanhFacade
			, NhanVienKythuatFacade nhanVienKythuatFacade, HopDongFacade hopDongFacade
			, PhieuNhanXetFacade phieuNhanXetFacade) {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new LineBorder(new Color(100, 149, 237), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(150, 147, 300, 55);
		contentPane.add(panel);
		panel.setLayout(null);

		txtUserName = new JTextField();
		txtUserName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUserName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtUserName.getText().equals("Tên đăng nhập")) {
					txtUserName.setText("");
				} else {
					txtUserName.selectAll();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtUserName.getText().equals("")) {
					txtUserName.setText("Tên đăng nhập");
				}
			}
		});
		txtUserName.setBorder(null);
		txtUserName.setText("Tên đăng nhập");
		txtUserName.setBounds(10, 11, 240, 33);
		panel.add(txtUserName);
		txtUserName.setColumns(10);

		JLabel lblIconUsername = new JLabel("");
		lblIconUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconUsername.setBounds(254, 0, 46, 55);
		panel.add(lblIconUsername);
		lblIconUsername.setIcon(new ImageIcon(img_Username));

		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(150, 213, 300, 55);
		contentPane.add(panel1);

		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtPassword.getText().equals("Mật khẩu")) {
					txtPassword.setEchoChar('●');
					txtPassword.setText("");
				} else {
					txtPassword.selectAll();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtPassword.getText().equals("")) {
					txtPassword.setText("Mật khẩu");
					txtPassword.setEchoChar((char) 0);
				}
			}
		});
		txtPassword.setBorder(null);
		txtPassword.setEchoChar((char) 0);
		txtPassword.setText("Mật khẩu");
		txtPassword.setBounds(10, 11, 240, 33);
		panel1.add(txtPassword);

		JLabel lblIconPassword = new JLabel("");
		lblIconPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconPassword.setBounds(254, 0, 46, 55);
		panel1.add(lblIconPassword);
		lblIconPassword.setIcon(new ImageIcon(img_Password));
		
		JPanel pnlButtonLogin = new JPanel();
		pnlButtonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String loaiTK = "";
				if (txtUserName.getText().equals("") || txtUserName.getText().equals("Tên đăng nhập") || 
						txtPassword.getText().equals("") || txtPassword.getText().equals("Mật khẩu")) {
					lblLogMessage.setText("Vui lòng nhập tất cả thông tin!");
				} else {
					boolean xacNhan = false;
					String maNVDangNhap = "";
					String tenNV = "";
					try {
						NhanVienHanhChanh nvhc = nhanVienHanhChanhFacade.timNhanVienHanhChanhTheoMa(txtUserName.getText().trim());
						if (nvhc != null) {
							if (nvhc.getTaiKhoan().getMatKhau().equals(txtPassword.getText().trim())) {
								xacNhan = true;
								maNVDangNhap = nvhc.getMaNV();
								tenNV = nvhc.getTenNV();
								loaiTK = nvhc.getTaiKhoan().getLoaiTaiKhoan();
							}
						} else {
							NhanVienKyThuat nvkt = nhanVienKythuatFacade.timNhanVienKyThuatTheoMa(txtUserName.getText().trim());
							if (nvkt != null) {
								if (nvkt.getTaiKhoan().getMatKhau().equals(txtPassword.getText().trim())) {
									xacNhan = true;
									maNVDangNhap = nvkt.getMaNV();
									tenNV = nvkt.getTenNV();
									loaiTK = nvkt.getTaiKhoan().getLoaiTaiKhoan();
								}
							}
							
						}
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
					if (xacNhan) {
						lblLogMessage.setText("");
						JOptionPane.showMessageDialog(null, "Đăng nhập Thành Công!");
						if (loaiTK.equals("Quản lý")) {
							FrmMain frmMain = new FrmMain(khachHangFacade, xeFacade
									, nhanVienHanhChanhFacade, nhanVienKythuatFacade, hopDongFacade
									, phieuNhanXetFacade, maNVDangNhap, tenNV);
							frmMain.setVisible(true);
						} 
						if (loaiTK.equals("Nhân viên hành chánh")) {
							FrmMainNhanVienHanhChanh frmMainNhanVienHanhChanh = new 
									FrmMainNhanVienHanhChanh(khachHangFacade, xeFacade
											, nhanVienHanhChanhFacade, nhanVienKythuatFacade
											, hopDongFacade, phieuNhanXetFacade, maNVDangNhap, tenNV);
							frmMainNhanVienHanhChanh.setVisible(true);
						}
						if (loaiTK.equals("Nhân viên kỹ thuật")) {
							FrmMainNhanVienKyThuat frmMainNhanVienKyThuat = new 
									FrmMainNhanVienKyThuat(khachHangFacade, xeFacade
											, nhanVienHanhChanhFacade, nhanVienKythuatFacade
											, hopDongFacade, phieuNhanXetFacade, maNVDangNhap, tenNV);
							frmMainNhanVienKyThuat.setVisible(true);
						}
						FrmLogin.this.dispose();
					} 
					else {
						lblLogMessage.setText("'Tên đăng nhập' hoặc 'Mật khẩu' không đúng!");
					}
				}
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlButtonLogin.setBackground(new Color(30, 60, 60));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnlButtonLogin.setBackground(new Color(175, 238, 238));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				pnlButtonLogin.setBackground(new Color(60, 80, 80));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				pnlButtonLogin.setBackground(new Color(30, 60, 60));
			}
		});
		pnlButtonLogin.setBackground(new Color(135, 206, 235));
		pnlButtonLogin.setBounds(170, 308, 250, 48);
		contentPane.add(pnlButtonLogin);
		pnlButtonLogin.setLayout(null);

		JLabel lblNewLabel = new JLabel("ĐĂNG NHẬP");
		lblNewLabel.setForeground(new Color(219, 112, 147));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(94, 0, 104, 48);
		pnlButtonLogin.add(lblNewLabel);

		JLabel lblNLogin = new JLabel("");
		lblNLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblNLogin.setBounds(34, 0, 50, 48);
		pnlButtonLogin.add(lblNLogin);
		lblNLogin.setIcon(new ImageIcon(img_Login));

		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn ĐÓNG ứng dụng?", "Xác nhận",
						JOptionPane.YES_NO_OPTION) == 0) {
					FrmLogin.this.dispose();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.RED);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.WHITE);
			}
		});
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(580, 0, 20, 20);
		contentPane.add(lblX);

		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogo.setBounds(170, 27, 250, 109);
		contentPane.add(lblIconLogo);
		lblIconLogo.setIcon(new ImageIcon(img_Logo));
		lblLogMessage.setHorizontalAlignment(SwingConstants.CENTER);

		lblLogMessage.setForeground(new Color(220, 20, 60));
		lblLogMessage.setFont(new Font("Arial", Font.BOLD, 15));
		lblLogMessage.setBounds(150, 271, 300, 26);
		contentPane.add(lblLogMessage);
		
		JLabel lblMinimize = new JLabel("—");
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
		lblMinimize.setBounds(560, 0, 20, 20);
		contentPane.add(lblMinimize);
		
		
		
		JLabel lblQuenMatKhau = new JLabel("Quên mật khẩu ?");
		lblQuenMatKhau.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmForgotPassword frmForgotPassword = new FrmForgotPassword(khachHangFacade, xeFacade
						, nhanVienHanhChanhFacade, nhanVienKythuatFacade, hopDongFacade
						, phieuNhanXetFacade);
				frmForgotPassword.setVisible(true);
				FrmLogin.this.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				String t = "<html><u> Quên mật khẩu ?</u></html>";
				lblQuenMatKhau.setText(t);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblQuenMatKhau.setText("Quên mật khẩu ?");
				lblQuenMatKhau.setForeground(new Color(0, 0, 255));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				String t = "<html><u> Quên mật khẩu ?</u></html>";
				lblQuenMatKhau.setText(t);
				lblQuenMatKhau.setForeground(new Color(220, 20, 60));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				String t = "<html><u> Quên mật khẩu ?</u></html>";
				lblQuenMatKhau.setText(t);
			}
		});
		lblQuenMatKhau.setForeground(new Color(0, 0, 255));
		lblQuenMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuenMatKhau.setBounds(170, 367, 142, 22);
		contentPane.add(lblQuenMatKhau);	
		setLocationRelativeTo(null);

	}
}
