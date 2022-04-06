package app;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameNhanVien extends JFrame{
	private JLabel lbl;
	public JPanel createPanelNhanVien() {
		JPanel pnlContentPane = new JPanel();
		pnlContentPane.setBackground(Color.WHITE);
		setContentPane(pnlContentPane);
		pnlContentPane.add(lbl = new JLabel("Gảgagag"));
		return pnlContentPane;
	}
	public static void main(String[] args) {
		new FrameNhanVien().setVisible(true);
	}
	
}