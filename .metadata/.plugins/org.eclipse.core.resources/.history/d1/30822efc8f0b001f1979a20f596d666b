package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import entity.Xe;
import facade.XeFacade;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelXe extends JPanel {

	private Image img_Add = new ImageIcon(FrmLogin.class.getResource("../image/add.png")).getImage()
			.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
	private Image img_Delete = new ImageIcon(FrmLogin.class.getResource("../image/delete.png")).getImage()
			.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
	private Image img_Edit = new ImageIcon(FrmLogin.class.getResource("../image/edit.png")).getImage()
			.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
	private Image img_New = new ImageIcon(FrmLogin.class.getResource("../image/new.png")).getImage()
			.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
	private Image img_SearchSP = new ImageIcon(FrmLogin.class.getResource("../image/search.png")).getImage()
			.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
	private Image img_RefreshLon = new ImageIcon(FrmLogin.class.getResource("../image/refresh.png")).getImage()
			.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);

	private JTextField txtMaXe;
	private JTextField txtTenXeMay;
	private JTextField txtMauXe;
	private JTextField txtHangXe;
	private JTextField txtLoaiXe;
	private JTextField txtGia;
	private JTextField txtNuocSX;
	private JTextField txtSoKhung;
	private JTextField txtSoPK;
	private JTextField txtSoLuong;
	private JTable tableXe;
	DefaultTableModel modelXe;
	private JTextField txtTimKiem;

	private XeFacade xeFacade;
	
	private Locale locale = new Locale("en", "EN");
	private String pattern = "###,###.##";
	private DecimalFormat dcf = (DecimalFormat) NumberFormat.getNumberInstance(locale);
	private JTextField txtSoSuon;
	private JLabel lblMess;
	/**
	 * Create the panel.
	 */
	public PanelXe(XeFacade xeFacade) {
		dcf.applyPattern(pattern);
		this.xeFacade = xeFacade;
		setBounds(1, 0, 1087, 706);
		setLayout(null);
		
		JLabel lblTitle = new JLabel("QUẢN LÝ THÔNG TIN XE MÁY");
		lblTitle.setForeground(new Color(165, 42, 42));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTitle.setBounds(0, 0, 1087, 38);
		add(lblTitle);

		txtMaXe = new JTextField();
		txtMaXe.setEditable(false);
		txtMaXe.setForeground(new Color(0, 0, 255));
		txtMaXe.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtMaXe.setBounds(125, 55, 380, 24);
		add(txtMaXe);
		txtMaXe.setColumns(10);

		JLabel lblMaXeMay = new JLabel("Mã xe:");
		lblMaXeMay.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaXeMay.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMaXeMay.setBounds(30, 55, 90, 22);
		add(lblMaXeMay);

		txtTenXeMay = new JTextField();
		txtTenXeMay.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtTenXeMay.setColumns(10);
		txtTenXeMay.setBounds(125, 90, 380, 24);
		add(txtTenXeMay);
		
		JLabel lblTenXeMay = new JLabel("Tên xe máy:");
		lblTenXeMay.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTenXeMay.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTenXeMay.setBounds(20, 90, 100, 22);
		add(lblTenXeMay);

		txtMauXe = new JTextField();
		txtMauXe.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtMauXe.setColumns(10);
		txtMauXe.setBounds(125, 193, 380, 24);
		add(txtMauXe);

		JLabel lblMauXe = new JLabel("Màu xe:");
		lblMauXe.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMauXe.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMauXe.setBounds(30, 193, 90, 22);
		add(lblMauXe);

		txtHangXe = new JTextField();
		txtHangXe.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtHangXe.setColumns(10);
		txtHangXe.setBounds(125, 123, 380, 24);
		add(txtHangXe);

		JLabel lblHangXe = new JLabel("Hãng xe:");
		lblHangXe.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHangXe.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblHangXe.setBounds(30, 123, 90, 22);
		add(lblHangXe);

		txtLoaiXe = new JTextField();
		txtLoaiXe.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtLoaiXe.setColumns(10);
		txtLoaiXe.setBounds(125, 158, 380, 24);
		add(txtLoaiXe);

		JLabel lblLoaiXe = new JLabel("Loại xe:");
		lblLoaiXe.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLoaiXe.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblLoaiXe.setBounds(30, 158, 90, 22);
		add(lblLoaiXe);

		txtGia = new JTextField();
		txtGia.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtGia.setColumns(10);
		txtGia.setBounds(697, 191, 380, 24);
		add(txtGia);

		JLabel lblGia = new JLabel("Giá:");
		lblGia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGia.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblGia.setBounds(602, 191, 90, 22);
		add(lblGia);

		txtNuocSX = new JTextField();
		txtNuocSX.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtNuocSX.setColumns(10);
		txtNuocSX.setBounds(698, 55, 380, 24);
		add(txtNuocSX);

		JLabel lblNuocSX = new JLabel("Nước sản xuất:");
		lblNuocSX.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNuocSX.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNuocSX.setBounds(575, 55, 118, 22);
		add(lblNuocSX);

		txtSoKhung = new JTextField();
		txtSoKhung.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSoKhung.setColumns(10);
		txtSoKhung.setBounds(697, 90, 380, 24);
		add(txtSoKhung);

		JLabel lblSoKhung = new JLabel("Số khung:");
		lblSoKhung.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoKhung.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSoKhung.setBounds(602, 90, 90, 22);
		add(lblSoKhung);

		JLabel lblSoPK = new JLabel("Số phân khối:");
		lblSoPK.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoPK.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSoPK.setBounds(584, 158, 109, 22);
		add(lblSoPK);

		txtSoPK = new JTextField();
		txtSoPK.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSoPK.setColumns(10);
		txtSoPK.setBounds(698, 158, 380, 24);
		add(txtSoPK);

		JLabel lblSoLuong = new JLabel("Số lượng tồn:");
		lblSoLuong.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSoLuong.setBounds(584, 226, 108, 22);
		add(lblSoLuong);

		txtSoLuong = new JTextField();
		txtSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(697, 226, 380, 24);
		add(txtSoLuong);

		JScrollPane scrollPaneXe = new JScrollPane();
		scrollPaneXe.setBounds(0, 385, 1087, 321);
		add(scrollPaneXe);

		String[] headers = { "Mã xe", "Tên xe", "Hãng xe","Loại xe", "Màu xe", "Nước sản xuất","Số khung","Số sườn","Số phân khối","Giá","Số lượng"};
		modelXe = new DefaultTableModel(headers, 0);
		tableXe = new JTable(modelXe);
		tableXe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableXe.getSelectedRow();
				String maXe = (String) tableXe.getValueAt(row, 0);
				try {
					Xe xe = xeFacade.timXeTheoMa(maXe);
					if (xe != null) {
						txtMaXe.setText(xe.getMaXe());
						txtTenXeMay.setText(xe.getTenXe());
						txtHangXe.setText(xe.getHangXe());
						txtLoaiXe.setText(xe.getLoaiXe());
						txtMauXe.setText(xe.getMauXe());
						txtNuocSX.setText(xe.getNuocSX());
						txtSoKhung.setText(xe.getSoKhung());
						txtSoSuon.setText(xe.getSoSuon());
						txtSoPK.setText(xe.getSoPK()+"");
						txtGia.setText(dcf.format(xe.getDonGia()));
						txtSoLuong.setText(xe.getSoLuongTon()+"");
					}
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		tableXe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPaneXe.setViewportView(tableXe);

		JPanel pnMenuChucNang = new JPanel();
		pnMenuChucNang.setLayout(null);
		pnMenuChucNang.setBorder(new LineBorder(new Color(30, 144, 255), 2));
		pnMenuChucNang.setBounds(94, 271, 868, 38);
		add(pnMenuChucNang);

		JButton btnThem = new JButton("Thêm xe");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (valid()) {
					try {
						Xe xe = new Xe(txtMaXe.getText().trim(), txtNuocSX.getText().trim()
								, txtLoaiXe.getText(), Integer.parseInt(txtSoPK.getText().trim())
								, txtSoKhung.getText().trim()
								, txtSoSuon.getText(), txtMauXe.getText().trim(), txtTenXeMay.getText().trim()
								, Double.parseDouble(dcf.parse(txtGia.getText().trim()).toString())
								, txtHangXe.getText().trim(), Integer.parseInt(txtSoLuong.getText().trim()));
						if (xeFacade.themXe(xe)) {
							lblMess.setText("Thêm thành công");
							updateTableData();
						} else {
							lblMess.setText("Trùng mã");
						}
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (ParseException e1) {
						e1.printStackTrace();
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
					
				}
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnThem.setBounds(3, 3, 227, 33);
		btnThem.setIcon(new ImageIcon(img_Add));
		pnMenuChucNang.add(btnThem);

		JButton btnXoa = new JButton("Xoá xe");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int hoiNhac = JOptionPane.showConfirmDialog((Component) e.getSource(),"Có chắn chắn xóa","Chú ý",JOptionPane.YES_NO_OPTION);
				if (hoiNhac == JOptionPane.YES_OPTION) {
					int row = tableXe.getSelectedRow();
					String ma = (String) tableXe.getValueAt(row, 0);
					try {
						if (xeFacade.xoaXe(ma)) {
							updateTableData();
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
		btnXoa.setBounds(230, 3, 237, 33);
		btnXoa.setIcon(new ImageIcon(img_Delete));
		pnMenuChucNang.add(btnXoa);

		JButton btnCapNhat = new JButton("Cập nhật xe");
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (valid()) {
					try {
						Xe xe = new Xe(txtMaXe.getText().trim(), txtNuocSX.getText().trim()
								, txtLoaiXe.getText(), Integer.parseInt(txtSoPK.getText().trim())
								, txtSoKhung.getText().trim()
								, txtSoSuon.getText(), txtMauXe.getText().trim(), txtTenXeMay.getText().trim()
								, Double.parseDouble(dcf.parse(txtGia.getText().trim()).toString())
								, txtHangXe.getText().trim(), Integer.parseInt(txtSoLuong.getText().trim()));
						if (xeFacade.capNhatXe(xe)) {
							lblMess.setText("Cập nhật thành công");
							updateTableData();
						}
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (ParseException e1) {
						e1.printStackTrace();
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
					
				}
			}
		});
		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCapNhat.setBounds(467, 3, 262, 33);
		btnCapNhat.setIcon(new ImageIcon(img_Edit));
		pnMenuChucNang.add(btnCapNhat);

		JButton btnTaoMoi = new JButton("Tạo mới");
		btnTaoMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnTaoMoi.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnTaoMoi.setBounds(729, 3, 136, 33);
		btnTaoMoi.setIcon(new ImageIcon(img_New));
		pnMenuChucNang.add(btnTaoMoi);

		JLabel lblDSXe = new JLabel("DANH SÁCH XE");
		lblDSXe.setForeground(new Color(70, 130, 180));
		lblDSXe.setHorizontalAlignment(SwingConstants.CENTER);
		lblDSXe.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDSXe.setBounds(0, 309, 1087, 36);
		add(lblDSXe);

		JPanel pnTimKiem = new JPanel();
		pnTimKiem.setLayout(null);
		pnTimKiem.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnTimKiem.setBounds(0, 345, 1087, 43);
		add(pnTimKiem);

		JButton btnTimKiem = new JButton("");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String keywords = txtTimKiem.getText().trim();
				try {
					Xe xeTK = xeFacade.timXeTheoMa(keywords);
					xoaHetTable();
					if (xeTK != null) {
						String[] rowData = {xeTK.getMaXe(),xeTK.getTenXe()
								,xeTK.getHangXe(),xeTK.getLoaiXe(),xeTK.getMauXe()
								,xeTK.getNuocSX(),xeTK.getSoKhung(),xeTK.getSoSuon()
								,xeTK.getSoPK()+"",dcf.format(xeTK.getDonGia())
								,xeTK.getSoLuongTon()+""};
						modelXe.addRow(rowData);
					} else {
						List<Xe> list = xeFacade.timXeTheoTextSearch(keywords);
						if (list.isEmpty()) {
							String[] rowData = {"","","","","","","","","","",""};
							modelXe.addRow(rowData);
						} else {
							for (Xe s : list) {
								String[] rowData = {s.getMaXe(),s.getTenXe(),s.getHangXe(),s.getLoaiXe(),s.getMauXe(),s.getNuocSX(),s.getSoKhung(),s.getSoSuon(),s.getSoPK()+"",dcf.format(s.getDonGia()),s.getSoLuongTon()+""};
								modelXe.addRow(rowData);
							}
						}
					}
					tableXe.setModel(modelXe);
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnTimKiem.setBounds(988, 2, 45, 36);
		btnTimKiem.setIcon(new ImageIcon(img_SearchSP));
		pnTimKiem.add(btnTimKiem);

		txtTimKiem = new JTextField();
		txtTimKiem.setForeground(new Color(128, 128, 128));
		txtTimKiem.setText("Tìm theo mã xe, tên xe, hãng");
		txtTimKiem.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtTimKiem.getText().equals("Tìm theo mã xe, tên xe, hãng")) {
					txtTimKiem.setText("");
				} else {
					txtTimKiem.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtTimKiem.getText().equals("")) {
					txtTimKiem.setText("Mã xe, tên xe, hãng");
				}
			}
		});
		txtTimKiem.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(8, 4, 976, 30);
		pnTimKiem.add(txtTimKiem);

		JButton btnLamMoi = new JButton("");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLamMoi.setBounds(1036, 2, 41, 36);
		pnTimKiem.add(btnLamMoi);
		btnLamMoi.setIcon(new ImageIcon(img_RefreshLon));
		
		JLabel lblSoSuon = new JLabel("Số sườn:");
		lblSoSuon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoSuon.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSoSuon.setBounds(574, 123, 118, 22);
		add(lblSoSuon);
		
		txtSoSuon = new JTextField();
		txtSoSuon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSoSuon.setColumns(10);
		txtSoSuon.setBounds(697, 123, 380, 24);
		add(txtSoSuon);
		
		lblMess = new JLabel("");
		lblMess.setForeground(Color.RED);
		lblMess.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblMess.setBounds(50, 228, 524, 27);
		add(lblMess);
		setVisible(true);
		updateTableData();
		txtMaXe.setText(setMaXeTuDong());
	}
	
	public boolean valid() {
		if (txtTenXeMay.getText().trim().equals("")) {
			lblMess.setText("Tên xe không được trống");
			txtTenXeMay.requestFocus();
			return false;
		}
		if (txtHangXe.getText().trim().equals("")) {
			lblMess.setText("Hãng xe không được trống");
			txtHangXe.requestFocus();
			return false;
		}
		if (txtLoaiXe.getText().trim().equals("")) {
			lblMess.setText("Loại xe không được trống");
			txtLoaiXe.requestFocus();
			return false;
		}
		if (txtMauXe.getText().trim().equals("")) {
			lblMess.setText("Màu xe không được trống");
			txtMauXe.requestFocus();
			return false;
		}
		if (txtNuocSX.getText().trim().equals("")) {
			lblMess.setText("Nước sản xuất không được trống");
			txtNuocSX.requestFocus();
			return false;
		}
		if (txtSoKhung.getText().trim().equals("")) {
			lblMess.setText("Số khung không được trống");
			txtSoKhung.requestFocus();
			return false;
		}
		if (txtSoSuon.getText().trim().equals("")) {
			lblMess.setText("Số sườn không được trống");
			txtSoSuon.requestFocus();
			return false;
		}
		try {
			int soPK = Integer.parseInt(txtSoPK.getText().trim());
			if (soPK <= 0) {
				lblMess.setText("Số phân khối phải > 0");
				txtSoPK.requestFocus();
				return false;
			}
		} catch (Exception e) {
			lblMess.setText("Sai định dạng số phân khối");
			txtSoPK.requestFocus();
			return false;
		}
		try {
			double donGia = Double.parseDouble(dcf.parse(txtGia.getText().trim()).toString());
			if (donGia < 0) {
				lblMess.setText("Đơn giá phải >= 0");
				txtGia.requestFocus();
				return false;
			}
		} catch (Exception e) {
			lblMess.setText("Sai định dạng đơn giá");
			txtGia.requestFocus();
			return false;
		}
		try {
			int soLuong = Integer.parseInt(txtSoLuong.getText().trim());
			if (soLuong <= 0) {
				lblMess.setText("Số lượng tồn phải > 0");
				txtSoLuong.requestFocus();
				return false;
			}
		} catch (Exception e) {
			lblMess.setText("Sai định dạng số lượng tồn");
			txtSoLuong.requestFocus();
			return false;
		}
		return true;
	}
	
	public void updateTableData() {
		xoaHetTable();
		try {
			List<Xe> list = xeFacade.getDSXe();
			if (list.isEmpty()) {
				String[] rowData = {"","","","","","","","","","",""};
				modelXe.addRow(rowData);
			}
			for (Xe s : list) {
				String[] rowData = {s.getMaXe(),s.getTenXe(),s.getHangXe(),s.getLoaiXe(),s.getMauXe(),s.getNuocSX(),s.getSoKhung(),s.getSoSuon(),s.getSoPK()+"",dcf.format(s.getDonGia()),s.getSoLuongTon()+""};
				modelXe.addRow(rowData);
			}
			tableXe.setModel(modelXe);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	public void xoaHetTable() {
		DefaultTableModel dm = (DefaultTableModel) tableXe.getModel();
		dm.getDataVector().removeAllElements();
	}
	public void clear() {
		txtMaXe.setText(setMaXeTuDong());
		txtTenXeMay.setText("");
		txtHangXe.setText("");
		txtLoaiXe.setText("");
		txtMauXe.setText("");
		txtNuocSX.setText("");
		txtSoKhung.setText("");
		txtSoSuon.setText("");
		txtSoPK.setText("");
		txtGia.setText("");
		txtSoLuong.setText("");
		lblMess.setText("");
		updateTableData();
	}
	public String setMaXeTuDong() {
		String ma = "X";
		int n = 0;
		try {
			n = xeFacade.getDSXe().size() + 1;
			while (xeFacade.timXeTheoMa(ma+n) != null) {
				n++;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ma + n;
	}
}
