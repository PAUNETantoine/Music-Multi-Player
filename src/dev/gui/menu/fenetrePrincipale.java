package dev.gui.menu;

import dev.Controleur;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FenetrePrincipale extends JFrame
{

	private PrincipalPanel prcplPnl;

	public FenetrePrincipale(String username)
	{
		this.setSize(1000, 800);
		this.setResizable(false);
		this.setTitle("Music Multi Player - " + username + " - Lecteur");
		this.setLocationRelativeTo(null);

		this.prcplPnl = new PrincipalPanel();


		this.add(this.prcplPnl);
		this.setVisible(true);


		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				// Fonction appelée lors du clic sur la croix
				Controleur.ServerOut.println("stop");

				System.exit(0);
			}
		});
	}
}
