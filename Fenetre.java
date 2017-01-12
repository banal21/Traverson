import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Fenetre extends JFrame{
	
	public Fenetre() {
		this.setTitle("Reigns");
		this.setSize(800, 500);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);              
	   
	    
	  //Définition layout qui est sur le panel
	    this.setLayout(new BorderLayout());
	    
	    //Nord
	    this.getContentPane().add(new JButton("NORD"), BorderLayout.NORTH);
	    
	    //Sud
	    this.getContentPane().add(new JButton("SUD"), BorderLayout.SOUTH);
	    
	    //Centre
	    this.getContentPane().add(new JButton("CENTRE"), BorderLayout.CENTER);
	    
	    //Ouest
	    this.getContentPane().add(new JButton("OUEST"), BorderLayout.WEST);
	    
	    //Est
	    this.getContentPane().add(new JButton("EST"), BorderLayout.EAST);
	    
	    

	    
	    this.setVisible(true);
	}
}
