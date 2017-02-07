
public class geek extends Pretendant {

	static int nbpts = 0;
	
	public geek() {
		// TODO Auto-generated constructor stub
	}

	static void evolutionRelation(int nb){
		nbpts= nbpts + nb;
		if(nbpts >= 50){
			Game.pile.depilerPretendant("geek");
		}
	}
	public void rendezVous() throws pileException{
		Game.pile.viderPile();
	}
}
