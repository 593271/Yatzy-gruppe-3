package no.hvl.dat109;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import YatzyRegler.Deltakere;
import YatzyRegler.Yatzy;
import YatzyRegler.YatzyStart;


@WebServlet("/simulereSpillServlet")
public class SimulereSpillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       
		Deltakere nr1= new Deltakere("Ola");
		Deltakere nr2= new Deltakere("Kari");
		
		Deltakere[] deltakere = {nr1, nr2};
		
		YatzyStart spill = new YatzyStart(deltakere.length);
		Yatzy regler = new Yatzy(deltakere);
		
		spill.start(spill, regler);
		
		request.setAttribute("runder", spill.getRunde());
		request.setAttribute("deltakere", deltakere);
		request.setAttribute("tabell", spill.getArr());

		request.getRequestDispatcher("WEB-INF/simulering.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
