package app;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import com.toedter.calendar.JDateChooser;

import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class FrameThongKe extends JFrame{
	private JDateChooser txtTuNgay;
	private JDateChooser txtDenNgay;
	private JTable table;

	public FrameThongKe() {
		setSize(1345, 705);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);		
		getContentPane().setBackground(new Color(166, 169, 248));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(new Color(166, 169, 248));
		panel.setBounds(0, 0, 363, 668);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ THỐNG KÊ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(247,237,0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 10, 331, 37);
		panel.add(lblNewLabel);
		
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLamMoi.setIcon(new ImageIcon("image\\lammoi.png"));
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLamMoi.setBackground(new Color(107,96,236));
		btnLamMoi.setBounds(218, 412, 134, 49);
		panel.add(btnLamMoi);
		
		JButton btnLoc = new JButton("Lọc");
		btnLoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLoc.setIcon(new ImageIcon("image\\timkiem.png"));
		btnLoc.setForeground(Color.WHITE);
		btnLoc.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLoc.setBackground(new Color(107, 96, 236));
		btnLoc.setBounds(31, 412, 134, 49);
		panel.add(btnLoc);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(147, 112, 219));
		panel_1.setBounds(10, 57, 345, 334);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JRadioButton radNgay = new JRadioButton("Lọc theo ngày");
		radNgay.setBackground(new Color(147, 112, 219));
		radNgay.setFont(new Font("Tahoma", Font.BOLD, 16));
		radNgay.setBounds(42, 45, 173, 29);
		panel_1.add(radNgay);
		
		JRadioButton radThang = new JRadioButton("Lọc theo tháng");
		radThang.setBackground(new Color(147, 112, 219));
		radThang.setFont(new Font("Tahoma", Font.BOLD, 16));
		radThang.setBounds(42, 85, 160, 29);
		panel_1.add(radThang);
		
		JRadioButton radNam = new JRadioButton("Lọc theo năm");
		radNam.setBackground(new Color(147, 112, 219));
		radNam.setFont(new Font("Tahoma", Font.BOLD, 16));
		radNam.setBounds(42, 125, 160, 29);
		panel_1.add(radNam);
		
		JRadioButton radKhac = new JRadioButton("Lựa chọn khác");
		radKhac.setBackground(new Color(147, 112, 219));
		radKhac.setFont(new Font("Tahoma", Font.BOLD, 16));
		radKhac.setBounds(42, 165, 143, 29);
		panel_1.add(radKhac);
		
		ButtonGroup grTieuChi = new ButtonGroup();
		grTieuChi.add(radNgay);
		grTieuChi.add(radThang);
		grTieuChi.add(radNam);
		grTieuChi.add(radKhac);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Từ ngày:");
		lblNewLabel_1_2_1.setBounds(10, 219, 110, 32);
		panel_1.add(lblNewLabel_1_2_1);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		txtTuNgay = new JDateChooser();
		txtTuNgay.setBounds(161, 219, 173, 32);
		panel_1.add(txtTuNgay);
		txtTuNgay.setDateFormatString("yyyy-MM-dd");
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Đến ngày:");
		lblNewLabel_1_2_2.setBounds(10, 279, 110, 32);
		panel_1.add(lblNewLabel_1_2_2);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		txtDenNgay = new JDateChooser();
		txtDenNgay.setBounds(161, 279, 173, 32);
		panel_1.add(txtDenNgay);
		txtDenNgay.setDateFormatString("yyyy-MM-dd");
		
		JLabel lblTiuChLc = new JLabel("Tiêu chí lọc:");
		lblTiuChLc.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTiuChLc.setBounds(10, 10, 111, 22);
		panel_1.add(lblTiuChLc);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(65, 105, 225));
		panel_2.setBounds(436, 36, 244, 122);
		getContentPane().add(panel_2);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(240, 128, 128));
		panel_2_1.setBounds(736, 36, 244, 122);
		getContentPane().add(panel_2_1);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBackground(new Color(50, 205, 50));
		panel_2_2.setBounds(1041, 36, 244, 122);
		getContentPane().add(panel_2_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(373, 168, 948, 500);
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
				"Mã hóa đơn", "Mã hợp đồng", "Mã sản phẩm", "Tên khách hàng", "Tên nhân viên", "Tên xe", "Số máy", "Hãng sản xuất", "Loại xe", "Giá tiền"
			}){
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		scrollPane.setViewportView(table);
		
		
	}
}
