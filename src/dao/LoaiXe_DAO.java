package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ConnectDB;
import entity.HangSanXuat;
import entity.LoaiXe;
import entity.Xe;

public class LoaiXe_DAO {
	private LoaiXe loaiXe;
	public LoaiXe getLoaiXeTheoMa(String maLoaiXe) {
		LoaiXe loaiXe = new LoaiXe();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from LoaiXe where maLoaiXe = '"+maLoaiXe+"'";
		
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				loaiXe.setMaLoaiXe(rs.getString(1));
				loaiXe.setTenLoaiXe(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return loaiXe;
	}
	
	public String getMaTheoLoaiXe(String tenXe) {
		String maLoai ="";
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select maLoaiXe from LoaiXe where tenLoaiXe = N'"+tenXe +"'";
		
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				
				maLoai = rs.getString(1);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return maLoai;
		
	}
	
	public ArrayList<LoaiXe> getDanhSachLoaiXe(){
		ArrayList<LoaiXe> lsLx = new ArrayList<LoaiXe>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();	
		String sql = "Select * from LoaiXe";	
		try {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				LoaiXe lx = new LoaiXe();
				lx.setMaLoaiXe(rs.getString(1));
				lx.setTenLoaiXe(rs.getString(2));


				
				lsLx.add(lx);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lsLx;
	}
	
	public ArrayList<Xe> getDanhSachXe(String maLoaiXe){
		ArrayList<Xe> lsXe = new ArrayList<Xe>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from Xe where maLoaiXe = '"+maLoaiXe+"'";
		
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while (rs.next()) {
				Xe xe = new Xe();
				xe.setMaXe(rs.getString(1));
				xe.setTenXe(rs.getString(2));
				
				lsXe.add(xe);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return lsXe;
		
		
	}
	
}
