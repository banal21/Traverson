package Game;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import Cartes.CarteFactory;
import Cartes.ICarte;

public class PileCarte implements pile{

	private static ArrayList<ICarte> lesCartes;
	private ArrayList<ICarte> lesCartesMatin;
	private ArrayList<ICarte> lesCartesMidi;
	private ArrayList<ICarte> lesCartesAM;
	private ArrayList<ICarte> lesCartesSoir;
	

	private static ArrayList<ICarte> lesCartesT;

	private boolean enoughtCard(ArrayList<ICarte> list1, ArrayList<ICarte> list2, ArrayList<ICarte> list3){
		int nb_listNotEmpty = 0;
		boolean returnBool = false;
		if (list1.size() > 0) {
			nb_listNotEmpty++;
		}
		if (list2.size() > 0) {
			nb_listNotEmpty++;
		}
		if (list3.size() > 0) {
			nb_listNotEmpty++;
		}
		if (nb_listNotEmpty > 1) {
			returnBool = true;
		}
		return returnBool;
		
	}
	
	public PileCarte(){
		lesCartes = new ArrayList<ICarte>();
		lesCartesMatin = new ArrayList<ICarte>();
		lesCartesMidi = new ArrayList<ICarte>();
		lesCartesAM = new ArrayList<ICarte>();
		lesCartesSoir= new ArrayList<ICarte>();
		lesCartesT = new ArrayList<ICarte>();
		
//generer l'empilage des carte automatique
		File file = new File("carte");
		if (file.isDirectory()) {
			for (File f : file.listFiles()) {
				ICarte c = CarteFactory.createCarte(f.getPath());				
				switch (c.getM_periode()) {
				case "matin":
					lesCartesMatin.add(c);
					lesCartesT.add(c);
					break;
				case "midi":
					lesCartesMidi.add(c);
					lesCartesT.add(c);
					break;
				case "apres-midi":
					lesCartesAM.add(c);
					lesCartesT.add(c);
					break;
				case "soir":
					lesCartesSoir.add(c);
					lesCartesT.add(c);
					break;
				default:
					break;
				} 
			}
			
			Random randomGenerator = new Random();
			Random r = new Random();
			int a=0;
			int i = lesCartesT.size();

			int valeur;
			while((a<i) && (enoughtCard(lesCartesSoir, lesCartesAM, lesCartesMatin))){
				if( lesCartesMatin.size() != 0){
					if (lesCartesMatin.size() > 2 ) {
						valeur = 1 + r.nextInt(2);
					}
					else{
						valeur =  1 + r.nextInt(lesCartesMatin.size());
					}
					i= i-valeur;
					for(int j=0; j<valeur; j++)
						chargerCarteMatin(randomGenerator);
				}
				if( lesCartesAM.size() != 0){
					if (lesCartesAM.size() > 2) {
						valeur = 1 + r.nextInt(2);
					}
					else{
						valeur = 1 + r.nextInt(lesCartesAM.size());
					}
					i= i-valeur;
					for(int j=0; j<valeur; j++)
						chargerCarteAM(randomGenerator);
				}
				if( lesCartesSoir.size() != 0){
					if (lesCartesSoir.size() > 2) {
						valeur = 1 + r.nextInt(2);
					}
					else{
						valeur = 1 + r.nextInt(lesCartesSoir.size());
					}
					i= i-valeur;
					for(int j=0; j<valeur; j++)
						chargerCarteSoir(randomGenerator);
				}
			}
		}

		ArrayList<ICarte> lesCartesProv = new ArrayList<ICarte>();
		while (!lesCartes.isEmpty()) {
			try {
				lesCartesProv.add(depiler());
			} catch (pileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		lesCartes = lesCartesProv;
		
	}
	
	public void chargerCarteMatin(Random randomGenerator){
		if(!lesCartesMatin.isEmpty()){
			int index4 = randomGenerator.nextInt(lesCartesMatin.size());
	        ICarte c4 = lesCartesMatin.get(index4);
	        empiler(c4);
	        lesCartesMatin.remove(index4);
		}
	}
	

	public void chargerCarteMidi(Random randomGenerator){
		if(!lesCartesMidi.isEmpty()){
	        int index3 = randomGenerator.nextInt(lesCartesMidi.size());
			ICarte c3 = lesCartesMidi.get(index3);
	        empiler(c3);
	        lesCartesMidi.remove(index3);
		}
	}

	public void chargerCarteAM(Random randomGenerator){
		if(!lesCartesAM.isEmpty()){
	        int index2 = randomGenerator.nextInt(lesCartesAM.size());
			ICarte c2 = lesCartesAM.get(index2);
	        empiler(c2);
	        lesCartesAM.remove(index2);
		}
	}

	public void chargerCarteSoir(Random randomGenerator){
		if(!lesCartesSoir.isEmpty()){
			int index = randomGenerator.nextInt(lesCartesSoir.size());
			ICarte c1 = lesCartesSoir.get(index);
	        empiler(c1);
	        lesCartesSoir.remove(index);
		}
	}
	
	
	public void rejouer(){
		lesCartes = new ArrayList<ICarte>();		
	}
	
	@Override
    public boolean estVide(){
        return lesCartes.isEmpty();
    }
    
    @Override
    public int sommet() throws pileException {
        return lesCartes.size();
    }
    @Override
	public void viderPile()throws pileException {
        if(this.estVide()){
            Game.F.partieFini();
        }
        else {
        	lesCartes.removeAll(lesCartes);
        }
	}

	@Override
	public void empiler(ICarte uneCarte) {
		lesCartes.add(uneCarte);
	}

	@Override
	public ICarte depiler() throws pileException {
		if(this.estVide()){
            throw new pileException();
        }
        else {
        	ICarte carte = lesCartes.get(lesCartes.size() - 1);
        	lesCartes.remove(lesCartes.size() - 1);
        	return carte;
        }
	}
	
	public void depilerPretendant(String leP){
		boolean is_pretendant = false;
		try {
			while (!is_pretendant) {
				ICarte c;
				c = depiler();
				if (Arrays.asList(c.getM_lePretendant()).contains(leP)) {
					is_pretendant = true;
					empiler(c);
				}
			}
		} catch (pileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
