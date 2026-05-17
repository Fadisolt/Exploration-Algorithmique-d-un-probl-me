package main.outils;

import main.modele.IEntite;
import main.modele.IGraphe;
import main.modele.NatureRelation;
import main.modele.RelationEntrante;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public final class AlgorithmesGraphe {

    public static Set<IEntite> dependantsDirects(IGraphe graphe, IEntite cible) {
        Set<IEntite> dependants = new HashSet<>();
        for (RelationEntrante relation : graphe.relationsEntrantes(cible)) {
            if (relation.nature().estDependanceStatique()) {
                dependants.add(relation.source());
            }
        }
        return dependants;
    }

    public static Set<IEntite> dependantsElargis(IGraphe graphe, IEntite cible) {
        Set<IEntite> resultat = new HashSet<>();
        Set<IEntite> directs = dependantsDirects(graphe, cible);
        resultat.addAll(directs);


        Queue<IEntite> aTraiter = new LinkedList<>(directs);
        Set<IEntite> visite = new HashSet<>(directs);

        while (!aTraiter.isEmpty()) {
            IEntite courant = aTraiter.poll();

            for (RelationEntrante relation : graphe.relationsEntrantes(courant)) {
                if (relation.nature() == NatureRelation.CONTIENT) {
                    IEntite parent = relation.source();


                    if (!visite.contains(parent)) {
                        resultat.add(parent);
                        visite.add(parent);
                        if (parent.estType()) {
                            aTraiter.add(parent);
                        }
                    }
                }
            }
        }

        return resultat;
    }
}