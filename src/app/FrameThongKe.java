package app;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import com.toedter.calendar.JDateChooser;

import dao.DAO_ThongKe;

import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class FrameThongKe extends JFrame implements ActionListener{
	private JDateChooser txtTuNgay;
	private JDateChooser txtDenNgay;
	private JTable table;
	private JTextField textField;
	private JDateChooser txtLocTheoNgay;
	private JComboBox cbbThang;
	private JComboBox cbbNam;
	private JComboBox cbbLocTheoNam;
	private JRadioButton radNgay;
	private JRadioButton radThang;
	private JRadioButton radNam;
	private JRadioButton radKhac;
	private FixButton btnLamMoi;
	private FixButton btnLoc;
	private DefaultTableModel datamodel;
	private ArrayList<Object> dsTKTheoNgay;
	private JLabel lblNewLabel_2;
	private JLabel lblSoXeBan;
	private JLabel lblNewLabel_4;
	private JLabel lblTongDoanhThu;
	

	public FrameThongKe() {
		getContentPane().setForeground(Color.WHITE);
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
		
		btnLamMoi = new FixButton("Làm mới");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLamMoi.setIcon(new ImageIcon("image\\lammoi.png"));
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLamMoi.setBackground(new Color(107,96,236));
		btnLamMoi.setBounds(219, 585, 134, 49);
		panel.add(btnLamMoi);
		
		btnLoc = new FixButton("Lọc");
		btnLoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLoc.setIcon(new ImageIcon("image\\timkiem.png"));
		btnLoc.setForeground(Color.WHITE);
		btnLoc.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLoc.setBackground(new Color(107, 96, 236));
		btnLoc.setBounds(29, 585, 134, 49);
		panel.add(btnLoc);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(147, 112, 219));
		panel_1.setBounds(10, 57, 345, 518);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		radNgay = new JRadioButton("Lọc theo ngày");
		radNgay.setBackground(new Color(147, 112, 219));
		radNgay.setFont(new Font("Tahoma", Font.BOLD, 16));
		radNgay.setBounds(42, 45, 173, 29);
		panel_1.add(radNgay);
		
		radThang = new JRadioButton("Lọc theo tháng");
		radThang.setBackground(new Color(147, 112, 219));
		radThang.setFont(new Font("Tahoma", Font.BOLD, 16));
		radThang.setBounds(42, 140, 160, 29);
		panel_1.add(radThang);
		
		radNam = new JRadioButton("Lọc theo năm");
		radNam.setBackground(new Color(147, 112, 219));
		radNam.setFont(new Font("Tahoma", Font.BOLD, 16));
		radNam.setBounds(42, 233, 160, 29);
		panel_1.add(radNam);
		
		radKhac = new JRadioButton("Lựa chọn khác");
		radKhac.setBackground(new Color(147, 112, 219));
		radKhac.setFont(new Font("Tahoma", Font.BOLD, 16));
		radKhac.setBounds(48, 326, 143, 29);
		panel_1.add(radKhac);
		
		ButtonGroup grTieuChi = new ButtonGroup();
		grTieuChi.add(radNgay);
		grTieuChi.add(radThang);
		grTieuChi.add(radNam);
		grTieuChi.add(radKhac);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Từ ngày:");
		lblNewLabel_1_2_1.setBounds(42, 361, 110, 32);
		panel_1.add(lblNewLabel_1_2_1);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		txtTuNgay = new JDateChooser();
		txtTuNgay.setBounds(161, 361, 173, 32);
		txtTuNgay.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(txtTuNgay);
		txtTuNgay.setDateFormatString("yyyy-MM-dd");
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Đến ngày:");
		lblNewLabel_1_2_2.setBounds(42, 403, 110, 32);
		panel_1.add(lblNewLabel_1_2_2);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		txtDenNgay = new JDateChooser();
		txtDenNgay.setBounds(161, 403, 173, 32);
		txtDenNgay.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(txtDenNgay);
		txtDenNgay.setDateFormatString("yyyy-MM-dd");
		
		JLabel lblTiuChLc = new JLabel("Tiêu chí lọc:");
		lblTiuChLc.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTiuChLc.setBounds(10, 10, 111, 22);
		panel_1.add(lblTiuChLc);
		
		txtLocTheoNgay = new JDateChooser();
		txtLocTheoNgay.setBounds(52, 80, 219, 32);
		panel_1.add(txtLocTheoNgay);
		txtLocTheoNgay.setDateFormatString("yyyy-MM-dd");
		
		cbbThang = new JComboBox();
		
		cbbThang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbThang.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cbbThang.setBounds(52, 175, 85, 32);
		panel_1.add(cbbThang);
		
		cbbNam = new JComboBox();
		cbbNam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbNam.setModel(new DefaultComboBoxModel(new String[] {"2022", "2021", "2020", "2019", "2018", "2017"}));
		cbbNam.setBounds(144, 175, 127, 32);
		panel_1.add(cbbNam);
		
		cbbLocTheoNam = new JComboBox();
		cbbLocTheoNam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbLocTheoNam.setModel(new DefaultComboBoxModel(new String[] {"2022", "2021", "2020", "2019", "2018", "2017"}));
		cbbLocTheoNam.setBounds(52, 268, 224, 32);
		panel_1.add(cbbLocTheoNam);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(65, 105, 225));
		panel_2.setBounds(436, 36, 244, 122);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tổng số lượng xe bán ra");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 244, 46);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_2.add(lblNewLabel_1);
		
		lblSoXeBan = new JLabel("...");
		lblSoXeBan.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoXeBan.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSoXeBan.setForeground(Color.WHITE);
		lblSoXeBan.setBounds(0, 56, 244, 42);
		panel_2.add(lblSoXeBan);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(240, 128, 128));
		panel_2_1.setBounds(736, 36, 244, 122);
		getContentPane().add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Tổng doanh thu");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(0, 0, 244, 46);
		panel_2_1.add(lblNewLabel_3);
		
		lblTongDoanhThu = new JLabel("...");
		lblTongDoanhThu.setHorizontalAlignment(SwingConstants.CENTER);
		lblTongDoanhThu.setForeground(Color.WHITE);
		lblTongDoanhThu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTongDoanhThu.setBounds(0, 56, 244, 42);
		panel_2_1.add(lblTongDoanhThu);
		
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
		
		table.setModel(datamodel = new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Mã hợp đồng", "Mã sản phẩm", "Tên khách hàng", "Tên nhân viên", "Tên xe", "Giá tiền"
			}){
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		scrollPane.setViewportView(table);
		
		
		radNgay.addActionListener(this);
		radThang.addActionListener(this);
		radNam.addActionListener(this);
		radKhac.addActionListener(this);
		btnLoc.addActionListener(this);
		moKhoaTextField(false);
	}
	
	private void moKhoaTextField(Boolean b) {
		txtLocTheoNgay.setEnabled(b);
		txtTuNgay.setEnabled(b);
		txtDenNgay.setEnabled(b);
		cbbThang.setEnabled(b);
		cbbNam.setEnabled(b);
		cbbLocTheoNam.setEnabled(b);
	}
	private void lamRongTextField() {
		txtLocTheoNgay.setDate(null);
		txtTuNgay.setDate(null);
		txtDenNgay.setDate(null);
	}
	private void xoaHetDLModel() {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.getDataVector().removeAllElements();
	}
	private String chuyenTienVND(double tien) {
		String tienVND;
		DecimalFormat df = new DecimalFormat("###,### VNĐ");
		String temp = df.format(tien);
		tienVND = temp.replace(",", ".");
		return tienVND;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(radNgay)) {
			moKhoaTextField(false);
			txtLocTheoNgay.setEnabled(true);
			lamRongTextField();
		}
		else if(o.equals(radThang)) {
			moKhoaTextField(false);
			cbbThang.setEnabled(true);
			cbbNam.setEnabled(true);
			lamRongTextField();
			
		}else if(o.equals(radNam)) {
			moKhoaTextField(false);
			cbbLocTheoNam.setEnabled(true);
			
			lamRongTextField();
		}else if(o.equals(radKhac)) {
			moKhoaTextField(false);
			txtTuNgay.setEnabled(true);
			txtDenNgay.setEnabled(true);
			lamRongTextField();
		}
		
		if(o.equals(btnLoc)) {
			if(radNgay.isSelected()) {
				xoaHetDLModel();
				if(txtLocTheoNgay.getDate()==null){
					JOptionPane.showMessageDialog(this, "Chọn ngày tháng năm!");
				}else {
					Date ngay = txtLocTheoNgay.getDate();
					DAO_ThongKe dao_ThongKe = new DAO_ThongKe();
					java.sql.Date ngaySQL = new java.sql.Date(ngay.getYear(),ngay.getMonth(),ngay.getDate());
					dsTKTheoNgay = dao_ThongKe.thongKeTheoNgay(ngaySQL);
					double tongDoanhThu = 0;
					for(int i = 0;i<dsTKTheoNgay.size();i++) {
						String[] hopDong = (String[])dsTKTheoNgay.get(i);
						String maHD = hopDong[0];
						String maSP = hopDong[1];
						String tenKH = hopDong[2];
						String tenNV = hopDong[3];
						String tenXe = hopDong[4];
						String giaTien = hopDong[5];
						datamodel.addRow(new Object[] {maHD,maSP,tenKH,tenNV,tenXe,giaTien});
						tongDoanhThu += Double.parseDouble(giaTien);
					}
					lblSoXeBan.setText(String.valueOf(dsTKTheoNgay.size()));			
					lblTongDoanhThu.setText(chuyenTienVND(tongDoanhThu));
				}
			}
			
		}
		
		
		
	}
}
