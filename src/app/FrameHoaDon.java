package app;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import connection.ConnectDB;
import dao.DAO_HopDong;
import dao.DAO_KhachHang;
import dao.HangSanXuat_DAO;
import dao.LoaiXe_DAO;
import dao.NhanVien_DAO;
import dao.Xe_DAO;
import entity.HangSanXuat;
import entity.HopDong;
import entity.KhachHang;
import entity.LoaiXe;
import entity.NhanVien;
import entity.Xe;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class FrameHoaDon extends JFrame{
	private DAO_HopDong dao_hopDong;
	private DAO_KhachHang dao_khachHang;
	private NhanVien_DAO dao_nhanvien;
	private Xe_DAO dao_xe;
	Locale localeVN = new Locale("vi", "VN");
    NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);

	public FrameHoaDon() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setSize(1345, 705);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(166, 169, 248));
		setResizable(false);
		getContentPane().setLayout(null);
		
		
		JLabel lblQunLHa = new JLabel("QUẢN LÝ HÓA ĐƠN");
		lblQunLHa.setHorizontalAlignment(SwingConstants.CENTER);
		lblQunLHa.setForeground(new Color(247, 237, 0));
		lblQunLHa.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblQunLHa.setBounds(10, 0, 1311, 47);
		getContentPane().add(lblQunLHa);
		
		JLabel lblNewLabel_1_3_7 = new JLabel("Ngày lập hóa đơn:");
		lblNewLabel_1_3_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3_7.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_3_7.setBounds(107, 615, 159, 37);
		getContentPane().add(lblNewLabel_1_3_7);
		
		txtNgayLap = new JDateChooser();
		txtNgayLap.setDateFormatString("yyyy-MM-dd");
		txtNgayLap.setBounds(276, 615, 331, 37);
		txtNgayLap.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNgayLap.setDate(new Date());
		getContentPane().add(txtNgayLap);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(147, 112, 219));
		panel.setBounds(97, 45, 989, 53);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Tìm kiếm hợp đồng:");
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_1_1.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_2_1_1.setBounds(10, 10, 168, 32);
		panel.add(lblNewLabel_1_2_1_1);
		
		JComboBox cboTimHopDong = new JComboBox();
		cboTimHopDong.setFont(new Font("Tahoma", Font.PLAIN, 16));
<<<<<<< HEAD
		cboTimHopDong.setBounds(177, 12, 839, 32);
		cboTimHopDong.setEditable(true);
=======
		cboTimHopDong.setBounds(177, 12, 693, 32);
