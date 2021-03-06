package View;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
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
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import Cartes.ICarte;
import Game.Game;
import Game.pileException;
import Pretandants.Drageur;
import Pretandants.Gay;
import Pretandants.Geek;
import Pretandants.Lourd;


@SuppressWarnings("serial")
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
		this.setSize(1100, 650);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);  
	    
	  //On initialise nos menus   
	    this.options.add(item1);
	    this.options.add(item2);
	    this.menuBar.add(options);
	    this.setJMenuBar(menuBar);
	    
	    //définition du type de bordure
	    Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	    
	    //Nord
	    pan1 = new JPanel();
	    pan1.setPreferredSize(new Dimension(970, 100));
	    BtnN1 = new JLabel();
	    BtnN1.setPreferredSize(new Dimension(480, 100));
	    BtnN1.setBorder(loweredetched);
		BtnN2 = new JLabel();
	    BtnN2.setPreferredSize(new Dimension(480, 100));
	    BtnN2.setBorder(loweredetched);

	    pan1.add(BtnN1);
	    pan1.add(BtnN2);
	    
	    //Milieu
	    pan3 = new JPanel();
	    pan3.setPreferredSize(new Dimension(1000, 300));

	    //Ouest
	    JLouest = new JButton();
	    JLouest.setPreferredSize(new Dimension(200, 300));
	    pan3.add(JLouest);
	    //Centre
	    JLcentre = new JLabel();
	    JLcentre.setPreferredSize(new Dimension(550, 300));
	    JLcentre.setBorder(loweredetched);
	    
	    pan3.add(JLcentre);
	    
	    //Est
	    JLest = new JButton();
	    JLest.setPreferredSize(new Dimension(200, 300));
	    pan3.add(JLest);
	    
		  //Sud
	    pan2 = new JPanel();
	    pan2.setPreferredSize(new Dimension(960, 110));
	    JL = new JLabel();
	    JL.setPreferredSize(new Dimension(960, 100));
	    JL.setBorder(loweredetched);
	    pan2.add(JL);
	    
	    pan4 = new JPanel();
	    pan4.setPreferredSize(new Dimension(1000, 550));
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
				int option = JOptionPane.showConfirmDialog(null, "Voulez-vous arr�ter le jeux ?", "Arr�ter ?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
							
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
		ImageIcon imageIcon  = new ImageIcon( "periodeImg/"+c.getM_periode()+".jpg" );
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(350, 150,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		BtnN1.setIcon(imageIcon);
	    BtnN2.setText(c.getM_lieux().substring(7));
	    imageIcon = new ImageIcon( "lieux/"+c.getM_lieux()+".jpg" );
		image = imageIcon.getImage(); // transform it 
		newimg = image.getScaledInstance(350, 150,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		BtnN2.setIcon(imageIcon);
		
	    JLouest.setText("<html>" + Character.toUpperCase(c.getM_choix1().charAt(0)) + c.getM_choix1().substring(1) + "</html>");
	   
	    imageIcon = new ImageIcon( "pretendant/"+c.getM_lePretendant()[Game.indexAleatoire]+".jpg" );
		image = imageIcon.getImage(); // transform it 
		newimg = image.getScaledInstance(550, 300,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
	    JLcentre.setIcon(imageIcon);
	    JLcentre.setText("");
	    JLest.setText("<html>" + Character.toUpperCase(c.getM_choix2().charAt(0)) + c.getM_choix2().substring(1) + "</html>");
	    JL.setText("<html>" + Character.toUpperCase(c.getM_question().charAt(0)) + c.getM_question().substring(1)  + "</html>");
	    JL.setHorizontalAlignment(SwingConstants.CENTER);
	    if (JLouest.getActionListeners().length > 0) {
		    JLouest.removeActionListener(JLouest.getActionListeners()[0]);
		}
	    JLouest.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Game.evolutionChoix1();					
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
				Game.nextCarte();
			}
		});
	    
	}
	
	public void partieFini(){
		BtnN1.setText(null); 
		imageP = new ImageIcon();
		BtnN1.setIcon(null);
	    BtnN2.setText("");
	    imagel = new ImageIcon();
		BtnN2.setIcon(null);
		
	    JLouest.setText("");
	   
		image = new ImageIcon();
	    JLcentre.setIcon(null);
	    String text = "<html>Partie Fini ! <br>";
	    text += Geek.message +" " + Drageur.message + " " + Gay.message + " " + Lourd.message + " <br>";
	    text += "relation avec le Geek :" + Geek.getNbpts() + " <br>";
	    text += "relation avec le Drageur :" + Drageur.getNbpts() + " <br>";
	    text += "relation avec la Gay :" + Gay.getNbpts() + " <br>";
	    text += "relation avec le Lourd :" + Lourd.getNbpts() + " <br>";
	    text += "</html>";
	    JLcentre.setText(text);
	    
	    JLest.setText("");
	    JL.setText("");
	    if (JLouest.getActionListeners().length > 0) {
		    JLouest.removeActionListener(JLouest.getActionListeners()[0]);
		}
	    if (JLest.getActionListeners().length > 0) {
	    	JLest.removeActionListener(JLest.getActionListeners()[0]);
		}
	    
	}
	
}
