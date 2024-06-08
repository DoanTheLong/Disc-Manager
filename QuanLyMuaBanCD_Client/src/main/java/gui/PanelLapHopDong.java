package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import entity.ChiTietHopDong;
import entity.HopDong;
import entity.KhachHang;
import entity.NhanVienHanhChanh;
import entity.NhanVienKyThuat;
import entity.PhieuNhanXet;
import entity.TaiKhoan;
import entity.Xe;
import facade.HopDongFacade;
import facade.KhachHangFacade;
import facade.NhanVienHanhChanhFacade;
import facade.NhanVienKythuatFacade;
import facade.PhieuNhanXetFacade;
import facade.XeFacade;

import javax.swing.border.TitledBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class PanelLapHopDong extends JPanel {

	private Image img_SearchLon = new ImageIcon(FrmLogin.class.getResource("../image/search.png")).getImage()
			.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
	private Image img_SearchNho = new ImageIcon(FrmLogin.class.getResource("../image/search.png")).getImage()
			.getScaledInstance(22, 22, java.awt.Image.SCALE_SMOOTH);
	private Image img_RefreshNho = new ImageIcon(FrmLogin.class.getResource("../image/refresh.png")).getImage()
			.getScaledInstance(22, 22, java.awt.Image.SCALE_SMOOTH);
	private Image img_RefreshLon = new ImageIcon(FrmLogin.class.getResource("../image/refresh.png")).getImage()
			.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
	private Image img_Add = new ImageIcon(PanelQuanLyNhanVien.class.getResource("../image/add.png")).getImage()
			.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
	private Image img_Delete = new ImageIcon(PanelQuanLyNhanVien.class.getResource("../image/delete.png")).getImage()
			.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
	private Image img_ThemKH = new ImageIcon(FrmLogin.class.getResource("../image/plus.png")).getImage()
			.getScaledInstance(22, 22, java.awt.Image.SCALE_SMOOTH);
	private Image img_Pay = new ImageIcon(PanelQuanLyNhanVien.class.getResource("../image/pay.png")).getImage()
			.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
	
	
	private JTextField txtMaKhachHang;
	private JTextField txtHoTenKhachHang;

	private JTable tableCTHD;
	DefaultTableModel modelChiTietHD;
	DefaultTableModel modelDanhSachSP;
	private JTable tbDanhSachXe;
	private JTextField txtSoLuong;
	private JTextField txtMaHoaDon;
	private JTextField txtTongCong;
	private JTextField txtTimSP;
	private JTextField txtMaNV;
	private JTextField txtTimKH;

	private JTable tableDSKH;
	DefaultTableModel modelDSKH;
	DefaultTableModel modelDSNV;
	private JTextField txtNgayLapHD;
	private JTextField txtHanHopDong;
	private JTextField txtTienTra;
	private JTextField txtNguoiThanhToan;
	private JTextField txtTienThua;
	private JLabel lblMessXe;
	
	private HopDong hopDong;
	private List<Xe> dsXe = new ArrayList<Xe>();
	private List<String[]> rowCTHD = new ArrayList<String[]>();
	private List<ChiTietHopDong> dsCTHDDaThem = new ArrayList<ChiTietHopDong>();
	
	private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	private Locale locale = new Locale("en", "EN");
	private String pattern = "###,###.##";
	private DecimalFormat dcf = (DecimalFormat) NumberFormat.getNumberInstance(locale);
	
	private String maNVDangNhap;

	private KhachHangFacade khachHangFacade;
	private XeFacade xeFacade;
	private HopDongFacade hopDongFacade;
	private JTextField txtSoLuongXeDaThem;
	private JLabel lblMessHopDong;
	
	
	
	/**
	 * Create the panel.
	 */
	public PanelLapHopDong(KhachHangFacade khachHangFacade, XeFacade xeFacade
			, HopDongFacade hopDongFacade, String maNVDangNhap) {
		dcf.applyPattern(pattern);
		
		this.khachHangFacade = khachHangFacade;
		this.xeFacade = xeFacade;
		this.hopDongFacade = hopDongFacade;
		this.maNVDangNhap = maNVDangNhap;
		
		hopDong = new HopDong(setMaHopDongTuDong(), new Date(), 0);
		
		try {
			dsXe = xeFacade.getDSXe();
		} catch (RemoteException e2) {
			e2.printStackTrace();
		}
		
		setBackground(new Color(175, 238, 238));
		setForeground(new Color(255, 255, 0));
		setName("");
		setBounds(0, 0, 1086, 676);
		setLayout(null);

		JPanel panelHoaDon = new JPanel();
		panelHoaDon.setBorder(new LineBorder(new Color(255, 0, 0)));
		panelHoaDon.setBounds(445, 0, 641, 676);
		add(panelHoaDon);
		panelHoaDon.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 266, 641, 242);
		panelHoaDon.add(scrollPane);

		String[] headers = { "Mã đĩa", "Tên đĩa", "Hãng đĩa", "Số lượng", "Đơn giá", "Thành tiền" };
		modelChiTietHD = new DefaultTableModel(headers, 0);
		tableCTHD = new JTable(modelChiTietHD);
		tableCTHD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableCTHD.getSelectedRow();
				if (row >= 0) {
					txtSoLuongXeDaThem.setText((String) tableCTHD.getValueAt(row, 3));
				}
			}
		});
		tableCTHD.setBackground(new Color(176, 224, 230));
		scrollPane.setViewportView(tableCTHD);

		txtMaKhachHang = new JTextField();
		txtMaKhachHang.setForeground(new Color(0, 0, 255));
		txtMaKhachHang.setEditable(false);
		txtMaKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtMaKhachHang.setBounds(133, 67, 184, 24);
		panelHoaDon.add(txtMaKhachHang);
		txtMaKhachHang.setColumns(10);
		txtMaKhachHang.setBorder(new LineBorder(new Color(0, 0, 0)));

		JLabel lblMaKhachHang = new JLabel("Mã khách hàng:");
		lblMaKhachHang.setBounds(10, 66, 117, 22);
		panelHoaDon.add(lblMaKhachHang);
		lblMaKhachHang.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JLabel lblPhieuLapHoaDon = new JLabel("HOÁ ĐƠN BÁN HÀNG");
		lblPhieuLapHoaDon.setBounds(0, 0, 641, 32);
		panelHoaDon.add(lblPhieuLapHoaDon);
		lblPhieuLapHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhieuLapHoaDon.setForeground(new Color(220, 20, 60));
		lblPhieuLapHoaDon.setFont(new Font("Tahoma", Font.BOLD, 24));

		JLabel lblNgayTao = new JLabel("Ngày lập:");
		lblNgayTao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNgayTao.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNgayTao.setBounds(327, 66, 139, 22);
		panelHoaDon.add(lblNgayTao);

		JLabel lblSoHopDong = new JLabel("Số Hóa đơn:");
		lblSoHopDong.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoHopDong.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSoHopDong.setBounds(330, 33, 136, 22);
		panelHoaDon.add(lblSoHopDong);

		txtMaHoaDon = new JTextField();
		txtMaHoaDon.setForeground(new Color(0, 0, 255));
		txtMaHoaDon.setEditable(false);
		txtMaHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtMaHoaDon.setColumns(10);
		txtMaHoaDon.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtMaHoaDon.setBounds(472, 33, 165, 24);
		panelHoaDon.add(txtMaHoaDon);

		JLabel lblTongCong = new JLabel("Tổng cộng (đồng)");
		lblTongCong.setForeground(new Color(220, 20, 60));
		lblTongCong.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTongCong.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTongCong.setBounds(237, 593, 155, 24);
		panelHoaDon.add(lblTongCong);

		txtTongCong = new JTextField();
		txtTongCong.setFont(new Font("Tahoma", Font.BOLD, 22));
		txtTongCong.setForeground(new Color(255, 0, 0));
		txtTongCong.setBackground(new Color(173, 216, 230));
		txtTongCong.setEditable(false);
		txtTongCong.setColumns(10);
		txtTongCong.setBounds(398, 593, 222, 24);
		panelHoaDon.add(txtTongCong);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 34, 320, 227);
		panelHoaDon.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPaneDSKH = new JScrollPane();
		scrollPaneDSKH.setBounds(1, 61, 318, 140);
		panel.add(scrollPaneDSKH);

		tableDSKH = new JTable();
		tableDSKH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableDSKH.getSelectedRow();
				String ma = (String) tableDSKH.getValueAt(row, 0);
				String ten = (String) tableDSKH.getValueAt(row, 1);
				
				txtHoTenKhachHang.setText(ten);
				txtMaKhachHang.setText(ma);
				txtNguoiThanhToan.setText(ten);
			}
		});
		String[] header1 = { "Mã khách hàng", "Tên khách hàng", "Số điện thoại" };
		modelDSKH = new DefaultTableModel(header1, 0);
		tableDSKH.setModel(modelDSKH);
		scrollPaneDSKH.setViewportView(tableDSKH);

		txtTimKH = new JTextField();
		txtTimKH.setForeground(new Color(128, 128, 128));
		txtTimKH.setText("Tìm theo sđt, tên");
		txtTimKH.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtTimKH.getText().equals("Tìm số điện thoại")) {
					txtTimKH.setText("");
				} else {
					txtTimKH.selectAll();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtTimKH.getText().equals("")) {
					txtTimKH.setText("Tìm số điện thoại");
				}
			}
		});
		txtTimKH.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		txtTimKH.setColumns(10);
		txtTimKH.setBounds(2, 201, 257, 25);
		panel.add(txtTimKH);

		JButton btnTimKH = new JButton("");
		btnTimKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String keywords = txtTimKH.getText().trim();
				try {
					List<KhachHang> list = khachHangFacade.timKhachHangTheoTextSearch(keywords);
					if (!list.isEmpty()) {
						xoaHetTableKhachHang();
						for (KhachHang kh : list) {
							String[] row = {kh.getMaKH(),kh.getTenKH(),kh.getSoDienThoaiKH()};
							modelDSKH.addRow(row);
						}
					} else {
						JOptionPane.showMessageDialog((Component) e.getSource(), "Không tìm thấy khách hàng");
					}
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnTimKH.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnTimKH.setBounds(257, 201, 32, 24);
		btnTimKH.setIcon(new ImageIcon(img_SearchNho));
		panel.add(btnTimKH);

		JButton btnLamMoiKH = new JButton("");
		btnLamMoiKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTableKhachHang();
				txtHoTenKhachHang.setText("");
				txtMaKhachHang.setText("");
				txtTimKH.setText("");
			}
		});
		btnLamMoiKH.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLamMoiKH.setBounds(287, 201, 32, 24);
		btnLamMoiKH.setIcon(new ImageIcon(img_RefreshNho));
		panel.add(btnLamMoiKH);

		JLabel lblHoTenKH = new JLabel("Tên khách hàng:");
		lblHoTenKH.setBounds(6, 5, 123, 22);
		panel.add(lblHoTenKH);
		lblHoTenKH.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHoTenKH.setFont(new Font("Tahoma", Font.PLAIN, 17));

		txtHoTenKhachHang = new JTextField();
		txtHoTenKhachHang.setBounds(133, 5, 184, 24);
		panel.add(txtHoTenKhachHang);
		txtHoTenKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtHoTenKhachHang.setColumns(10);
		txtHoTenKhachHang.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		String[] header2 = { "Mã nhân viên", "Tên nhân viên" };
		modelDSNV = new DefaultTableModel(header2, 0);

		JLabel lblMaNhanVien = new JLabel("Mã nhân viên:");
		lblMaNhanVien.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMaNhanVien.setBounds(327, 100, 141, 22);
		panelHoaDon.add(lblMaNhanVien);

		txtMaNV = new JTextField();
		txtMaNV.setForeground(new Color(0, 0, 255));
		txtMaNV.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtMaNV.setEditable(false);
		txtMaNV.setColumns(10);
		txtMaNV.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtMaNV.setText(maNVDangNhap);
		txtMaNV.setBounds(472, 99, 167, 24);
		
		panelHoaDon.add(txtMaNV);

		JButton btnLapHDMoi = new JButton("Lập Hóa đơn");
		btnLapHDMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (validData()) {
						double soTienTra = Double.parseDouble(txtTienTra.getText().trim());
						String tenNguoiTra = txtNguoiThanhToan.getText();
						int soNamBaoHanh = Integer.parseInt(txtHanHopDong.getText().trim());
						String maKH = txtMaKhachHang.getText();
						if (!hopDong.getDsCTHD().isEmpty()) {
							hopDong.setKhDaiDien(new KhachHang(maKH));
							hopDong.setThoiGianBH(soNamBaoHanh);
							hopDong.setNhanVienLapHD(new NhanVienHanhChanh(maNVDangNhap));
							hopDong.themChiTietThanhToan(1, soTienTra, tenNguoiTra);
							txtTongCong.setText(dcf.format(hopDong.getTienPhaiTra()));
							txtTienThua.setText(dcf.format(hopDong.getTienThua()));
							if (hopDongFacade.themHopDong(hopDong)) {
								lblMessHopDong.setText("Thêm Hóa đơn thành công");
								for (Xe xe : dsXe) {
									xeFacade.capNhatXe(xe);
								}
							}
						} else {
							lblMessHopDong.setText("Vui lòng thêm đĩa đơn");
						}
					}
				} catch (RemoteException e1) {
					e1.printStackTrace();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog((Component) e.getSource(), "Sai định dạng tiền trả");
					txtTienTra.requestFocus();
				}
			}
		});
		btnLapHDMoi.setForeground(new Color(0, 0, 255));
		btnLapHDMoi.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLapHDMoi.setBounds(23, 584, 204, 44);
		panelHoaDon.add(btnLapHDMoi);

		txtNgayLapHD = new JTextField();
		txtNgayLapHD.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtNgayLapHD.setEditable(false);
		txtNgayLapHD.setBounds(472, 68, 167, 24);
		panelHoaDon.add(txtNgayLapHD);
		txtNgayLapHD.setColumns(10);
		txtNgayLapHD.setText(formatter.format(new Date()));

		JLabel lblHanHopDong = new JLabel("Số năm bảo hành:");
		lblHanHopDong.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHanHopDong.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblHanHopDong.setBounds(327, 132, 141, 22);
		panelHoaDon.add(lblHanHopDong);

		txtHanHopDong = new JTextField();
		txtHanHopDong.setForeground(new Color(0, 0, 0));
		txtHanHopDong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtHanHopDong.setColumns(10);
		txtHanHopDong.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtHanHopDong.setBounds(472, 132, 167, 24);
		panelHoaDon.add(txtHanHopDong);

		JButton btnXoaSP = new JButton("Xoá sản phẩm");
		btnXoaSP.setBounds(385, 189, 195, 31);
		panelHoaDon.add(btnXoaSP);
		btnXoaSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tableCTHD.getSelectedRow();
				if (row >= 0) {
					String maXe = (String) tableCTHD.getValueAt(row, 0);
					int soLuongXe = Integer.parseInt((String) tableCTHD.getValueAt(row, 3));
					
					for (int i = 0; i < dsCTHDDaThem.size(); i++) {
						if (dsCTHDDaThem.get(i).getXe().getMaXe().equals(maXe)) {
							dsCTHDDaThem.remove(i);
							capNhatChiTietHopDongTrongHopDong();
							break;
						}
					}
					
					for (int i = 0; i < rowCTHD.size(); i++) {
						if (rowCTHD.get(i)[0].equals(maXe)) {
							rowCTHD.remove(i);
							updateTableCTHD();
							break;
						}
					}
					
					for (int j = 0; j < dsXe.size(); j++) {
						if (dsXe.get(j).getMaXe().equals(maXe)) {
							Xe xeMoi = dsXe.get(j);
							int soLuongTonCu = xeMoi.getSoLuongTon();
							xeMoi.setSoLuongTon(soLuongTonCu + soLuongXe);
							dsXe.set(j, xeMoi);
							updateTableXeFromList();
						}
					}
					
				} else {
					JOptionPane.showMessageDialog((Component) e.getSource(), "Vui lòng chọn xe muốn xóa");
				}
			}
		});
		btnXoaSP.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXoaSP.setIcon(new ImageIcon(img_Delete));
		
		txtTienTra = new JTextField();
		txtTienTra.setForeground(Color.BLUE);
		txtTienTra.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtTienTra.setColumns(10);
		txtTienTra.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtTienTra.setBounds(459, 520, 172, 24);
		panelHoaDon.add(txtTienTra);
		
		JLabel lblTinTr = new JLabel("Tiền trả:");
		lblTinTr.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTinTr.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTinTr.setBounds(375, 519, 82, 22);
		panelHoaDon.add(lblTinTr);
		
		JLabel lblNgiThanhTon = new JLabel("Người thanh toán:");
		lblNgiThanhTon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNgiThanhTon.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNgiThanhTon.setBounds(0, 519, 141, 22);
		panelHoaDon.add(lblNgiThanhTon);
		
		txtNguoiThanhToan = new JTextField();
		txtNguoiThanhToan.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtNguoiThanhToan.setColumns(10);
		txtNguoiThanhToan.setBounds(145, 519, 199, 24);
		panelHoaDon.add(txtNguoiThanhToan);
		
		JLabel lblTienThua = new JLabel("Tiền thừa (đồng)");
		lblTienThua.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTienThua.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTienThua.setBounds(237, 628, 155, 24);
		panelHoaDon.add(lblTienThua);
		
		txtTienThua = new JTextField();
		txtTienThua.setForeground(new Color(0, 0, 0));
		txtTienThua.setFont(new Font("Tahoma", Font.BOLD, 22));
		txtTienThua.setEditable(false);
		txtTienThua.setColumns(10);
		txtTienThua.setBackground(new Color(255, 255, 255));
		txtTienThua.setBounds(398, 628, 222, 24);
		panelHoaDon.add(txtTienThua);

		JPanel pnlDanhSachSanPham = new JPanel();
		pnlDanhSachSanPham.setBorder(new LineBorder(new Color(0, 0, 255)));
		pnlDanhSachSanPham.setBounds(0, 0, 441, 676);
		add(pnlDanhSachSanPham);
		pnlDanhSachSanPham.setLayout(null);

		JScrollPane scrollPaneDanhSachSP = new JScrollPane();
		scrollPaneDanhSachSP.setBounds(0, 144, 436, 528);
		pnlDanhSachSanPham.add(scrollPaneDanhSachSP);

		String[] headers1 = { "Mã đĩa", "Tên đĩa", "Hãng đĩa", "Tồn kho", "Giá bán" };
		modelDanhSachSP = new DefaultTableModel(headers1, 0);
		tbDanhSachXe = new JTable(modelDanhSachSP);
		scrollPaneDanhSachSP.setViewportView(tbDanhSachXe);

		JLabel lblDanhSachXe = new JLabel("DANH SÁCH ĐĨA");
		lblDanhSachXe.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSachXe.setForeground(new Color(70, 130, 180));
		lblDanhSachXe.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDanhSachXe.setBounds(0, 0, 441, 32);
		pnlDanhSachSanPham.add(lblDanhSachXe);

		JPanel pnTimKiem = new JPanel();
		pnTimKiem.setLayout(null);
		pnTimKiem.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnTimKiem.setBounds(0, 105, 436, 43);
		pnlDanhSachSanPham.add(pnTimKiem);

		JButton btnTimKiem = new JButton("");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String keywords = txtTimSP.getText().trim();
				Xe xe;
				try {
					xe = xeFacade.timXeTheoMa(keywords);
					if (xe != null) {
						xoaHetTableXe();
						for (Xe xeFromList : dsXe) {
							if (xeFromList.getMaXe().equals(xe.getMaXe())) {
								String[] rowData = {xeFromList.getMaXe(),xeFromList.getTenXe(),xeFromList.getHangXe(),xeFromList.getSoLuongTon()+""
										,dcf.format(xeFromList.getDonGia())};
								modelDanhSachSP.addRow(rowData);
							}
						}
					} else {
						xoaHetTableXe();
						List<Xe> dsXeFromDB = xeFacade.timXeTheoTextSearch(keywords);
						for (Xe x : dsXeFromDB) {
							for (Xe xeFromList : dsXe) {
								if (xeFromList.getMaXe().equals(x.getMaXe())) {
									String[] rowData = {xeFromList.getMaXe(),xeFromList.getTenXe(),xeFromList.getHangXe(),xeFromList.getSoLuongTon()+""
											,dcf.format(xeFromList.getDonGia())};
									modelDanhSachSP.addRow(rowData);
								}
							}
						}
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnTimKiem.setBounds(350, 2, 41, 36);
		btnTimKiem.setIcon(new ImageIcon(img_SearchLon));
		pnTimKiem.add(btnTimKiem);

		txtTimSP = new JTextField();
		txtTimSP.setForeground(new Color(128, 128, 128));
		txtTimSP.setText("Tìm theo mã đĩa, tên đĩa, hãng");
		txtTimSP.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtTimSP.getText().equals("Tìm theo mã xe, tên xe, hãng")) {
					txtTimSP.setText("");
				} else {
					txtTimSP.selectAll();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtTimSP.getText().equals("")) {
					txtTimSP.setText("Tìm theo mã xe, tên xe, hãng");
				}
			}
		});
		txtTimSP.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		txtTimSP.setColumns(10);
		txtTimSP.setBounds(8, 4, 340, 30);
		pnTimKiem.add(txtTimSP);

		JButton btnLamMoi = new JButton("");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTableXeFromList();
			}

		});
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLamMoi.setBounds(392, 2, 41, 36);
		btnLamMoi.setIcon(new ImageIcon(img_RefreshLon));
		pnTimKiem.add(btnLamMoi);

		JLabel lblSoLuong = new JLabel("Số lượng:");
		lblSoLuong.setBounds(10, 32, 70, 22);
		pnlDanhSachSanPham.add(lblSoLuong);
		lblSoLuong.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 17));

		txtSoLuong = new JTextField();
		txtSoLuong.setBounds(85, 33, 346, 24);
		pnlDanhSachSanPham.add(txtSoLuong);
		txtSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtSoLuong.setColumns(10);
		txtSoLuong.setBorder(new LineBorder(new Color(0, 0, 0)));

		JButton btnThemSP = new JButton("Thêm vào hóa đơn");
		btnThemSP.setBounds(221, 68, 210, 31);
		pnlDanhSachSanPham.add(btnThemSP);
		btnThemSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String soLuong = "";
				try {
					soLuong = txtSoLuong.getText().trim();
					if (soLuong.equals("")) {
						lblMessXe.setText("Vui lòng nhập số lượng");
						txtSoLuong.requestFocus();
					} else {
						int row = tbDanhSachXe.getSelectedRow();
						if (row >= 0) {
							String ma = (String) tbDanhSachXe.getValueAt(row, 0);
							Xe xe = xeFacade.timXeTheoMa(ma);
							int soLuongTonList = Integer.parseInt((String) tbDanhSachXe.getValueAt(row, 3));
							if (soLuongTonList >= Integer.parseInt(soLuong)) {
								boolean daCo = false;
								for (int i = 0; i < dsCTHDDaThem.size(); i++) {
									if (dsCTHDDaThem.get(i).getXe().getMaXe().equals(ma)) {
										ChiTietHopDong chiTietHopDong = dsCTHDDaThem.get(i);
										int soLuongCu = chiTietHopDong.getSoLuong();
										int soLuongMoi = soLuongCu + Integer.parseInt(soLuong);
										chiTietHopDong.setSoLuong(soLuongMoi);
										dsCTHDDaThem.set(i, chiTietHopDong);
										capNhatChiTietHopDongTrongHopDong();
										daCo = true;
										String[] rowsCapNhat = {ma ,xe.getTenXe(), xe.getHangXe(), soLuongMoi+"", dcf.format(xe.getDonGia()),dcf.format(chiTietHopDong.getThanhTien())};
										for (int j = 0; j < rowCTHD.size(); j++) {
											if (rowCTHD.get(i)[0].equals(ma)) {
												rowCTHD.set(i, rowsCapNhat);
											}
										}
										break;
									}
								}
								if (!daCo) {
									hopDong.themChiTietHopDong(Integer.parseInt(soLuong), xe.getDonGia(), xe);
									ChiTietHopDong chiTietHopDong = new ChiTietHopDong(Integer.parseInt(soLuong), xe.getDonGia());
									chiTietHopDong.setXe(xe);
									dsCTHDDaThem.add(chiTietHopDong);
									String[] rowsThem = {ma ,xe.getTenXe(), xe.getHangXe(), soLuong+"", dcf.format(xe.getDonGia()),dcf.format(chiTietHopDong.getThanhTien())};
									rowCTHD.add(rowsThem);
								}
								
								updateTableCTHD();
								
								for (int i = 0; i < dsXe.size(); i++) {
									if (dsXe.get(i).getMaXe().equals(ma)) {
										Xe xeFromList = dsXe.get(i);
										int soLuongTon = xeFromList.getSoLuongTon();
										xeFromList.setSoLuongTon(soLuongTon - Integer.parseInt(soLuong));
										dsXe.set(i, xeFromList);
									}
								}
								updateTableXeFromList();
								txtTongCong.setText(dcf.format(hopDong.getTongThanhTien()));
								lblMessXe.setText("");
							} else {
								lblMessXe.setText("Cửa hàng không đủ số lượng");
							}
						} else {
							lblMessXe.setText("Vui lòng chọn xe");
						}
					}
				} catch (Exception e1) {
					lblMessXe.setText("Sai định dạng số lượng");
				}
			}
		});
		btnThemSP.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThemSP.setIcon(new ImageIcon(img_Add));
		
		lblMessXe = new JLabel("");
		lblMessXe.setForeground(Color.RED);
		lblMessXe.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblMessXe.setBounds(10, 65, 201, 22);
		pnlDanhSachSanPham.add(lblMessXe);
		setVisible(true);
		updateTableXeFromDatabase();
		txtMaHoaDon.setText(setMaHopDongTuDong());
		
		lblMessHopDong = new JLabel("");
		lblMessHopDong.setForeground(Color.RED);
		lblMessHopDong.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblMessHopDong.setBounds(10, 552, 351, 30);
		panelHoaDon.add(lblMessHopDong);
		
		txtSoLuongXeDaThem = new JTextField();
		txtSoLuongXeDaThem.setForeground(Color.BLACK);
		txtSoLuongXeDaThem.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtSoLuongXeDaThem.setColumns(10);
		txtSoLuongXeDaThem.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtSoLuongXeDaThem.setBounds(398, 235, 59, 24);
		panelHoaDon.add(txtSoLuongXeDaThem);
		
		JButton btnCapNhatSL = new JButton("Cập nhật");
		btnCapNhatSL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tableCTHD.getSelectedRow();
				if (row >= 0) {
					try {
						int soLuongMoi = Integer.parseInt(txtSoLuongXeDaThem.getText().trim());
						String maXe = (String) tableCTHD.getValueAt(row, 0);
						int soLuongCu = Integer.parseInt((String) tableCTHD.getValueAt(row, 3));
						ChiTietHopDong ct = new ChiTietHopDong();
						
						for (int i = 0; i < dsCTHDDaThem.size(); i++) {
							if (dsCTHDDaThem.get(i).getXe().getMaXe().equals(maXe)) {
								ChiTietHopDong chiTietHopDongMoi = dsCTHDDaThem.get(i);
								chiTietHopDongMoi.setSoLuong(soLuongMoi);
								dsCTHDDaThem.set(i, chiTietHopDongMoi);
								ct = chiTietHopDongMoi;
								capNhatChiTietHopDongTrongHopDong();
								break;
							}
						}
						
						for (int i = 0; i < rowCTHD.size(); i++) {
							if (rowCTHD.get(i)[0].equals(maXe)) {
								String[] rowMoi = rowCTHD.get(i);
								rowMoi[3] = soLuongMoi+"";
								rowMoi[5] = dcf.format(ct.getThanhTien());
								rowCTHD.set(i, rowMoi);
								updateTableCTHD();
								break;
							}
						}
						
						for (int j = 0; j < dsXe.size(); j++) {
							if (dsXe.get(j).getMaXe().equals(maXe)) {
								Xe xeMoi = dsXe.get(j);
								int soLuongTonCu = xeMoi.getSoLuongTon();
								xeMoi.setSoLuongTon(soLuongTonCu + soLuongCu - soLuongMoi);
								dsXe.set(j, xeMoi);
								updateTableXeFromList();
							}
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog((Component) e.getSource(), "Sai định dạng số lượng");
						txtSoLuongXeDaThem.requestFocus();
					}
				} else {
					JOptionPane.showMessageDialog((Component) e.getSource(), "Vui lòng chọn xe cần cập nhật");
				}
			}
		});
		btnCapNhatSL.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCapNhatSL.setBounds(464, 231, 139, 31);
		panelHoaDon.add(btnCapNhatSL);
		
		JLabel lblSoLuongXeDaThem = new JLabel("Số lượng:");
		lblSoLuongXeDaThem.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSoLuongXeDaThem.setBounds(327, 233, 76, 24);
		panelHoaDon.add(lblSoLuongXeDaThem);
		
		JButton btnThmHpng = new JButton("Thêm hóa đơn mới");
		btnThmHpng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					txtSoLuong.setText("");
					lblMessXe.setText("");
					lblMessHopDong.setText("");
					txtTimSP.setText("");
					updateTableXeFromDatabase();
					txtHoTenKhachHang.setText("");
					txtMaKhachHang.setText("");
					txtTimKH.setText("");
					updateTableKhachHang();
					String maHD = setMaHopDongTuDong();
					txtMaHoaDon.setText(maHD);
					txtNgayLapHD.setText(formatter.format(new Date()));
					txtMaNV.setText(maNVDangNhap);
					txtHanHopDong.setText("");
					txtSoLuongXeDaThem.setText("");
					dsXe = xeFacade.getDSXe();
					dsCTHDDaThem = new ArrayList<ChiTietHopDong>();
					hopDong = new HopDong(maHD, new Date(), 0);
					rowCTHD = new ArrayList<String[]>();
					updateTableCTHD();
					txtNguoiThanhToan.setText("");
					txtTienTra.setText("");
					txtTongCong.setText("");
					txtTienThua.setText("");
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		btnThmHpng.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThmHpng.setBounds(23, 639, 204, 31);
		panelHoaDon.add(btnThmHpng);
		
		hopDong.setNhanVienLapHD(new NhanVienHanhChanh(maNVDangNhap));
		updateTableKhachHang();
	}
	
	public void xoaHetTableXe() {
		DefaultTableModel dm = (DefaultTableModel) tbDanhSachXe.getModel();
		dm.getDataVector().removeAllElements();
	}
	
	public void xoaHetTableCTHD() {
		DefaultTableModel dm = (DefaultTableModel) tableCTHD.getModel();
		dm.getDataVector().removeAllElements();
	}
	
	public void xoaHetTableKhachHang() {
		DefaultTableModel dm = (DefaultTableModel) tableDSKH.getModel();
		dm.getDataVector().removeAllElements();
	}
	
	public void updateTableXeFromList() {
		xoaHetTableXe();
		for (Xe s : dsXe) {
			String[] rowData = {s.getMaXe(),s.getTenXe(),s.getHangXe(),s.getSoLuongTon()+"",dcf.format(s.getDonGia())};
			modelDanhSachSP.addRow(rowData);
		}
		tbDanhSachXe.setModel(modelDanhSachSP);
	}
	
	public void updateTableXeFromDatabase() {
		xoaHetTableXe();
		List<Xe> dsXe;
		try {
			dsXe = xeFacade.getDSXe();
			for (Xe s : dsXe) {
				String[] rowData = {s.getMaXe(),s.getTenXe(),s.getHangXe(),s.getSoLuongTon()+"",dcf.format(s.getDonGia())};
				modelDanhSachSP.addRow(rowData);
			}
			tbDanhSachXe.setModel(modelDanhSachSP);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean validData() {
		if (txtMaKhachHang.getText().trim().equals("")) {
			lblMessHopDong.setText("Chưa chọn khách hàng");
			txtMaKhachHang.requestFocus();
			return false;
		}
		
		if (txtHanHopDong.getText().trim().equals("")) {
			lblMessHopDong.setText("Chưa nhập số năm bảo hành");
			txtHanHopDong.requestFocus();
			return false;
		}
		
		if (txtNguoiThanhToan.getText().trim().equals("")) {
			lblMessHopDong.setText("Chưa nhập tên người thanh toán");
			txtNguoiThanhToan.requestFocus();
			return false;
		}
		
		try {
			double tienTra = Integer.parseInt(txtTienTra.getText().trim());
			if (tienTra <= 0) {
				lblMessHopDong.setText("Tiền trả phải > 0");
				txtTienTra.requestFocus();
				return false;
			}
		} catch (Exception e) {
			lblMessHopDong.setText("Sai định dạng tiền trả");
			txtTienTra.requestFocus();
			return false;
		}
		
		return true;
	}
	
	public void updateTableCTHD() {
		xoaHetTableCTHD();
		if (rowCTHD.isEmpty()) {
			String[] row = {"","","","",""};
			modelChiTietHD.addRow(row);
		} else {
			for (String[] row : rowCTHD) {
				modelChiTietHD.addRow(row);
			}
		}
		tableCTHD.setModel(modelChiTietHD);
		
	}
	
	
	public void updateTableKhachHang() {
		xoaHetTableKhachHang();
		List<KhachHang> dsKH;
		try {
			dsKH = khachHangFacade.getDSKhachHang();
			for (KhachHang s : dsKH) {
				String[] rowData = {s.getMaKH(),s.getTenKH(),s.getSoDienThoaiKH()};
				modelDSKH.addRow(rowData);
			}
			tableDSKH.setModel(modelDSKH);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public void capNhatChiTietHopDongTrongHopDong() {
		hopDong.xoaHetChiTietHopDong();
		for (ChiTietHopDong chiTietHopDong : dsCTHDDaThem) {
			hopDong.themChiTietHopDong(chiTietHopDong.getSoLuong(), chiTietHopDong.getDonGia(), chiTietHopDong.getXe());
		}
		txtTongCong.setText(dcf.format(hopDong.getTienPhaiTra()));
		txtTienThua.setText(dcf.format(hopDong.getTienThua()));
	}
	
	public String setMaHopDongTuDong() {
		String maHopDong = "HD";
		int n = 1;
		try {
			n = hopDongFacade.getDSHopDong().size() +1;
			while (hopDongFacade.timHopDongTheoMaHopDong(maHopDong + n) != null) {
				n++;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return maHopDong + n;
	}
}