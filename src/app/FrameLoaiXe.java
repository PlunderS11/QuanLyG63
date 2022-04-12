package app;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrameLoaiXe extends JFrame{	
	private JButton lbl;
	private JTextField txtTimKiem;
	private JTextField txtMaLoaiXe;
	private JTextField txtTenLoaiXe;
	private JTable tableLoaiXe;
	private JTable tableTenXe;
	public JPanel createPanelLoaiXe() {
		JPanel pnlContentPane = new JPanel();
		pnlContentPane.setBackground(Color.WHITE);
		setContentPane(pnlContentPane);
		pnlContentPane.add(lbl = new JButton("Gagag"));
		return pnlContentPane;}
	public FrameLoaiXe() {
		// TODO Auto-generated constructor stub
		setSize(1345, 705);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(166, 169, 248));	
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		//panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(new Color(166, 169, 248));
		panel.setBounds(0, 0, 796, 115);
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
		
		JButton btnTimLX = new FixButton("Tìm");
		btnTimLX.setIcon(new ImageIcon("image\\timkiem.png"));
	
		
		btnTimLX.setForeground(Color.WHITE);
		btnTimLX.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTimLX.setBackground(new Color(107,96,236));
		btnTimLX.setBounds(605, 15, 99, 32);
		panel.add(btnTimLX);
		
		JLabel lblMaLoaiXe = new JLabel("Mã loại xe:");
		lblMaLoaiXe.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMaLoaiXe.setBounds(53, 72, 104, 20);
		panel.add(lblMaLoaiXe);
		
		txtMaLoaiXe = new JTextField();
		txtMaLoaiXe.setBounds(154, 70, 214, 28);
		panel.add(txtMaLoaiXe);
		txtMaLoaiXe.setColumns(10);
		
		JLabel lblTenLoaiXe = new JLabel("Tên loại xe:");
		lblTenLoaiXe.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTenLoaiXe.setBounds(414, 77, 104, 15);
		panel.add(lblTenLoaiXe);
		
		txtTenLoaiXe = new JTextField();
		txtTenLoaiXe.setBounds(528, 70, 214, 28);
		panel.add(txtTenLoaiXe);
		txtTenLoaiXe.setColumns(10);
		
		JPanel pChucNang = new JPanel();
		pChucNang.setBounds(839, 11, 480, 86);
		pChucNang.setBackground(new Color(166, 169, 248));
		pChucNang.setBorder(new LineBorder(Color.BLACK));
		pChucNang.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1, true), "Chức năng",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(pChucNang);
		
		JButton btnThemLX = new FixButton("Thêm");
		
		btnThemLX.setIcon(new ImageIcon("image\\them.png"));
		
		btnThemLX.setForeground(Color.WHITE);
		btnThemLX.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThemLX.setBackground(new Color(107,96,236));
		btnThemLX.setBounds(0, 336, 115, 49);
		pChucNang.add(btnThemLX);
		
		JButton btnXoaLX = new FixButton("Xóa");
		btnXoaLX.setIcon(new ImageIcon("image\\xoa.png"));
		btnXoaLX.setForeground(Color.WHITE);
		btnXoaLX.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoaLX.setBackground(new Color(107,96,236));
		btnXoaLX.setBounds(125, 336, 109, 49);
		pChucNang.add(btnXoaLX);
		
		JButton btnSuaLX = new FixButton("Sửa");
	
		btnSuaLX.setIcon(new ImageIcon("image\\capnhat.png"));
		btnSuaLX.setForeground(Color.WHITE);
		btnSuaLX.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSuaLX.setBackground(new Color(107,96,236));
		btnSuaLX.setBounds(244, 336, 109, 49);
		pChucNang.add(btnSuaLX);
		
		JButton btnLamMoiLX = new FixButton("Làm mới");
		btnLamMoiLX.setIcon(new ImageIcon("image\\lammoi.png"));
		btnLamMoiLX.setForeground(Color.WHITE);
		btnLamMoiLX.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLamMoiLX.setBackground(new Color(107,96,236));
		btnLamMoiLX.setBounds(366, 336, 138, 49);
		pChucNang.add(btnLamMoiLX);
		
		JScrollPane scrlLoaiXe = new JScrollPane();
		scrlLoaiXe.setBounds(52, 140, 1267, 204);
		getContentPane().add(scrlLoaiXe);
		
		//tableLoaiXe = new JTable();
		tableLoaiXe = new JTable(){
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
		tableLoaiXe.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tableLoaiXe.setGridColor(getBackground());
		tableLoaiXe.setRowHeight(tableLoaiXe.getRowHeight() + 20);
		tableLoaiXe.setSelectionBackground(new Color(166, 169, 248));
		
		JTableHeader tableHeaderLoaiXe = tableLoaiXe.getTableHeader();
		tableHeaderLoaiXe.setBackground(new Color(79, 12, 132));
		tableHeaderLoaiXe.setForeground(Color.WHITE);
		tableHeaderLoaiXe.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		tableLoaiXe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableLoaiXe	.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
				},
				new String[] {
					"Mã loại xe", "Tên loại xe"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		scrlLoaiXe.setViewportView(tableLoaiXe);
		
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
					"Mã xe", "Mã loại xe", "Tên xe", "Tên loại xe"
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
