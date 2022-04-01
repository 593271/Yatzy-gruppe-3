package LoggInn;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MenyServlet")
public class MenyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession sesjon = request.getSession(false);

		if (sesjon == null || sesjon.getAttribute("spiller") == null) {
			response.sendRedirect("logginnServlet?kreverPaalogging");
		} else {
			request.getRequestDispatcher("WEB-INF/meny.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String button_param = request.getParameter("button");
		RequestDispatcher rd = null;

		if(button_param.equals("Nytt spill")) {
			rd=request.getRequestDispatcher("nyttSpillServlet");
		}
		else if(button_param.equals("Eksisterende spill")) {
			rd=request.getRequestDispatcher("eksisterendeSpillServlet");
		}
		else if(button_param.equals("Logg ut")){
			rd=request.getRequestDispatcher("loggUtServlet");
		};

		rd.forward(request, response);

	}

}
