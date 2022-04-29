package app;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import dao.HangSanXuat_DAO;
import dao.Regex;
import dao.Xe_DAO;
import entity.HangSanXuat;
import entity.LoaiXe;
import entity.Xe;

public class FrameHangSanXuat extends JFrame implements ActionListener, MouseListener{
	private JTextField txtTimKiem;
	private JTextField txtMaHangXe;
	private JTextField txtTenHangXe;
	private JTextField txtNguonGoc;
	private JTable tableHangXe;
	private JTable tableTenXe;
	private DefaultTableModel modelHangXe;
	private DefaultTableModel modelTenXe;
	private HangSanXuat_DAO daoHSX;
	private Xe_DAO daoXe;
	private FixButton btnThemHX;
	private FixButton btnSuaHX;
	private FixButton btnLamMoiHX;
	private Regex regex;
	private FixButton btnTimHX;
	private FixButton btnXoaHX;
	
	public FrameHangSanXuat() {
		
		//khai bao regex
		regex = new Regex();
		
		//Khai bao DAO
		daoHSX = new HangSanXuat_DAO();
		daoXe = new Xe_DAO();
		
		// TODO Auto-generated constructor stub
		setSize(1345, 705);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(166, 169, 248));	
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		//panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(new Color(166, 169, 248));
		panel.setBounds(0, 0, 796, 136);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
		
		JLabel lblTimKiem = new JLabel("Tìm kiếm:");
		lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTimKiem.setBounds(20, 22, 91, 14);
		panel.add(lblTimKiem);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTimKiem.setBounds(108, 18, 214, 28);
		panel.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		btnTimHX = new FixButton("Tìm");
		btnTimHX.setIcon(new ImageIcon("image\\timkiem.png"));
	
		
		btnTimHX.setForeground(Color.WHITE);
		btnTimHX.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTimHX.setBackground(new Color(107,96,236));
		btnTimHX.setBounds(332, 15, 99, 32);
		panel.add(btnTimHX);
		
		JLabel lblMaHangXe = new JLabel("Mã hãng xe:");
		lblMaHangXe.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMaHangXe.setBounds(458, 14, 116, 20);
		panel.add(lblMaHangXe);
		
		txtMaHangXe = new JTextField();
		txtMaHangXe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMaHangXe.setEditable(false);
		txtMaHangXe.setBounds(572, 12, 214, 28);
		panel.add(txtMaHangXe);
		txtMaHangXe.setColumns(10);
		
		JLabel lblTenHangXe = new JLabel("Tên hãng xe:");
		lblTenHangXe.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTenHangXe.setBounds(458, 52, 116, 20);
		panel.add(lblTenHangXe);
		
		txtTenHangXe = new JTextField();
		txtTenHangXe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenHangXe.setBounds(572, 49, 214, 28);
		panel.add(txtTenHangXe);
		txtTenHangXe.setColumns(10);
		
		txtNguonGoc = new JTextField();
		txtNguonGoc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNguonGoc.setBounds(572, 87, 214, 28);
		panel.add(txtNguonGoc);
		txtNguonGoc.setColumns(10);
		
		JLabel lblNgunGc = new JLabel("Nguồn gốc:");
		lblNgunGc.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNgunGc.setBounds(459, 90, 99, 20);
		panel.add(lblNgunGc);
		
