# Lancement de la demonstration

## Préparation du robot

Le robot se met tout seul en point d'accès wifi lors du démarrage, il suffit donc de brancher l'Arduino, le pcduino, et après quelques minutes ( environ 5 ), le point d'accès Robotaf apparait dans la liste des reseau disponible.

Il faut toutefois lancer à la main le terminal Erlang ainsi que le serveur d'écoute Java, pour cela il faut qu'un ordinateur se connecte en ssh via la commande 

```
ssh ubuntu@192.168.100.1
java -jar JavaServer.jar 44000
```

```
ssh ubuntu@192.168.100.1
erl -sname control -setcookie ROBOT
```

En cas de problème à l'éxécution, relancer le shell erlang et le serveur java.
Si l'éxécution du code bloque sur une instruction de type : "On exec une fonction erlang: **********", alors le problème viens du shell erlang.

## Préparation de l'application android

L'application est à lancer sur un smartphone ou tablette android ( testé jusqu'a 5.1 et supérieur ). Il faut connecter le device au réseau wifi "Robotaf" qui est public, et lancer l'application Robotaf.

Il faut ensuite se connecter au robot via le menu de l'application, puis "Se connecter", il faut ensuite saisir les informations (par defaut) :
* IP : 192.168.100.1
* Port : 44000

On peut ensuite directement éxécuter le code de l'application via le bouton "run", la flèche de la navbar à droite des bouton pour load/save les algos.

> Attention à verifier la connexion au robot : Verifier dans le menu si le bouton "Se connecter" est toujours present ou non

## Coding guidelines 

* Un programmes doit terminer par une instruction return 0 ( ou autre entier);
* La fonction principale doit être de type int sans argument
* le elseif n'est pas pris en compte, utiliser des suite de if/else
* Les fonctions utilisant les capteurs retournent des int, elles doivent donc être comparées avec des int ( cf les erreurs de compilation dans le serveur java si besoin )
