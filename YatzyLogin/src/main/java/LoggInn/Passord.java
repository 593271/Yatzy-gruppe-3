package LoggInn;

import javax.persistence.Embeddable;

@Embeddable
public class Passord {

    private String passord_hash;
    private String passord_salt;

    private Passord(String hash, String salt) {
    	this.passord_hash = hash;
    	this.passord_salt = salt;
    }

    public Passord() {}

    @Override
    public String toString() {
        return passord_hash + "" + passord_salt;
    }

    public static Passord lagPassord(String passordKlartekst) {
        String salt = PassordUtil.genererTilfeldigSalt();
        String hash = PassordUtil.hashMedSalt(passordKlartekst, salt);
        return new Passord(hash, salt);
    }

	public String getPassord_hash() {
		return passord_hash;
	}

	public void setPassord_hash(String passord_hash) {
		this.passord_hash = passord_hash;
	}

	public String getPassord_salt() {
		return passord_salt;
	}

	public void setPassord_salt(String passord_salt) {
		this.passord_salt = passord_salt;
	}
    
    
}