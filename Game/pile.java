package Game;
import Cartes.ICarte;

public interface pile {
	/* 
	 * méthodes abstraites de gestion d'une pile 
	 * */

	public boolean estVide();
	public void empiler (ICarte uneCarte);
	public int sommet() throws pileException;
	public void viderPile() throws pileException;
	public ICarte depiler() throws pileException;
}
