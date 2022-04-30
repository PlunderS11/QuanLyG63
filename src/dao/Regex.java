package dao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entity.Xe;

public class Regex {
	private Xe_DAO daoXe;

	public boolean regexTen(JTextField txtTen2) {
		String input = txtTen2.getText().trim();
		String regex = "[^\\@\\!\\$\\^\\&\\*\\(\\)]+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		if (!matcher.find()) {
			JOptionPane.showMessageDialog(null, "Tên xe không hợp lệ!", "Thông báo",
					JOptionPane.ERROR_MESSAGE);
			txtTen2.requestFocus();
			txtTen2.selectAll();
			return false;
		} else
			return true;
	}
	public boolean regexSoKhung(JTextField txtTen2) {
		String input = txtTen2.getText().trim();
		String regex = "^[a-zA-Z0-9]{1,17}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		daoXe = new Xe_DAO();
		for (Xe xe : daoXe.getDanhSachXe()) {
			if (xe.getSoKhung().equalsIgnoreCase(input)) {
				JOptionPane.showMessageDialog(null, "Số khung xe đã tồn tại!", "Thông báo",
						JOptionPane.ERROR_MESSAGE);
				txtTen2.requestFocus();
				txtTen2.selectAll();
				return false;
			}
		}
		if (!matcher.find()) {
			JOptionPane.showMessageDialog(null, "Số khung không hợp lệ chỉ giới hạn trong 17 kí tự!", "Thông báo",
					JOptionPane.ERROR_MESSAGE);
			txtTen2.requestFocus();
			txtTen2.selectAll();
			return false;
		} else
			return true;
	}
	public boolean regexSuaSoKhung(JTextField txtTen2, String temp) {
		String input = txtTen2.getText().trim();
		String regex = "^[a-zA-Z0-9]{1,17}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		daoXe = new Xe_DAO();
		for (Xe xe : daoXe.getDanhSachXeTruSoKhung(temp)) {
			if (xe.getSoKhung().equalsIgnoreCase(input)) {
				JOptionPane.showMessageDialog(null, "Số khung xe đã tồn tại!", "Thông báo",
						JOptionPane.ERROR_MESSAGE);
				txtTen2.requestFocus();
				txtTen2.selectAll();
				return false;
			}
		}
		if (!matcher.find()) {
			JOptionPane.showMessageDialog(null, "Số khung không hợp lệ chỉ giới hạn trong 17 kí tự!", "Thông báo",
					JOptionPane.ERROR_MESSAGE);
			txtTen2.requestFocus();
			txtTen2.selectAll();
			return false;
		} else
			return true;
	}
	
	
	public boolean regexSoMay(JTextField txtTen2) {
		String input = txtTen2.getText().trim();
		String regex = "^[a-zA-Z0-9]{1,17}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		daoXe = new Xe_DAO();
		for (Xe xe : daoXe.getDanhSachXe()) {
			if (xe.getSoMay().equalsIgnoreCase(input)) {
				JOptionPane.showMessageDialog(null, "Số máy xe đã tồn tại!", "Thông báo",
						JOptionPane.ERROR_MESSAGE);
				txtTen2.requestFocus();
				txtTen2.selectAll();
				return false;
			}
		}
		if (!matcher.find()) {
			JOptionPane.showMessageDialog(null, "Số máy không hợp lệ chỉ giới hạn trong 17 kí tự!", "Thông báo",
					JOptionPane.ERROR_MESSAGE);
			txtTen2.requestFocus();
			txtTen2.selectAll();
			return false;
		} else
			return true;
	}
	public boolean regexSuaSoMay(JTextField txtTen2, String temp) {
		String input = txtTen2.getText().trim();
		String regex = "^[a-zA-Z0-9]{1,17}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		daoXe = new Xe_DAO();
		for (Xe xe : daoXe.getDanhSachXeTruSoMay(temp)) {
			if (xe.getSoMay().equalsIgnoreCase(input)) {
				JOptionPane.showMessageDialog(null, "Số máy xe đã tồn tại!", "Thông báo",
						JOptionPane.ERROR_MESSAGE);
				txtTen2.requestFocus();
				txtTen2.selectAll();
				return false;
			}
		}
		if (!matcher.find()) {
			JOptionPane.showMessageDialog(null, "Số máy không hợp lệ chỉ giới hạn trong 17 kí tự!", "Thông báo",
					JOptionPane.ERROR_MESSAGE);
			txtTen2.requestFocus();
			txtTen2.selectAll();
			return false;
		} else
			return true;
	}
	
	
	public boolean regexHangSanXuat(JTextField txtTen2) {
		String input = txtTen2.getText().trim();
		String regex = "^[a-zA-Z0-9]{1,}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		if (!matcher.find()) {
			JOptionPane.showMessageDialog(null, "Hãng sản xuất không được có kí tự đặc biệt", "Thông báo",
					JOptionPane.ERROR_MESSAGE);
			txtTen2.requestFocus();
			txtTen2.selectAll();
			return false;
		} else
			return true;
	}
	
	public boolean regexGiaXe(JTextField txtGiaXe) {
		String giaXe = txtGiaXe.getText().trim();
		if(giaXe.trim().length() > 0) {
			try {
				double x = Double.parseDouble(giaXe);
				if(x <= 0) {
					JOptionPane.showMessageDialog(null, "Giá xe phải lớn hơn 0", "Lỗi", JOptionPane.ERROR_MESSAGE);
					txtGiaXe.requestFocus();
					return false;
				}
			}catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error: Giá xe phải nhập số", "Lỗi", JOptionPane.ERROR_MESSAGE);
				txtGiaXe.requestFocus();
				return false;
			}
		}else {
			JOptionPane.showMessageDialog(null, "Giá xe không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
			txtGiaXe.requestFocus();
			return false;
		}
		return true;
	}
	
	public boolean regexNhaCungCap(JTextField txtTen2) {
		String input = txtTen2.getText().trim();
		String regex = "^(Cty )([a-zA-Z0-9]*(\\s?))+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		if (!matcher.find()) {
			JOptionPane.showMessageDialog(null, "Công ty không hợp lệ\n Ví dụ: Cty TNHH Abc", "Thông báo",
					JOptionPane.ERROR_MESSAGE);
			txtTen2.requestFocus();
			txtTen2.selectAll();
			return false;
		} else
			return true;
	}

	public boolean timMaXe(JTextField txtTimKiem) {
		String input = txtTimKiem.getText().trim();
		input = input.toUpperCase();
		String regexMaP = "^((X|x)[0-9]{4})$";
		if(!input.matches(regexMaP)) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy xe cần tìm", "Thông báo",JOptionPane.ERROR_MESSAGE);
			txtTimKiem.requestFocus();
			txtTimKiem.selectAll();
			return false;
		}
		return true;
	}
	
}
