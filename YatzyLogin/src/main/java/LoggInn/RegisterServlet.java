package LoggInn;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/registerservlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Må ligge her for å få DAO til å fungere
	@EJB
	private SpillerDAO SpillerDAO;

	// Do get for Ã¥ laste inn pÃ¥meldingsskjema.jsp
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String error = " ";

		if (request.getParameter("epostError") != null) {
			error = "Epost er allerede i bruk";
		}else if(request.getParameter("brukernavnError") != null){
			error = "Brukernavn er allerede i bruk";
		}

		request.setAttribute("error", error);
	
		request.getRequestDispatcher("jsp/register.jsp")
				.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		// Input parameterne fra html/jsp side
		String navn = request.getParameter("navn");
		String brukernavn = request.getParameter("brukernavn");
		String epost = request.getParameter("epost").toLowerCase();
		String passord = request.getParameter("passord");
		String passordRepetert = request.getParameter("passordRepetert");
		
		// Hasher passord
		Passord p = Passord.lagPassord(passord);
		
		if (SpillerDAO.eksistererEpost(epost)) {
			response.sendRedirect("registerservlet?epostError");
		} else if(SpillerDAO.eksistererBrukernavn(brukernavn)){
			response.sendRedirect("registerservlet?brukernavnError");
		}
		else {
			HttpSession sesjon = request.getSession(false);
			if (sesjon != null) {
				sesjon.invalidate();
			}
			
			sesjon = request.getSession(true);
			sesjon.setMaxInactiveInterval(1000);
			
			// Legger til deltagere til database vi DAO
			Spiller spiller = new Spiller(navn, brukernavn, epost, p);
			SpillerDAO.lagreNySpiller(spiller);
			sesjon.setAttribute("spiller", spiller);
			
			response.sendRedirect("yatzeservlet");
		}
	}
}