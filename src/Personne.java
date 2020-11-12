package tp1;

import java.util.ArrayList;

public class Personne {
	protected String  prenom;
	protected String nom;
	protected String dateDeNaissance;
	protected String mail;
	protected double fonds;
	protected ArrayList<Aliment> alimentpref = new ArrayList<Aliment>();
	protected ArrayList<Meuble> meublepref = new ArrayList<Meuble>();
	protected String status;
	
	public Personne(String prenom, String nom, String dateDeNaissance, String status) {
		
		this.setMail(nom, prenom);
		this.prenom = prenom;
		this.nom = nom;
		this.dateDeNaissance = dateDeNaissance;	
		this.fonds=0;
		this.status=status;
	}
	
	public String getNaissance() {
		return this.dateDeNaissance;
		
	}
	public void setNaissance(String date) {
		this.dateDeNaissance=date;
	}
	public String toString() {
		return this.mail+"   "+this.dateDeNaissance+"   "+this.status+"   "+this.fonds+" $";
	}
	
	public String getNom() {
		return this.nom;
	};
	public void setNom(String nom) {
		this.nom=nom;
		this.setMail(nom,this.prenom);
	}
	public String getPrenom() {
		return this.prenom;
	};
	public void setPrenom(String prenom) {
		this.prenom=prenom;
		this.setMail(this.nom, prenom);
	}
	
	public double getMoney() {
		return this.fonds;
	};
	
	public ArrayList<Aliment> getAlimentPref() {
		return this.alimentpref;
	};
	
	public void addAlimentPref(Aliment A) {
		this.alimentpref.add(A);
	};
	
	public void subAlimentPref(int i) {
		this.alimentpref.remove(i);
	};
	
	public ArrayList<Meuble> getMeublePref(){
		return this.meublepref;
	};
	
	public void addMeublePref (Meuble M) {
		this.meublepref.add(M);
	};
	
	public void subMeublePref (int i) {
		this.meublepref.remove(i);
	};
	
	public void addMoney(double add) {
		if(add>0){
			this.fonds += add;
		}
	}
	
	public void takeMoney(double sub) {
		if(sub>0) {
			this.fonds -=sub;
		}
		
	}
	public String getStatus() {
		return this.status;
	}
	public String getMail() {
		return this.mail;
	};
	
	public void setStatus(String status) {
		this.status=status;
	}

	
	public void setMail(String nom, String prenom) {
		String capitalNom = nom.substring(0, 1).toUpperCase() + nom.substring(1);
		String capitalPrenom = prenom.substring(0, 1).toUpperCase() + prenom.substring(1);
		
		this.mail =capitalNom + capitalPrenom + "@magasin.ca";
	}
}

