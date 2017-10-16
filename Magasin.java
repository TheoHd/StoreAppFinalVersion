package StoreAppFinalVersion;
import java.util.Scanner;

public class Magasin {
	
	private String nomMagasin;
	private String proprietaire;
	private int refMagasin;	
	private int refTabMagasin[];
	private String nmTabMagasin[];
	private String ppTabMagasin[];
	private Scanner sc = new Scanner(System.in);
	
	public Magasin(){
		this.proprietaire="";
		this.refMagasin=0;
		this.nomMagasin="";
	}
	public void gererMagasin()
	{
		int choix;		
		Categorie categorie = new Categorie();
		Produit produit = new Produit();
		Magasin magasin = new Magasin();
		
		do
		{
			System.out.println("------ MAGASIN ------");
			System.out.println("1: Ajouter magasin");
			System.out.println("2: Supprimer magasin");
			System.out.println("3: Consulter magasin");
			System.out.println("4: Afficher magasin");
			System.out.println("5: Gérer catégorie");
			System.out.println("6: Quitter");
			System.out.println("---------------------");
			
			choix = sc.nextInt();
			
			switch(choix)
			{				
				case 1: magasin.ajouterMagasin();break;
				case 2: magasin.supprimerMagasin();break;
				case 3: magasin.consulterMagasin();break;
				case 4: magasin.afficherMagasin(this.getRefTabMagasin(),this.getNmTabMagasin(),this.getPpTabMagasin());break;
				case 5: categorie.gererCategorie();break;
				case 6: produit.afficherProduit();break;
				default: gererMagasin();break;
				
			}
		}
		while(choix!=0);
	}
	
	public void ajouterMagasin()
	{
		sc.nextLine();
		System.out.println("Saisir le nom du propriétaire:");
        this.proprietaire = sc.nextLine();
        System.out.println("Saisir la référence du magasin:");
        this.refMagasin = sc.nextInt();
        System.out.println("Saisir le nom du magasin:");
        this.nomMagasin = sc.nextLine();
        @SuppressWarnings("unused")
		int refTabMagasin[] = {this.refMagasin};
        @SuppressWarnings("unused")
		String nmTabMagasin[] = {this.nomMagasin};
        @SuppressWarnings("unused")
		String ppTabMagasin[] = {this.proprietaire};        
	}
	public void afficherMagasin(int refTabMagasin[],String nmTabMagasin[],String ppTabMagasin[])
	{		
		int ref;
		String nom;
		String pp;
		ref = refTabMagasin[this.refMagasin];
		nom = nmTabMagasin[this.refMagasin];
		pp = ppTabMagasin[this.refMagasin];
		System.out.println("Référence: "+ref);
		System.out.println("Nom du magasin: "+nom);
		System.out.println("Propriétaire: " +pp);
	}
	public void consulterMagasin(){
	    int ref;
	    int refCat;	    
	    Categorie refCategorie = new Categorie();
	    refCat = refCategorie.getRefCategorie();
	    int i = 0;
	    boolean trouve = false;
	    
	    System.out.println("Que cherchez-vous ? ");
	    ref = sc.nextInt();
	    
	    while(trouve == false && i < refCat)
	    {
	    	if(this.refTabMagasin[i] == ref)
	    	{
	    		trouve = true; 
	    	}
	        else
	        {
	        	i++; 
	        }
	    }	
	    if(trouve == true)
	    {
	    	System.out.println("Référence du magasin :" + getRefTabMagasin());
	    	System.out.println("Nom du magasin :" + getNmTabMagasin());
	    	System.out.println("Propriétaire du magasin :" + getPpTabMagasin());
	    }
	    else
	    {
	    	System.out.println("Aucune correspondance.");
	    }
	    
	    
	}
	public void supprimerMagasin(){
		
	}
	public void gererCategorie(){
		Categorie categorie = new Categorie();
		categorie.gererCategorie();
	}
	
	public String getNomMagasin() {
		return nomMagasin;
	}

	public void setNomMagasin(String nomMagasin) {
		this.nomMagasin = nomMagasin;
	}

	public String getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}

	public int getRefMagasin() {
		return refMagasin;
	}
	public void setRefMagasin(int refMagasin) {
		this.refMagasin = refMagasin;
	}
	public int[] getRefTabMagasin() {
		return refTabMagasin;
	}
	public String[] getNmTabMagasin() {
		return nmTabMagasin;
	}
	public String[] getPpTabMagasin() {
		return ppTabMagasin;
	}
}
