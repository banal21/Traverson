
public class Game {
	public static PileCarte pile;
	public static Fenetre F;
	public static Carte currentCarte;
	public static void startGame() throws pileException{
		pile = new PileCarte();
		nextCarte();
	}
	
	public static void nextCarte(){
		try {
			if (!pile.estVide()) { 
				currentCarte  = pile.depiler();
				if (F == null) {
					F = new Fenetre();
				}
				F.afficheCarte(currentCarte);	
			}
				
		} catch (pileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void evolutionChoix1(){

//		currentCarte.actionLancee(choix1);
		switch (currentCarte.getM_lePretendant()) {
		case "drageur":
			drageur.evolutionRelation(Integer.parseInt(currentCarte.getM_reponseChoix1()));
			break;
		case "geek":
			geek.evolutionRelation(Integer.parseInt(currentCarte.getM_reponseChoix1()));
			break;
		default:
			break;
		} 
	}
	
	
	public static void evolutionChoix2(){

//		currentCarte.actionLancee(choix2);
		
		switch (currentCarte.getM_lePretendant()) {
		case "drageur":
			drageur.evolutionRelation(Integer.parseInt(currentCarte.getM_reponseChoix2()));
			break;
		case "geek":
			geek.evolutionRelation(Integer.parseInt(currentCarte.getM_reponseChoix2()));
			break;
		default:
			break;
		}	
	}
}
