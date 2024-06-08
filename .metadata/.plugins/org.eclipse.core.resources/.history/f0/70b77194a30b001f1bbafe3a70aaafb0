package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Choice;
import com.toedter.calendar.JDateChooser;

import entity.KhachHang;
import entity.NhanVienHanhChanh;
import entity.NhanVienKyThuat;
import entity.TaiKhoan;
import facade.NhanVienHanhChanhFacade;
import facade.NhanVienKythuatFacade;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import java.awt.event.MouseAdapter;

public class PanelQuanLyNhanVien extends JPanel {
	private Image img_Add = new ImageIcon(PanelQuanLyNhanVien.class.getResource("../image/add.png")).getImage()
			.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
	private Image img_Delete = new ImageIcon(PanelQuanLyNhanVien.class.getResource("../image/delete.png")).getImage()
			.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
	private Image img_Edit = new ImageIcon(PanelQuanLyNhanVien.class.getResource("../image/edit.png")).getImage()
			.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
	private Image img_New = new ImageIcon(PanelQuanLyNhanVien.class.getResource("../image/new.png")).getImage()
			.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
	private Image img_Search = new ImageIcon(PanelQuanLyNhanVien.class.getResource("../image/search.png")).getImage()
			.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
	private Image img_RefreshLon = new ImageIcon(FrmLogin.class.getResource("../image/refresh.png")).getImage()
			.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);

	private JTextField txtHoTen;
	private JTextField txtSoDienThoai;
	private JTextField txtDiaChi;
	private JTextField txtMaNhanVien;
	private JTable tableNhanVienNV;
	DefaultTableModel model;
	private JTextField txtTimKiem;
	private JTextField txtChucVu;
	private JTextField txtBacTho;
	private JTextField txtKinhNghiem;
	private JTextField txtHocVan;
	private JTextField txtPhongBan;
	
	private NhanVienHanhChanhFacade nhanVienHanhChanhFacade;
	private NhanVienKythuatFacade nhanVienKyThuatFacade;
	private JComboBox<String> cbLoaiNV;
	private JLabel lblMess;

	/**
	 * Create the panel.
	 */
	public PanelQuanLyNhanVien(NhanVienHanhChanhFacade nhanVienHanhChanhFacade
			, NhanVienKythuatFacade nhanVienKythuatFacade) {
		this.nhanVienHanhChanhFacade = nhanVienHanhChanhFacade;
		this.nhanVienKyThuatFacade = nhanVienKythuatFacade;
		
		setForeground(new Color(255, 255, 0));
		setName("");
		setBounds(1, 0, 1087, 706);
		setLayout(null);
		setVisible(true);

		JLabel lblDiaChi = new JLabel("\u0110\u1ECBa ch\u1EC9:");
		lblDiaChi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDiaChi.setBounds(28, 144, 83, 22);
		add(lblDiaChi);

		JLabel lblHoTenNV = new JLabel("H\u1ECD v\u00E0 t\u00EAn:");
		lblHoTenNV.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHoTenNV.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblHoTenNV.setBounds(28, 78, 83, 22);
		add(lblHoTenNV);

		JLabel lblSoDienThoai = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i:");
		lblSoDienThoai.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSoDienThoai.setBounds(8, 111, 103, 22);
		add(lblSoDienThoai);

		txtHoTen = new JTextField();
		txtHoTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtHoTen.setColumns(10);
		txtHoTen.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtHoTen.setBounds(116, 80, 380, 24);
		add(txtHoTen);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtSoDienThoai.setBounds(116, 113, 380, 24);
		add(txtSoDienThoai);

		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtDiaChi.setBounds(116, 145, 380, 24);
		add(txtDiaChi);

		JLabel lblMaNhanVien = new JLabel("M\u00E3 nh\u00E2n vi\u00EAn:");
		lblMaNhanVien.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMaNhanVien.setBounds(0, 51, 111, 22);
		add(lblMaNhanVien);

		JLabel lblLoaiNhanVien = new JLabel("Lo\u1EA1i nh\u00E2n vi\u00EAn:");
		lblLoaiNhanVien.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLoaiNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblLoaiNhanVien.setBounds(8, 180, 112, 22);
		add(lblLoaiNhanVien);

		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setForeground(new Color(0, 0, 255));
		txtMaNhanVien.setEditable(false);
		txtMaNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtMaNhanVien.setColumns(10);
		txtMaNhanVien.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtMaNhanVien.setBounds(116, 49, 380, 24);
		add(txtMaNhanVien);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 371, 1086, 335);
		add(scrollPane);

		String[] headers = { "Mã nhân viên", "Họ và tên", "Địa chỉ", "Số điện thoại", "Loại nhân viên", "Chức vụ",
				"Bậc thợ", "Kinh nghiệm", "Phòng ban", "Học vấn" };
		model = new DefaultTableModel(headers, 0);
		tableNhanVienNV = new JTable(model);
		tableNhanVienNV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableNhanVienNV.getSelectedRow();
				String ma = (String) tableNhanVienNV.getValueAt(row, 0);
				try {
					NhanVienHanhChanh nvhc = nhanVienHanhChanhFacade.timNhanVienHanhChanhTheoMa(ma);
					if (nvhc != null) {
						txtMaNhanVien.setText(nvhc.getMaNV());
						txtHoTen.setText(nvhc.getTenNV());
						txtDiaChi.setText(nvhc.getDiaChiNV());
						txtSoDienThoai.setText(nvhc.getSoDienThoaiNV());
						txtChucVu.setText(nvhc.getChucVu());
						cbLoaiNV.setSelectedIndex(0);
						txtHocVan.setText(nvhc.getTrinhDoHocVan());
						txtPhongBan.setText(nvhc.getPhongBan());
					} else {
						NhanVienKyThuat nvkt = nhanVienKythuatFacade.timNhanVienKyThuatTheoMa(ma);
						if (nvkt != null) {
							txtMaNhanVien.setText(nvkt.getMaNV());
							txtHoTen.setText(nvkt.getTenNV());
							txtDiaChi.setText(nvkt.getDiaChiNV());
							txtSoDienThoai.setText(nvkt.getSoDienThoaiNV());
							txtChucVu.setText(nvkt.getChucVu());
							cbLoaiNV.setSelectedIndex(1);
							txtBacTho.setText(nvkt.getBacTho());
							txtKinhNghiem.setText(nvkt.getSoNamKN()+"");
						}
					}
					
					
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		});
		tableNhanVienNV.setBackground(new Color(176, 224, 230));
		scrollPane.setViewportView(tableNhanVienNV);

		JLabel lblDanhSachNV = new JLabel("DANH S\u00C1CH NH\u00C2N VI\u00CAN");
		lblDanhSachNV.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSachNV.setForeground(new Color(70, 130, 180));
		lblDanhSachNV.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDanhSachNV.setBounds(0, 296, 1085, 30);
		add(lblDanhSachNV);

		JPanel pnlChucNang = new JPanel();
		pnlChucNang.setBorder(new LineBorder(new Color(100, 149, 237), 2, true));
		pnlChucNang.setBounds(159, 249, 778, 38);
		add(pnlChucNang);
		pnlChucNang.setLayout(new BoxLayout(pnlChucNang, BoxLayout.X_AXIS));

		JButton btnThem = new JButton("Thêm nhân viên");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (valid()) {
					try {
						if (cbLoaiNV.getSelectedItem().equals("Nhân viên hành chánh")) {
							NhanVienHanhChanh nvhc = new NhanVienHanhChanh(txtMaNhanVien.getText().trim()
									, txtHoTen.getText().trim(), txtDiaChi.getText().trim()
									, txtSoDienThoai.getText().trim(), txtChucVu.getText().trim()
									, txtPhongBan.getText().trim()
									, txtHocVan.getText().trim());
							TaiKhoan tk;
							if (txtChucVu.getText().trim().equals("Quản lý")) {
								tk = new TaiKhoan("1111", "Quản lý");								
							} else {
								tk = new TaiKhoan("1111", "Nhân viên hành chánh");	
							}
							nvhc.setTaiKhoan(tk);
							if (nhanVienHanhChanhFacade.themNhanVienHanhChanh(nvhc)) {
								lblMess.setText("Thêm thành công");
								updateTable();
							} else {
								lblMess.setText("Trùng mã");
							}
							
						} else {
							NhanVienKyThuat nvkt = new NhanVienKyThuat(txtMaNhanVien.getText().trim()
									, txtHoTen.getText().trim(), txtDiaChi.getText().trim()
									, txtSoDienThoai.getText().trim(), txtChucVu.getText().trim()
									, txtBacTho.getText().trim()
									, Integer.parseInt(txtKinhNghiem.getText().trim()));
							TaiKhoan tk = new TaiKhoan("1111", "Nhân viên kỹ thuật");
							nvkt.setTaiKhoan(tk);
							if (nhanVienKythuatFacade.themNhanVienKyThuat(nvkt)) {
								lblMess.setText("Thêm thành công");
								updateTable();
							} else {
								lblMess.setText("Trùng mã");
							}
						}
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnThem.setIcon(new ImageIcon(img_Add));
		pnlChucNang.add(btnThem);

		JButton btnXoa = new JButton("Xoá nhân viên");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int hoiNhac = JOptionPane.showConfirmDialog((Component) e.getSource(),"Có chắn chắn xóa","Chú ý",JOptionPane.YES_NO_OPTION);
				if (hoiNhac == JOptionPane.YES_OPTION) {
					int row = tableNhanVienNV.getSelectedRow();
					String ma = (String) tableNhanVienNV.getValueAt(row, 0);
					if (cbLoaiNV.getSelectedItem().equals("Nhân viên hành chánh")) {
						try {
							if (nhanVienHanhChanhFacade.xoaNhanVienHanhChanh(ma)) {
								updateTable();
								lblMess.setText("Xóa thành công");
								clearAll();
							}
						} catch (RemoteException e1) {
							e1.printStackTrace();
						}
					} else {
						try {
							if (nhanVienKythuatFacade.xoaNhanVienKyThuat(ma)) {
								updateTable();
								lblMess.setText("Xóa thành công");
								clearAll();
							}
						} catch (RemoteException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnXoa.setIcon(new ImageIcon(img_Delete));
		pnlChucNang.add(btnXoa);

		JButton btnCapNhat = new JButton("Cập nhật nhân viên");
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (valid()) {
					try {
						if (cbLoaiNV.getSelectedItem().equals("Nhân viên hành chánh")) {
							NhanVienHanhChanh nvhc = new NhanVienHanhChanh(txtMaNhanVien.getText().trim()
									, txtHoTen.getText().trim(), txtDiaChi.getText().trim()
									, txtSoDienThoai.getText().trim(), txtChucVu.getText().trim()
									, txtPhongBan.getText().trim()
									, txtHocVan.getText().trim());
							if (nhanVienHanhChanhFacade.capNhatNhanVienHanhChanh(nvhc)) {
								lblMess.setText("Cập nhật thành công");
								nhanVienKythuatFacade.xoaNhanVienKyThuat(nvhc.getMaNV());
								updateTable();
							}
						} else {
							NhanVienKyThuat nvkt = new NhanVienKyThuat(txtMaNhanVien.getText().trim()
									, txtHoTen.getText().trim(), txtDiaChi.getText().trim()
									, txtSoDienThoai.getText().trim(), txtChucVu.getText().trim()
									, txtBacTho.getText().trim()
									, Integer.parseInt(txtKinhNghiem.getText().trim()));
							if (nhanVienKythuatFacade.capNhatNhanVienKyThuat(nvkt)) {
								lblMess.setText("Cập nhật thành công");
								nhanVienHanhChanhFacade.xoaNhanVienHanhChanh(nvkt.getMaNV());
								updateTable();
							}
						}
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCapNhat.setIcon(new ImageIcon(img_Edit));
		pnlChucNang.add(btnCapNhat);

		JButton btnTaoMoi = new JButton("Tạo mới");
		btnTaoMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearAll();
			}
		});
		pnlChucNang.add(btnTaoMoi);
		btnTaoMoi.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnTaoMoi.setIcon(new ImageIcon(img_New));

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 327, 1086, 45);
		add(panel);
		panel.setLayout(null);

		JButton btnTimKiem = new JButton("");
		btnTimKiem.setBounds(989, 5, 46, 36);
		btnTimKiem.setIcon(new ImageIcon(img_Search));
		panel.add(btnTimKiem);
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String keywords = txtTimKiem.getText().trim();
				xoaHetTable();
				try {
					NhanVienHanhChanh nvhc = nhanVienHanhChanhFacade.timNhanVienHanhChanhTheoMa(keywords);
					if (nvhc != null) {
						String[] row = {nvhc.getMaNV(),nvhc.getTenNV(),nvhc.getDiaChiNV()
								,nvhc.getSoDienThoaiNV(),"Nhân viên hành chánh", nvhc.getChucVu()
								, "", "", nvhc.getPhongBan(), nvhc.getTrinhDoHocVan()};
						model.addRow(row);
					} else {
						List<NhanVienHanhChanh> listNVHC = nhanVienHanhChanhFacade.timNhanVienHanhChanhTheoTextSearch(keywords);
						for (NhanVienHanhChanh nvhcTK : listNVHC) {
							String[] row = {nvhcTK.getMaNV(),nvhcTK.getTenNV(),nvhcTK.getDiaChiNV()
									,nvhcTK.getSoDienThoaiNV(),"Nhân viên hành chánh"
									, nvhcTK.getChucVu(), "", ""
									, nvhcTK.getPhongBan(), nvhcTK.getTrinhDoHocVan()};
							model.addRow(row);
						}
						NhanVienKyThuat nvkt = nhanVienKythuatFacade.timNhanVienKyThuatTheoMa(keywords);
						if (nvkt != null) {
							String[] row = {nvkt.getMaNV(),nvkt.getTenNV(),nvkt.getDiaChiNV()
									,nvkt.getSoDienThoaiNV(),"Nhân viên kỹ thuật", nvkt.getChucVu()
									, nvkt.getBacTho(), nvkt.getSoNamKN()+"", "", ""};
							model.addRow(row);
						} else {
							List<NhanVienKyThuat> listNVKT = nhanVienKythuatFacade.timNhanVienKyThuatTheoTextSearch(keywords);
							for (NhanVienKyThuat nvktTK : listNVKT) {
								String[] row = {nvktTK.getMaNV(),nvktTK.getTenNV(),nvktTK.getDiaChiNV()
										,nvktTK.getSoDienThoaiNV(),"Nhân viên kỹ thuật"
										, nvktTK.getChucVu(), nvktTK.getBacTho(), nvktTK.getSoNamKN()+""
										, "", ""};
								model.addRow(row);
							}
							if (listNVHC.isEmpty() && listNVKT.isEmpty()) {
								String[] row = {"","",""
										,"", ""
										, "", "", ""
										, "", ""};
								model.addRow(row);
							}
						}
						
					}
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 18));

		txtTimKiem = new JTextField();
		txtTimKiem.setForeground(new Color(128, 128, 128));
		txtTimKiem.setText("Tìm theo mã nhân viên, tên nhân viên, số điện thoại");
		txtTimKiem.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtTimKiem.getText().equals("Mã nhân viên, tên nhân viên, số điện thoại")) {
					txtTimKiem.setText("");
				} else {
					txtTimKiem.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtTimKiem.getText().equals("")) {
					txtTimKiem.setText("Mã nhân viên, tên nhân viên, số điện thoại");
				}
			}
		});
		txtTimKiem.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		txtTimKiem.setBounds(8, 8, 978, 30);
		panel.add(txtTimKiem);
		txtTimKiem.setColumns(10);

		JButton btnLamMoi = new JButton("");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearAll();
			}
		});
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLamMoi.setBounds(1036, 5, 41, 36);
		btnLamMoi.setIcon(new ImageIcon(img_RefreshLon));
		panel.add(btnLamMoi);

		JLabel lblTitle = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(165, 42, 42));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTitle.setBounds(0, 0, 1085, 41);
		add(lblTitle);

		JLabel lblChucVu = new JLabel("Chức vụ:");
		lblChucVu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblChucVu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblChucVu.setBounds(608, 49, 83, 22);
		add(lblChucVu);

		txtChucVu = new JTextField();
		txtChucVu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtChucVu.setColumns(10);
		txtChucVu.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtChucVu.setBounds(696, 51, 380, 24);
		add(txtChucVu);

		JLabel lblBatTho = new JLabel("Bậc thợ:");
		lblBatTho.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBatTho.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblBatTho.setBounds(588, 82, 103, 22);
		add(lblBatTho);

		txtBacTho = new JTextField();
		txtBacTho.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtBacTho.setColumns(10);
		txtBacTho.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtBacTho.setBounds(696, 84, 380, 24);
		add(txtBacTho);

		JLabel lblKinhNghiem = new JLabel("Kinh nghiệm:");
		lblKinhNghiem.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKinhNghiem.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblKinhNghiem.setBounds(588, 115, 103, 22);
		add(lblKinhNghiem);

		txtKinhNghiem = new JTextField();
		txtKinhNghiem.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtKinhNghiem.setColumns(10);
		txtKinhNghiem.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtKinhNghiem.setBounds(696, 116, 380, 24);
		add(txtKinhNghiem);

		JLabel lblHocVan = new JLabel("Học vấn:");
		lblHocVan.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHocVan.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblHocVan.setBounds(608, 181, 83, 22);
		add(lblHocVan);

		txtHocVan = new JTextField();
		txtHocVan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtHocVan.setColumns(10);
		txtHocVan.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtHocVan.setBounds(696, 182, 380, 24);
		add(txtHocVan);

		JLabel lblPhongBan = new JLabel("Phòng ban:");
		lblPhongBan.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhongBan.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPhongBan.setBounds(588, 148, 103, 22);
		add(lblPhongBan);

		txtPhongBan = new JTextField();
		txtPhongBan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtPhongBan.setColumns(10);
		txtPhongBan.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtPhongBan.setBounds(696, 150, 380, 24);
		add(txtPhongBan);
		
		cbLoaiNV = new JComboBox<String>();
		cbLoaiNV.addItem("Nhân viên hành chánh");
		cbLoaiNV.addItem("Nhân viên kỹ thuật");
		cbLoaiNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbLoaiNV.getSelectedItem().equals("Nhân viên hành chánh")) {
					clearNVKT();
					txtHocVan.setEditable(true);
					txtPhongBan.setEditable(true);
					txtKinhNghiem.setEditable(false);
					txtBacTho.setEditable(false);
				} else {
					clearNVHC();
					txtHocVan.setEditable(false);
					txtPhongBan.setEditable(false);
					txtKinhNghiem.setEditable(true);
					txtBacTho.setEditable(true);
				}
			}
		});
		cbLoaiNV.setForeground(new Color(0, 0, 0));
		cbLoaiNV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		cbLoaiNV.setBounds(126, 180, 204, 24);
		add(cbLoaiNV);
		cbLoaiNV.setSelectedIndex(0);
		
		updateTable();
		txtMaNhanVien.setText(setMaNVTuDong());
		
		lblMess = new JLabel("");
		lblMess.setForeground(Color.RED);
		lblMess.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblMess.setBounds(80, 213, 962, 23);
		add(lblMess);
	}
	
	public void xoaHetTable() {
		DefaultTableModel dm = (DefaultTableModel) tableNhanVienNV.getModel();
		dm.getDataVector().removeAllElements();
	}
	
	public void updateTable() {
		xoaHetTable();
		try {
			List<NhanVienHanhChanh> dsNVHC = nhanVienHanhChanhFacade.getDSNhanVienHanhChanh();
			for (NhanVienHanhChanh nvhc : dsNVHC) {
				String[] rowData = {nvhc.getMaNV(), nvhc.getTenNV(), nvhc.getDiaChiNV()
						,nvhc.getSoDienThoaiNV(),"Nhân viên hành chánh",nvhc.getChucVu(),""
						,"",nvhc.getPhongBan(),nvhc.getTrinhDoHocVan()};
				model.addRow(rowData);
			}
			
			List<NhanVienKyThuat> dsNVTHC = nhanVienKyThuatFacade.getDSNhanVienKyThuat();
			for (NhanVienKyThuat nvkt : dsNVTHC) {
				String[] rowData = {nvkt.getMaNV(), nvkt.getTenNV(), nvkt.getDiaChiNV()
						,nvkt.getSoDienThoaiNV(),"Nhân viên kỹ thuật",nvkt.getChucVu()
						,nvkt.getBacTho() ,nvkt.getSoNamKN()+"","",""};
				model.addRow(rowData);
			}
			
			tableNhanVienNV.setModel(model);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}
	public boolean valid() {
		if (txtHoTen.getText().trim().equals("")) {
			lblMess.setText("Họ tên không được bỏ trống");
			txtHoTen.requestFocus();
			return false;
		}
		if (txtSoDienThoai.getText().trim().equals("")) {
			lblMess.setText("Số điện thoại không được bỏ trống");
			txtSoDienThoai.requestFocus();
			return false;
		}
		if (txtDiaChi.getText().trim().equals("")) {
			lblMess.setText("Địa chỉ không được bỏ trống");
			txtDiaChi.requestFocus();
			return false;
		}
		if (txtChucVu.getText().trim().equals("")) {
			lblMess.setText("Chức vụ không được bỏ trống");
			txtChucVu.requestFocus();
			return false;
		}
		if (cbLoaiNV.getSelectedItem().equals("Nhân viên hành chánh")) {
			if (txtPhongBan.getText().trim().equals("")) {
				lblMess.setText("Phòng ban không được bỏ trống");
				txtPhongBan.requestFocus();
				return false;
			}
			if (txtHocVan.getText().trim().equals("")) {
				lblMess.setText("Học vấn không được bỏ trống");
				txtHocVan.requestFocus();
				return false;
			}
		}
		if (cbLoaiNV.getSelectedItem().equals("Nhân viên kỹ thuật")) {
			if (txtBacTho.getText().trim().equals("")) {
				lblMess.setText("Bậc thợ không được bỏ trống");
				txtBacTho.requestFocus();
				return false;
			}
			try {
				int soNamKN = Integer.parseInt(txtKinhNghiem.getText().trim());
				if (soNamKN < 0) {
					lblMess.setText("Số năm kinh nghiệm phải >= 0");
					txtKinhNghiem.requestFocus();
					return false;
				}
			} catch (Exception e) {
				lblMess.setText("Sai định dạng số năm kinh nghiệm");
				txtKinhNghiem.requestFocus();
				return false;
			}
		}
		return true;
	}
	public void clearNVHC() {
		txtHocVan.setText("");
		txtPhongBan.setText("");
	}
	public void clearNVKT() {
		txtKinhNghiem.setText("");
		txtBacTho.setText("");
	}
	public void clearAll() {
		txtMaNhanVien.setText(setMaNVTuDong());
		txtHoTen.setText("");
		txtDiaChi.setText("");
		txtSoDienThoai.setText("");
		cbLoaiNV.setSelectedIndex(0);
		txtChucVu.setText("");
		clearNVHC();
		lblMess.setText("");
		updateTable();
	}
	public String setMaNVTuDong() {
		String ma = "NV";
		int n = 0;
		try {
			n = nhanVienHanhChanhFacade.getDSNhanVienHanhChanh().size() 
					+ nhanVienKyThuatFacade.getDSNhanVienKyThuat().size() + 1;
			while (nhanVienHanhChanhFacade.timNhanVienHanhChanhTheoMa(ma) != null
					|| nhanVienKyThuatFacade.timNhanVienKyThuatTheoMa(ma) != null) {
				n++;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ma + n;
	}
}
