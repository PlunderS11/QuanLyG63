package app;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class FrameHangSanXuat extends JFrame{
	private JTextField txtTimKiem;
	private JTextField txtMaHangXe;
	private JTextField txtTenHangXe;
	private JTextField textField;

	public FrameHangSanXuat() {
		// TODO Auto-generated constructor stub
		setSize(1345, 705);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(166, 169, 248));	
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		//panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(new Color(166, 169, 248));
		panel.setBounds(0, 0, 796, 136);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
		
		JLabel lblTimKiem = new JLabel("Tìm kiếm:");
		lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTimKiem.setBounds(213, 22, 91, 14);
		panel.add(lblTimKiem);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(314, 17, 270, 28);
		panel.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		JButton btnTimHX = new FixButton("Tìm");
		btnTimHX.setIcon(new ImageIcon("image\\timkiem.png"));
	
		
		btnTimHX.setForeground(Color.WHITE);
		btnTimHX.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTimHX.setBackground(new Color(107,96,236));
		btnTimHX.setBounds(605, 15, 99, 32);
		panel.add(btnTimHX);
		
		JLabel lblMaHangXe = new JLabel("Mã hãng xe:");
		lblMaHangXe.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMaHangXe.setBounds(53, 72, 104, 20);
		panel.add(lblMaHangXe);
		
		txtMaHangXe = new JTextField();
		txtMaHangXe.setBounds(154, 70, 214, 28);
		panel.add(txtMaHangXe);
		txtMaHangXe.setColumns(10);
		
		JLabel lblTenHangXe = new JLabel("Tên hãng xe:");
		lblTenHangXe.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTenHangXe.setBounds(414, 77, 116, 15);
		panel.add(lblTenHangXe);
		
		txtTenHangXe = new JTextField();
		txtTenHangXe.setBounds(528, 70, 214, 28);
		panel.add(txtTenHangXe);
		txtTenHangXe.setColumns(10);
		
		JLabel lblNguonGoc = new JLabel("Nguồn gốc:");
		lblNguonGoc.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNguonGoc.setBounds(261, 109, 99, 25);
		panel.add(lblNguonGoc);
		
		textField = new JTextField();
		textField.setBounds(370, 109, 214, 28);
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel pChucNang = new JPanel();
		pChucNang.setBounds(839, 11, 480, 86);
		pChucNang.setBackground(new Color(166, 169, 248));
		pChucNang.setBorder(new LineBorder(Color.BLACK));
		pChucNang.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1, true), "Chức năng",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(pChucNang);
		
		JButton btnThemHX = new FixButton("Thêm");
		
		btnThemHX.setIcon(new ImageIcon("image\\them.png"));
		
		btnThemHX.setForeground(Color.WHITE);
		btnThemHX.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThemHX.setBackground(new Color(107,96,236));
		btnThemHX.setBounds(0, 336, 115, 49);
		pChucNang.add(btnThemHX);
		
		JButton btnXoaHX = new FixButton("Xóa");
		btnXoaHX.setIcon(new ImageIcon("image\\xoa.png"));
		btnXoaHX.setForeground(Color.WHITE);
		btnXoaHX.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoaHX.setBackground(new Color(107,96,236));
		btnXoaHX.setBounds(125, 336, 109, 49);
		pChucNang.add(btnXoaHX);
		
		JButton btnSuaHX = new FixButton("Sửa");
	
		btnSuaHX.setIcon(new ImageIcon("image\\capnhat.png"));
		btnSuaHX.setForeground(Color.WHITE);
		btnSuaHX.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSuaHX.setBackground(new Color(107,96,236));
		btnSuaHX.setBounds(244, 336, 109, 49);
		pChucNang.add(btnSuaHX);
		
		JButton btnLamMoiHX = new FixButton("Làm mới");
		btnLamMoiHX.setIcon(new ImageIcon("image\\lammoi.png"));
		btnLamMoiHX.setForeground(Color.WHITE);
		btnLamMoiHX.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLamMoiHX.setBackground(new Color(107,96,236));
		btnLamMoiHX.setBounds(366, 336, 138, 49);
		pChucNang.add(btnLamMoiHX);
	}
}
