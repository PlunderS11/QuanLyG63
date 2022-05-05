package app;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.toedter.calendar.JDateChooser;

import dao.NhanVien_DAO;
import dao.TaiKhoan_DAO;
import dao.TrangChu_DAO;
import entity.NhanVien;
import entity.TaiKhoan;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrameNhanVien extends JFrame{
	
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	
	private JTextField txtDiaChi;
	private JTextField txtSoDT;
	private JTextField txtCCCD;
	private JRadioButton radMaleNV;
	private JRadioButton radFemaleNV;
	private JButton btnThemNV;
	private JButton btnXoaNV;
	private JButton btnSuaNV;
	private JButton btnLamMoiNV;
	private JComboBox cbbChucVu;
	private JButton btnTimNV;
	private static JTable table;
	private static NhanVien_DAO nhanvien_dao;
	private TaiKhoan_DAO taikhoan_dao;
	private JDateChooser txtNgaySinh;
	private ButtonGroup grNV;
	private static DefaultTableModel model;
	private JComboBox cboTimNV;
	private TrangChu_DAO trangchu_dao;
	public FrameNhanVien() {
		
		// khởi tạo kết nối đến CSDL
		try {
			connection.ConnectDB.getInstance().connect();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//...............................
		
		nhanvien_dao = new NhanVien_DAO();
		taikhoan_dao = new TaiKhoan_DAO();
		trangchu_dao = new TrangChu_DAO();
		
		setSize(1345, 705);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(166, 169, 248));	
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(new Color(166, 169, 248));
		panel.setBounds(0, 0, 516, 668);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THÔNG TIN NHÂN VIÊN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(247,237,0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 10, 486, 37);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã nhân viên:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBackground(new Color(166, 169, 248));
		lblNewLabel_1.setBounds(64, 102, 159, 20);
		panel.add(lblNewLabel_1);
		
		
		txtMaNV = new JTextField();
		txtMaNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMaNV.setEditable(false);
		txtMaNV.setColumns(10);
		txtMaNV.setBounds(236, 99, 182, 32);
		panel.add(txtMaNV);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên nhân viên:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_1.setBounds(64, 144, 159, 20);
		panel.add(lblNewLabel_1_1);
		
		txtTenNV = new JTextField();
		txtTenNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(236, 141, 214, 32);
		panel.add(txtTenNV);
		
		JLabel lblNewLabel_1_2 = new JLabel("Chức vụ:");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_2.setBounds(64, 63, 159, 20);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Ngày sinh:");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_1.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_2_1.setBounds(64, 186, 159, 20);
		panel.add(lblNewLabel_1_2_1);
		
		txtNgaySinh = new JDateChooser();
		txtNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNgaySinh.setDateFormatString("yyyy-MM-dd");
		txtNgaySinh.setBounds(236, 183, 214, 32);
		panel.add(txtNgaySinh);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Địa chỉ:");
		lblNewLabel_1_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_2.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_2_2.setBounds(64, 228, 159, 20);
		panel.add(lblNewLabel_1_2_2);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(236, 225, 214, 32);
		panel.add(txtDiaChi);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Số điện thoại:");
		lblNewLabel_1_2_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_3.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_2_3.setBounds(64, 270, 159, 20);
		panel.add(lblNewLabel_1_2_3);
		
		txtSoDT = new JTextField();
		txtSoDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSoDT.setColumns(10);
		txtSoDT.setBounds(236, 267, 214, 32);
		panel.add(txtSoDT);
		
		JLabel lblNewLabel_1_2_4 = new JLabel("CCCD:");
		lblNewLabel_1_2_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_4.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_2_4.setBounds(64, 312, 159, 20);
		panel.add(lblNewLabel_1_2_4);
		
		txtCCCD = new JTextField();
		txtCCCD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCCCD.setColumns(10);
		txtCCCD.setBounds(236, 309, 214, 32);
		panel.add(txtCCCD);
		
		
		JLabel lblNewLabel_1_2_5 = new JLabel("Giới tính:");
		lblNewLabel_1_2_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_5.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_2_5.setBounds(64, 351, 159, 20);
		panel.add(lblNewLabel_1_2_5);
		
		radMaleNV = new JRadioButton("Nam");
		radMaleNV.setFont(new Font("Tahoma", Font.BOLD, 16));
		radMaleNV.setBackground(new Color(166, 169, 248));
		radMaleNV.setBounds(231, 351, 63, 20);
		panel.add(radMaleNV);
		
		radFemaleNV = new JRadioButton("Nữ");
		radFemaleNV.setFont(new Font("Tahoma", Font.BOLD, 16));
		radFemaleNV.setBackground(new Color(166, 169, 248));
		radFemaleNV.setBounds(297, 351, 63, 20);
		panel.add(radFemaleNV);
		
		grNV = new ButtonGroup();
		grNV.add(radMaleNV);
		grNV.add(radFemaleNV);
		
		btnThemNV = new FixButton("Thêm");
		btnThemNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!validInput())
					return;
				else {
					String maNV = txtMaNV.getText();
					String tenNV = txtTenNV.getText();
					boolean gioiTinh = radMaleNV.isSelected();
					String cccd = txtCCCD.getText();
					String sdt = txtSoDT.getText();
					String diaChi = txtDiaChi.getText();
					String chucVu = cbbChucVu.getSelectedItem().toString();
					Date ngaySinhNV = txtNgaySinh.getDate();
					java.sql.Date ngaySinh = new java.sql.Date(ngaySinhNV.getYear(), ngaySinhNV.getMonth(), ngaySinhNV.getDate());
					TaiKhoan tk = new TaiKhoan(maNV, "123");
					NhanVien nv = new NhanVien(maNV, tenNV, ngaySinh, diaChi, sdt, cccd, gioiTinh, chucVu, tk);
					taikhoan_dao.createTK(tk);
					nhanvien_dao.createNVCoTK(nv);
					JOptionPane.showMessageDialog(null, "Thêm thành công");
					xoaHetDL();
					docDuLieuDatabaseVaoTable();
					}
				}
			}
		);

		btnThemNV.setIcon(new ImageIcon("image\\them.png"));
		
		btnThemNV.setForeground(Color.WHITE);
		btnThemNV.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThemNV.setBackground(new Color(107,96,236));
		btnThemNV.setBounds(10,400, 123, 49);
		panel.add(btnThemNV);
		
		btnXoaNV = new FixButton("Xóa");
		btnXoaNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int r = table.getSelectedRow();
				if (r == -1) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên cho nghỉ việc!", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
				}else
					if(JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa nhân viên này?", "Cảnh báo", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
						List<NhanVien> dsNV = new ArrayList<NhanVien>();
						String maNV = table.getValueAt(r, 0).toString();
						String tenTaiKhoan = "";
//							for(NhanVien nv : dsNV) {
//								if (nv.getMaNV().equalsIgnoreCase(maNV)) {
//									tenTaiKhoan = nv.getTaiKhoan().getTenTaiKhoan();
//									break;
//								}
//							}
						nhanvien_dao.delete(maNV);
						taikhoan_dao.delete(maNV);
						xoaHetDL();
						docDuLieuDatabaseVaoTable();
					}
			}
		});
		btnXoaNV.setIcon(new ImageIcon("image\\xoa.png"));
		btnXoaNV.setForeground(Color.WHITE);
		btnXoaNV.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoaNV.setBackground(new Color(107,96,236));
		btnXoaNV.setBounds(139, 400, 105, 49);
		panel.add(btnXoaNV);
		
		NhanVien nv123 = trangchu_dao.getNhanVienSuDung(NewSignin.getTaiKhoan());
		String chucVu = nv123.getMaNV().substring(0, 2);
		if(chucVu.equalsIgnoreCase("NV"))
			btnXoaNV.setEnabled(false);
		
		btnSuaNV = new FixButton("Sửa");
		btnSuaNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int r = table.getSelectedRow();
				if(r == -1)
					JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng cần sửa", "Lỗi", JOptionPane.ERROR_MESSAGE);
				else {
					if (!validInput1()) {
						return;
					} else {
						String maNV = txtMaNV.getText();
						String tenNV = txtTenNV.getText();
						boolean gioiTinh = radMaleNV.isSelected();
						String cccd = txtCCCD.getText();
						String sdt = txtSoDT.getText();
						String diaChi = txtDiaChi.getText();
						String chucVu = cbbChucVu.getSelectedItem().toString();
						Date ngaySinhNV = txtNgaySinh.getDate();
						java.sql.Date ngaySinh = new java.sql.Date(ngaySinhNV.getYear(), ngaySinhNV.getMonth(), ngaySinhNV.getDate());
						String taiKhoan = (String) model.getValueAt(r, 8);
						
						List<TaiKhoan> dsTK = taikhoan_dao.getAllTaiKhoan();
						for (TaiKhoan tkhoan : dsTK) {
							if (tkhoan.getTenTaiKhoan().equals(taiKhoan)) {
								TaiKhoan tk = new TaiKhoan(taiKhoan, tkhoan.getMatKhau());
								NhanVien nv = new NhanVien(maNV, tenNV, ngaySinh, diaChi, sdt, cccd, gioiTinh, chucVu, tk);
								nhanvien_dao.update(nv);
							}
						}
						JOptionPane.showMessageDialog(null, "Cập nhật thành công!", "Thành công",
								JOptionPane.INFORMATION_MESSAGE);
						xoaHetDL();
						docDuLieuDatabaseVaoTable();
					}
					
				}
			}
		});

		btnSuaNV.setIcon(new ImageIcon("image\\capnhat.png"));
		btnSuaNV.setForeground(Color.WHITE);
		btnSuaNV.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSuaNV.setBackground(new Color(107,96,236));
		btnSuaNV.setBounds(250, 400, 105, 49);
		panel.add(btnSuaNV);
		
		btnLamMoiNV = new FixButton("Làm mới");
		btnLamMoiNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lamMoi();
			}
		});
		btnLamMoiNV.setIcon(new ImageIcon("image\\lammoi.png"));
		btnLamMoiNV.setForeground(Color.WHITE);
		btnLamMoiNV.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLamMoiNV.setBackground(new Color(107,96,236));
		btnLamMoiNV.setBounds(361, 400, 136, 49);
		panel.add(btnLamMoiNV);
		
		cbbChucVu = new JComboBox();
		cbbChucVu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbbChucVu.setModel(new DefaultComboBoxModel(new String[] {"Quản lí", "Nhân viên bán hàng"}));
		cbbChucVu.setBackground(Color.WHITE);
		cbbChucVu.setBounds(235, 57, 214, 32);
		panel.add(cbbChucVu);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(105, 549, 45, 13);
		panel.add(lblNewLabel_2);
		
		JButton btnPhatSinhMa = new FixButton();
		btnPhatSinhMa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				phatSinhMa();
			}
		});
		btnPhatSinhMa.setIcon(new ImageIcon("image\\lammoi.png"));
		btnPhatSinhMa.setBackground(new Color(107,96,236));
		btnPhatSinhMa.setBounds(417, 100, 33, 31);
		panel.add(btnPhatSinhMa);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Tìm kiếm:");
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_1_1.setBackground(new Color(166, 169, 248));
		lblNewLabel_1_2_1_1.setBounds(525, 10, 88, 32);
		getContentPane().add(lblNewLabel_1_2_1_1);
		
		btnTimNV = new FixButton("Tìm");
		
		btnTimNV.setIcon(new ImageIcon("image\\timkiem.png"));
	
		
		btnTimNV.setForeground(Color.WHITE);
		btnTimNV.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTimNV.setBackground(new Color(107,96,236));
		btnTimNV.setBounds(837, 10, 99, 32);
		getContentPane().add(btnTimNV);
		
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
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int r = table.getSelectedRow();
				txtMaNV.setText(model.getValueAt(r, 0).toString());
				txtTenNV.setText(model.getValueAt(r, 1).toString());
				String dateString = model.getValueAt(r, 2).toString();
				String[] a = dateString.split("-");
				txtNgaySinh
						.setDate(new Date(Integer.parseInt(a[0]) - 1900, Integer.parseInt(a[1]) - 1, Integer.parseInt(a[2])));
				txtDiaChi.setText(model.getValueAt(r, 3).toString());
				txtSoDT.setText(model.getValueAt(r, 4).toString());
				txtCCCD.setText(model.getValueAt(r, 5).toString());
				if (model.getValueAt(r, 6).toString().equalsIgnoreCase("Nam"))
		            radMaleNV.setSelected(true);
		        else
		            radFemaleNV.setSelected(true);
				cbbChucVu.setSelectedItem(model.getValueAt(r, 7).toString().trim());
			}
		});
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
				"Mã nhân viên", "Tên nhân viên",  "Ngày sinh", "Địa chỉ", "Số điện thoại", "Số CCCD", "Giới tính", "Chức vụ", "Tên tài khoản"
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
		
		cboTimNV = new JComboBox();
		cboTimNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cboTimNV.setEditable(true);
		cboTimNV.setBounds(613, 9, 214, 32);
		cboTimNV.addItem("");
		AutoCompleteDecorator.decorate(cboTimNV);
		for (NhanVien nv : nhanvien_dao.getAllNhanVien()) {
			cboTimNV.addItem(nv.getcCCD());
		}
		btnTimNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cccd = cboTimNV.getSelectedItem().toString();
				if (cccd.equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập CCCD nhân viên cần tìm!");
				} else {
					int temp = -1;
					for (NhanVien nv : nhanvien_dao.getAllNhanVien()) {
						if (nv.getcCCD().equalsIgnoreCase(cccd)) {
							xoaHetDL();
							model.addRow(new Object[] { nv.getMaNV().trim(), nv.getTenNV().trim(), nv.getNgaySinh(),
									nv.getDiaChi().trim(), nv.getSoDT().trim(), nv.getcCCD().trim(),nv.isGioiTinh() == true ? "Nam" : "Nữ",
									nv.getChucVu().trim(), nv.getTaiKhoan().getTenTaiKhoan() });
							temp = 1;
						}

					}
					if (temp == -1) {
						JOptionPane.showMessageDialog(null, "Không tìm thấy nhân viên cần tìm!");
					}
				}
				
			}
		});
		getContentPane().add(cboTimNV);
		docDuLieuDatabaseVaoTable();
	}
	public static void main(String[] args) {
		new FrameNhanVien().setVisible(true);
	}
	private boolean validInput() {
		String maNV = txtMaNV.getText();
		String tenNV = txtTenNV.getText();
		Date ngaySinh = txtNgaySinh.getDate();
		String cccd = txtCCCD.getText();
		String sdt = txtSoDT.getText();
		String diaChi = txtDiaChi.getText();
		
		if(maNV.equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng phát sinh mã Nhân viên!","Lỗi", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (tenNV.trim().length() > 0) {
			if (!(tenNV.matches("[^\\@\\!\\$\\^\\&\\*\\(\\)]+"))) {
				JOptionPane.showMessageDialog(this, "Tên nhân viên không chứa ký tự đặc biệt", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
				txtTenNV.requestFocus();
				return false;				
			}
		} else {
			JOptionPane.showMessageDialog(this, "Tên nhân viên không được để trống", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
			txtTenNV.requestFocus();
			return false;
		}
		if (ngaySinh == null) {
			JOptionPane.showMessageDialog(this, "Ngày sinh không được để trống", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
			txtNgaySinh.requestFocus();
			return false;
		} else {
			Date ngayHienTai = new Date();
			if (ngayHienTai.getYear() - ngaySinh.getYear() < 18) {
				JOptionPane.showMessageDialog(this, "Nhân viên chưa đủ 18 tuổi", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
				txtNgaySinh.requestFocus();
				return false;
			}
		}
		for (NhanVien nv : nhanvien_dao.getAllNhanVien()) {
			if (nv.getcCCD().equalsIgnoreCase(cccd)) {
				JOptionPane.showMessageDialog(this, "CCCD nhân viên đã tồn tại!", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
				txtCCCD.requestFocus();
				return false;
			}
		}
		if (cccd.trim().length() > 0) {
			if (!(cccd.matches("[0-9]{9}")) && !(cccd.matches("[0-9]{12}"))) {
				JOptionPane.showMessageDialog(this, "CCCD phải gồm 9 hoặc 12 số", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
				txtCCCD.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "CCCD không được để trống", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
			txtCCCD.requestFocus();
			return false;
		}
		if (sdt.trim().length() > 0) {
			if (!(sdt.matches("[0-9]{10,11}"))) {
				JOptionPane.showMessageDialog(this, "Số điện thoại phải gồm 10 đến 11 số", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
				txtSoDT.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
			txtSoDT.requestFocus();
			return false;
		}
		if(diaChi.trim().length() > 0) {
			if (!(diaChi.matches("[^\\@\\!\\$\\^\\&\\*\\(\\)]+"))) {
				JOptionPane.showMessageDialog(this, "Địa chỉ không chứa ký tự đặc biệt", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
				txtDiaChi.requestFocus();
				return false;				
			}
		} else {
			JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
			txtDiaChi.requestFocus();
			return false;
		}
		return true;
	}
	private boolean validInput1() {
		String maNV = txtMaNV.getText();
		String tenNV = txtTenNV.getText();
		Date ngaySinh = txtNgaySinh.getDate();
		String cccd = txtCCCD.getText();
		String sdt = txtSoDT.getText();
		String diaChi = txtDiaChi.getText();
		
		if(maNV.equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng phát sinh mã Nhân viên!","Lỗi", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (tenNV.trim().length() > 0) {
			if (!(tenNV.matches("[^\\@\\!\\$\\^\\&\\*\\(\\)]+"))) {
				JOptionPane.showMessageDialog(this, "Tên nhân viên không chứa ký tự đặc biệt", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
				txtTenNV.requestFocus();
				return false;				
			}
		} else {
			JOptionPane.showMessageDialog(this, "Tên nhân viên không được để trống", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
			txtTenNV.requestFocus();
			return false;
		}
		if (ngaySinh == null) {
			JOptionPane.showMessageDialog(this, "Ngày sinh không được để trống", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
			txtNgaySinh.requestFocus();
			return false;
		} else {
			Date ngayHienTai = new Date();
			if (ngayHienTai.getYear() - ngaySinh.getYear() < 18) {
				JOptionPane.showMessageDialog(this, "Nhân viên chưa đủ 18 tuổi", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
				txtNgaySinh.requestFocus();
				return false;
			}
		}
		int r = table.getSelectedRow();
		for (NhanVien nv : nhanvien_dao.getAllNhanVienTruCCCD(model.getValueAt(r, 5).toString())) {
			if (nv.getcCCD().equalsIgnoreCase(cccd)) {
				
					JOptionPane.showMessageDialog(this, "CCCD nhân viên đã tồn tại!", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
					txtCCCD.requestFocus();
					return false;
				
			}
		}
		if (cccd.trim().length() > 0) {
			if (!(cccd.matches("[0-9]{9}")) && !(cccd.matches("[0-9]{12}"))) {
				JOptionPane.showMessageDialog(this, "CCCD phải gồm 9 hoặc 12 số", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
				txtCCCD.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "CCCD không được để trống", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
			txtCCCD.requestFocus();
			return false;
		}
		if (sdt.trim().length() > 0) {
			if (!(sdt.matches("[0-9]{10,11}"))) {
				JOptionPane.showMessageDialog(this, "Số điện thoại phải gồm 10 đến 11 số", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
				txtSoDT.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
			txtSoDT.requestFocus();
			return false;
		}
		if(diaChi.trim().length() > 0) {
			if (!(diaChi.matches("[^\\@\\!\\$\\^\\&\\*\\(\\)]+"))) {
				JOptionPane.showMessageDialog(this, "Địa chỉ không chứa ký tự đặc biệt", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
				txtDiaChi.requestFocus();
				return false;				
			}
		} else {
			JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
			txtDiaChi.requestFocus();
			return false;
		}
		return true;
	}
	public void phatSinhMa() {
		String chucVu = cbbChucVu.getSelectedItem().toString();
		String maNV = "";
		List<NhanVien> dsNV = nhanvien_dao.getAllNhanVien();
		if(dsNV.size() == 0) {
			if(chucVu.equalsIgnoreCase("Quản lí")) {
				maNV = "QL1001";
				txtMaNV.setText(maNV);
			}
			else if(chucVu.equalsIgnoreCase("Nhân viên bán hàng")) {
				maNV = "NV1001";
				txtMaNV.setText(maNV);
			}
		}else {
			if(chucVu.equalsIgnoreCase("Quản lí")){
				List<NhanVien> dsTam = new ArrayList<NhanVien>();
				for(NhanVien nv : dsNV) {
					if(nv.getMaNV().substring(0, 2).equalsIgnoreCase("QL")) {
						dsTam.add(nv);
					}
				}
				if (dsTam.isEmpty()) {
					maNV = "QL1001";
					txtMaNV.setText(maNV);
				} else {
					String maNVCuoi = dsTam.get(dsTam.size() - 1).getMaNV().trim();
					int layMaSo = Integer.parseInt(maNVCuoi.substring(2, maNVCuoi.length()));
					maNV = "QL" + (layMaSo + 1);
					txtMaNV.setText(maNV);
				}
			}else {
				List<NhanVien> dsTam = new ArrayList<NhanVien>();
				for(NhanVien nv : dsNV) {
					if(nv.getMaNV().substring(0, 2).equalsIgnoreCase("NV")) {
						dsTam.add(nv);
					}
				}
				if (dsTam.isEmpty()) {
					maNV = "NV1001";
					txtMaNV.setText(maNV);
				} else {
					String maNVCuoi = dsTam.get(dsTam.size() - 1).getMaNV().trim();
					int layMaSo = Integer.parseInt(maNVCuoi.substring(2, maNVCuoi.length()));
					maNV = "NV" + (layMaSo + 1);
					txtMaNV.setText(maNV);
				}
			}	
		}
//		System.out.println(dsNV.get(dsNV.size()-1).getMaNV().trim());
	}
	public void lamMoi() {
		txtMaNV.setText("");
		txtTenNV.setText("");
		txtNgaySinh.setDate(null);
		txtDiaChi.setText("");
		txtSoDT.setText("");
		txtCCCD.setText("");
		cboTimNV.removeAllItems();
		cboTimNV.addItem("");
		for (NhanVien nv : nhanvien_dao.getAllNhanVien()) {
			cboTimNV.addItem(nv.getcCCD());
		}
		cbbChucVu.setSelectedIndex(0);
		grNV.clearSelection();
		xoaHetDL();
		docDuLieuDatabaseVaoTable();
	}
	public static void xoaHetDL() {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.setRowCount(0);
	}
	public static void docDuLieuDatabaseVaoTable() {
		List<NhanVien> listNV = nhanvien_dao.getAllNhanVien();
		for (NhanVien nv : listNV) {
			model.addRow(new Object[] { nv.getMaNV().trim(), nv.getTenNV().trim(), nv.getNgaySinh(),
					nv.getDiaChi().trim(), nv.getSoDT().trim(), nv.getcCCD().trim(),nv.isGioiTinh() == true ? "Nam" : "Nữ",
					nv.getChucVu().trim(), nv.getTaiKhoan().getTenTaiKhoan() });
		}
	}
}