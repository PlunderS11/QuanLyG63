package app;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class FrameHoaDon extends JFrame{
	public FrameHoaDon() {
		setSize(1345, 705);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(166, 169, 248));
		getContentPane().setLayout(null);
		
		
		JLabel lblQunLHa = new JLabel("QUẢN LÝ HÓA ĐƠN");
		lblQunLHa.setHorizontalAlignment(SwingConstants.CENTER);
		lblQunLHa.setForeground(new Color(247, 237, 0));
		lblQunLHa.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblQunLHa.setBounds(10, 0, 1311, 47);
		getContentPane().add(lblQunLHa);
		
		JLabel lblNewLabel_1_3_7 = new JLabel("Ngày lập:");
		lblNewLabel_1_3_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3_7.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_3_7.setBounds(97, 560, 159, 30);
		getContentPane().add(lblNewLabel_1_3_7);
		
		txtNgayLap = new JDateChooser();
		txtNgayLap.setDateFormatString("yyyy-MM-dd");
		txtNgayLap.setBounds(266, 560, 351, 32);
		getContentPane().add(txtNgayLap);
		
		JLabel lblNewLabel_1_3_7_1 = new JLabel("Số lượng:");
		lblNewLabel_1_3_7_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_7_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3_7_1.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_3_7_1.setBounds(97, 604, 159, 30);
		getContentPane().add(lblNewLabel_1_3_7_1);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(266, 604, 351, 32);
		getContentPane().add(txtSoLuong);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(147, 112, 219));
		panel.setBounds(97, 45, 1135, 53);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Tìm kiếm hợp đồng:");
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_1_1.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_2_1_1.setBounds(10, 10, 168, 32);
		panel.add(lblNewLabel_1_2_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(177, 12, 839, 32);
		panel.add(comboBox);
		
		FixButton btnTimKH = new FixButton("Tìm");
		btnTimKH.setForeground(Color.WHITE);
		btnTimKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTimKH.setBackground(new Color(107, 96, 236));
		btnTimKH.setBounds(1026, 10, 99, 32);
		panel.add(btnTimKH);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(166, 169, 248));
		panel_2.setBorder(new TitledBorder(new TitledBorder(new LineBorder(Color.BLACK, 1, true), "Khách hàng",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0))));
		panel_2.setBounds(97, 112, 520, 276);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_3 = new JLabel("Mã khách hàng:");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_3.setBounds(10, 20, 159, 30);
		panel_2.add(lblNewLabel_1_3);
		
		txtMaKH = new JTextField();
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
		txtSDT.setEditable(false);
		txtSDT.setColumns(10);
		txtSDT.setBounds(179, 234, 331, 32);
		panel_2.add(txtSDT);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(712, 108, 520, 437);
		panel_3.setBackground(new Color(166, 169, 248));
		panel_3.setBorder(new TitledBorder(new TitledBorder(new LineBorder(Color.BLACK, 1, true), "Sản phẩm",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0))));
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1_3_8 = new JLabel("Mã sản phẩm:");
		lblNewLabel_1_3_8.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3_8.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_3_8.setBounds(10, 20, 159, 30);
		panel_3.add(lblNewLabel_1_3_8);
		
		txtMaXe = new JTextField();
		txtMaXe.setEditable(false);
		txtMaXe.setColumns(10);
		txtMaXe.setBounds(179, 20, 331, 32);
		panel_3.add(txtMaXe);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("Tên xe:");
		lblNewLabel_1_3_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3_1_1.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_3_1_1.setBounds(10, 82, 159, 30);
		panel_3.add(lblNewLabel_1_3_1_1);
		
		txtTenXe = new JTextField();
		txtTenXe.setEditable(false);
		txtTenXe.setColumns(10);
		txtTenXe.setBounds(179, 82, 331, 32);
		panel_3.add(txtTenXe);
		
		JLabel lblNewLabel_1_3_2_1 = new JLabel("Màu xe:");
		lblNewLabel_1_3_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3_2_1.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_3_2_1.setBounds(10, 144, 159, 30);
		panel_3.add(lblNewLabel_1_3_2_1);
		
		txtMauXe = new JTextField();
		txtMauXe.setEditable(false);
		txtMauXe.setColumns(10);
		txtMauXe.setBounds(179, 144, 331, 32);
		panel_3.add(txtMauXe);
		
		JLabel lblNewLabel_1_3_3_1 = new JLabel("Số khung:");
		lblNewLabel_1_3_3_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_3_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3_3_1.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_3_3_1.setBounds(10, 206, 159, 30);
		panel_3.add(lblNewLabel_1_3_3_1);
		
		txtSoKhung = new JTextField();
		txtSoKhung.setEditable(false);
		txtSoKhung.setColumns(10);
		txtSoKhung.setBounds(179, 206, 331, 32);
		panel_3.add(txtSoKhung);
		
		JLabel lblNewLabel_1_3_4_1 = new JLabel("Số máy:");
		lblNewLabel_1_3_4_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_4_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3_4_1.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_3_4_1.setBounds(10, 268, 159, 30);
		panel_3.add(lblNewLabel_1_3_4_1);
		
		txtSoMay = new JTextField();
		txtSoMay.setEditable(false);
		txtSoMay.setColumns(10);
		txtSoMay.setBounds(179, 268, 331, 32);
		panel_3.add(txtSoMay);
		
		JLabel lblNewLabel_1_3_5_1 = new JLabel("Loại xe:");
		lblNewLabel_1_3_5_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_5_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3_5_1.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_3_5_1.setBounds(10, 330, 159, 30);
		panel_3.add(lblNewLabel_1_3_5_1);
		
		txtLoaiXe = new JTextField();
		txtLoaiXe.setEditable(false);
		txtLoaiXe.setColumns(10);
		txtLoaiXe.setBounds(179, 330, 331, 32);
		panel_3.add(txtLoaiXe);
		
		JLabel lblNewLabel_1_3_6_1 = new JLabel("Hãng sản xuất:");
		lblNewLabel_1_3_6_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_6_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3_6_1.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_3_6_1.setBounds(10, 392, 159, 30);
		panel_3.add(lblNewLabel_1_3_6_1);
		
		txtHangSX = new JTextField();
		txtHangSX.setEditable(false);
		txtHangSX.setColumns(10);
		txtHangSX.setBounds(179, 392, 331, 32);
		panel_3.add(txtHangSX);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(97, 398, 520, 144);
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
		txtTenNV.setEditable(false);
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(179, 88, 331, 37);
		panel_4.add(txtTenNV);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(147, 112, 219));
		panel_1.setBounds(712, 557, 523, 79);
		getContentPane().add(panel_1);
		
		JLabel lblThnhTin = new JLabel("Thành tiền:");
		lblThnhTin.setHorizontalAlignment(SwingConstants.CENTER);
		lblThnhTin.setForeground(new Color(247, 237, 0));
		lblThnhTin.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblThnhTin.setBounds(0, 24, 139, 37);
		panel_1.add(lblThnhTin);
		
		JLabel lblThanhTien = new JLabel("...");
		lblThanhTien.setForeground(Color.BLACK);
		lblThanhTien.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblThanhTien.setBounds(140, 24, 237, 37);
		panel_1.add(lblThanhTien);
		
		FixButton btnThanhTien = new FixButton("Làm mới");
		btnThanhTien.setIcon(new ImageIcon("image\\thanhtoan.png"));
		btnThanhTien.setText("");
		btnThanhTien.setForeground(Color.WHITE);
		btnThanhTien.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThanhTien.setBackground(new Color(107, 96, 236));
		btnThanhTien.setBounds(383, 10, 60, 60);
		panel_1.add(btnThanhTien);
		
		FixButton btnXuat = new FixButton("Làm mới");
		btnXuat.setIcon(new ImageIcon("image\\xuatexcel.png"));
		btnXuat.setText("");
		btnXuat.setForeground(Color.WHITE);
		btnXuat.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXuat.setBackground(new Color(107, 96, 236));
		btnXuat.setBounds(453, 10, 60, 60);
		panel_1.add(btnXuat);

	}
	private JButton lbl;
	private JDateChooser txtNgayLap;
	private JTextField txtSoLuong;
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
	public JPanel createPanelHoaDon() {
		JPanel pnlContentPane = new JPanel();
		pnlContentPane.setBackground(Color.WHITE);
		setContentPane(pnlContentPane);
		pnlContentPane.add(lbl = new JButton("Gảgagag"));
		return pnlContentPane;
	}
	public static void main(String[] args) {
		new FrameHoaDon().setVisible(true);
	}
}
