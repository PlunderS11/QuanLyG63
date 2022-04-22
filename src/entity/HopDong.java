package entity;

import java.util.Date;
import java.util.Objects;

public class HopDong {
	private String maHopDong;
	private KhachHang khachHang;
	private NhanVien nhanVien;
	private Xe xe;
	private Date ngayLapHopDong;
	public String getMaHopDong() {
		return maHopDong;
	}
	public void setMaHopDong(String maHopDong) {
		this.maHopDong = maHopDong;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public Xe getXe() {
		return xe;
	}
	public void setXe(Xe xe) {
		this.xe = xe;
	}
	public Date getNgayLapHopDong() {
		return ngayLapHopDong;
	}
	public void setNgayLapHopDong(Date ngayLapHopDong) {
		this.ngayLapHopDong = ngayLapHopDong;
	}
	public HopDong(String maHopDong, KhachHang khachHang, NhanVien nhanVien, Xe xe, Date ngayLapHopDong) {
		super();
		this.maHopDong = maHopDong;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.xe = xe;
		this.ngayLapHopDong = ngayLapHopDong;
	}
	public HopDong(String maHopDong) {
		super();
		this.maHopDong = maHopDong;
	}
	public HopDong() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(maHopDong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HopDong other = (HopDong) obj;
		return Objects.equals(maHopDong, other.maHopDong);
	}
	@Override
	public String toString() {
		return "HopDong [maHopDong=" + maHopDong + ", khachHang=" + khachHang + ", nhanVien=" + nhanVien + ", xe=" + xe
				+ ", ngayLapHopDong=" + ngayLapHopDong + "]";
	}
	
	

}
