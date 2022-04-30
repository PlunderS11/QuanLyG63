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
import javax.swing.table.TableModel;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import connection.ConnectDB;
import dao.HangSanXuat_DAO;
import dao.LoaiXe_DAO;
import dao.Regex;
import dao.Xe_DAO;
import entity.HangSanXuat;
import entity.LoaiXe;
import entity.NhanVien;
import entity.Xe;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.sql.SQLException;

import java.text.DecimalFormat;

import java.text.NumberFormat;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.JScrollPane;
import javax.swing.JTable;


public class FrameXe extends JFrame implements ActionListener,MouseListener{
	Locale localeVN = new Locale("vi", "VN");
    NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);



	private FixButton btnLamMoiXe;
	private JComboBox<String> cboMauXe;
	private JComboBox<String> cboLoaiXe;
	private Regex regex;
	private FixButton btnThemXe;
	private FixButton btnSuaXe;
	private static DecimalFormat dfGiaXe;
	private FixButton btnXoaXe;
	private FixButton btnTimXe;
	private JComboBox<String> cboSapXep;
	private JTextField txtMauXe;
	private static DefaultTableModel modelXe;
	private JTextField txtMaXe;
	private JTextField txtTenXe;
	private JTextField txtSoKhung;
	private JTextField txtSoMay;
	private JTextField txtNhaCungCap;
	private JTextField txtGiaNhap;	
	private JComboBox txtTimKiem;
	private JTable tableXe;
	private Xe_DAO daoXe;
	private static HangSanXuat_DAO daoHSX;
	private static LoaiXe_DAO daoLoaiXe;
	private JComboBox<String> cboTrangThai;
	private JComboBox<String> cboHSX;

	public FrameXe() {
		
		//Connect database
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		//khai bao DAO
		daoXe = new Xe_DAO();
		daoLoaiXe = new LoaiXe_DAO();
		daoHSX = new HangSanXuat_DAO();
		
		//khai bao regex
		regex = new Regex();
		
		//dinh dang
		dfGiaXe=new DecimalFormat("###,###");
		
		//Giao dien
		setSize(1345, 705);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
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
		txtMaXe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMaXe.setEditable(false);
		txtMaXe.setBounds(103, 58, 214, 28);
		panel.add(txtMaXe);
		txtMaXe.setColumns(10);
		
		JLabel lblTenXe = new JLabel("Tên xe:");
		lblTenXe.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTenXe.setBounds(10, 101, 102, 14);
		panel.add(lblTenXe);
		
		txtTenXe = new JTextField();
		txtTenXe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenXe.setBounds(103, 96, 214, 28);
		panel.add(txtTenXe);
		txtTenXe.setColumns(10);
		
		JLabel lblMauXe = new JLabel("Màu xe:");
		lblMauXe.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMauXe.setBounds(10, 135, 102, 14);
		panel.add(lblMauXe);
		
//		String mauXe[] = {"Xanh", "Đỏ", "Trắng", "Đen"};
//		cboMauXe = new JComboBox<String>(mauXe);
		txtMauXe = new JTextField();
		txtMauXe.setBounds(103, 130, 214, 28);
		txtMauXe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(txtMauXe);
		
		JLabel lblSoXeung = new JLabel("Số Khung:");
		lblSoXeung.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSoXeung.setBounds(10, 170, 102, 23);
		panel.add(lblSoXeung);
		
		txtSoKhung = new JTextField();
		txtSoKhung.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSoKhung.setBounds(103, 165, 214, 28);
		panel.add(txtSoKhung);
		txtSoKhung.setColumns(10);
		
		JLabel lblSoMay = new JLabel("Số máy:");
		lblSoMay.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSoMay.setBounds(10, 207, 91, 23);
		panel.add(lblSoMay);
		
		txtSoMay = new JTextField();
		txtSoMay.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSoMay.setBounds(103, 202, 214, 28);
		panel.add(txtSoMay);
		txtSoMay.setColumns(10);
		
		JLabel lblNhaCungCap = new JLabel("Nhà cung cấp:");
		lblNhaCungCap.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNhaCungCap.setBounds(369, 63, 128, 23);
		panel.add(lblNhaCungCap);
		
		txtNhaCungCap = new JTextField();
		txtNhaCungCap.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNhaCungCap.setBounds(507, 58, 214, 28);
		panel.add(txtNhaCungCap);
		txtNhaCungCap.setColumns(10);
		
		JLabel lblHangSanXuat = new JLabel("Hãng sản xuất:");
		lblHangSanXuat.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHangSanXuat.setBounds(369, 101, 128, 23);
		panel.add(lblHangSanXuat);
		
		JLabel lblLoaiXe = new JLabel("Loại xe:");
		lblLoaiXe.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLoaiXe.setBounds(369, 135, 128, 23);
		panel.add(lblLoaiXe);
		

//		String loaiXe[] = {"Xe tay ga","Xe tay côn","Xe số"};
		 cboLoaiXe = new JComboBox<String>();
		 cboLoaiXe.addItem("Xe tay ga");
		 cboLoaiXe.addItem("Xe tay côn");
		 cboLoaiXe.addItem("Xe số");
		 cboLoaiXe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cboLoaiXe.setBounds(507, 130, 214, 28);
		panel.add(cboLoaiXe);
		
		JLabel lblGiaNhap = new JLabel("Giá nhập:");
		lblGiaNhap.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGiaNhap.setBounds(369, 170, 128, 23);
		panel.add(lblGiaNhap);
		
		txtGiaNhap = new JTextField();
		txtGiaNhap.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtGiaNhap.setBounds(507, 165, 214, 28);
		panel.add(txtGiaNhap);
		txtGiaNhap.setColumns(10);
		
		JLabel lblTrangThai = new JLabel("Trạng thái:");
		lblTrangThai.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTrangThai.setBounds(369, 207, 128, 23);
		panel.add(lblTrangThai);
		
		JLabel lblTimKiem = new JLabel("Tìm kiếm:");
		lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTimKiem.setBounds(9, 22, 91, 14);
		panel.add(lblTimKiem);
		
		txtTimKiem = new JComboBox();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTimKiem.setBounds(102, 17, 215, 28);
		txtTimKiem.addItem("");
		AutoCompleteDecorator.decorate(txtTimKiem);
		panel.add(txtTimKiem);
		for(Xe x : daoXe.getDanhSachXe()) {
			txtTimKiem.addItem(x.getMaXe());
		}
		
		btnTimXe = new FixButton("Tìm");
		btnTimXe.setIcon(new ImageIcon("image\\timkiem.png"));
		btnTimXe.setForeground(Color.WHITE);
		btnTimXe.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTimXe.setBackground(new Color(107,96,236));
		btnTimXe.setBounds(325, 15, 99, 32);
		panel.add(btnTimXe);
		
		cboTrangThai = new JComboBox<String>();
		cboTrangThai.setEnabled(false);
		cboTrangThai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cboTrangThai.addItem("Còn hàng");
		cboTrangThai.addItem("Đang bán");
		cboTrangThai.addItem("Đã bán");
		cboTrangThai.setBounds(507, 202, 214, 28);
		panel.add(cboTrangThai);
		
		cboHSX = new JComboBox<String>();
		cboHSX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cboHSX.setBounds(507, 94, 214, 28);
		
		for (HangSanXuat hsx : daoHSX.getDanhSachHangSanXat()) {
			cboHSX.addItem(hsx.getTenHangSX());
		}
		panel.add(cboHSX);
		
		
		JPanel pChucNang = new JPanel();
		pChucNang.setBounds(800, 11, 482, 86);
		pChucNang.setBackground(new Color(166, 169, 248));
		pChucNang.setBorder(new LineBorder(Color.BLACK));
		pChucNang.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1, true), "Chức năng",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(pChucNang);
		
		btnThemXe = new FixButton("Thêm");
		
		btnThemXe.setIcon(new ImageIcon("image\\them.png"));
		
		btnThemXe.setForeground(Color.WHITE);
		btnThemXe.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThemXe.setBackground(new Color(107,96,236));
		btnThemXe.setBounds(0, 336, 115, 49);
		pChucNang.add(btnThemXe);
		
		btnXoaXe = new FixButton("Xóa");
		btnXoaXe.setIcon(new ImageIcon("image\\xoa.png"));
		btnXoaXe.setForeground(Color.WHITE);
		btnXoaXe.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoaXe.setBackground(new Color(107,96,236));
		btnXoaXe.setBounds(125, 336, 109, 49);
		pChucNang.add(btnXoaXe);
		
		btnSuaXe = new FixButton("Sửa");
	
		btnSuaXe.setIcon(new ImageIcon("image\\capnhat.png"));
		btnSuaXe.setForeground(Color.WHITE);
		btnSuaXe.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSuaXe.setBackground(new Color(107,96,236));
		btnSuaXe.setBounds(244, 336, 109, 49);
		pChucNang.add(btnSuaXe);
		
		btnLamMoiXe = new FixButton("Làm mới");
		btnLamMoiXe.setIcon(new ImageIcon("image\\lammoi.png"));
		btnLamMoiXe.setForeground(Color.WHITE);
		btnLamMoiXe.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLamMoiXe.setBackground(new Color(107,96,236));
		btnLamMoiXe.setBounds(366, 336, 138, 49);
		pChucNang.add(btnLamMoiXe);
		
		JPanel pSapXep = new JPanel();
		pSapXep.setLayout(null);
		pSapXep.setBounds(800, 116, 482, 71);
		pSapXep.setBackground(new Color(166, 169, 248));
		pSapXep.setBorder(new LineBorder(Color.BLACK));
		pSapXep.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1, true), "Sắp xếp",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(pSapXep);
		
		JLabel lblSapXep = new JLabel("Loại sắp xếp:");
		lblSapXep.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSapXep.setBounds(74, 30, 108, 23);
		pSapXep.add(lblSapXep);
		
