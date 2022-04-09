package app;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import com.toedter.calendar.JDateChooser;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

public class FrameKhachHang extends JFrame{
	private DefaultTableModel model;
	public FrameKhachHang() {
		setSize(1345, 705);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(166, 169, 248));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(new Color(166, 169, 248));
		panel.setBounds(10, 10, 506, 668);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THÔNG TIN KHÁCH HÀNG");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(247,237,0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 10, 486, 37);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên khách hàng:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBackground(new Color(166, 169, 248));
		lblNewLabel_1.setBounds(62, 136, 159, 30);
		panel.add(lblNewLabel_1);
		
		txtTenKH = new JTextField();
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(231, 134, 214, 32);
		panel.add(txtTenKH);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ngày sinh:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_1.setBounds(62, 194, 159, 30);
		panel.add(lblNewLabel_1_1);
		
		txtNgaySinhKH = new JDateChooser();
		txtNgaySinhKH.setDateFormatString("yyyy-MM-dd");;
		txtNgaySinhKH.setBounds(231, 192, 214, 32);
		panel.add(txtNgaySinhKH);
		
		JLabel lblNewLabel_1_2 = new JLabel("Địa chỉ:");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_2.setBounds(62, 252, 159, 30);
		panel.add(lblNewLabel_1_2);
		
		txtDiaChiKH = new JTextField();
		txtDiaChiKH.setColumns(10);
		txtDiaChiKH.setBounds(231, 250, 214, 32);
		panel.add(txtDiaChiKH);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Số điện thoại:");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_1.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_2_1.setBounds(62, 310, 159, 30);
		panel.add(lblNewLabel_1_2_1);
		
		txtSDTKH = new JTextField();
		txtSDTKH.setColumns(10);
		txtSDTKH.setBounds(231, 308, 214, 32);
		panel.add(txtSDTKH);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("CCCD:");
		lblNewLabel_1_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_2.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_2_2.setBounds(62, 368, 159, 30);
		panel.add(lblNewLabel_1_2_2);
		
		txtCCCDKH = new JTextField();
		txtCCCDKH.setColumns(10);
		txtCCCDKH.setBounds(231, 366, 214, 32);
		panel.add(txtCCCDKH);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Giới tính:");
		lblNewLabel_1_2_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_3.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_2_3.setBounds(62, 426, 159, 20);
		panel.add(lblNewLabel_1_2_3);
		
		JRadioButton radMaleKH = new JRadioButton("Nam");
		radMaleKH.setFont(new Font("Tahoma", Font.BOLD, 16));
		radMaleKH.setBackground(new Color(166, 169, 248));
		radMaleKH.setBounds(231, 426, 63, 20);
		panel.add(radMaleKH);
		
		JRadioButton radFemaleKH = new JRadioButton("Nữ");
		radFemaleKH.setFont(new Font("Tahoma", Font.BOLD, 16));
		radFemaleKH.setBackground(new Color(166, 169, 248));
		radFemaleKH.setBounds(312, 426, 63, 20);
		panel.add(radFemaleKH);
		
		ButtonGroup grKH = new ButtonGroup();
		grKH.add(radMaleKH);
		grKH.add(radFemaleKH);
		
		JButton btnThemKH = new FixButton("Thêm");
		btnThemKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThemKH.setIcon(new ImageIcon("image\\them.png"));
		btnThemKH.setForeground(Color.WHITE);
		btnThemKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThemKH.setBackground(new Color(107,96,236));
		btnThemKH.setBounds(10, 476, 123, 49);
		panel.add(btnThemKH);
		
		JButton btnXoaKH = new FixButton("Xóa");
		btnXoaKH.setIcon(new ImageIcon("image\\xoa.png"));
		btnXoaKH.setForeground(Color.WHITE);
		btnXoaKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoaKH.setBackground(new Color(107,96,236));
		btnXoaKH.setBounds(139, 476, 105, 49);
		panel.add(btnXoaKH);
		
		JButton btnSuaKH = new FixButton("Sửa");	
		btnSuaKH.setIcon(new ImageIcon("image\\capnhat.png"));
		btnSuaKH.setForeground(Color.WHITE);
		btnSuaKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSuaKH.setBackground(new Color(107,96,236));
		btnSuaKH.setBounds(250, 476, 105, 49);
		panel.add(btnSuaKH);
		
		JButton btnLamMoiKH = new FixButton("Làm mới");
		btnLamMoiKH.setIcon(new ImageIcon("image\\lammoi.png"));
		btnLamMoiKH.setForeground(Color.WHITE);
		btnLamMoiKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLamMoiKH.setBackground(new Color(107,96,236));
		btnLamMoiKH.setBounds(361, 476, 136, 49);
		panel.add(btnLamMoiKH);
		
		txtMaKH = new JTextField();
		txtMaKH.setColumns(10);
		txtMaKH.setBounds(231, 76, 214, 32);
		panel.add(txtMaKH);
		
		JLabel lblNewLabel_1_3 = new JLabel("Mã khách hàng:");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_3.setBounds(62, 78, 159, 30);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Tìm kiếm:");
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_1_1.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_2_1_1.setBounds(516, 10, 88, 32);
		getContentPane().add(lblNewLabel_1_2_1_1);
		
		txtTimKH = new JTextField();
		txtTimKH.setColumns(10);
		txtTimKH.setBounds(604, 10, 214, 32);
		getContentPane().add(txtTimKH);
		
		JButton btnTimKH = new FixButton("Tìm");
		btnTimKH.setIcon(new ImageIcon("image\\timkiem.png"));	
		btnTimKH.setForeground(Color.WHITE);
		btnTimKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTimKH.setBackground(new Color(107,96,236));
		btnTimKH.setBounds(828, 10, 99, 32);
		getContentPane().add(btnTimKH);
		
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
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 kh\u00E1ch h\u00E0ng", "T\u00EAn kh\u00E1ch h\u00E0ng", "Ng\u00E0y sinh", "\u0110\u1ECBa ch\u1EC9", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "CDDD", "Gi\u1EDBi t\u00EDnh"
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
	private JTextField txtTenKH;
	private JDateChooser txtNgaySinhKH;
	private JTextField txtDiaChiKH;
	private JTextField txtSDTKH;
	private JTextField txtCCCDKH;
	private JTextField txtTimKH;
	private JTextField txtMaKH;
	private JTable table;
	public JPanel createPanelKhachHang() {
		JPanel pnlContentPane = new JPanel();
		pnlContentPane.setBackground(Color.WHITE);
		setContentPane(pnlContentPane);		
		return pnlContentPane;
	}
}
