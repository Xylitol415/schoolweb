package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bean.TZuzhi;
import com.util.DBWork;
import com.util.PageInfo;
/**
 * 
 * 组织信息DAO
 *
 */
public class ZuzhiDao {
	
	private Connection conn=null;
	
	/**
	 * 分页查询
	 */
	public PageInfo queryTZuzhi(int currentpage, int pageunit,
			HttpServletRequest request, String url, String cond) {
		
		int rowCount = this.getTZuzhisCount(cond);
		List<TZuzhi> list = this.getTZuzhis(currentpage,
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

	public int getTZuzhisCount(String cond) {
		DBWork da = new DBWork();
		PreparedStatement pstmt = null; 
		int count = 0;
		try {
			conn=da.getConnection();
			String sql = " select count(*) from t_zuzhi a where 1=1 "
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
	public List<TZuzhi> getTZuzhis(int currentpage, int pageunit,
			String cond) {
		List<TZuzhi> list = new ArrayList<TZuzhi>();
		try {
			 DBWork da = new DBWork();
			 conn=da.getConnection();
			 Statement stmt=conn.createStatement();
			 ResultSet rs=stmt.executeQuery("select * from t_zuzhi a  where 1 = 1 "+cond+" limit "+(currentpage-1)*pageunit+","+pageunit);
			 while(rs.next())
			 {
				 TZuzhi zuzhi = new TZuzhi();
				 zuzhi.setId(rs.getInt("id"));
				 zuzhi.setTypeid(rs.getString("typeid"));
				 zuzhi.setApplyer(rs.getString("applyer"));
				 zuzhi.setCsum(rs.getString("csum"));
				 zuzhi.setHuodate(rs.getString("huodate"));
				 zuzhi.setHuouser(rs.getString("huouser"));
				 zuzhi.setPlace(rs.getString("place"));
				 zuzhi.setStatus(rs.getString("status"));
				 zuzhi.setTel(rs.getString("tel"));
				 zuzhi.setTypename(rs.getString("typename"));
				 zuzhi.setXiangqing(rs.getString("xiangqing"));
				 zuzhi.setHuoname(rs.getString("huoname"));
				 list.add(zuzhi);
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
	public void addZuzhi(TZuzhi zuzhi) throws SQLException
	{
	  DBWork da = new DBWork();
	 try {
		 conn=da.getConnection();
	     PreparedStatement ptst=conn.prepareStatement ("insert into  t_zuzhi (typeid,typename,place,huodate,csum,huouser,tel,xiangqing,status,applyer,huoname) values(?,?,?,?,?,?,?,?,?,?,?)");
		 ptst.setString(1, zuzhi.getTypeid());
		 ptst.setString(2, zuzhi.getTypename());
		 ptst.setString(3, zuzhi.getPlace());
		 ptst.setString(4, zuzhi.getHuodate());
		 ptst.setString(5, zuzhi.getCsum());
		 ptst.setString(6, zuzhi.getHuouser());
		 ptst.setString(7, zuzhi.getTel());
		 ptst.setString(8, zuzhi.getXiangqing());
		 ptst.setString(9, zuzhi.getStatus());
		 ptst.setString(10, zuzhi.getApplyer());
		 ptst.setString(11, zuzhi.getHuoname());
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
	public void updateZuzhi(TZuzhi zuzhi) throws SQLException
	{
	  DBWork da = new DBWork();
	 try {
		 conn=da.getConnection();
	     PreparedStatement ptst=conn.prepareStatement ("update t_zuzhi set typeid=?,typename=?,place=?,huodate=?,csum=?,huouser=?,tel=?,xiangqing=?,status=?,applyer=?,huoname=? where id=?");
		 ptst.setString(1, zuzhi.getTypeid());
		 ptst.setString(2, zuzhi.getTypename());
		 ptst.setString(3, zuzhi.getPlace());
		 ptst.setString(4, zuzhi.getHuodate());
		 ptst.setString(5, zuzhi.getCsum());
		 ptst.setString(6, zuzhi.getHuouser());
		 ptst.setString(7, zuzhi.getTel());
		 ptst.setString(8, zuzhi.getXiangqing());
		 ptst.setString(9, zuzhi.getStatus());
		 ptst.setString(10, zuzhi.getApplyer());
		 ptst.setString(11, zuzhi.getHuoname());
		 ptst.setInt(12, zuzhi.getId());
		 ptst.execute();
		 ptst.close();
		 conn.close();  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void applyZuzhi(TZuzhi zuzhi) throws SQLException
	{
	  DBWork da = new DBWork();
	 try {
		 conn=da.getConnection();
	     PreparedStatement ptst=conn.prepareStatement ("update t_zuzhi set status=?,applyer=? where id=?");
		 ptst.setString(1, zuzhi.getStatus());
		 ptst.setString(2, zuzhi.getApplyer());
		 ptst.setInt(3, zuzhi.getId());
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
	public void delZuzhi(String id) throws SQLException
	{
	  DBWork da = new DBWork();
	 try {
		 conn=da.getConnection();
	     PreparedStatement ptst=conn.prepareStatement ("delete from t_zuzhi where id=?");
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
	public List<TZuzhi>  queryZuzhi(String zuzhiName) throws SQLException
	{
		DBWork da = new DBWork();
		List<TZuzhi> list = new ArrayList<TZuzhi>();
		 try {
			 conn=da.getConnection();
			 Statement stmt=conn.createStatement();
			 String cond = "";
			 if(zuzhiName!=null&&!"".equals(zuzhiName)){
				 cond = " and typeid like '%"+zuzhiName+"%'";
			 }
			 ResultSet rs=stmt.executeQuery("select * from t_zuzhi  where 1 = 1 "+cond);
			 while(rs.next())
			 {
				 TZuzhi zuzhi = new TZuzhi();
				 zuzhi.setId(rs.getInt("id"));
				 zuzhi.setTypeid(rs.getString("typeid"));
				 zuzhi.setApplyer(rs.getString("applyer"));
				 zuzhi.setCsum(rs.getString("csum"));
				 zuzhi.setHuodate(rs.getString("huodate"));
				 zuzhi.setHuouser(rs.getString("huouser"));
				 zuzhi.setPlace(rs.getString("place"));
				 zuzhi.setStatus(rs.getString("status"));
				 zuzhi.setTel(rs.getString("tel"));
				 zuzhi.setTypename(rs.getString("typename"));
				 zuzhi.setXiangqing(rs.getString("typename"));
				 zuzhi.setHuoname(rs.getString("huoname"));
				 list.add(zuzhi);
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
	public  TZuzhi  getZuzhi(String id) throws SQLException
	{
		DBWork da = new DBWork();
		TZuzhi zuzhi = new TZuzhi();
		 try {
			 conn=da.getConnection();
			 Statement stmt=conn.createStatement();
			 ResultSet rs=stmt.executeQuery("select * from t_zuzhi u where u.id="+id);
			 if(rs.next())
			 {
				 zuzhi.setId(rs.getInt("id"));
				 zuzhi.setTypeid(rs.getString("typeid"));
				 zuzhi.setApplyer(rs.getString("applyer"));
				 zuzhi.setCsum(rs.getString("csum"));
				 zuzhi.setHuodate(rs.getString("huodate"));
				 zuzhi.setHuouser(rs.getString("huouser"));
				 zuzhi.setPlace(rs.getString("place"));
				 zuzhi.setStatus(rs.getString("status"));
				 zuzhi.setTel(rs.getString("tel"));
				 zuzhi.setTypename(rs.getString("typename"));
				 zuzhi.setXiangqing(rs.getString("typename"));
				 zuzhi.setHuoname(rs.getString("huoname"));
			 }
			 rs.close();
			 stmt.close();
			 conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return zuzhi;
	}
}
