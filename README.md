# Exploration-Algorithmique-d-un-probl-me
SAE 2.02 Exploration Algorithmique d'un problème Thème en 2026 : Graphes de dépendances
Groupe 106 :
Fadi
Lucas
Idir
Clément

Tous nos tests ont été passés, l'ensemble du Sprint 1 est fonctionnelle.
Là où ça à poser probleme, c'est justement sur testAjoutSommetArete dans la classe TestMatrice avec la gestion de doublon Quand le test essayait d'ajouter "AppliChenille" une deuxième fois, notre code ne le bloquait pas correctement. Résultat : la matrice d'adjacence se redimensionnait pour rien, recréait une nouvelle ligne et une nouvelle colonne, et ça décalait absolument tous nos index.
Il a fallu qu'on revoie complètement la méthode ajouterSommet dans MatriceGraphe pour qu'elle scanne efficacement les sommets déjà existants avant de toucher à la taille du tableau.
