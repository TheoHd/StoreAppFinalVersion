package StoreAppFinalVersion;

import java.util.Scanner;


public class Categorie extends Magasin{
	
	private String nomCategorie;
	private int refCategorie;	
	private Categorie tabCategorie[];
	private Scanner sc = new Scanner(System.in);
	
	public Categorie()
	{
		this.nomCategorie="";
		this.refCategorie=0;
	}
	public void creerCategorie()
	{
		System.out.println("Saisir la référence: ");
		this.refCategorie = sc.nextInt();
		System.out.println("Saisir le nom de la catégorie: ");
		sc.nextLine();
		this.nomCategorie = sc.nextLine();
	}
	public void afficherCategorie()
	{
		System.out.println("Nom: "+this.tabCategorie);
		System.out.println("Référence: "+this.tabCategorie);
	}
	public void afficherToutCategorie()
	{
		for(int i = 0; i< this.refCategorie ; i++)
		{
			System.out.println("element "+i+" : "+this.tabCategorie[i]);
		}
	}
	public void trierCategorie()
	{
		int i,j;
		Categorie temp;
		
		for(i = 0; i < this.refCategorie - 1; i++)
		{
			for(j = i + 1; j < this.refCategorie ; j++)
			{
				if(this.tabCategorie[i].getRefCategorie() > this.tabCategorie[j].getRefCategorie())
				{
					temp = this.tabCategorie[i];
					this.tabCategorie[i] = this.tabCategorie[j];
					this.tabCategorie[j] = temp;
				}
			}
		}
	}
	public void rechercherCategorie()
	{
		int ref;
		int i=0;
		boolean trouve = false;
		System.out.println("Que cherchez-vous ? ");
		ref= sc.nextInt();
		while(trouve == false && i < this.refCategorie)
		{
			if(this.tabCategorie[i].getRefCategorie()== ref)
				trouve = true;
			else
				i++;
		}
		if(trouve == true)
			this.tabCategorie[i].afficherCategorie();
		else
			System.out.println("aucune correspondance");
	}
	public void modifierCategorie()
	{
		int ref;
		int i=0;
		boolean trouve = false;
		System.out.println("Que voulez-vous supprimer ? ");
		ref= sc.nextInt();
		while(trouve == false && i < this.refCategorie)
		{
			if(this.tabCategorie[i].getRefCategorie()== ref)
				trouve = true;
			else
				i++;
		}
		if(trouve == true){
			this.tabCategorie[i] = this.tabCategorie[this.refCategorie-1];
			this.refCategorie--;
		}
		else
			System.out.println("aucune correspondance");
	}
	public void ajouterCategorie()
	{	
		String choix = "Non";
		do
		{
			System.out.println("Confirmer la création? Oui / Non");
			sc.nextLine();
			choix = sc.nextLine();
			Categorie maCategorie = new Categorie();
			maCategorie.creerCategorie();
			sc.nextLine();
			Categorie [] tabCategorie = new Categorie[this.refCategorie];
			tabCategorie[this.refCategorie] = maCategorie;
			this.tabCategorie = tabCategorie;
			this.refCategorie++;
			System.out.println("Confirmer la création? Oui / Non");
			sc.nextLine();
			choix = sc.nextLine();			
		}while(choix != "Non");	
	}
	public void gererCategorie()
	{
		int choix;		
		Categorie categorie = new Categorie();
		Produit produit = new Produit();
		Scanner scMag = new Scanner(System.in);
		do
		{
			System.out.println("------ CATEGORIE ------");
			System.out.println("1: Ajouter catégorie");
			System.out.println("2: Modifier/Supprimer catégorie");
			System.out.println("3: Consulter catégorie");
			System.out.println("4: Ajouter produit");
			System.out.println("5: Modifier/Supprimer produit");
			System.out.println("6: Consulter produit");
			System.out.println("7: Quitter");
			System.out.println("---------------------");
			
			choix = scMag.nextInt();
			
			switch(choix)
			{				
				case 1: categorie.ajouterCategorie();break;
				case 2: categorie.gererCategorie();break;
				case 3: categorie.afficherCategorie();break;
				case 4: produit.ajouterProduit();break;
				case 5: produit.gererProduit();break;
				case 6: produit.afficherProduit();break;
				default: gererMagasin();break;
				
			}
		}
		while(choix!=0);
		scMag.close();
	}
	public String getNomCategorie()
	{
		return this.nomCategorie;
	}
	public int getRefCategorie()
	{
		return this.refCategorie;
	}	
	public void setNomCategorie(String nomCategorie)
	{
		this.nomCategorie = nomCategorie;
	}
	public void setRefCategorie(int refCategorie)
	{
		this.refCategorie = refCategorie;
	}
	public void afficherTableau(Categorie tabCategorie)
	{
		System.out.println(this.tabCategorie);
	}
}