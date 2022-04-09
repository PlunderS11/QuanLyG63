package app;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import com.toedter.calendar.JDateChooser;

public class FrameNhanVien extends JFrame{
	
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	
	private JTextField txtDiaChi;
	private JTextField txtSoDT;
	private JTextField txtCCCD;
	private JRadioButton radMaleNV;
	private JRadioButton radFemaleNV;
	private JButton btnThemNV;
	private JButton btnXoaNV;
	private JButton btnSuaNV;
	private JButton btnLamMoiNV;
	private JComboBox cbbChucVu;
	private JTextField txtTimNV;
	private JButton btnTimNV;
	private JTable table;
	private JDateChooser txtNgaySinh;
	public FrameNhanVien() {
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
		
		JLabel lblNewLabel = new JLabel("THÔNG TIN NHÂN VIÊN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(247,237,0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 10, 486, 37);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã nhân viên:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBackground(new Color(166, 169, 248));
		lblNewLabel_1.setBounds(64, 60, 159, 20);
		panel.add(lblNewLabel_1);
		
		
		txtMaNV = new JTextField();
		txtMaNV.setColumns(10);
		txtMaNV.setBounds(236, 57, 214, 32);
		panel.add(txtMaNV);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên nhân viên:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_1.setBounds(64, 102, 159, 20);
		panel.add(lblNewLabel_1_1);
		
		txtTenNV = new JTextField();
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(236, 99, 214, 32);
		panel.add(txtTenNV);
		
		JLabel lblNewLabel_1_2 = new JLabel("Chức vụ:");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_2.setBounds(64, 147, 159, 20);
		panel.add(lblNewLabel_1_2);
		
//		String[] chucVu = {"Quản lí","Nhân viên bán hàng"};
//		cbbChucVu = new JComboBox<>(chucVu);
//		cbbChucVu.setBounds(231, 176, 214, 32);
//		cbbChucVu.setBackground(Color.WHITE);
//		panel.add(cbbChucVu);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Ngày sinh:");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_1.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_2_1.setBounds(64, 186, 159, 20);
		panel.add(lblNewLabel_1_2_1);
		
		txtNgaySinh = new JDateChooser();
		//txtNgaySinh.setColumns(10);
		txtNgaySinh.setDateFormatString("yyyy-MM-dd");
		txtNgaySinh.setBounds(236, 183, 214, 32);
		panel.add(txtNgaySinh);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Địa chỉ:");
		lblNewLabel_1_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_2.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_2_2.setBounds(64, 228, 159, 20);
		panel.add(lblNewLabel_1_2_2);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(236, 225, 214, 32);
		panel.add(txtDiaChi);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Số điện thoại:");
		lblNewLabel_1_2_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_3.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_2_3.setBounds(64, 270, 159, 20);
		panel.add(lblNewLabel_1_2_3);
		
		txtSoDT = new JTextField();
		txtSoDT.setColumns(10);
		txtSoDT.setBounds(236, 267, 214, 32);
		panel.add(txtSoDT);
		
		JLabel lblNewLabel_1_2_4 = new JLabel("CCCD:");
		lblNewLabel_1_2_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_4.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_2_4.setBounds(64, 312, 159, 20);
		panel.add(lblNewLabel_1_2_4);
		
		txtCCCD = new JTextField();
		txtCCCD.setColumns(10);
		txtCCCD.setBounds(236, 309, 214, 32);
		panel.add(txtCCCD);
		
		
		JLabel lblNewLabel_1_2_5 = new JLabel("Giới tính:");
		lblNewLabel_1_2_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_5.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_2_5.setBounds(64, 351, 159, 20);
		panel.add(lblNewLabel_1_2_5);
		
		radMaleNV = new JRadioButton("Nam");
		radMaleNV.setFont(new Font("Tahoma", Font.BOLD, 16));
		radMaleNV.setBackground(new Color(166, 169, 248));
		radMaleNV.setBounds(231, 351, 63, 20);
		panel.add(radMaleNV);
		
		radFemaleNV = new JRadioButton("Nữ");
		radFemaleNV.setFont(new Font("Tahoma", Font.BOLD, 16));
		radFemaleNV.setBackground(new Color(166, 169, 248));
		radFemaleNV.setBounds(297, 351, 63, 20);
		panel.add(radFemaleNV);
		
		ButtonGroup grNV = new ButtonGroup();
		grNV.add(radMaleNV);
		grNV.add(radFemaleNV);
		
		btnThemNV = new JButton("Thêm");
		
		btnThemNV.setIcon(new ImageIcon("image\\them.png"));
		
		btnThemNV.setForeground(Color.WHITE);
		btnThemNV.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThemNV.setBackground(new Color(107,96,236));
		btnThemNV.setBounds(0,428, 115, 49);
		panel.add(btnThemNV);
		
		btnXoaNV = new JButton("Xóa");
		btnXoaNV.setIcon(new ImageIcon("image\\xoa.png"));
		btnXoaNV.setForeground(Color.WHITE);
		btnXoaNV.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoaNV.setBackground(new Color(107,96,236));
		btnXoaNV.setBounds(125, 428, 115, 49);
		panel.add(btnXoaNV);
		
		btnSuaNV = new JButton("Sửa");
		btnSuaNV.setIcon(new ImageIcon("image\\capnhat.png"));
		btnSuaNV.setForeground(Color.WHITE);
		btnSuaNV.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSuaNV.setBackground(new Color(107,96,236));
		btnSuaNV.setBounds(250, 428, 115, 49);
		panel.add(btnSuaNV);
		
		btnLamMoiNV = new JButton("Làm mới");
		btnLamMoiNV.setIcon(new ImageIcon("image\\lammoi.png"));
		btnLamMoiNV.setForeground(Color.WHITE);
		btnLamMoiNV.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLamMoiNV.setBackground(new Color(107,96,236));
		btnLamMoiNV.setBounds(375, 428, 138, 49);
		panel.add(btnLamMoiNV);
		
		cbbChucVu = new JComboBox();
		cbbChucVu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbbChucVu.setModel(new DefaultComboBoxModel(new String[] {"Quản lí", "Nhân viên bán hàng"}));
		cbbChucVu.setBackground(Color.WHITE);
		cbbChucVu.setBounds(235, 141, 214, 32);
		panel.add(cbbChucVu);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Tìm kiếm:");
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_1_1.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_2_1_1.setBounds(516, 10, 88, 32);
		getContentPane().add(lblNewLabel_1_2_1_1);
		
		
		txtTimNV = new JTextField();
		txtTimNV.setColumns(10);
		txtTimNV.setBounds(604, 10, 214, 32);
		getContentPane().add(txtTimNV);
		
		btnTimNV = new JButton("Tìm");
		btnTimNV.setIcon(new ImageIcon("image\\timkiem.png"));
	
		
		btnTimNV.setForeground(Color.WHITE);
		btnTimNV.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTimNV.setBackground(new Color(107,96,236));
		btnTimNV.setBounds(828, 10, 99, 32);
		getContentPane().add(btnTimNV);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(516, 52, 805, 616);
		getContentPane().add(scrollPane);
		table = new JTable() {
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
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Mã nhân viên", "Tên nhân viên", "Chức vụ", "Ngày sinh", "Địa chỉ", "Số điện thoại", "Số CCCD","Giới tính"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
	}
	private JLabel lbl;
	public JPanel createPanelNhanVien() {
		JPanel pnlContentPane = new JPanel();
		pnlContentPane.setBackground(Color.WHITE);
		setContentPane(pnlContentPane);
		pnlContentPane.add(lbl = new JLabel("Gảgagag"));
		return pnlContentPane;
	}
	public static void main(String[] args) {
		new FrameNhanVien().setVisible(true);
	}
	
}