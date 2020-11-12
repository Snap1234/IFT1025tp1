package tp1;

public class Aliment {
	protected String nom;
	protected String couleur;
	protected String poids;
	protected String directeur;
	
	Aliment(String nom,String poids,String couleur,String directeur){
		this.nom=nom;
		this.couleur=couleur;
		this.poids=poids+"(g)";
		this.directeur="ajouté par: "+directeur;
	}
	
	public String getnom() {
		return this.nom;
	}
	public String getprix() {
		return this.couleur;
	}
	public String getpoids() {
		return this.poids;
	}
	public String toString() {
		return this.nom + "   "+this.poids+"   "+this.couleur + "   "+this.directeur;
	}
	public String getDirecteur() {
		return this.directeur;
	}
	
}

