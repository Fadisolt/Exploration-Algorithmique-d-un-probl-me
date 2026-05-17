package main.sprint1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListeGraphe{

    private HashMap<String, List<Arete>> Liste;

    public ListeGraphe() {
        this.Liste = new HashMap<>();
    }

    public void ajouterSommet(String nom) {
        if (!Liste.containsKey(nom))
            Liste.put(nom, new ArrayList<>());
    }

    public void ajouterArete(String depart, String etiquette, String arrive){
        ajouterSommet(depart);
        ajouterSommet(arrive);

        List<Arete>Successeurs = Liste.get(depart);
        boolean trouve = false;

        for(Arete a: Successeurs){
            if (a.arrive.equals(arrive)){
                a.etiquette = etiquette;
                trouve = true;
                break;
            }
        }
        if (!trouve) {
            Successeurs.add(new Arete(arrive, etiquette));
        }
    }

    public boolean existeArete(String depart, String arrive) {
        if(!Liste.containsKey(depart)) {
            return false;
        }
        for (Arete a : Liste.get(depart)) {
            if (a.arrive.equals(arrive)) {
            return true;
            }
        }
        return false;
    }

    public String getEtiquette(String depart, String arrive){
        if (!Liste.containsKey(depart)){
            return null;
        }
        for (Arete a : Liste.get(depart)) {
            if (a.arrive.equals(arrive)) {
                return a.etiquette;
            }
        }
        return null;
    }

}
