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

		Class<?> clazz;
		try {
			clazz = Class.forName(currentCarte.getM_lePretendant());
			//recuperation du constructeur de la classe trouvé
			Constructor<?> ctor = clazz.getConstructor();

			//Instanciation de l'interface Pretandant pour le bon type voulus
			IPretendant pretendant = (IPretendant) ctor.newInstance(new Object[] {});
			pretendant.evolutionRelation(Integer.parseInt(currentCarte.getM_reponseChoix1()));
		}		
		catch (Exception e){
		System.out.println(e.toString());
		}
		
//		currentCarte.actionLancee(choix1);
	
	}
	
	
	public static void evolutionChoix2(){
		Class<?> clazz;
		try {
			clazz = Class.forName(currentCarte.getM_lePretendant());
			//recuperation du constructeur de la classe trouvé
			Constructor<?> ctor = clazz.getConstructor();

			//Instanciation de l'interface Pretandant pour le bon type voulus
			IPretendant pretendant = (IPretendant) ctor.newInstance(new Object[] {});
			pretendant.evolutionRelation(Integer.parseInt(currentCarte.getM_reponseChoix2()));
		}		
		catch (Exception e){
		System.out.println(e.toString());
		}
	}
}
