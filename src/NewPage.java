package tp1;
import java.lang.reflect.Field;

import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


abstract class NewPage {
	static ArrayList <Personne> repertoir = new ArrayList<Personne>();
	static Personne loggedinas;// le compte qui s'est enregistre
	static int i; //le compte de la personne selectionne. son indice de positionnement dans repertoir.
	static ArrayList <Aliment> arrayaliment = new ArrayList <Aliment>(); // la liste des produits disponibles
	static ArrayList <Meuble> arraymeuble = new ArrayList <Meuble>();
	static Dictaliment alimentpref= new Dictaliment();
	static Dictmeuble meublepref = new Dictmeuble();
	
	public NewPage() {};
	
	public static Personne select() {
		return repertoir.get(i);
	}
	//Pour aerer le code en modifiant la personne selectionne
	
	
	public static void resetpage(JFrame f) {
		f.getContentPane().removeAll();
		f.repaint();
		f.setSize(400, 400);
		f.getContentPane().setLayout(null);
	}
	//pour aerer le code en preparant une nouvelle page
	
	
	
	public static void initialisation(JFrame f,JPanel pane) {
		
		arrayaliment.add(new Aliment("pomme","150","rouge","Directeur Prenom"));
		arrayaliment.add(new Aliment("banane","98","jaune","Directeur Prenom")); // pour donner des produits par defauts a l'epicerie
		arraymeuble.add(new Meuble("125","125","chaise","Directeur Prenom"));
		arraymeuble.add(new Meuble("725","75","table","Directeur Prenom"));
		
		Personne temp = new Personne("Prenom","Nom","12/11/1986","client");
		repertoir.add(new Personne("Prenom","Directeur","07/10/1967","directeur"));
		repertoir.add(temp);
		i=repertoir.indexOf(temp);
		
		Aliment tempA = new Aliment("orange","68","orange","Directeur Prenom");
		select().addAlimentPref(tempA);
		alimentpref.ajouterMot(tempA);
		arrayaliment.add(tempA);
		
		Meuble tempM = new Meuble("550","55","sofa","Directeur Prenom");
		select().addMeublePref(tempM);
		meublepref.ajouterMot(tempM);
		arraymeuble.add(tempM);
		
		
		
		Login(f,pane);
	}
	