>>>>>>> da4773c66b6af87c474578db3b66e7214c102baf
		cboTimHopDong.addItem("");
		panel.add(cboTimHopDong);
		
		FixButton btnTimHopDong = new FixButton("Tìm");
		
		btnTimHopDong.setIcon(new ImageIcon("image\\timkiem.png"));
		btnTimHopDong.setForeground(Color.WHITE);
		btnTimHopDong.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTimHopDong.setBackground(new Color(107, 96, 236));
		btnTimHopDong.setBounds(880, 10, 99, 32);
		panel.add(btnTimHopDong);
		
		dao_hopDong = new DAO_HopDong();
		dao_khachHang = new DAO_KhachHang();
		dao_nhanvien = new NhanVien_DAO();
		dao_xe =  new Xe_DAO();
		for (HopDong hopdong : dao_hopDong.getAllHopDong()) {
			String tenKH = "";
			String tenNV = "";
			String tenXe = "";
			for (KhachHang kh : dao_khachHang.getAllKH()) {
				if (kh.getMaKH().equalsIgnoreCase(hopdong.getKhachHang().getMaKH())) {
					tenKH = kh.getTenKH();
				}
			}
			for (NhanVien nhanvien : dao_nhanvien.getAllNhanVien()) {
				if (nhanvien.getMaNV().equalsIgnoreCase(hopdong.getNhanVien().getMaNV())) {
					tenNV = nhanvien.getTenNV();
				}
			}
			for (Xe xe : dao_xe.getDanhSachXe()) {
				if (xe.getMaXe().equalsIgnoreCase(hopdong.getXe().getMaXe())) {
					tenXe = xe.getTenXe();
				}
			}
			cboTimHopDong.addItem(hopdong.getMaHopDong()+" - "+hopdong.getKhachHang().getMaKH()+" - "+tenKH+" - "+hopdong.getNhanVien().getMaNV()+" - "+tenNV+" - "+hopdong.getXe().getMaXe()+" - "+tenXe+" ("+hopdong.getNgayLapHopDong()+")");
		}
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(166, 169, 248));
		panel_2.setBorder(new TitledBorder(new TitledBorder(new LineBorder(Color.BLACK, 1, true), "Khách hàng",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0))));
		panel_2.setBounds(97, 112, 520, 285);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_3 = new JLabel("Mã khách hàng:");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_3.setBounds(10, 20, 159, 30);
		panel_2.add(lblNewLabel_1_3);
		
		txtMaKH = new JTextField();
		txtMaKH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMaKH.setEditable(false);
		txtMaKH.setColumns(10);
		txtMaKH.setBounds(179, 18, 331, 32);
		panel_2.add(txtMaKH);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Tên khách hàng:");
		lblNewLabel_1_3_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3_1.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_3_1.setBounds(10, 74, 159, 30);
		panel_2.add(lblNewLabel_1_3_1);
		
		txtTenKH = new JTextField();
		txtTenKH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenKH.setEditable(false);
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(179, 72, 331, 32);
		panel_2.add(txtTenKH);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("CCCD:");
		lblNewLabel_1_3_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3_2.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_3_2.setBounds(10, 128, 159, 30);
		panel_2.add(lblNewLabel_1_3_2);
		
		txtCCCD = new JTextField();
		txtCCCD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCCCD.setEditable(false);
		txtCCCD.setColumns(10);
		txtCCCD.setBounds(179, 126, 331, 32);
		panel_2.add(txtCCCD);
		
		JLabel lblNewLabel_1_3_3 = new JLabel("Địa Chỉ:");
		lblNewLabel_1_3_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3_3.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_3_3.setBounds(10, 182, 159, 30);
		panel_2.add(lblNewLabel_1_3_3);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDiaChi.setEditable(false);
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(179, 180, 331, 32);
		panel_2.add(txtDiaChi);
		
		JLabel lblNewLabel_1_3_4 = new JLabel("Số điện thoại:");
		lblNewLabel_1_3_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3_4.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_3_4.setBounds(10, 236, 159, 30);
		panel_2.add(lblNewLabel_1_3_4);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSDT.setEditable(false);
		txtSDT.setColumns(10);
		txtSDT.setBounds(179, 234, 331, 32);
		panel_2.add(txtSDT);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(712, 108, 520, 454);
		panel_3.setBackground(new Color(166, 169, 248));
		panel_3.setBorder(new TitledBorder(new TitledBorder(new LineBorder(Color.BLACK, 1, true), "Sản phẩm",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0))));
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1_3_8 = new JLabel("Mã sản phẩm:");
		lblNewLabel_1_3_8.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3_8.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_3_8.setBounds(10, 22, 159, 30);
		panel_3.add(lblNewLabel_1_3_8);
		
		txtMaXe = new JTextField();
		txtMaXe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMaXe.setEditable(false);
		txtMaXe.setColumns(10);
		txtMaXe.setBounds(179, 20, 331, 32);
		panel_3.add(txtMaXe);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("Tên xe:");
		lblNewLabel_1_3_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3_1_1.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_3_1_1.setBounds(10, 78, 159, 30);
		panel_3.add(lblNewLabel_1_3_1_1);
		
		txtTenXe = new JTextField();
		txtTenXe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenXe.setEditable(false);
		txtTenXe.setColumns(10);
		txtTenXe.setBounds(179, 76, 331, 32);
		panel_3.add(txtTenXe);
		
		JLabel lblNewLabel_1_3_2_1 = new JLabel("Màu xe:");
		lblNewLabel_1_3_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3_2_1.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_3_2_1.setBounds(10, 134, 159, 30);
		panel_3.add(lblNewLabel_1_3_2_1);
		
		txtMauXe = new JTextField();
		txtMauXe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMauXe.setEditable(false);
		txtMauXe.setColumns(10);
		txtMauXe.setBounds(179, 132, 331, 32);
		panel_3.add(txtMauXe);
		
		JLabel lblNewLabel_1_3_3_1 = new JLabel("Số khung:");
		lblNewLabel_1_3_3_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_3_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3_3_1.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_3_3_1.setBounds(10, 190, 159, 30);
		panel_3.add(lblNewLabel_1_3_3_1);
		
		txtSoKhung = new JTextField();
		txtSoKhung.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSoKhung.setEditable(false);
		txtSoKhung.setColumns(10);
		txtSoKhung.setBounds(179, 188, 331, 32);
		panel_3.add(txtSoKhung);
		
		JLabel lblNewLabel_1_3_4_1 = new JLabel("Số máy:");
		lblNewLabel_1_3_4_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_4_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3_4_1.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_3_4_1.setBounds(10, 246, 159, 30);
		panel_3.add(lblNewLabel_1_3_4_1);
		
		txtSoMay = new JTextField();
		txtSoMay.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSoMay.setEditable(false);
		txtSoMay.setColumns(10);
		txtSoMay.setBounds(179, 244, 331, 32);
		panel_3.add(txtSoMay);
		
		JLabel lblNewLabel_1_3_5_1 = new JLabel("Loại xe:");
		lblNewLabel_1_3_5_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_5_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3_5_1.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_3_5_1.setBounds(10, 302, 159, 30);
		panel_3.add(lblNewLabel_1_3_5_1);
		
		txtLoaiXe = new JTextField();
		txtLoaiXe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtLoaiXe.setEditable(false);
		txtLoaiXe.setColumns(10);
		txtLoaiXe.setBounds(179, 300, 331, 32);
		panel_3.add(txtLoaiXe);
		
		JLabel lblNewLabel_1_3_6_1 = new JLabel("Hãng sản xuất:");
		lblNewLabel_1_3_6_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_6_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3_6_1.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_3_6_1.setBounds(10, 358, 159, 30);
		panel_3.add(lblNewLabel_1_3_6_1);
		
		txtHangSX = new JTextField();
		txtHangSX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtHangSX.setEditable(false);
		txtHangSX.setColumns(10);
		txtHangSX.setBounds(179, 356, 331, 32);
		panel_3.add(txtHangSX);
		
		txtGiaXe = new JTextField();
		txtGiaXe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtGiaXe.setEditable(false);
		txtGiaXe.setColumns(10);
		txtGiaXe.setBounds(179, 412, 331, 32);
		panel_3.add(txtGiaXe);
		
		JLabel lblNewLabel_1_3_6_1_1 = new JLabel("Giá xe:");
		lblNewLabel_1_3_6_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_6_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3_6_1_1.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_3_6_1_1.setBounds(10, 414, 159, 30);
		panel_3.add(lblNewLabel_1_3_6_1_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(97, 418, 520, 144);
		panel_4.setBackground(new Color(166, 170, 248));
		panel_4.setBorder(new TitledBorder(new TitledBorder(new LineBorder(Color.BLACK, 1, true), "Nhân viên",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0))));
		getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1_3_5 = new JLabel("Mã nhân viên:");
		lblNewLabel_1_3_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3_5.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_3_5.setBounds(10, 22, 159, 35);
		panel_4.add(lblNewLabel_1_3_5);
		
		
		
		txtMaNV = new JTextField();
		txtMaNV.setToolTipText("");
		txtMaNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMaNV.setEditable(false);
		txtMaNV.setColumns(10);
		txtMaNV.setBounds(179, 20, 331, 37);
		panel_4.add(txtMaNV);
		
		JLabel lblNewLabel_1_3_6 = new JLabel("Tên nhân viên:");
		lblNewLabel_1_3_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3_6.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_3_6.setBounds(10, 90, 159, 35);
		panel_4.add(lblNewLabel_1_3_6);
		
		txtTenNV = new JTextField();
		txtTenNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenNV.setEditable(false);
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(179, 88, 331, 37);
		panel_4.add(txtTenNV);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(147, 112, 219));
		panel_1.setBounds(712, 572, 523, 79);
		getContentPane().add(panel_1);
		
		JLabel lblThnhTin = new JLabel("Thành tiền:");
		lblThnhTin.setHorizontalAlignment(SwingConstants.CENTER);
		lblThnhTin.setForeground(new Color(247, 237, 0));
		lblThnhTin.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblThnhTin.setBounds(0, 24, 139, 37);
		panel_1.add(lblThnhTin);
		
		JLabel lblThanhTien = new JLabel("...");
		lblThanhTien.setToolTipText("Đã bao gồm 5% giá trị thuế VAT");
		lblThanhTien.setForeground(new Color(247, 237, 0));
		lblThanhTien.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblThanhTien.setBounds(140, 24, 237, 37);
		
		panel_1.add(lblThanhTien);
		
		FixButton btnThanhTien = new FixButton();
		btnThanhTien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtGiaXe.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin trước khi tính thành tiền!");
				} else {
					double giaXe = Double.parseDouble(txtGiaXe.getText());
					double thanhTien = giaXe + giaXe*5/100;
					lblThanhTien.setText(currencyVN.format(thanhTien));
				}
			}
		});
		btnThanhTien.setIcon(new ImageIcon("image\\thanhtoan.png"));
		btnThanhTien.setText("");
		btnThanhTien.setForeground(Color.WHITE);
		btnThanhTien.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThanhTien.setBackground(new Color(107, 96, 236));
		btnThanhTien.setBounds(383, 10, 60, 60);
		panel_1.add(btnThanhTien);
		
		FixButton btnXuat = new FixButton();
		btnXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ma = cboTimHopDong.getSelectedItem().toString().substring(0,11);
