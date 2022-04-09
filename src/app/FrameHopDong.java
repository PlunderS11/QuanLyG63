package app;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameHopDong extends JFrame{
	private JTextField textField;
	private JTextField txtTenKH;
	private JTextField txtCCCD;
	private JTextField txtTenNV;
	private JTextField txtMaSP;
	private JTextField txtTenSP;
	private JDateChooser txtNgayLap;
	private JTextField txtGiaTien;
	private JTextField textField_1;
	private JTextField txtSoKhung;
	private JTextField txtSoMay;
	private JTextField txtHangSX;
	private JTextField txtLoaiXe;
	private JTextField txtGiaNhap;
	private JTable table;
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
		
		JLabel lblNewLabel_1 = new JLabel("Tên khách hàng:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 160, 153, 32);
		panel.add(lblNewLabel_1);
		
		txtTenKH = new JTextField();
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(173, 160, 210, 32);
		panel.add(txtTenKH);
		
		JLabel lblNewLabel_1_1 = new JLabel("CCCD:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(10, 210, 134, 32);
		panel.add(lblNewLabel_1_1);
		
		txtCCCD = new JTextField();
		txtCCCD.setColumns(10);
		txtCCCD.setBounds(173, 210, 210, 32);
		panel.add(txtCCCD);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tên nhân viên:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(10, 260, 134, 32);
		panel.add(lblNewLabel_1_2);
		
		txtTenNV = new JTextField();
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(173, 260, 210, 32);
		panel.add(txtTenNV);
		
		JLabel lblNewLabel_1_3 = new JLabel("Mã sản phẩm:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(10, 310, 134, 32);
		panel.add(lblNewLabel_1_3);
		
		txtMaSP = new JTextField();
		txtMaSP.setColumns(10);
		txtMaSP.setBounds(173, 310, 210, 32);
		panel.add(txtMaSP);
		
		JLabel lblNewLabel_1_4 = new JLabel("Tên sản phẩm:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_4.setBounds(10, 360, 134, 32);
		panel.add(lblNewLabel_1_4);
		
		txtTenSP = new JTextField();
		txtTenSP.setColumns(10);
		txtTenSP.setBounds(173, 360, 210, 32);
		panel.add(txtTenSP);
		
		JLabel lblNewLabel_1_5 = new JLabel("Ngày lập:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_5.setBounds(10, 410, 134, 32);
		panel.add(lblNewLabel_1_5);
		
		txtNgayLap = new JDateChooser();
		txtNgayLap.setDateFormatString("yyyy-MM-dd");
		txtNgayLap.setBounds(173, 410, 210, 32);
		panel.add(txtNgayLap);
		
		JLabel lblNewLabel_1_6 = new JLabel("Giá tiền:");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_6.setBounds(10, 460, 134, 32);
		panel.add(lblNewLabel_1_6);
		
		txtGiaTien = new JTextField();
		txtGiaTien.setColumns(10);
		txtGiaTien.setBounds(173, 460, 210, 32);
		panel.add(txtGiaTien);
		
		JButton btnThemKH = new FixButton("Thêm");
		btnThemKH.setIcon(new ImageIcon("image\\them.png"));
		btnThemKH.setForeground(Color.WHITE);
		btnThemKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThemKH.setBackground(new Color(107,96,236));
		btnThemKH.setBounds(54, 544, 115, 49);
		panel.add(btnThemKH);
		
		JButton btnLamMoi = new FixButton("Làm mới");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLamMoi.setIcon(new ImageIcon("image\\lammoi.png"));
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLamMoi.setBackground(new Color(107,96,236));
		btnLamMoi.setBounds(213, 544, 134, 49);
		panel.add(btnLamMoi);
		
		JPanel pnlTimKH = new JPanel();
		pnlTimKH.setBackground(new Color(147, 112, 219));
		pnlTimKH.setBounds(10, 57, 373, 93);		
		panel.add(pnlTimKH);
		pnlTimKH.setLayout(null);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Tìm kiếm khách cũ:");
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_1_1.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_2_1_1.setBounds(10, 14, 183, 32);
		pnlTimKH.add(lblNewLabel_1_2_1_1);
		
		JButton btnTimKH = new FixButton("Tìm");
		btnTimKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTimKH.setForeground(Color.WHITE);
		btnTimKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTimKH.setIcon(new ImageIcon("image\\timkiem.png"));
		btnTimKH.setBackground(new Color(107, 96, 236));
		btnTimKH.setBounds(247, 51, 117, 32);
		pnlTimKH.add(btnTimKH);
		
		JComboBox cboTimKHCu = new JComboBox();
		cboTimKHCu.setBounds(10, 51, 216, 32);
		pnlTimKH.add(cboTimKHCu);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(402, 159, 919, 509);
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
				"Mã xe", "Tên xe", "Màu xe", "Số khung", "Số máy", "Hãng sản xuất", "Loại xe", "Trạng thái"
			}){
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1_7 = new JLabel("Màu xe:");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_7.setBounds(442, 18, 304, 32);
		getContentPane().add(lblNewLabel_1_7);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(543, 18, 203, 32);
		getContentPane().add(textField_1);
		
		JLabel lblNewLabel_1_7_1 = new JLabel("Số khung:");
		lblNewLabel_1_7_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_7_1.setBounds(442, 60, 304, 32);
		getContentPane().add(lblNewLabel_1_7_1);
		
		txtSoKhung = new JTextField();
		txtSoKhung.setColumns(10);
		txtSoKhung.setBounds(543, 60, 203, 32);
		getContentPane().add(txtSoKhung);
		
		JLabel lblNewLabel_1_7_2 = new JLabel("Số máy:");
		lblNewLabel_1_7_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_7_2.setBounds(442, 102, 304, 32);
		getContentPane().add(lblNewLabel_1_7_2);
		
		txtSoMay = new JTextField();
		txtSoMay.setColumns(10);
		txtSoMay.setBounds(543, 102, 203, 32);
		getContentPane().add(txtSoMay);
		
		JLabel lblNewLabel_1_7_3 = new JLabel("Hãng sản xuất:");
		lblNewLabel_1_7_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_7_3.setBounds(801, 18, 129, 32);
		getContentPane().add(lblNewLabel_1_7_3);
		
		txtHangSX = new JTextField();
		txtHangSX.setColumns(10);
		txtHangSX.setBounds(940, 18, 193, 32);
		getContentPane().add(txtHangSX);
		
		JLabel lblNewLabel_1_7_4 = new JLabel("Loại xe:");
		lblNewLabel_1_7_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_7_4.setBounds(801, 60, 93, 32);
		getContentPane().add(lblNewLabel_1_7_4);
		
		txtLoaiXe = new JTextField();
		txtLoaiXe.setColumns(10);
		txtLoaiXe.setBounds(940, 60, 193, 32);
		getContentPane().add(txtLoaiXe);
		
		JLabel lblNewLabel_1_7_5 = new JLabel("Giá nhập:");
		lblNewLabel_1_7_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_7_5.setBounds(801, 102, 93, 32);
		getContentPane().add(lblNewLabel_1_7_5);
		
		txtGiaNhap = new JTextField();
		txtGiaNhap.setColumns(10);
		txtGiaNhap.setBounds(940, 102, 193, 32);
		getContentPane().add(txtGiaNhap);
		
		JButton btnTimXe = new FixButton("Tìm");
		btnTimXe.setIcon(new ImageIcon("image\\timkiem.png"));
		btnTimXe.setForeground(Color.WHITE);
		btnTimXe.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTimXe.setBackground(new Color(107, 96, 236));
		btnTimXe.setBounds(1160, 60, 99, 32);
		getContentPane().add(btnTimXe);
		
		JButton btnTangDan = new JButton();
		btnTangDan.setBackground(new Color(0, 0, 139));
		btnTangDan.setIcon(new ImageIcon("image\\tangdan.png"));
		btnTangDan.setBounds(1160, 110, 71, 47);
		getContentPane().add(btnTangDan);
		
		JButton btnGiamDan = new JButton();
		btnGiamDan.setBackground(new Color(0, 0, 139));
		btnGiamDan.setIcon(new ImageIcon("image\\giamdan.png"));
		btnGiamDan.setBounds(1241, 110, 71, 47);
		getContentPane().add(btnGiamDan);
	}
}
