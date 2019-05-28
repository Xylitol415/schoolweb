package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bean.TStudentzh;
import com.util.DBWork;
import com.util.PageInfo;
/**
 * 
 * 正式党员信息信息DAO
 *
 */
public class StudentzhDao {
	
	private Connection conn=null;
	
	/**
	 * 分页查询
	 */
	public PageInfo queryTStudentzh(int currentpage, int pageunit,
			HttpServletRequest request, String url, String cond) {
		
		int rowCount = this.getTStudentzhsCount(cond);
		List<TStudentzh> list = this.getTStudentzhs(currentpage,
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

	public int getTStudentzhsCount(String cond) {
		DBWork da = new DBWork();
		PreparedStatement pstmt = null; 
		int count = 0;
		try {
			conn=da.getConnection();
			String sql = " select count(*) from t_studentzh a where 1=1 "
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
	public List<TStudentzh> getTStudentzhs(int currentpage, int pageunit,
			String cond) {
		List<TStudentzh> list = new ArrayList<TStudentzh>();
		try {
			 DBWork da = new DBWork();
			 conn=da.getConnection();
			 Statement stmt=conn.createStatement();
			 ResultSet rs=stmt.executeQuery("select * from t_studentzh a  where 1 = 1 "+cond+" limit "+(currentpage-1)*pageunit+","+pageunit);
			 while(rs.next())
			 {
				 TStudentzh studentzh = new TStudentzh();
				 studentzh.setId(rs.getInt("id"));
				 studentzh.setTypeid(rs.getString("typeid"));
				 studentzh.setUsername(rs.getString("username"));
				 studentzh.setBarthday(rs.getString("barthday"));
				 studentzh.setClassname(rs.getString("classname"));
				 studentzh.setFenzhi(rs.getString("fenzhi"));
				 studentzh.setNation(rs.getString("nation"));
				 studentzh.setPlace(rs.getString("place"));
				 studentzh.setSixiang(rs.getString("sixiang"));
				 studentzh.setTypename(rs.getString("typename"));
				 studentzh.setSex(rs.getString("sex"));
				 studentzh.setApplyer(rs.getString("applyer"));
				 studentzh.setFadate(rs.getString("fadate"));
				 studentzh.setJiedate(rs.getString("jiedate"));
				 studentzh.setZhuandate(rs.getString("zhuandate"));
				 studentzh.setJieuser(rs.getString("jieuser"));
				 studentzh.setJueyi(rs.getString("jueyi"));
				 studentzh.setStatus(rs.getString("status"));
				 studentzh.setRudate(rs.getString("rudate"));
				 studentzh.setIdcard(rs.getString("idcard"));
				 studentzh.setNewtid(rs.getString("newtid"));
				 studentzh.setNewtname(rs.getString("newtname"));
				 studentzh.setRollstatus(rs.getInt("rollstatus"));
				 list.add(studentzh);
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
	public void addStudentzh(TStudentzh studentzh) throws SQLException
	{
	  DBWork da = new DBWork();
	 try {
		 conn=da.getConnection();
	     PreparedStatement ptst=conn.prepareStatement ("insert into  t_studentzh (typeid,typename,username,classname,nation,place,barthday,fenzhi,fadate,jiedate,jieuser,sixiang,sex,jueyi,status,applyer,rudate,idcard,zhuandate) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		 ptst.setString(1, studentzh.getTypeid());
		 ptst.setString(2, studentzh.getTypename());
		 ptst.setString(3, studentzh.getUsername());
		 ptst.setString(4, studentzh.getClassname());
		 ptst.setString(5, studentzh.getNation());
		 ptst.setString(6, studentzh.getPlace());
		 ptst.setString(7, studentzh.getBarthday());
		 ptst.setString(8, studentzh.getFenzhi());
		 ptst.setString(9, studentzh.getFadate());
		 ptst.setString(10, studentzh.getJiedate());
		 ptst.setString(11, studentzh.getJieuser());
		 ptst.setString(12, studentzh.getSixiang());
		 ptst.setString(13, studentzh.getSex());
		 ptst.setString(14, studentzh.getJueyi());
		 ptst.setString(15, studentzh.getStatus());
		 ptst.setString(16, studentzh.getApplyer());
		 ptst.setString(17, studentzh.getRudate());
		 ptst.setString(18, studentzh.getIdcard());
		 ptst.setString(19, studentzh.getZhuandate());
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
	public void updateStudentzh(TStudentzh studentzh) throws SQLException
	{
	  DBWork da = new DBWork();
	 try {
		 conn=da.getConnection();
	     PreparedStatement ptst=conn.prepareStatement ("update t_studentzh set typeid=?,typename=?,username=?,classname=?,nation=?,place=?,barthday=?,fenzhi=?,fadate=?,jiedate=?,jieuser=?,sixiang=?,sex=?,jueyi=?,status=?,applyer=?,rudate=?,idcard=?,zhuandate=? where id=?");
	     ptst.setString(1, studentzh.getTypeid());
		 ptst.setString(2, studentzh.getTypename());
		 ptst.setString(3, studentzh.getUsername());
		 ptst.setString(4, studentzh.getClassname());
		 ptst.setString(5, studentzh.getNation());
		 ptst.setString(6, studentzh.getPlace());
		 ptst.setString(7, studentzh.getBarthday());
		 ptst.setString(8, studentzh.getFenzhi());
		 ptst.setString(9, studentzh.getFadate());
		 ptst.setString(10, studentzh.getJiedate());
		 ptst.setString(11, studentzh.getJieuser());
		 ptst.setString(12, studentzh.getSixiang());
		 ptst.setString(13, studentzh.getSex());
		 ptst.setString(14, studentzh.getJueyi());
		 ptst.setString(15, studentzh.getStatus());
		 ptst.setString(16, studentzh.getApplyer());
		 ptst.setString(17, studentzh.getRudate());
		 ptst.setString(18, studentzh.getIdcard());
		 ptst.setString(19, studentzh.getZhuandate());
		 ptst.setInt(20, studentzh.getId());
		 ptst.execute();
		 ptst.close();
		 conn.close();  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void applyStudentzh(TStudentzh studentzh) throws SQLException
	{
	  DBWork da = new DBWork();
	 try {
		 conn=da.getConnection();
	     PreparedStatement ptst=conn.prepareStatement ("update t_studentzh set status=?,applyer=? where id=?");
		 ptst.setString(1, studentzh.getStatus());
		 ptst.setString(2, studentzh.getApplyer());
		 ptst.setInt(3, studentzh.getId());
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
	public void delStudentzh(String id) throws SQLException
	{
	  DBWork da = new DBWork();
	 try {
		 conn=da.getConnection();
	     PreparedStatement ptst=conn.prepareStatement ("delete from t_studentzh where id=?");
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
	public List<TStudentzh>  queryStudentzh(String studentzhName) throws SQLException
	{
		DBWork da = new DBWork();
		List<TStudentzh> list = new ArrayList<TStudentzh>();
		 try {
			 conn=da.getConnection();
			 Statement stmt=conn.createStatement();
			 String cond = "";
			 if(studentzhName!=null&&!"".equals(studentzhName)){
				 cond = " and typeid like '%"+studentzhName+"%'";
			 }
			 ResultSet rs=stmt.executeQuery("select * from t_studentzh  where 1 = 1 "+cond);
			 while(rs.next())
			 {
				 TStudentzh studentzh = new TStudentzh();
				 studentzh.setId(rs.getInt("id"));
				 studentzh.setTypeid(rs.getString("typeid"));
				 studentzh.setUsername(rs.getString("username"));
				 studentzh.setBarthday(rs.getString("barthday"));
				 studentzh.setClassname(rs.getString("classname"));
				 studentzh.setFenzhi(rs.getString("fenzhi"));
				 studentzh.setNation(rs.getString("nation"));
				 studentzh.setPlace(rs.getString("place"));
				 studentzh.setSixiang(rs.getString("sixiang"));
				 studentzh.setTypename(rs.getString("typename"));
				 studentzh.setSex(rs.getString("sex"));
				 studentzh.setApplyer(rs.getString("applyer"));
				 studentzh.setFadate(rs.getString("fadate"));
				 studentzh.setJiedate(rs.getString("jiedate"));
				 studentzh.setJieuser(rs.getString("jieuser"));
				 studentzh.setJueyi(rs.getString("jueyi"));
				 studentzh.setStatus(rs.getString("status"));
				 studentzh.setRudate(rs.getString("rudate"));
				 studentzh.setIdcard(rs.getString("idcard"));
				 list.add(studentzh);
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
	public  TStudentzh  getStudentzh(String id) throws SQLException
	{
		DBWork da = new DBWork();
		TStudentzh studentzh = new TStudentzh();
		 try {
			 conn=da.getConnection();
			 Statement stmt=conn.createStatement();
			 ResultSet rs=stmt.executeQuery("select * from t_studentzh u where u.id="+id);
			 if(rs.next())
			 {
				 studentzh.setId(rs.getInt("id"));
				 studentzh.setTypeid(rs.getString("typeid"));
				 studentzh.setUsername(rs.getString("username"));
				 studentzh.setBarthday(rs.getString("barthday"));
				 studentzh.setClassname(rs.getString("classname"));
				 studentzh.setFenzhi(rs.getString("fenzhi"));
				 studentzh.setNation(rs.getString("nation"));
				 studentzh.setPlace(rs.getString("place"));
				 studentzh.setSixiang(rs.getString("sixiang"));
				 studentzh.setTypename(rs.getString("typename"));
				 studentzh.setSex(rs.getString("sex"));
				 studentzh.setApplyer(rs.getString("applyer"));
				 studentzh.setFadate(rs.getString("fadate"));
				 studentzh.setJiedate(rs.getString("jiedate"));
				 studentzh.setJieuser(rs.getString("jieuser"));
				 studentzh.setJueyi(rs.getString("jueyi"));
				 studentzh.setStatus(rs.getString("status"));
				 studentzh.setRudate(rs.getString("rudate"));
				 studentzh.setIdcard(rs.getString("idcard"));
			 }
			 rs.close();
			 stmt.close();
			 conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return studentzh;
	}

	public void rollstudentzh(TStudentzh studentzh) {
		// TODO Auto-generated method stub
		DBWork da = new DBWork();
		try {
			 conn=da.getConnection();
		     PreparedStatement ptst=conn.prepareStatement ("update t_studentzh set newtid=?,newtname=?,rollstatus=? where id=?");
		     ptst.setString(1, studentzh.getNewtid());
			 ptst.setString(2, studentzh.getNewtname());
			 ptst.setInt(3, studentzh.getRollstatus());
			 ptst.setInt(4, studentzh.getId());
			 ptst.execute();
			 ptst.close();
			 conn.close();  
			} catch (Exception e) {
				e.printStackTrace();
		}
	}

	public void rollupdatestudentzh(TStudentzh studentzh, String flag) {
		// TODO Auto-generated method stub
		DBWork da = new DBWork();
		try {
			 conn=da.getConnection();
			 PreparedStatement ptst = null;
			 if("0".equals(flag)){
				 ptst = conn.prepareStatement ("update t_studentzh set typeid=newtid,typename=newtname,rollstatus=? where id=?");
				 ptst.setInt(1,0);
				 ptst.setInt(2, studentzh.getId());
				 ptst.execute();
			 } else {
				 ptst = conn.prepareStatement ("update t_studentzh set rollstatus=? where id=?");
				 ptst.setInt(1,0);
				 ptst.setInt(2, studentzh.getId());
				 ptst.execute();
			 }
			 ptst.close();
			 conn.close();  
			} catch (Exception e) {
				e.printStackTrace();
		}
	}
}
