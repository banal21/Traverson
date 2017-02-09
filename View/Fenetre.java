package View;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import Cartes.ICarte;
import Game.Game;
import Game.pileException;


public class Fenetre extends JFrame{
	
	 private JMenuBar menuBar = new JMenuBar();
	 private JMenu options = new JMenu("options");
	 private JMenuItem item1 = new JMenuItem("relancer");
	 private JMenuItem item2 = new JMenuItem("quiter");
	 private JPanel pan1;
	 private JLabel BtnN1;
	 private Icon imageP;
	 private JLabel BtnN2;
	 private Icon imagel;
	 private JPanel pan3;
	 private JButton JLouest;
	 private JLabel JLcentre;
	 private Icon image;
	 private JButton JLest;
	 private JPanel pan2;
	 private JLabel JL;
	 private JPanel pan4;
	 
	public Fenetre() {

		
		this.setTitle("Reigns");
		this.setSize(800, 550);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);  
	    
	  //On initialise nos menus   
	    this.options.add(item1);
	    this.options.add(item2);
	    this.menuBar.add(options);
	    this.setJMenuBar(menuBar);
	    
	    //dÃ©finition du type de bordure
	    Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	    
	    //Nord
	    pan1 = new JPanel();
	    pan1.setPreferredSize(new Dimension(800, 100));
	    BtnN1 = new JLabel();
	    BtnN1.setPreferredSize(new Dimension(380, 100));
	    BtnN1.setBorder(loweredetched);
		BtnN2 = new JLabel();
	    BtnN2.setPreferredSize(new Dimension(380, 100));
	    BtnN2.setBorder(loweredetched);

	    pan1.add(BtnN1);
	    pan1.add(BtnN2);
	    
	    //Milieu
	    pan3 = new JPanel();
	    pan3.setPreferredSize(new Dimension(800, 300));

	    //Ouest
	    JLouest = new JButton();
	    JLouest.setPreferredSize(new Dimension(200, 300));
	    pan3.add(JLouest);
	    //Centre
	    JLcentre = new JLabel();
	    JLcentre.setPreferredSize(new Dimension(350, 300));
	    JLcentre.setBorder(loweredetched);
	    
	    pan3.add(JLcentre);
	    
	    //Est
	    JLest = new JButton();
	    JLest.setPreferredSize(new Dimension(200, 300));
	    pan3.add(JLest);
	    
		  //Sud
	    pan2 = new JPanel();
	    pan2.setPreferredSize(new Dimension(800, 100));
	    JL = new JLabel();
	    JL.setPreferredSize(new Dimension(760, 100));
	    JL.setBorder(loweredetched);
	    pan2.add(JL);
	    
	    pan4 = new JPanel();
	    pan4.setPreferredSize(new Dimension(800, 550));
	  //On positionne maintenant ces trois lignes en colonne
	    pan4.add(pan1);
	    pan4.add(pan3);
	    pan4.add(pan2);
	    
	    //ecoute des menus
    	//relancer le jeux
	    item1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try {
					Game.startGame();
				} catch (pileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	    	//quiter l'application
	    item2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane jop = new JOptionPane();			
				int option = jop.showConfirmDialog(null, "Voulez-vous arrêter le jeux ?", "Arrêter ?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
							
				if(option == JOptionPane.OK_OPTION){
				  System.exit(0);		
				}
			}
		});

	    this.getContentPane().add(pan4);
	    this.setVisible(true);
	}
	
	public void afficheCarte(ICarte c){
		BtnN1.setText(c.getM_periode()); 
		imageP = new ImageIcon( "periodeImg/"+c.getM_periode()+".jpg" );
		BtnN1.setIcon(imageP);
	    BtnN2.setText(c.getM_lieux());
	    imagel = new ImageIcon( "lieux/"+c.getM_lieux()+".jpg" );
		BtnN2.setIcon(imagel);
		
	    JLouest.setText(c.getM_choix1());
	   
		image = new ImageIcon( "pretendant/"+c.getM_lePretendant()+".jpg" );
	    JLcentre.setIcon(image);
	    JLest.setText(c.getM_choix2());
	    JL.setText(c.getM_question());
	    if (JLouest.getActionListeners().length > 0) {
		    JLouest.removeActionListener(JLouest.getActionListeners()[0]);
		}
	    JLouest.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Game.evolutionChoix1();
					
//					if(c.getM_carteSuivanteChoix1().length()>0){
//						Carte maCarte = new Carte("carte/"+c.getM_carteSuivanteChoix1());
//						Game.pile.empiler(maCarte);
//					}
					
				Game.nextCarte();
			}
		});
	    if (JLest.getActionListeners().length > 0) {
	    	JLest.removeActionListener(JLest.getActionListeners()[0]);
		}
	    JLest.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				Game.evolutionChoix2();
			
//				if(c.getM_carteSuivanteChoix2() {
//					Carte maCarte = new Carte("carte/"+c.getM_carteSuivanteChoix2());
//					Game.pile.empiler(maCarte);
//				}
				
				Game.nextCarte();
			}
		});
	    
	}
	
}
