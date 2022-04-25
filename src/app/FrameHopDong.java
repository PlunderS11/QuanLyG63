package app;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.toedter.calendar.JDateChooser;

import dao.DAO_HopDong;
import dao.DAO_KhachHang;
import dao.HangSanXuat_DAO;
import dao.LoaiXe_DAO;
import dao.NhanVien_DAO;
import dao.TrangChu_DAO;
import dao.Xe_DAO;
import entity.HangSanXuat;
import entity.HopDong;
import entity.KhachHang;
import entity.LoaiXe;
import entity.NhanVien;
import entity.Xe;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

public class FrameHopDong extends JFrame{
	private JTextField textField;
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtCCCD;
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	private JDateChooser txtNgayLap;
	private JTextField txtMauXe;
	private JTextField txtSoKhung;
	private JTextField txtSoMay;
	private JTable table;
	private TrangChu_DAO trangchu_dao;
	private DAO_KhachHang dao_khachHang;
	private Xe_DAO dao_xe;
	private JTextField txtHSX;
	private JTextField txtLoaiXe;
	private JTextField txtGiaNhap;
	private DAO_HopDong hopdong_dao;
	private DefaultTableModel model;
	private NhanVien_DAO daonhanvien;
	private JTextField txtMaHopDong;
	public FrameHopDong() {
		setSize(1345, 705);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);		
		getContentPane().setBackground(new Color(166, 169, 248));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(new Color(166, 169, 248));
		panel.setBounds(0, 0, 392, 668);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ HỢP ĐỒNG");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(247,237,0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(38, 10, 324, 37);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã khách hàng:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 216, 153, 32);
		panel.add(lblNewLabel_1);
		
		txtMaKH = new JTextField();
		txtMaKH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMaKH.setEditable(false);
		txtMaKH.setColumns(10);
		txtMaKH.setBounds(173, 216, 210, 32);
		panel.add(txtMaKH);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên khách hàng:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(10, 266, 134, 32);
		panel.add(lblNewLabel_1_1);
		
		txtTenKH = new JTextField();
		txtTenKH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenKH.setEditable(false);
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(173, 266, 210, 32);
		panel.add(txtTenKH);
		
