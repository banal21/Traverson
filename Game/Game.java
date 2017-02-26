package Game;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import Cartes.CarteFactory;
import Cartes.ICarte;
import Pretandants.IPretendant;
import Pretandants.Lourd;
import Pretandants.Drageur;
import Pretandants.Gay;
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
		Geek.message ="";
		Drageur.setNbpts(0);
		Drageur.message ="";
		Gay.setNbpts(0);
		Gay.message ="";
		Lourd.setNbpts(0);
		Lourd.message ="";
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

					Class<?> clazz;
					clazz = Class.forName(currentCarte.getM_lePretendant()[indexAleatoire]);
					Constructor<?> ctor = clazz.getConstructor();
					IPretendant pretendant = (IPretendant) ctor.newInstance(new Object[] {});
					if (pretendant.Rencontre_possible()) {
						F.afficheCarte(currentCarte);
					}
					else{
						nextCarte();
					}
				}
				else{
					nextCarte();
				}
			}
			else{
	            Game.F.partieFini();
			}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void evolutionChoix1(){

		Class<?> clazz;
		try {
			currentCarte.actionLancee();
			clazz = Class.forName(currentCarte.getM_lePretendant()[indexAleatoire]);
			//recuperation du constructeur de la classe trouvé
			Constructor<?> ctor = clazz.getConstructor();

			//Instanciation de l'interface Pretandant pour le bon type voulus
			IPretendant pretendant = (IPretendant) ctor.newInstance(new Object[] {});
			pretendant.evolutionRelation(Integer.parseInt(currentCarte.getM_reponseChoix1()[indexAleatoire]));
			if (!currentCarte.getM_carteSuivanteChoix1().equals("")) {
				ICarte carteToAdd = CarteFactory.createCarte(currentCarte.getM_carteSuivanteChoix1());
				int nb_periode = 0;
				String periode = currentCarte.getM_periode();
				while ((nb_periode < 2) || !periode.equals(carteToAdd.getM_periode())) {
					ICarte prov = pile.depiler();
					periode = prov.getM_periode();
					if (!periode.equals(currentCarte.getM_periode())) {
						nb_periode++;
					}
					if (periode.equals(carteToAdd.getM_periode()) || (nb_periode == 2)) {
						pile.empiler(prov);
						pile.empiler(carteToAdd);
						nb_periode = 3;
					}
				}
			}
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
		
//		currentCarte.actionLancee(choix1);
	
	}
	
	
	public static void evolutionChoix2(){
		Class<?> clazz;
		try {
			currentCarte.actionLancee();
			clazz = Class.forName(currentCarte.getM_lePretendant()[indexAleatoire]);
			//recuperation du constructeur de la classe trouvé
			Constructor<?> ctor = clazz.getConstructor();

			//Instanciation de l'interface Pretandant pour le bon type voulus
			IPretendant pretendant = (IPretendant) ctor.newInstance(new Object[] {});
			pretendant.evolutionRelation(Integer.parseInt(currentCarte.getM_reponseChoix2()[indexAleatoire]));
			if (!currentCarte.getM_carteSuivanteChoix2().equals("") && !currentCarte.getM_carteSuivanteChoix2().equals("/")) {
				ICarte carteToAdd = CarteFactory.createCarte(currentCarte.getM_carteSuivanteChoix2());
				int nb_periode = 0;
				String periode = currentCarte.getM_periode();
				while (nb_periode < 2) {
					ICarte prov = pile.depiler();
					periode = prov.getM_periode();
					if (carteToAdd.getM_periode().equals(currentCarte.getM_periode())) {
						pile.empiler(prov);
						pile.empiler(carteToAdd);
						nb_periode = 3;
					}
					else{
						if (!periode.equals(currentCarte.getM_periode())) {
							nb_periode++;
						}
						if (periode.equals(carteToAdd.getM_periode()) || (nb_periode ==2)) {
							pile.empiler(prov);
							pile.empiler(carteToAdd);
							nb_periode = 3;
						}
					}
				}
			}
		}		
		catch (Exception e){
		System.out.println(e.toString());
		}
	}
}
