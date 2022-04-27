package dao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Regex {
	public boolean regexTen(JTextField txtTen2) {
		String input = txtTen2.getText().trim();
		String regex = "^([ A-Za-za-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]*(\\s?))+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		if (!matcher.find()) {
			JOptionPane.showMessageDialog(null, "Họ tên không hợp lệ!\nMẫu họ tên: Nguyễn Văn A", "Thông báo",
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
		String input = txtGiaXe.getText();
		String regex = "^[1-9]+[0-9]*$";
		if (!input.matches(regex)) {
			JOptionPane.showMessageDialog(null,
					"Giá xe không được để trống và không được có kí tự chữ", "Thông báo",
					JOptionPane.ERROR_MESSAGE);
			txtGiaXe.requestFocus();
			txtGiaXe.selectAll();
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
