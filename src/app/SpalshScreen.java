package app;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;

import java.awt.Font;

public class SpalshScreen extends JFrame{
	public JProgressBar loading;
	public JLabel loadingNumber;
	public SpalshScreen() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(75, 0, 130));
		setSize(767, 569);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\code\\QuanLyG63\\image\\Logo.jfif"));
		lblNewLabel.setBounds(285, 177, 206, 113);
		getContentPane().add(lblNewLabel);
		
		loading = new JProgressBar();
		loading.setForeground(new Color(169, 224, 49));
		loading.setBorderPainted(false);
        loading.setFocusable(false);
        loading.setRequestFocusEnabled(false);
        loading.setVerifyInputWhenFocusTarget(false);
		loading.setBounds(0, 494, 753, 38);
		getContentPane().add(loading);
		
		loadingNumber = new JLabel("99%");
		loadingNumber.setFont(new Font("Tahoma", Font.BOLD, 30));
		loadingNumber.setForeground(new Color(169, 224, 49));
		loadingNumber.setBounds(370, 447, 75, 37);
		getContentPane().add(loadingNumber);
	}
	public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SpalshScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SpalshScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SpalshScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SpalshScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SpalshScreen().setVisible(true);
            }
        });
    }
}
