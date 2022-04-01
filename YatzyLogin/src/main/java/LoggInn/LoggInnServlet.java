package LoggInn;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logginnServlet")
public class LoggInnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private SpillerDAO SpillerDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String loginMessage = "";

		if (request.getParameter("kreverPaalogging") != null) {
			loginMessage = "Foresporselen din krever paalogging. " 
					+ "(Du kan ha blitt logget ut automatisk)";

		} else if (request.getParameter("feil") != null) {
			loginMessage = "Ugyldig epost og/eller passord"; 
		}

		request.setAttribute("loginMessage", loginMessage);

		request.getRequestDispatcher("jsp/loggInn.jsp")
		.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		// Ma hente parametere fra database
		String epost = request.getParameter("epost");
		String passord = request.getParameter("passord");


		Spiller spiller = SpillerDAO.finnEpost(epost);
		if (spiller != null) {

			String salt = spiller.getPassord().getPassord_salt();
			String hash = spiller.getPassord().getPassord_hash();

			if(spiller.getEpost().equals(epost) && PassordUtil.validerMedSalt(passord, salt, hash)) {
				HttpSession sesjon = request.getSession(false);
				if (sesjon != null) {
					sesjon.invalidate();
				}
				sesjon = request.getSession(true);
				sesjon.setMaxInactiveInterval(1000);

				sesjon.setAttribute("spiller", spiller);

				response.sendRedirect("yatzeservlet"); 
			}
			else{
				response.sendRedirect("logginnServlet?feil");
			}

		} else {
			response.sendRedirect("logginnServlet?feil");
		}


	}
}
