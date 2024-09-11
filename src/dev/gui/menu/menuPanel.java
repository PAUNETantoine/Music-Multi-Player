package dev.gui.menu;

import dev.metier.Connexion;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.image.BufferedImage;
import java.io.File;

public class menuPanel extends JPanel implements ActionListener
{
	private BufferedImage logo;

	private JTextField txtNomUtilisateur;
	private JPasswordField txtMotDePasse;

	private JLabel lblErreur;
	private JLabel lblTxtNomUser;
	private JLabel lblTxtMdp;

	private JButton btnConnexion;

	public menuPanel(int code)
	{
		this.setBackground(Color.GRAY);

		this.setLayout(null);

		try{
			this.logo = ImageIO.read(new File("src/files/images/Music Multi Player Logo1.png"));
		}catch (Exception e)
		{
			System.out.println("Erreur de lecture de l'image logo");
		}


		this.lblErreur 			= new JLabel();
		this.txtNomUtilisateur 	= new JTextField();
		this.txtMotDePasse 		= new JPasswordField(30);
		this.btnConnexion		= new JButton("Se connecter");



		if (code != 0)// Si erreur on affiche que la connexion au serveur n'a pas aboutie
		{
			this.lblErreur.setText("Erreur de connexion au serveur, veuillez ressayer...");
			this.lblErreur.setBounds(350, 280, 350, 30);
			this.add(this.lblErreur);
			return;
		}

		this.lblTxtNomUser		= new JLabel("Nom d'utilisateur :");
		this.lblTxtMdp			= new JLabel("Mot de passe :");

		this.txtNomUtilisateur.setBounds(365, 280, 250, 30);
		this.lblTxtNomUser.setBounds(this.txtNomUtilisateur.getX(), this.txtNomUtilisateur.getY() - 30, 250, 30);
		this.txtMotDePasse.setBounds(365, 350, 250, 30);
		this.lblTxtMdp.setBounds(this.txtMotDePasse.getX(), this.txtMotDePasse.getY() - 30, 250, 30);
		this.btnConnexion.setBounds(this.lblTxtMdp.getX() + 55, this.lblTxtMdp.getY() + 75, 130, 40);

		this.setFocusable(true);
		this.requestFocusInWindow();

		this.add(this.txtNomUtilisateur);
		this.add(this.txtMotDePasse);
		this.add(this.lblTxtNomUser);
		this.add(this.lblTxtMdp);
		this.add(this.btnConnexion);


		this.btnConnexion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				sendConnexion();
			}
		});
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		g.drawImage(this.logo,  super.getWidth()/2 - this.logo.getWidth()/2, 50, this);
	}


	public void sendConnexion()
	{
		Connexion connexion = new Connexion(this.txtNomUtilisateur.getText(), this.txtMotDePasse.getPassword());

		System.out.println("Ok");

		if (connexion.getEstConnecter()){return;}

		this.lblErreur.setText("Nom d'utilisateur ou mot de passe incorrect.");
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{

	}
}
