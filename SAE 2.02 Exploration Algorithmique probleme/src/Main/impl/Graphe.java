package Main.impl;

import Main.modele.*;

import java.util.*;

public class Graphe implements IGraphe {

    private List<IEntite> sommets;
    private List<List<Set<NatureRelation>>> matrice;

    public Graphe(){
        this.sommets = new ArrayList<>();
        this.matrice = new ArrayList<>();
    }

    public boolean ajouterEntite(IEntite entite){
        if(!sommets.contains(entite)){
            sommets.add(entite);
            int nbSommet = sommets.size();
            for(List<Set<NatureRelation>>ligne : matrice)
                ligne.add(new HashSet<>());
            List<Set<NatureRelation>> newLigne = new ArrayList<>();
            for(int i = 0; i < sommets.size(); i++)
                newLigne.add(new HashSet<>());
            matrice.add(newLigne);
            return true;
        }
        return false;
    }

    public boolean ajouterRelation(IEntite source, IEntite cible, NatureRelation nature){

        ajouterEntite(source);
        ajouterEntite(cible);

        int idDepart = sommets.indexOf(source);
        int idArrive = sommets.indexOf(cible);

        return matrice.get(idDepart).get(idArrive).add(nature);
    }

    public Set<IEntite> entites(){
        return Collections.unmodifiableSet(new HashSet<>(this.sommets));
    }

    public Set<RelationSortante> relationsSortantes(IEntite source){
        Set<RelationSortante> resultats = new HashSet<>();
        int idSource = sommets.indexOf(source);
        if (idSource == -1)
            return Collections.unmodifiableSet(resultats);

        List<Set<NatureRelation>> ligneSource = matrice.get(idSource);
        for (int i = 0; i < ligneSource.size(); i++) {
            Set<NatureRelation> natures = ligneSource.get(i);
            IEntite cible = sommets.get(i);
            for (NatureRelation n : natures) {
                resultats.add(new RelationSortante(cible, n));
            }
        }
        return Collections.unmodifiableSet(resultats);
    }

    public Set<RelationEntrante> relationsEntrantes(IEntite cible){
        Set<RelationEntrante> resultats = new HashSet<>();
        int idCible = sommets.indexOf(cible);

        if (idCible == -1)
            return Collections.unmodifiableSet(resultats);

        for (int i = 0; i < matrice.size(); i++) {
            Set<NatureRelation> natures = matrice.get(i).get(idCible);

            if (!natures.isEmpty()) {
                IEntite source = sommets.get(i);
                for (NatureRelation n : natures) {
                    resultats.add(new RelationEntrante(source, n));
                }
            }
        }
        return Collections.unmodifiableSet(resultats);
    }
}
