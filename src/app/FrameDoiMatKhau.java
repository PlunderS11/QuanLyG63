package app;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import connection.ConnectDB;
import dao.DoiMatKhau_DAO;
import dao.TaiKhoan_DAO;
import entity.TaiKhoan;

public class FrameDoiMatKhau extends JFrame{
	private JPasswordField txtMatkhauMoi;
	private JPasswordField txtMatkhauCu;
	private JPasswordField txtXacNhan;
	private DoiMatKhau_DAO doimatkhau_dao;
	private TaiKhoan_DAO taiKhoan_dao;

	public FrameDoiMatKhau() {
		
		// khởi tạo kết nối đến CSDL
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		doimatkhau_dao = new DoiMatKhau_DAO();
		taiKhoan_dao = new TaiKhoan_DAO();
		// ------------------------------
		setTitle("Đổi mật khẩu");
		setSize(767, 569);
		
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel pnlDN = new JPanel();
		pnlDN.setBackground(new Color(148, 0, 211));
		pnlDN.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pnlDN.setBounds(0, 0, 422, 534);
		getContentPane().add(pnlDN);
		pnlDN.setLayout(null);
		
		JLabel lblDN = new JLabel();
		lblDN.setIcon(new ImageIcon("image\\Login.png"));
		lblDN.setBounds(150, 45, 100, 100);
		pnlDN.add(lblDN);
		
		txtMatkhauCu = new JPasswordField();
		txtMatkhauCu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMatkhauCu.setBounds(99, 200, 233, 35);
		txtMatkhauCu.setBorder(BorderFactory.createLineBorder(new Color(169, 224, 49)));
		pnlDN.add(txtMatkhauCu);
		txtMatkhauCu.setColumns(10);
		
		txtMatkhauMoi = new JPasswordField();
		txtMatkhauMoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMatkhauMoi.setColumns(10);
		txtMatkhauMoi.setBounds(99, 285, 233, 35);
		txtMatkhauMoi.setBorder(BorderFactory.createLineBorder(new Color(169, 224, 49)));
		pnlDN.add(txtMatkhauMoi);
		
		JButton btnDoiMK = new JButton("Đổi Mật Khẩu");
		btnDoiMK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String matKhauCu = txtMatkhauCu.getText().trim();
				String matKhauMoi = txtMatkhauMoi.getText().trim();
				String xacNhan = txtXacNhan.getText().trim();
				
				TaiKhoan tk = doimatkhau_dao.getTaiKhoanTheoTenTaiKhoan(NewSignin.getTaiKhoan());
				if(!ktraMatKhau())
					return;
				else {
					if (taiKhoan_dao.updateDoiMatKhau(tk, matKhauMoi) == true) {
						JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công!");

						dispose();
						
					} else {
						JOptionPane.showMessageDialog(null, "Đổi mật khẩu thất bại");
					}
				}
			}
		});
		btnDoiMK.setFont(new Font("Arial", Font.BOLD, 20));
		btnDoiMK.setBackground(new Color(152, 201, 45));
		btnDoiMK.setForeground(Color.WHITE);
		btnDoiMK.setBounds(99, 473, 233, 35);
		pnlDN.add(btnDoiMK);
		
		JCheckBox chkHienMK = new JCheckBox("Hiện mật khẩu");
		chkHienMK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==chkHienMK) {
					if(chkHienMK.isSelected()) {
						txtMatkhauCu.setEchoChar((char) 0);
						txtMatkhauMoi.setEchoChar((char) 0);
						txtXacNhan.setEchoChar((char) 0);
					}else {
						txtMatkhauCu.setEchoChar('*');
						txtMatkhauMoi.setEchoChar('*');
						txtXacNhan.setEchoChar('*');
					}
				}
			}
		});
		chkHienMK.setFont(new Font("Arial", Font.BOLD, 16));
		chkHienMK.setBackground(new Color(148, 0, 211));
		chkHienMK.setForeground(Color.WHITE);
		chkHienMK.setBounds(99, 427, 169, 27);
		pnlDN.add(chkHienMK);
		
		JLabel lblMKCu = new JLabel("Mật khẩu cũ");
		lblMKCu.setFont(new Font("Arial", Font.BOLD, 15));
		lblMKCu.setForeground(Color.WHITE);
		lblMKCu.setBounds(99, 170, 161, 18);
		pnlDN.add(lblMKCu);
		
		JLabel lblMKMoi = new JLabel("Mật khẩu mới");
		lblMKMoi.setForeground(Color.WHITE);
		lblMKMoi.setFont(new Font("Arial", Font.BOLD, 15));
		lblMKMoi.setBounds(99, 255, 132, 18);
		pnlDN.add(lblMKMoi);
		
		txtXacNhan = new JPasswordField();
		txtXacNhan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtXacNhan.setColumns(10);
		txtXacNhan.setBorder(BorderFactory.createLineBorder(new Color(169, 224, 49)));
		txtXacNhan.setBounds(99, 370, 233, 35);
		pnlDN.add(txtXacNhan);
		
		JLabel lblXacNhan = new JLabel("Xác nhận mật khẩu");
		lblXacNhan.setForeground(Color.WHITE);
		lblXacNhan.setFont(new Font("Arial", Font.BOLD, 15));
		lblXacNhan.setBounds(99, 340, 186, 18);
		pnlDN.add(lblXacNhan);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(75, 0, 130));
		panel.setBounds(420, 0, 335, 534);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("image\\Logo.jfif"));
		lblNewLabel.setBounds(70, 146, 206, 113);
		panel.add(lblNewLabel);
		
	}
	public boolean ktraMatKhau() {
		String matKhauCu = txtMatkhauCu.getText().trim();
		String matKhauMoi = txtMatkhauMoi.getText().trim();
		String xacNhan = txtXacNhan.getText().trim();

		if (matKhauCu.equals("") || matKhauMoi.equals("") || xacNhan.equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ mật khẩu");
			return false;
		}

		TaiKhoan tk = doimatkhau_dao.getTaiKhoanTheoTenTaiKhoan(NewSignin.getTaiKhoan());

		if (!matKhauCu.equals(tk.getMatKhau().trim())) {
			JOptionPane.showMessageDialog(this, "Mật khẩu cũ không chính xác");
			return false;
		}
		if (matKhauMoi.matches("(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,20}")) {
			if (!matKhauMoi.equals(xacNhan)) {
				JOptionPane.showMessageDialog(this, "Xác nhận không chính xác");
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Mật khẩu mới từ 8 đến 20 kí tự gồm cả chữ và số");
			return false;
		}
		return true;
	}
}
