package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bean.TNotice;
import com.util.DBWork;
import com.util.PageInfo;
/**
 * 
 * 系部信息DAO
 *
 */
public class NoticeDao {
	
	private Connection conn=null;
	
	/**
	 * 分页查询
	 */
	public PageInfo queryTNotice(int currentpage, int pageunit,
			HttpServletRequest request, String url, String cond) {
		
		int rowCount = this.getTNoticesCount(cond);
		List<TNotice> list = this.getTNotices(currentpage,
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

	public int getTNoticesCount(String cond) {
		DBWork da = new DBWork();
		PreparedStatement pstmt = null; 
		int count = 0;
		try {
			conn=da.getConnection();
			String sql = " select count(*) from t_notice a where 1=1 "
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
	 * 查询并更新各学院入党积极分子人数
	 * @param typeid
	 * @return
	 */
	public int updateRunum(String typeid) {
		DBWork da = new DBWork();
		PreparedStatement pstmt = null; 
		int count = 0;
		try {
			conn=da.getConnection();
			String sql = " select count(*) from t_studentru where typeid=?";			
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, typeid);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
			sql = "update t_notice set runum=? where typeid=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, count);
			pstmt.setString(2, typeid);
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
	 * @param typeid
	 */
	public int updateYunum(String typeid) {
		DBWork da = new DBWork();
		PreparedStatement pstmt = null; 
		int count = 0;
		try {
			conn=da.getConnection();
			String sql = " select count(*) from t_studentyu where typeid=? and status='已同意'";			
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, typeid);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
			sql = "update t_notice set yunum=? where typeid=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, count);
			pstmt.setString(2, typeid);
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
	 * @param typeid
	 */
	public int updateZhnum(String typeid) {
		DBWork da = new DBWork();
		PreparedStatement pstmt = null; 
		int count = 0;
		try {
			conn=da.getConnection();
			String sql = " select count(*) from t_studentzh where typeid=? and status='已同意'";			
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, typeid);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
			sql = "update t_notice set zhnum=? where typeid=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, count);
			pstmt.setString(2, typeid);
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
	public List<TNotice> getTNotices(int currentpage, int pageunit,
			String cond) {
		List<TNotice> list = new ArrayList<TNotice>();
		try {
			 DBWork da = new DBWork();
			 conn=da.getConnection();
			 Statement stmt=conn.createStatement();
			 ResultSet rs=stmt.executeQuery("select * from t_notice a  where 1 = 1 "+cond+" limit "+(currentpage-1)*pageunit+","+pageunit);
			 int snum = 0;
			 int runum = 0;
			 int yunum = 0;
			 int zhnum = 0;
			 String typeid = "";
			 while(rs.next())
			 {
				 TNotice notice = new TNotice();				
				 typeid = rs.getString("typeid");
				 notice.setId(rs.getInt("id"));
				 runum = this.updateRunum(typeid);
				 yunum = this.updateYunum(typeid);
				 zhnum = this.updateZhnum(typeid);
				 snum = runum + yunum + zhnum;
				 notice.setTypeid(typeid);
				 notice.setRunum(runum);
				 notice.setYunum(yunum);
				 notice.setZhnum(zhnum);
				 notice.setSnum(snum);
				 notice.setTel(rs.getString("tel"));
				 notice.setUsername(rs.getString("username"));
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
	 * 查询本学院近三年入党积极分子人数
	 * @param typeid
	 * @return
	 */
	public int[] queryRunum(String typeid) {
		DBWork da = new DBWork();
		PreparedStatement pstmt = null;
		String sql = "";
		ResultSet rs = null;
		int[] count = {0,0,0};
		try {
			conn=da.getConnection();
			sql = "select year(fenzhidate),COUNT(*) from t_studentru WHERE typeid=? AND year(fenzhidate)>'2016'  GROUP BY YEAR(fenzhidate) DESC";
			 pstmt =conn.prepareStatement(sql);
			 pstmt.setString(1, typeid);
			 rs=pstmt.executeQuery();
			 while(rs.next()) {
				 if(rs.getString(1).equals("2019")){
					 count[0] = rs.getInt(2);
				 } else if(rs.getString(1).equals("2018")){
					 count[1] = rs.getInt(2);
				 } else {
					 count[2] = rs.getInt(2);
				 }
			 }
			rs.close();
			pstmt.close();
			conn.close();	
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 查询本学院近三年预备党员人数
	 * @param typeid
	 * @return
	 */
	public int[] queryYunum(String typeid) {
		DBWork da = new DBWork();
		PreparedStatement pstmt = null;
		String sql = "";
		ResultSet rs = null;
		int[] count = {0,0,0};
		try {
			 conn=da.getConnection();
			 sql = "select year(fadate),COUNT(*) from t_studentyu WHERE typeid=? AND year(fadate)>'2016'  GROUP BY YEAR(fadate) DESC";
			 pstmt =conn.prepareStatement(sql);
			 pstmt.setString(1, typeid);
			 rs=pstmt.executeQuery();
			 while(rs.next()) {
				 if(rs.getString(1).equals("2019")){
					 count[0] = rs.getInt(2);
				 } else if(rs.getString(1).equals("2018")){
					 count[1] = rs.getInt(2);
				 } else {
					 count[2] = rs.getInt(2);
				 }
			 }
			rs.close();
			pstmt.close();
			conn.close();	
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 查询本学院近三年正式党员人数
	 * @param typeid
	 * @return
	 */
	public int[] queryZhnum(String typeid) {
		DBWork da = new DBWork();
		PreparedStatement pstmt = null;
		String sql = "";
		ResultSet rs = null;
		int[] count = {0,0,0};
		try {
			 conn=da.getConnection();
			 sql = "select year(jiedate),COUNT(*) from t_studentzh WHERE typeid=? AND year(jiedate)>'2016'  GROUP BY YEAR(jiedate) DESC";
			 pstmt =conn.prepareStatement(sql);
			 pstmt.setString(1, typeid);
			 rs=pstmt.executeQuery();
			 while(rs.next()) {
				 if(rs.getString(1).equals("2019")){
					 count[0] = rs.getInt(2);
					 System.out.println("19zh..."+count[0]);
				 } else if(rs.getString(1).equals("2018")){
					 count[1] = rs.getInt(2);
				 } else {
					 count[2] = rs.getInt(2);
				 }
			 }
			rs.close();
			pstmt.close();
			conn.close();	
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	/**
	 * 获取近三年党员数据
	 * @return List<TNotice>
	 */
	public List<TNotice> getTNotices(String typeid){
		List<TNotice> list = new ArrayList<TNotice>();
		int[] count1 = this.queryRunum(typeid);
		int[] count2 = this.queryYunum(typeid);
		int[] count3 = this.queryZhnum(typeid);
		int[] count4 = {0,0,0};
		int id = 0;
		String realname ="";
		String phone ="";
		DBWork da = new DBWork();
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		String sql = "";
		//int i = 0;
		try {
			 conn=da.getConnection();
			 sql = "select id,username,tel from t_notice WHERE typeid=?";
			 pstmt =conn.prepareStatement(sql);
			 pstmt.setString(1, typeid);
			 rs=pstmt.executeQuery();
			 if(rs.next()) {
				 id = rs.getInt("id");
				 realname = rs.getString("username");
				 phone = rs.getString("tel");
			 }
			 for(int j = 0; j <3; j++){
				 TNotice notice = new TNotice();
				 count4[j] = count1[j]+count2[j]+count3[j];
				 notice.setRunum(count1[j]);
				 notice.setYunum(count2[j]);
				 notice.setZhnum(count3[j]);
				 notice.setSnum(count4[j]);
				 notice.setId(id);
				 notice.setUsername(realname);
				 notice.setTel(phone);
				 notice.setTypeid(typeid);
				 //System.out.println("Notice["+j+"]:::"+notice.toString());
				 list.add(notice);
			 }
			 rs.close();
			 pstmt.close();
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
	public void addNotice(TNotice notice) throws SQLException
	{
	  DBWork da = new DBWork();
	 try {
		 conn=da.getConnection();
	     //PreparedStatement ptst=conn.prepareStatement ("insert into  t_notice (typeid,snum,username,tel) values(?,?,?,?)");
	     PreparedStatement ptst=conn.prepareStatement ("insert into  t_notice (typeid,snum,username,tel) values(?,?,?,?)");
		 ptst.setString(1, notice.getTypeid());
		 ptst.setInt(2, notice.getSnum());
		 ptst.setString(3, notice.getUsername());
		 ptst.setString(4, notice.getTel());
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
	public void updateNotice(TNotice notice) throws SQLException
	{
	  DBWork da = new DBWork();
	 try {
		 conn=da.getConnection();
	     PreparedStatement ptst=conn.prepareStatement ("update t_notice set typeid=?,snum=?,username=?,tel=? where id=?");
		 ptst.setString(1, notice.getTypeid());
		 ptst.setInt(2, notice.getSnum());
		 ptst.setString(3, notice.getUsername());
		 ptst.setString(4, notice.getTel());
		 ptst.setInt(5, notice.getId());
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
	public void delNotice(String id) throws SQLException
	{
	  DBWork da = new DBWork();
	 try {
		 conn=da.getConnection();
	     PreparedStatement ptst=conn.prepareStatement ("delete from t_notice where id=?");
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
	public List<TNotice>  queryNotice(String noticeName) throws SQLException
	{
		DBWork da = new DBWork();
		List<TNotice> list = new ArrayList<TNotice>();
		 try {
			 conn=da.getConnection();
			 Statement stmt=conn.createStatement();
			 String cond = "";
			 if(noticeName!=null&&!"".equals(noticeName)){
				 cond = " and typeid like '%"+noticeName+"%'";
			 }
			 ResultSet rs=stmt.executeQuery("select * from t_notice  where 1 = 1 "+cond);
			 while(rs.next())
			 {
				 TNotice notice = new TNotice();
				 notice.setId(rs.getInt("id"));
				 notice.setTypeid(rs.getString("typeid"));
				 notice.setSnum(rs.getInt("snum"));
				 notice.setSnum(rs.getInt("runum"));
				 notice.setSnum(rs.getInt("yunum"));
				 notice.setSnum(rs.getInt("zhnum"));
				 notice.setTel(rs.getString("tel"));
				 notice.setUsername(rs.getString("username"));
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
	public  TNotice  getNotice(String id) throws SQLException
	{
		DBWork da = new DBWork();
		TNotice notice = new TNotice();
		 try {
			 conn=da.getConnection();
			 Statement stmt=conn.createStatement();
			 ResultSet rs=stmt.executeQuery("select * from t_notice u where u.id="+id);
			 if(rs.next())
			 {
				 notice.setId(rs.getInt("id"));
				 notice.setTypeid(rs.getString("typeid"));
				 notice.setSnum(rs.getInt("snum"));
				 notice.setTel(rs.getString("tel"));
				 notice.setUsername(rs.getString("username"));
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
