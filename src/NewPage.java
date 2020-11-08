package tp1;


import javax.swing.*;


abstract class NewPage {
	public NewPage() {}
	
	public static void Login(JFrame f) {
		f.setSize(400, 400);
		
		
		JLabel log = new JLabel();;
		JTextField username = new JTextField();
		JLabel endmail = new JLabel();
		JLabel titre = new JLabel();
		JButton inscrit = new JButton();
		JButton entrer = new JButton();
		
		
		JPanel pane= (JPanel)f.getContentPane();
		f.getContentPane().setLayout(null);
		
		entrer.setText("entrer");
		entrer.setBounds(120,195,100,20);
		pane.add(entrer);
		
		inscrit.setText("s'inscrire");
		inscrit.setBounds(120,250,100,50);
		pane.add(inscrit);
		
		titre.setText("Projet fidélité");
		titre.setFont(titre.getFont().deriveFont(18.0f));
		titre.setBounds(110, 50, 200, 100);
		pane.add(titre);
		
		
		username.setText("NomPrenom");
		username.setBounds(120,175,100,20);
		pane.add(username);
	
		log.setText("login:");
		log.setBounds(80,175,50,20);
		pane.add(log);
		
		
		endmail.setText("@magasin.ca");
		endmail.setBounds(220,175,100,20);
		pane.add(endmail);
		;
	}
	public static void inscription(JFrame f) {
		f.setSize(400,400);
		f.getContentPane().setLayout(null);
		
		JLabel titre = new JLabel("insciption");
		
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
		
		
		JPanel pane= (JPanel)f.getContentPane();
		
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
		
		client.setBounds(20,200,100,25);
		pane.add(client);
		
		employe.setBounds(140,200,100,25);
		pane.add(employe);
		
		directeur.setBounds(260,200,100,25);
		pane.add(directeur);
		
		
		
		
		
		
	}
}