	public static void Login(JFrame f,JPanel pane) {
		resetpage(f);
		f.setTitle("accueil");
		
		
		JLabel log = new JLabel();;
		JTextField username = new JTextField();
		JLabel endmail = new JLabel();
		JLabel titre = new JLabel();
		JLabel exemple1= new JLabel();
		JLabel exemple2 = new JLabel();
		
		JButton inscrit = new JButton();
		JButton entrer = new JButton();
		
		
		class click implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if(inscrit==e.getSource()) {
					inscription(f,pane);
				}
				else if (entrer==e.getSource()) {
					for (Personne p:repertoir) {
						if (p.getMail().equals(username.getText()+endmail.getText())) {
							loggedinas=p;
							gerer_client(f,pane);
							break;
							}
					}
				}
			}
		}
		
		
		
		entrer.addActionListener(new click());
		entrer.setText("entrer");
		entrer.setBounds(120,195,100,20);
		pane.add(entrer);
		
		
		
		inscrit.addActionListener(new click());
		inscrit.setText("s'inscrire");
		inscrit.setBounds(120,250,100,50);
		pane.add(inscrit);
		
		
		exemple1.setText("exemple 1: NomPrenom@magasin.ca");
		exemple1.setBounds(65,300,250,25);
		pane.add(exemple1);
		
		
		exemple2.setText("exemple 2: DirecteurPrenom@magasin.ca");
		exemple2.setBounds(65,325,250,25);
		pane.add(exemple2);
		
		titre.setText("Projet fidélité");
		titre.setFont(titre.getFont().deriveFont(18.0f));
		titre.setBounds(110, 50, 200, 100);
		pane.add(titre);
		
		
		username.setText("DirecteurPrenom");
		username.setBounds(120,175,100,20);
		pane.add(username);
	
		log.setText("login:");
		log.setBounds(80,175,50,20);
		pane.add(log);
		
		
		endmail.setText("@magasin.ca");
		endmail.setBounds(220,175,100,20);
		pane.add(endmail);
		
		
		
	}
	public static void inscription(JFrame f,JPanel pane) {
		
		resetpage(f);
		
		
		
		JLabel titre = new JLabel("inscription");
		
		JLabel nom = new JLabel("nom:");
		JTextField getnom = new JTextField();
		JLabel prenom = new JLabel("prénom:");
		JTextField getprenom = new JTextField();
		JLabel naissance = new JLabel("date de naissance:");
		JTextField getnaissance = new JTextField();
		
		JLabel identite = new JLabel("s'inscire en tant que:");
		JButton client = new JButton("client");
		JButton employe = new JButton("employé");
		JButton directeur = new JButton("directeur");
		JButton retour =  new JButton("retour");
		
		
		
		class click implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				
				
				if (retour==e.getSource()) {
					Login(f,pane);
				}
				
				
			
				
				else if (!getprenom.getText().equals("")&& !getnom.getText().equals("")&& !getnaissance.getText().equals("") ) {
					for (int i = 0; i < getnom.getText().length(); i++) {
				         if (!Character.isLetter(getnom.getText().charAt(i)))
				        	 JOptionPane.showMessageDialog(f,
				        			    "Nom invalide, enlevez les caracteres speciaux");
				   }
				   
				   for (int i = 0; i < getprenom.getText().length(); i++) {
				         if (!Character.isLetter(getprenom.getText().charAt(i)))
				        	 JOptionPane.showMessageDialog(f,
				        			    "Prenom invalide, enlevez les caracteres speciaux");
				        	 
				   }
	
					
					if		(client==e.getSource()) {
						
						Personne p = new Personne(getprenom.getText(),getnom.getText(),getnaissance.getText(),"client");
						repertoir.add(p);
						
					}
					else if (employe==e.getSource()) {
						
						if (employe.getText()=="retour") {	// Le bouton est modifié. l'inscription est complété. Retournons à la page Login.
							
							
							Login(f,pane);
							
							
						}
						else {
							Personne p = new Personne(getprenom.getText(),getnom.getText(),getnaissance.getText(),"employe");
							repertoir.add(p);
						}
					}
					else if (directeur==e.getSource()) {
						Personne p = new Personne(getprenom.getText(),getnom.getText(),getnaissance.getText(),"directeur");
						repertoir.add(p);
					}
					
					
					pane.remove(directeur);
					pane.remove(client);
					
					identite.setText("Inscription terminée. Bienvenue.");
					identite.setBounds(105,160,200,50);
					
					employe.setText("retour");
					
					f.repaint();
				}
			}
		}	
		
		
		
		
		retour.addActionListener(new click());
		retour.setBounds(0,0,100,25);
		pane.add(retour);
		
		titre.setBounds(160,10,100,20);
		pane.add(titre);
		
		nom.setBounds(10,60,130,20);
		pane.add(nom);
		
		getnom.setBounds(140,60,100,20);
		pane.add(getnom);
		
		prenom.setBounds(10,90,130,20);
		pane.add(prenom);
		
		getprenom.setBounds(140,90,100,20);
		pane.add(getprenom);
		
		naissance.setBounds(10,120,130,20);
		pane.add(naissance);
		
		getnaissance.setBounds(140,120,100,20);
		pane.add(getnaissance);
		
	
		identite.setBounds(130,160,150,50);
		pane.add(identite);
		
		client.addActionListener(new click());
		client.setBounds(20,200,100,25);
		pane.add(client);
		
		employe.addActionListener(new click());
		employe.setBounds(140,200,100,25);
		pane.add(employe);
		
		directeur.addActionListener(new click());
		directeur.setBounds(260,200,100,25);
		pane.add(directeur);
				
		
		
	}
	public static void client(JFrame f,JPanel pane) {
		
		resetpage(f);
		//f.setTitle(loggedinas.getMail()+" compte client");
		
		JButton retour = new JButton("retour");
		retour.setBounds(0,0,100,25);
		pane.add(retour);
		
		JButton ajout = new JButton("ajouter des fonds");
		ajout.setBounds(250,0,150,25);
		pane.add(ajout);
		
		JButton buttonaliment = new JButton("aliment");
		buttonaliment.setBounds(0,275,95,25);
		pane.add(buttonaliment);
		
		JButton buttonmeuble = new JButton("meuble");
		buttonmeuble.setBounds(95,275,95,25);
		pane.add(buttonmeuble);
		
		JButton deletecompte = new JButton("effacer ce compte");
		deletecompte.setBounds(225,320,150,25);
		pane.add(deletecompte);
		
		JButton gerer = new JButton("gérer détails du compte");
		gerer.setBounds(15,320,200,25);
		pane.add(gerer);
		//creation des boutons
		
		
		
		JLabel dispo = new JLabel("meubles disponibles");
		dispo.setBounds(25,50,150,25);
		pane.add(dispo);
		
		JLabel pref = new JLabel("meubles préférés");
		pref.setBounds(225,50,150,25);
		pane.add(pref);
		
		
		
		ArrayList<Aliment> dataaliment=(ArrayList)arrayaliment.clone();
		ArrayList<Meuble> datameuble=(ArrayList)arraymeuble.clone();
		
		
		//on fait une instance des arcticles dipsonnibles pour ne pas modifier la vrai liste
		
		for(Aliment A:select().getAlimentPref()) dataaliment.remove(A);
		for(Meuble M:select().getMeublePref()) datameuble.remove(M);
		
		JList listmeuble = new JList(datameuble.toArray()) ;
		JScrollPane scrollermeuble = new JScrollPane(listmeuble);
		scrollermeuble.setBounds(0, 75, 190, 200);
		pane.add(scrollermeuble);
		
		
		
		JList listaliment = new JList(dataaliment.toArray()) ;
		JScrollPane scrolleraliment = new JScrollPane(listaliment);
		scrolleraliment.setBounds(0, 75, 190, 200);
		pane.add(scrolleraliment);
		
		
		
		JList listmeublelike = new JList( select().getMeublePref().toArray()) ;
		JScrollPane scrollermeublelike = new JScrollPane(listmeublelike);
		scrollermeublelike.setBounds(190, 75, 190, 200);
		pane.add(scrollermeublelike);
		
		
		
		JList listalimentlike = new JList(select().getAlimentPref().toArray()) ;
		JScrollPane scrolleralimentlike = new JScrollPane(listalimentlike);
		scrolleralimentlike.setBounds(190, 75, 190, 200);
		pane.add(scrolleralimentlike);
		//creation des tableau de liste et les listes des produits preferes
		
		f.revalidate();
		
		
		
		class choose implements ListSelectionListener{// reagit a l'objet de la liste qui est selectionne
			public void valueChanged(ListSelectionEvent e) { 
				// On cherche à échanger les éléments des listes lorsque sélectionné. 
				
				
				if(listmeuble.getSelectedIndex()!=-1) {
					int ii = listmeuble.getSelectedIndex();
					
					meublepref.ajouterMot(datameuble.get(ii));//on ajoute au dictionnaire 
					select().addMeublePref(datameuble.get(ii));// et dans la liste personnel des individus
					datameuble.remove(ii);
				
					listmeuble.setListData(datameuble.toArray());
					listmeublelike.setListData(select().getMeublePref().toArray());
					f.repaint();
				}
				else if(listmeublelike.getSelectedIndex()!=-1) {
					int ii = listmeublelike.getSelectedIndex();
					
					meublepref.enleverMot(select().getMeublePref().get(ii));
					datameuble.add(select().getMeublePref().get(ii));
					select().subMeublePref(ii);
					
					listmeublelike.setListData(select().getMeublePref().toArray());
					listmeuble.setListData(datameuble.toArray());
					f.repaint();
				
				}
				
				else if(listaliment.getSelectedIndex()!=-1) {
					int ii = listaliment.getSelectedIndex();
					
					alimentpref.ajouterMot(dataaliment.get(ii));
					select().addAlimentPref(dataaliment.get(ii));		
					dataaliment.remove(ii);
					
					listaliment.setListData(dataaliment.toArray());
					listalimentlike.setListData(select().getAlimentPref().toArray());
					f.repaint();
				}
				else if(listalimentlike.getSelectedIndex()!=-1) {
					int ii = listalimentlike.getSelectedIndex();
					
					alimentpref.enleverMot(select().getAlimentPref().get(ii));
					dataaliment.add(select().getAlimentPref().get(ii));
					select().subAlimentPref(ii);
					
					listalimentlike.setListData(select().getAlimentPref().toArray());
					listaliment.setListData(dataaliment.toArray());
					f.repaint();
				
				}
				
			}

		}	
		class click implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource()==buttonmeuble) {
					pane.remove(scrolleraliment);
					pane.remove(scrolleralimentlike);
					pane.add(scrollermeuble);
					pane.add(scrollermeublelike);
					
					dispo.setText("meubles disponibles");
					pref.setText("meubles préférés");
					
					f.repaint();
				//interchanger les boites d'aliments et de meubles	
					
				}
				else if (e.getSource()==buttonaliment) {
					pane.remove(scrollermeuble);
					pane.remove(scrollermeublelike);
					pane.add(scrolleraliment);
					pane.add(scrolleralimentlike);
					
					dispo.setText("aliments disponibles");
					pref.setText("aliments préférés");
					
					f.repaint();
				}
				else if(e.getSource()==retour) gerer_client(f,pane);// retour a la page principale
				
				else if (e.getSource()==ajout) liquidite();//pop-up pour ajouter des fonds
				
				else if (e.getSource()==deletecompte) effacercompte(f,pane); //pop-up pour confirmer
				
				else if (e.getSource()==gerer) gestion(f,pane);
				
			}
		}		
		
		
		listmeuble.addListSelectionListener(new choose());
		listmeublelike.addListSelectionListener(new choose());
		listaliment.addListSelectionListener(new choose());
		listalimentlike.addListSelectionListener(new choose());
		
		ajout.addActionListener(new click());
		retour.addActionListener(new click());
		buttonmeuble.addActionListener(new click());
		buttonaliment.addActionListener(new click());
		deletecompte.addActionListener(new click());
		gerer.addActionListener(new click());
		}	
		//on ajoute tous les listener de la page	
		
	public static void effacercompte(JFrame f, JPanel pane) {
		
		JFrame f3 = new JFrame();
		
		JPanel pane3= (JPanel)f3.getContentPane();
		f3.setSize(300, 100);
		f3.getContentPane().setLayout(null);
		f3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f3.setVisible(true);
		
		JLabel avertissement = new JLabel("Êtes-vous sûr de vouloir effacer votre compte?");
		JButton oui = new JButton("oui");
		JButton non = new JButton("non");
		
		avertissement.setBounds(0,0,300,20);
		pane3.add(avertissement);
		
		oui.setBounds(50,20,60,20);
		pane3.add(oui);
		
		non.setBounds(150,20,60,20);
		pane3.add(non);
		
		
		class click implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==oui) {
					if (oui.getText()!="ok") {
						pane3.remove(non);
						oui.setBounds(100,20,60,20);
						oui.setText("ok");
						avertissement.setText("votre compte à été effacé.");	
						avertissement.setBounds(60,0,200,20);
						
					}
					
					else {
						f3.dispose();
						alimentpref.enleverTout(select().getAlimentPref());
						meublepref.enleverTout(select().getMeublePref());
						repertoir.remove(select());    //on efface le compte ici
						
						Login(f,pane);
					}
				}
				else if(e.getSource()==non) {
					f3.dispose();
				}
			}
		}
		
		oui.addActionListener(new click());
		non.addActionListener(new click());
	}
	public static void epicerie(JFrame f, JPanel pane) { //ici le directeur pourra choisir les produits de son epicerie
		resetpage(f);
		
		
		
		JButton retour = new JButton("retour");
		retour.setBounds(0,0,100,25);
		pane.add(retour);
		
		JButton buttonaliment = new JButton("aliment");
		buttonaliment.setBounds(0,50,95,25);
		pane.add(buttonaliment);
		
		JButton buttonmeuble = new JButton("meuble");
		buttonmeuble.setBounds(95,50,95,25);
		pane.add(buttonmeuble);
		
		JButton produitspref = new JButton("les produits préférés");
		produitspref.setBounds(95,295,190,25);
		pane.add(produitspref);
		
		
		
		JLabel type = new JLabel("type:");
		type.setBounds(200,75,75,20);
		pane.add(type);
		
		JLabel prixmeuble = new JLabel("prix:");
		prixmeuble.setBounds(200,115,75,20);
		pane.add(prixmeuble);
		
		
		
		JLabel hauteur = new JLabel("hauteur:");
		hauteur.setBounds(200,155,75,20);
		pane.add(hauteur);
		
		
		
		JLabel nom = new JLabel("nom:");
		nom.setBounds(200,75,75,20);
		
		
		
		JLabel poids = new JLabel("poids:");
		poids.setBounds(200,115,75,20);
		
		
		
		JLabel prixaliment = new JLabel("prix:");
		prixaliment.setBounds(200,155,75,20);
		
		
		
		JTextField ligne1 = new JTextField();
		ligne1.setBounds(260,75,90,20);
		pane.add(ligne1);
		
		JTextField ligne2 = new JTextField();
		ligne2.setBounds(260,115,90,20);
		pane.add(ligne2);
		
		JTextField ligne3 = new JTextField();
		ligne3.setBounds(260,155,90,20);
		pane.add(ligne3);
		
		
		
		
		JButton ajoutermeuble = new JButton("ajouter ce meuble");
		ajoutermeuble.setBounds(200,200,150,20);
		pane.add(ajoutermeuble);
		
		JButton ajouteraliment = new JButton("ajouter cet aliment");
		ajouteraliment.setBounds(200,200,150,20);
		
		


		JList listmeuble = new JList( arraymeuble.toArray()) ;
		JScrollPane scrollermeuble = new JScrollPane(listmeuble);
		scrollermeuble.setBounds(0, 75, 190, 200);
		pane.add(scrollermeuble);
		
		
		
		JList listaliment = new JList(arrayaliment.toArray()) ;
		JScrollPane scrolleraliment = new JScrollPane(listaliment);
		scrolleraliment.setBounds(0, 75, 190, 200);
		pane.add(scrolleraliment);
		
		
		class click implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource()==retour) gerer_client(f,pane);
				
				else if(e.getSource()==produitspref) pref(f,pane);
				
				else if (e.getSource()==buttonmeuble) {
					pane.remove(scrolleraliment);
					pane.remove(prixaliment);
					pane.remove(poids);
					pane.remove(nom);
					pane.remove(ajouteraliment);
					
					pane.add(scrollermeuble);
					pane.add(prixmeuble);
					pane.add(hauteur);
					pane.add(type);
					pane.add(ajoutermeuble);
					
					f.repaint();
								
				}
				else if (e.getSource()==buttonaliment) {
					pane.remove(scrollermeuble);
					pane.remove(prixmeuble);
					pane.remove(hauteur);
					pane.remove(type);
					pane.remove(ajoutermeuble);
					
					pane.add(scrolleraliment);
					pane.add(prixaliment);
					pane.add(poids);
					pane.add(nom);
					pane.add(ajouteraliment);
				
				}
				
				else if (!ligne1.getText().equals("") && !ligne2.getText().equals("") && !ligne3.getText().equals("")) {
					String directeur=loggedinas.getNom()+" "+loggedinas.getPrenom();
					
					if (e.getSource()==ajouteraliment) {
						arrayaliment.add(new Aliment(ligne1.getText(),ligne2.getText(),ligne3.getText(),directeur));
						listaliment.setListData(arrayaliment.toArray());
						ligne1.setText("");
						ligne2.setText("");
						ligne3.setText("");
						
						
					}
					else if(e.getSource()==ajoutermeuble) {
						arraymeuble.add(new Meuble(ligne1.getText(),ligne2.getText(),ligne3.getText(),directeur));
						listmeuble.setListData(arraymeuble.toArray());
						ligne1.setText("");
						ligne2.setText("");
						ligne3.setText("");
					}
				}
				f.repaint();
			}
		}	
		
		
		
		class choose implements ListSelectionListener{// reagit a l'objet de la liste qui est selectionne
			public void valueChanged(ListSelectionEvent e) { // On cherche à échanger les éléments des listes lorsque sélectionnées. 
				
				
				if(listmeuble.getSelectedIndex()!=-1) {
					
					int i = listmeuble.getSelectedIndex();
					arraymeuble.remove(i);
					listmeuble.setListData(arraymeuble.toArray());
						
				}
			
				
				else if(listaliment.getSelectedIndex()!=-1) {
					
					int i = listaliment.getSelectedIndex();
					arrayaliment.remove(i);
					listaliment.setListData(arrayaliment.toArray());
				
				}
				f.repaint();
			}
		}	
		
		listaliment.addListSelectionListener(new choose());
		listmeuble.addListSelectionListener(new choose());
					
		
		buttonaliment.addActionListener(new click());
		buttonmeuble.addActionListener(new click());
		retour.addActionListener(new click());
		ajouteraliment.addActionListener(new click());
		ajoutermeuble.addActionListener(new click());
		produitspref.addActionListener(new click());
		
		
		f.revalidate();
		
	}
	public static void gerer_client(JFrame f,JPanel pane) {
		
		
		resetpage(f);
		
		
		JButton retour = new JButton("retour");
		retour.setBounds(0,0,100,25);
		pane.add(retour);
		
		JButton epicerie = new JButton("mon épicerie");
		epicerie.setBounds(100,275,125,35);
		if(loggedinas.getStatus()=="directeur") { //seul le directeur aura acces
			pane.add(epicerie);
		}
		
		
		JLabel titre = new JLabel("répertoire des membres");
		titre.setBounds(100,25,200,20);
		pane.add(titre);
		
		
		JLabel exemple = new JLabel("courriel                 naissance   status   fonds");
		exemple.setBounds(50,55,330,20);
		pane.add(exemple);
		
		
		
		
		ArrayList<Personne> repertoirtemp= (ArrayList)repertoir.clone();
		
		JList listPersonne = new JList(repertoirtemp.toArray()) ;
		JScrollPane scrollerPersonne = new JScrollPane(listPersonne);
		scrollerPersonne.setBounds(0, 75, 350, 200);
		pane.add(scrollerPersonne);
		
		
		String[] alphabet= {"","A","B","C","D","E","F","G","H","I","J","K","L"
				,"M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		
		JComboBox firstletter = new JComboBox(alphabet);
		firstletter.setBounds(350,75,35,20);
		firstletter.setSelectedIndex(0);
		pane.add(firstletter);
		
		
		
		
		class choisirlettre implements ItemListener{
		    public void itemStateChanged(ItemEvent e) {
		       if (e.getStateChange() == ItemEvent.SELECTED) {
		          String lettre =(String) e.getItem();
		          
		          repertoirtemp.clear();
		          for(Personne p:repertoir) {
		        	  if(p.toString().substring(0, 1).equals(lettre)) {
		        		  repertoirtemp.add(p);
		        	  }
		        	  else continue; 
		          }
		          listPersonne.setListData(repertoirtemp.toArray());
        		  f.repaint();
		       }
		    }       
		}
		
		
		
		
		
		class choose implements ListSelectionListener{// reagit a l'objet de la liste qui est selectionne
			public void valueChanged(ListSelectionEvent e) { // On cherche à échanger les éléments des listes lorsque sélectionné. 
				int index=listPersonne.getSelectedIndex();
				
				if (index!=-1) {
					Personne pTemp=repertoirtemp.get(index);
					i=repertoir.indexOf(pTemp);
					
					client( f, pane);
					listPersonne.clearSelection();// pour plus que l'objet ne soit selectionne
					
				}
				
			}
			
		}
		class click implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource()==retour) {
					Login (f,pane);
				}
				else if(e.getSource()==epicerie) {
					epicerie(f,pane);
				}
			}
		}
		epicerie.addActionListener(new click());
		listPersonne.addListSelectionListener(new choose());
		retour.addActionListener(new click());
		
		firstletter.addItemListener(new choisirlettre());
		
		f.revalidate();
	}
	

	
	public static void liquidite() {
		JFrame f3 = new JFrame();
		
		JPanel pane3= (JPanel)f3.getContentPane();
		f3.setSize(300, 150);
		f3.getContentPane().setLayout(null);
		f3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f3.setVisible(true);
		
		JTextField valeur = new JTextField("entrer une valeur");
		valeur.setBounds(25,50,200,25);
		pane3.add(valeur);
		
		JLabel solde = new JLabel("solde:"+select().getMoney());
		solde.setBounds(100,25,100,25);
		pane3.add(solde);
		
		JLabel compte = new JLabel("fonds de: "+select().getMail());
		compte.setBounds(25,0,250,25);
		pane3.add(compte);
		
		
		JButton ajouter = new JButton("ajouter");
		JButton soustraire = new JButton("retirer");
		//les clients ne peuvent pas retirer d'argent
		if (select().getStatus().equals("client")) {
			
			ajouter.setBounds(25,75,200,25);
			pane3.add(ajouter);
		}
		else {
			ajouter.setBounds(25,75,100,25);
			pane3.add(ajouter);
			
			soustraire.setBounds(125,75,100,25);
			pane3.add(soustraire);
		}
		
		
		
		class click implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource()==ajouter) {
					double plus = Double.valueOf(valeur.getText());
					select().addMoney(plus);
					solde.setText("solde:"+select().getMoney());
					f3.repaint();
				}
				// ici aussi on peut ignorer les exceptions de type. Le programme continue 
				//de rouler sans reagir s'il y a une lettre ou un autre symbole qu'un nombre.
				else if (e.getSource()==soustraire) {
					
					double moins = Double.valueOf(valeur.getText());
					
					if(select().getMoney()>=moins) {
						select().takeMoney(moins);
						solde.setText("solde:"+select().getMoney());
						f3.repaint();
					}
					else {
						valeur.setText("fonds insuffisant");
					}
				}
				
			}
		}
		
		ajouter.addActionListener(new click());
		soustraire.addActionListener(new click());
		
		
	}
	
