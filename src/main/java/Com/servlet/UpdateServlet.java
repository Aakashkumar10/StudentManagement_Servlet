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

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);

		String name = req.getParameter("name");
		String dob = req.getParameter("dob");
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		
		int id = Integer.parseInt(req.getParameter("id"));

		Student student = new Student(id,name, dob, address, email);

		StudentDAO dao = new StudentDAO(DBconnect.getConn());

		HttpSession session = req.getSession();
		
//		dao.updateStudent(student);
		
		boolean f = dao.updateStudent(student);
		
if (f) {
			
			session.setAttribute("succMsg","Student Details update Sucessfully ...");
			

			resp.sendRedirect("index.jsp");
//			System.out.println("Student Details Submit sucessfully...");
		}

		else {
			
			session.setAttribute("errorMsg","Something wrong on server ...");
			resp.sendRedirect("index.jsp");
			
//			System.out.println("something wrong on server...");
		}
		
	}

}
