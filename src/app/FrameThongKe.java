package app;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameThongKe extends JFrame{
	private JButton lbl;
	public JPanel createPanelThongKe() {
		JPanel pnlContentPane = new JPanel();
		pnlContentPane.setBackground(Color.WHITE);
		setContentPane(pnlContentPane);
		pnlContentPane.add(lbl = new JButton("Gảgagag"));
		return pnlContentPane;
	}
	public static void main(String[] args) {
		new FrameThongKe().setVisible(true);
	}
}