//				String tenKH = (dao_khachHang.getKHtheoMaHopDong(ma)).getTenKH();
//				String tenNV = (dao_nhanvien.getNVtheoMaHopDong(ma)).getTenNV();
//				String tenXe = (dao_xe.getXeTheoMaHopDong(ma)).getTenXe();
//				String mauXe = (dao_xe.getXeTheoMaHopDong(ma)).getMauXe();
//				String soKhung = (dao_xe.getXeTheoMaHopDong(ma)).getSoKhung();
//				String soMay = (dao_xe.getXeTheoMaHopDong(ma)).getSoMay();
//				String loaiXe = (dao_xe.getXeTheoMaHopDong(ma)).getLoaiXe().getTenLoaiXe();
//				String hang = (dao_xe.getXeTheoMaHopDong(ma)).getHangSanXuat().getTenHangSX();
//				double tien = (dao_xe.getXeTheoMaHopDong(ma)).getGiaXe();
				String tenKH = txtTenKH.getText();
				String tenNV = txtTenNV.getText();
				Date ngay = txtNgayLap.getDate();
				java.sql.Date ngayLap = new java.sql.Date(ngay.getYear(), ngay.getMonth(), ngay.getDate());
				String tenXe = txtTenXe.getText();
				String mauXe = txtMauXe.getText();
				String soKhung = txtSoKhung.getText();
				String soMay = txtSoMay.getText();
				String loaiXe = txtLoaiXe.getText();
				String hang = txtHangSX.getText();
				double tien = Double.parseDouble(txtGiaXe.getText());
				double tong = tien + tien*5/100;
				new FrameHoaDonTinhTien(tenKH, tenNV, ngayLap, 
						tenXe, mauXe, soKhung, soMay, loaiXe, hang, tien, tong).setVisible(true);
			}
		});
		btnXuat.setIcon(new ImageIcon("image\\xuatexcel.png"));
		btnXuat.setText("");
		btnXuat.setForeground(Color.WHITE);
		btnXuat.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXuat.setBackground(new Color(107, 96, 236));
		btnXuat.setBounds(453, 10, 60, 60);
		panel_1.add(btnXuat);
		
		FixButton btnLamMoiKH = new FixButton("Làm mới");
		btnLamMoiKH.setIcon(new ImageIcon("image\\lammoi.png"));
		btnLamMoiKH.setForeground(Color.WHITE);
		btnLamMoiKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLamMoiKH.setBackground(new Color(107, 96, 236));
		btnLamMoiKH.setBounds(1096, 49, 136, 49);
		getContentPane().add(btnLamMoiKH);
		
		JLabel lblNewLabel_1_3_6_2 = new JLabel("Mã hóa đơn:");
		lblNewLabel_1_3_6_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_6_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3_6_2.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_3_6_2.setBounds(108, 572, 159, 35);
		getContentPane().add(lblNewLabel_1_3_6_2);
		
		txtMaHoaDon = new JTextField();
		txtMaHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMaHoaDon.setEditable(false);
		txtMaHoaDon.setColumns(10);
		txtMaHoaDon.setBounds(277, 570, 331, 37);
		getContentPane().add(txtMaHoaDon);
		btnTimHopDong.addActionListener(new ActionListener() {
			private LoaiXe_DAO daoloaixe;
			private HangSanXuat_DAO daohsx;

			public void actionPerformed(ActionEvent e) {
				if (cboTimHopDong.getSelectedItem().toString().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn hợp đồng!");
				} else {
					String ma = cboTimHopDong.getSelectedItem().toString().substring(0,11);
					for (HopDong hopdong : dao_hopDong.getAllHopDong()) {
						if (hopdong.getMaHopDong().equalsIgnoreCase(ma)) {
							String maKH = hopdong.getKhachHang().getMaKH();
							String maNV = hopdong.getNhanVien().getMaNV();
							String maXe = hopdong.getXe().getMaXe();
							for (KhachHang kh : dao_khachHang.getAllKH()) {
								if (kh.getMaKH().equalsIgnoreCase(maKH)) {
									txtMaKH.setText(kh.getMaKH());
									txtTenKH.setText(kh.getTenKH());
									txtCCCD.setText(kh.getcCCD());
									txtDiaChi.setText(kh.getDiaChi());
									txtSDT.setText(kh.getsDT());
								}
							}
							for (NhanVien nhanvien : dao_nhanvien.getAllNhanVien()) {
								if (nhanvien.getMaNV().equalsIgnoreCase(maNV)) {
									txtMaNV.setText(nhanvien.getMaNV());
									txtTenNV.setText(nhanvien.getTenNV());
								}
							}
							for (Xe xe : dao_xe.getDanhSachXe()) {
								if (xe.getMaXe().equalsIgnoreCase(maXe)) {
									txtMaXe.setText(xe.getMaXe());
									txtTenXe.setText(xe.getTenXe());
									txtMauXe.setText(xe.getMauXe());
									txtSoKhung.setText(xe.getSoKhung());
									txtSoMay.setText(xe.getSoMay());
									
									daoloaixe = new LoaiXe_DAO();
									daohsx = new HangSanXuat_DAO();
									
									LoaiXe lx = daoloaixe.getLoaiXeTheoMa(xe.getLoaiXe().getMaLoaiXe());
									txtLoaiXe.setText(lx.getTenLoaiXe());
									
									HangSanXuat hsx = daohsx.getHSXTheoMa(xe.getHangSanXuat().getMaHangSX());
									txtHangSX.setText(hsx.getTenHangSX());
									DecimalFormat cd = new DecimalFormat("###.0");
									txtGiaXe.setText(cd.format(xe.getGiaXe()));
								}
							}
						}
					}
				}
				
			}
		});
		btnLamMoiKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cboTimHopDong.setSelectedIndex(0);
				txtNgayLap.setDate(null);
				txtMaKH.setText("");
				txtTenKH.setText("");
				txtCCCD.setText("");
				txtDiaChi.setText("");
				txtSDT.setText("");
				
				txtMaNV.setText("");
				txtTenNV.setText("");
				
				txtMaXe.setText("");
				txtTenXe.setText("");
				txtMauXe.setText("");
				txtSoKhung.setText("");
				txtSoMay.setText("");
				txtLoaiXe.setText("");
				txtHangSX.setText("");
				txtGiaXe.setText("");
				
				lblThanhTien.setText("...");
			}
		});
	}
	private JButton lbl;
	private JDateChooser txtNgayLap;
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtCCCD;
	private JTextField txtDiaChi;
	private JTextField txtSDT;
	private JTextField txtMaXe;
	private JTextField txtTenXe;
	private JTextField txtMauXe;
	private JTextField txtSoKhung;
	private JTextField txtSoMay;
	private JTextField txtLoaiXe;
	private JTextField txtHangSX;
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	private JTextField txtGiaXe;
	private JTextField txtMaHoaDon;
	public JPanel createPanelHoaDon() {
		JPanel pnlContentPane = new JPanel();
		pnlContentPane.setBackground(Color.WHITE);
		setContentPane(pnlContentPane);
		
		return pnlContentPane;
	}
	
	public static void main(String[] args) {
		new FrameHoaDon().setVisible(true);
	}
}
