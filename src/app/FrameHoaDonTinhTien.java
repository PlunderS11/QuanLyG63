package app;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.HeadlessException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JScrollPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.awt.event.ActionEvent;

public class FrameHoaDonTinhTien extends JFrame{
	Locale localeVN = new Locale("vi", "VN");
    NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
    
	public FrameHoaDonTinhTien(String tenKH, String tenNV, Date ngayMua, String tenXe, String mauXe, String soKhung, String soMay, String loaiXe, String hang, Double tien, Double tong) {
	setTitle("HÓA ĐƠN TÍNH TIỀN");
	setSize(500, 650);
	setLocationRelativeTo(null);
	setResizable(false);
	getContentPane().setLayout(null);
	
	JLabel lblTenQuan = new JLabel("CỬA HÀNG XE MÁY G63");
	lblTenQuan.setFont(new Font("Tahoma", Font.BOLD, 20));
	lblTenQuan.setBounds(135, 11, 238, 25);
	getContentPane().add(lblTenQuan);
	
	JLabel lblDiaChi = new JLabel("Address: 12 Nguyễn Văn Bảo, Phường 4, Gò Vấp, TP.Hồ Chí Minh");
	lblDiaChi.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblDiaChi.setBounds(21, 41, 450, 17);
	getContentPane().add(lblDiaChi);
	
	JLabel lblSDT = new JLabel("SĐT: 0888244212");
	lblSDT.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblSDT.setBounds(186, 63, 128, 17);
	getContentPane().add(lblSDT);
	
	JLabel lblNewLabel = new JLabel("HÓA ĐƠN TÍNH TIỀN");
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
	lblNewLabel.setBounds(152, 122, 191, 22);
	getContentPane().add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("Tên nhân viên:");
	lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblNewLabel_1.setBounds(32, 161, 108, 19);
	getContentPane().add(lblNewLabel_1);
	
	JLabel lblNewLabel_1_1 = new JLabel("Tên khách hàng:");
	lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblNewLabel_1_1.setBounds(31, 191, 120, 19);
	getContentPane().add(lblNewLabel_1_1);
	
	JLabel lblNewLabel_1_2 = new JLabel("Thời gian mua hàng:");
	lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblNewLabel_1_2.setBounds(32, 221, 148, 19);
	getContentPane().add(lblNewLabel_1_2);
	
	JLabel lblNewLabel_2 = new JLabel("-----------------------------------");
	lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 23));
	lblNewLabel_2.setBounds(81, 80, 350, 28);
	getContentPane().add(lblNewLabel_2);
	
	JLabel lblNewLabel_2_1 = new JLabel("----*---*----");
	lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 23));
	lblNewLabel_2_1.setBounds(182, 96, 140, 28);
	getContentPane().add(lblNewLabel_2_1);
	
	JLabel lblTenNV = new JLabel();
	lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblTenNV.setBounds(265, 161, 206, 19);
	lblTenNV.setText(tenNV);
	getContentPane().add(lblTenNV);
	
	JLabel lblTenKH = new JLabel();
	lblTenKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblTenKH.setBounds(265, 191, 206, 19);
	lblTenKH.setText(tenKH);
	getContentPane().add(lblTenKH);
	
	JLabel lblThoiGian = new JLabel();
	lblThoiGian.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblThoiGian.setBounds(265, 221, 206, 19);
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	lblThoiGian.setText(df.format(ngayMua));
	getContentPane().add(lblThoiGian);
	
	JLabel lblNewLabel_1_2_1_1 = new JLabel("Tên xe:");
	lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblNewLabel_1_2_1_1.setBounds(32, 251, 141, 19);
	getContentPane().add(lblNewLabel_1_2_1_1);
	
	JLabel lblNewLabel_1_2_1_2 = new JLabel("Màu xe:");
	lblNewLabel_1_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblNewLabel_1_2_1_2.setBounds(32, 281, 141, 19);
	getContentPane().add(lblNewLabel_1_2_1_2);
	
	JLabel lblNewLabel_1_2_1_3 = new JLabel("Số khung:");
	lblNewLabel_1_2_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblNewLabel_1_2_1_3.setBounds(32, 311, 141, 19);
	getContentPane().add(lblNewLabel_1_2_1_3);
	
	JLabel lblNewLabel_1_2_1_4 = new JLabel("Số máy:");
	lblNewLabel_1_2_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblNewLabel_1_2_1_4.setBounds(32, 341, 141, 19);
	getContentPane().add(lblNewLabel_1_2_1_4);
	
	JLabel lblNewLabel_1_2_1_5 = new JLabel("Loại xe:");
	lblNewLabel_1_2_1_5.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblNewLabel_1_2_1_5.setBounds(32, 371, 141, 19);
	getContentPane().add(lblNewLabel_1_2_1_5);
	
	JLabel lblNewLabel_1_2_1_6 = new JLabel("Hãng sản xuất:");
	lblNewLabel_1_2_1_6.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblNewLabel_1_2_1_6.setBounds(32, 401, 141, 19);
	getContentPane().add(lblNewLabel_1_2_1_6);
	
	JLabel lblNewLabel_1_2_1_7 = new JLabel("Giá xe:");
	lblNewLabel_1_2_1_7.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblNewLabel_1_2_1_7.setBounds(32, 431, 141, 19);
	getContentPane().add(lblNewLabel_1_2_1_7);
	
	JLabel lblTenXe = new JLabel();
	lblTenXe.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblTenXe.setBounds(265, 251, 108, 19);
	lblTenXe.setText(tenXe);
	getContentPane().add(lblTenXe);
	
	JLabel lblMauXe = new JLabel();
	lblMauXe.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblMauXe.setBounds(265, 281, 108, 19);
	lblMauXe.setText(mauXe);
	getContentPane().add(lblMauXe);
	
	JLabel lblSoKhung = new JLabel();
	lblSoKhung.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblSoKhung.setBounds(265, 311, 108, 19);
	lblSoKhung.setText(soKhung);
	getContentPane().add(lblSoKhung);
	
	JLabel lblSoMay = new JLabel();
	lblSoMay.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblSoMay.setBounds(265, 341, 108, 19);
	lblSoMay.setText(soMay);
	getContentPane().add(lblSoMay);
	
	JLabel lblLoaiXe = new JLabel();
	lblLoaiXe.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblLoaiXe.setBounds(265, 371, 108, 19);
	lblLoaiXe.setText(loaiXe);
	getContentPane().add(lblLoaiXe);
	
	JLabel lblHang = new JLabel();
	lblHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblHang.setBounds(265, 401, 108, 19);
	lblHang.setText(hang);
	getContentPane().add(lblHang);
	
	JLabel lblGiaXe = new JLabel();
	lblGiaXe.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblGiaXe.setBounds(265, 431, 108, 19);
	lblGiaXe.setText(currencyVN.format(tien));
	getContentPane().add(lblGiaXe);
	
	JLabel lblNewLabel_1_2_1_7_1 = new JLabel("Tổng hóa đơn:");
	lblNewLabel_1_2_1_7_1.setFont(new Font("Tahoma", Font.BOLD, 22));
	lblNewLabel_1_2_1_7_1.setBounds(67, 479, 158, 27);
	getContentPane().add(lblNewLabel_1_2_1_7_1);
	
	JLabel lblTong = new JLabel();
	lblTong.setFont(new Font("Tahoma", Font.PLAIN, 22));
	lblTong.setBounds(231, 479, 240, 27);
	lblTong.setText(currencyVN.format(tong));
	getContentPane().add(lblTong);
	
	JLabel lblNewLabel_3 = new JLabel("XIN CÁM ƠN VÀ HẸN GẶP LẠI QUÝ KHÁCH !");
	lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
	lblNewLabel_3.setBounds(33, 521, 438, 25);
	getContentPane().add(lblNewLabel_3);
	
	JButton btnIn = new FixButton("In hóa đơn");
	btnIn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JFileChooser fileDialog = new JFileChooser() {
				@Override
				protected JDialog createDialog(Component parent) throws HeadlessException {
					JDialog dialog = super.createDialog(parent);
					return dialog;
				}
			};
			FileFilter filter = new FileNameExtensionFilter("PDF(.pdf)", ".pdf");
			fileDialog.setAcceptAllFileFilterUsed(false);
			fileDialog.addChoosableFileFilter(filter);
			int returnVal = fileDialog.showSaveDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				java.io.File file = fileDialog.getSelectedFile();
				String filePath = file.getAbsolutePath();
				if(!(filePath.endsWith(".pdf"))) {
					filePath += ".pdf";
				}
				Document doc = new Document(PageSize.A5);
				try {
					PdfWriter.getInstance(doc, new FileOutputStream(filePath));
					doc.open();
					doc.add(new Paragraph("\t \t \t \t \t \t \t \t \t \t \t \t \tCUA HANG XE MAY G63\n"
							+ "	D/c: 12 Nguyen Van Bao, Phuong 4, Go Vap, TP.Ho Chi Minh \n"
							+ "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t SDT: 0888244212\n"
							+ "		Ten nhan vien: \t \t \t \t \t \t  "+tenNV+"\n"
							+ "		Ten khach hang: \t \t \t \t \t "+tenKH+"\n"
							+ "		Thoi gian mua hang: \t \t "+ngayMua+"\n"
							+ "		Ten xe: \t \t \t \t \t \t \t \t \t \t \t \t  "+tenXe+"\n"
							+ "		Mau xe: \t \t \t \t \t \t \t \t \t \t \t   "+mauXe+"\n"
							+ "		So khung: \t \t \t \t \t \t \t \t \t \t "+soKhung+"\n"
							+ "		So may: \t \t \t \t \t \t \t \t \t \t \t  "+soMay+"\n"
							+ "		Loai xe: \t \t \t \t \t \t \t \t \t \t \t   "+loaiXe+"\n"
							+ "		Hang san xuat: \t \t \t \t \t \t "+hang+"\n"
							+ "		Gia xe: \t \t \t \t \t \t \t \t \t \t \t \t  "+currencyVN.format(tien)+"\n"
							+ "\t \t \t \t \t \t \t \t Tong hoa đon:   "+tong+"\n"
							+ "\t \t \t \t \t \t \t XIN CAM ON VA HEN GAP LAI QUY KHACH !"));
					doc.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (DocumentException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Ghi file thành công!!", "Thành công",
							JOptionPane.INFORMATION_MESSAGE);
			}
		}
	});
	btnIn.setIcon(new ImageIcon("image\\inhoadon.png"));
	btnIn.setForeground(Color.WHITE);
	btnIn.setFont(new Font("Tahoma", Font.BOLD, 14));
	btnIn.setBackground(new Color(107, 96, 236));
	btnIn.setBounds(152, 557, 171, 41);
	getContentPane().add(btnIn);
	}
}