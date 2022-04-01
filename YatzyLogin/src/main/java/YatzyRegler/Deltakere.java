package YatzyRegler;

public class Deltakere {
	
	int poeng;
	String navn;
	
	public Deltakere(String navn) {
		this.navn = navn;
		this.poeng = 0;
	}
	
	public int getPoeng() {
		return poeng;
	}
	
	public void setPoeng(int poeng) {
		this.poeng = poeng;
	}
	
	public String getNavn() {
		return navn;
	}
	
	public void setNavn(String navn) {
		this.navn = navn;
	}
	
}
