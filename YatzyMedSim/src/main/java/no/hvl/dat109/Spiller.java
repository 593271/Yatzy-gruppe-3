package no.hvl.dat109;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="dat109oblig3")
public class Spiller {
	
	@Id
	private String epost;
	private String navn;
	private String brukernavn;
	
	@Embedded
	private Passord passord;
	
	public Spiller() {}
	
	public Spiller(String navn, String brukernavn, String epost, Passord passord) {
		this.navn = navn;
		this.brukernavn = brukernavn;
		this.epost = epost;
		this.passord = passord;
	}
	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}
	public String getBrukernavn() {
		return brukernavn;
	}
	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}
	public String getEpost() {
		return epost;
	}
	public void setEpost(String epost) {
		this.epost = epost;
	}
	public Passord getPassord() {
		return passord;
	}
	public void setPassord(Passord passord) {
		this.passord = passord;
	}
}
