package app;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.ArrayList;
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
import dao.TaiKhoan_DAO;
import entity.TaiKhoan;
import java.awt.event.KeyAdapter;

public class NewSignin extends JFrame implements KeyListener{
	private static JTextField txtTK;
	private JPasswordField txtMK;
	private TaiKhoan_DAO taikhoan_dao;
	private JButton btnLogIn;
	public NewSignin() {
		
		// khởi tạo kết nối đến CSDL
		try {
			ConnectDB.getInstance().connect();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		//...................................
		taikhoan_dao = new TaiKhoan_DAO();
		
		setTitle("Đăng nhập");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(767, 569);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel pnlDN = new JPanel();
		pnlDN.setBackground(new Color(148, 0, 211));
		pnlDN.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pnlDN.setBounds(0, 0, 422, 534);
		getContentPane().add(pnlDN);
		pnlDN.setLayout(null);
		
		JLabel lblDN = new JLabel();
		lblDN.setIcon(new ImageIcon("image\\Login.png"));
		lblDN.setBounds(149, 68, 100, 100);
		pnlDN.add(lblDN);
		
		JLabel lblTK = new JLabel();
		lblTK.setIcon(new ImageIcon("image\\account.png"));
		lblTK.setBounds(41, 218, 35, 35);
		pnlDN.add(lblTK);
		
		JLabel lblMK = new JLabel();
		lblMK.setIcon(new ImageIcon("image\\password.png"));
		lblMK.setBounds(41, 309, 35, 35);
		pnlDN.add(lblMK);
		
		txtTK = new JTextField();
		txtTK.setBounds(99, 218, 233, 35);
		txtTK.setBorder(BorderFactory.createLineBorder(new Color(169, 224, 49)));
		pnlDN.add(txtTK);
		txtTK.setColumns(10);
		
		txtMK = new JPasswordField();
		txtMK.setColumns(10);
		txtMK.setBounds(99, 309, 233, 35);
		txtMK.setBorder(BorderFactory.createLineBorder(new Color(169, 224, 49)));
		pnlDN.add(txtMK);
		
		btnLogIn = new JButton("Sign In");
		btnLogIn.setFont(new Font("Arial", Font.BOLD, 20));
		btnLogIn.setBackground(new Color(152, 201, 45));
		btnLogIn.setForeground(Color.WHITE);
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==btnLogIn) {
					String tentk = txtTK.getText();
					String mk = txtMK.getText();
					
					int flag = 0;
					List<TaiKhoan> dsTK = taikhoan_dao.getAllTaiKhoan();
					for(TaiKhoan tk : dsTK) {
						if(tk.getTenTaiKhoan().trim().equals(tentk) && tk.getMatKhau().trim().equals(mk)) {
							flag = 1;
							break;
						}
					}
					if(flag == 0) {
						JOptionPane.showMessageDialog(null, "Đăng nhập thất bại!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
						txtTK.requestFocus();
						return;
					}else {
						FrameTrangChu home;
						try {
							home = new FrameTrangChu();
							home.setVisible(true);
							home.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
							home.setLocationRelativeTo(null);
							dispose();
						}catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		});
		btnLogIn.setBounds(99, 420, 233, 35);
		pnlDN.add(btnLogIn);
		
		JCheckBox chkHienMK = new JCheckBox("Hiện mật khẩu");
		chkHienMK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==chkHienMK) {
					if(chkHienMK.isSelected()) {
						txtMK.setEchoChar((char) 0);
					}else {
						txtMK.setEchoChar('*');
					}
				}
			}
		});
		chkHienMK.setFont(new Font("Arial", Font.BOLD, 16));
		chkHienMK.setBackground(new Color(148, 0, 211));
		chkHienMK.setForeground(Color.WHITE);
		chkHienMK.setBounds(99, 374, 169, 27);
		pnlDN.add(chkHienMK);
		
		JLabel lblTaiKhoan = new JLabel("Tài khoản");
		lblTaiKhoan.setFont(new Font("Arial", Font.BOLD, 15));
		lblTaiKhoan.setForeground(Color.WHITE);
		lblTaiKhoan.setBounds(99, 190, 74, 18);
		pnlDN.add(lblTaiKhoan);
		
		JLabel lblMatKhau = new JLabel("Mật khẩu");
		lblMatKhau.setForeground(Color.WHITE);
		lblMatKhau.setFont(new Font("Arial", Font.BOLD, 15));
		lblMatKhau.setBounds(99, 281, 74, 18);
		pnlDN.add(lblMatKhau);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(75, 0, 130));
		panel.setBounds(420, 0, 335, 534);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("image\\Logo.jfif"));
		lblNewLabel.setBounds(70, 146, 206, 113);
		panel.add(lblNewLabel);
		
		txtTK.addKeyListener(this);
		txtMK.addKeyListener(this);
	}

	public static void main(String args[]) { 
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewSignin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewSignin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewSignin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewSignin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewSignin().setVisible(true);
            }
        });
    }
	public static String getTaiKhoan() {
		return txtTK.getText();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			btnLogIn.doClick();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
