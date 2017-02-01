import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Carte {

	private String m_question, m_choix1, m_choix2, m_periode,m_lieux, m_reponseChoix1, m_reponseChoix2;  
	private ArrayList<Pretendant> lesPretendants = new ArrayList<Pretendant>();
	
	public void readCarte(){

		try{
		InputStream flux=new FileInputStream("piscine.txt"); 
		InputStreamReader lecture=new InputStreamReader(flux);
		BufferedReader buff=new BufferedReader(lecture);
		String ligne;
		for(int i=0; i<9;i++){
			ligne=buff.readLine();
			
			switch (i) {
			case 0:
				m_periode = ligne.toString();
				break;
			case 1:
				m_lieux = ligne.toString();
				break;
			case 2:
				m_question = ligne.toString();
				break;
			case 3:
				m_choix1 = ligne.toString();
				break;
			case 4:
				m_choix2 = ligne.toString();
				break;
			case 5:
				m_reponseChoix1 = (ligne.toString());
				break;
			case 6:
				m_reponseChoix2 = (ligne.toString());
				break;
			default:
				break;
			}	
		
				
		}
		buff.close(); 
		}		
		catch (Exception e){
		System.out.println(e.toString());
		}
	}

	public String getM_question() {
		return m_question;
	}

	public void setM_question(String m_question) {
		this.m_question = m_question;
	}

	public String getM_choix1() {
		return m_choix1;
	}

	public void setM_choix1(String m_choix1) {
		this.m_choix1 = m_choix1;
	}

	public String getM_choix2() {
		return m_choix2;
	}

	public void setM_choix2(String m_choix2) {
		this.m_choix2 = m_choix2;
	}

	public String getM_periode() {
		return m_periode;
	}

	public void setM_periode(String m_periode) {
		this.m_periode = m_periode;
	}

	public String getM_lieux() {
		return m_lieux;
	}

	public void setM_lieux(String m_lieux) {
		this.m_lieux = m_lieux;
	}

	public String getM_reponseChoix1() {
		return m_reponseChoix1;
	}

	public void setM_reponseChoix1(String m_reponseChoix1) {
		this.m_reponseChoix1 = m_reponseChoix1;
	}

	public String getM_reponseChoix2() {
		return m_reponseChoix2;
	}

	public void setM_reponseChoix2(String m_reponseChoix2) {
		this.m_reponseChoix2 = m_reponseChoix2;
	}
}
