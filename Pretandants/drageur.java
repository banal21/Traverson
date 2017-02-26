package Pretandants;
import Game.Game;
import Game.PileCarte;
import Game.pileException;

public class Drageur extends Pretendant implements IPretendant {

	static int nbpts = 0;
	public static String message = "";
	
	public boolean Rencontre_possible() {
		return rencontre_possible;
	}

	public static int getNbpts() {
		return nbpts;
	}

	public static void setNbpts(int nbpts) {
		Drageur.nbpts = nbpts;
	}

	public Drageur() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void rendezVous(){
		nbpts = -200;
		message = "Le drageur vous deteste !";
		rencontre_possible = false;
	}

	@Override
	public void evolutionRelation(int nb) {
		nbpts= nbpts + nb;
		if (nbpts >= 100) {
			if (Game.currentCarte.getM_periode().equals("soir")){
				this.rendezVous();
			}
		}
	}

}
