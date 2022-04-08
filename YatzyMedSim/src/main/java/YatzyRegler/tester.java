package YatzyRegler;

public class tester {

	public static void main(String[] args) {
		
		Deltakere nr1= new Deltakere("a");
		Deltakere nr2= new Deltakere("b");
		
		Deltakere[] deltakere = {nr1, nr2};
		
		YatzyStart spill = new YatzyStart(deltakere.length);
		Yatzy regler = new Yatzy(deltakere);
		
		spill.start(spill, regler);
		
		spill.print2D(spill.getArr(), regler);
		
		
		
	}

}
