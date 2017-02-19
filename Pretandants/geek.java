package Pretandants;
import Game.Game;
import Game.pileException;

public class Geek extends Pretendant  implements IPretendant{

	static int nbpts = 0;
	
	public Geek() {
		// TODO Auto-generated constructor stub
	}

	public void evolutionRelation(int nb){
		nbpts= nbpts + nb;
		if(nbpts >= 50){
			Game.pile.depilerPretendant("geek");
		}
	}
	public void rendezVous() throws pileException{
		Game.pile.viderPile();
	}
}
