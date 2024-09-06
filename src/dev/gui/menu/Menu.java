package dev.gui.menu;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame
{
	private JPanel pnlCentral;


	public Menu()
	{
		this.setSize(1000,800);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Définition du panel
		this.pnlCentral = new menuPanel();




		//Ajout des éléments au panel / Frame
		this.add(this.pnlCentral);
		this.setVisible(true);
	}




}
