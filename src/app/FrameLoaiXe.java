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
		panel.setBounds(10, 0, 1311, 77);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblMaLoaiXe = new JLabel("Mã loại xe:");
		lblMaLoaiXe.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMaLoaiXe.setBounds(10, 26, 104, 20);
		panel.add(lblMaLoaiXe);
		
		txtMaLoaiXe = new JTextField();
		txtMaLoaiXe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMaLoaiXe.setEditable(false);
		txtMaLoaiXe.setBounds(111, 24, 214, 28);
		panel.add(txtMaLoaiXe);
		txtMaLoaiXe.setColumns(10);
		
		JLabel lblTenLoaiXe = new JLabel("Tên loại xe:");
		lblTenLoaiXe.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTenLoaiXe.setBounds(373, 32, 104, 15);
		panel.add(lblTenLoaiXe);
		
		txtTenLoaiXe = new JTextField();
		txtTenLoaiXe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenLoaiXe.setBounds(487, 26, 214, 28);
		panel.add(txtTenLoaiXe);
		txtTenLoaiXe.setColumns(10);
		
		btnLamMoi = new FixButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon("image\\lammoi.png"));
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLamMoi.setBackground(new Color(107, 96, 236));
		btnLamMoi.setBounds(733, 23, 145, 32);
		panel.add(btnLamMoi);
		
		JScrollPane scrlLoaiXe = new JScrollPane();
		scrlLoaiXe.setBounds(10, 87, 1309, 135);
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
		scrlTenXe.setBounds(10, 232, 1309, 373);
		
		
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
			txtTenLoaiXe.setText("");
			txtMaLoaiXe.setText("");
			XoaDL();
			loadDanhSachLoaiXe();
			clearTableXe();
			
		
	}
	private void XoaDL() {
		DefaultTableModel dm = (DefaultTableModel) tableLoaiXe.getModel();
		dm.getDataVector().removeAllElements();
	}
}
