package entity;

public class HangSanXuat {
	private String maHangSX;
	private String tenHangSX;
	private String nguonGoc;
	public String getMaHangSX() {
		return maHangSX;
	}
	public void setMaHangSX(String maHangSX) {
		this.maHangSX = maHangSX;
	}
	public String getTenHangSX() {
		return tenHangSX;
	}
	public void setTenHangSX(String tenHangSX) {
		this.tenHangSX = tenHangSX;
	}
	public String getNguonGoc() {
		return nguonGoc;
	}
	public void setNguonGoc(String nguonGoc) {
		this.nguonGoc = nguonGoc;
	}
	public HangSanXuat(String maHangSX, String tenHangSX, String nguonGoc) {
		super();
		this.maHangSX = maHangSX;
		this.tenHangSX = tenHangSX;
		this.nguonGoc = nguonGoc;
	}
	public HangSanXuat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HangSanXuat(String maHangSX) {
		super();
		this.maHangSX = maHangSX;
	}
	@Override
	public String toString() {
		return "HangSanXuat [maHangSX=" + maHangSX + ", tenHangSX=" + tenHangSX + ", nguonGoc=" + nguonGoc + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maHangSX == null) ? 0 : maHangSX.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HangSanXuat other = (HangSanXuat) obj;
		if (maHangSX == null) {
			if (other.maHangSX != null)
				return false;
		} else if (!maHangSX.equals(other.maHangSX))
			return false;
		return true;
	}
	
}