public static void gestion(JFrame f,JPanel pane) {
		
		resetpage(f);
		
		
		
		JLabel titre = new JLabel("gestion du compte");
		
		JLabel nom = new JLabel("nom:");
		JTextField getnom = new JTextField(select().getNom());
		JLabel prenom = new JLabel("prénom:");
		JTextField getprenom = new JTextField(select().getPrenom());
		JLabel naissance = new JLabel("date de naissance:");
		JTextField getnaissance = new JTextField(select().getNaissance());
		
		JLabel identite = new JLabel("status présent: "+select().getStatus());
		JButton client = new JButton("client");
		JButton employe = new JButton("employé");
		JButton directeur = new JButton("directeur");
		JButton retour =  new JButton("retour");
		JLabel notif = new JLabel("changer le status du compte");
		
		JButton nomenter = new JButton("->");
		JButton prenomenter = new JButton("->");	
		JButton naissanceenter =  new JButton("->");
		
		
		JLabel nompresent = new JLabel(select().getNom());
		JLabel prenompresent = new JLabel(select().getPrenom());
		JLabel naissancepresent = new JLabel(select().getNaissance());
		
		
		class click implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				
				
				if (retour==e.getSource()) {
					client(f,pane);
				}
				
				else if(e.getSource()==nomenter){
					
					
					if(!getnom.getText().equals("")) {
						select().setNom(getnom.getText());
						nompresent.setText(select().getNom());
					}
					for (int i = 0; i < getnom.getText().length(); i++) {
						if (!Character.isLetter(getnom.getText().charAt(i)))
							JOptionPane.showMessageDialog(f,
									"Nom invalide");
					}

					for (int i = 0; i < getprenom.getText().length(); i++) {
						if (!Character.isLetter(getprenom.getText().charAt(i)))
							JOptionPane.showMessageDialog(f,
									"Prenom invalide");

					}
					
				}
				else if(e.getSource()==prenomenter) {
					if(!getprenom.getText().equals("")) {
						select().setPrenom(getprenom.getText());
						prenompresent.setText(select().getPrenom());
					}
				}
				else if(e.getSource()==naissanceenter) {
					if(!getnaissance.getText().equals("")) {
						select().setNaissance(getnaissance.getText());
						naissancepresent.setText(select().getNaissance());
					}	
				}
				else if(e.getSource()==client) {
					select().setStatus("client");
					identite.setText("status pr�sent: "+select().getStatus());
				}
				else if(e.getSource()==employe) {
					select().setStatus("employé");
					identite.setText("status présent: "+select().getStatus());
				}
				else if(e.getSource()==directeur) {
					select().setStatus("directeur");
					identite.setText("status présent: "+select().getStatus());
				}
				f.repaint();
			}
		}	
		
		
		
		
		retour.addActionListener(new click());
		retour.setBounds(0,0,100,25);
		pane.add(retour);
		
		titre.setBounds(135,10,120,20);
		pane.add(titre);
		
		
		
		nom.setBounds(10,60,130,20);
		pane.add(nom);
		
		getnom.setBounds(130,60,80,20);
		pane.add(getnom);
		
		nomenter.addActionListener(new click());
		nomenter.setBounds(210,60, 45, 20);
		pane.add(nomenter);
		
		nompresent.setBounds(265,60,150,20);
		pane.add(nompresent);
		
		
		
		prenom.setBounds(10,90,130,20);
		pane.add(prenom);
		
		getprenom.setBounds(130,90,80,20);
		pane.add(getprenom);
		
		prenomenter.addActionListener(new click());
		prenomenter.setBounds(210,90,45,20);
		pane.add(prenomenter);
		
		prenompresent.setBounds(265,90,150,20);
		pane.add(prenompresent);
		
		
		
		naissance.setBounds(10,120,130,20);
		pane.add(naissance);
		
		getnaissance.setBounds(130,120,80,20);
		pane.add(getnaissance);
		
		naissanceenter.addActionListener(new click());
		naissanceenter.setBounds(210,120,45,20);
		pane.add(naissanceenter);
		
		naissancepresent.setBounds(265,120,150,20);
		pane.add(naissancepresent);
		
	
		identite.setBounds(130,220,150,50);
		pane.add(identite);
		
		client.addActionListener(new click());
		client.setBounds(20,200,100,25);
		pane.add(client);
		
		employe.addActionListener(new click());
		employe.setBounds(140,200,100,25);
		pane.add(employe);
		
		directeur.addActionListener(new click());
		directeur.setBounds(260,200,100,25);
		pane.add(directeur);
		
		notif.setBounds(110,160,200,50);
		pane.add(notif);
		
			
	}

	public static void pref(JFrame f, JPanel pane) {
		resetpage(f);
		
				
		JButton meuble = new JButton("meubles");
		meuble.setBounds(0,275,100,25);
		pane.add(meuble);
		
		
		JButton aliment = new JButton("aliments");
		aliment.setBounds(100,275,100,25);
		pane.add(aliment);
		
		JButton retour= new JButton("retour");
		retour.setBounds(0,0,100,25);
		pane.add(retour);
		
		
		
		JLabel titrealiment = new JLabel("(nom),(gramme),(couleur),(directeur)=(j'aime)");
		titrealiment.setBounds(0,50,350,25);
		pane.add(titrealiment);
		
		JLabel titremeuble = new JLabel("(nom),(centimètres),(dollars),(directeur)=(j'aime)");
		titremeuble.setBounds(0,50,350,25);
		
		JLabel titre = new JLabel("Comptage total des préférences");
		titre.setBounds(0,25,200,25);
		pane.add(titre);
		
		
		
	
		JList listaliment = new JList(alimentpref.dico.entrySet().toArray()) ;
		JScrollPane scrolleraliment = new JScrollPane(listaliment);
		scrolleraliment.setBounds(0, 75, 350, 200);
		pane.add(scrolleraliment);
		
		
	
		JList listMeuble = new JList(meublepref.dico.entrySet().toArray()) ;
		JScrollPane scrollerMeuble = new JScrollPane(listMeuble);
		scrollerMeuble.setBounds(0, 75, 350, 200);
		pane.add(scrollerMeuble);
		
		class click implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				
				
				if(e.getSource()==aliment) {
					pane.remove(scrollerMeuble);
					pane.add(scrolleraliment);
					
					pane.remove(titremeuble);
					pane.add(titrealiment);
					
					f.repaint();
					
				}
				else if(e.getSource()==meuble) {
					pane.remove(scrolleraliment);
					pane.add(scrollerMeuble);
					
					pane.remove(titrealiment);
					pane.add(titremeuble);
					
					f.repaint();
					
				}
				else if(e.getSource()==retour) {
					epicerie(f,pane);
					
				}
			}
		}
		
		meuble.addActionListener(new click());
		aliment.addActionListener(new click());
		retour.addActionListener(new click());
		
		f.revalidate();
		
	}

		
}


