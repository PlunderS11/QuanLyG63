package app;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import dao.LoaiXe_DAO;
import dao.Regex;
import dao.Xe_DAO;
import entity.LoaiXe;
import entity.Xe;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrameLoaiXe extends JFrame implements MouseListener, ActionListener{	
	private JButton lbl;
	private JTextField txtTimKiem;
	private JTextField txtMaLoaiXe;
	private JTextField txtTenLoaiXe;
	private JTable tableLoaiXe;
	private JTable tableTenXe;
	private DefaultTableModel modelLoaiXe;
	private DefaultTableModel modelXe;
	private LoaiXe_DAO daoLoaiXe;
	private Xe_DAO daoXe;
	private FixButton btnLamMoi;
	private Regex regex;
	private FixButton btnTimLX;
	public JPanel createPanelLoaiXe() {
		JPanel pnlContentPane = new JPanel();
		pnlContentPane.setBackground(Color.WHITE);
		setContentPane(pnlContentPane);
		pnlContentPane.add(lbl = new JButton("Gagag"));
		return pnlContentPane;}
	public FrameLoaiXe(){
		regex = new Regex();
		daoLoaiXe = new LoaiXe_DAO();
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
		panel.setBounds(0, 0, 897, 115);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
		
		JLabel lblTimKiem = new JLabel("Tìm kiếm:");
		lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTimKiem.setBounds(213, 22, 91, 14);
		panel.add(lblTimKiem);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(314, 17, 270, 28);
		panel.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		btnTimLX = new FixButton("Tìm");
		btnTimLX.setIcon(new ImageIcon("image\\timkiem.png"));
	
		
		btnTimLX.setForeground(Color.WHITE);
		btnTimLX.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTimLX.setBackground(new Color(107,96,236));
		btnTimLX.setBounds(605, 15, 99, 32);
		panel.add(btnTimLX);
		
		JLabel lblMaLoaiXe = new JLabel("Mã loại xe:");
		lblMaLoaiXe.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMaLoaiXe.setBounds(53, 72, 104, 20);
		panel.add(lblMaLoaiXe);
		
		txtMaLoaiXe = new JTextField();
		txtMaLoaiXe.setEditable(false);
		txtMaLoaiXe.setBounds(154, 70, 214, 28);
		panel.add(txtMaLoaiXe);
		txtMaLoaiXe.setColumns(10);
		
		JLabel lblTenLoaiXe = new JLabel("Tên loại xe:");
		lblTenLoaiXe.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTenLoaiXe.setBounds(414, 77, 104, 15);
		panel.add(lblTenLoaiXe);
		
		txtTenLoaiXe = new JTextField();
		txtTenLoaiXe.setBounds(528, 70, 214, 28);
		panel.add(txtTenLoaiXe);
		txtTenLoaiXe.setColumns(10);
		
		btnLamMoi = new FixButton("Làm mới");
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLamMoi.setBackground(new Color(107, 96, 236));
		btnLamMoi.setBounds(781, 70, 101, 25);
		panel.add(btnLamMoi);
		
		JScrollPane scrlLoaiXe = new JScrollPane();
		scrlLoaiXe.setBounds(52, 140, 1267, 204);
		getContentPane().add(scrlLoaiXe);
		
		//tableLoaiXe = new JTable();
		tableLoaiXe = new JTable(){
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
		tableLoaiXe.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tableLoaiXe.setGridColor(getBackground());
		tableLoaiXe.setRowHeight(tableLoaiXe.getRowHeight() + 20);
		tableLoaiXe.setSelectionBackground(new Color(166, 169, 248));
		
		JTableHeader tableHeaderLoaiXe = tableLoaiXe.getTableHeader();
		tableHeaderLoaiXe.setBackground(new Color(79, 12, 132));
		tableHeaderLoaiXe.setForeground(Color.WHITE);
		tableHeaderLoaiXe.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		tableLoaiXe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableLoaiXe.setModel(modelLoaiXe = new DefaultTableModel(
				new Object[][] {
					
				},
				new String[] {
						"Mã loại xe", "Tên loại xe"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		loadDanhSachLoaiXe();
		scrlLoaiXe.setViewportView(tableLoaiXe);
		
		JScrollPane scrlTenXe = new JScrollPane();
		scrlTenXe.setBounds(52, 371, 1267, 259);
		
		
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
		tableTenXe.setModel(modelXe = new DefaultTableModel(
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
		//ArrayList<Xe> lsXe = daoLoaiXe.getDanhSachXe("LX0001");
		//System.out.println(lsXe);
		
		scrlTenXe.setViewportView(tableTenXe);
		
		tableLoaiXe.addMouseListener(this);
		btnLamMoi.addActionListener(this);
		btnTimLX.addActionListener(this);
	}
	
	public void loadDanhSachLoaiXe() {
		ArrayList<LoaiXe> lsLx = daoLoaiXe.getDanhSachLoaiXe();
		
		for(LoaiXe lx : lsLx) {
			modelLoaiXe.addRow(new Object [] {
				lx.getMaLoaiXe(), lx.getTenLoaiXe()
			});
		}
	}
	public void clearTableXe() {
		while (tableTenXe.getRowCount() > 0) {
			modelXe.removeRow(0);
		}
	}
	public void loadDanhSachXeTheoLoaiXe(String maLoaiXe) {
		clearTableXe();
		ArrayList<Xe> lsXe = daoLoaiXe.getDanhSachXe(maLoaiXe);
		for(Xe xe : lsXe) {
			modelXe.addRow(new Object[] {
					xe.getMaXe(), xe.getTenXe()
			});
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(tableLoaiXe))
		{
			int row = tableLoaiXe.getSelectedRow();
			txtMaLoaiXe.setText(modelLoaiXe.getValueAt(row, 0).toString());
			txtTenLoaiXe.setText(modelLoaiXe.getValueAt(row, 1).toString());
			loadDanhSachXeTheoLoaiXe(modelLoaiXe.getValueAt(row, 0).toString());
			
		}
	}
	public void timXe() {
		String regexMaXe = "((X|x)[0-9]{4})";
			if(!txtTimKiem.getText().equals("")) {
				if(regex.timMaXe(txtTimKiem)) {
					if(txtTimKiem.getText().trim().matches(regexMaXe)) {
						Xe xe = daoXe.getGiaXeTheoMa(txtTimKiem.getText());
						LoaiXe lx = daoLoaiXe.getLoaiXeTheoMa(xe.getLoaiXe().getMaLoaiXe());
						JOptionPane.showMessageDialog(this, "Xe "+xe.getMaXe()+" là "+lx.getTenLoaiXe()+"", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
			else {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin tìm kiếm!", "Thông báo",
						JOptionPane.WARNING_MESSAGE);
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
		if(o.equals(btnLamMoi))
			clearTableXe();
		if(o.equals(btnTimLX))
			timXe();
	}
}
