package org.zucc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.zucc.entity.Dvd;

public class DvdDao {

	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pdst = null;

	public DvdDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("驱动错误");
			e.printStackTrace();
		}
	}

	public void myclose() {
		try {
			if (rs != null)
				rs.close();
			if (pdst != null)
				pdst.close();
			if (conn != null)
				conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("关闭数据库错误");
			e.printStackTrace();
		}
	}

	public void addDvd(Dvd dvd) {

		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/minidvd", "root", "root");
			String sql = "insert into dvd(name)values(?)";
			pdst = conn.prepareStatement(sql);
			pdst.setString(1, dvd.getName());

			pdst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("连接错误");
			e.printStackTrace();
		} finally {

			myclose();

		}

	}

	public void deletebyId(int Id) {

		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/minidvd", "root", "root");

			String sql = "delete from dvd where id =?";
			pdst = conn.prepareStatement(sql);
			pdst.setInt(1, Id);
			System.out.println(sql);
			pdst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("连接错误");
			e.printStackTrace();
		} finally {
			myclose();

		}

	}

	public void updateDvd(Dvd dvd) {

		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/minidvd", "root", "root");

			String sql = "update dvd set name =?,state=?,borrowdate=?,returndate=?,dvdcount=? where id =?";
			pdst = conn.prepareStatement(sql);
			pdst.setString(1, dvd.getName());
			pdst.setInt(2, dvd.getState());
			java.sql.Date sqlBorrow = dvd.getBorrowdate() == null ? null
					: new java.sql.Date(dvd.getBorrowdate().getTime());
			pdst.setDate(3, sqlBorrow);
			java.sql.Date sqlReturn = dvd.getReturndate() == null ? null
					: new java.sql.Date(dvd.getReturndate().getTime());
			pdst.setDate(4, sqlReturn);
			pdst.setInt(5, dvd.getDvdcount());
			pdst.setInt(6, dvd.getId());
			System.out.println(sql);
			pdst.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("更新错误");
			e.printStackTrace();
		} finally {

			myclose();
		}

	}

	public Dvd findbyId(int Id) {

		Dvd dvd = new Dvd();
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/minidvd", "root", "root");

			String sql = "select * from dvd where id =? ";
			pdst = conn.prepareStatement(sql);
			pdst.setInt(1, Id);
			rs = pdst.executeQuery();
			while (rs.next()) {

				dvd.setBorrowdate(rs.getDate("borrowdate"));
				dvd.setId(rs.getInt("Id"));
				dvd.setName(rs.getString("name"));
				dvd.setReturndate(rs.getDate("returndate"));
				dvd.setState(rs.getInt("state"));
				dvd.setDvdcount(rs.getInt("dvdcount"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("连接错误");
			e.printStackTrace();
		} finally {

			myclose();

		}
		return dvd;

	}

	public List<Dvd> findbyName(String name) {
		List<Dvd> list = new ArrayList<Dvd>();
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/minidvd", "root", "root");

			String sql = "select * from dvd where name =?";
			pdst = conn.prepareStatement(sql);
			pdst.setString(1, name);
			System.out.println(sql);
			rs = pdst.executeQuery();

			while (rs.next()) {
				Dvd dvd = new Dvd();
				dvd.setBorrowdate(rs.getDate("borrowdate"));
				dvd.setId(rs.getInt("Id"));
				dvd.setName(rs.getString("name"));
				dvd.setReturndate(rs.getDate("returndate"));
				dvd.setState(rs.getInt("state"));
				list.add(dvd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("连接错误");
			e.printStackTrace();
		} finally {

			myclose();
		}
		return list;

	}

	public List<Dvd> findall() {
		List<Dvd> list = new ArrayList<Dvd>();
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/minidvd", "root", "root");

			String sql = "select * from dvd";
			pdst = conn.prepareStatement(sql);
			rs = pdst.executeQuery();

			while (rs.next()) {
				Dvd dvd = new Dvd();
				dvd.setBorrowdate(rs.getDate("borrowdate"));
				dvd.setId(rs.getInt("Id"));
				dvd.setName(rs.getString("name"));
				dvd.setReturndate(rs.getDate("returndate"));
				dvd.setState(rs.getInt("state"));
				dvd.setDvdcount(rs.getInt("dvdcount"));
				list.add(dvd);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("连接错误");
			e.printStackTrace();
		} finally {

			myclose();

		}
		return list;
	}

}
