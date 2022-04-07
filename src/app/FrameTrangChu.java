package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.text.ParseException;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

public class FrameTrangChu extends JFrame{
	
	public FrameTrangChu() throws ParseException {
		setTitle("KARAOKE DIAMOND");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setSize(1000, 800);
		setLocationRelativeTo(null);
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
		
		JLabel lblNgayHienTai = new JLabel("Hiện tại:");
		lblNgayHienTai.setFont(new Font("Arial", Font.BOLD, 40));
		lblNgayHienTai.setForeground(Color.WHITE);
		lblNgayHienTai.setBounds(650, 15, 200, 100);
		pnlHeader.add(lblNgayHienTai);
		
		JLabel lblTenNVHienTai = new JLabel("-tenNV-");
		lblTenNVHienTai.setFont(new Font("Arial", Font.BOLD, 30));
		lblTenNVHienTai.setForeground(Color.WHITE);
		lblTenNVHienTai.setBounds(1400, 5, 200, 100);
		pnlHeader.add(lblTenNVHienTai);
		
		JLabel lblMaNVHienTai = new JLabel("-MaNV-");
		lblMaNVHienTai.setFont(new Font("Arial", Font.BOLD, 30));
		lblMaNVHienTai.setForeground(Color.WHITE);
		lblMaNVHienTai.setBounds(1400, 50, 200, 100);
		pnlHeader.add(lblMaNVHienTai);
		
		JButton btnDangXuat = new JButton("Đăng Xuất");
		btnDangXuat.setBackground(new Color(236, 43, 43));
		btnDangXuat.setForeground(Color.WHITE);
		btnDangXuat.setBounds(1800, 30, 100, 35);
		pnlHeader.add(btnDangXuat);

		return pnlHeader;
	}
	
	private JTabbedPane createTabbedPane() throws ParseException {
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setUI(new BasicTabbedPaneUI() {
			@Override
			protected int calculateTabHeight(int tabPlacement, int tabIndex, int fontHeight) {
				return 80;
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
		JPanel pnlKhachHang = frameKH.createPanelKhachHang();
		JPanel pnlNhanVien = frameNV.createPanelNhanVien();
		JPanel pnlHopDong = frameHopDong.createPanelHopDong();
		JPanel pnlHoaDon = frameHD.createPanelHoaDon();
		JPanel pnlThongKe = frameTK.createPanelThongKe();
		
		JTabbedPane tabHangHoa = new JTabbedPane();
		tabHangHoa.setBackground(new Color(79, 12, 132));
		tabHangHoa.setForeground(Color.WHITE);
		tabHangHoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		FrameXe frameXe = new FrameXe();
		FrameLoaiXe frameLoaiXe = new FrameLoaiXe();
		FrameHangSanXuat frameHangSX = new FrameHangSanXuat();
		JPanel pnlXe = frameXe.createPanelXe();
		JPanel pnlLoaiXe = frameLoaiXe.createPanelLoaiXe();
		JPanel pnlHangSX = frameHangSX.createPanelHangSX();
		
		tabHangHoa.addTab("XE", new ImageIcon("image/doanhthu.png"), pnlXe, "Xe");
		tabHangHoa.addTab("LOẠI XE", new ImageIcon("image/khachhang.png"), pnlLoaiXe, "LOẠI XE");
		tabHangHoa.addTab("HÃNG SẢN XUẤT", new ImageIcon("image/khachhang.png"), pnlHangSX, "HÃNG SẢN XUẤT");

			
		/* add tab with JPanel */
		tabbedPane.addTab("TRANG CHỦ", new ImageIcon("image/trangchu.png"), pnlTrangChu, "TRANG CHỦ");
		tabbedPane.addTab("KHÁCH HÀNG", new ImageIcon("image/khachhang.png"), pnlKhachHang, "KHÁCH HÀNG");
		tabbedPane.addTab("NHÂN VIÊN", new ImageIcon("image/nhanvien.png"), pnlNhanVien, "NHÂN VIÊN");
		tabbedPane.addTab("HÀNG HÓA", new ImageIcon("image/hanghoa.png"), tabHangHoa, "HÀNG HÓA");
		tabbedPane.addTab("HỢP ĐỒNG", new ImageIcon("image/hopdong.png"), pnlHopDong, "HỢP ĐÔNG");
		tabbedPane.addTab("HÓA ĐƠN", new ImageIcon("image/thongke.png"), pnlHoaDon, "HÓA ĐƠN");
		tabbedPane.addTab("THỐNG KÊ", new ImageIcon("image/thongke.png"), pnlThongKe, "THỐNG KÊ");

		return tabbedPane;
	}
	private JPanel createPanelTrangChu() {
		JPanel pnlContentPane = new JPanel();
		pnlContentPane.setBackground(new Color(204, 0, 0));
		pnlContentPane.setLayout(null);
		
		return pnlContentPane;
	}
	public static void main(String[] args) throws ParseException {
		new FrameTrangChu().setVisible(true);
	}
}
