package com.spritle.dao;

import java.sql.*;
import java.util.ArrayList;

import com.spritle.model.*;

public class StudentFunctionallity 
{
	private static final String url = "jdbc:mysql://localhost:3306/spritle";
	private static final String username = "root";
	private static final String password = "admin";
	
	private static final String insertQry = "insert into student_table(name, email, mobile, password) values(?,?,?,?)";
	private static final String validateQry = "select email, password from student_table";
	private static final String getStudentIdQry = "select s_id from student_table where email = ?";
	
	private static final String getAssignedTaskPerStudent = "select m.name as 'master_name', t.left_operand, t.right_operand, t.operator, t.task_desc from task_description t join master_table m on t.m_id = m.m_id where s_id = ?";
	
	private static Connection con = null;
	private static Statement s = null;
	private static PreparedStatement ps = null;
	
	public static void insertStudent(Student student) throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con = DriverManager.getConnection(url, username, password);
		
		ps = con.prepareStatement(insertQry);
		ps.setString(1, student.getName());
		ps.setString(2, student.getEmail());
		ps.setLong(3, student.getMobile());
		ps.setString(4, student.getPassword());
		
		ps.executeUpdate();
		
		if(ps != null) { ps.close(); }

		if(con != null) { con.close(); }
	}
	
	public static boolean validDateStudent(Student student) throws ClassNotFoundException, SQLException {
		
		boolean b = false;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con = DriverManager.getConnection(url, username, password);
		
		ps = con.prepareStatement(validateQry);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) 
		{
			if( rs.getString("email").equals( student.getEmail() ) && rs.getString("password").equals( student.getPassword() ) ) 
			{
				b = true;
			}
		}
		
		if(ps != null) { ps.close(); }

		if(con != null) { con.close(); }
		
		return b;
	}
	
	// New 2
	public static int getStudentId(String email) throws ClassNotFoundException, SQLException {
		
		int res = 0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con = DriverManager.getConnection(url, username, password);
		
		ps = con.prepareStatement(getStudentIdQry);
		ps.setString(1, email);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) 
		{
			res = rs.getInt("s_id");
		}
		
		if(ps != null) { ps.close(); }

		if(con != null) { con.close(); }
		
		return res;
		
	}
	
	
	public static ArrayList<DisplayTable> getTasksAssigned(int studentId) throws ClassNotFoundException, SQLException
	{
		ArrayList<DisplayTable> al = new ArrayList<DisplayTable>();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con = DriverManager.getConnection(url, username, password);
		
		ps = con.prepareStatement(getAssignedTaskPerStudent);
		ps.setInt(1, studentId);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) 
		{
			String ms = rs.getString("master_name");
			String l = rs.getString("left_operand");
			String o = rs.getString("operator");
			String r = rs.getString("right_operand");
			
			DisplayTable dt = new DisplayTable(ms, l, o, r);
			
			al.add(dt);
		}
		
		if(ps != null) { ps.close(); }

		if(con != null) { con.close(); }
		
		return al;
	}
}
