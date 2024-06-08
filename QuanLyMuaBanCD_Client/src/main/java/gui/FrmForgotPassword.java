package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

import javax.swing.JButton;
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
import entity.TaiKhoan;
import facade.HopDongFacade;
import facade.KhachHangFacade;
import facade.NhanVienHanhChanhFacade;
import facade.NhanVienKythuatFacade;
import facade.PhieuNhanXetFacade;
import facade.XeFacade;

public class FrmForgotPassword extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaNhanVien;
	private JPasswordField txtMatKhauMoi;
	private JPasswordField txtXacNhanMK;
	private JPasswordField txtSoDienThoai;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FrmForgotPassword frame = new FrmForgotPassword(khachHangFacade, xeFacade
//							, nhanVienHanhChanhFacade, nhanVienKythuatFacade, hopDongFacade
//							, phieuNhanXetFacade);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the frame.
	 */
	public FrmForgotPassword(KhachHangFacade khachHangFacade, XeFacade xeFacade
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
		
		JLabel lblMess = new JLabel("");
		lblMess.setForeground(Color.RED);
		lblMess.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblMess.setBounds(157, 280, 300, 31);
		contentPane.add(lblMess);
		
		JLabel lblExit = new JLabel("X");		
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn ĐÓNG ứng dụng?", "Xác nhận",
						JOptionPane.YES_NO_OPTION) == 0) {
					FrmForgotPassword.this.dispose();
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
		lblExit.setForeground(Color.WHITE);
		lblExit.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblExit.setBounds(580, 0, 20, 20);
		contentPane.add(lblExit);
		
		JLabel lblMaNhanVien = new JLabel("Mã nhân viên:");
		lblMaNhanVien.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaNhanVien.setBounds(24, 120, 180, 29);
		contentPane.add(lblMaNhanVien);
		
		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtMaNhanVien.setColumns(10);
		txtMaNhanVien.setBounds(212, 120, 315, 30);
		contentPane.add(txtMaNhanVien);
		
		JLabel lblMatKhauMoi = new JLabel("Mật khẩu mới:");
		lblMatKhauMoi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMatKhauMoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMatKhauMoi.setBounds(24, 199, 180, 29);
		contentPane.add(lblMatKhauMoi);
		
		txtMatKhauMoi = new JPasswordField();
		txtMatKhauMoi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtMatKhauMoi.setBounds(212, 200, 315, 30);
		contentPane.add(txtMatKhauMoi);
		
		JLabel lblXacNhanMK = new JLabel("Xác nhận mật khẩu:");
		lblXacNhanMK.setHorizontalAlignment(SwingConstants.RIGHT);
		lblXacNhanMK.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblXacNhanMK.setBounds(24, 240, 180, 29);
		contentPane.add(lblXacNhanMK);
		
		txtXacNhanMK = new JPasswordField();
		txtXacNhanMK.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtXacNhanMK.setBounds(211, 240, 315, 30);
		contentPane.add(txtXacNhanMK);
		
		JButton btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maNV = txtMaNhanVien.getText().trim();
				String soDienThoai = txtSoDienThoai.getText().trim();
				String matKhauMoi = txtMatKhauMoi.getText().trim();
				String xacNhanMK = txtXacNhanMK.getText().trim();
				
				if (maNV.equals("") || soDienThoai.equals("") || 
						matKhauMoi.equals("") || xacNhanMK.equals("")) {
					lblMess.setText("Phải nhập đầy đủ tất cả thông tin");
				} else {
					if (!matKhauMoi.equals(xacNhanMK)) {
						lblMess.setText("Xác nhận mật khẩu không giống với mật khẩu mới");
					} else {
						NhanVienHanhChanh nvhc;
						NhanVienKyThuat nvkt;
						try {
							nvhc = nhanVienHanhChanhFacade.timNhanVienHanhChanhTheoMa(maNV);
							if (nvhc != null) {
								if (nvhc.getSoDienThoaiNV().equals(soDienThoai)) {
									TaiKhoan taiKhoanMoi = nvhc.getTaiKhoan();
									taiKhoanMoi.setMatKhau(matKhauMoi);
									nvhc.setTaiKhoan(taiKhoanMoi);
									nhanVienHanhChanhFacade.capNhatNhanVienHanhChanh(nvhc);
									lblMess.setText("Đổi mật khẩu thành công");
								} else {
									lblMess.setText("Sai số điện thoại xác nhận");
									txtSoDienThoai.requestFocus();
								}
							} else {
								nvkt = nhanVienKythuatFacade.timNhanVienKyThuatTheoMa(maNV);
								if (nvkt != null) {
									if (nvkt.getSoDienThoaiNV().equals(soDienThoai)) {
										TaiKhoan taiKhoanMoi = nvkt.getTaiKhoan();
										taiKhoanMoi.setMatKhau(matKhauMoi);
										nvkt.setTaiKhoan(taiKhoanMoi);
										nhanVienHanhChanhFacade.capNhatNhanVienHanhChanh(nvhc);
										lblMess.setText("Đổi mật khẩu thành công");
									} else {
										lblMess.setText("Sai số điện thoại xác nhận");
										txtSoDienThoai.requestFocus();
									}
								} else {
									lblMess.setText("Không tìm thấy mã nhân viên");
									txtMaNhanVien.requestFocus();
								}
							}
						} catch (RemoteException e1) {
							e1.printStackTrace();
						}
					}
				}
				
				
			}
		});
		btnXacNhan.setFont(new Font("Dialog", Font.PLAIN, 24));
		btnXacNhan.setBounds(135, 323, 148, 30);
		contentPane.add(btnXacNhan);
		
		JButton btnQuayLai = new JButton("Quay lại");
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmLogin frmLogin = new FrmLogin(khachHangFacade, xeFacade
						, nhanVienHanhChanhFacade, nhanVienKythuatFacade, hopDongFacade
						, phieuNhanXetFacade);
				frmLogin.setVisible(true);
				FrmForgotPassword.this.dispose();
			}
		});
		btnQuayLai.setFont(new Font("Dialog", Font.PLAIN, 24));
		btnQuayLai.setBounds(322, 323, 148, 30);
		contentPane.add(btnQuayLai);
		
		JLabel lblQuenMatKhau = new JLabel("QUÊN MẬT KHẨU");
		lblQuenMatKhau.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuenMatKhau.setForeground(new Color(127, 255, 212));
		lblQuenMatKhau.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblQuenMatKhau.setBounds(0, 44, 600, 49);
		contentPane.add(lblQuenMatKhau);
		
		JLabel lblSoDienThoai = new JLabel("Số điện thoại:");
		lblSoDienThoai.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoDienThoai.setBounds(24, 160, 180, 29);
		contentPane.add(lblSoDienThoai);
		
		txtSoDienThoai = new JPasswordField();
		txtSoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSoDienThoai.setBounds(212, 160, 315, 30);
		contentPane.add(txtSoDienThoai);
		
		
	}
}
