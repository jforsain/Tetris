# Tetris

Auteurs : Jean-Luc FORSAIN, Antoine LIEBERT, Jordy RUIZ-GABANCHO

Build et lancement du programme - Exécuter la commande suivante :
mvn clean install && java -jar *.jar

Les fonctionnalités de notre Tetris :
- Menu principal lors du lancement du programme
- Mode 1 joueur ou mode multijoueurs
- Affichage du score, du niveau, du nombre de lignes complétées et de la prochaine pièce en temps réel
- Un niveau de plus toutes les 30 secondes (+10% de vitesse de descente des pièces)
- 7 pièces différentes avec une couleur pour chacun et toutes leurs positions possibles
- Réponse aux commandes des utilisateurs pour déplacer latéralement les pièces, les faire tourner, et les descendre instantanément ou rapidement
- Gestion des collisions
- Tableau des 5 meilleurs scores issus d'un fichier qui se met à jour à chaque partie

Les spécificités du multijoueurs : 
- Affichage du score de l'adversaire
- A chaque fois qu'un joueur marque 1000 points, il inflige à son adversaire un des trois malus (aléatoire) :
  - Augmentation de deux niveaux, et donc de deux paliers de vitesse
  - Ajout d'une ligne en bas de la grille, avec donc l'ensemble des cases non vides qui montent d'un cran
  - Perte de contrôle des touches pendant trois séquences de 3 secondes

Comment jouer :

Mode 1 joueur :
Depuis le menu, appuyez sur la touche 'a'.
Une fois la partie lancée, voici les touches qui répondront à vos actions :
- Flèche du haut : Faire tourner la pièce (sens horaire)
- Flèche du bas : descendre la pièce plus rapidement
- Flèche de droite : décaler la pièce d'une case vers la droite
- Flèche de gauche : décaler la pièce d'une case vers la gauche
- Barre d'espace : descendre la pièce instantanément
La partie s'arrête lorsque la nouvelle pièce ne peut plus apparaître. Si votre score figure parmi les 5 meilleurs, il est enregistré.

Mode 2 joueurs :
Ouvrez deux instances du programme. 
Un premier joueur appuie sur la touche 'b' pour héberger la partie
Un second joueur appuie sur la touche 'c' pour rejoindre la partie
La partie se lance alors dans chacune des instances. Le gagnant est celui qui tient le plus longtemps indépendamment du score.

Exercice architecture :
Notre architecture est de type MVC, Modèle-Vue-Controleur. Nous avons choisi ce type d'architecture pour séparer logiquement tous les composants du programme. La modèle contient toutes les données (pièce, grille, données de jeu) et les règles à respecter. La vue est l'interface utilisateur, elle affiche les composants graphiques. Le controleur est le coordinateur de l'ensemble, il suit les actions de l'utilisateur, modifie le modèle et contrôle la vue.
Ainsi, la vue a connaissance du modèle mais ne le modifie pas. Le controleur a connaissance de la vue et du modèle et peut les modifier. Le modèle n'a ni connaissance de la vue ni du controleur.
Le fait de fonctionner en MVC a permis à notre programme d'être évolutif et facile à maintenir. Par exemple, nous avons pu ajouter la fonctionnalité multijoueurs sans perdre de temps à ré-écrire des fonctionnalités existantes car notre programme a atteint une flexibilité satisfaisante grâce au pattern MVC.

Exercice Design Pattern / Solid :
Pattern Observable/Observer : Nous utilisé le pattern Observable/Observer entre l'objet grille et l'affichage du jeu. Lorsque la grille subit une modification de ses données, elle notifie la vue. La vue se met alors à jour en reprenant la dernière version du modèle. Ce pattern est très utile dans le cadre d'un jeu avec des interactions utilisateurs et de nombreuses modifications du modèle. Il nous a permis de gagner du temps sur la gestion des mises à jour des composants graphiques.
Pattern Factory : Le pattern factory a été utilisé dans le modèle, et plus particulièrement avec les pièces. Nous avons défini une classe Piece abstraite, 7 classes filles pour chaque type de pièce, et une classe Factory qui permet de générer aléatoirement une des 7 classes filles possibles. Ce système nous a donc permis d'instancier dynamiquement nos sous-classes et de permettre facilement l'ajout de nouvelles pièces pour des éventuelles évolutions.
O de Solid : Open-Closed Principle. Nous avons veillé à laisser ouvert aux évolutions tous les composants de notre programme, tout en évitant de permettre la modification. A chaque évolution de notre programme, nous avons grâce au respect de ce principe pu ajouter des fonctionnalités sans jamais se perdre dans le code et compromettre le bon fonctionnement du jeu.


