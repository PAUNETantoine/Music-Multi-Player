package dev;

import dev.gui.menu.Menu;

import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class Controleur
{
	private Menu menu;
	public static Socket socket;
	public static PrintWriter ServerOut;
	private int code;

	public Controleur()
	{
		try
		{
			new Thread(new Runnable() {
				@Override
				public void run() {
					connexionServeur();
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

			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			ServerOut = new PrintWriter(socket.getOutputStream(), true);


			while (in.readLine() != null)
			{
				String reponse = in.readLine();
				System.out.println("Réponse du serveur : " + reponse);
			}
		}catch (Exception e)
		{
			this.code = 1;
		}

		return null;
	}
}
