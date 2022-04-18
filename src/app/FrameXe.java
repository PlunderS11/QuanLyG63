package app;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import connection.ConnectDB;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrameXe extends JFrame{

	public FrameXe() {
		
		try {
			ConnectDB.getinstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		setSize(1345, 705);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(166, 169, 248));	
		getContentPane().setLayout(null);
		
		
		
		JPanel panel = new JPanel();
		//panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(new Color(166, 169, 248));
		panel.setBounds(0, 0, 796, 241);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblMaXe = new JLabel("Mã xe:");
		lblMaXe.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMaXe.setBounds(10, 63, 102, 14);
		panel.add(lblMaXe);
		
		txtMaXe = new JTextField();
		txtMaXe.setBounds(103, 58, 214, 28);
		panel.add(txtMaXe);
		txtMaXe.setColumns(10);
		
		JLabel lblTenXe = new JLabel("Tên xe:");
		lblTenXe.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTenXe.setBounds(10, 101, 102, 14);
		panel.add(lblTenXe);
		
		txtTenXe = new JTextField();
		txtTenXe.setBounds(103, 96, 214, 28);
		panel.add(txtTenXe);
		txtTenXe.setColumns(10);
		
		JLabel lblMauXe = new JLabel("Màu xe:");
		lblMauXe.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMauXe.setBounds(10, 135, 102, 14);
		panel.add(lblMauXe);
		
		JComboBox cboMauXe = new JComboBox();
		cboMauXe.setBounds(103, 130, 214, 28);
		panel.add(cboMauXe);
		
		JLabel lblSoXeung = new JLabel("Số Khung:");
		lblSoXeung.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSoXeung.setBounds(10, 170, 102, 23);
		panel.add(lblSoXeung);
		
		txtSoKhung = new JTextField();
		txtSoKhung.setBounds(103, 165, 214, 28);
		panel.add(txtSoKhung);
		txtSoKhung.setColumns(10);
		
		JLabel lblSoMay = new JLabel("Số máy:");
		lblSoMay.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSoMay.setBounds(10, 207, 91, 23);
		panel.add(lblSoMay);
		
		txtSoMay = new JTextField();
		txtSoMay.setBounds(103, 202, 214, 28);
		panel.add(txtSoMay);
		txtSoMay.setColumns(10);
		
		JLabel lblNhaCungCap = new JLabel("Nhà cung cấp:");
		lblNhaCungCap.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNhaCungCap.setBounds(369, 63, 128, 23);
		panel.add(lblNhaCungCap);
		
		txtNhaCungCap = new JTextField();
		txtNhaCungCap.setBounds(507, 58, 214, 28);
		panel.add(txtNhaCungCap);
		txtNhaCungCap.setColumns(10);
		
		JLabel lblHangSanXuat = new JLabel("Hãng sản xuất:");
		lblHangSanXuat.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHangSanXuat.setBounds(369, 101, 128, 23);
		panel.add(lblHangSanXuat);
		
		txtHangSanXuat = new JTextField();
		txtHangSanXuat.setBounds(507, 96, 214, 28);
		panel.add(txtHangSanXuat);
		txtHangSanXuat.setColumns(10);
		
		JLabel lblLoaiXe = new JLabel("Loại xe:");
		lblLoaiXe.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLoaiXe.setBounds(369, 135, 128, 23);
		panel.add(lblLoaiXe);
		
		JComboBox cboLoaiXe = new JComboBox();
		cboLoaiXe.setBounds(507, 130, 214, 28);
		panel.add(cboLoaiXe);
		
		JLabel lblGiaNhap = new JLabel("Giá nhập:");
		lblGiaNhap.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGiaNhap.setBounds(369, 170, 128, 23);
		panel.add(lblGiaNhap);
		
		txtGiaNhap = new JTextField();
		txtGiaNhap.setBounds(507, 165, 214, 28);
		panel.add(txtGiaNhap);
		txtGiaNhap.setColumns(10);
		
		JLabel lblTrangThai = new JLabel("Trạng thái:");
		lblTrangThai.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTrangThai.setBounds(369, 207, 128, 23);
		panel.add(lblTrangThai);
		
		JComboBox cboTrangThai = new JComboBox();
		cboTrangThai.setBounds(507, 202, 214, 28);
		panel.add(cboTrangThai);
		
		JLabel lblTimKiem = new JLabel("Tìm kiếm:");
		lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTimKiem.setBounds(213, 22, 91, 14);
		panel.add(lblTimKiem);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(314, 17, 270, 28);
		panel.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		JButton btnTimXe = new FixButton("Tìm");
		btnTimXe.setIcon(new ImageIcon("image\\timkiem.png"));
	
		
		btnTimXe.setForeground(Color.WHITE);
		btnTimXe.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTimXe.setBackground(new Color(107,96,236));
		btnTimXe.setBounds(605, 15, 99, 32);
		panel.add(btnTimXe);
		
		
		JPanel pChucNang = new JPanel();
		pChucNang.setBounds(839, 11, 480, 86);
		pChucNang.setBackground(new Color(166, 169, 248));
		pChucNang.setBorder(new LineBorder(Color.BLACK));
		pChucNang.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1, true), "Chức năng",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(pChucNang);
		
		JButton btnThemXe = new FixButton("Thêm");
		
		btnThemXe.setIcon(new ImageIcon("image\\them.png"));
		
		btnThemXe.setForeground(Color.WHITE);
		btnThemXe.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThemXe.setBackground(new Color(107,96,236));
		btnThemXe.setBounds(0, 336, 115, 49);
		pChucNang.add(btnThemXe);
		
		JButton btnXoaXe = new FixButton("Xóa");
		btnXoaXe.setIcon(new ImageIcon("image\\xoa.png"));
		btnXoaXe.setForeground(Color.WHITE);
		btnXoaXe.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoaXe.setBackground(new Color(107,96,236));
		btnXoaXe.setBounds(125, 336, 109, 49);
		pChucNang.add(btnXoaXe);
		
		JButton btnSuaXe = new FixButton("Sửa");
	
		btnSuaXe.setIcon(new ImageIcon("image\\capnhat.png"));
		btnSuaXe.setForeground(Color.WHITE);
		btnSuaXe.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSuaXe.setBackground(new Color(107,96,236));
		btnSuaXe.setBounds(244, 336, 109, 49);
		pChucNang.add(btnSuaXe);
		
		JButton btnLamMoiXe = new FixButton("Làm mới");
		btnLamMoiXe.setIcon(new ImageIcon("image\\lammoi.png"));
		btnLamMoiXe.setForeground(Color.WHITE);
		btnLamMoiXe.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLamMoiXe.setBackground(new Color(107,96,236));
		btnLamMoiXe.setBounds(366, 336, 138, 49);
		pChucNang.add(btnLamMoiXe);
		
		JPanel pSapXep = new JPanel();
		pSapXep.setLayout(null);
		pSapXep.setBounds(839, 124, 466, 112);
		pSapXep.setBackground(new Color(166, 169, 248));
		pSapXep.setBorder(new LineBorder(Color.BLACK));
		pSapXep.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1, true), "Sắp xếp",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(pSapXep);
		
		JLabel lblSapXep = new JLabel("Loại sắp xếp:");
		lblSapXep.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSapXep.setBounds(74, 30, 108, 23);
		pSapXep.add(lblSapXep);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(192, 25, 214, 28);
		pSapXep.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 274, 1295, 325);
		getContentPane().add(scrollPane);
		
		tableXe = new JTable(){
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
		tableXe.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tableXe.setGridColor(getBackground());
		tableXe.setRowHeight(tableXe.getRowHeight() + 20);
		tableXe.setSelectionBackground(new Color(166, 169, 248));
		
		JTableHeader tableHeader = tableXe.getTableHeader();
		tableHeader.setBackground(new Color(79, 12, 132));
		tableHeader.setForeground(Color.WHITE);
		tableHeader.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		tableXe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableXe.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null},
				},
				new String[] {
					"Mã xe", "Tên xe", "Màu xe", "Số khung", "Số máy", "Nhà cung cấp", "Hãng sản xuất", "Loại xe", "Giá", "Trạng thái"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		
		scrollPane.setViewportView(tableXe);
		
	
		
	}
	private JTextField txtMaXe;
	private JTextField txtTenXe;
	private JTextField txtSoKhung;
	private JTextField txtSoMay;
	private JTextField txtNhaCungCap;
	private JTextField txtHangSanXuat;
	private JTextField txtGiaNhap;	
	private JTextField txtTimKiem;
	private JTable tableXe;

	
	public static void main(String[] args) {
		new FrameXe().setVisible(true);

}
	}
