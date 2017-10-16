package StoreAppFinalVersion;
import java.util.Scanner;

public class Produit extends Magasin{

	private int nbProduit;
	private int quantite;
	private String ref_produit,designation;
	private float prix;
	private Produit tabProduit[];
	private Scanner sc = new Scanner(System.in);
	
	public Produit()
	{
		this.designation = "";
		this.ref_produit = "";
		this.prix = 0;
		this.quantite = 0;
	}
	public void gererProduit()
	{
		int choix;
		do
		{
			System.out.println("------ PRODUIT ------");
			System.out.println("1:Ajouter produit");
			System.out.println("2:Consulter les produits");
			System.out.println("3:Supprimer un produit");
			System.out.println("4:Trier les produits");
			System.out.println("5:Tout afficher");
			System.out.println("6:Quitter");
			System.out.println("---------------------");
			choix = sc.nextInt();
			
			switch(choix)
			{
				case 1: this.ajouterProduit();break;
				case 2: this.afficherProduit();break;
				case 3: this.supprimerProduit();break;
				case 4: this.trierProduit();break;
				case 5: this.afficherToutProduit();break;
				
			}
		}
		while(choix!=0);
	}
	public void total_qte()
	{
		
	}
	public void total_prix()
	{
		
	}
	public void saisir()
	{
		System.out.println("Saisir ref: ");
		this.ref_produit = sc.nextLine();
		System.out.println("Saisir designation");
		this.designation = sc.nextLine();
		System.out.println("Saisir prix: ");
		this.prix = sc.nextFloat();
		System.out.println("Saisir quantite: ");
		this.quantite = sc.nextInt();
	}
	public void rechercherProduit()
	{
		System.out.println("Saisir ref: "+this.ref_produit);
		System.out.println("Saisir designation: "+this.designation);
		System.out.println("Saisir prix: "+this.prix);
		System.out.println("Saisir quantite: "+this.quantite);
	}
	public void afficherProduit()
	{
		System.out.println(tabProduit);
	}
	public void afficherToutProduit()
	{
		System.out.println("");
	}
	public void ajouterProduit ()
	{		
		String choix = "Non";
		do
		{
			Produit mon_produit = new Produit();
			mon_produit.saisir();
			this.tabProduit[this.nbProduit] = mon_produit;
			this.nbProduit++;
			System.out.println("Continuez? Oui / Non");
			choix = sc.nextLine();
		}while(choix != "Non");
	}
	public int getNbProduit()
	{
		return this.nbProduit;
	}
	public void setnbProduit(int nbProduit)
	{
		this.nbProduit = nbProduit;
	}
	public void quantiteProduit()
	{
		int qte = 0;
		for(int i = 0; i > this.nbProduit; i++)
		{
			qte = qte+this.tabProduit[i].getQuantite();
		}
		System.out.println("Quantité: "+qte);
	}
	public void trierProduit()
	{
		int i,j;
		Produit temp;
		
		for(i = 0; i < this.nbProduit -1; i++)
		{
			for(j = i + 1; j < this.nbProduit ; j++)
			{
				if(this.tabProduit[i].getPrix() > this.tabProduit[j].getPrix())
				{
					temp = this.tabProduit[i];
					this.tabProduit[i] = this.tabProduit[j];
					this.tabProduit[j] = temp;
				}
			}
		}
	}
	public void supprimerProduit()
	{
		String ref;
		int i=0;
		boolean trouve = false;
		System.out.println("Que voulez-vous supprimer ? ");
		ref= sc.nextLine();
		while(trouve == false && i < this.nbProduit)
		{
			if(this.tabProduit[i].getRef_produit()== ref)
				trouve = true;
			else
				i++;
		}
		if(trouve == true){
			this.tabProduit[i] = this.tabProduit[this.nbProduit-1];
			this.nbProduit--;
		}
		else
			System.out.println("aucune correspondance");
	}
	public void total_prixProduit()
	{
		float total = 0;
		for(int i = 0; i > this.nbProduit; i++)
		{
			total = total+this.tabProduit[i].getPrix();
		}
		System.out.println("Total: "+total);
	}
	
	public String getRef_produit()
	{
		return this.ref_produit;
	}
	public String getDesignation()
	{
		return this.designation;
	}
	public int getQuantite()
	{
		return this.quantite;
	}
	public float getPrix()
	{
		return this.prix;
	}
	
	public void setQuantite(int quantite)
	{
		this.quantite = quantite;
	}
	public void setDesignation(String designation)
	{
		this.designation = designation;
	}
	public void setPrix(Float prix)
	{
		this.prix = prix;
	}
	public void setRef_produit(String ref_produit)
	{
		this.ref_produit = ref_produit;
	}
}
