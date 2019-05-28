package com.util;

import java.sql.*;

public class DBWork {
	// static void conn=null;
	private Connection conn = null;
	Statement stmt = null;

	ResultSet rs = null;
	public Connection getConnection() {
		
		Connection conn = null;
		
		String sDBDriver = "com.mysql.jdbc.Driver";

		String url = "jdbc:mysql://127.0.0.1:3306/schooldb";
		
		try {
			//加载数据库驱动
			Class.forName(sDBDriver);
			//获取数据库链接
			conn = DriverManager.getConnection(url, "root", "root");

			return conn;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("数据库驱动注册错误信息： " + e.getMessage());
		}
		return conn;
	}

	public ResultSet Query(String sql) {

		DBWork dbWork = new DBWork();
		try {
			stmt = dbWork.getConnection().createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO 自动生成 catch 块
			System.out.println(e.toString());
		} catch (Exception e) {
			// TODO 自动生成 catch 块
			System.out.println(e.toString());
		}

		return rs;
	}

	public void Update(String sql) {
		DBWork dbWork = new DBWork();
		try {
			stmt = dbWork.getConnection().createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO 自动生成 catch 块
			System.out.println(e.toString());
		} catch (Exception e) {
			// TODO 自动生成 catch 块
			System.out.println(e.toString());
		}

	}
	/**
	 * 对数据库进行update操作
	 */
	public int excuteUpdate(String s) {
		int status = 0;
		
		try {
			stmt = getConnection().createStatement();
			if (stmt != null){
				status = stmt.executeUpdate(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public ResultSet excuteQuery(String sql) {
		try {
			stmt = getConnection().createStatement();
			if (stmt != null) {
				rs = stmt.executeQuery(sql);
				return rs;
			} else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public void close() {
		try {
			conn.close();
			stmt.close();
			rs.close();

		} catch (SQLException e) {
			// TODO 自动生成 catch 块
			System.out.println(e.toString());
		}

	}
	//测试数据库链接
	public static void main(String[] args) {
		DBWork db = new DBWork();
		
		System.out.println(db.getConnection());
	}
}
