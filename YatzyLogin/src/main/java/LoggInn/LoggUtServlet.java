package LoggInn;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loggUtServlet")
public class LoggUtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession sesjon = request.getSession(false);

		if (sesjon == null || sesjon.getAttribute("spiller") == null) {
			response.sendRedirect("logginnServlet?kreverPaalogging");
		} else {
			sesjon.invalidate();
			request.getRequestDispatcher("WEB-INF/loggUt.jsp").forward(request, response);
		}
	}
}
