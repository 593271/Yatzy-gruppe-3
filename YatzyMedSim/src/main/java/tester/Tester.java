package tester;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import YatzyRegler.Terning;
import YatzyRegler.Yatzy;
import YatzyRegler.Deltakere;

class Tester {

	Deltakere[] deltakere = { new Deltakere("Tommy"), new Deltakere("Pham"), new Deltakere("Willy") };
	Yatzy yatzy = new Yatzy(deltakere);

	@Test
	public void sjekkTerninger() {

		assertEquals(5, yatzy.terningerKast().length);

		yatzy.getTerninger()[2].setBeholder(true);
		assertEquals(1, yatzy.terningerBeholdt().length);

		yatzy.getTerninger()[4].setBeholder(true);
		assertEquals(2, yatzy.terningerBeholdt().length);

		assertEquals(3, yatzy.terningerKast().length);
	}

	@Test
	public void sjekkPoeng() {

		yatzy.setKast(3);

		yatzy.kastTerninger();

		for (int i = 1; i < 7; i++) {
			assertEquals(yatzy.teller(i), yatzy.sjekkePoeng(i));
		}

		yatzy.getTerninger()[1].setBeholder(true);

		for (int i = 1; i < 7; i++) {
			assertEquals(yatzy.teller(i), yatzy.sjekkePoeng(i));
		}

	}
	
	@Test
	public void sjekkPar1() {
		for (int i = 1; i < 7; i++) {
			yatzy.getTerninger()[0].setVerdi(i);
			yatzy.getTerninger()[1].setVerdi(i);
			yatzy.getTerninger()[2].setVerdi(0);
			yatzy.getTerninger()[3].setVerdi(0);
			yatzy.getTerninger()[4].setVerdi(0);
			assertEquals(i * 2, yatzy.par(1));
		}
		yatzy.getTerninger()[0].setVerdi(5);
		yatzy.getTerninger()[1].setVerdi(5);
		yatzy.getTerninger()[2].setVerdi(1);
		yatzy.getTerninger()[3].setVerdi(1);
		yatzy.getTerninger()[4].setVerdi(0);
		assertEquals(5 * 2, yatzy.par(1));
		
		yatzy.getTerninger()[0].setVerdi(5);
		yatzy.getTerninger()[1].setVerdi(5);
		yatzy.getTerninger()[2].setVerdi(5);
		yatzy.getTerninger()[3].setVerdi(5);
		yatzy.getTerninger()[4].setVerdi(0);
		assertEquals(5 * 2, yatzy.par(1));
		
	}
	
	@Test
	public void sjekkPar2() {
		
		yatzy.getTerninger()[0].setVerdi(1);
		yatzy.getTerninger()[1].setVerdi(1);
		yatzy.getTerninger()[2].setVerdi(2);
		yatzy.getTerninger()[3].setVerdi(2);
		yatzy.getTerninger()[4].setVerdi(0);
		assertEquals(6, yatzy.par(2));
		
		yatzy.getTerninger()[0].setVerdi(1);
		yatzy.getTerninger()[1].setVerdi(1);
		yatzy.getTerninger()[2].setVerdi(1);
		yatzy.getTerninger()[3].setVerdi(1);
		yatzy.getTerninger()[4].setVerdi(0);
		assertEquals(0, yatzy.par(2));

		
	}

	@Test
	public void sjekkOfAKind() {
		for (int i = 1; i < 7; i++) {
			yatzy.getTerninger()[0].setVerdi(i);
			yatzy.getTerninger()[1].setVerdi(i);
			yatzy.getTerninger()[2].setVerdi(i);
			yatzy.getTerninger()[3].setVerdi(0);
			yatzy.getTerninger()[4].setVerdi(0);
			assertEquals(i * 3, yatzy.ofaKind(3));
		}

		for (int i = 1; i < 7; i++) {
			yatzy.getTerninger()[0].setVerdi(i);
			yatzy.getTerninger()[1].setVerdi(i);
			yatzy.getTerninger()[2].setVerdi(i);
			yatzy.getTerninger()[3].setVerdi(i);
			yatzy.getTerninger()[4].setVerdi(0);
			assertEquals(i * 4, yatzy.ofaKind(4));
		}

	}

	@Test
	public void sjekkStraight() {

		yatzy.getTerninger()[0].setVerdi(1);
		yatzy.getTerninger()[1].setVerdi(2);
		yatzy.getTerninger()[2].setVerdi(3);
		yatzy.getTerninger()[3].setVerdi(4);
		yatzy.getTerninger()[4].setVerdi(5);

		assertEquals(15, yatzy.StraightSmall());

		yatzy.getTerninger()[0].setVerdi(2);
		yatzy.getTerninger()[1].setVerdi(3);
		yatzy.getTerninger()[2].setVerdi(4);
		yatzy.getTerninger()[3].setVerdi(5);
		yatzy.getTerninger()[4].setVerdi(6);

		assertEquals(20, yatzy.StraightBig());

	}

	@Test
	public void sjekkSjanse() {

		yatzy.getTerninger()[0].setVerdi(1);
		yatzy.getTerninger()[1].setVerdi(2);
		yatzy.getTerninger()[2].setVerdi(3);
		yatzy.getTerninger()[3].setVerdi(4);
		yatzy.getTerninger()[4].setVerdi(5);

		assertEquals(15, yatzy.Sjanse());

	}

	@Test
	public void fullHouse() {

		yatzy.getTerninger()[0].setVerdi(1);
		yatzy.getTerninger()[1].setVerdi(1);
		yatzy.getTerninger()[2].setVerdi(1);
		yatzy.getTerninger()[3].setVerdi(2);
		yatzy.getTerninger()[4].setVerdi(2);

		assertEquals(7, yatzy.fullHouse());

		yatzy.getTerninger()[0].setVerdi(2);
		yatzy.getTerninger()[1].setVerdi(2);
		yatzy.getTerninger()[2].setVerdi(2);
		yatzy.getTerninger()[3].setVerdi(1);
		yatzy.getTerninger()[4].setVerdi(1);

		assertEquals(8, yatzy.fullHouse());

		yatzy.getTerninger()[0].setVerdi(6);
		yatzy.getTerninger()[1].setVerdi(6);
		yatzy.getTerninger()[2].setVerdi(6);
		yatzy.getTerninger()[3].setVerdi(5);
		yatzy.getTerninger()[4].setVerdi(5);

		assertEquals(28, yatzy.fullHouse());
	}

	@Test
	public void sjekkYatzy() {

		yatzy.getTerninger()[0].setVerdi(5);
		yatzy.getTerninger()[1].setVerdi(5);
		yatzy.getTerninger()[2].setVerdi(5);
		yatzy.getTerninger()[3].setVerdi(5);
		yatzy.getTerninger()[4].setVerdi(5);

		assertEquals(50, yatzy.Yatzee());

	}

}
