##### devoir :
Le devoir suivant porte sur les tests unitaitres en utilisant la technique des tests structurels (boite blanche). L'exercice concerne la simulation de la connection d"une carte bancaire à un guichet automatique. Le but étant d'implémenter les classes suivant le cahier de charges ci-joint et de réaliser les questions théoriques et pratiques détaillées dans la dernière page.


##### Enonce:
Enoncé: Carte Bancaire
 Le but  est de construire des classes Java et de les tester avec JUnit.
  Un terminal de paiement par carte bancaire permet de lire un numéro de carte, de l'authentifier
 via un service externe de validation, puis au possesseur de la carte de se connecter en entrant son
 code secret.
  Si celui-ci est correct, la carte est connectée. Si le numéro de carte n'est pas légal, le terminal
 refuse la connexion, et si l'utilisateur entre plus de 4 fois un code erroné, le terminal invalide la carte.


##### pour executer :
pour executer au tant que JAVA APPLICATION  tout ca va bien marher 
pour executer l application au tant que web APPLICATION  sue le serveur change la mode de connexion a la base de donne dans la classe validator commente du code et efface le commentaire sur l autre patie du code 

### 
pour executer les tests il faut exclure la classe main et la servlet ATM afin d obtenire un bon coverage
pour faire ca il suffit de cliquer au boutton droit de la souris sur le projet -> propriete ->java build paths ->source -> excluded -> add 



![image](https://user-images.githubusercontent.com/94359353/223516787-4931f905-d759-4149-908e-235ad978d92b.png)
