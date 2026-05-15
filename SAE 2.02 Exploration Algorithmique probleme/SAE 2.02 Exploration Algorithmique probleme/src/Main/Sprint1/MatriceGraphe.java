package Main.Sprint1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatriceGraphe{
    private List<String> sommets;
    private List<List<String>> matrice;

    public MatriceGraphe(){
        this.sommets = new ArrayList<>();
        this.matrice = new ArrayList<>();
    }

    public void ajouterSommet(String nom){
        if(!sommets.contains(nom)){
            sommets.add(nom);
            int nbSommet = sommets.size();
            for(List<String>ligne : matrice)
                ligne.add(null);
            List<String> newLigne = new ArrayList<>(Collections.nCopies(nbSommet, null));
            matrice.add(newLigne);
        }

    }

    public void ajouterArete(String depart, String etiquette, String arrive){
        ajouterSommet(depart);
        ajouterSommet(arrive);

        int idDepart = sommets.indexOf(depart);
        int idArrive = sommets.indexOf(arrive);

        String valEtiquette = (etiquette == null) ? "" : etiquette;
        matrice.get(idDepart).set(idArrive, valEtiquette);
    }

    public boolean existeArete(String depart, String arrive) {
        int idDepart = sommets.indexOf(depart);
        int idArrive = sommets.indexOf(arrive);

        if (idDepart == -1  || idArrive == -1)
            return false;

        return matrice.get(idDepart).get(idArrive) != null;
    }

    public String getEtiquette(String depart, String arrive) {
        int idDepart = sommets.indexOf(depart);
        int idArrive = sommets.indexOf(arrive);

        if (idDepart == -1  || idArrive == -1)
            return null;

        return matrice.get(idDepart).get(idArrive);
    }
}
