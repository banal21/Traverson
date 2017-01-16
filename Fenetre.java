import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;


public class Fenetre extends JFrame{
	
	public Fenetre() {
		this.setTitle("Reigns");
		this.setSize(800, 550);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);              

	    //définition du type de bordure
	    Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	    
	    //Nord
	    JPanel pan1 = new JPanel();
	    pan1.setPreferredSize(new Dimension(800, 100));
	    JLabel BtnN1 = new JLabel("Gauche");
	    BtnN1.setPreferredSize(new Dimension(380, 100));
	    BtnN1.setBorder(loweredetched);
	    JLabel BtnN2 = new JLabel("Droite");
	    BtnN2.setPreferredSize(new Dimension(380, 100));
	    BtnN2.setBorder(loweredetched);
	    pan1.add(BtnN1);
	    pan1.add(BtnN2);	    
	    
	    //Milieu
	    JPanel pan3 = new JPanel();
	    pan3.setPreferredSize(new Dimension(800, 300));

	    //Ouest
	    JButton JLouest = new JButton("OUEST");
	    JLouest.setPreferredSize(new Dimension(200, 300));
	    pan3.add(JLouest);
	    
	    //Centre
	    JLabel JLcentre = new JLabel("CENTRE");
	    JLcentre.setPreferredSize(new Dimension(350, 300));
	    JLcentre.setBorder(loweredetched);
	    pan3.add(JLcentre);
	    	    
	    //Est
	    JButton JLest = new JButton("EST");
	    JLest.setPreferredSize(new Dimension(200, 300));
	    pan3.add(JLest);
	    
	  //Sud
	    JPanel pan2 = new JPanel();
	    pan2.setPreferredSize(new Dimension(800, 100));
	    JLabel JL = new JLabel("Question ?");
	    JL.setPreferredSize(new Dimension(760, 100));
	    JL.setBorder(loweredetched);
	    pan2.add(JL);
	    
	    JPanel pan4 = new JPanel();
	    pan4.setPreferredSize(new Dimension(800, 550));
	  //On positionne maintenant ces trois lignes en colonne
	    pan4.add(pan1);
	    pan4.add(pan3);
	    pan4.add(pan2);
			
	    this.getContentPane().add(pan4);
	    this.setVisible(true);
	}
}
