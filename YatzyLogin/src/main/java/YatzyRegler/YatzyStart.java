package YatzyRegler;

import java.util.Iterator;

public class YatzyStart {
	
	int [][] arr;
	String[] runde= {"Enere", "Toere", "Treere", "Firere", "Femmere",  "Seksere", "Sum", "Bonus", "Ett par", 
					 "To par", "Tre Like", "Fire Like", "Liten Straight", "Stor Straight", "Hus", "Sjanse", "Yatzy", "Totalt"};
	
	public YatzyStart(int lengde) {
		
		arr = new int[18][lengde];
	}

	protected int[][] getArr() {
		return arr;
	}

	protected void setArr(int[][] arr) {
		this.arr = arr;
	}
	
	public void print2D(int mat[][], Yatzy regler) {
        // Loop through all rows
		System.out.format("%-17s", "Deltakere");
		for(int k = 0; k < regler.getDeltakere().length; k++) {
			System.out.print(regler.getDeltakere()[k].getNavn()+ "\t");
		}
		System.out.println("");
		
        for (int i = 0; i < mat.length; i++) {
        	
        	System.out.println();
        	System.out.format("%-17s", runde[i]);
            // Loop through all elements of current row
            for (int j = 0; j < mat[i].length; j++) {
   
            	System.out.print(mat[i][j] +"\t");
            }
                
        }
        
    }
	
	public void start(YatzyStart brett, Yatzy regler) {
		
		while(regler.getRunde() < 18) {
			for(int col = 0; col < getArr()[regler.getRunde()].length; col++) {
				   
			       brett.getArr()[regler.runde][col] = kast(regler, brett, col);
			       
			}
			
			regler.setRunde(regler.getRunde()+1);
		}
			
	   
	}

	public int kast(Yatzy regler, YatzyStart brett, int spiller) {
		
		int sum = 0;
		
		if(regler.getKast() == 3 || regler.terningerBeholdt().length ==5) {
			regler.setKast(0);
		}
		//System.out.println(regler.getKast());
			if(regler.getRunde() < 6) {
				while(regler.getKast() <3 || regler.terningerBeholdt().length ==5) {
					
					regler.kastTerninger();
					
				}
				
				sum = regler.sjekkePoeng(regler.getRunde()+1);
				
			} else if (regler.getRunde()==6) {
			
				for(int i = 0; i < 6; i++) {
					sum += brett.getArr()[i][spiller];
				}
			
				
				
			} else if(regler.getRunde()==7) {
				if(62 < brett.getArr()[6][spiller]) {
					sum = 50;
				} else {
					sum = 0;
				}
			} else if(regler.getRunde() == 8 || regler.getRunde() == 9) {
				while(regler.getKast() < 3 || regler.terningerBeholdt().length ==5) {
					
				regler.kastTerninger();
					
				}
				
				regler.par(regler.getRunde()-7);
					
			}
			
			else if (regler.getRunde() == 10 || regler.getRunde() ==11) {
				while (regler.getKast() < 3 || regler.terningerBeholdt().length == 5) {

					regler.kastTerninger();

				}

				sum = regler.ofaKind(regler.getRunde()-7);
			}
			
			else if (regler.getRunde() == 12) {
				while (regler.getKast() < 3 || regler.terningerBeholdt().length == 5) {

					regler.kastTerninger();

				}

				sum = regler.StraightSmall();
			}
			
			else if (regler.getRunde() == 13) {
				while (regler.getKast() < 3 || regler.terningerBeholdt().length == 5) {

					regler.kastTerninger();

				}

				sum = regler.StraightBig();
			}
			
			else if (regler.getRunde() == 14) {

				while (regler.getKast() < 3 || regler.terningerBeholdt().length == 5) {

					regler.kastTerninger();

				}

				sum = regler.fullHouse();
			}

			else if (regler.getRunde() == 15) {

				while (regler.getKast() < 3 || regler.terningerBeholdt().length == 5) {

					regler.kastTerninger();

				}

				sum = regler.Sjanse();
			}

			else if (regler.getRunde() == 16) {

				while (regler.getKast() < 3 || regler.terningerBeholdt().length == 5) {

					regler.kastTerninger();

				}

				sum = regler.Yatzee();
			}

			else if (regler.getRunde() == 17) {

				for (int i = 6; i < 17; i++) {
					sum += brett.getArr()[i][spiller];
				}

			}

			return sum;

		
	}
	
	public void terninger(Yatzy regler) {
		
		regler.kastTerninger();
		regler.setKast(regler.getKast()+1);
		
	}
}




















