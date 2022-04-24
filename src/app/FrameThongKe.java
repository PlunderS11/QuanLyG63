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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
 
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
	private ArrayList<Object> dsTKTheoThang;
	private ArrayList<Object> dsTKTheoNam;
	private ArrayList<Object> dsTKTheoKhoang;
	private DecimalFormat df;
	private JButton btnXuat;
	

	public FrameThongKe() {
		
		df = new DecimalFormat("###");
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
		btnLamMoi.setBounds(154, 585, 134, 49);
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
		btnLoc.setBounds(10, 585, 134, 49);
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
		
		btnXuat = new JButton("in");
		
		btnXuat.setBounds(268, 637, 85, 21);
		panel.add(btnXuat);
		
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
		DecimalFormat df = new DecimalFormat("###,### VNĐ");
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
			if(radNgay.isSelected()) {
				xoaHetDLModel();
				if(txtLocTheoNgay.getDate()==null){
					JOptionPane.showMessageDialog(this, "Chọn ngày tháng năm!");
					xoaHetDLModel();
					return;
				}
				else {
					Date ngay = txtLocTheoNgay.getDate();
					DAO_ThongKe dao_ThongKe = new DAO_ThongKe();
					java.sql.Date ngaySQL = new java.sql.Date(ngay.getYear(),ngay.getMonth(),ngay.getDate());
					dsTKTheoNgay = dao_ThongKe.thongKeTheoNgay(ngaySQL);
					if(dsTKTheoNgay.size() == 0) {
						JOptionPane.showMessageDialog(this, "Không tìm thấy dữ liệu!");
						xoaHetDLModel();
						return;
					}
					double tongDoanhThu = 0;
					for(int i = 0;i<dsTKTheoNgay.size();i++) {
						String[] hopDong = (String[])dsTKTheoNgay.get(i);
						String maHD = hopDong[0];
						String maSP = hopDong[1];
						String tenKH = hopDong[2];
						String tenNV = hopDong[3];
						String tenXe = hopDong[4];
						String giaTien = hopDong[5];
						datamodel.addRow(new Object[] {maHD,maSP,tenKH,tenNV,tenXe,df.format(Double.parseDouble(giaTien))});
						tongDoanhThu += Double.parseDouble(giaTien);
					}
					lblSoXeBan.setText(String.valueOf(dsTKTheoNgay.size()));			
					lblTongDoanhThu.setText(chuyenTienVND(tongDoanhThu));
//					btnXuat.addActionListener(new ActionListener() {
//						
//						@Override
//						public void actionPerformed(ActionEvent e) {
//							JFileChooser fileDialog = new JFileChooser() {
//								@Override
//								protected JDialog createDialog(Component parent) throws HeadlessException {
//									JDialog dialog = super.createDialog(parent);
//									return dialog;
//								}
//							};
//							
//							
//							fileDialog.setAcceptAllFileFilterUsed(false);
//							int returnVal = fileDialog.showSaveDialog(null);
//							java.io.File file = fileDialog.getSelectedFile();
//							String filePath = file.getAbsolutePath();
//							Document doc = new Document(PageSize.A4);
//							
//							try {
//								PdfWriter.getInstance(doc, new FileOutputStream(filePath));
//								doc.open();
//								PdfPTable tbl = new PdfPTable(6);
//								tbl.setWidthPercentage(113);
//								
//								
//								
//								float[] columnWidths = new float[]{10f,10f, 30f, 30f,30f,20f};
//								tbl.setWidths(columnWidths);
//								tbl.addCell("Mã HD");
//								tbl.addCell("Mã SP");
//								tbl.addCell("Tên khách hàng");
//								tbl.addCell("Tên nhân viên");
//								tbl.addCell("Tên xe");
//								tbl.addCell("Giá");
//								for(int i=0;i<datamodel.getRowCount();i++) {
//									String maHD = datamodel.getValueAt(i, 0).toString();
//									String maSP = datamodel.getValueAt(i, 1).toString();
//									String tenKH = datamodel.getValueAt(i, 2).toString();
//									String tenNV = datamodel.getValueAt(i, 3).toString();
//									String tenXe = datamodel.getValueAt(i, 4).toString();
//									String gia = datamodel.getValueAt(i, 5).toString();
//									
//									tbl.addCell(maHD);
//									tbl.addCell(maSP);
//									tbl.addCell(tenKH);
//									tbl.addCell(tenNV);
//									tbl.addCell(tenXe);
//									tbl.addCell(gia);
//									
//									
//								}
//								doc.add(new Paragraph("\t \t \t \t \t \t \t \t \t \t \t \t \tCUA HANG XE MAY G63\n"
//										+ "	D/c: 12 Nguyen Van Bao, Phuong 4, Go Vap, TP.Ho Chi Minh \n"
//										+ "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t SDT: 0888244212\n"
//										+ "		Ten nhan vien: \t \t \t \t \t \t "
//										
//										
//										+ "\t \t \t \t \t \t \t XIN CAM ON VA HEN GAP LAI QUY KHACH !"));
//								
//								doc.add(tbl);
//								doc.close();
//							} catch (FileNotFoundException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							} catch (DocumentException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
//							JOptionPane.showMessageDialog(null, "Ghi file thành công!!", "Thành công",
//									JOptionPane.INFORMATION_MESSAGE);
//							
//							
//						}
//					});
//					
				}
			}
			
			else if(radKhac.isSelected()) {
				xoaHetDLModel();
				if(txtTuNgay.getDate()==null || txtDenNgay.getDate() == null){
					JOptionPane.showMessageDialog(this, "Chọn ngày tháng năm!");
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
						JOptionPane.showMessageDialog(this, "Không tìm thấy dữ liệu!");
						xoaHetDLModel();
						return;
					}
					double tongDoanhThu = 0;
					for(int i = 0;i<dsTKTheoKhoang.size();i++) {
						String[] hopDong = (String[])dsTKTheoKhoang.get(i);
						String maHD = hopDong[0];
						String maSP = hopDong[1];
						String tenKH = hopDong[2];
						String tenNV = hopDong[3];
						String tenXe = hopDong[4];
						String giaTien = hopDong[5];
						datamodel.addRow(new Object[] {maHD,maSP,tenKH,tenNV,tenXe,df.format(Double.parseDouble(giaTien))});
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
					JOptionPane.showMessageDialog(this, "Không tìm thấy dữ liệu");
					xoaHetDLModel();
					return;
				}
				double tongDoanhThu = 0;
				for(int i = 0;i<dsTKTheoThang.size();i++) {
					String[] hopDong = (String[])dsTKTheoThang.get(i);
					String maHD = hopDong[0];
					String maSP = hopDong[1];
					String tenKH = hopDong[2];
					String tenNV = hopDong[3];
					String tenXe = hopDong[4];
					String giaTien = hopDong[5];
					datamodel.addRow(new Object[] {maHD,maSP,tenKH,tenNV,tenXe,df.format(Double.parseDouble(giaTien))});
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
					JOptionPane.showMessageDialog(this, "Không tìm thấy dữ liệu");
					xoaHetDLModel();
					return;
				}
				
				double tongDoanhThu = 0;
				for(int i = 0;i<dsTKTheoNam.size();i++) {
					String[] hopDong = (String[])dsTKTheoNam.get(i);
					String maHD = hopDong[0];
					String maSP = hopDong[1];
					String tenKH = hopDong[2];
					String tenNV = hopDong[3];
					String tenXe = hopDong[4];
					String giaTien = hopDong[5];
					datamodel.addRow(new Object[] {maHD,maSP,tenKH,tenNV,tenXe,df.format(Double.parseDouble(giaTien))});
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
	}
}
