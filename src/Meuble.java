package tp1;

public class Meuble {
	protected String prix;
	protected String hauteur;
	protected String type;
	protected String directeur;
	
	Meuble(String prix,String hauteur,String type,String directeur){
		this.prix=prix+"($)";
		this.hauteur=hauteur+"(cm)";
		this.type=type;
		this.directeur="ajouté par: "+directeur;
	}
	public String getprix() {
		return this.prix;
	}
	public String gethauteur() {
		return this.hauteur;
	}
	public String gettype() {
		return this.type;
	}
	public String getDirecteur() {
		return this.directeur;
	}
	public String toString() {
		return this.type+"   "+this.hauteur+"   "+this.prix+"   "+this.directeur;
	}
	
}
