package Cartes;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Pretandants.Pretendant;

public interface ICarte { 
	
	public String getM_question();

	public void setM_question(String m_question);

	public String getM_choix1();

	public void setM_choix1(String m_choix1);

	public String getM_choix2();

	public void setM_choix2(String m_choix2);

	public String getM_periode();

	public void setM_periode(String m_periode);

	public String getM_lieux();

	public void setM_lieux(String m_lieux);

	public String[] getM_reponseChoix1();

	public void setM_reponseChoix1(String[] strings);

	public String[] getM_reponseChoix2();

	public void setM_reponseChoix2(String[] strings);

	public String[] getM_lePretendant();
	
	public void setM_lePretendant(String[] strings);

	public String getM_carteSuivanteChoix1();

	public void setM_carteSuivanteChoix1(String m_carteSuivanteChoix1);

	public String getM_carteSuivanteChoix2();

	public void setM_carteSuivanteChoix2(String m_carteSuivanteChoix2);

	public void evolutionRelation();
	
	abstract void actionLancee();
}
