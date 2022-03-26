# chercheCP

Petit logiciel en JavaFX pour retrouver le code postal avec le nom de la ville en se basant sur le fichier csv de la poste
https://www.data.gouv.fr/fr/datasets/r/554590ab-ae62-40ac-8353-ee75162c05ee

Le fichier csv est intégré aux sources

On peut entrer le nom des villes sans respecter la casse ni se préoccuper des accents.

![Screenshot](Capture.png)



Pour l'aspect Material Design ce projet utilise le framework jfoenix

**Ce projet est désormais compilable avec JDK14 et gradle 6.5.1**

** 18/03/22 Mise à jour en cours vers JDK17 et JFX17**

## Fix
- JFXTextField incompatibles avec le nouveau JDK
## Updates
- Le plus petit code postal est affiché en premier
- S'il existe d'autres codes postaux pour une ville donnée un tooltip s'affiche au survol du code
- De même un bouton + devient visible pour afficher la liste sous forme de popup

<!--Notes perso:  https://mkyong.com/java/how-to-read-and-parse-csv-file-in-java/ -->
