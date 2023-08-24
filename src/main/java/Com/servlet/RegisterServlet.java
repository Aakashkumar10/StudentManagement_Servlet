package Com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Com.connection.DBconnect;
import Com.dao.StudentDAO;
import Com.entity.Student;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);

		String name = req.getParameter("name");
		String dob = req.getParameter("dob");
		String address = req.getParameter("address");
		String email = req.getParameter("email");

		Student student = new Student(name, dob, address ,email);
		
	
		
		StudentDAO dao = new StudentDAO(DBconnect.getConn());
		
		HttpSession session = req.getSession();
		
		boolean f = dao.addStudent(student);

		if (f) {
			
			session.setAttribute("succMsg","Student Details submit Sucessfully ...");
			

			resp.sendRedirect("add_student.jsp");
//			System.out.println("Student Details Submit sucessfully...");
		}

		else {
			
			session.setAttribute("errorMsg","Something wrong on server ...");
			resp.sendRedirect("add_student.jsp");
			
//			System.out.println("something wrong on server...");
		}

	}

}
