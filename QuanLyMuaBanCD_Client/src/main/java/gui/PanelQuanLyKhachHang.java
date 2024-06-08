package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import entity.KhachHang;
import facade.KhachHangFacade;

public class PanelQuanLyKhachHang extends JPanel {
	private Image img_Add = new ImageIcon(FrmLogin.class.getResource("../image/add.png")).getImage()
			.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
	private Image img_Delete = new ImageIcon(FrmLogin.class.getResource("../image/delete.png")).getImage()
			.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
	private Image img_Edit = new ImageIcon(FrmLogin.class.getResource("../image/edit.png")).getImage()
			.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
	private Image img_New = new ImageIcon(FrmLogin.class.getResource("../image/new.png")).getImage()
			.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
	private Image img_Search = new ImageIcon(FrmLogin.class.getResource("../image/search.png")).getImage()
			.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
	private Image img_RefreshLon = new ImageIcon(FrmLogin.class.getResource("../image/refresh.png")).getImage()
			.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);

	private JTextField txtHoTen;
	private JTextField txtSoDienThoai;
	private JTextField txtDiaChi;
	private JTextField txtMaKhachHang;
	private JTable table;
	DefaultTableModel model;
	private JTextField txtTimKiem;
	
	private KhachHangFacade khachHangFacade;
	private JLabel lblMess;

	/**
	 * Create the panel.
	 */
	public PanelQuanLyKhachHang(KhachHangFacade khachHangFacade) {
		this.khachHangFacade = khachHangFacade;
		
		setForeground(new Color(255, 255, 0));
		setName("");
		setBounds(1, 0, 1087, 706);
		setLayout(null);

		JLabel lblDiaChi = new JLabel("\u0110\u1ECBa ch\u1EC9:");
		lblDiaChi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDiaChi.setBounds(622, 101, 83, 22);
		add(lblDiaChi);

		JLabel lblHoTenKH = new JLabel("H\u1ECD v\u00E0 t\u00EAn:");
		lblHoTenKH.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHoTenKH.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblHoTenKH.setBounds(34, 99, 83, 22);
		add(lblHoTenKH);

		JLabel lblSoDienThoai = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i:");
		lblSoDienThoai.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSoDienThoai.setBounds(601, 64, 103, 22);
		add(lblSoDienThoai);

		txtHoTen = new JTextField();
		txtHoTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtHoTen.setColumns(10);
		txtHoTen.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtHoTen.setBounds(120, 101, 370, 24);
		add(txtHoTen);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtSoDienThoai.setBounds(707, 64, 370, 24);
		add(txtSoDienThoai);

		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtDiaChi.setBounds(707, 99, 370, 24);
		add(txtDiaChi);

		JLabel lblMaKhachHang = new JLabel("Mã khách hàng:");
		lblMaKhachHang.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMaKhachHang.setBounds(0, 64, 117, 22);
		add(lblMaKhachHang);

		txtMaKhachHang = new JTextField();
		txtMaKhachHang.setEditable(false);
		txtMaKhachHang.setForeground(new Color(0, 0, 255));
		txtMaKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtMaKhachHang.setColumns(10);
		txtMaKhachHang.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtMaKhachHang.setBounds(121, 66, 370, 24);
		add(txtMaKhachHang);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(-1, 292, 1087, 414);
		add(scrollPane);

		String[] headers = { "Mã khách hàng", "Họ và tên", "Địa chỉ", "Số điện thoại"};
		model = new DefaultTableModel(headers, 0);
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				String ma = (String) table.getValueAt(row, 0);
				try {
					KhachHang kh = khachHangFacade.timKhachHangTheoMa(ma);
					if (kh != null) {
						txtMaKhachHang.setText(ma);
						txtHoTen.setText(kh.getTenKH());
						txtDiaChi.setText(kh.getDiaChiKH());
						txtSoDienThoai.setText(kh.getSoDienThoaiKH());
					}
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		});
		table.setBackground(new Color(176, 224, 230));
		scrollPane.setViewportView(table);

		JLabel lblDanhSachKH = new JLabel("DANH SÁCH KHÁCH HÀNG");
		lblDanhSachKH.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSachKH.setForeground(new Color(70, 130, 180));
		lblDanhSachKH.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblDanhSachKH.setBounds(0, 213, 1086, 38);
		add(lblDanhSachKH);

		JPanel pnMenuChucNang = new JPanel();
		pnMenuChucNang.setLayout(null);
		pnMenuChucNang.setBorder(new LineBorder(new Color(30, 144, 255), 2));
		pnMenuChucNang.setBounds(108, 170, 871, 38);
		add(pnMenuChucNang);

		JButton btnThem = new JButton("Thêm khách hàng");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (valid()) {
					try {
						KhachHang kh = new KhachHang(txtMaKhachHang.getText().trim(), txtHoTen.getText().trim(), txtDiaChi.getText().trim(), txtSoDienThoai.getText().trim());
						if (khachHangFacade.themKhachHang(kh)) {
							lblMess.setText("Thêm thành công");
							updateTable();
						} else {
							lblMess.setText("Trùng mã");
						}
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnThem.setBounds(3, 3, 243, 33);
		btnThem.setIcon(new ImageIcon(img_Add));
		pnMenuChucNang.add(btnThem);

		JButton btnXoa = new JButton("Xoá khách hàng");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int hoiNhac = JOptionPane.showConfirmDialog((Component) e.getSource(),"Có chắn chắn xóa","Chú ý",JOptionPane.YES_NO_OPTION);
				if (hoiNhac == JOptionPane.YES_OPTION) {
					int row = table.getSelectedRow();
					String ma = (String) table.getValueAt(row, 0);
					try {
						if (khachHangFacade.xoaKhachHang(ma)) {
							updateTable();
							lblMess.setText("Xóa thành công");
							clear();
						}
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnXoa.setBounds(246, 3, 222, 33);
		btnXoa.setIcon(new ImageIcon(img_Delete));
		pnMenuChucNang.add(btnXoa);

		JButton btnCapNhat = new JButton("Cập nhật khách hàng");
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (valid()) {
					try {
						KhachHang kh = new KhachHang(txtMaKhachHang.getText().trim(), txtHoTen.getText().trim(), txtDiaChi.getText().trim(), txtSoDienThoai.getText().trim());
						if (khachHangFacade.capNhatKhachHang(kh)) {
							lblMess.setText("Cập nhật thành công");
							updateTable();
						} 
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCapNhat.setBounds(468, 3, 264, 33);
		btnCapNhat.setIcon(new ImageIcon(img_Edit));
		pnMenuChucNang.add(btnCapNhat);

		JButton btnTaoMoi = new JButton("Tạo mới");
		btnTaoMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnTaoMoi.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnTaoMoi.setBounds(732, 3, 136, 33);
		btnTaoMoi.setIcon(new ImageIcon(img_New));
		pnMenuChucNang.add(btnTaoMoi);

		JPanel pnTimKiem = new JPanel();
		pnTimKiem.setLayout(null);
		pnTimKiem.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnTimKiem.setBounds(0, 250, 1086, 43);
		add(pnTimKiem);

		JButton btnTimKiem = new JButton("");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String keywords = txtTimKiem.getText().trim();
				try {
					KhachHang kh = khachHangFacade.timKhachHangTheoMa(keywords);
					xoaHetTable();
					if (kh != null) {
						String[] rowData = {kh.getMaKH(),kh.getTenKH(),kh.getDiaChiKH(),kh.getSoDienThoaiKH()};
						model.addRow(rowData);
					} else {
						List<KhachHang> list = khachHangFacade.timKhachHangTheoTextSearch(keywords);
						if (list.isEmpty()) {
							String[] rowData = {"","","",""};
							model.addRow(rowData);
						} else {
							for (KhachHang khTK: list) {
								String[] rowData = {khTK.getMaKH(),khTK.getTenKH()
										,khTK.getDiaChiKH(),khTK.getSoDienThoaiKH()};
								model.addRow(rowData);
							}
						}
					}
					table.setModel(model);
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnTimKiem.setBounds(989, 3, 45, 36);
		btnTimKiem.setIcon(new ImageIcon(img_Search));
		pnTimKiem.add(btnTimKiem);

		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(8, 6, 978, 30);
		pnTimKiem.add(txtTimKiem);

		JButton btnLamMoi = new JButton("");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLamMoi.setBounds(1035, 3, 41, 36);
		btnLamMoi.setIcon(new ImageIcon(img_RefreshLon));
		pnTimKiem.add(btnLamMoi);
		
		JLabel lblTitle = new JLabel("QUẢN LÝ KHÁCH HÀNG");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(165, 42, 42));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTitle.setBounds(0, 11, 1086, 38);
		add(lblTitle);
		
		lblMess = new JLabel("");
		lblMess.setForeground(Color.RED);
		lblMess.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblMess.setBounds(62, 134, 803, 23);
		add(lblMess);
		setVisible(true);
		updateTable();
		txtMaKhachHang.setText(setMaKHTuDong());
	}
	public void xoaHetTable() {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.getDataVector().removeAllElements();
	}
	public void updateTable() {
		xoaHetTable();
		
		try {
			List<KhachHang> dsKH = khachHangFacade.getDSKhachHang();
			for (KhachHang khachHang : dsKH) {
				String[] rowData = {khachHang.getMaKH(), khachHang.getTenKH(),khachHang.getDiaChiKH()
						,khachHang.getSoDienThoaiKH()};
				model.addRow(rowData);
			}
			table.setModel(model);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	public boolean valid() {
		if (txtHoTen.getText().trim().equals("")) {
			lblMess.setText("Họ tên không được rỗng");
			txtHoTen.requestFocus();
			return false;
		} 
		if (txtDiaChi.getText().trim().equals("")) {
			lblMess.setText("Địa chỉ không được rỗng");
			txtDiaChi.requestFocus();
			return false;
		} 
		if (txtSoDienThoai.getText().trim().equals("")) {
			lblMess.setText("Số điện thoại không được rỗng");
			txtSoDienThoai.requestFocus();
			return false;
		} 
		return true;
	}
	public String setMaKHTuDong() {
		String ma = "KH";
		int n = 0;
		try {
			n = khachHangFacade.getDSKhachHang().size() + 1;
			while (khachHangFacade.timKhachHangTheoMa(ma+n) != null) {
				n++;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ma + n;
	}
	public void clear() {
		txtMaKhachHang.setText(setMaKHTuDong());
		txtHoTen.setText("");
		txtDiaChi.setText("");
		txtSoDienThoai.setText("");
		lblMess.setText("");
		updateTable();
	}
}
