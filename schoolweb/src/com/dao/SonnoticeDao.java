package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bean.TSonnotice;
import com.util.DBWork;
import com.util.PageInfo;
/**
 * 
 * 支部信息DAO
 *
 */
public class SonnoticeDao {
	
	private Connection conn=null;
	
	/**
	 * 分页查询
	 */
	public PageInfo queryTSonnotice(int currentpage, int pageunit,
			HttpServletRequest request, String url, String cond) {
		
		int rowCount = this.getTSonnoticesCount(cond);
		List<TSonnotice> list = this.getTSonnotices(currentpage,
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

	public int getTSonnoticesCount(String cond) {
		DBWork da = new DBWork();
		PreparedStatement pstmt = null; 
		int count = 0;
		try {
			conn=da.getConnection();
			String sql = " select count(*) from t_sonnotice a where 1=1 "
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
	 * 查询并更新各学院入党积极分子人数
	 * @param typeid, typename
	 * @return
	 */
	public int updateRunum(String typeid,String typename) {
		DBWork da = new DBWork();
		PreparedStatement pstmt = null; 
		int count = 0;
		try {
			conn=da.getConnection();
			String sql = " select count(*) from t_studentru where typeid=? and typename=?";			
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, typeid);
			pstmt.setString(2, typename);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
			sql = "update t_sonnotice set rusun=? where typeid=? and typename=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, count);
			pstmt.setString(2, typeid);
			pstmt.setString(3, typename);
			pstmt.execute();
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
	 * 查询并更新各学院预备党员人数
	 * @param typeid,typename
	 */
	public int updateYunum(String typeid,String typename) {
		DBWork da = new DBWork();
		PreparedStatement pstmt = null; 
		int count = 0;
		try {
			conn=da.getConnection();
			String sql = " select count(*) from t_studentyu where typeid=? and typename=? and status='已同意'";			
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, typeid);
			pstmt.setString(2, typename);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
			sql = "update t_sonnotice set yusun=? where typeid=? and typename=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, count);
			pstmt.setString(2, typeid);
			pstmt.setString(3, typename);
			pstmt.execute();
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
	 * 查询并更新各学院正式党员人数
	 * @param typeid,typename
	 */
	public int updateZhnum(String typeid, String typename) {
		DBWork da = new DBWork();
		PreparedStatement pstmt = null; 
		int count = 0;
		try {
			conn=da.getConnection();
			String sql = " select count(*) from t_studentzh where typeid=? and typename=? and status='已同意'";			
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, typeid);
			pstmt.setString(2, typename);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
			sql = "update t_sonnotice set dangsun=? where typeid=? and typename=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, count);
			pstmt.setString(2, typeid);
			pstmt.setString(3, typename);
			pstmt.execute();
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
	public List<TSonnotice> getTSonnotices(int currentpage, int pageunit,
			String cond) {
		List<TSonnotice> list = new ArrayList<TSonnotice>();
		try {
			 DBWork da = new DBWork();
			 conn=da.getConnection();
			 Statement stmt=conn.createStatement();
			 ResultSet rs=stmt.executeQuery("select * from t_sonnotice a  where 1 = 1 "+cond+" limit "+(currentpage-1)*pageunit+","+pageunit);
			 int ssun = 0;
			 int rusun = 0;
			 int yusun = 0;
			 int dangsun = 0;
			 String typeid = "";
			 String typename = "";
			 while(rs.next())
			 {
				 TSonnotice notice = new TSonnotice();
				 notice.setId(rs.getInt("id"));
				 typeid = rs.getString("typeid");
				 typename = rs.getString("typename");
				 rusun = this.updateRunum(typeid,typename);
				 yusun = this.updateYunum(typeid,typename);
				 dangsun = this.updateZhnum(typeid,typename);
				 ssun = rusun + yusun + dangsun;
				 System.out.println(rusun+ "..."+ yusun+"..."+dangsun);
				 notice.setTypeid(typeid);
				 notice.setTypename(typename);
				 notice.setRusun(rusun);
				 notice.setYusun(yusun);
				 notice.setDangsun(dangsun);
				 notice.setSsun(ssun);
				 notice.setTel(rs.getString("tel"));
				 notice.setUsername(rs.getString("username"));
				 notice.setEmail(rs.getString("email"));
				 notice.setPhone(rs.getString("phone"));
				 list.add(notice);
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
	public void addSonnotice(TSonnotice notice) throws SQLException
	{
	  DBWork da = new DBWork();
	 try {
		 conn=da.getConnection();
	     PreparedStatement ptst=conn.prepareStatement ("insert into  t_sonnotice (typeid,typename,rusun,dangsun,username,tel,phone,email) values(?,?,?,?,?,?,?,?)");
		 ptst.setString(1, notice.getTypeid());
		 ptst.setString(2, notice.getTypename());
		 ptst.setInt(3, notice.getRusun());
		 ptst.setInt(4, notice.getDangsun());
		 ptst.setString(5, notice.getUsername());
		 ptst.setString(6, notice.getTel());
		 ptst.setString(7, notice.getPhone());
		 ptst.setString(8, notice.getEmail());
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
	public void updateSonnotice(TSonnotice notice) throws SQLException
	{
	  DBWork da = new DBWork();
	 try {
		 conn=da.getConnection();
	     PreparedStatement ptst=conn.prepareStatement ("update t_sonnotice set typeid=?,typename=?,rusun=?,dangsun=?,username=?,tel=?,phone=?,email=? where id=?");
	     ptst.setString(1, notice.getTypeid());
		 ptst.setString(2, notice.getTypename());
		 ptst.setInt(3, notice.getRusun());
		 ptst.setInt(4, notice.getDangsun());
		 ptst.setString(5, notice.getUsername());
		 ptst.setString(6, notice.getTel());
		 ptst.setString(7, notice.getPhone());
		 ptst.setString(8, notice.getEmail());
		 ptst.setInt(9, notice.getId());
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
	public void delSonnotice(String id) throws SQLException
	{
	  DBWork da = new DBWork();
	 try {
		 conn=da.getConnection();
	     PreparedStatement ptst=conn.prepareStatement ("delete from t_sonnotice where id=?");
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
	public List<TSonnotice>  querySonnotice(String noticeName) throws SQLException
	{
		DBWork da = new DBWork();
		List<TSonnotice> list = new ArrayList<TSonnotice>();
		 try {
			 conn=da.getConnection();
			 Statement stmt=conn.createStatement();
			 String cond = "";
			 if(noticeName!=null&&!"".equals(noticeName)){
				 cond = " and typeid like '%"+noticeName+"%'";
			 }
			 ResultSet rs=stmt.executeQuery("select * from t_sonnotice  where 1 = 1 "+cond);
			 while(rs.next())
			 {
				 TSonnotice notice = new TSonnotice();
				 notice.setId(rs.getInt("id"));
				 notice.setTypeid(rs.getString("typeid"));
				 notice.setDangsun(rs.getInt("dangsun"));
				 notice.setTel(rs.getString("tel"));
				 notice.setUsername(rs.getString("username"));
				 notice.setEmail(rs.getString("email"));
				 notice.setPhone(rs.getString("phone"));
				 notice.setRusun(rs.getInt("rusun"));
				 notice.setTypename(rs.getString("typename"));
				 list.add(notice);
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
	public  TSonnotice  getSonnotice(String id) throws SQLException
	{
		DBWork da = new DBWork();
		TSonnotice notice = new TSonnotice();
		 try {
			 conn=da.getConnection();
			 Statement stmt=conn.createStatement();
			 ResultSet rs=stmt.executeQuery("select * from t_sonnotice u where u.id="+id);
			 if(rs.next())
			 {
				 notice.setId(rs.getInt("id"));
				 notice.setTypeid(rs.getString("typeid"));
				 notice.setDangsun(rs.getInt("dangsun"));
				 notice.setTel(rs.getString("tel"));
				 notice.setUsername(rs.getString("username"));
				 notice.setEmail(rs.getString("email"));
				 notice.setPhone(rs.getString("phone"));
				 notice.setRusun(rs.getInt("rusun"));
				 notice.setTypename(rs.getString("typename"));
			 }
			 rs.close();
			 stmt.close();
			 conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return notice;
	}
}
