package Pretandants;
import Game.PileCarte;
import Game.pileException;

public class Drageur extends Pretendant implements IPretendant {

	static int nbpts = 0;
	public static int getNbpts() {
		return nbpts;
	}

	public static void setNbpts(int nbpts) {
		Drageur.nbpts = nbpts;
	}

	public Drageur() {
		// TODO Auto-generated constructor stub
	}
	
	public void rendezVous(){
		PileCarte test = new PileCarte();
		try {
			test.viderPile();
		} catch (pileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void test(){
		
	}

	@Override
	public void evolutionRelation(int nb) {
		nbpts= nbpts + nb;
	}

}
