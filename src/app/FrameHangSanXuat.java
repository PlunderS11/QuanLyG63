package app;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

public class FrameHangSanXuat extends JFrame{
	private JTextField txtTimKiem;
	private JTextField txtMaHangXe;
	private JTextField txtTenHangXe;
	private JTextField textField;
	private JTable tableHangXe;
	private JTable tableTenXe;

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
		
		JScrollPane scrlHangXe = new JScrollPane();
		scrlHangXe.setBounds(52, 140, 1267, 204);
		getContentPane().add(scrlHangXe);
		
		//tableLoaiXe = new JTable();
		tableHangXe = new JTable(){
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
		tableHangXe.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tableHangXe.setGridColor(getBackground());
		tableHangXe.setRowHeight(tableHangXe.getRowHeight() + 20);
		tableHangXe.setSelectionBackground(new Color(166, 169, 248));
		
		JTableHeader tableHeaderHangXe = tableHangXe.getTableHeader();
		tableHeaderHangXe.setBackground(new Color(79, 12, 132));
		tableHeaderHangXe.setForeground(Color.WHITE);
		tableHeaderHangXe.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		tableHangXe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableHangXe	.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
				},
				new String[] {
					"Mã hãng xe", "Tên Hãng xe", "Nguồn gốc"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		scrlHangXe.setViewportView(tableHangXe);
		
		JScrollPane scrlTenXe = new JScrollPane();
		scrlTenXe.setBounds(52, 371, 1267, 259);
		
		
		getContentPane().add(scrlTenXe);
		
		tableTenXe = new JTable(){
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
		tableTenXe.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tableTenXe.setGridColor(getBackground());
		tableTenXe.setRowHeight(tableTenXe.getRowHeight() + 20);
		tableTenXe.setSelectionBackground(new Color(166, 169, 248));
		
		JTableHeader tableHeaderTenXe = tableTenXe.getTableHeader();
		tableHeaderTenXe.setBackground(new Color(79, 12, 132));
		tableHeaderTenXe.setForeground(Color.WHITE);
		tableHeaderTenXe.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		tableTenXe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableTenXe.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
				},
				new String[] {
					"Mã xe", "Mã hãng xe", "Tên xe", "Tên hãng xe"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		scrlTenXe.setViewportView(tableTenXe);
		
	}
}
