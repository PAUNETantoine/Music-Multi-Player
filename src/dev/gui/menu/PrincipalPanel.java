package dev.gui.menu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;

public class PrincipalPanel extends JPanel
{


	public PrincipalPanel()
	{
		this.setBackground(Color.GRAY);
		this.setLayout(null);
	}


	public void paintComponents(Graphics g)
	{
		super.paintComponent(g);

		BufferedImage logo = null;
		BufferedImage playPause = null;

		try{
			logo = ImageIO.read(new File("src/files/images/Music Multi Player Logo1.png"));
			playPause = ImageIO.read(new File("src/files/images/play.png"));

		}catch (Exception e)
		{
			System.out.println("Erreur de lecture d'une image");
		}

		g.drawImage(logo,  super.getWidth()/2 - logo.getWidth()/2, 50, this);

		g.drawImage(playPause, 200, 500, this);
	}
}
