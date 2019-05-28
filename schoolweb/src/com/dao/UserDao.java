package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bean.TUser;
import com.util.DBWork;
import com.util.PageInfo;
/**
 * 
 * 用户DAO
 *
 */
public class UserDao {
	
	private Connection conn=null;
	
	
	/**
	 * 分页查询
	 */
	public PageInfo queryTUser(int currentpage, int pageunit,
			HttpServletRequest request, String url, String cond) {
		
		int rowCount = this.getTUsersCount(cond);
		List<TUser> list = this.getTUsers(currentpage,
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

	public int getTUsersCount(String cond) {
		DBWork da = new DBWork();
		PreparedStatement pstmt = null; 
		int count = 0;
		try {
			conn=da.getConnection();
			String sql = " select count(*) from t_user a where 1=1 "
					+ cond;
			System.out.println(sql);
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
	public List<TUser> getTUsers(int currentpage, int pageunit,
			String cond) {
		List<TUser> list = new ArrayList<TUser>();
		try {
			 DBWork da = new DBWork();
			 conn=da.getConnection();
			 Statement stmt=conn.createStatement();
			 ResultSet rs=stmt.executeQuery("select * from t_user a  where 1 = 1 "+cond+" limit "+(currentpage-1)*pageunit+","+pageunit);
			 while(rs.next())
			 {
				 TUser user = new TUser();
				 user.setId(rs.getInt("id"));
				 user.setUsername(rs.getString("username"));
				 user.setRealname(rs.getString("realname"));
				 user.setUsertype(rs.getInt("usertype"));
				 user.setPassword(rs.getString("password"));
				 user.setUsernum(rs.getString("usernum"));
				 user.setAtrr(rs.getString("atrr"));
				 user.setPhone(rs.getString("phone"));
				 user.setCard(rs.getString("card"));
				 user.setTypeid(rs.getString("typeid"));
				 list.add(user);
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
	 * 登录验证
	 *
	 */
	public  TUser  checkUser(String username,String password,String usertype) throws SQLException
	{
		DBWork da = new DBWork();
		TUser user = new TUser();
		 try {
			 conn=da.getConnection();
			 Statement stmt=conn.createStatement();
			 ResultSet rs=stmt.executeQuery("select * from t_user u where u.username='"+username+"' and password='"+password+"' and usertype = '"+usertype+"'");
			 while(rs.next())
			 {
				 user.setId(rs.getInt("id"));
				 user.setUsername(rs.getString("username"));
				 user.setRealname(rs.getString("realname"));
				 user.setUsertype(rs.getInt("usertype"));
				 user.setPassword(rs.getString("password"));
				 user.setUsernum(rs.getString("usernum"));
				 user.setAtrr(rs.getString("atrr"));
				 user.setPhone(rs.getString("phone"));
				 user.setCard(rs.getString("card"));
				 user.setTypeid(rs.getString("typeid"));
			 }
			 rs.close();
			 stmt.close();
			 conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return user;
	}
	/**
	 * 
	 *
	 * 查询
	 *
	 */
	public  TUser  getUser(String id) throws SQLException
	{
		DBWork da = new DBWork();
		TUser user = new TUser();
		 try {
			 conn=da.getConnection();
			 Statement stmt=conn.createStatement();
			 ResultSet rs=stmt.executeQuery("select * from t_user u where u.id="+id);
			 if(rs.next())
			 {
				 user.setId(rs.getInt("id"));
				 user.setUsername(rs.getString("username"));
				 user.setRealname(rs.getString("realname"));
				 user.setUsertype(rs.getInt("usertype"));
				 user.setPassword(rs.getString("password"));
				 user.setUsernum(rs.getString("usernum"));
				 user.setAtrr(rs.getString("atrr"));
				 user.setPhone(rs.getString("phone"));
				 user.setCard(rs.getString("card"));
				 user.setTypeid(rs.getString("typeid"));
			 }
			 rs.close();
			 stmt.close();
			 conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return user;
	}
	/**
	 * 
	 *
	 * 修改密码
	 *
	 */
	public void updatepassword(String password,String userid) throws SQLException
	{
	  DBWork da = new DBWork();

	 try {
		 conn=da.getConnection();
	     PreparedStatement ptst=conn.prepareStatement ("update t_user u set u.password=? where u.id=? ");
		 ptst.setString(1, password);
		 ptst.setString(2, userid);
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
	 * 添加用户
	 *
	 */
	public void addUser(TUser user) throws SQLException
	{
	  DBWork da = new DBWork();
	 try {
		 conn=da.getConnection();
	     PreparedStatement ptst=conn.prepareStatement ("insert into  t_user (username,password,realname,usertype,usernum,atrr,phone,card,typeid) values(?,?,?,?,?,?,?,?,?)");
		 ptst.setString(1, user.getUsername());
		 ptst.setString(2, user.getPassword());
		 ptst.setString(3, user.getRealname());
		 ptst.setInt(4, user.getUsertype());
		 ptst.setString(5, user.getUsernum());
		 ptst.setString(6, user.getAtrr());
		 ptst.setString(7, user.getPhone());
		 ptst.setString(8, user.getCard());
		 ptst.setString(9, user.getTypeid());
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
	 * 修改用户
	 *
	 */
	public void updateUser(TUser user) throws SQLException
	{
	  DBWork da = new DBWork();
	 try {
		 conn=da.getConnection();
	     PreparedStatement ptst=conn.prepareStatement ("update t_user set password=?,realname=?,atrr=?,phone=?,card=?,typeid=? where id=?");
		 ptst.setString(1, user.getPassword());
		 ptst.setString(2, user.getRealname());
		 ptst.setString(3, user.getAtrr());
		 ptst.setString(4, user.getPhone());
		 ptst.setString(5, user.getCard());
		 ptst.setString(6, user.getTypeid());
		 ptst.setInt(7, user.getId());
		 
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
	 * 删除用户
	 *
	 */
	public void delUser(String id) throws SQLException
	{
	  DBWork da = new DBWork();
	 try {
		 conn=da.getConnection();
	     PreparedStatement ptst=conn.prepareStatement ("delete from t_user where id=?");
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
	 * 检查用户名唯一
	 *
	 */
	public int  findName(String userName) throws SQLException
	{
		DBWork da = new DBWork();
		 try {
			 conn=da.getConnection();
			 Statement stmt=conn.createStatement();
			 ResultSet rs=stmt.executeQuery("select * from t_user where username='"+userName+"'");
			 if(rs.next())
			 {
				 return 1;
			 }
			 rs.close();
			 stmt.close();
			 conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return 0;
	}
	
	/**
	 * 
	 *
	 * 遍历用户
	 *
	 */
	public List<TUser>  queryUser(String userName) throws SQLException
	{
		DBWork da = new DBWork();
		List<TUser> list = new ArrayList<TUser>();
		 try {
			 conn=da.getConnection();
			 Statement stmt=conn.createStatement();
			 String cond = "";
			 if(userName!=null&&!"".equals(userName)){
				 cond = " and username like '%"+userName+"%'";
			 }
			 ResultSet rs=stmt.executeQuery("select * from t_user where usertype = 1 "+cond);
			 while(rs.next())
			 {
				 TUser user = new TUser();
				 user.setId(rs.getInt("id"));
				 user.setUsername(rs.getString("username"));
				 user.setRealname(rs.getString("realname"));
				 user.setUsertype(rs.getInt("usertype"));
				 user.setPassword(rs.getString("password"));
				 user.setUsernum(rs.getString("usernum"));
				 user.setAtrr(rs.getString("atrr"));
				 user.setPhone(rs.getString("phone"));
				 user.setCard(rs.getString("card"));
				 user.setTypeid(rs.getString("typeid"));
				 list.add(user);
			 }
			 rs.close();
			 stmt.close();
			 conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return list;
	}

}
