package Pretandants;
import Game.Game;
import Game.pileException;

public class Lourd extends Pretendant  implements IPretendant{

	private static int nbpts = 0;
	public static String message = "";
	
	public static int getNbpts() {
		return nbpts;
	}

	public static void setNbpts(int nbpts) {
		Lourd.nbpts = nbpts;
	}

	public Lourd() {
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
		nbpts = -200;
		message = "Le drageur vous deteste !";
		rencontre_possible = false;
	}

	@Override
	public boolean Rencontre_possible() {
		return rencontre_possible;
	}
}
