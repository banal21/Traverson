
public class dragueur extends Pretendant {

	public dragueur() {
		// TODO Auto-generated constructor stub
	}
	
	public void rendezVous(){
		PileCarte test = new PileCarte();
		try {
			test.viderPile();
		} catch (pileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
