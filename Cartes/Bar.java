package Cartes;

import Game.Game;
import Game.PileCarte;
import Game.pileException;

public class Bar extends Carte implements ICarte {
	
	@Override
	public void actionLancee() {
		try {
			boolean periode_saute = false;
			String next_periode = "";
			int nb_periode = 0;
			while (!periode_saute) {
				ICarte carte = Game.pile.depiler();
				
				if (!carte.getM_periode().equals(this.getM_periode()) || nb_periode > 0) {
					if ((carte.getM_periode().equals("matin") && nb_periode == 0)) {
						nb_periode++;
					}
					else{
						periode_saute = true;
					}
				}
			}
		} catch (pileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void evolutionRelation() {
		// TODO Auto-generated method stub
		
	}


}
