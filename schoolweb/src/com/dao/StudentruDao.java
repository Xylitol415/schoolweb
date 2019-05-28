package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bean.TStudentru;
import com.util.DBWork;
import com.util.PageInfo;
/**
 * 
 * 入党积极分子信息DAO
 *
 */
public class StudentruDao {
	
	private Connection conn=null;
	
	/**
	 * 分页查询
	 */
	public PageInfo queryTStudentru(int currentpage, int pageunit,
			HttpServletRequest request, String url, String cond) {
		
		int rowCount = this.getTStudentrusCount(cond);
		List<TStudentru> list = this.getTStudentrus(currentpage,
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

	public int getTStudentrusCount(String cond) {
		DBWork da = new DBWork();
		PreparedStatement pstmt = null; 
		int count = 0;
		try {
			conn=da.getConnection();
			String sql = " select count(*) from t_studentru a where 1=1 "
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
	public List<TStudentru> getTStudentrus(int currentpage, int pageunit,
			String cond) {
		List<TStudentru> list = new ArrayList<TStudentru>();
		try {
			 DBWork da = new DBWork();
			 conn=da.getConnection();
			 Statement stmt=conn.createStatement();
			 ResultSet rs=stmt.executeQuery("select * from t_studentru a  where 1 = 1 "+cond+" limit "+(currentpage-1)*pageunit+","+pageunit);
			 while(rs.next())
			 {
				 TStudentru studentru = new TStudentru();
				 studentru.setId(rs.getInt("id"));
				 studentru.setTypeid(rs.getString("typeid"));
				 studentru.setUsername(rs.getString("username"));
				 studentru.setBarthday(rs.getString("barthday"));
				 studentru.setClassname(rs.getString("classname"));
				 studentru.setFenzhi(rs.getString("fenzhi"));
				 studentru.setFenzhidate(rs.getString("fenzhidate"));
				 studentru.setIstrain(rs.getString("istrain"));
				 studentru.setNation(rs.getString("nation"));
				 studentru.setPlace(rs.getString("place"));
				 studentru.setRudate(rs.getString("rudate"));
				 studentru.setSixiang(rs.getString("sixiang"));
				 studentru.setTypename(rs.getString("typename"));
				 studentru.setSex(rs.getString("sex"));
				 studentru.setIdcard(rs.getString("idcard"));
				 studentru.setNewtid(rs.getString("newtid"));
				 studentru.setNewtname(rs.getString("newtname"));
				 studentru.setRollstatus(rs.getInt("rollstatus"));
				 list.add(studentru);
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
	public void addStudentru(TStudentru studentru) throws SQLException
	{
	  DBWork da = new DBWork();
	 try {
		 conn=da.getConnection();
	     PreparedStatement ptst=conn.prepareStatement ("insert into  t_studentru (typeid,typename,username,classname,nation,place,barthday,fenzhi,rudate,fenzhidate,istrain,sixiang,sex,idcard) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		 ptst.setString(1, studentru.getTypeid());
		 ptst.setString(2, studentru.getTypename());
		 ptst.setString(3, studentru.getUsername());
		 ptst.setString(4, studentru.getClassname());
		 ptst.setString(5, studentru.getNation());
		 ptst.setString(6, studentru.getPlace());
		 ptst.setString(7, studentru.getBarthday());
		 ptst.setString(8, studentru.getFenzhi());
		 ptst.setString(9, studentru.getRudate());
		 ptst.setString(10, studentru.getFenzhidate());
		 ptst.setString(11, studentru.getIstrain());
		 ptst.setString(12, studentru.getSixiang());
		 ptst.setString(13, studentru.getSex());
		 ptst.setString(14, studentru.getIdcard());
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
	public void updateStudentru(TStudentru studentru) throws SQLException
	{
	  DBWork da = new DBWork();
	 try {
		 conn=da.getConnection();
	     PreparedStatement ptst=conn.prepareStatement ("update t_studentru set typeid=?,typename=?,username=?,classname=?,nation=?,place=?,barthday=?,fenzhi=?,rudate=?,fenzhidate=?,istrain=?,sixiang=?,sex=?,idcard=? where id=?");
	     ptst.setString(1, studentru.getTypeid());
		 ptst.setString(2, studentru.getTypename());
		 ptst.setString(3, studentru.getUsername());
		 ptst.setString(4, studentru.getClassname());
		 ptst.setString(5, studentru.getNation());
		 ptst.setString(6, studentru.getPlace());
		 ptst.setString(7, studentru.getBarthday());
		 ptst.setString(8, studentru.getFenzhi());
		 ptst.setString(9, studentru.getRudate());
		 ptst.setString(10, studentru.getFenzhidate());
		 ptst.setString(11, studentru.getIstrain());
		 ptst.setString(12, studentru.getSixiang());
		 ptst.setString(13, studentru.getSex());
		 ptst.setString(14, studentru.getIdcard());
		 ptst.setInt(15, studentru.getId());
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
	public void delStudentru(String id) throws SQLException
	{
	  DBWork da = new DBWork();
	 try {
		 conn=da.getConnection();
	     PreparedStatement ptst=conn.prepareStatement ("delete from t_studentru where id=?");
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
	public List<TStudentru>  queryStudentru(String studentruName) throws SQLException
	{
		DBWork da = new DBWork();
		List<TStudentru> list = new ArrayList<TStudentru>();
		 try {
			 conn=da.getConnection();
			 Statement stmt=conn.createStatement();
			 String cond = "";
			 if(studentruName!=null&&!"".equals(studentruName)){
				 cond = " and typeid like '%"+studentruName+"%'";
			 }
			 ResultSet rs=stmt.executeQuery("select * from t_studentru  where 1 = 1 "+cond);
			 while(rs.next())
			 {
				 TStudentru studentru = new TStudentru();
				 studentru.setId(rs.getInt("id"));
				 studentru.setTypeid(rs.getString("typeid"));
				 studentru.setUsername(rs.getString("username"));
				 studentru.setBarthday(rs.getString("barthday"));
				 studentru.setClassname(rs.getString("classname"));
				 studentru.setFenzhi(rs.getString("fenzhi"));
				 studentru.setFenzhidate(rs.getString("fenzhidate"));
				 studentru.setIstrain(rs.getString("istrain"));
				 studentru.setNation(rs.getString("nation"));
				 studentru.setPlace(rs.getString("place"));
				 studentru.setRudate(rs.getString("rudate"));
				 studentru.setSixiang(rs.getString("sixiang"));
				 studentru.setTypename(rs.getString("typename"));
				 studentru.setIdcard(rs.getString("idcard"));
				 list.add(studentru);
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
	public  TStudentru  getStudentru(String id) throws SQLException
	{
		DBWork da = new DBWork();
		TStudentru studentru = new TStudentru();
		 try {
			 conn=da.getConnection();
			 Statement stmt=conn.createStatement();
			 ResultSet rs=stmt.executeQuery("select * from t_studentru u where u.id="+id);
			 if(rs.next())
			 {
				 studentru.setId(rs.getInt("id"));
				 studentru.setTypeid(rs.getString("typeid"));
				 studentru.setUsername(rs.getString("username"));
				 studentru.setBarthday(rs.getString("barthday"));
				 studentru.setClassname(rs.getString("classname"));
				 studentru.setFenzhi(rs.getString("fenzhi"));
				 studentru.setFenzhidate(rs.getString("fenzhidate"));
				 studentru.setIstrain(rs.getString("istrain"));
				 studentru.setNation(rs.getString("nation"));
				 studentru.setPlace(rs.getString("place"));
				 studentru.setRudate(rs.getString("rudate"));
				 studentru.setSixiang(rs.getString("sixiang"));
				 studentru.setTypename(rs.getString("typename"));
				 studentru.setSex(rs.getString("sex"));
				 studentru.setIdcard(rs.getString("idcard"));
			 }
			 rs.close();
			 stmt.close();
			 conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return studentru;
	}

	/**
	 * 系管理员设置转出信息和状态
	 * @param studentru
	 */
	public void rollStudentru(TStudentru studentru) {
		DBWork da = new DBWork();
		try {
			 conn=da.getConnection();
		     PreparedStatement ptst=conn.prepareStatement ("update t_studentru set newtid=?,newtname=?,rollstatus=? where id=?");
		     ptst.setString(1, studentru.getNewtid());
			 ptst.setString(2, studentru.getNewtname());
			 ptst.setInt(3, studentru.getRollstatus());
			 ptst.setInt(4, studentru.getId());
			 ptst.execute();
			 ptst.close();
			 conn.close();  
			} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	/**
	 * 超级管理员更新转出信息
	 * @param studentru
	 */
	public void rollupdateStudentru(TStudentru studentru, String flag) {
		DBWork da = new DBWork();
		try {
			 conn=da.getConnection();
			 PreparedStatement ptst = null;
			 if("0".equals(flag)){
				 ptst = conn.prepareStatement ("update t_studentru set typeid=newtid,typename=newtname,rollstatus=? where id=?");
				 ptst.setInt(1,0);
				 ptst.setInt(2, studentru.getId());
				 ptst.execute();
			 } else {
				 ptst = conn.prepareStatement ("update t_studentru set rollstatus=? where id=?");
				 ptst.setInt(1,0);
				 ptst.setInt(2, studentru.getId());
				 ptst.execute();
			 }
			 ptst.close();
			 conn.close();  
			} catch (Exception e) {
				e.printStackTrace();
		}
	}
}
