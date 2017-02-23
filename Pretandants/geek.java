package Pretandants;
import Game.Game;
import Game.pileException;

public class Geek extends Pretendant  implements IPretendant{

	private static int nbpts = 0;
	
	public static int getNbpts() {
		return nbpts;
	}

	public static void setNbpts(int nbpts) {
		Geek.nbpts = nbpts;
	}

	public Geek() {
		// TODO Auto-generated constructor stub
	}

	public void evolutionRelation(int nb){
		nbpts= nbpts + nb;
		if (nbpts >= 100) {
			if (Game.currentCarte.getM_periode().equals("soir")){
				this.rendezVous();
			}
		}
		else if(nbpts >= 50){
			Game.pile.depilerPretendant("geek");
		}
	}
	
	@Override
	public void rendezVous(){
		try {
			Game.pile.viderPile();
		} catch (pileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean Rencontre_possible() {
		return rencontre_possible;
	}
}
