package app;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

import connection.ConnectDB;
import dao.TrangChu_DAO;
import entity.NhanVien;

public class FrameTrangChu extends JFrame implements ActionListener, MouseListener{
	
	private FixButton lblDoiMK;
	private FixButton lblDangXuat;
	private TrangChu_DAO trangchu_dao;
	private JLabel lblTenNVHienTai;
	private JLabel lblMaNVHienTai;
	private JLabel txtNgayHienTai;
	private SimpleDateFormat timeFormat;
	private JLabel lblTime;
	private String time;
	private Calendar calendar;
	public FrameTrangChu() throws ParseException {
		
		//Khởi tạo kết nối đến CSDL
		try {
			ConnectDB.getInstance().connect();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		trangchu_dao = new TrangChu_DAO();
		//---------------------------------
		
		setTitle("QUANLYG63");
		setSize(1550, 839);
//		setExtendedState(JFrame.MAXIMIZED_BOTH);
//		setSize(1000, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		//setResizable(false);
		UIManager.put("TabbedPane.selected", new Color(200,191,231));
		getContentPane().add(pnlHeader(), BorderLayout.NORTH);
		getContentPane().add(createTabbedPane());
	}
	private JPanel pnlHeader() {
		JPanel pnlHeader = new JPanel();
		pnlHeader.setPreferredSize(new Dimension(300,120));
		pnlHeader.setLayout(null);
		pnlHeader.setBackground(new Color(79, 12, 132));
		ImageIcon icon = new ImageIcon("image/Logo.jfif");
		JLabel lblHeader = new JLabel(icon);
		lblHeader.setBounds(15, 2, icon.getIconWidth(), icon.getIconHeight());
		pnlHeader.add(lblHeader);
		
		JPanel pnlThoiGian = new JPanel();
		pnlThoiGian.setPreferredSize(new Dimension(100, 120));
		pnlThoiGian.setLayout(null);
		pnlThoiGian.setBackground(new Color(79, 12, 132));
		pnlThoiGian.setBounds(430, 10, 380, 110);
		pnlHeader.add(pnlThoiGian);
		
		JLabel lblNgayHienTai = new JLabel("Hiện tại:");
		lblNgayHienTai.setFont(new Font("Arial", Font.BOLD, 35));
		lblNgayHienTai.setForeground(new Color(0x00FF00));
		lblNgayHienTai.setBounds(20, -10, 150, 100);
		pnlThoiGian.add(lblNgayHienTai);
		
		txtNgayHienTai = new JLabel();
		txtNgayHienTai.setFont(new Font("Arial", Font.BOLD, 35));
		txtNgayHienTai.setForeground(new Color(0x00FF00));
		txtNgayHienTai.setBounds(170, -10, 200, 100);
		Date ngayHienTai = new Date();
		DateFormat dateFormat = null;
        dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String ngay = dateFormat.format(ngayHienTai);
        txtNgayHienTai.setText(ngay);
		pnlThoiGian.add(txtNgayHienTai);
		
		lblTime = new JLabel();
		lblTime.setFont(new Font("Arial", Font.BOLD, 28));
		lblTime.setForeground(new Color(0x00FF00));
		lblTime.setBounds(20, 30, 300, 100);
		layThoiGian();
		pnlThoiGian.add(lblTime);
		
		ImageIcon iconNV = new ImageIcon("image/image002.png");
		JLabel lbliconNV = new JLabel(iconNV);
		lbliconNV.setBounds(880, -15, 150, 150);
		pnlHeader.add(lbliconNV);
		
		lblTenNVHienTai = new JLabel();
		lblTenNVHienTai.setFont(new Font("Arial", Font.BOLD, 20));
		lblTenNVHienTai.setForeground(Color.WHITE);
		lblTenNVHienTai.setBounds(1000, 5, 400, 100);
		NhanVien nv = trangchu_dao.getNhanVienSuDung(NewSignin.getTaiKhoan());
		lblTenNVHienTai.setText(nv.getTenNV());
		pnlHeader.add(lblTenNVHienTai);
		
		lblMaNVHienTai = new JLabel();
		lblMaNVHienTai.setFont(new Font("Arial", Font.BOLD, 20));
		lblMaNVHienTai.setForeground(Color.WHITE);
		lblMaNVHienTai.setBounds(1000, 30, 200, 100);
		lblMaNVHienTai.setText(nv.getMaNV());
		pnlHeader.add(lblMaNVHienTai);
		
		lblDoiMK = new FixButton("ĐỔI MẬT KHẨU");
		lblDoiMK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FrameDoiMatKhau doimk = new FrameDoiMatKhau();
				doimk.setVisible(true);
				
				doimk.setLocationRelativeTo(null);
				
			}
		});
		lblDoiMK.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblDoiMK.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDoiMK.setForeground(Color.WHITE);
		lblDoiMK.setBounds(1350, 15, 160, 30);
		pnlHeader.add(lblDoiMK);

		lblDangXuat = new FixButton("ĐĂNG XUẤT");
		lblDangXuat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn đăng xuất?", "?!", 
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
					
					NewSignin ns = new NewSignin();
					ns.setVisible(true);
					ns.setLocationRelativeTo(null);
					dispose();
				}
			}
		});
		lblDangXuat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblDangXuat.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDangXuat.setForeground(Color.WHITE);
		lblDangXuat.setBounds(1350, 55, 160, 30);
		pnlHeader.add(lblDangXuat);

		return pnlHeader;
	}
	
	private JTabbedPane createTabbedPane() throws ParseException {
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setUI(new BasicTabbedPaneUI() {
			@Override
			protected int calculateTabHeight(int tabPlacement, int tabIndex, int fontHeight) {
				return 96;
			}
			@Override
			protected int calculateTabWidth(int tabPlacement, int tabIndex, FontMetrics metrics) {
				return 200;
			}
		});
		tabbedPane.setBackground(new Color(79, 12, 132));
		tabbedPane.setForeground(Color.WHITE);
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 17));

		FrameKhachHang frameKH = new FrameKhachHang();
		FrameNhanVien frameNV = new FrameNhanVien();
		FrameHopDong frameHopDong = new FrameHopDong();
		FrameHoaDon frameHD = new FrameHoaDon();
		FrameThongKe frameTK = new FrameThongKe();

		JPanel pnlTrangChu = createPanelTrangChu();
		JPanel pnlKhachHang = (JPanel) frameKH.getContentPane();
		JPanel pnlNhanVien = (JPanel) frameNV.getContentPane();
		JPanel pnlHopDong = (JPanel) frameHopDong.getContentPane();
		JPanel pnlHoaDon = (JPanel) frameHD.getContentPane();
		JPanel pnlThongKe = (JPanel) frameTK.getContentPane();
		
		JTabbedPane tabHangHoa = new JTabbedPane();
		tabHangHoa.setBackground(new Color(79, 12, 132));
		tabHangHoa.setForeground(Color.WHITE);
		tabHangHoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		FrameXe  frameXe = new FrameXe();
		FrameLoaiXe frameLoaiXe = new FrameLoaiXe();
		FrameHangSanXuat frameHangSX = new FrameHangSanXuat();
		JPanel pnlXe = (JPanel) frameXe.getContentPane();
		JPanel pnlLoaiXe = (JPanel) frameLoaiXe.getContentPane();
		JPanel pnlHangSX =(JPanel) frameHangSX.getContentPane();
		

		
		tabHangHoa.addTab("XE", new ImageIcon("image/xe.png"), pnlXe, "Xe");
		tabHangHoa.addTab("LOẠI XE", new ImageIcon("image/loaixe.png"), pnlLoaiXe, "LOẠI XE");
		tabHangHoa.addTab("HÃNG SẢN XUẤT", new ImageIcon("image/hangsx.png"), pnlHangSX, "HÃNG SẢN XUẤT");

			
		/* add tab with JPanel */
		tabbedPane.addTab("TRANG CHỦ", new ImageIcon("image/trangchu.png"), pnlTrangChu, "Giới thiệu sơ lược về cửa hàng");
		tabbedPane.addTab("KHÁCH HÀNG", new ImageIcon("image/khachhang.png"), pnlKhachHang, "Gồm các thông tin của khách hàng");
		tabbedPane.addTab("NHÂN VIÊN", new ImageIcon("image/nhanvien.png"), pnlNhanVien, "Gồm các thông tin của nhân viên");
		tabbedPane.addTab("HÀNG HÓA", new ImageIcon("image/hanghoa.png"), tabHangHoa, "Gồm các thông tin của hàng hóa");
		tabbedPane.addTab("HỢP ĐỒNG", new ImageIcon("image/hopdong.png"), pnlHopDong, "Gồm các thông tin của hợp đồng");
		tabbedPane.addTab("HÓA ĐƠN", new ImageIcon("image/hoadon.png"), pnlHoaDon, "Hiển thị hóa đơn và thanh toán");
		tabbedPane.addTab("THỐNG KÊ", new ImageIcon("image/thongke.png"), pnlThongKe, "Thống kê các khoảng doanh thu");

		return tabbedPane;
	}
	private JPanel createPanelTrangChu() {
		JPanel pnlContentPane = new JPanel();
		pnlContentPane.setLayout(null);
		JLabel lblBackground = new JLabel();
		lblBackground.setBounds(0, 0, 1345, 705);
		lblBackground.setIcon(new ImageIcon("image/bg.jpg"));
		lblBackground.setLayout(null);
		pnlContentPane.add(lblBackground);
		/*intro*/
		ImageIcon icon1 = new ImageIcon("image/dienthoai.png");
		Image logo1 = icon1.getImage();
		Image logo1Resize = logo1.getScaledInstance(32, 32, Image.SCALE_SMOOTH);
		JLabel lblLogo1 = new JLabel(new ImageIcon(logo1Resize));
		lblLogo1.setBounds(30, 614, 32, 32);
		lblBackground.add(lblLogo1);
		JLabel lblLienhe = new JLabel("Booking: (083)11223344");
		lblLienhe.setBounds(70, 580, 500, 100);
		lblLienhe.setFont(new Font("DialogInput", Font.BOLD, 25));
		lblLienhe.setForeground(Color.WHITE);
		lblBackground.add(lblLienhe);

		ImageIcon icon2 = new ImageIcon("image/hotline.png");
		Image logo2 = icon2.getImage();
		Image logo2Resize = logo2.getScaledInstance(32, 32, Image.SCALE_SMOOTH);
		JLabel lblLogo2 = new JLabel(new ImageIcon(logo2Resize));
		lblLogo2.setBounds(30, 574, 32, 32);
		lblBackground.add(lblLogo2);
		JLabel lblLienhe2 = new JLabel("Hotline: 0888244212");
		lblLienhe2.setBounds(70, 540, 500, 100);
		lblLienhe2.setFont(new Font("DialogInput", Font.BOLD, 25));
		lblLienhe2.setForeground(Color.WHITE);
		lblBackground.add(lblLienhe2);

		ImageIcon icon3 = new ImageIcon("image/diachi.png");
		Image logo3 = icon3.getImage();
		Image logo3Resize = logo3.getScaledInstance(32, 32, Image.SCALE_SMOOTH);
		JLabel lblLogo3 = new JLabel(new ImageIcon(logo3Resize));
		lblLogo3.setBounds(30, 534, 32, 32);
		lblBackground.add(lblLogo3);
		JLabel lblLienhe3 = new JLabel("Address: 12 Nguyễn Văn Bảo, Phường 4, Gò Vấp, TP.Hồ Chí Minh");
		lblLienhe3.setBounds(70, 500, 900, 100);
		lblLienhe3.setFont(new Font("DialogInput", Font.BOLD, 25));
		lblLienhe3.setForeground(Color.WHITE);
		lblBackground.add(lblLienhe3);
		return pnlContentPane;
	}
	public void layThoiGian() {
		Thread layThoiGian = new Thread() {
			public void run() {
				try {
					for(;;) {
						timeFormat = new SimpleDateFormat("hh:mm:ss a");
						lblTime.setText("Time: "+timeFormat.format(Calendar.getInstance().getTime()));
						sleep(1000);
					}
				}catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		};
		layThoiGian.start();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

