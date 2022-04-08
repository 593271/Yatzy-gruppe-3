package YatzyRegler;

public class Terning {
	
	int verdi;
	boolean beholder;
	
    public Terning(int verdi) {
		this.verdi = verdi;
		this.beholder = false;
	}

	public int roll(){
        verdi = (int)(Math.random() * 6 + 1);
        return verdi;
    }

    public int getVerdi(){
        return verdi;   
    }

    public void setVerdi(int verdi) {
		this.verdi = verdi;
	}

	public boolean isBeholder() {
		return beholder;
	}

	public void setBeholder(boolean beholder) {
		this.beholder = beholder;
	}

	public String toString(){
        return Integer.toString(verdi);
    }
	
	

}
