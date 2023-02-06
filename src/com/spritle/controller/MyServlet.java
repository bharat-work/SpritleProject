package com.spritle.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.spritle.dao.*;
import com.spritle.model.*;


@WebServlet("/")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
				
		String path = request.getServletPath();
			
		switch(path) 
		{
			case "/master_login":
				validateMaster(request, response);
				break;
			case "/student_login":
				validateStudent(request, response);
				break;
			case "/master_register":
				registerMaster(request, response);
				break;
			case "/student_register":
				registerStudent(request, response);
				break;
			case "/task_creation":
				insertTask(request, response);
				break;
			case "/displayMasterTasks":
				int mid = Integer.parseInt(request.getParameter("masterId"));
				getTasksForMaster(request, response, mid);
				break;
			case "/tasksAssigned": 
				int sid = Integer.parseInt(request.getParameter("studentId"));
				getTasksForStudent(request, response, sid);
				break;	
			 default: 
				displayHomePage(request, response); 
				break;
		}
	}
	
	private void getTasksForStudent(HttpServletRequest request, HttpServletResponse response, int sid) 
	{
		ArrayList<DisplayTable> alTasks = null;
		try 
		{
			alTasks = StudentFunctionallity.getTasksAssigned(sid);
			request.setAttribute("tasks", alTasks);
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		try 
		{
			RequestDispatcher rd = request.getRequestDispatcher("student_tasks_page.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getTasksForMaster(HttpServletRequest request, HttpServletResponse response, int mid)
	{
		ArrayList<DisplayTable> alTasks = null;
		try {
			alTasks = MasterFunctionallity.getTaskCreated(mid);
			request.setAttribute("tasks", alTasks);
			
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		try 
		{
			RequestDispatcher rd = request.getRequestDispatcher("master_tasks_page.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void insertTask(HttpServletRequest request, HttpServletResponse response) 
	{
		int mid = Integer.parseInt(request.getParameter("masterId"));
		String fn = request.getParameter("fn");
		String sn = request.getParameter("sn");
		String op = request.getParameter("operation");
		String sName = request.getParameter("student_assigned");
		
		int sid;
		try 
		{
			sid = MasterFunctionallity.getStudentId(sName);
			
			Task t = new Task(mid, sid, fn, sn, op);
			
			MasterFunctionallity.insertCreatedTask(t);
			
			getTasksForMaster(request, response, mid);

		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void validateStudent(HttpServletRequest request, HttpServletResponse response) 
	{
		String e = request.getParameter("email");
		String p = request.getParameter("pass");
		
		Student student = new Student(e, p);

		try 
		{
			boolean b = StudentFunctionallity.validDateStudent(student);
			if(b) 
			{
				int res = StudentFunctionallity.getStudentId(e);
				request.setAttribute("id", res);
				RequestDispatcher rd = request.getRequestDispatcher("student_dashboard.jsp");
				try 
				{
					rd.forward(request, response);
				} 
				catch (ServletException e1){
					e1.printStackTrace();
				} 
				catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			else 
			{
				try 
				{
					response.getWriter().append("<h1 style=\"color:red\"> Oops go back! <br> data is not valid </h1>");
				} 
				catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		} 
		catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
	}


	private void validateMaster(HttpServletRequest request, HttpServletResponse response) 
	{
		String e = request.getParameter("email");
		String p = request.getParameter("pass");
		
		Master master = new Master(e, p);
		
		try 
		{
			boolean b = MasterFunctionallity.validDateMaster(master);
			
			if(b) 
			{	
				try 
				{
					int masterId = MasterFunctionallity.getMasterId(e);
					request.setAttribute("id", masterId);
					
					ArrayList<String> names = MasterFunctionallity.getAllStudentsName();
					request.setAttribute("values", names);
					
					RequestDispatcher rd = request.getRequestDispatcher("master_dashboard.jsp");
					rd.forward(request, response);
				} 
				catch (ServletException e1){
					e1.printStackTrace();
				} 
				catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			else 
			{
				try 
				{
					response.getWriter().append("<h1 style=\"color:red\"> Oops go back! <br> data is not valid </h1>");
				} 
				catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		} 
		catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
	}


	private void registerStudent(HttpServletRequest request, HttpServletResponse response) 
	{
		String n = request.getParameter("name");
		String e = request.getParameter("email");
		long m = Long.parseLong(request.getParameter("mobile"));
		String p = request.getParameter("pass");
		
		Student student = new Student(n, e, m, p);
		
		try 
		{
			StudentFunctionallity.insertStudent(student);
			
			RequestDispatcher rd = request.getRequestDispatcher("student_login_page.jsp");
			try 
			{
				rd.forward(request, response);
			} 
			catch (ServletException e1)
			{
				e1.printStackTrace();
			} 
			catch (IOException e1) {
				e1.printStackTrace();
			}
		} 
		catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}


	private void registerMaster(HttpServletRequest request, HttpServletResponse response) 
	{
		String n = request.getParameter("name");
		String e = request.getParameter("email");
		long m = Long.parseLong(request.getParameter("mobile"));
		String p = request.getParameter("pass");
		
		Master master = new Master(n, e, m, p);
		
		try 
		{
			MasterFunctionallity.insertMaster(master);
			
			RequestDispatcher rd = request.getRequestDispatcher("master_login_page.jsp");
			try 
			{
				rd.forward(request, response);
			} 
			catch (ServletException e1)
			{
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} 
		catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	  private void displayHomePage(HttpServletRequest request, HttpServletResponse response) 
	  { 
		  try 
		  { 
			  response.sendRedirect("index.html"); 
			  } 
		  catch (IOException e)
		  { 
			  e.printStackTrace(); 
			  } 
	  }
	 

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}

