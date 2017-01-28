# INF7845
Vaisseaux dans l'espace

https://info.uqam.ca/~privat/INF7845/TP2/


Antoine LeBel - LEBA23068603

Tristan Vacher - VACT24119400

Justifications
==============

- Les deux points de contravariance à faire attention sont aux niveaux des vaisseaux armées léger et lourd pour l'équipement des phaser et des blasters.
    Où est le deuxième point?j

- Factory simple, ne respecte pas le principe ouvert fermé mais offre
une meilleure simplicité face au problème.

Le problème est que chaque "produit" de l'espace (container, vaisseau et
arme possède des particularités qui leurs empêchent d'abstraire leur
création.

La seule cohésion qu'ils possèdent et qu'ils sont tous transportables.

- Il y a besoin d'un des éléments disponibles (équipé et non équipé), transporté ou non transporté

- Le principe à respecter est le suivant pour les classes abstraites et les interfaces :
    Ce qui change est une interface
    Ce qui est fixe est une classe abstraite

- Les éléments changeant dans le problèmes sonti: 
    - les équipement/container/vaisseaux créer
    - le chargement déchargements d'une soupe'
    - Équiper ou déséquiper quelque chose
    - Les méthodes localiser, getMasse(), équiper / déséquiper

Donc
Vaisseau est une interface, arme est une interface, transportable est une classe abstraite (getNom(), construct) 

- Une classe façade permet de gérer les quantités, les créations et les questionnement sur le programme
- Arme est abstraite parce qu'elle sait équiper et déséquiper


