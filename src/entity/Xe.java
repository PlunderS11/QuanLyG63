package entity;

public class Xe {
	private String maXe;
	private String tenXe;
	private String mauXe;
	private String soKhung;
	private String soMay;
	private String nhaCungCap;
	private double giaXe;
	private HangSanXuat hangSanXuat;
	private LoaiXe loaiXe;
	private String trangThai;
	

	public Xe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Xe(String maXe, String tenXe, String mauXe, String soKhung, String soMay, String nhaCungCap, double giaXe2,
			HangSanXuat hangSanXuat, LoaiXe loaiXe, String trangThai) {
		super();
		this.maXe = maXe;
		this.tenXe = tenXe;
		this.mauXe = mauXe;
		this.soKhung = soKhung;
		this.soMay = soMay;
		this.nhaCungCap = nhaCungCap;
		this.giaXe = giaXe2;
		this.hangSanXuat = hangSanXuat;
		this.loaiXe = loaiXe;
		this.trangThai = trangThai;
	}
	public Xe(String maXe) {
		super();
		this.maXe = maXe;
	}
	public Xe(String maXe2, String tenXe2, String mauXe2, String soKhung2, String soMay2, String nhaCungCap2,
			float giaXe2, String hangSanXuat2, LoaiXe loaiXe2, String trangThai2) {
		// TODO Auto-generated constructor stub
	}
	public String getMaXe() {
		return maXe;
	}
	public void setMaXe(String maXe) {
		this.maXe = maXe;
	}
	public String getTenXe() {
		return tenXe;
	}
	public void setTenXe(String tenXe) {
		this.tenXe = tenXe;
	}
	public String getMauXe() {
		return mauXe;
	}
	public void setMauXe(String mauXe) {
		this.mauXe = mauXe;
	}
	public String getSoKhung() {
		return soKhung;
	}
	public void setSoKhung(String soKhung) {
		this.soKhung = soKhung;
	}
	public String getSoMay() {
		return soMay;
	}
	public void setSoMay(String soMay) {
		this.soMay = soMay;
	}
	public String getNhaCungCap() {
		return nhaCungCap;
	}
	public void setNhaCungCap(String nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}
	public double getGiaXe() {
		return giaXe;
	}
	public void setGiaXe(double d) {
		this.giaXe = d;
	}
	public HangSanXuat getHangSanXuat() {
		return hangSanXuat;
	}
	public void setHangSanXuat(HangSanXuat hangSanXuat) {
		this.hangSanXuat = hangSanXuat;
	}
	public LoaiXe getLoaiXe() {
		return loaiXe;
	}
	public void setLoaiXe(LoaiXe loaiXe) {
		this.loaiXe = loaiXe;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maXe == null) ? 0 : maXe.hashCode());
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
		Xe other = (Xe) obj;
		if (maXe == null) {
			if (other.maXe != null)
				return false;
		} else if (!maXe.equals(other.maXe))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Xe [maXe=" + maXe + ", tenXe=" + tenXe + ", mauXe=" + mauXe + ", soKhung=" + soKhung + ", soMay="
				+ soMay + ", nhaCungCap=" + nhaCungCap + ", giaXe=" + giaXe + ", hangSanXuat=" + hangSanXuat
				+ ", loaiXe=" + loaiXe + ", trangThai=" + trangThai + "]";
	}
	
	
}