//		String sapXep[] = {"Chọn phương thức sắp xếp","Giá tiền từ thấp đến cao", "Giá tiền từ cao đến thấp"};
		cboSapXep = new JComboBox<String>();
		cboSapXep.addItem("Chọn phương thức sắp xếp");
		cboSapXep.addItem("Giá tiền từ thấp đến cao");
		cboSapXep.addItem("Giá tiền từ cao đến thấp");
		cboSapXep.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cboSapXep.setBounds(192, 25, 230, 28);
		//loadDanhSachXe();
		cboSapXep.addItemListener(new ItemListener() {
			
				
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange() == ItemEvent.SELECTED) {
					if(cboSapXep.getSelectedItem().toString().equals("Giá tiền từ cao đến thấp")) {
						clearTable();
						sapXepGiaGiamDan();
					}
					if(cboSapXep.getSelectedItem().toString().equals("Giá tiền từ thấp đến cao")) {
						clearTable();
						sapXepGiaTangDan();
					}
				

					
				}
			}
		});
		pSapXep.add(cboSapXep);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 274, 1311, 335);
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
		tableXe.setModel(modelXe = new DefaultTableModel(
				new Object[][] {
					
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
		hienThiDanhSachXe();
		scrollPane.setViewportView(tableXe);
		
		FixButton btnNhapExcel = new FixButton("Nhập Excel");
		btnNhapExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileDialog = new JFileChooser() {
					@Override
					protected JDialog createDialog(Component parent) throws HeadlessException {
						JDialog dialog = super.createDialog(parent);
						return dialog;
					}
				};
				int returnVal = fileDialog.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					java.io.File file = fileDialog.getSelectedFile();
					if (file.getName().endsWith(".xls")) {
						docFileExcel(file.getAbsolutePath());
					}
					else {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn file Excel để đọc file", "Lỗi",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
			}
		});
		btnNhapExcel.setIcon(new ImageIcon("image\\docfile.png"));
		btnNhapExcel.setForeground(Color.WHITE);
		btnNhapExcel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNhapExcel.setBackground(new Color(107, 96, 236));
		btnNhapExcel.setBounds(976, 198, 174, 49);
		getContentPane().add(btnNhapExcel);
		
		btnLamMoiXe.addActionListener(this);
		tableXe.addMouseListener(this);
		btnThemXe.addActionListener(this);
		btnSuaXe.addActionListener(this);
		btnXoaXe.addActionListener(this);
		btnTimXe.addActionListener(this);
		phatSinhMaXe();

	}

	
	public void hienThiDanhSachXe() {
		clearTable();
		ArrayList<Xe> lsXe = daoXe.getDanhSachXe();
		for(Xe xe : lsXe) {
			HangSanXuat hsx = daoHSX.getHSXTheoMa(xe.getHangSanXuat().getMaHangSX());
			LoaiXe lx = daoLoaiXe.getLoaiXeTheoMa(xe.getLoaiXe().getMaLoaiXe());
			modelXe.addRow(new Object[] {
					xe.getMaXe(), xe.getTenXe(), xe.getMauXe(), xe.getSoKhung(), xe.getSoMay(), xe.getNhaCungCap(), hsx.getTenHangSX(), lx.getTenLoaiXe(), dfGiaXe.format(xe.getGiaXe()), xe.getTrangThai()

			});
			
			
			
		}
	}
	
	public void loadDanhSachXe() {
		clearTable();
		ArrayList<Xe> lsXe =  daoXe.getDanhSachXe();

			for (Xe xe : lsXe) {
				HangSanXuat hsx = daoHSX.getHSXTheoMa(xe.getHangSanXuat().getMaHangSX());
				LoaiXe lx = daoLoaiXe.getLoaiXeTheoMa(xe.getLoaiXe().getMaLoaiXe());
				modelXe.addRow(new Object[] {
						xe.getMaXe(), xe.getTenXe(), xe.getMauXe(), xe.getSoKhung(), xe.getSoMay(), xe.getNhaCungCap(), hsx.getTenHangSX(), lx.getTenLoaiXe(), currencyVN.format(xe.getGiaXe()), xe.getTrangThai()

				});
			
		}
	}
	
	public void clearTable() {
		while (tableXe.getRowCount() > 0) {
			modelXe.removeRow(0);
		}
	}
	
	public static void loadThongTinXe(Xe xe) {
		HangSanXuat hsx = daoHSX.getHSXTheoMa(xe.getHangSanXuat().getMaHangSX());
		LoaiXe lx = daoLoaiXe.getLoaiXeTheoMa(xe.getLoaiXe().getMaLoaiXe());
		modelXe.addRow(new Object[] {
				xe.getMaXe(), xe.getTenXe(), xe.getMauXe(), xe.getSoKhung(), xe.getSoMay(), xe.getNhaCungCap(), hsx.getTenHangSX(), lx.getTenLoaiXe(), dfGiaXe.format(xe.getGiaXe()), xe.getTrangThai()
		});
	}
	public void sapXepGiaGiamDan() {
		ArrayList<Xe> lsXe = daoXe.sortByGia();
		for (Xe xe : lsXe) {
			HangSanXuat hsx = daoHSX.getHSXTheoMa(xe.getHangSanXuat().getMaHangSX());
			LoaiXe lx = daoLoaiXe.getLoaiXeTheoMa(xe.getLoaiXe().getMaLoaiXe());
			modelXe.addRow(new Object[] {
					xe.getMaXe(), xe.getTenXe(), xe.getMauXe(), xe.getSoKhung(), xe.getSoMay(), xe.getNhaCungCap(), hsx.getTenHangSX(), lx.getTenLoaiXe(), dfGiaXe.format(xe.getGiaXe()), xe.getTrangThai()
			});	
	}
	}
	
	public void sapXepGiaTangDan() {
		ArrayList<Xe> lsXe = daoXe.sortByGiaTangDan();
		for (Xe xe : lsXe) {
			HangSanXuat hsx = daoHSX.getHSXTheoMa(xe.getHangSanXuat().getMaHangSX());
			LoaiXe lx = daoLoaiXe.getLoaiXeTheoMa(xe.getLoaiXe().getMaLoaiXe());
			modelXe.addRow(new Object[] {
					xe.getMaXe(), xe.getTenXe(), xe.getMauXe(), xe.getSoKhung(), xe.getSoMay(), xe.getNhaCungCap(), hsx.getTenHangSX(), lx.getTenLoaiXe(), dfGiaXe.format(xe.getGiaXe()), xe.getTrangThai()
			});	
	}
	}
	
	public void clearAll() {
		txtMaXe.setText("");
		txtTenXe.setText("");
		txtSoKhung.setText("");
		txtSoMay.setText("");
		txtNhaCungCap.setText("");
		cboHSX.setSelectedIndex(0);
		txtGiaNhap.setText("");
		txtTimKiem.setSelectedIndex(0);;
		cboTrangThai.setSelectedIndex(0);
		cboLoaiXe.setSelectedIndex(0);
		cboSapXep.setSelectedIndex(0);
		txtMauXe.setText("");
		phatSinhMaXe();
		cboHSX.removeAllItems();
		for (HangSanXuat hsx : daoHSX.getDanhSachHangSanXat()) {
			cboHSX.addItem(hsx.getTenHangSX());
		}
	}
	
	public void themXe() {
		try {
			if(regex.regexTen(txtTenXe) && regex.regexSoKhung(txtSoKhung) && regex.regexSoMay(txtSoMay) && regex.regexNhaCungCap(txtNhaCungCap) && regex.regexGiaXe(txtGiaNhap)) {
				String maXe = txtMaXe.getText();
				String tenXe = txtTenXe.getText();
				String mauXe = txtMauXe.getText();
				String soKhung = txtSoKhung.getText();
				String soMay = txtSoMay.getText();
				String nhaCungCap = txtNhaCungCap.getText();
				HangSanXuat hangSanXuat = new HangSanXuat(daoHSX.getMaTheoHangSanXuat(cboHSX.getSelectedItem().toString())); 
				String trangThai = cboTrangThai.getSelectedItem().toString();
				
				LoaiXe loaiXe = new LoaiXe( daoLoaiXe.getMaTheoLoaiXe(cboLoaiXe.getSelectedItem().toString()));
				double giaXe = Double.parseDouble(txtGiaNhap.getText());
				
				Xe xe = new Xe(maXe, tenXe, mauXe, soKhung, soMay, nhaCungCap, giaXe, hangSanXuat, loaiXe, trangThai);
				
				daoXe.themDanhSachXe(xe);
				loadThongTinXe(xe);
				JOptionPane.showMessageDialog(this, "Thêm thông tin xe thành công");	
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin", "Thông báo", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void suaThongTinXe() {
		int row = tableXe.getSelectedRow();
		if(row >= 0 ) {
			int update = JOptionPane.showConfirmDialog(this, "Bạn muốn sửa thông tin xe này không?", "Thông báo",
					JOptionPane.YES_NO_OPTION);
			if(update == JOptionPane.YES_OPTION) {
//				JTextField txtTam = new JTextField();
//				String maXe = modelXe.getValueAt(row, 0).toString();
//				double gia = Math.round(daoXe.getGiaXeTheoMa(maXe).getGiaXe());
//				//System.out.println(gia);
//				
//				
//				txtTam.setText(String.valueOf(Math.round(giaXe)));
				//System.out.println(regex.regexGiaXe(txtTam));
				int r = tableXe.getSelectedRow();
				if(regex.regexTen(txtTenXe) && regex.regexSuaSoKhung(txtSoKhung,modelXe.getValueAt(r, 3).toString()) && regex.regexSuaSoMay(txtSoMay,modelXe.getValueAt(r, 4).toString()) && regex.regexNhaCungCap(txtNhaCungCap) && regex.regexGiaXe(txtGiaNhap)) {
					try {	
						String maXe = txtMaXe.getText();
						String tenXe = txtTenXe.getText();
						String mauXe = txtMauXe.getText();
						String soKhung = txtSoKhung.getText();
						String soMay = txtSoMay.getText();
						String nhaCungCap = txtNhaCungCap.getText();
						double giaXe = Double.parseDouble(txtGiaNhap.getText().toString());
						HangSanXuat hangSanXuat = new HangSanXuat(daoHSX.getMaTheoHangSanXuat(cboHSX.getSelectedItem().toString())); 
						String trangThai = cboTrangThai.getSelectedItem().toString();
						LoaiXe loaiXe = new LoaiXe( daoLoaiXe.getMaTheoLoaiXe(cboLoaiXe.getSelectedItem().toString()));
						Xe xe = new Xe(maXe, tenXe, mauXe, soKhung, soMay, nhaCungCap, giaXe, hangSanXuat, loaiXe, trangThai);
						daoXe.suaThongTinXe(xe);
						loadDanhSachXe();
						JOptionPane.showMessageDialog(this, "Thông tin xe đã được sửa!", "Thông báo",
								JOptionPane.INFORMATION_MESSAGE);
					} catch (Exception e) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại thông tin xe!!", "Thông báo",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn thông tin xe cần sửa!", "Thông báo",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
	private boolean xoaThongTinXe() {
		int row = tableXe.getSelectedRow();
		if (row >= 0) {
			if (modelXe.getValueAt(row, 9).toString().equalsIgnoreCase("Còn hàng")) {
				int cancel = JOptionPane.showConfirmDialog(null, "Bạn muốn xóa thông tin xe này?", "Thông báo",
						JOptionPane.YES_NO_OPTION);
				if (cancel == JOptionPane.YES_OPTION) {
					String maXe = tableXe.getValueAt(row, 0).toString();
					try {
						daoXe.xoaXe(maXe);
						modelXe.removeRow(row);
						clearTable();					
						hienThiDanhSachXe();
						JOptionPane.showMessageDialog(null, "Đã xóa Xe!", "Thông báo", JOptionPane.OK_OPTION);
					} catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Xóa thông tin xe thất bại!", "Thông báo",
								JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn lại");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Chỉ xóa được những xe có trạng thái 'Còn hàng'!", "Thông báo",
						JOptionPane.ERROR_MESSAGE);
			}
			
		} else {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn thông tin xe cần hủy!", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
		}
		return false;
	}
	
	public void timXe() {
		String ma = txtTimKiem.getSelectedItem().toString();
			if(!ma.equalsIgnoreCase("")) {
				Xe xe = daoXe.getGiaXeTheoMa(ma);
				clearTable();
				loadThongTinXe(xe);
			}
			else {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin tìm kiếm!", "Thông báo",
						JOptionPane.WARNING_MESSAGE);
			}
	}
	
	
	public static void main(String[] args) {
		new FrameXe().setVisible(true);

}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnLamMoiXe))
		{
			clearAll();
			hienThiDanhSachXe();
		}
		if(o.equals(btnThemXe))
			themXe();
		if(o.equals(btnSuaXe))
			suaThongTinXe();
		if(o.equals(btnXoaXe))
			xoaThongTinXe();
		if(o.equals(btnTimXe))
			timXe();

		//if()
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	
		
			int row = tableXe.getSelectedRow();
			txtMaXe.setText(modelXe.getValueAt(row, 0).toString());
			txtTenXe.setText(modelXe.getValueAt(row, 1).toString());
			txtMauXe.setText(modelXe.getValueAt(row, 2).toString());
			txtSoKhung.setText(modelXe.getValueAt(row, 3).toString());
			txtSoMay.setText(modelXe.getValueAt(row, 4).toString());
			txtNhaCungCap.setText(modelXe.getValueAt(row, 5).toString());
			cboHSX.setSelectedItem(modelXe.getValueAt(row, 6).toString());
			cboLoaiXe.setSelectedItem(modelXe.getValueAt(row, 7).toString());
			txtGiaNhap.setText(modelXe.getValueAt(row, 8).toString());

			String trangThai =  modelXe.getValueAt(row, 9).toString();
			if (trangThai.equalsIgnoreCase("Còn hàng")) {
				cboTrangThai.setSelectedIndex(0);
			} else if(trangThai.equalsIgnoreCase("Đang bán")) {
				cboTrangThai.setSelectedIndex(1);
			} else {
				cboTrangThai.setSelectedIndex(2);
			}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	private void phatSinhMaXe() {
		
		if (daoXe.getDanhSachXe().isEmpty()) {
			txtMaXe.setText("X0001");
		} else {
			
			String ma = daoXe.getMaXeCuoi();
			String ma1 = ma.substring(0, 1);
			String ma2 = ma.substring(1);
			int ma3 = Integer.parseInt(ma2)+1;
			DecimalFormat df = new DecimalFormat("0000");
			txtMaXe.setText(ma1+df.format(ma3));
		}
	}
	public void docFileExcel(String filePath) {
		List<Xe> dsXeDocTuFile = new ArrayList<Xe>();
		try {
			FileInputStream iStream = null;
			HSSFWorkbook workbook;
			try {
				iStream = new FileInputStream(filePath);
				workbook = new HSSFWorkbook(iStream);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "File không hợp lệ!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
				return;
			}
			HSSFSheet worksheet = workbook.getSheet("DANH SÁCH XE");

			if (worksheet == null) {
				JOptionPane.showMessageDialog(this, "File không có worksheet \"DANH SÁCH XE\"", "Lỗi", JOptionPane.ERROR_MESSAGE);
				workbook.close();
				return;
			}

			String[] title = { "STT", "Tên xe", "Màu xe", "Số khung", "Số máy", "Nhà cung cấp", "Hãng cung cấp", "Loại xe", "Giá xe" };
			HSSFRow row0 = worksheet.getRow(0);
			for (int i = 0; i < title.length; i++) {
				String temp = "";
				try {
					temp = row0.getCell(i).getStringCellValue();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(this, "File không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
					workbook.close();
					return;
				}
				if (!temp.trim().equals(title[i])) {
					JOptionPane.showMessageDialog(this, "File excel không đúng định dạng", "Lỗi", JOptionPane.ERROR_MESSAGE);
					workbook.close();
					return;
				}
			}

			HSSFRow row = worksheet.getRow(1);
			int i = 1;
			// Đọc dữ liệu vào list
			String temp = "";
			try {
				temp = row.getCell(1).getStringCellValue();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Dòng "+(i+1)+" file Excel sai định dạng!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
				workbook.close();
				return;
			}
			while (!temp.trim().equals("")) {
				try {
					String maXe = "ma";
					String tenXe = row.getCell(1).getStringCellValue();
					String mauXe = row.getCell(2).getStringCellValue();
					int soKhungcell = (int) row.getCell(3).getNumericCellValue();
					String soKhung = String.valueOf(soKhungcell);
					int soMaycell = (int) row.getCell(4).getNumericCellValue();
					String soMay = String.valueOf(soMaycell);
					String NCC = row.getCell(5).getStringCellValue();
					String HSXcell = row.getCell(6).getStringCellValue();
					HangSanXuat HSX = new HangSanXuat(daoHSX.getMaTheoHangSanXuat(HSXcell));
					String lxcell = row.getCell(7).getStringCellValue();
					LoaiXe loaiXe = new LoaiXe(daoLoaiXe.getMaTheoLoaiXe(lxcell));
					double giaTien = row.getCell(8).getNumericCellValue();
					String trangThai = "Còn hàng";
					Xe x = new Xe(maXe, tenXe, mauXe, soKhung, soMay , NCC, giaTien, HSX, loaiXe, trangThai);
					dsXeDocTuFile.add(x);
					row = worksheet.getRow(++i);
					if (row == null)
						break;
					temp = row.getCell(1).getStringCellValue();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(this, "Dòng "+(i+1)+" file Excel sai định dạng", "Lỗi", JOptionPane.ERROR_MESSAGE);
					workbook.close();
					return;
				}
			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (dsXeDocTuFile == null) {
			JOptionPane.showMessageDialog(this, "File không hợp lệ!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			return;
		}	
		for(Xe xeDocTuFile : dsXeDocTuFile) {
			if (daoXe.getDanhSachXe().isEmpty()) {
				xeDocTuFile.setMaXe("X0001");
			} else {
				DecimalFormat df = new DecimalFormat("0000");
				String ma = daoXe.getMaXeCuoi();				
				int layMaSo = Integer.parseInt(ma.substring(1, ma.length())); 
				String maXe = "X" + df.format(layMaSo + 1);
				
				xeDocTuFile.setMaXe(maXe);
			}
			
//			if (daoXe.getDanhSachXe().isEmpty()) {
//				xeDocTuFile.setMauXe("X0001");
//			} else {
//				
//				String ma = daoXe.getMaXeCuoi();
//				String ma1 = ma.substring(0, 1);
//				String ma2 = ma.substring(1);
//				int ma3 = Integer.parseInt(ma2)+1;
//				DecimalFormat df = new DecimalFormat("0000");
//				xeDocTuFile.setMauXe(ma1+df.format(ma3));
//			}
			Xe x = new Xe(xeDocTuFile.getMaXe(), xeDocTuFile.getTenXe(), xeDocTuFile.getMauXe(), xeDocTuFile.getSoKhung(), 
					xeDocTuFile.getSoMay(), xeDocTuFile.getNhaCungCap(), xeDocTuFile.getGiaXe(), xeDocTuFile.getHangSanXuat(), 
					xeDocTuFile.getLoaiXe(), "Còn hàng");
			daoXe.themDanhSachXe(x);
			loadDanhSachXe();	
		}
		JOptionPane.showMessageDialog(this, "Đọc file thành công!!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
	}
}