		JPanel pChucNang = new JPanel();
		pChucNang.setBounds(839, 11, 480, 86);
		pChucNang.setBackground(new Color(166, 169, 248));
		pChucNang.setBorder(new LineBorder(Color.BLACK));
		pChucNang.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1, true), "Chức năng",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(pChucNang);
		
		btnThemHX = new FixButton("Thêm");
		
		btnThemHX.setIcon(new ImageIcon("image\\them.png"));
		
		btnThemHX.setForeground(Color.WHITE);
		btnThemHX.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThemHX.setBackground(new Color(107,96,236));
		btnThemHX.setBounds(0, 336, 115, 49);
		pChucNang.add(btnThemHX);
		 
		 btnXoaHX = new FixButton("Thêm");
		 btnXoaHX.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		int r = tableHangXe.getSelectedRow();
				if (r==-1) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng cần xóa!");
				} else {
					if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa khách hàng này không?", "Cảnh báo", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
						daoHSX.delete(modelHangXe.getValueAt(r, 0).toString());
						modelHangXe.removeRow(r);
						JOptionPane.showMessageDialog(null, "Xóa thành công!");
					}
				}
		 	}
		 });
		 btnXoaHX.setIcon(new ImageIcon("image\\xoa.png"));
		 btnXoaHX.setText("Xóa");
		 btnXoaHX.setForeground(Color.WHITE);
		 btnXoaHX.setFont(new Font("Tahoma", Font.BOLD, 14));
		 btnXoaHX.setBackground(new Color(107, 96, 236));
		 pChucNang.add(btnXoaHX);
		

		
		 btnSuaHX = new FixButton("Sửa");
	
		btnSuaHX.setIcon(new ImageIcon("image\\capnhat.png"));
		btnSuaHX.setForeground(Color.WHITE);
		btnSuaHX.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSuaHX.setBackground(new Color(107,96,236));
		btnSuaHX.setBounds(244, 336, 109, 49);
		pChucNang.add(btnSuaHX);
		
		 btnLamMoiHX = new FixButton("Làm mới");
		btnLamMoiHX.setIcon(new ImageIcon("image\\lammoi.png"));
		btnLamMoiHX.setForeground(Color.WHITE);
		btnLamMoiHX.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLamMoiHX.setBackground(new Color(107,96,236));
		btnLamMoiHX.setBounds(366, 336, 138, 49);
		pChucNang.add(btnLamMoiHX);
		
		JScrollPane scrlHangXe = new JScrollPane();
		scrlHangXe.setBounds(10, 140, 1309, 199);
		getContentPane().add(scrlHangXe);
		
		//tableLoaiXe = new JTable();
		tableHangXe = new JTable(){
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
		tableHangXe.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tableHangXe.setGridColor(getBackground());
		tableHangXe.setRowHeight(tableHangXe.getRowHeight() + 20);
		tableHangXe.setSelectionBackground(new Color(166, 169, 248));
		
		JTableHeader tableHeaderHangXe = tableHangXe.getTableHeader();
		tableHeaderHangXe.setBackground(new Color(79, 12, 132));
		tableHeaderHangXe.setForeground(Color.WHITE);
		tableHeaderHangXe.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		tableHangXe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableHangXe.setModel(modelHangXe = new DefaultTableModel(
				new Object[][] {
					
				},
				new String[] {
						"Mã hãng xe", "Tên hãng xe", "Nguồn gốc"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		scrlHangXe.setViewportView(tableHangXe);
		
		JScrollPane scrlTenXe = new JScrollPane();
		scrlTenXe.setBounds(10, 349, 1309, 255);
		loadDanhSachHangXe();
		
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
		tableTenXe.setModel(modelTenXe = new DefaultTableModel(
				new Object[][] {
					
				},
				new String[] {
						"Mã xe", "Tên xe"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		scrlTenXe.setViewportView(tableTenXe);
		tableHangXe.addMouseListener(this);
		btnThemHX.addActionListener(this);
		btnSuaHX.addActionListener(this);
		btnLamMoiHX.addActionListener(this);
		btnTimHX.addActionListener(this);
		phatSinhMaHSX();
	}
	public void themHangSanXuat() {
		try {
			if (!kiemTra()) {
				return;
			} else {
				String maHSX = txtMaHangXe.getText();
				String tenHSX = txtTenHangXe.getText();
				String nguonGoc = txtNguonGoc.getText();
				
				HangSanXuat hsx = new HangSanXuat(maHSX, tenHSX, nguonGoc);
				daoHSX.themHangSanXuat(hsx);
				clearTableHangXe();
				loadDanhSachHangXe();
				JOptionPane.showMessageDialog(this, "Thêm hãng xe thành công");	
			}
				
				
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin", "Thông báo", JOptionPane.WARNING_MESSAGE);
		}
		
		
	}
	
	public void suaThongTinHangSanXuat() {
		int row = tableHangXe.getSelectedRow();
		if(row >= 0 ) {
			int update = JOptionPane.showConfirmDialog(this, "Bạn muốn sửa thông tin hãng này không?", "Thông báo",
					JOptionPane.YES_NO_OPTION);
			if(update == JOptionPane.YES_OPTION) {
				if (!kiemTra1()) {
					return;
				} else {
					try {	
						String maHSX = txtMaHangXe.getText();
						String tenHSX = txtTenHangXe.getText();
						String nguonGoc = txtNguonGoc.getText();
						HangSanXuat hsx = new HangSanXuat(maHSX, tenHSX, nguonGoc);
						clearTableHangXe();
						daoHSX.suaThongTinHangSanXuat(hsx);
						loadDanhSachHangXe();
						JOptionPane.showMessageDialog(this, "Thông tin hãng đã được sửa!", "Thông báo",
								JOptionPane.OK_OPTION);
					} catch (Exception e) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại thông tin hãng!!", "Thông báo",
								JOptionPane.ERROR_MESSAGE);
					}
				}
					
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn thông tin hãng cần sửa!", "Thông báo",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	public void timXe() {
		String regexMaXe = "((X|x)[0-9]{4})";
			if(!txtTimKiem.getText().equals("")) {
				if(regex.timMaXe(txtTimKiem)) {
					if(txtTimKiem.getText().trim().matches(regexMaXe)) {
						Xe xe = daoXe.getGiaXeTheoMa(txtTimKiem.getText());
						HangSanXuat hsx = daoHSX.getHSXTheoMa(xe.getLoaiXe().getMaLoaiXe());
						JOptionPane.showMessageDialog(this, "Xe "+xe.getMaXe()+" có hãng sản xuất là "+hsx.getTenHangSX()+"", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
			else {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin tìm kiếm!", "Thông báo",
						JOptionPane.WARNING_MESSAGE);
			}
	}
	
	
	public void clearAll() {
		txtMaHangXe.setText("");
		txtTenHangXe.setText("");
		txtNguonGoc.setText("");
		clearTableHangXe();
		clearTableXe();
		loadDanhSachHangXe();
		phatSinhMaHSX();
	}
	
	public void loadDanhSachHangXe() {
		ArrayList<HangSanXuat> lsHSX = daoHSX.getDanhSachHangSanXat();
		for(HangSanXuat hsx : lsHSX) {
			modelHangXe.addRow(new Object [] {
				hsx.getMaHangSX(), hsx.getTenHangSX(), hsx.getNguonGoc()
			});
		}
	}
	
	public void loadDanhSachTenXe(String maHangSanXuat) {
		clearTableXe();
		
		ArrayList<Xe> lsXe = daoHSX.getDanhSachXe(maHangSanXuat);
				for(Xe xe : lsXe) {
					modelTenXe.addRow(new Object [] {
						xe.getMaXe(), xe.getTenXe()
					});
				}
		
	}
	public void clearTableHangXe() {
		while (tableHangXe.getRowCount() > 0) {
			modelHangXe.removeRow(0);
		}
		
	}
	
	public void clearTableXe() {
		while (tableTenXe.getRowCount() > 0) {
			modelTenXe.removeRow(0);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(tableHangXe)) {
			int row = tableHangXe.getSelectedRow();
			txtMaHangXe.setText(modelHangXe.getValueAt(row, 0).toString());
			txtTenHangXe.setText(modelHangXe.getValueAt(row, 1).toString());
			txtNguonGoc.setText(modelHangXe.getValueAt(row, 2).toString());
			
			loadDanhSachTenXe(modelHangXe.getValueAt(row, 0).toString());
			
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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThemHX))
			themHangSanXuat();
		if(o.equals(btnSuaHX))
			suaThongTinHangSanXuat();
		if(o.equals(btnLamMoiHX))
			clearAll();
		if(o.equals(btnTimHX))
			timXe();
	}
	private void phatSinhMaHSX() {
		
		if (daoHSX.getDanhSachHangSanXat().isEmpty()) {
			txtMaHangXe.setText("HSX0001");
		} else {
			
			String ma = daoHSX.getMaXeCuoi();
			String ma1 = ma.substring(0, 3);
			String ma2 = ma.substring(3);
			int ma3 = Integer.parseInt(ma2)+1;
			DecimalFormat df = new DecimalFormat("0000");
			txtMaHangXe.setText(ma1+df.format(ma3));
		}
		
	}
	public boolean kiemTra() {
		String ten = txtTenHangXe.getText();
		String nguon = txtNguonGoc.getText();
		for (HangSanXuat hsx : daoHSX.getDanhSachHangSanXat()) {
			if (hsx.getTenHangSX().equalsIgnoreCase(ten)) {
				JOptionPane.showMessageDialog(null, "Tên hãng xe đã tòn tại!");
				txtTenHangXe.requestFocus();
				return false;
			}
		}
		if (ten.trim().length()>0) {
			if (!ten.matches("[^!@#$%^&*()]+")) {
				JOptionPane.showMessageDialog(null, "Tên hãng xe không bao gồm ký tự đặc biệt!");
				txtTenHangXe.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Tên hãng xe không được để trống!");
			txtTenHangXe.requestFocus();
			return false;
		}
		if (nguon.trim().length()>0) {
			if (!nguon.matches("[^!@#$%^&*()]+")) {
				JOptionPane.showMessageDialog(null, "Nguồn gốc xe không bao gồm ký tự đặc biệt!");
				txtNguonGoc.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Nguồn gốc xe không được để trống!");
			txtNguonGoc.requestFocus();
			return false;
		}
		return true;
	}
	public boolean kiemTra1() {
		String ten = txtTenHangXe.getText();
		String nguon = txtNguonGoc.getText();
		
		if (ten.trim().length()>0) {
			if (!ten.matches("[^!@#$%^&*()]+")) {
				JOptionPane.showMessageDialog(null, "Tên hãng xe không bao gồm ký tự đặc biệt!");
				txtTenHangXe.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Tên hãng xe không được để trống!");
			txtTenHangXe.requestFocus();
			return false;
		}
		if (nguon.trim().length()>0) {
			if (!nguon.matches("[^!@#$%^&*()]+")) {
				JOptionPane.showMessageDialog(null, "Nguồn gốc xe không bao gồm ký tự đặc biệt!");
				txtNguonGoc.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Nguồn gốc xe không được để trống!");
			txtNguonGoc.requestFocus();
			return false;
		}
		return true;
	}
}
