package entity;

public class LoaiXe {
	private String maLoaiXe;
	private String tenLoaiXe;
	public LoaiXe(String maLoaiXe) {
		super();
		this.maLoaiXe = maLoaiXe;
	}
	public LoaiXe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoaiXe(String maLoaiXe, String tenLoaiXe) {
		super();
		this.maLoaiXe = maLoaiXe;
		this.tenLoaiXe = tenLoaiXe;
	}
	public String getMaLoaiXe() {
		return maLoaiXe;
	}
	public void setMaLoaiXe(String maLoaiXe) {
		this.maLoaiXe = maLoaiXe;
	}
	public String getTenLoaiXe() {
		return tenLoaiXe;
	}
	public void setTenLoaiXe(String tenLoaiXe) {
		this.tenLoaiXe = tenLoaiXe;
	}
	@Override
	public String toString() {
		return "LoaiXe [maLoaiXe=" + maLoaiXe + ", tenLoaiXe=" + tenLoaiXe + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maLoaiXe == null) ? 0 : maLoaiXe.hashCode());
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
		LoaiXe other = (LoaiXe) obj;
		if (maLoaiXe == null) {
			if (other.maLoaiXe != null)
				return false;
		} else if (!maLoaiXe.equals(other.maLoaiXe))
			return false;
		return true;
	}
	
	
}
