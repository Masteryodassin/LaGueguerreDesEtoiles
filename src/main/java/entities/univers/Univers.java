package entities.univers;

import java.util.ArrayList;
import java.util.List;

public class Univers {

    public Univers(){}

    private List<Joueur> joueurs = new ArrayList<>();

    private List<Planete> planetes = new ArrayList<>();

    /////////////////////////// Getters and Setters /////////////////////////////////

    public List<Planete> getPlanetes() {
        return planetes;
    }

    public void setPlanetes(List<Planete> planetes) {
        this.planetes = planetes;
    }

    public List<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }
}
