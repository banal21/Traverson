import java.util.ArrayList;

public class PileCarte implements pile{

	private ArrayList<Carte> lesCartes = new ArrayList<Carte>();
	
	public void rejouer(){
		lesCartes = new ArrayList<Carte>();		
	}
	
	@Override
    public boolean estVide(){
        return lesCartes.isEmpty();
    }
    
    @Override
    public Carte sommet() throws pileException {
        if(this.estVide()){
            throw new pileException();
        }
        else return lesCartes.get(0);
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
		// TODO Auto-generated method stub
		
	}

}
