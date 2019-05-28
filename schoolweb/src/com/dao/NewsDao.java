package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bean.TNews;
import com.util.DBWork;
import com.util.PageInfo;
/**
 * 
 * 公告信息DAO
 *
 */
public class NewsDao {
	
	private Connection conn=null;
	
	/**
	 * 分页查询
	 */
	public PageInfo queryTNews(int currentpage, int pageunit,
			HttpServletRequest request, String url, String cond) {
		
		int rowCount = this.getTNewssCount(cond);
		List<TNews> list = this.getTNewss(currentpage,
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

	public int getTNewssCount(String cond) {
		DBWork da = new DBWork();
		PreparedStatement pstmt = null; 
		int count = 0;
		try {
			conn=da.getConnection();
			String sql = " select count(*) from t_news a where 1=1 "
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
	public List<TNews> getTNewss(int currentpage, int pageunit,
			String cond) {
		List<TNews> list = new ArrayList<TNews>();
		try {
			 DBWork da = new DBWork();
			 conn=da.getConnection();
			 Statement stmt=conn.createStatement();
			 ResultSet rs=stmt.executeQuery("select * from t_news a  where 1 = 1 "+cond+" limit "+(currentpage-1)*pageunit+","+pageunit);
			 while(rs.next())
			 {
				 TNews news = new TNews();
				 news.setId(rs.getInt("id"));
				 news.setInputdate(rs.getString("inputdate"));
				 news.setRemark(rs.getString("remark"));
				 news.setTitle(rs.getString("title"));
				 news.setUsername(rs.getString("username"));
				 news.setXiangqing(rs.getString("xiangqing"));
				 list.add(news);
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
	public void addNews(TNews news) throws SQLException
	{
	  DBWork da = new DBWork();
	 try {
		 conn=da.getConnection();
	     PreparedStatement ptst=conn.prepareStatement ("insert into  t_news (title,inputdate,remark,username,xiangqing) values(?,?,?,?,?)");
		 ptst.setString(1, news.getTitle());
		 ptst.setString(2, news.getInputdate());
		 ptst.setString(3, news.getRemark());
		 ptst.setString(4, news.getUsername());
		 ptst.setString(5, news.getXiangqing());
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
	public void updateNews(TNews news) throws SQLException
	{
	  DBWork da = new DBWork();
	 try {
		 conn=da.getConnection();
	     PreparedStatement ptst=conn.prepareStatement ("update t_news set title=?,inputdate=?,remark=?,username=?,xiangqing=? where id=?");
	     ptst.setString(1, news.getTitle());
		 ptst.setString(2, news.getInputdate());
		 ptst.setString(3, news.getRemark());
		 ptst.setString(4, news.getUsername());
		 ptst.setString(5, news.getXiangqing());
		 ptst.setInt(6, news.getId());
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
	public void delNews(String id) throws SQLException
	{
	  DBWork da = new DBWork();
	 try {
		 conn=da.getConnection();
	     PreparedStatement ptst=conn.prepareStatement ("delete from t_news where id=?");
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
	public List<TNews>  queryNews(String newsName) throws SQLException
	{
		DBWork da = new DBWork();
		List<TNews> list = new ArrayList<TNews>();
		 try {
			 conn=da.getConnection();
			 Statement stmt=conn.createStatement();
			 String cond = "";
			 if(newsName!=null&&!"".equals(newsName)){
				 cond = " and typeid like '%"+newsName+"%'";
			 }
			 ResultSet rs=stmt.executeQuery("select * from t_news  where 1 = 1 "+cond);
			 while(rs.next())
			 {
				 TNews news = new TNews();
				 news.setId(rs.getInt("id"));
				 news.setInputdate(rs.getString("inputdate"));
				 news.setRemark(rs.getString("remark"));
				 news.setTitle(rs.getString("title"));
				 news.setUsername(rs.getString("username"));
				 news.setXiangqing(rs.getString("xiangqing"));
				 list.add(news);
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
	public  TNews  getNews(String id) throws SQLException
	{
		DBWork da = new DBWork();
		TNews news = new TNews();
		 try {
			 conn=da.getConnection();
			 Statement stmt=conn.createStatement();
			 ResultSet rs=stmt.executeQuery("select * from t_news u where u.id="+id);
			 if(rs.next())
			 {
				 news.setId(rs.getInt("id"));
				 news.setInputdate(rs.getString("inputdate"));
				 news.setRemark(rs.getString("remark"));
				 news.setTitle(rs.getString("title"));
				 news.setUsername(rs.getString("username"));
				 news.setXiangqing(rs.getString("xiangqing"));
			 }
			 rs.close();
			 stmt.close();
			 conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return news;
	}
}
