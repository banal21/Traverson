
public interface pile {
	/* 
	 * méthodes abstraites de gestion d'une pile 
	 * */

	public boolean estVide();
	public void empiler (Carte uneCarte);
	public int sommet() throws pileException;
	public void viderPile() throws pileException;
	public Carte depiler() throws pileException;
}
