
public class Piscine extends Carte {
	public void actionLancee(String choix){
		if(choix == "choix1"){
			switch (Game.currentCarte.getM_lePretendant()) {
			case "drageur":
				drageur.evolutionRelation(Integer.parseInt(Game.currentCarte.getM_reponseChoix1()));
				break;
			case "geek":
				geek.evolutionRelation(Integer.parseInt(Game.currentCarte.getM_reponseChoix1()));
				break;
			default:
				break;
			}
		}
		
		if(choix=="choix2"){
			switch (Game.currentCarte.getM_lePretendant()) {
			case "drageur":
				drageur.evolutionRelation(Integer.parseInt(Game.currentCarte.getM_reponseChoix2()));
				break;
			case "geek":
				geek.evolutionRelation(Integer.parseInt(Game.currentCarte.getM_reponseChoix2()));
				break;
			default:
				break;
			}	
		}
	}
//
//	@Override
//	public 
	
}
