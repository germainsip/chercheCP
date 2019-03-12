# chercheCP

Petit logiciel en JavaFX pour retrouver le code postal avec le nom de la ville en se basant sur le fichier csv de la poste
https://www.data.gouv.fr/fr/datasets/r/554590ab-ae62-40ac-8353-ee75162c05ee

Le fichier csv est intégré aux sources

On peut entrez le nom des villes sans respecter la casse ni se préoccuper des accents.

![Screenshot](Capture.png)

# test de plantuml dans un markdown

!!! info
	esstjjkhkljhljkh

```plantuml
@startuml
skinparam Handwritten true
skinparam usecase {
  BackgroundColor darkorange
  bordercolor darkorange
}
left to right direction
actor documentaliste
actor benevole
actor usager
usager<|--benevole
benevole<|--documentaliste
usager->(consulter liste des documents)
benevole->(enregistrer un pret)
documentaliste-->(commander un document)
documentaliste-->(editer un document)
documentaliste-->(enregistrer un document)
documentaliste-->(inscription d'un usager)
documentaliste-->(mettre au rebus un document)
@enduml
```

## Pour les séquences

* [ ] 

```plantuml
@startuml
skinparam Handwritten true
skinparam usecase {
   BackgroundColor darkorange
   Bordercolor darkorange
}
actor user
participant "first class" as A
participant "second class" as B
participant "last class" as C

user -> A: dowork
activate A
A->B : create request
activate B
B->C : dowork
activate C
C-->B: workdone
destroy C

B-->A:request created
deactivate B

@enduml
```

