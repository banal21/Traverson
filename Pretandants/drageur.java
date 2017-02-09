package Pretandants;
import Game.PileCarte;
import Game.pileException;

public class drageur extends Pretendant {

	static int nbpts = 0;
	public drageur() {
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
	
	public static void evolutionRelation(int nb){
		nbpts= nbpts + nb;
	}
	
	public static void test(){
		
	}

}
