package app;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameKhachHang extends JFrame{
	public FrameKhachHang() {
	}
	private JButton lbl;
	public JPanel createPanelKhachHang() {
		JPanel pnlContentPane = new JPanel();
		pnlContentPane.setBackground(Color.WHITE);
		setContentPane(pnlContentPane);
		pnlContentPane.add(lbl = new JButton("Gảgagag"));
		return pnlContentPane;
	}
	public static void main(String[] args) {
		new FrameKhachHang().setVisible(true);
	}
	
}
