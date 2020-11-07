
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
	public static String addressMail(String nom, String prenom) {
		String capitalNom = nom.substring(0, 1).toUpperCase() + nom.substring(1);
		String capitalPrenom = nom.substring(0, 1).toUpperCase() + prenom.substring(1);
		String adressMail = "address mail est = " + capitalNom + capitalPrenom + "@magasin.ca";
		return adressMail;
	}
}
