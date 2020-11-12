package tp1;

import java.util.ArrayList;
import java.util.HashMap;

public class Dictmeuble {
	// Classe dictionnaire cree dans demo 4
	
	public HashMap<Meuble, Integer> dico;

	public Dictmeuble() {
		this.dico = new HashMap();
	}
	
	
	public void ajouterMot(Meuble mot) {
		if (this.dico.containsKey(mot)) {
			this.dico.put(mot, this.dico.get(mot) + 1);
		}
		else {
			this.dico.put(mot, 1);
		}	
	}
	public void enleverMot(Meuble mot) {
		if(this.dico.get(mot)>1) {
			this.dico.put(mot, this.dico.get(mot)-1);
		}
		else {
			this.dico.remove(mot);
		}
	}

	public void enleverTout(ArrayList<Meuble> listaliment) {
		for (Meuble i:listaliment) {
			enleverMot(i);
		}
		
	}
}
