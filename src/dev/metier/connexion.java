package dev.metier;

public class Connexion
{

	private String nomUtilisateur;
	private char[] mdp;
	private boolean estConnecter;

	public Connexion(String nomUtilisateur, char[] mdp)
	{
		this.nomUtilisateur = nomUtilisateur;
		this.mdp = mdp;


		this.estConnecter = true;
	}


	public boolean getEstConnecter()
	{
		return this.estConnecter;
	}
}
