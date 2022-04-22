package entity;

import java.util.Date;
import java.util.Objects;

public class HoaDon {
	private String maHoaDon;
	private HopDong hopDong;
	private Date ngayLap;
	private double donGia;
	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public HopDong getHopDong() {
		return hopDong;
	}
	public void setHopDong(HopDong hopDong) {
		this.hopDong = hopDong;
	}
	public Date getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public HoaDon(String maHoaDon, HopDong hopDong, Date ngayLap, double donGia) {
		super();
		this.maHoaDon = maHoaDon;
		this.hopDong = hopDong;
		this.ngayLap = ngayLap;
		this.donGia = donGia;
	}
	public HoaDon(String maHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
	}
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(maHoaDon);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(maHoaDon, other.maHoaDon);
	}
	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", hopDong=" + hopDong + ", ngayLap=" + ngayLap + ", donGia=" + donGia
				+ "]";
	}
	
}