		JLabel lblNewLabel_1_2 = new JLabel("CCCD:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(10, 316, 134, 32);
		panel.add(lblNewLabel_1_2);
		
		txtCCCD = new JTextField();
		txtCCCD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCCCD.setEditable(false);
		txtCCCD.setColumns(10);
		txtCCCD.setBounds(173, 316, 210, 32);
		panel.add(txtCCCD);
		
		JLabel lblNewLabel_1_3 = new JLabel("Mã nhân viên:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(10, 366, 134, 32);
		panel.add(lblNewLabel_1_3);
		
		trangchu_dao = new TrangChu_DAO();
		NhanVien nv = trangchu_dao.getNhanVienSuDung(NewSignin.getTaiKhoan());
		
		txtMaNV = new JTextField();
		txtMaNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMaNV.setEditable(false);
		txtMaNV.setColumns(10);
		txtMaNV.setBounds(173, 366, 210, 32);
		txtMaNV.setText(nv.getMaNV());
		panel.add(txtMaNV);
		
		JLabel lblNewLabel_1_4 = new JLabel("Tên nhân viên:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_4.setBounds(10, 416, 134, 32);
		panel.add(lblNewLabel_1_4);
		
		txtTenNV = new JTextField();
		txtTenNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenNV.setEditable(false);
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(173, 416, 210, 32);
		txtTenNV.setText(nv.getTenNV());
		panel.add(txtTenNV);
		
		JLabel lblNewLabel_1_5 = new JLabel("Ngày lập:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_5.setBounds(10, 466, 134, 32);
		panel.add(lblNewLabel_1_5);
		
		txtNgayLap = new JDateChooser();
		txtNgayLap.setDateFormatString("yyyy-MM-dd");
		txtNgayLap.setBounds(173, 466, 210, 32);
		txtNgayLap.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Date d = new Date();
		txtNgayLap.setDate(d);
		panel.add(txtNgayLap);
		
		JButton btnThemKH = new FixButton("Thêm");
		
		btnThemKH.setIcon(new ImageIcon("image\\them.png"));
		btnThemKH.setForeground(Color.WHITE);
		btnThemKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThemKH.setBackground(new Color(107,96,236));
		btnThemKH.setBounds(9, 528, 115, 49);
		panel.add(btnThemKH);
		
		JButton btnLamMoi = new FixButton("Làm mới");
		
		btnLamMoi.setIcon(new ImageIcon("image\\lammoi.png"));
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLamMoi.setBackground(new Color(107,96,236));
		btnLamMoi.setBounds(249, 528, 134, 49);
		panel.add(btnLamMoi);
		
		JPanel pnlTimKH = new JPanel();
		pnlTimKH.setBackground(new Color(147, 112, 219));
		pnlTimKH.setBounds(10, 57, 373, 93);		
		panel.add(pnlTimKH);
		pnlTimKH.setLayout(null);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Tìm kiếm khách:");
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_1_1.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_2_1_1.setBounds(10, 14, 183, 32);
		pnlTimKH.add(lblNewLabel_1_2_1_1);
		
		JButton btnTimKH = new FixButton("Tìm");
		
		btnTimKH.setForeground(Color.WHITE);
		btnTimKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTimKH.setIcon(new ImageIcon("image\\timkiem.png"));
		btnTimKH.setBackground(new Color(107, 96, 236));
		btnTimKH.setBounds(247, 51, 117, 32);
		pnlTimKH.add(btnTimKH);
		
		JComboBox cboTimKHCu = new JComboBox();
		cboTimKHCu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cboTimKHCu.setBounds(10, 51, 216, 32);
		cboTimKHCu.addItem("");
		cboTimKHCu.setEditable(true);
		AutoCompleteDecorator.decorate(cboTimKHCu);
		pnlTimKH.add(cboTimKHCu);
		
		JLabel lblNewLabel_1_6 = new JLabel("Mã hợp đồng:");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_6.setBounds(10, 166, 153, 32);
		panel.add(lblNewLabel_1_6);
		
		txtMaHopDong = new JTextField();
		txtMaHopDong.setEditable(false);
		txtMaHopDong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMaHopDong.setColumns(10);
		txtMaHopDong.setBounds(173, 166, 210, 32);
		panel.add(txtMaHopDong);
		
		FixButton btnXoaHopDong = new FixButton("Thêm");
		
		btnXoaHopDong.setIcon(new ImageIcon("image\\xoa.png"));
		
		btnXoaHopDong.setText("Xóa");
		btnXoaHopDong.setForeground(Color.WHITE);
		btnXoaHopDong.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoaHopDong.setBackground(new Color(107, 96, 236));
		btnXoaHopDong.setBounds(129, 528, 115, 49);
		panel.add(btnXoaHopDong);
		
		dao_khachHang = new DAO_KhachHang();
		for (KhachHang kh : dao_khachHang.getAllKH()) {
			cboTimKHCu.addItem(kh.getcCCD());
		}
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(402, 201, 919, 467);
		getContentPane().add(scrollPane);
		
		table = new JTable(){
			public Component prepareRenderer(TableCellRenderer rederer, int row, int column) {
				Component c = super.prepareRenderer(rederer, row, column);
				Color color1 = new Color(220,220,220);
				Color color2 = Color.WHITE;
				if (!c.getBackground().equals(getSelectionBackground())) {
					Color coleur = (row % 2 == 0 ? color1 : color2);
					c.setBackground(coleur);
					coleur=null;
				}
				return c;
			}
		};
		table.setBorder(null);
		table.setBackground(Color.WHITE);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setGridColor(getBackground());
		table.setRowHeight(table.getRowHeight() + 20);
		table.setSelectionBackground(new Color(166, 169, 248));
		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setBackground(new Color(79, 12, 132));
		tableHeader.setForeground(Color.WHITE);
		tableHeader.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setModel(model = new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Mã hợp đồng","Mã khách hàng", "Tên khách hàng", "CCCD", "Mã nhân viên", "Tên nhân viên", "Mã xe", "Tên xe", "Ngày lập","Trạng thái"
			}){
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false, false,false,false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1_7 = new JLabel("Màu xe:");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_7.setBounds(440, 75, 304, 32);
		getContentPane().add(lblNewLabel_1_7);
		
		txtMauXe = new JTextField();
		txtMauXe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMauXe.setEditable(false);
		txtMauXe.setColumns(10);
		txtMauXe.setBounds(541, 75, 203, 32);
		getContentPane().add(txtMauXe);
		
		JLabel lblNewLabel_1_7_1 = new JLabel("Số khung:");
		lblNewLabel_1_7_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_7_1.setBounds(440, 117, 304, 32);
		getContentPane().add(lblNewLabel_1_7_1);
		
		txtSoKhung = new JTextField();
		txtSoKhung.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSoKhung.setEditable(false);
		txtSoKhung.setColumns(10);
		txtSoKhung.setBounds(541, 117, 203, 32);
		getContentPane().add(txtSoKhung);
		
		JLabel lblNewLabel_1_7_2 = new JLabel("Số máy:");
		lblNewLabel_1_7_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_7_2.setBounds(440, 159, 304, 32);
		getContentPane().add(lblNewLabel_1_7_2);
		
		txtSoMay = new JTextField();
		txtSoMay.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSoMay.setEditable(false);
		txtSoMay.setColumns(10);
		txtSoMay.setBounds(541, 159, 203, 32);
		getContentPane().add(txtSoMay);
		
		JLabel lblNewLabel_1_7_3 = new JLabel("Hãng sản xuất:");
		lblNewLabel_1_7_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_7_3.setBounds(799, 75, 129, 32);
		getContentPane().add(lblNewLabel_1_7_3);
		
		JLabel lblNewLabel_1_7_4 = new JLabel("Loại xe:");
		lblNewLabel_1_7_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_7_4.setBounds(799, 117, 93, 32);
		getContentPane().add(lblNewLabel_1_7_4);
		
		JLabel lblNewLabel_1_7_5 = new JLabel("Giá nhập:");
		lblNewLabel_1_7_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_7_5.setBounds(799, 159, 93, 32);
		getContentPane().add(lblNewLabel_1_7_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(147, 112, 219));
		panel_1.setBounds(440, 10, 691, 53);
		getContentPane().add(panel_1);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Tìm kiếm sản phẩm:");
		lblNewLabel_1_2_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_1_1_1.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_2_1_1_1.setBounds(10, 10, 168, 32);
		panel_1.add(lblNewLabel_1_2_1_1_1);
		
		JComboBox cboTimXe = new JComboBox();
		cboTimXe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cboTimXe.setBounds(177, 12, 395, 32);
		cboTimXe.addItem("");
		cboTimXe.setEditable(true);
		AutoCompleteDecorator.decorate(cboTimXe);
		panel_1.add(cboTimXe);
		
		dao_xe = new Xe_DAO();
		for (Xe x : dao_xe.getDanhSachXe()) {
			if (x.getTrangThai().equalsIgnoreCase("Còn hàng")) {
				cboTimXe.addItem(x.getMaXe()+" - "+x.getTenXe());
			}
		}
		
		FixButton btnTimKH_1 = new FixButton("Tìm");
		btnTimKH_1.setForeground(Color.WHITE);
		btnTimKH_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTimKH_1.setBackground(new Color(107, 96, 236));
		btnTimKH_1.setBounds(1026, 10, 99, 32);
		panel_1.add(btnTimKH_1);
		
		FixButton btnTimXe = new FixButton("Tìm");
		btnTimXe.setIcon(new ImageIcon("image\\timkiem.png"));
		btnTimXe.addActionListener(new ActionListener() {
			private HangSanXuat_DAO daoHSX;
			private LoaiXe_DAO daoLoaiXe;

			public void actionPerformed(ActionEvent e) {
				if (cboTimXe.getSelectedItem().toString().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm!");
				} else {
					String ma = cboTimXe.getSelectedItem().toString().substring(0,5);
					daoHSX = new HangSanXuat_DAO();
					daoLoaiXe = new LoaiXe_DAO();
					
					for (Xe xe : dao_xe.getDanhSachXe()) {
						HangSanXuat hsx = daoHSX.getHSXTheoMa(xe.getHangSanXuat().getMaHangSX());
						LoaiXe lx = daoLoaiXe.getLoaiXeTheoMa(xe.getLoaiXe().getMaLoaiXe());
						if (xe.getMaXe().equalsIgnoreCase(ma)) {
							txtMauXe.setText(xe.getMauXe());
							txtSoKhung.setText(xe.getSoKhung());
							txtSoMay.setText(xe.getSoMay());
							txtHSX.setText(hsx.getTenHangSX());
							txtLoaiXe.setText(lx.getTenLoaiXe());
							DecimalFormat cf = new DecimalFormat("###.0");
							txtGiaNhap.setText(cf.format(xe.getGiaXe()));
							
						}
					}
				}
				
			}
		});
		btnTimXe.setForeground(Color.WHITE);
		btnTimXe.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTimXe.setBackground(new Color(107, 96, 236));
		btnTimXe.setBounds(582, 10, 99, 32);
		panel_1.add(btnTimXe);
		
		txtHSX = new JTextField();
		txtHSX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtHSX.setEditable(false);
		txtHSX.setColumns(10);
		txtHSX.setBounds(928, 75, 203, 32);
		getContentPane().add(txtHSX);
		
		txtLoaiXe = new JTextField();
		txtLoaiXe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtLoaiXe.setEditable(false);
		txtLoaiXe.setColumns(10);
		txtLoaiXe.setBounds(928, 117, 203, 32);
		getContentPane().add(txtLoaiXe);
		
		txtGiaNhap = new JTextField();
		txtGiaNhap.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtGiaNhap.setEditable(false);
		txtGiaNhap.setColumns(10);
		txtGiaNhap.setBounds(928, 159, 203, 32);
		
		
		
		hopdong_dao = new DAO_HopDong();
		daonhanvien = new NhanVien_DAO();
		
		phatSinhMaHopDong();
		
		for (HopDong hd : hopdong_dao.getAllHopDong()) {
			String tenKH = "";
			String cccd = "";
			String tenNV = "";
			String tenXe = "";
			for (KhachHang kh : dao_khachHang.getAllKH()) {
				if (kh.getMaKH().equalsIgnoreCase(hd.getKhachHang().getMaKH())) {
					tenKH = kh.getTenKH();
					cccd = kh.getcCCD();
				}
			}
			for (NhanVien nhanvien : daonhanvien.getAllNhanVien()) {
				if (nhanvien.getMaNV().equalsIgnoreCase(hd.getNhanVien().getMaNV())) {
					tenNV = nhanvien.getTenNV();
				}
			}
			for (Xe xe : dao_xe.getDanhSachXe()) {
				if (xe.getMaXe().equalsIgnoreCase(hd.getXe().getMaXe())) {
					tenXe = xe.getTenXe();
				}
			}
//			HangSanXuat hsx = daoHSX.getHSXTheoMa(xe.getHangSanXuat().getMaHangSX());
//			LoaiXe lx = daoLoaiXe.getLoaiXeTheoMa(xe.getLoaiXe().getMaLoaiXe());
			model.addRow(new Object[] {
					hd.getMaHopDong(),
					hd.getKhachHang().getMaKH(),tenKH,cccd,
					hd.getNhanVien().getMaNV(),tenNV,
					hd.getXe().getMaXe(),tenXe,
					hd.getNgayLapHopDong(),
					hd.getTrangThai()
					
			});
		}
		
		getContentPane().add(txtGiaNhap);
		
		btnTimKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cboTimKHCu.getSelectedItem().toString().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập CCCD của khách hàng!");
				} else {
					for (KhachHang kh : dao_khachHang.getAllKH()) {
						if (kh.getcCCD().equalsIgnoreCase(cboTimKHCu.getSelectedItem().toString())) {
							txtMaKH.setText(kh.getMaKH());
							txtTenKH.setText(kh.getTenKH());
							txtCCCD.setText(kh.getcCCD());
						}
					}
				}
				
			}
		});
		btnThemKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtMaKH.getText().equalsIgnoreCase("")||txtMauXe.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!");
				} else {
					String maHD = txtMaHopDong.getText();
					String maKH = txtMaKH.getText();
					String maNV = txtMaNV.getText();
					String maXe = cboTimXe.getSelectedItem().toString().substring(0,5);
					Date ngay = txtNgayLap.getDate();
					java.sql.Date ngayLapHD = new java.sql.Date(ngay.getYear(),ngay.getMonth(),ngay.getDate());
					
					HopDong hd = new HopDong(maHD, new KhachHang(maKH), new NhanVien(maNV), new Xe(maXe), ngayLapHD,"Chưa thanh toán");
					if (hopdong_dao.getAllHopDong().contains(hd)) {
						JOptionPane.showMessageDialog(null, "Mã hợp đồng đã tồn tại!");
					} else {
						try {
							
							hopdong_dao.create(hd);
							dao_xe.update(maXe, "Đang bán");
							String tenKH = "";
							String cccd = "";
							String tenNV = "";
							String tenXe = "";
							for (KhachHang kh : dao_khachHang.getAllKH()) {
								if (kh.getMaKH().equalsIgnoreCase(hd.getKhachHang().getMaKH())) {
									tenKH = kh.getTenKH();
									cccd = kh.getcCCD();
								}
							}
							for (NhanVien nhanvien : daonhanvien.getAllNhanVien()) {
								if (nhanvien.getMaNV().equalsIgnoreCase(hd.getNhanVien().getMaNV())) {
									tenNV = nhanvien.getTenNV();
								}
							}
							for (Xe xe : dao_xe.getDanhSachXe()) {
								if (xe.getMaXe().equalsIgnoreCase(hd.getXe().getMaXe())) {
									tenXe = xe.getTenXe();
								}
							}
							model.addRow(new Object[] {
									hd.getMaHopDong(),
									hd.getKhachHang().getMaKH(),tenKH,cccd,
									hd.getNhanVien().getMaNV(),tenNV,
									hd.getXe().getMaXe(),tenXe,
									hd.getNgayLapHopDong(),
									hd.getTrangThai()
							});
							JOptionPane.showMessageDialog(null, "Thêm thành công!");
						} catch (Exception e2) {
							// TODO: handle exception
							JOptionPane.showMessageDialog(null, "Thêm thất bại!");
						}
					}
				}

			}
		});
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				phatSinhMaHopDong();
				cboTimKHCu.setSelectedIndex(0);
				txtMaKH.setText("");
				txtTenKH.setText("");
				txtCCCD.setText("");
				
				cboTimXe.removeAllItems();
				cboTimXe.addItem("");
				for (Xe x : dao_xe.getDanhSachXe()) {
					if (x.getTrangThai().equalsIgnoreCase("Chưa bán")) {
						cboTimXe.addItem(x.getMaXe()+" - "+x.getTenXe());
					}
				}
				
				txtMauXe.setText("");
				txtSoKhung.setText("");
				txtSoMay.setText("");
				txtHSX.setText("");
				txtLoaiXe.setText("");
				Date d = new Date();
				txtNgayLap.setDate(d);
				txtGiaNhap.setText("");
				XoaDL();
				for (HopDong hd : hopdong_dao.getAllHopDong()) {
					String tenKH = "";
					String cccd = "";
					String tenNV = "";
					String tenXe = "";
					for (KhachHang kh : dao_khachHang.getAllKH()) {
						if (kh.getMaKH().equalsIgnoreCase(hd.getKhachHang().getMaKH())) {
							tenKH = kh.getTenKH();
							cccd = kh.getcCCD();
						}
					}
					for (NhanVien nhanvien : daonhanvien.getAllNhanVien()) {
						if (nhanvien.getMaNV().equalsIgnoreCase(hd.getNhanVien().getMaNV())) {
							tenNV = nhanvien.getTenNV();
						}
					}
					for (Xe xe : dao_xe.getDanhSachXe()) {
						if (xe.getMaXe().equalsIgnoreCase(hd.getXe().getMaXe())) {
							tenXe = xe.getTenXe();
						}
					}
//					HangSanXuat hsx = daoHSX.getHSXTheoMa(xe.getHangSanXuat().getMaHangSX());
//					LoaiXe lx = daoLoaiXe.getLoaiXeTheoMa(xe.getLoaiXe().getMaLoaiXe());
					model.addRow(new Object[] {
							hd.getMaHopDong(),
							hd.getKhachHang().getMaKH(),tenKH,cccd,
							hd.getNhanVien().getMaNV(),tenNV,
							hd.getXe().getMaXe(),tenXe,
							hd.getNgayLapHopDong(),
							hd.getTrangThai()
					});
				}
			}
		});
		table.addMouseListener(new MouseListener() {
			
			private HangSanXuat_DAO daoHSX;
			private LoaiXe_DAO daoLoaiXe;

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int r = table.getSelectedRow();
				txtMaHopDong.setText(model.getValueAt(r, 0).toString());
				txtMaKH.setText(model.getValueAt(r, 1).toString());
				txtTenKH.setText(model.getValueAt(r, 2).toString());
				txtCCCD.setText(model.getValueAt(r, 3).toString());
				txtMaNV.setText(model.getValueAt(r, 4).toString());
				txtTenNV.setText(model.getValueAt(r, 5).toString());
				
				String ngayL = model.getValueAt(r, 8).toString();
				String nam = ngayL.substring(0, 4);
				String thang = ngayL.substring(5, 7);
				String ngay = ngayL.substring(8);
				Date demodate = new Date(Integer.parseInt(nam),Integer.parseInt(thang),Integer.parseInt(ngay));
				java.sql.Date dateLap = new java.sql.Date(demodate.getYear()-1900,demodate.getMonth()-1, demodate.getDate());
				txtNgayLap.setDate(dateLap);
				txtNgayLap.setDateFormatString("yyyy-MM-dd");
				
				cboTimKHCu.setSelectedItem(model.getValueAt(r, 3).toString());
				
				
				cboTimXe.setSelectedItem(model.getValueAt(r, 6).toString()+" - "+model.getValueAt(r, 7).toString());
				
				String ma = model.getValueAt(r, 6).toString();
				daoHSX = new HangSanXuat_DAO();
				daoLoaiXe = new LoaiXe_DAO();
				for (Xe xe : dao_xe.getDanhSachXe()) {
					HangSanXuat hsx = daoHSX.getHSXTheoMa(xe.getHangSanXuat().getMaHangSX());
					LoaiXe lx = daoLoaiXe.getLoaiXeTheoMa(xe.getLoaiXe().getMaLoaiXe());
					if (xe.getMaXe().equalsIgnoreCase(ma)) {
						txtMauXe.setText(xe.getMauXe());
						txtSoKhung.setText(xe.getSoKhung());
						txtSoMay.setText(xe.getSoMay());
						txtHSX.setText(hsx.getTenHangSX());
						txtLoaiXe.setText(lx.getTenLoaiXe());
						DecimalFormat cf = new DecimalFormat("###.0");
						txtGiaNhap.setText(cf.format(xe.getGiaXe()));
						
					}
				}
			}
		});
		btnXoaHopDong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int r = table.getSelectedRow();
				if (r == -1) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng cần xóa!");
				} else {
					if (model.getValueAt(r, 9).toString().equalsIgnoreCase("Chưa thanh toán")) {
						if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa hợp đồng này không?", "Cảnh báo", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
							hopdong_dao.delete(model.getValueAt(r, 0).toString());
							String trangthai = "Còn hàng";
							dao_xe.update(model.getValueAt(r, 6).toString(), trangthai);
							model.removeRow(r);
							JOptionPane.showMessageDialog(null, "Xóa thành công!");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Chỉ xóa được những hợp đồng chưa thanh toán!");
					}
				}
				
			}
		});
	}
	private void phatSinhMaHopDong() {
			
			if (hopdong_dao.getAllHopDong().isEmpty()) {
				txtMaHopDong.setText("HOPDONG0001");
			} else {
				
				String ma = hopdong_dao.getMaHDCuoi();
				String ma1 = ma.substring(0, 7);
				String ma2 = ma.substring(7);
				int ma3 = Integer.parseInt(ma2)+1;
				DecimalFormat df = new DecimalFormat("0000");
				txtMaHopDong.setText(ma1+df.format(ma3));
			}
			
		}
	private void XoaDL() {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.getDataVector().removeAllElements();
	}
}
