package com.spritle.dao;

import java.sql.*;
import java.util.ArrayList;

import com.spritle.model.*;

public class MasterFunctionallity {
	private static final String url = "jdbc:mysql://localhost:3306/spritle";
	private static final String username = "root";
	private static final String password = "admin";
	
	private static final String insertQry = "insert into master_table(name, email, mobile, password) values(?,?,?,?)";
	private static final String validateQry = "select email, password from master_table";
	private static final String selectStudentsQry = "select name from student_table";
	private static final String getMasterIdQry = "select m_id from master_table where email = ?";
	private static final String getStudentIdQry = "select s_id from student_table where email = (select email from student_table where name = ?)";
	private static final String insertTaskQry = "insert into task_description(m_id, s_id, left_operand, right_operand, operator, task_desc) values(?,?,?,?,?,?)";
	private static final String getAllTasksQry = "select s.name as 'student_name', t.left_operand, t.right_operand, t.operator, t.task_desc from task_description t join student_table s on t.s_id = s.s_id where m_id = ?";
	
	private static Connection con = null;
	private static Statement s = null;
	private static PreparedStatement ps = null;
	
	public static void insertMaster(Master master) throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con = DriverManager.getConnection(url, username, password);
		
		ps = con.prepareStatement(insertQry);
		ps.setString(1, master.getName());
		ps.setString(2, master.getEmail());
		ps.setLong(3, master.getMobile());
		ps.setString(4, master.getPassword());
		
		ps.executeUpdate();
		
		if(ps != null) { ps.close(); }

		if(con != null) { con.close(); }
	}

	public static boolean validDateMaster(Master master) throws ClassNotFoundException, SQLException {
		
		boolean b = false;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con = DriverManager.getConnection(url, username, password);
		
		ps = con.prepareStatement(validateQry);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) 
		{
			if( rs.getString("email").equals( master.getEmail() ) && rs.getString("password").equals( master.getPassword() ) ) 
			{
				b = true;
			}
		}
		
		if(ps != null) { ps.close(); }

		if(con != null) { con.close(); }
		
		return b;
	}
	
	public static ArrayList<String> getAllStudentsName() throws ClassNotFoundException, SQLException {
		
		ArrayList<String> alStuds = new ArrayList<String>();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con = DriverManager.getConnection(url, username, password);
		
		ps = con.prepareStatement(selectStudentsQry);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) 
		{
			String data = rs.getString("name");
			alStuds.add(data);
		}
		
		if(ps != null) { ps.close(); }

		if(con != null) { con.close(); }
		
		return alStuds;
	}
	
	public static int getMasterId(String email) throws ClassNotFoundException, SQLException {
		
		int res = 0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con = DriverManager.getConnection(url, username, password);
		
		ps = con.prepareStatement(getMasterIdQry);
		ps.setString(1, email);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) 
		{
			res = rs.getInt("m_id");
		}
		
		if(ps != null) { ps.close(); }

		if(con != null) { con.close(); }
		
		return res;
		
	}
	
	public static int getStudentId(String name) throws ClassNotFoundException, SQLException 
	{
		int res = 0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con = DriverManager.getConnection(url, username, password);
		
		ps = con.prepareStatement(getStudentIdQry);
		ps.setString(1, name);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) 
		{
			res = rs.getInt("s_id");
		}
		
		if(ps != null) { ps.close(); }

		if(con != null) { con.close(); }
		
		return res;
	}
	
	public static void insertCreatedTask(Task t) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con = DriverManager.getConnection(url, username, password);
		
		ps = con.prepareStatement(insertTaskQry);
		ps.setInt(1, t.getMid());
		ps.setInt(2, t.getSid());
		ps.setString(3, t.getFn());
		ps.setString(4, t.getSn());
		ps.setString(5, t.getOpreation());
		ps.setString(6, t.getFn() + " " + t.getOpreation() + " " + t.getSn());
		
		ps.executeUpdate();
		
		if(ps != null) { ps.close(); }

		if(con != null) { con.close(); }
	}
	
	public static ArrayList<DisplayTable> getTaskCreated(int masterId) throws ClassNotFoundException, SQLException
	{
		ArrayList<DisplayTable> al = new ArrayList<DisplayTable>();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con = DriverManager.getConnection(url, username, password);
		
		ps = con.prepareStatement(getAllTasksQry);
		ps.setInt(1, masterId);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) 
		{
			String s = rs.getString("student_name");
			String l = rs.getString("left_operand");
			String o = rs.getString("operator");
			String r = rs.getString("right_operand");
			
			DisplayTable dt = new DisplayTable(s, l, o, r);
			
			al.add(dt);
			
		}
		
		if(ps != null) { ps.close(); }

		if(con != null) { con.close(); }
		
		return al;
	}
}