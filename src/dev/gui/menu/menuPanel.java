package dev.gui.menu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class menuPanel extends JPanel
{
	private BufferedImage logo;

	private JTextField txtNomUtilisateur;
	private JTextField txtMotDePasse;



	public menuPanel()
	{
		this.setBackground(Color.GRAY);

		this.setLayout(null);

		try{
			this.logo = ImageIO.read(new File("src/files/images/Music Multi Player Logo1.png"));
		}catch (Exception e)
		{
			System.out.println("Erreur de lecture de l'image logo");
		}


		this.txtNomUtilisateur 	= new JTextField();
		this.txtMotDePasse 		= new JTextField();

		this.txtNomUtilisateur.setBounds(365, 300, 250, 30);
		this.txtMotDePasse.setBounds(365, 350, 250, 30);

		this.add(this.txtNomUtilisateur);
		this.add(this.txtMotDePasse);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		g.drawImage(this.logo,  super.getWidth()/2 - this.logo.getWidth()/2, 50, this);
	}
}
