package app;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;


import com.toedter.calendar.JDateChooser;

import dao.DAO_ThongKe;
import dao.TrangChu_DAO;
import entity.NhanVien;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
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
	private ArrayList<Object> dsTKTheoThang;
	private ArrayList<Object> dsTKTheoNam;
	private ArrayList<Object> dsTKTheoKhoang;
	private DecimalFormat df;
	private JButton btnXuat;
	private TrangChu_DAO trangChu_dao;
	Locale localeVN = new Locale("vi", "VN");
    NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);

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
		
		JLabel lblNewLabel = new JLabel("QU???N L?? TH???NG K??");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(247,237,0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 10, 331, 37);
		panel.add(lblNewLabel);
		
		btnLamMoi = new FixButton("L??m m???i");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLamMoi.setIcon(new ImageIcon("image\\lammoi.png"));
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLamMoi.setBackground(new Color(107,96,236));
		btnLamMoi.setBounds(154, 585, 134, 49);
		panel.add(btnLamMoi);
		
		btnLoc = new FixButton("L???c");
		btnLoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLoc.setIcon(new ImageIcon("image\\timkiem.png"));
		btnLoc.setForeground(Color.WHITE);
		btnLoc.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLoc.setBackground(new Color(107, 96, 236));
		btnLoc.setBounds(10, 585, 134, 49);
		panel.add(btnLoc);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(147, 112, 219));
		panel_1.setBounds(10, 57, 345, 518);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		radNgay = new JRadioButton("L???c theo ng??y");
		radNgay.setBackground(new Color(147, 112, 219));
		radNgay.setFont(new Font("Tahoma", Font.BOLD, 16));
		radNgay.setBounds(42, 45, 173, 29);
		panel_1.add(radNgay);
		
		radThang = new JRadioButton("L???c theo th??ng");
		radThang.setBackground(new Color(147, 112, 219));
		radThang.setFont(new Font("Tahoma", Font.BOLD, 16));
		radThang.setBounds(42, 140, 160, 29);
		panel_1.add(radThang);
		
		radNam = new JRadioButton("L???c theo n??m");
		radNam.setBackground(new Color(147, 112, 219));
		radNam.setFont(new Font("Tahoma", Font.BOLD, 16));
		radNam.setBounds(42, 233, 160, 29);
		panel_1.add(radNam);
		
		radKhac = new JRadioButton("L???a ch???n kh??c");
		radKhac.setBackground(new Color(147, 112, 219));
		radKhac.setFont(new Font("Tahoma", Font.BOLD, 16));
		radKhac.setBounds(48, 326, 143, 29);
		panel_1.add(radKhac);
		
		ButtonGroup grTieuChi = new ButtonGroup();
		grTieuChi.add(radNgay);
		grTieuChi.add(radThang);
		grTieuChi.add(radNam);
		grTieuChi.add(radKhac);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("T??? ng??y:");
		lblNewLabel_1_2_1.setBounds(42, 361, 110, 32);
		panel_1.add(lblNewLabel_1_2_1);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		txtTuNgay = new JDateChooser();
		txtTuNgay.setBounds(161, 361, 173, 32);
		txtTuNgay.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(txtTuNgay);
		txtTuNgay.setDateFormatString("yyyy-MM-dd");
		
		JLabel lblNewLabel_1_2_2 = new JLabel("?????n ng??y:");
		lblNewLabel_1_2_2.setBounds(42, 403, 110, 32);
		panel_1.add(lblNewLabel_1_2_2);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		txtDenNgay = new JDateChooser();
		txtDenNgay.setBounds(161, 403, 173, 32);
		txtDenNgay.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(txtDenNgay);
		txtDenNgay.setDateFormatString("yyyy-MM-dd");
		
		JLabel lblTiuChLc = new JLabel("Ti??u ch?? l???c:");
		lblTiuChLc.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTiuChLc.setBounds(10, 10, 111, 22);
		panel_1.add(lblTiuChLc);
		
		txtLocTheoNgay = new JDateChooser();
		txtLocTheoNgay.setBounds(52, 80, 219, 32);
		txtLocTheoNgay.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(txtLocTheoNgay);
		txtLocTheoNgay.setDateFormatString("yyyy-MM-dd");
		
		cbbThang = new JComboBox();
		
		cbbThang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbbThang.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cbbThang.setBounds(52, 175, 85, 32);
		panel_1.add(cbbThang);
		
		cbbNam = new JComboBox();
		cbbNam.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbbNam.setModel(new DefaultComboBoxModel(new String[] {"2022", "2021", "2020", "2019", "2018", "2017"}));
		cbbNam.setBounds(144, 175, 127, 32);
		panel_1.add(cbbNam);
		
		cbbLocTheoNam = new JComboBox();
		cbbLocTheoNam.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbbLocTheoNam.setModel(new DefaultComboBoxModel(new String[] {"2022", "2021", "2020", "2019", "2018", "2017"}));
		cbbLocTheoNam.setBounds(52, 268, 224, 32);
		panel_1.add(cbbLocTheoNam);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(65, 105, 225));
		panel_2.setBounds(436, 36, 244, 122);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("T???ng s??? l?????ng xe b??n ra");
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
		
		JLabel lblNewLabel_3 = new JLabel("T???ng doanh thu");
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
		scrollPane.setBounds(373, 168, 948, 442);
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
				"M?? h???p ?????ng","M?? h??a ????n", "M?? s???n ph???m", "T??n kh??ch h??ng", "T??n nh??n vi??n", "T??n xe", "Gi?? ti???n"
			}){
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		scrollPane.setViewportView(table);
		
		btnXuat = new JButton("Xu???t Excel");
		btnXuat.setIcon(new ImageIcon("image\\xuatexcel.png"));
		btnXuat.setForeground(Color.WHITE);
		btnXuat.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXuat.setBackground(new Color(107,96,236));
		btnXuat.setBounds(1171, 615, 150, 49);
		getContentPane().add(btnXuat);
		btnXuat.addActionListener(this);
		
		
		
		
		
		radNgay.addActionListener(this);
		radThang.addActionListener(this);
		radNam.addActionListener(this);
		radKhac.addActionListener(this);
		btnLoc.addActionListener(this);
		btnLamMoi.addActionListener(this);
		moKhoaTextField(false);
		xoaHetDLModel();
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
		datamodel.getDataVector().removeAllElements();
	}
	private String chuyenTienVND(double tien) {
		String tienVND;
		DecimalFormat df = new DecimalFormat("###,### VN??");
		String temp = df.format(tien);
		tienVND = temp.replace(",", ".");
		return tienVND;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(radNgay)) {
			xoaHetDLModel();
			moKhoaTextField(false);
			txtLocTheoNgay.setEnabled(true);
			lamRongTextField();
		}
		else if(o.equals(radThang)) {
			xoaHetDLModel();
			moKhoaTextField(false);
			cbbThang.setEnabled(true);
			cbbNam.setEnabled(true);
			lamRongTextField();
			
		}else if(o.equals(radNam)) {
			xoaHetDLModel();
			moKhoaTextField(false);
			cbbLocTheoNam.setEnabled(true);
			lamRongTextField();
		}else if(o.equals(radKhac)) {
			xoaHetDLModel();
			moKhoaTextField(false);
			txtTuNgay.setEnabled(true);
			txtDenNgay.setEnabled(true);
			lamRongTextField();
		}
		
		if(o.equals(btnLoc)) {
			if(radNgay.isSelected()==false && radThang.isSelected()==false && radNam.isSelected()==false && radKhac.isSelected() ==false) {
				JOptionPane.showMessageDialog(this,"Ch???n ??i???u ki???n ????? l???c!");
				return;
			}
			if(radNgay.isSelected()) {
				xoaHetDLModel();
				if(txtLocTheoNgay.getDate()==null){
					JOptionPane.showMessageDialog(this, "Ch???n ng??y th??ng n??m!");
					xoaHetDLModel();
					return;
				}
				else {
					Date ngay = txtLocTheoNgay.getDate();
					DAO_ThongKe dao_ThongKe = new DAO_ThongKe();
					java.sql.Date ngaySQL = new java.sql.Date(ngay.getYear(),ngay.getMonth(),ngay.getDate());
					dsTKTheoNgay = dao_ThongKe.thongKeTheoNgay(ngaySQL);
					if(dsTKTheoNgay.size() == 0) {
						JOptionPane.showMessageDialog(this, "Kh??ng t??m th???y d??? li???u!");
						xoaHetDLModel();
						return;
					}
					double tongDoanhThu = 0;
					for(int i = 0;i<dsTKTheoNgay.size();i++) {
						String[] hopDong = (String[])dsTKTheoNgay.get(i);
						String maHD = hopDong[0];
						String maHoaDon = hopDong[1];
						String maSP = hopDong[2];
						String tenKH = hopDong[3];
						String tenNV = hopDong[4];
						String tenXe = hopDong[5];
						String giaTien = hopDong[6];
						datamodel.addRow(new Object[] {maHD,maHoaDon,maSP,tenKH,tenNV,tenXe,currencyVN.format(Double.parseDouble(giaTien))});
						tongDoanhThu += Double.parseDouble(giaTien);
					}
					lblSoXeBan.setText(String.valueOf(dsTKTheoNgay.size()));			
					lblTongDoanhThu.setText(chuyenTienVND(tongDoanhThu));
					
				}
			}
			
			else if(radKhac.isSelected()) {
				xoaHetDLModel();
				if(txtTuNgay.getDate()==null || txtDenNgay.getDate() == null){
					JOptionPane.showMessageDialog(this, "Ch???n ng??y th??ng n??m!");
					xoaHetDLModel();
					return;
				}
				else {
					Date tuNgay = txtTuNgay.getDate();
					Date denNgay = txtDenNgay.getDate();
					DAO_ThongKe dao_ThongKe = new DAO_ThongKe();
					java.sql.Date tuNgaySQL = new java.sql.Date(tuNgay.getYear(),tuNgay.getMonth(),tuNgay.getDate());
					java.sql.Date denNgaySQL = new java.sql.Date(denNgay.getYear(),denNgay.getMonth(),denNgay.getDate());
					dsTKTheoKhoang = dao_ThongKe.thongKeTheoKhoang(tuNgaySQL,denNgaySQL);
					if(dsTKTheoKhoang.size() == 0) {
						JOptionPane.showMessageDialog(this, "Kh??ng t??m th???y d??? li???u!");
						xoaHetDLModel();
						return;
					}
					double tongDoanhThu = 0;
					for(int i = 0;i<dsTKTheoKhoang.size();i++) {
						String[] hopDong = (String[])dsTKTheoKhoang.get(i);
						String maHD = hopDong[0];
						String maHoaDon = hopDong[1];
						String maSP = hopDong[2];
						String tenKH = hopDong[3];
						String tenNV = hopDong[4];
						String tenXe = hopDong[5];
						String giaTien = hopDong[6];
						datamodel.addRow(new Object[] {maHD,maHoaDon,maSP,tenKH,tenNV,tenXe,currencyVN.format(Double.parseDouble(giaTien))});
						tongDoanhThu += Double.parseDouble(giaTien);
					}
					lblSoXeBan.setText(String.valueOf(dsTKTheoKhoang.size()));			
					lblTongDoanhThu.setText(chuyenTienVND(tongDoanhThu));
				}
			}
			
			
			else if(radThang.isSelected()) {
				xoaHetDLModel();
				int thang = Integer.parseInt(cbbThang.getSelectedItem().toString());
				int nam = Integer.parseInt(cbbNam.getSelectedItem().toString());
				DAO_ThongKe dao_ThongKe = new DAO_ThongKe();
				dsTKTheoThang = dao_ThongKe.thongKeTheoThang(thang,nam);
				if(dsTKTheoThang.size()==0) {
					JOptionPane.showMessageDialog(this, "Kh??ng t??m th???y d??? li???u");
					xoaHetDLModel();
					return;
				}
				double tongDoanhThu = 0;
				for(int i = 0;i<dsTKTheoThang.size();i++) {
					String[] hopDong = (String[])dsTKTheoThang.get(i);
					String maHD = hopDong[0];
					String maHoaDon = hopDong[1];
					String maSP = hopDong[2];
					String tenKH = hopDong[3];
					String tenNV = hopDong[4];
					String tenXe = hopDong[5];
					String giaTien = hopDong[6];
					datamodel.addRow(new Object[] {maHD,maHoaDon,maSP,tenKH,tenNV,tenXe,currencyVN.format(Double.parseDouble(giaTien))});
					tongDoanhThu += Double.parseDouble(giaTien);
				}
				lblSoXeBan.setText(String.valueOf(dsTKTheoThang.size()));			
				lblTongDoanhThu.setText(chuyenTienVND(tongDoanhThu));
			}
			else if(radNam.isSelected()) {
				xoaHetDLModel();
				int nam = Integer.parseInt(cbbLocTheoNam.getSelectedItem().toString());
				DAO_ThongKe dao_ThongKe = new DAO_ThongKe();
				dsTKTheoNam = dao_ThongKe.thongKeTheoNam(nam);
				
				if(dsTKTheoNam.size()==0) {
					JOptionPane.showMessageDialog(this, "Kh??ng t??m th???y d??? li???u");
					xoaHetDLModel();
					return;
				}
				
				double tongDoanhThu = 0;
				for(int i = 0;i<dsTKTheoNam.size();i++) {
					String[] hopDong = (String[])dsTKTheoNam.get(i);
					String maHD = hopDong[0];
					String maHoaDon = hopDong[1];
					String maSP = hopDong[2];
					String tenKH = hopDong[3];
					String tenNV = hopDong[4];
					String tenXe = hopDong[5];
					String giaTien = hopDong[6];
					datamodel.addRow(new Object[] {maHD,maHoaDon,maSP,tenKH,tenNV,tenXe,currencyVN.format(Double.parseDouble(giaTien))});
					tongDoanhThu += Double.parseDouble(giaTien);
				}
				lblSoXeBan.setText(String.valueOf(dsTKTheoNam.size()));			
				lblTongDoanhThu.setText(chuyenTienVND(tongDoanhThu));
			}	
		}
		if(o.equals(btnLamMoi)) {
			lamRongTextField();
			xoaHetDLModel();
		}
		if (o.equals(btnXuat)) {
			JFileChooser fileDialog = new JFileChooser() {
				@Override
				protected JDialog createDialog(Component parent) throws HeadlessException {
					JDialog dialog = super.createDialog(parent);
					ImageIcon icon = new ImageIcon("image/logodark.png");
					dialog.setIconImage(icon.getImage());
					return dialog;
				}
			};
			FileFilter filter = new FileNameExtensionFilter("Excel(.xls)", ".xls");
			fileDialog.setAcceptAllFileFilterUsed(false);
			fileDialog.addChoosableFileFilter(filter);
			int returnVal = fileDialog.showSaveDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				java.io.File file = fileDialog.getSelectedFile();
				String filePath = file.getAbsolutePath();
				if(!(filePath.endsWith(".xls") || filePath.endsWith(".xlsx"))) {
					filePath += ".xls";
				}
				if (xuatExcel(filePath))
					JOptionPane.showMessageDialog(null, "Ghi file th??nh c??ng!!", "Th??nh c??ng",
							JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, "Ghi file th???t b???i!!", "L???i", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	
	
	public boolean xuatExcel(String filePath) {
		try {
			FileOutputStream fileOut = new FileOutputStream(filePath);
			// T???o sheet Danh s??ch kh??ch h??ng
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet worksheet = workbook.createSheet("DANH S??CH H??A ????N");

			HSSFRow row;
			HSSFCell cell;

			// D??ng 1 t??n
			cell = worksheet.createRow(1).createCell(1);

			HSSFFont newFont = cell.getSheet().getWorkbook().createFont();
			newFont.setBold(true);
			newFont.setFontHeightInPoints((short) 13);
			CellStyle styleTenDanhSach = worksheet.getWorkbook().createCellStyle();
			styleTenDanhSach.setAlignment(HorizontalAlignment.CENTER);
			styleTenDanhSach.setFont(newFont);

			cell.setCellValue("TH???NG K?? DOANH THU");
			cell.setCellStyle(styleTenDanhSach);

			String[] header = { "STT","M?? h???p ?????ng","M?? h??a ????n", "M?? s???n ph???m", "T??n kh??ch h??ng", "T??n nh??n vi??n", "T??n s???n ph???m" , "Gi?? ti???n" };
			worksheet.addMergedRegion(new CellRangeAddress(1, 1, 1, header.length));

			// D??ng 2 ng?????i l???p
			row = worksheet.createRow(2);

			cell = row.createCell(1);
			cell.setCellValue("Ng?????i l???p:");
			cell = row.createCell(2);
			trangChu_dao = new TrangChu_DAO();
			NhanVien nv = trangChu_dao.getNhanVienSuDung(NewSignin.getTaiKhoan());
			cell.setCellValue(nv.getTenNV());
			worksheet.addMergedRegion(new CellRangeAddress(2, 2, 2, 3));

			// D??ng 3 ng??y l???p
			row = worksheet.createRow(3);
			cell = row.createCell(1);
			cell.setCellValue("Ng??y l???p:");
			cell = row.createCell(2);
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			cell.setCellValue(df.format(new Date()));
			worksheet.addMergedRegion(new CellRangeAddress(3, 3, 2, 3));

			// D??ng 4 t??n c??c c???t
			row = worksheet.createRow(4);

			HSSFFont fontHeader = cell.getSheet().getWorkbook().createFont();
			fontHeader.setBold(true);
			
			CellStyle styleHeader = worksheet.getWorkbook().createCellStyle();
			styleHeader.setFont(fontHeader);
			styleHeader.setBorderBottom(BorderStyle.THIN);
			styleHeader.setBorderTop(BorderStyle.THIN);
			styleHeader.setBorderLeft(BorderStyle.THIN);
			styleHeader.setBorderRight(BorderStyle.THIN);
			styleHeader.setAlignment(HorizontalAlignment.CENTER);

			styleHeader.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
			styleHeader.setFillPattern(FillPatternType.SOLID_FOREGROUND);

			for (int i = 0; i < header.length; i++) {
				cell = row.createCell(i + 1);
				cell.setCellValue(header[i]);
				cell.setCellStyle(styleHeader);
			}

//			if (table.getRowCount() == 0) {
//				return false;
//			}

			HSSFFont fontRow = cell.getSheet().getWorkbook().createFont();
			fontRow.setBold(false);

			CellStyle styleRow = worksheet.getWorkbook().createCellStyle();
			styleRow.setFont(fontRow);
			styleRow.setBorderBottom(BorderStyle.THIN);
			styleRow.setBorderTop(BorderStyle.THIN);
			styleRow.setBorderLeft(BorderStyle.THIN);
			styleRow.setBorderRight(BorderStyle.THIN);

			// Ghi d??? li???u v??o b???ng
			int STT = 0;
			if(table.getRowCount()==0) {
				workbook.write(fileOut);
				workbook.close();
				fileOut.flush();
				fileOut.close();
				return true;
			}
			for (int i = 0; i < table.getRowCount(); i++) {
				row = worksheet.createRow(5 + i);
				for (int j = 0; j < header.length; j++) {
					cell = row.createCell(j + 1);
					if (STT == i) {
						cell.setCellValue(STT + 1);
						STT++;
					} else {
						if (table.getValueAt(i, j - 1) != null) {
//							if (j == header.length - 1 || j == header.length - 2 || j == header.length - 3
//									|| j == header.length - 4) {
//								String tien[] = datamodel.getValueAt(i, j - 1).toString().split(",");
//								String tongTien = "";
//								for (int t = 0; t < tien.length; t++)
//									tongTien += tien[t];
//								//cell.setCellValue(Double.parseDouble(tongTien));
//							} else
								cell.setCellValue(table.getValueAt(i, j - 1).toString().trim());
						}
					}
					cell.setCellStyle(styleRow);
				}
			}

			for (int i = 1; i < header.length + 1; i++) {
				worksheet.autoSizeColumn(i);
			}
			int row5 = 4 + table.getRowCount() + 1;
			row = worksheet.createRow(row5);
			cell = row.createCell(4);
			cell.setCellStyle(styleTenDanhSach);
			worksheet.addMergedRegion(new CellRangeAddress(row5, row5, 4,5));
			cell.setCellValue("T???NG DOANH THU:");
			cell = row.createCell(6);
			worksheet.addMergedRegion(new CellRangeAddress(row5, row5, 6, 7));
			cell.setCellStyle(styleTenDanhSach);
			
			cell.setCellValue("" + lblTongDoanhThu.getText());

			workbook.write(fileOut);
			workbook.close();
			fileOut.flush();
			fileOut.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
