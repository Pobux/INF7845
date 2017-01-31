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

La factory via la méthode "construire()" permet d'embler de valider et d'assurer les types nécessaires pour chaque vaisseau.

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

- Utilisation de l'introspection pour la validation des paramètres via la factory.

- Chaque construction d'un produit est suivi de sa description d'arguments afin de permettre une bonne documentation.

- Une classe façade permet de gérer les quantités, les créations et les questionnement sur le programme
- Arme est abstraite parce qu'elle sait équiper et déséquiper

- Une exception est lancée afin d'assurer la non construction des produits de l'espace.

- Expliquer pourquoi vaisseau léger ne pourrait pas hérité de vaisseau lourd afin de se spécialiser aux niveaux des armes.

- La soute, on utilise le principe de Demeter pour conserver appeler les sous méthodes de soute par Transport / Hybride

- getVolume de Transport considère le volume de la soute aussi.

- Obliger de copier Transport sur Hybride

- Sans BD, la gestion des équipements et leur localisation (le tracking) est conservé sous FarStarAPI. La BD sert à faire le suivi des éléments existant afin que ceux-ci ne soit pas créée en double. Elle sort aussi de gestionnaire à savoir si un équipement ou non est disponible (non-équiper et non-chargé)

- Object[] aurait pu être un tableau de Integer FIX, mais l'abstraction vers object permet une meilleure extension en offrant la possibilité de mettre des doubles ou des string pour différents attributs futurs si nécessaire. La validation restant la même.

Déséquiper est dans vaisseau arme, c'est un choix de conception, la covariance doit être respectée.

- getMasse est appelé récursivement sur un vaisseau de transport si celui-ci est utilisé. Inspirer de Composite.
- La localisation utilise la réflexivité pour chercher les éléments
- L'association entre la soute et le vaisseau est bidirectionnelle, les deux ont besoin de connaître à qui ils appartiennent.
- La visibilité des packages a été séparé pour façade
- À noter que les volumes et les masses doivent toujours être générées de manière dynamique (Voir Composite), du coup on ne peut enregistrer un volume ou une masse fixe à cause du vaisseau qui change.
- Les armes équipées sont considérées comme étant externes au vaisseau et du coup augmente le volume de celui-ci.

#Trace
Caractéristique de : VT-2
Type : TRANSPORT
Masse : 157
Volume : 100

Il reste 73 de volume disponible dans la soute.
Chargement :
CT-5
CT-4
CT-3
PH-2
CT-2
VC-1
CT-1


Caractéristique de : MR-1
Type : ARMELOURD
Masse : 713
Volume : 206
Armes équipées : 
BL-2
BL-1
PH-4
PH-3


Caractéristique de : VC-1
Type : ARMELEGER
Masse : 51
Volume : 11
Armes équipées : 
PH-1


PH-1 est dans VC-1
PH-2 est dans VT-2
PH-3 est dans MR-1
PH-4 est dans MR-1
BUILD SUCCESSFUL (total time: 0 seconds)
