package dev.gui.menu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;

public class PrincipalPanel extends JPanel implements MouseListener
{


	public PrincipalPanel()
	{
		this.setLayout(null);
	}


	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		BufferedImage bg		 	= null;
		BufferedImage logo 			= null;
		BufferedImage playPause 	= null;
		BufferedImage bgMenuMulti 	= null;

		try{
			bg			= ImageIO.read(new File("src/files/images/BG.jpg"));
			logo 		= ImageIO.read(new File("src/files/images/Music Multi Player Logo1.png"));
			playPause 	= ImageIO.read(new File("src/files/images/play.png"));
			bgMenuMulti = ImageIO.read(new File("src/files/images/multiMenuBG.png"));

		}catch (Exception e)
		{
			System.out.println("Erreur de lecture d'une image");
		}

		//Positionnement des images
		g.drawImage(bg, -1, -1, this);
		g.drawImage(logo,  super.getWidth()/2 - logo.getWidth()/2, 50, this);
		g.drawImage(playPause, super.getWidth()/2 - 160, 400, this);
		g.drawImage(bgMenuMulti, -1, -1, this);
		g.drawImage(bgMenuMulti, super.getWidth() - bgMenuMulti.getWidth(), -1, this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
}
