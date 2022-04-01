package YatzyRegler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Yatzy {

	int runde;
	Terning[] terninger = new Terning[5];
	int kast;
	Deltakere[] deltakere;

	public int getKast() {
		return kast;
	}

	public void setKast(int kast) {
		this.kast = kast;
	}

	public Deltakere[] getDeltakere() {
		return deltakere;
	}

	public void setDeltakere(Deltakere[] deltakere) {
		this.deltakere = deltakere;
	}

	public Yatzy(Deltakere[] deltakere) {
		if (antallDeltakere(deltakere).length < 2 || antallDeltakere(deltakere).length > 6) {
			System.out.println("Ugyldig antall spillere");
		} else {
			this.runde = 0;
			for (int i = 0; i < 5; i++) {
				terninger[i] = new Terning(1);
			}
			this.deltakere = antallDeltakere(deltakere);
			this.kast = 0;
		}

	}

	public int getRunde() {
		return runde;
	}

	public void setRunde(int runde) {
		this.runde = runde;
	}

	public Terning[] getTerninger() {
		return terninger;
	}

	public void setTerninger(Terning[] terninger) {
		this.terninger = terninger;
	}
	
	public int sjekkePoeng(int tall) {
		int prikker = 0;

			for (int i = 0; i < getTerninger().length; i++) {
				if (getTerninger()[i].getVerdi() == tall) {
					prikker++;
				}

			}

		
		return prikker * tall;
	}

	public void sjekkBonus() {
		for (int i = 0; i < deltakere.length; i++) {
			if (deltakere[i].getPoeng() >= 63) {
				deltakere[i].setPoeng(deltakere[i].getPoeng() + 50);
			}
		}
	}

	public void kastTerninger() {
		for (int i = 0; i < terninger.length; i++) {
			if (!terninger[i].isBeholder()) {
				terninger[i].roll();
			}
		}
		setKast(getKast()+1);
	}

	/**
	 * Array av terninger som spilleren kan kaste
	 */
	public Terning[] terningerBeholdt() {

		List<Terning> alle = Arrays.asList(terninger);
		List<Terning> kast = alle.stream().filter(terning -> terning.isBeholder()).collect(Collectors.toList());
		Terning[] kastArray = kast.toArray(new Terning[0]);
		return kastArray;
	}
	
	public int par(int antallPar) {
		
		int toPar=0;
		int antall = 0;
		List<Terning> alle = Arrays.asList(getTerninger());
		
		Long par1 = alle.stream().filter(k -> k.getVerdi() == 1).count();
		Long par2 = alle.stream().filter(k -> k.getVerdi() == 2).count();
		Long par3 = alle.stream().filter(k -> k.getVerdi() == 3).count();
		Long par4 = alle.stream().filter(k -> k.getVerdi() == 4).count();
		Long par5 = alle.stream().filter(k -> k.getVerdi() == 5).count();
		Long par6 = alle.stream().filter(k -> k.getVerdi() == 6).count();
		
		
		if(antallPar ==2) {

	        if (par6 >= 2) {
	            antall += 6 * 2;
	            toPar++;
	        }
	        if (par5 >= 2) {
	            antall += 5 * 2;
	            toPar++;
	        }
	        if (par4 >= 2) {
	            antall += 4 * 2;
	            toPar++;
	        }
	        if (par3 >= 2) {
	            antall += 3 * 2;
	            toPar++;
	        }
	        if (par2 >= 2) {
	            antall += 2 * 2;
	            toPar++;
	        }
	        if (par1 >= 2) {
	            antall += 1 * 2;
	            toPar++;
	        }

	        if (toPar == 2) {
	            return antall;
	        } else {
	            antall = 0;
	        }
			
		} else if(antallPar ==1) {
			
			if(par6 >= 2) {
				antall = 12;
			} else if(par5 >=2) {
				antall = 10;
			}else if(par4 >=2) {
				antall = 8;
			}else if(par3 >=2) {
				antall = 6;
			}else if(par2 >=2) {
				antall = 4;
			}else if(par1 >=2) {
				antall = 2;
			} else {
				antall = 0;
			}
		}
		
		
		return antall;
		
	}

	public int ofaKind(int antall) {
		int poeng = 0;
		for (int i = 1; i < 7; i++) {
			if (teller(i) / i == antall) {
				poeng = teller(i);

			}

		}

		return poeng;
	}

	public int StraightSmall() {
		int poeng = 0;
		List<Terning> alle = Arrays.asList(getTerninger());
		List<Integer> kast = alle.stream().map(terninger -> terninger.getVerdi()).collect(Collectors.toList());
		if (kast.contains(1) && kast.contains(2) && kast.contains(3) && kast.contains(4) && kast.contains(5)) {
			poeng = 15;
		}

		return poeng;
	}

	public int StraightBig() {

		int poeng = 0;
		List<Terning> alle = Arrays.asList(getTerninger());
		List<Integer> kast = alle.stream().map(terninger -> terninger.getVerdi()).collect(Collectors.toList());
		if (kast.contains(2) && kast.contains(3) && kast.contains(4) && kast.contains(5) && kast.contains(6)) {
			poeng = 20;
		}

		return poeng;

	}

	public int Sjanse() {
		int score = 0;
		for (int i = 0; i < terninger.length; i++) {

			score += getTerninger()[i].getVerdi();

		}

		return score;

	}
	
	public int fullHouse() {

        int prikkerTre = 0;
        int prikkerTo = 0;
        int poeng = 0;
        boolean tre = false;
        boolean to = false;

        for(int i = 1; i < 7; i++) {
            if(teller(i)/i == 3) {
                tre = true;
                prikkerTre = i;
                break;
            }
        }

        for(int i = 1; i < 7; i++) {
            if(teller(i)/i == 2) {
                to = true;
                prikkerTo = i;
               break;
            }
        }

        if (to && tre) {
            poeng = teller(prikkerTre) + teller(prikkerTo);
        } 
        return poeng;
    }

	public int Yatzee() {
		int score = 0;

		if (getTerninger()[0].getVerdi() == getTerninger()[1].getVerdi()
				&& getTerninger()[2].getVerdi() == getTerninger()[3].getVerdi()
				&& getTerninger()[4].getVerdi() == getTerninger()[3].getVerdi()) {
			score = 50;

		}

		return score;

	}

	/**
	 * Array av alle terninger som spilleren ikke beholder
	 */
	public Terning[] terningerKast() {

		List<Terning> alle = Arrays.asList(terninger);
		List<Terning> kast = alle.stream().filter(terning -> !terning.isBeholder()).collect(Collectors.toList());
		Terning[] kastArray = kast.toArray(new Terning[0]);
		return kastArray;
	}

	public Deltakere[] antallDeltakere(Deltakere[] deltakere) {

		List<Deltakere> alle = Arrays.asList(deltakere);
		List<Deltakere> kast = alle.stream().collect(Collectors.toList());
		Deltakere[] kastArray = kast.toArray(new Deltakere[0]);
		return kastArray;
	}

	public int teller(int prikker) {
		List<Terning> alle = Arrays.asList(getTerninger());
		int antall = (int) alle.stream().filter(terning -> terning.getVerdi() == prikker).count();
		return antall * prikker;

	}

}
