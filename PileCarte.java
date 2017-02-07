import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

public class PileCarte implements pile{

	private static ArrayList<Carte> lesCartes = new ArrayList<Carte>();
	private static ArrayList<Carte> lesCartesMatin = new ArrayList<Carte>();
	private static ArrayList<Carte> lesCartesMidi = new ArrayList<Carte>();
	private static ArrayList<Carte> lesCartesAM = new ArrayList<Carte>();
	private static ArrayList<Carte> lesCartesSoir= new ArrayList<Carte>();

	
	public PileCarte(){
//generer l'empilage des carte automatique
		File file = new File("carte");
		if (file.isDirectory()) {
			for (File f : file.listFiles()) {
				Carte c = new Carte();
				c.readCarte(f.getPath());				
				switch (c.getM_periode()) {
				case "matin":
					lesCartesMatin.add(c);
					break;
				case "midi":
					lesCartesMidi.add(c);
					break;
				case "apres-midi":
					lesCartesAM.add(c);
					break;
				case "soir":
					lesCartesSoir.add(c);
					break;
				default:
					break;
				} 
			}


			Random randomGenerator = new Random();
			ArrayList<Carte> CarteAl = new ArrayList<Carte>();
			CarteAl.addAll(lesCartesSoir);
			while(!CarteAl.isEmpty()){
				int index = randomGenerator.nextInt(CarteAl.size());
				Carte c1 = CarteAl.get(index);
		        empiler(c1);
		        CarteAl.remove(index);
				
			}

			
			CarteAl.addAll(lesCartesAM);
			while(!CarteAl.isEmpty()){
				int index = randomGenerator.nextInt(CarteAl.size());
				Carte c1 = CarteAl.get(index);
		        empiler(c1);
		        CarteAl.remove(index);
				
			}
			

			CarteAl.addAll(lesCartesMidi);
			while(!CarteAl.isEmpty()){
				int index = randomGenerator.nextInt(CarteAl.size());
				Carte c1 = CarteAl.get(index);
		        empiler(c1);
		        CarteAl.remove(index);
				
			}
			

			CarteAl.addAll(lesCartesMatin);
			while(!CarteAl.isEmpty()){
				int index = randomGenerator.nextInt(CarteAl.size());
		        Carte c1 = CarteAl.get(index);
		        empiler(c1);
		        CarteAl.remove(index);
			} 
		}
	}
	
	public void rejouer(){
		lesCartes = new ArrayList<Carte>();		
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
            throw new pileException();
        }
        else {
            lesCartes.remove(this.sommet());
        }
	}

	@Override
	public void empiler(Carte uneCarte) {
		lesCartes.add(uneCarte);
	}

	@Override
	public Carte depiler() throws pileException {
		if(this.estVide()){
            throw new pileException();
        }
        else {
        	Carte carte = lesCartes.get(lesCartes.size() - 1);
        	lesCartes.remove(lesCartes.size() - 1);
        	return carte;
        }
	}
	
	public void depilerPretendant(String leP){
		boolean is_pretendant = false;
		try {
			while (!is_pretendant) {
				Carte c;
				c = depiler();
				if (c.getM_lePretendant() == leP) {
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
