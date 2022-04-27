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

import connection.ConnectDB;
import dao.HangSanXuat_DAO;
import dao.LoaiXe_DAO;
import dao.Regex;
import dao.Xe_DAO;
import entity.HangSanXuat;
import entity.LoaiXe;
import entity.Xe;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrameXe extends JFrame implements ActionListener, MouseListener, ItemListener{



	private FixButton btnLamMoiXe;
	private JComboBox<String> cboMauXe;
	private JComboBox<String> cboLoaiXe;
	private JComboBox<String> cboTrangThai;
	private Regex regex;
	private FixButton btnThemXe;
	private FixButton btnSuaXe;
	private DecimalFormat dfGiaXe;
	private FixButton btnXoaXe;
	private FixButton btnTimXe;
	private JComboBox<String> cboSapXep;

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
		txtMaXe.setEditable(false);
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
		
		String mauXe[] = {"Xanh", "Đỏ", "Trắng", "Đen"};
		 cboMauXe = new JComboBox<String>(mauXe);
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
		
		String loaiXe[] = {"Xe tay ga", "Xe số"};
		 cboLoaiXe = new JComboBox<String>(loaiXe);
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
		
		String trangThai[] = {"Còn hàng", "Đang bán", "Đã bán"};
		cboTrangThai = new JComboBox<String>(trangThai);
		cboTrangThai.setEnabled(false);
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
		
		btnTimXe = new FixButton("Tìm");
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
		
		String sapXep[] = {"Chọn phương thức sắp xếp","Giá tiền từ thấp đến cao", "Giá tiền từ cao đến thấp"};
		cboSapXep = new JComboBox<String>(sapXep);
		cboSapXep.setBounds(192, 25, 214, 28);
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
		loadDanhSachXe();
		scrollPane.setViewportView(tableXe);
		
		btnLamMoiXe.addActionListener(this);
		tableXe.addMouseListener(this);
		btnThemXe.addActionListener(this);
		btnSuaXe.addActionListener(this);
		btnXoaXe.addActionListener(this);
		btnTimXe.addActionListener(this);

	}
	private DefaultTableModel modelXe;
	private JTextField txtMaXe;
	private JTextField txtTenXe;
	private JTextField txtSoKhung;
	private JTextField txtSoMay;
	private JTextField txtNhaCungCap;
	private JTextField txtHangSanXuat;
	private JTextField txtGiaNhap;	
	private JTextField txtTimKiem;
	private JTable tableXe;
	private Xe_DAO daoXe;
	private HangSanXuat_DAO daoHSX;
	private LoaiXe_DAO daoLoaiXe;
	
	public void loadDanhSachXe() {
		clearTable();
		ArrayList<Xe> lsXe =  daoXe.getDanhSachXe();

			for (Xe xe : lsXe) {
				HangSanXuat hsx = daoHSX.getHSXTheoMa(xe.getHangSanXuat().getMaHangSX());
				LoaiXe lx = daoLoaiXe.getLoaiXeTheoMa(xe.getLoaiXe().getMaLoaiXe());
				modelXe.addRow(new Object[] {
						xe.getMaXe(), xe.getTenXe(), xe.getMauXe(), xe.getSoKhung(), xe.getSoMay(), xe.getNhaCungCap(), hsx.getTenHangSX(), lx.getTenLoaiXe(), dfGiaXe.format(xe.getGiaXe()), xe.getTrangThai()
				});
			
		}
	}
	
	public void clearTable() {
		while (tableXe.getRowCount() > 0) {
			modelXe.removeRow(0);
		}
	}
	
	public void loadThongTinXe(Xe xe) {
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
		txtHangSanXuat.setText("");
		txtGiaNhap.setText("");
		txtTimKiem.setText("");
	}
	
	public void themXe() {
		try {
			if(regex.regexTen(txtTenXe) && regex.regexSoKhung(txtSoKhung) && regex.regexSoMay(txtSoMay) && regex.regexNhaCungCap(txtNhaCungCap) && regex.regexHangSanXuat(txtHangSanXuat) && regex.regexGiaXe(txtGiaNhap)) {
				String maXe = daoXe.getMaXe();
				String tenXe = txtTenXe.getText();
				String mauXe = cboMauXe.getSelectedItem().toString();
				String soKhung = txtSoKhung.getText();
				String soMay = txtSoMay.getText();
				String nhaCungCap = txtNhaCungCap.getText();
				HangSanXuat hangSanXuat = new HangSanXuat(daoHSX.getMaTheoHangSanXuat(txtHangSanXuat.getText())); 
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
				JTextField txtTam = new JTextField();
				String maXe = modelXe.getValueAt(row, 0).toString();
				double gia = Math.round(daoXe.getGiaXeTheoMa(maXe).getGiaXe());
				txtTam.setText(String.valueOf(Math.round(gia)));
				if(regex.regexTen(txtTenXe) && regex.regexSoKhung(txtSoKhung) && regex.regexSoMay(txtSoMay) && regex.regexNhaCungCap(txtNhaCungCap) && regex.regexHangSanXuat(txtHangSanXuat) && regex.regexGiaXe(txtTam)) {
					try {	
						String tenXe = txtTenXe.getText();
						String mauXe = cboMauXe.getSelectedItem().toString();
						String soKhung = txtSoKhung.getText();
						String soMay = txtSoMay.getText();
						String nhaCungCap = txtNhaCungCap.getText();
						HangSanXuat hangSanXuat = new HangSanXuat(daoHSX.getMaTheoHangSanXuat(txtHangSanXuat.getText())); 
						String trangThai = cboTrangThai.getSelectedItem().toString();
						LoaiXe loaiXe = new LoaiXe( daoLoaiXe.getMaTheoLoaiXe(cboLoaiXe.getSelectedItem().toString()));
						Xe xe = new Xe(maXe, tenXe, mauXe, soKhung, soMay, nhaCungCap, gia, hangSanXuat, loaiXe, trangThai);
						
						clearTable();
						daoXe.suaThongTinXe(xe);
						loadThongTinXe(xe);
						JOptionPane.showMessageDialog(this, "Thông tin xe đã được sửa!", "Thông báo",
								JOptionPane.OK_OPTION);
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
			int cancel = JOptionPane.showConfirmDialog(null, "Bạn muốn xóa thông tin xe này?", "Thông báo",
					JOptionPane.YES_NO_OPTION);
			if (cancel == JOptionPane.YES_OPTION) {
				String maXe = tableXe.getValueAt(row, 0).toString();
				try {
					modelXe.removeRow(row);
					clearTable();
					daoXe.xoaXe(maXe);
					loadDanhSachXe();
					JOptionPane.showMessageDialog(null, "Đã xóa Xe!", "Thông báo", JOptionPane.OK_OPTION);
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "xóa thông tin xe thất bại!", "Thông báo",
							JOptionPane.ERROR_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn lại");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn thông tin xe cần hủy!", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
		}
		return false;
	}
	
	public void timXe() {
		
		String regexMaXe = "((X|x)[0-9]{4})";
			if(!txtTimKiem.getText().equals("")) {
				if(regex.timMaXe(txtTimKiem)) {
					if(txtTimKiem.getText().trim().matches(regexMaXe)) {
						Xe xe = daoXe.getGiaXeTheoMa(txtTimKiem.getText());
						loadThongTinXe(xe);
					}
				}
			}
			else {
				clearTable();
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
			loadDanhSachXe();
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
		Object o = e.getSource();
		if(o.equals(tableXe)) {
			int row = tableXe.getSelectedRow();
			txtMaXe.setText(tableXe.getValueAt(row, 0).toString());
			txtTenXe.setText(tableXe.getValueAt(row, 1).toString());
			cboMauXe.setSelectedItem(tableXe.getValueAt(row, 2).toString());
			txtSoKhung.setText(tableXe.getValueAt(row, 3).toString());
			txtSoMay.setText(tableXe.getValueAt(row, 4).toString());
			txtNhaCungCap.setText(tableXe.getValueAt(row, 5).toString());
			txtHangSanXuat.setText(tableXe.getValueAt(row, 6).toString());
			cboLoaiXe.setSelectedItem(tableXe.getValueAt(row, 7).toString());
			txtGiaNhap.setText(tableXe.getValueAt(row, 8).toString());
			cboTrangThai.setSelectedItem(tableXe.getValueAt(row, 9).toString());
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

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	}
