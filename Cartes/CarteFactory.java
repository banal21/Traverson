package Cartes;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CarteFactory {

	//Methode générique permetant de créé a	 la voller des implementation de l'interface Icarte a partir du fichier texte de carte
	public static ICarte createCarte(String carte){
		try{
			InputStream flux=new FileInputStream(carte); 
			InputStreamReader lecture=new InputStreamReader(flux);
			BufferedReader buff=new BufferedReader(lecture);
			String ligne;
			
			//recuperation de la 2eme ligne du fichier
			String typeCarte = Files.readAllLines(Paths.get(carte)).get(1);

			//recuperation du type de carte voulut a partir de ce qui est lu dans le fichier
			Class<?> clazz = Class.forName(typeCarte);
			//recuperation du constructeur de la classe trouvé
			Constructor<?> ctor = clazz.getConstructor();

			//Instanciation de l'interface de Carte pour le bon type voulus
			ICarte EndCarte = (ICarte) ctor.newInstance(new Object[] {});
			for(int i=0; i<10;i++){
				ligne=buff.readLine();
				
				switch (i) {
				case 0:
					EndCarte.setM_periode(ligne.toString());
					break;
				case 1:
					EndCarte.setM_lieux(ligne.toString());
					break;
				case 2:
					EndCarte.setM_question(ligne.toString());
					break;
				case 3:
					EndCarte.setM_choix1(ligne.toString());
					break;
				case 4:
					EndCarte.setM_choix2(ligne.toString());
					break;
				case 5:
					EndCarte.setM_reponseChoix1(ligne.toString().split(";"));
					break;
				case 6:
					EndCarte.setM_reponseChoix2(ligne.toString().split(";"));
					break;
				case 7:
					EndCarte.setM_lePretendant(ligne.toString().split(";"));
					break;
				case 8:
					EndCarte.setM_carteSuivanteChoix1(ligne.toString());
					break;
				case 9:
					EndCarte.setM_carteSuivanteChoix2(ligne.toString());
					break;
				default:
					break;
				}
			}
			buff.close(); 
			return EndCarte;
			}		
			catch (Exception e){
				System.out.println(e.toString());
			}
		
		return null;
		
	}
}
