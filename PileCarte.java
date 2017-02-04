import java.util.ArrayList;

public class PileCarte implements pile{

	private static ArrayList<Carte> lesCartes = new ArrayList<Carte>();
	
	public PileCarte(){
//generer l'empilage des carte automatique

		Carte c3  = new Carte();
		c3.readCarte("carte/piscine_longueur.txt");
		empiler(c3);
		Carte c  = new Carte();
		c.readCarte("carte/soireeCinee.txt");
		Carte c2  = new Carte();
		c2.readCarte("carte/piscine.txt");
		empiler(c);
		empiler(c2);
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

}
