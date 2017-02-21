package Cartes;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Pretandants.Pretendant;

abstract class Carte implements ICarte {

	private String[]  m_lePretendant,m_reponseChoix1, m_reponseChoix2;
	private String m_question, m_choix1, m_choix2, m_periode,m_lieux ,m_carteSuivanteChoix1,m_carteSuivanteChoix2 ;  
	private ArrayList<Pretendant> lesPretendants = new ArrayList<Pretendant>();
	

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

	public String[] getM_reponseChoix1() {
		return m_reponseChoix1;
	}

	public void setM_reponseChoix1(String[] m_reponseChoix1) {
		this.m_reponseChoix1 = m_reponseChoix1;
	}

	public String[] getM_reponseChoix2() {
		return m_reponseChoix2;
	}

	public void setM_reponseChoix2(String[] m_reponseChoix2) {
		this.m_reponseChoix2 = m_reponseChoix2;
	}

	public String[] getM_lePretendant() {
		return m_lePretendant;
	}

	public void setM_lePretendant(String[] m_lePretendant) {
		this.m_lePretendant = m_lePretendant;
	}


	public String getM_carteSuivanteChoix1() {
		return m_carteSuivanteChoix1;
	}

	public void setM_carteSuivanteChoix1(String m_carteSuivanteChoix1) {
		this.m_carteSuivanteChoix1 = m_carteSuivanteChoix1;
	}

	public String getM_carteSuivanteChoix2() {
		return m_carteSuivanteChoix2;
	}

	public void setM_carteSuivanteChoix2(String m_carteSuivanteChoix2) {
		this.m_carteSuivanteChoix2 = m_carteSuivanteChoix2;
	}
	
	public abstract void actionLancee();

}
