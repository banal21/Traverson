
public interface pile {
	/* 
	 * m�thodes abstraites de gestion d'une pile 
	 * */

	public boolean estVide();
	public void empiler (Carte uneCarte);
	public Carte sommet() throws pileException;
	public void viderPile() throws pileException;
}
