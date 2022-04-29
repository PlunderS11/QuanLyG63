package app;

import javax.swing.JFrame;
import javax.swing.JTextField;

import dao.HangSanXuat_DAO;
import dao.LoaiXe_DAO;
import dao.Regex;
import dao.Xe_DAO;
import entity.HangSanXuat;
import entity.LoaiXe;
import entity.Xe;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class FormThemXe extends JFrame{
	private Regex regex;
	private JTextField txtTenXe;
	private JTextField txtMauXe;
	private JTextField txtSoKhung;
	private JTextField txtSoMay;
	private JTextField txtGiaXe;
	private JTextField txtSoLuong;
	private JTextField txtHCC;
	private JTextField txtNCC;
	private DecimalFormat dfGiaXe;
	private Xe_DAO daoXe;
	private HangSanXuat_DAO daoHSX;
	private LoaiXe_DAO daoLoaiXe;
	private JComboBox<String> cboTrangThai;
	private JComboBox<String> cboLoaiXe;
	public FormThemXe() {
		setTitle("THÊM NHIỀU XE");
		setSize(474, 355);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		txtTenXe = new JTextField();
		txtTenXe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenXe.setBounds(110, 75, 86, 20);
		getContentPane().add(txtTenXe);
		txtTenXe.setColumns(10);
		
		txtMauXe = new JTextField();
		txtMauXe.setColumns(10);
		txtMauXe.setBounds(110, 108, 86, 20);
		getContentPane().add(txtMauXe);
		
		JLabel lblNewLabel = new JLabel("Tên xe:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(24, 75, 62, 20);
		getContentPane().add(lblNewLabel);
		
		JLabel lblMuXe = new JLabel("Màu xe:");
		lblMuXe.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMuXe.setBounds(24, 108, 65, 20);
		getContentPane().add(lblMuXe);
		
		JLabel lblSKhung = new JLabel("Số khung:");
		lblSKhung.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSKhung.setBounds(24, 139, 81, 20);
		getContentPane().add(lblSKhung);
		
		JLabel lblSMy = new JLabel("Số máy:");
		lblSMy.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSMy.setBounds(24, 170, 65, 20);
		getContentPane().add(lblSMy);
		
		JLabel lblNewLabel_3_1 = new JLabel("Loại xe:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_1.setBounds(24, 201, 65, 20);
		getContentPane().add(lblNewLabel_3_1);
		
		txtSoKhung = new JTextField();
		txtSoKhung.setColumns(10);
		txtSoKhung.setBounds(110, 141, 86, 20);
		getContentPane().add(txtSoKhung);
		
		txtSoMay = new JTextField();
		txtSoMay.setColumns(10);
		txtSoMay.setBounds(110, 172, 86, 20);
		getContentPane().add(txtSoMay);
		
		JLabel lblNhCungCp = new JLabel("Nhà cung cấp:");
		lblNhCungCp.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNhCungCp.setBounds(226, 75, 114, 20);
		getContentPane().add(lblNhCungCp);
		
		JLabel lblHngCungCp = new JLabel("Hãng cung cấp:");
		lblHngCungCp.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHngCungCp.setBounds(226, 108, 124, 20);
		getContentPane().add(lblHngCungCp);
		
		JLabel lblSLng = new JLabel("Số lượng:");
		lblSLng.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSLng.setBounds(226, 139, 81, 20);
		getContentPane().add(lblSLng);
		
		JLabel lblGiNhp = new JLabel("Giá nhập:");
		lblGiNhp.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGiNhp.setBounds(226, 170, 78, 20);
		getContentPane().add(lblGiNhp);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Trạng thái:");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_1_1.setBounds(226, 201, 91, 20);
		getContentPane().add(lblNewLabel_3_1_1);
		
		txtGiaXe = new JTextField();
		txtGiaXe.setColumns(10);
		txtGiaXe.setBounds(350, 172, 86, 20);
		getContentPane().add(txtGiaXe);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(350, 141, 86, 20);
		getContentPane().add(txtSoLuong);
		
		txtHCC = new JTextField();
		txtHCC.setColumns(10);
		txtHCC.setBounds(350, 108, 86, 20);
		getContentPane().add(txtHCC);
		
		txtNCC = new JTextField();
		txtNCC.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNCC.setColumns(10);
		txtNCC.setBounds(350, 75, 86, 20);
		getContentPane().add(txtNCC);
		
		JLabel lblThmNhiuXe = new JLabel("THÊM NHIỀU XE");
		lblThmNhiuXe.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThmNhiuXe.setBounds(146, 11, 162, 25);
		getContentPane().add(lblThmNhiuXe);
		
		String loaiXe[] = {"Xe tay ga", "Xe số"};
		cboLoaiXe = new JComboBox<String>(loaiXe);
		cboLoaiXe.setBounds(110, 202, 86, 22);
		getContentPane().add(cboLoaiXe);
		
		String trangThai[] = {"Còn hàng", "Đang bán", "Đã bán"};
		cboTrangThai = new JComboBox<String>(trangThai);
		cboTrangThai.setBounds(350, 202, 86, 22);
		cboTrangThai.setEnabled(false);
		getContentPane().add(cboTrangThai);
		
		JButton btnThem = new FixButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sl = Integer.parseInt(txtSoLuong.getText());
				daoXe = new Xe_DAO();
				daoLoaiXe = new LoaiXe_DAO();
				daoHSX = new HangSanXuat_DAO();
				regex = new Regex();
				dfGiaXe=new DecimalFormat("###,###");
				for(int i = 0;i < sl; i++) {
					try {
						if(regex.regexTen(txtTenXe) && regex.regexSoKhung(txtSoKhung) && regex.regexSoMay(txtSoMay) && regex.regexNhaCungCap(txtNCC) && regex.regexHangSanXuat(txtHCC) && regex.regexGiaXe(txtGiaXe)) {
							String maXe = daoXe.getMaXe();
							String tenXe = txtTenXe.getText();
							String mauXe = txtMauXe.getText();
							String soKhung = txtSoKhung.getText();
							String soMay = txtSoMay.getText();
							String nhaCungCap = txtNCC.getText();
							HangSanXuat hangSanXuat = new HangSanXuat(daoHSX.getMaTheoHangSanXuat(txtHCC.getText())); 
							String trangThai = cboTrangThai.getSelectedItem().toString();
							
							LoaiXe loaiXe = new LoaiXe( daoLoaiXe.getMaTheoLoaiXe(cboLoaiXe.getSelectedItem().toString()));
							double giaXe = Double.parseDouble(txtGiaXe.getText());
							
							Xe xe = new Xe(maXe, tenXe, mauXe, soKhung, soMay, nhaCungCap, giaXe, hangSanXuat, loaiXe, trangThai);
							
							daoXe.themDanhSachXe(xe);
							FrameXe.loadThongTinXe(xe);
						}
						JOptionPane.showMessageDialog(null, "Thêm thông tin xe thành công");			
					} catch (Exception e1) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin", "Thông báo", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		btnThem.setForeground(Color.WHITE);
		btnThem.setBackground(new Color(107, 96, 236));
		btnThem.setIcon(new ImageIcon("image\\them.png"));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThem.setBounds(167, 256, 124, 49);
		getContentPane().add(btnThem);
	}
}
