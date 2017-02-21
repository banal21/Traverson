package Game;
import java.lang.reflect.Constructor;

import Cartes.ICarte;
import Pretandants.IPretendant;
import Pretandants.Drageur;
import Pretandants.Geek;
import View.Fenetre;

public class Game {
	public static PileCarte pile;
	public static Fenetre F;
	public static ICarte currentCarte;
	public static int indexAleatoire = 0;
	public static void startGame() throws pileException{
		pile = new PileCarte();
		Geek.setNbpts(0);
		Drageur.setNbpts(0);
		nextCarte();
	}
	
	public static void nextCarte(){
		try {
			if (!pile.estVide()) { 
				currentCarte  = pile.depiler();
				if (F == null) {
					F = new Fenetre();
				}
				if (currentCarte.getM_lePretendant().length == currentCarte.getM_reponseChoix1().length && currentCarte.getM_lePretendant().length == currentCarte.getM_reponseChoix2().length) {
					indexAleatoire = (int) (Math.random() * (currentCarte.getM_lePretendant().length));
					F.afficheCarte(currentCarte);
				}
				else{
					nextCarte();
				}
			}
			else{
	            Game.F.partieFini();
			}
				
		} catch (pileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void evolutionChoix1(){

		Class<?> clazz;
		try {
			clazz = Class.forName(currentCarte.getM_lePretendant()[indexAleatoire]);
			//recuperation du constructeur de la classe trouvé
			Constructor<?> ctor = clazz.getConstructor();

			//Instanciation de l'interface Pretandant pour le bon type voulus
			IPretendant pretendant = (IPretendant) ctor.newInstance(new Object[] {});
			pretendant.evolutionRelation(Integer.parseInt(currentCarte.getM_reponseChoix1()[indexAleatoire]));
		}		
		catch (Exception e){
		System.out.println(e.toString());
		}
		
//		currentCarte.actionLancee(choix1);
	
	}
	
	
	public static void evolutionChoix2(){
		Class<?> clazz;
		try {
			clazz = Class.forName(currentCarte.getM_lePretendant()[indexAleatoire]);
			//recuperation du constructeur de la classe trouvé
			Constructor<?> ctor = clazz.getConstructor();

			//Instanciation de l'interface Pretandant pour le bon type voulus
			IPretendant pretendant = (IPretendant) ctor.newInstance(new Object[] {});
			pretendant.evolutionRelation(Integer.parseInt(currentCarte.getM_reponseChoix2()[indexAleatoire]));
		}		
		catch (Exception e){
		System.out.println(e.toString());
		}
	}
}
