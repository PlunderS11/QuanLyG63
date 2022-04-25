package app;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import com.toedter.calendar.JDateChooser;

import connection.ConnectDB;
import dao.DAO_KhachHang;
import entity.KhachHang;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

public class FrameKhachHang extends JFrame{
	private DefaultTableModel model;
	private DAO_KhachHang khachHang;
	public FrameKhachHang() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setSize(1345, 705);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(166, 169, 248));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(new Color(166, 169, 248));
		panel.setBounds(4, 1, 512, 667);
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
		txtTenKH.setFont(new Font("Tahoma", Font.PLAIN, 16));
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
		txtNgaySinhKH.setDateFormatString("yyyy-MM-dd");
		txtNgaySinhKH.setBounds(231, 134, 214, 32);
		txtNgaySinhKH.setDateFormatString("yyyy-MM-dd");;
		txtNgaySinhKH.setBounds(231, 192, 214, 32);
		txtNgaySinhKH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(txtNgaySinhKH);
		
		JLabel lblNewLabel_1_2 = new JLabel("Địa chỉ:");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_2.setBounds(62, 252, 159, 30);
		panel.add(lblNewLabel_1_2);
		
		txtDiaChiKH = new JTextField();
		txtDiaChiKH.setFont(new Font("Tahoma", Font.PLAIN, 16));
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
		txtSDTKH.setFont(new Font("Tahoma", Font.PLAIN, 16));
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
		txtCCCDKH.setFont(new Font("Tahoma", Font.PLAIN, 16));
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
		txtMaKH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMaKH.setEditable(false);
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
		lblNewLabel_1_2_1_1.setBounds(525, 10, 88, 32);
		getContentPane().add(lblNewLabel_1_2_1_1);
		
		txtTimKH = new JTextField();
		txtTimKH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTimKH.setColumns(10);
		txtTimKH.setBounds(613, 10, 214, 32);
		getContentPane().add(txtTimKH);
		
		JButton btnTimKH = new FixButton("Tìm");
		btnTimKH.setIcon(new ImageIcon("image\\timkiem.png"));	
		btnTimKH.setForeground(Color.WHITE);
		btnTimKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTimKH.setBackground(new Color(107,96,236));
		btnTimKH.setBounds(837, 10, 99, 32);
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
		table.setModel(model = new DefaultTableModel(
			new Object[][] {
				
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
		
		khachHang = new DAO_KhachHang();
		for (KhachHang kh : khachHang.getAllKH()) {
			model.addRow(new Object[] {
					kh.getMaKH(),kh.getTenKH(),kh.getNgaySinh(),
					kh.getDiaChi(),kh.getsDT(),
					kh.getcCCD(),kh.isGioiTinh()==true?"Nam":"Nữ"
			});
		}
		
		phatSinhMaKH();
		
		scrollPane.setViewportView(table);	
		
		btnThemKH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!kiemTra())
					return;
				else {
					String ma = txtMaKH.getText();
					String ten = txtTenKH.getText();
					Date ngay = txtNgaySinhKH.getDate();
					java.sql.Date ngaySinh = new java.sql.Date(ngay.getYear(),ngay.getMonth(),ngay.getDate());
					
					String diachi = txtDiaChiKH.getText();
					String sdt = txtSDTKH.getText();
					String cccd = txtCCCDKH.getText();
					boolean phai = radMaleKH.isSelected();
					KhachHang kh = new KhachHang(ma, ten, ngaySinh, diachi, sdt, cccd, phai);
					if (khachHang.getAllKH().contains(kh)) {
						JOptionPane.showMessageDialog(null, "Mã khách hàng đã tồn tại!");
					} else {
						try {
							khachHang.create(kh);
							model.addRow(new Object[] {
									kh.getMaKH(),kh.getTenKH(),kh.getNgaySinh(),
									kh.getDiaChi(),kh.getsDT(),
									kh.getcCCD(),kh.isGioiTinh()==true?"Nam":"Nữ"
							});
							
							JOptionPane.showMessageDialog(null, "Thêm Thành công");
						} catch (Exception e2) {
							// TODO: handle exception
							JOptionPane.showMessageDialog(null, "Thêm thất bại!");
						}
					}
					
				}
			}
		});
		btnLamMoiKH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtTenKH.setText("");
				txtNgaySinhKH.setDate(null);
				txtDiaChiKH.setText("");
				txtSDTKH.setText("");
				txtCCCDKH.setText("");
				grKH.clearSelection();
				phatSinhMaKH();
				XoaDL();
				khachHang = new DAO_KhachHang();
				for (KhachHang kh : khachHang.getAllKH()) {
					model.addRow(new Object[] {
							kh.getMaKH(),kh.getTenKH(),kh.getNgaySinh(),
							kh.getDiaChi(),kh.getsDT(),
							kh.getcCCD(),kh.isGioiTinh()==true?"Nam":"Nữ"
					});
				}
			}
		});
		btnXoaKH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int r = table.getSelectedRow();
				if (r==-1) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng cần xóa!");
				} else {
					if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa khách hàng này khong?", "Cảnh báo", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
						khachHang.delete(model.getValueAt(r, 0).toString());
						model.removeRow(r);
						JOptionPane.showMessageDialog(null, "Xóa thành công!");
					}
				}
			}
		});
		
		btnSuaKH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int r = table.getSelectedRow();
				if (r==-1) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng chứa khách hàng cần sửa!");
				} else {
					if (!kiemTra()) {
						return;
					} else {
						String ma = txtMaKH.getText();
						String ten = txtTenKH.getText();
						Date ngay = txtNgaySinhKH.getDate();
						java.sql.Date ngaySinh = new java.sql.Date(ngay.getYear(),ngay.getMonth(),ngay.getDate());
						
						String diachi = txtDiaChiKH.getText();
						String sdt = txtSDTKH.getText();
						String cccd = txtCCCDKH.getText();
						boolean phai = radMaleKH.isSelected();
						KhachHang kh = new KhachHang(ma, ten, ngaySinh, diachi, sdt, cccd, phai);
						
						try {
							khachHang.update(kh);
							model.setValueAt(kh.getTenKH(), r, 1);
							model.setValueAt(kh.getNgaySinh(), r, 2);
							model.setValueAt(kh.getDiaChi(), r, 3);
							model.setValueAt(kh.getsDT(), r, 4);
							model.setValueAt(kh.getcCCD(), r, 5);
							model.setValueAt(kh.isGioiTinh()==true?"Nam":"Nữ", r, 6);
							
							
							JOptionPane.showMessageDialog(null, "Sửa thành công!");
						} catch (Exception e2) {
							// TODO: handle exception
							JOptionPane.showMessageDialog(null, "Sửa thất bại!");
						}
					}
					
				}
			}
		});
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int r = table.getSelectedRow();
				txtMaKH.setText(model.getValueAt(r, 0).toString());
				txtTenKH.setText(model.getValueAt(r, 1).toString());

				//yyyy-MM-dd
				String ngayS = model.getValueAt(r, 2).toString();
				
				String nam = ngayS.substring(0, 4);
				String thang = ngayS.substring(5, 7);
				String ngay = ngayS.substring(8);
				Date demodate = new Date(Integer.parseInt(nam),Integer.parseInt(thang),Integer.parseInt(ngay));
				java.sql.Date dateNS = new java.sql.Date(demodate.getYear()-1900,demodate.getMonth()-1, demodate.getDate());
				txtNgaySinhKH.setDate(dateNS);
				txtNgaySinhKH.setDateFormatString("yyyy-MM-dd");

				txtDiaChiKH.setText(model.getValueAt(r, 3).toString());
				txtSDTKH.setText(model.getValueAt(r, 4).toString());
				txtCCCDKH.setText(model.getValueAt(r, 5).toString());
				if (model.getValueAt(r, 6).toString().equalsIgnoreCase("Nam")) {
		            radMaleKH.setSelected(true);
		        } else {
		            radFemaleKH.setSelected(true);
		        }
			}
		});
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
	private void phatSinhMaKH() {
		
		if (khachHang.getAllKH().isEmpty()) {
			txtMaKH.setText("KH0001");
		} else {
			
			String ma = khachHang.getMaKHCuoi();
			String ma1 = ma.substring(0, 2);
			String ma2 = ma.substring(2);
			int ma3 = Integer.parseInt(ma2)+1;
			DecimalFormat df = new DecimalFormat("0000");
			txtMaKH.setText(ma1+df.format(ma3));
		}
		
	}
	private void XoaDL() {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.getDataVector().removeAllElements();
	}
	private boolean kiemTra() {
		String tenKH = txtTenKH.getText();
		Date ngaySinh = txtNgaySinhKH.getDate();
		String cccd = txtCCCDKH.getText();
		String sdt = txtSDTKH.getText();
		String diaChi = txtDiaChiKH.getText();
		
		if (tenKH.trim().length() > 0) {
			if (!(tenKH.matches("[^\\@\\!\\$\\^\\&\\*\\(\\)]+"))) {
				JOptionPane.showMessageDialog(this, "Tên nhân viên không chứa ký tự đặc biệt", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
				txtTenKH.requestFocus();
				return false;				
			}
		} else {
			JOptionPane.showMessageDialog(this, "Tên nhân viên không được để trống", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
			txtTenKH.requestFocus();
			return false;
		}
		if (ngaySinh == null) {
			JOptionPane.showMessageDialog(this, "Ngày sinh không được để trống", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
			txtNgaySinhKH.requestFocus();
			return false;
		} else {
			Date ngayHienTai = new Date();
			if (ngayHienTai.getYear() - ngaySinh.getYear() < 18) {
				JOptionPane.showMessageDialog(this, "Nhân viên chưa đủ 18 tuổi", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
				txtNgaySinhKH.requestFocus();
				return false;
			}
		}
		if (cccd.trim().length() > 0) {
			if (!(cccd.matches("[0-9]{9}")) && !(cccd.matches("[0-9]{12}"))) {
				JOptionPane.showMessageDialog(this, "CCCD phải gồm 9 hoặc 12 số", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
				txtCCCDKH.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "CCCD không được để trống", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
			txtCCCDKH.requestFocus();
			return false;
		}
		if (sdt.trim().length() > 0) {
			if (!(sdt.matches("[0-9]{10,11}"))) {
				JOptionPane.showMessageDialog(this, "Số điện thoại phải gồm 10 đến 11 số", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
				txtSDTKH.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
			txtSDTKH.requestFocus();
			return false;
		}
		if(diaChi.trim().length() > 0) {
			if (!(diaChi.matches("[^\\@\\!\\$\\^\\&\\*\\(\\)]+"))) {
				JOptionPane.showMessageDialog(this, "Địa chỉ không chứa ký tự đặc biệt", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
				txtDiaChiKH.requestFocus();
				return false;				
			}
		} else {
			JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
			txtDiaChiKH.requestFocus();
			return false;
		}
		return true;
	}
}
