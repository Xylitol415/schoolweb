package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bean.TStudentyu;
import com.util.DBWork;
import com.util.PageInfo;
/**
 * 
 * 预备党员信息信息DAO
 *
 */
public class StudentyuDao {
	
	private Connection conn=null;
	
	/**
	 * 分页查询
	 */
	public PageInfo queryTStudentyu(int currentpage, int pageunit,
			HttpServletRequest request, String url, String cond) {
		
		int rowCount = this.getTStudentyusCount(cond);
		List<TStudentyu> list = this.getTStudentyus(currentpage,
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

	public int getTStudentyusCount(String cond) {
		DBWork da = new DBWork();
		PreparedStatement pstmt = null; 
		int count = 0;
		try {
			conn=da.getConnection();
			String sql = " select count(*) from t_studentyu a where 1=1 "
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
	public List<TStudentyu> getTStudentyus(int currentpage, int pageunit,
			String cond) {
		List<TStudentyu> list = new ArrayList<TStudentyu>();
		try {
			 DBWork da = new DBWork();
			 conn=da.getConnection();
			 Statement stmt=conn.createStatement();
			 ResultSet rs=stmt.executeQuery("select * from t_studentyu a  where 1 = 1 "+cond+" limit "+(currentpage-1)*pageunit+","+pageunit);
			 while(rs.next())
			 {
				 TStudentyu studentyu = new TStudentyu();
				 studentyu.setId(rs.getInt("id"));
				 studentyu.setTypeid(rs.getString("typeid"));
				 studentyu.setUsername(rs.getString("username"));
				 studentyu.setBarthday(rs.getString("barthday"));
				 studentyu.setClassname(rs.getString("classname"));
				 studentyu.setFenzhi(rs.getString("fenzhi"));
				 studentyu.setNation(rs.getString("nation"));
				 studentyu.setPlace(rs.getString("place"));
				 studentyu.setSixiang(rs.getString("sixiang"));
				 studentyu.setTypename(rs.getString("typename"));
				 studentyu.setSex(rs.getString("sex"));
				 studentyu.setApplyer(rs.getString("applyer"));
				 studentyu.setFadate(rs.getString("fadate"));
				 studentyu.setJiedate(rs.getString("jiedate"));
				 studentyu.setJieuser(rs.getString("jieuser"));
				 studentyu.setJueyi(rs.getString("jueyi"));
				 studentyu.setStatus(rs.getString("status"));
				 studentyu.setRudate(rs.getString("rudate"));
				 studentyu.setIdcard(rs.getString("idcard"));
				 studentyu.setNewtid(rs.getString("newtid"));
				 studentyu.setNewtname(rs.getString("newtname"));
				 studentyu.setRollstatus(rs.getInt("rollstatus"));
				 list.add(studentyu);
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
	public void addStudentyu(TStudentyu studentyu) throws SQLException
	{
	  DBWork da = new DBWork();
	 try {
		 conn=da.getConnection();
	     PreparedStatement ptst=conn.prepareStatement ("insert into  t_studentyu (typeid,typename,username,classname,nation,place,barthday,fenzhi,fadate,jiedate,jieuser,sixiang,sex,jueyi,status,applyer,rudate,idcard) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		 ptst.setString(1, studentyu.getTypeid());
		 ptst.setString(2, studentyu.getTypename());
		 ptst.setString(3, studentyu.getUsername());
		 ptst.setString(4, studentyu.getClassname());
		 ptst.setString(5, studentyu.getNation());
		 ptst.setString(6, studentyu.getPlace());
		 ptst.setString(7, studentyu.getBarthday());
		 ptst.setString(8, studentyu.getFenzhi());
		 ptst.setString(9, studentyu.getFadate());
		 ptst.setString(10, studentyu.getJiedate());
		 ptst.setString(11, studentyu.getJieuser());
		 ptst.setString(12, studentyu.getSixiang());
		 ptst.setString(13, studentyu.getSex());
		 ptst.setString(14, studentyu.getJueyi());
		 ptst.setString(15, studentyu.getStatus());
		 ptst.setString(16, studentyu.getApplyer());
		 ptst.setString(17, studentyu.getRudate());
		 ptst.setString(18, studentyu.getIdcard());
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
	public void updateStudentyu(TStudentyu studentyu) throws SQLException
	{
	  DBWork da = new DBWork();
	 try {
		 conn=da.getConnection();
	     PreparedStatement ptst=conn.prepareStatement ("update t_studentyu set typeid=?,typename=?,username=?,classname=?,nation=?,place=?,barthday=?,fenzhi=?,fadate=?,jiedate=?,jieuser=?,sixiang=?,sex=?,jueyi=?,status=?,applyer=?,rudate=?,idcard=? where id=?");
	     ptst.setString(1, studentyu.getTypeid());
		 ptst.setString(2, studentyu.getTypename());
		 ptst.setString(3, studentyu.getUsername());
		 ptst.setString(4, studentyu.getClassname());
		 ptst.setString(5, studentyu.getNation());
		 ptst.setString(6, studentyu.getPlace());
		 ptst.setString(7, studentyu.getBarthday());
		 ptst.setString(8, studentyu.getFenzhi());
		 ptst.setString(9, studentyu.getFadate());
		 ptst.setString(10, studentyu.getJiedate());
		 ptst.setString(11, studentyu.getJieuser());
		 ptst.setString(12, studentyu.getSixiang());
		 ptst.setString(13, studentyu.getSex());
		 ptst.setString(14, studentyu.getJueyi());
		 ptst.setString(15, studentyu.getStatus());
		 ptst.setString(16, studentyu.getApplyer());
		 ptst.setString(17, studentyu.getRudate());
		 ptst.setString(18, studentyu.getIdcard());
		 ptst.setInt(19, studentyu.getId());
		 ptst.execute();
		 ptst.close();
		 conn.close();  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void applyStudentyu(TStudentyu studentyu) throws SQLException
	{
	  DBWork da = new DBWork();
	 try {
		 conn=da.getConnection();
	     PreparedStatement ptst=conn.prepareStatement ("update t_studentyu set status=?,applyer=? where id=?");
		 ptst.setString(1, studentyu.getStatus());
		 ptst.setString(2, studentyu.getApplyer());
		 ptst.setInt(3, studentyu.getId());
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
	public void delStudentyu(String id) throws SQLException
	{
	  DBWork da = new DBWork();
	 try {
		 conn=da.getConnection();
	     PreparedStatement ptst=conn.prepareStatement ("delete from t_studentyu where id=?");
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
	public List<TStudentyu>  queryStudentyu(String studentyuName) throws SQLException
	{
		DBWork da = new DBWork();
		List<TStudentyu> list = new ArrayList<TStudentyu>();
		 try {
			 conn=da.getConnection();
			 Statement stmt=conn.createStatement();
			 String cond = "";
			 if(studentyuName!=null&&!"".equals(studentyuName)){
				 cond = " and typeid like '%"+studentyuName+"%'";
			 }
			 ResultSet rs=stmt.executeQuery("select * from t_studentyu  where 1 = 1 "+cond);
			 while(rs.next())
			 {
				 TStudentyu studentyu = new TStudentyu();
				 studentyu.setId(rs.getInt("id"));
				 studentyu.setTypeid(rs.getString("typeid"));
				 studentyu.setUsername(rs.getString("username"));
				 studentyu.setBarthday(rs.getString("barthday"));
				 studentyu.setClassname(rs.getString("classname"));
				 studentyu.setFenzhi(rs.getString("fenzhi"));
				 studentyu.setNation(rs.getString("nation"));
				 studentyu.setPlace(rs.getString("place"));
				 studentyu.setSixiang(rs.getString("sixiang"));
				 studentyu.setTypename(rs.getString("typename"));
				 studentyu.setSex(rs.getString("sex"));
				 studentyu.setApplyer(rs.getString("applyer"));
				 studentyu.setFadate(rs.getString("fadate"));
				 studentyu.setJiedate(rs.getString("jiedate"));
				 studentyu.setJieuser(rs.getString("jieuser"));
				 studentyu.setJueyi(rs.getString("jueyi"));
				 studentyu.setStatus(rs.getString("status"));
				 studentyu.setRudate(rs.getString("rudate"));
				 studentyu.setIdcard(rs.getString("idcard"));
				 list.add(studentyu);
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
	public  TStudentyu  getStudentyu(String id) throws SQLException
	{
		DBWork da = new DBWork();
		TStudentyu studentyu = new TStudentyu();
		 try {
			 conn=da.getConnection();
			 Statement stmt=conn.createStatement();
			 ResultSet rs=stmt.executeQuery("select * from t_studentyu u where u.id="+id);
			 if(rs.next())
			 {
				 studentyu.setId(rs.getInt("id"));
				 studentyu.setTypeid(rs.getString("typeid"));
				 studentyu.setUsername(rs.getString("username"));
				 studentyu.setBarthday(rs.getString("barthday"));
				 studentyu.setClassname(rs.getString("classname"));
				 studentyu.setFenzhi(rs.getString("fenzhi"));
				 studentyu.setNation(rs.getString("nation"));
				 studentyu.setPlace(rs.getString("place"));
				 studentyu.setSixiang(rs.getString("sixiang"));
				 studentyu.setTypename(rs.getString("typename"));
				 studentyu.setSex(rs.getString("sex"));
				 studentyu.setApplyer(rs.getString("applyer"));
				 studentyu.setFadate(rs.getString("fadate"));
				 studentyu.setJiedate(rs.getString("jiedate"));
				 studentyu.setJieuser(rs.getString("jieuser"));
				 studentyu.setJueyi(rs.getString("jueyi"));
				 studentyu.setStatus(rs.getString("status"));
				 studentyu.setRudate(rs.getString("rudate"));
				 studentyu.setIdcard(rs.getString("idcard"));
			 }
			 rs.close();
			 stmt.close();
			 conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return studentyu;
	}

	public void rollStudentyu(TStudentyu studentyu) {
		// TODO Auto-generated method stub
		DBWork da = new DBWork();
		try {
			 conn=da.getConnection();
		     PreparedStatement ptst=conn.prepareStatement ("update t_studentyu set newtid=?,newtname=?,rollstatus=? where id=?");
		     ptst.setString(1, studentyu.getNewtid());
			 ptst.setString(2, studentyu.getNewtname());
			 ptst.setInt(3, studentyu.getRollstatus());
			 ptst.setInt(4, studentyu.getId());
			 ptst.execute();
			 ptst.close();
			 conn.close();  
			} catch (Exception e) {
				e.printStackTrace();
		}
	}

	public void rollupdateStudentyu(TStudentyu studentyu, String flag) {
		DBWork da = new DBWork();
		try {
			 conn=da.getConnection();
			 PreparedStatement ptst = null;
			 if("0".equals(flag)){
				 ptst = conn.prepareStatement ("update t_studentyu set typeid=newtid,typename=newtname,rollstatus=? where id=?");
				 ptst.setInt(1,0);
				 ptst.setInt(2, studentyu.getId());
				 ptst.execute();
			 } else {
				 ptst = conn.prepareStatement ("update t_studentyu set rollstatus=? where id=?");
				 ptst.setInt(1,0);
				 ptst.setInt(2, studentyu.getId());
				 ptst.execute();
			 }
			 ptst.close();
			 conn.close();  
			} catch (Exception e) {
				e.printStackTrace();
		}
	}
}
