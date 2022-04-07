package app;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class FrameXe extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	public FrameXe() {
		setSize(1345, 705);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(166, 169, 248));	
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(new Color(166, 169, 248));
		panel.setBounds(0, 0, 506, 668);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblMaXe = new JLabel("Mã xe:");
		lblMaXe.setBounds(10, 23, 46, 14);
		panel.add(lblMaXe);
		
		textField = new JTextField();
		textField.setBounds(66, 20, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblTenXe = new JLabel("Tên xe:");
		lblTenXe.setBounds(10, 61, 46, 14);
		panel.add(lblTenXe);
		
		textField_1 = new JTextField();
		textField_1.setBounds(66, 58, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblMauXe = new JLabel("Màu xe:");
		lblMauXe.setBounds(10, 95, 46, 14);
		panel.add(lblMauXe);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(66, 92, 86, 20);
		panel.add(comboBox);
		
		JLabel lblSoKhung = new JLabel("Số khung:");
		lblSoKhung.setBounds(10, 126, 46, 14);
		panel.add(lblSoKhung);
		
		textField_2 = new JTextField();
		textField_2.setBounds(66, 123, 86, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblSoMay = new JLabel("Số máy:");
		lblSoMay.setBounds(10, 151, 46, 14);
		panel.add(lblSoMay);
		
		textField_3 = new JTextField();
		textField_3.setBounds(66, 148, 86, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNhaCungCap = new JLabel("Nhà cung cấp:");
		lblNhaCungCap.setBounds(173, 23, 46, 14);
		panel.add(lblNhaCungCap);
		
		textField_4 = new JTextField();
		textField_4.setBounds(229, 20, 86, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblHangSanXuat = new JLabel("Hãng sản xuất");
		lblHangSanXuat.setBounds(173, 61, 46, 14);
		panel.add(lblHangSanXuat);
		
		textField_5 = new JTextField();
		textField_5.setBounds(229, 58, 86, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblLoaiXe = new JLabel("Loại xe:");
		lblLoaiXe.setBounds(173, 95, 46, 14);
		panel.add(lblLoaiXe);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(229, 92, 86, 20);
		panel.add(comboBox_1);
		
		JLabel lblGiaNhap = new JLabel("Giá nhập:");
		lblGiaNhap.setBounds(173, 126, 46, 14);
		panel.add(lblGiaNhap);
		
		textField_6 = new JTextField();
		textField_6.setBounds(229, 123, 86, 20);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblTrangThai = new JLabel("Trạng thái:");
		lblTrangThai.setBounds(173, 151, 46, 14);
		panel.add(lblTrangThai);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(229, 148, 86, 20);
		panel.add(comboBox_2);
		
		
		
	}
	
	public JPanel createPanelXe() {
		JPanel pnlContentPane = new JPanel();
		pnlContentPane.setBackground(Color.WHITE);
		setContentPane(pnlContentPane);
		return pnlContentPane;
	}
	
	public static void main(String[] args) {
		new FrameXe().setVisible(true);
	}
}
