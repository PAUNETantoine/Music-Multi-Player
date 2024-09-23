package dev;

import dev.gui.menu.FenetrePrincipale;
import dev.gui.menu.Menu;
import dev.gui.menu.PrincipalPanel;
import javazoom.jl.player.Player;

import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class Controleur
{
	private Menu menu;
	private FenetrePrincipale fntrPrincipal;
	public static Socket socket;
	public static PrintWriter ServerOut;
	public static BufferedReader ServerIn;
	private int code;
	private String[] args;

	public Controleur()
	{
		try
		{
			new Thread(new Runnable() {
				@Override
				public void run()
				{
					while(true)
					{
						connexionServeur();
					}
				}
			}).start();

			SwingUtilities.invokeLater(new Runnable()
			{
				@Override
				public void run()
				{
					menu = new Menu(code);
				}
			});


		}catch (Exception e)
		{
			this.menu = new Menu(1);
		}
	}

	public Runnable connexionServeur()
	{
		try {
			socket = new Socket("localhost", 8080);
			this.code = 0;

			ServerIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			ServerOut = new PrintWriter(socket.getOutputStream(), true);

			String reponse;
			while ((reponse = ServerIn.readLine()) != null)
			{
				System.out.println("Réponse du serveur : " + reponse);


				args = reponse.split(" ");


				switch (args[0])
				{
					case "inscription" : {
						if (args[1].contains("true"))
						{
							System.out.println("Inscription réussie");
							this.menu.getMenuPanel().getInscriptionFrame().dispose();
						}else{
							menu.getMenuPanel().setLblErreurI("nom d'utilisateur déjà pris");
						}
						break;
					}
					case "connexion" : {
						if(args[1].contains("true"))
						{
							System.out.println("Connexion réussie");
							this.menu.dispose();
							this.fntrPrincipal = new FenetrePrincipale(args[2]);
						}else{
							System.out.println("Nom d'utilisateur ou mot de passe incorrect");
							menu.getMenuPanel().setLblErreur("Nom d'utilisateur ou mot de passe incorrect.");
						}
						break;
					}
					default: break;
				}

			}
		}catch (Exception e)
		{
			this.code = 1;
		}

		return null;
	}
}
