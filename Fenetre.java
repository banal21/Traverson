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


public class Fenetre extends JFrame{
	
	 private JMenuBar menuBar = new JMenuBar();
	 private JMenu options = new JMenu("options");
	 private JMenuItem item1 = new JMenuItem("relancer");
	 private JMenuItem item2 = new JMenuItem("quiter");
	  	
	public Fenetre(Carte c ) {

		c.readCarte();
		
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
	    JPanel pan1 = new JPanel();
	    pan1.setPreferredSize(new Dimension(800, 100));
	    JLabel BtnN1 = new JLabel(c.getM_periode());
	    BtnN1.setPreferredSize(new Dimension(380, 100));
	    BtnN1.setBorder(loweredetched);
	    JLabel BtnN2 = new JLabel(c.getM_lieux());
	    BtnN2.setPreferredSize(new Dimension(380, 100));
	    BtnN2.setBorder(loweredetched);
	    pan1.add(BtnN1);
	    pan1.add(BtnN2);	    
	    
	    //Milieu
	    JPanel pan3 = new JPanel();
	    pan3.setPreferredSize(new Dimension(800, 300));

	    //Ouest
	    JButton JLouest = new JButton(c.getM_choix1());
	    JLouest.setPreferredSize(new Dimension(200, 300));
	    pan3.add(JLouest);
	    
	    

	    //Centre
	    JLabel JLcentre = new JLabel();
	    JLcentre.setPreferredSize(new Dimension(350, 300));
	    JLcentre.setBorder(loweredetched);
	    //chargement de l'image
	    Icon image = new ImageIcon( "pretendant/test.jpg" );
	    JLcentre.setIcon(image);
	    pan3.add(JLcentre);
	    	    
	    //Est
	    JButton JLest = new JButton(c.getM_choix2());
	    JLest.setPreferredSize(new Dimension(200, 300));
	    pan3.add(JLest);
	    
	  //Sud
	    JPanel pan2 = new JPanel();
	    pan2.setPreferredSize(new Dimension(800, 100));
	    JLabel JL = new JLabel(c.getM_question());
	    JL.setPreferredSize(new Dimension(760, 100));
	    JL.setBorder(loweredetched);
	    pan2.add(JL);
	    
	    JPanel pan4 = new JPanel();
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
				new PileCarte();
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
}
