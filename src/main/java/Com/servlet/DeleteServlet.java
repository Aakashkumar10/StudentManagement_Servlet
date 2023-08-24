package Com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Com.connection.DBconnect;
import Com.dao.StudentDAO;
import Com.entity.Student;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.ServletException;.http.HttpServlet;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		StudentDAO dao = new StudentDAO(DBconnect.getConn());
		boolean f = dao.deleteStudent(id);

		HttpSession session = req.getSession();

		if (f) {

			session.setAttribute("succMsg", "Student Details Delete  Sucessfully ...");

			resp.sendRedirect("index.jsp");
//			System.out.println("Student Details Submit sucessfully...");
		}

		else {

			session.setAttribute("errorMsg", "Something wrong on server ...");
			resp.sendRedirect("index.jsp");

//			System.out.println("something wrong on server...");
		}

	}

}
