package Cartes;

import Game.Game;
import Game.PileCarte;
import Game.pileException;

public class Bar extends Carte implements ICarte {
	
	@Override
	public void actionLancee() {
		try {
			Game.pile.depiler();
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
