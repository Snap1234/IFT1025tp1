# IFT1025tp1
Pour la structure générale du code, l'idée est d'écrire le corps à l'intérieur
d'une classe et que chaque "page" ou "menu" soit une méthode de la classe. Le tout
se fait de manière statique pour facilement accéder aux pages où aux atttributs
globales.

Le tout commence par une "initialisation" où on inclue des données de base pour
faire l'exemple de l'utilisation du logiciel.

Ensuite on arrive à la méthode page "login" où on peut soit entrer le mail d'un
utilisateur pour se connecter ou bien aller à la méthode page d'inscription.

À la page d'inscription, on peut entrer son nom, prénom et date de naissance, 
puis choisir son status parmis client, employé ou directeur.

En se connectant, la page présenté sera différente si la connection a été fait à
partir d'un compte client, employé ou directeur. Plus précisément, le choix est fait 
qu'il n'y a qu'une seule classe Personne() qui contient simplement un attribut 
déterminant le status. Ainsi, à la base, les trois status ont les même fonctionnalité
mais c'est l'interface même qui dicte les différences. En effet,par exemple,
Le boutons "mon épicerie" apparaît seulement si l'utilisateur est reconnu comme 
directeur.

Une fois connecté, on arrive à la page de gestion des membres. Dans cette page,
on voit la liste des membres et on peut en sélectionner un pour accéder à
son dossier. On peut aussi sélectionner une lettre pour ne faire apparaître que les
membres dont le nom commence par celle-ci.

À la page dossier du client sélectionné appelé client(), on peut choisir ses produits
favoris ou accéder à d'autres fenêtres pour soit modifier ses données personelles,
ajouter/retirer des fonds ou supprimer le compte.

Si on se connecte comme directeur, dans la page gestion, on peut aussi accéder à la page 
"mon épicerie".

à la page "mon épicerie", on peut ajouter ou enlever des produits qui seront disponiblent
pour les clients. 

On peut aussi accéder à une page pref() ou on trouve les produits aimés par les clients et
d'entre-eux l'ont aimé.

Ainsi, tout ce qui est demandé, est inclu, ni plus ni moins.
