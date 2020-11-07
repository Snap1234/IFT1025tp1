
public abstract class Personne {
	String prenom;
	String nom;
	int dateDeNaissance;
	String mail;
	
	public Personne(String prenom, String nom, int dateDeNaissance, String mail) {
		this.prenom = prenom;
		this.nom = nom;
		this.dateDeNaissance = dateDeNaissance;
		this.mail = mail;
	}
	
}
