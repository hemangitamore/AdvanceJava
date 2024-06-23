package com.studentCrud.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.studentCrud.model.Student;
import com.studentCrud.serviceImpl.StudentServiceImpl;

/**
 * Servlet implementation class StudentController
 */
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentServiceImpl studentServiceImpl;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	public void init() {
		studentServiceImpl=new StudentServiceImpl ();
		
	}
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Student>students=studentServiceImpl.getAll();
			RequestDispatcher rd=request.getRequestDispatcher("student-list.jsp");
			request.setAttribute("studentList", students);
			rd.forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id=Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			float marks=Integer.parseInt(request.getParameter("marks"));
			Student student=new Student(id,name,marks);
		int result=	studentServiceImpl.save(student);
		RequestDispatcher rd=request.getRequestDispatcher("addStudent.jsp");
		
			if(result>0) {
				request.setAttribute("msg", "Student sucessflly added");
			}else {
				request.setAttribute("errormsg", "Problem in adding");
			}
			rd.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
