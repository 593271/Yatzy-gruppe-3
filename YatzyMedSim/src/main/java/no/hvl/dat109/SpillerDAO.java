package no.hvl.dat109;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class SpillerDAO {

	@PersistenceContext(name="spillerDB")
	private EntityManager em;

	public List<Spiller> hentAlleDeltagere() {

		return em.createQuery("select d from Spiller d", Spiller.class).getResultList();
	}

	public Spiller finnEpost(String epost) {
		return em.find(Spiller.class, epost);
	} 

	public boolean eksistererEpost(String epost) {
		return finnEpost(epost) != null;
	}

	// Bedre metode for insetting
	public void lagreNySpiller(Spiller spiller) {
		em.persist(spiller);
	}

	public boolean eksistererBrukernavn(String brukernavn) {
		List<Spiller> spillere = hentAlleDeltagere();
		for(Spiller s : spillere) {
			if(s.getBrukernavn().equals(brukernavn)) {
				return true;
			}
		}
		return false;
	}
}
