package dev.metier;

import dev.Controleur;

import java.util.Arrays;

public class Connexion
{

	private String nomUtilisateur;
	private String mdp;
	private boolean estConnecter;

	public Connexion(String nomUtilisateur, char[] mdp)
	{
		this.nomUtilisateur = nomUtilisateur;
		this.mdp = "";

		for (char c : mdp)
		{
			this.mdp = this.mdp + c;
		}

		this.essaieMdp();
	}

	public boolean essaieMdp()
	{
		Controleur.ServerOut.println("connexion " + this.nomUtilisateur + " " + this.mdp);
		return true;
	}


	public boolean getEstConnecter()
	{
		return this.estConnecter;
	}
}
