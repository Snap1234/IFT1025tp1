package tp1;

import java.util.ArrayList;
import java.util.HashMap;

public class Dictaliment {
	// Classe dictionnaire cree dans demo 4
	
	public HashMap<Aliment, Integer> dico;

	public Dictaliment() {
		this.dico = new HashMap();
	}
	
	
	public void ajouterMot(Aliment mot) {
		if (this.dico.containsKey(mot)) {
			this.dico.put(mot, this.dico.get(mot) + 1);
		}
		else {
			this.dico.put(mot, 1);
		}	
	}
	public void enleverMot(Aliment mot) {
		if(this.dico.get(mot)>1) {
			this.dico.put(mot, this.dico.get(mot)-1);
		}
		else {
			this.dico.remove(mot);
		}
	}
	public void enleverTout(ArrayList<Aliment> listaliment) {
		for (Aliment i:listaliment) {
			enleverMot(i);
		}
	}
	public  HashMap<Aliment, Integer> dicoenordre() {
		int a=0;
		for (int i:dico.values()) {
			
		}
		
		return this.dico;
	}
}
