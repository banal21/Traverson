package Pretandants;
import Game.Game;
import Game.pileException;

public class Gay extends Pretendant  implements IPretendant{

	private static int nbpts = 0;
	public static String message = "";
	
	public static int getNbpts() {
		return nbpts;
	}

	public static void setNbpts(int nbpts) {
		Gay.nbpts = nbpts;
	}

	public Gay() {
		// TODO Auto-generated constructor stub
	}

	public void evolutionRelation(int nb){
		nbpts= nbpts + nb;
		if (nbpts >= 100) {
			if (Game.currentCarte.getM_periode().equals("soir")){
				this.rendezVous();
			}
		}
	}
	
	@Override
	public void rendezVous(){
		try {
			message = "la lesbienne vous aime ! ";
			Game.pile.viderPile();
            Game.F.partieFini();
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
