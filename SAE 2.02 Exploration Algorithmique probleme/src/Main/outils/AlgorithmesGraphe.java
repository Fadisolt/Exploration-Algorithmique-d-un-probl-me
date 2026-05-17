package Main.outils;

import Main.modele.IEntite;
import Main.modele.IGraphe;
import Main.modele.NatureRelation;
import Main.modele.RelationEntrante;

import java.util.HashSet;
import java.util.Set;

public final class AlgorithmesGraphe {

    public static Set<IEntite> dependantsDirects(IGraphe graphe, IEntite cible) {
        Set<IEntite> dependants = new HashSet<>();

        // On parcourt toutes les relations qui pointent vers la cible
        for (RelationEntrante relation : graphe.relationsEntrantes(cible)) {
            // On vérifie si c'est une dépendance statique (exclut CONTIENT) [cite: 69, 74, 97]
            if (relation.nature().estDependanceStatique()) {
                dependants.add(relation.source()); // Ajout de l'entité qui dépend de la cible [cite: 79]
            }
        }

        return dependants;
    }

    public static Set<IEntite> dependantsElargis(IGraphe graphe, IEntite cible) {
        Set<IEntite> resultat = new HashSet<>();


        Set<IEntite> directs = dependantsDirects(graphe, cible);
        resultat.addAll(directs);


        for (IEntite entite : directs) {
            IEntite courant = entite;
            boolean continuerRemontee = true;

            while (continuerRemontee) {
                IEntite parent = null;
                for (RelationEntrante relation : graphe.relationsEntrantes(courant)) {
                    if (relation.nature() == NatureRelation.CONTIENT) {
                        parent = relation.source();
                        break; // On suppose qu'une entité n'a qu'un seul conteneur direct
                    }
                }
                if (parent == null) {
                    continuerRemontee = false;
                } else {
                    resultat.add(parent);

                    if (!parent.estType()) {
                        continuerRemontee = false; // On s'arrête au premier paquetage
                    } else {
                        courant = parent;
                    }
                }
            }
        }

        return resultat;
    }
}
