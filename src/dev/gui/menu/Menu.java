package dev.gui.menu;

import dev.Controleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Menu extends JFrame
{
	private MenuPanel pnlCentral;
	public static int width = 1000;

	public Menu(int code)
	{
		this.setSize(1000,800);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Music Multi Player - Connexion");


		//Définition du panel
		this.pnlCentral = new MenuPanel(code);

		//Ajout des éléments au panel / Frame
		this.add(this.pnlCentral);


		this.setVisible(true);





		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				if (code == 0)
				{
					// Fonction appelée lors du clic sur la croix
					Controleur.ServerOut.println("stop");
				}

				// Pour fermer explicitement l'application après l'action
				System.exit(0);
			}
		});
	}


	public MenuPanel getMenuPanel()
	{
		return this.pnlCentral;
	}




}
