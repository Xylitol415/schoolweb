package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bean.TDangfei;
import com.util.DBWork;
import com.util.PageInfo;
/**
 * 
 * 党费信息DAO
 *
 */
public class DangfeiDao {
	
	private Connection conn=null;
	
	/**
	 * 分页查询
	 */
	public PageInfo queryTDangfei(int currentpage, int pageunit,
			HttpServletRequest request, String url, String cond) {
		
		int rowCount = this.getTDangfeisCount(cond);
		List<TDangfei> list = this.getTDangfeis(currentpage,
				pageunit, cond);
		PageInfo PageInfo = new PageInfo(currentpage, pageunit, rowCount, url,
				list);
		return PageInfo;
	}
	
	/**
	 * 
	 * 统计总记录数
	 * 
	 */

	public int getTDangfeisCount(String cond) {
		DBWork da = new DBWork();
		PreparedStatement pstmt = null; 
		int count = 0;
		try {
			conn=da.getConnection();
			String sql = " select count(*) from t_dangfei a where 1=1 "
					+ cond;
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
			rs.close();
			pstmt.close();
			conn.close();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * 
	 * 信息处理分页查询
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<TDangfei> getTDangfeis(int currentpage, int pageunit,
			String cond) {
		List<TDangfei> list = new ArrayList<TDangfei>();
		try {
			 DBWork da = new DBWork();
			 conn=da.getConnection();
			 Statement stmt=conn.createStatement();
			 ResultSet rs=stmt.executeQuery("select * from t_dangfei a  where 1 = 1 "+cond+" limit "+(currentpage-1)*pageunit+","+pageunit);
			 while(rs.next())
			 {
				 TDangfei dangfei = new TDangfei();
				 dangfei.setId(rs.getInt("id"));
				 dangfei.setTypeid(rs.getString("typeid"));
				 dangfei.setTypename(rs.getString("typename"));
				 dangfei.setClassname(rs.getString("classname"));
				 dangfei.setDangfei(rs.getDouble("dangfei"));
				 dangfei.setDangtype(rs.getInt("dangtype"));
				 dangfei.setUsername(rs.getString("username"));
				 dangfei.setShouyear(rs.getString("shouyear"));
				 list.add(dangfei);
			 }
			 rs.close();
			 stmt.close();
			 conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 
	 *
	 * 添加系部信息
	 *
	 */
	public void addDangfei(TDangfei dangfei) throws SQLException
	{
	  DBWork da = new DBWork();
	 try {
		 conn=da.getConnection();
	     PreparedStatement ptst=conn.prepareStatement ("insert into  t_dangfei (typeid,typename,username,classname,dangtype,shouyear,dangfei) values(?,?,?,?,?,?,?)");
		 ptst.setString(1, dangfei.getTypeid());
		 ptst.setString(2, dangfei.getTypename());
		 ptst.setString(3, dangfei.getUsername());
		 ptst.setString(4, dangfei.getClassname());
		 ptst.setInt(5, dangfei.getDangtype());
		 ptst.setString(6, dangfei.getShouyear());
		 ptst.setDouble(7, dangfei.getDangfei());
		 ptst.execute();
		 ptst.close();
		 conn.close();  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 *
	 * 修改系部信息
	 *
	 */
	public void updateDangfei(TDangfei dangfei) throws SQLException
	{
	  DBWork da = new DBWork();
	 try {
		 conn=da.getConnection();
	     PreparedStatement ptst=conn.prepareStatement ("update t_dangfei set typeid=?,typename=?,username=?,classname=?,dangtype=?,shouyear=?,dangfei=? where id=?");
	     ptst.setString(1, dangfei.getTypeid());
		 ptst.setString(2, dangfei.getTypename());
		 ptst.setString(3, dangfei.getUsername());
		 ptst.setString(4, dangfei.getClassname());
		 ptst.setInt(5, dangfei.getDangtype());
		 ptst.setString(6, dangfei.getShouyear());
		 ptst.setDouble(7, dangfei.getDangfei());
		 ptst.setInt(8, dangfei.getId());
		 ptst.execute();
		 ptst.close();
		 conn.close();  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 *
	 * 删除系部信息
	 *
	 */
	public void delDangfei(String id) throws SQLException
	{
	  DBWork da = new DBWork();
	 try {
		 conn=da.getConnection();
	     PreparedStatement ptst=conn.prepareStatement ("delete from t_dangfei where id=?");
		 ptst.setString(1, id);
		 ptst.execute();
		 ptst.close();
		 conn.close();  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 *
	 * 遍历系部信息
	 *
	 */
	public List<TDangfei>  queryDangfei(String dangfeiName) throws SQLException
	{
		DBWork da = new DBWork();
		List<TDangfei> list = new ArrayList<TDangfei>();
		 try {
			 conn=da.getConnection();
			 Statement stmt=conn.createStatement();
			 String cond = "";
			 if(dangfeiName!=null&&!"".equals(dangfeiName)){
				 cond = " and typeid like '%"+dangfeiName+"%'";
			 }
			 ResultSet rs=stmt.executeQuery("select * from t_dangfei  where 1 = 1 "+cond);
			 while(rs.next())
			 {
				 TDangfei dangfei = new TDangfei();
				 dangfei.setId(rs.getInt("id"));
				 dangfei.setTypeid(rs.getString("typeid"));
				 dangfei.setTypename(rs.getString("typename"));
				 dangfei.setClassname(rs.getString("classname"));
				 dangfei.setDangfei(Double.parseDouble(rs.getString("dangfei")));
				 dangfei.setDangtype(Integer.parseInt(rs.getString("dangtype")));
				 dangfei.setUsername(rs.getString("username"));
				 dangfei.setShouyear(rs.getString("shouyear"));
				 list.add(dangfei);
			 }
			 rs.close();
			 stmt.close();
			 conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return list;
	}
	/**
	 * 
	 *
	 * 查询
	 *
	 */
	public  TDangfei  getDangfei(String id) throws SQLException
	{
		DBWork da = new DBWork();
		TDangfei dangfei = new TDangfei();
		 try {
			 conn=da.getConnection();
			 Statement stmt=conn.createStatement();
			 ResultSet rs=stmt.executeQuery("select * from t_dangfei u where u.id="+id);
			 if(rs.next())
			 {
				 dangfei.setId(rs.getInt("id"));
				 dangfei.setTypeid(rs.getString("typeid"));
				 dangfei.setTypename(rs.getString("typename"));
				 dangfei.setClassname(rs.getString("classname"));
				 dangfei.setDangfei(Double.parseDouble(rs.getString("dangfei")));
				 dangfei.setDangtype(Integer.parseInt(rs.getString("dangtype")));
				 dangfei.setUsername(rs.getString("username"));
				 dangfei.setShouyear(rs.getString("shouyear"));
			 }
			 rs.close();
			 stmt.close();
			 conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return dangfei;
	}
}
