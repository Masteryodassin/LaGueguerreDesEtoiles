package entities.univers;

import java.util.ArrayList;
import java.util.List;

public class Univers {

    private List<Planete> planetes = new ArrayList<>();


    public Univers(List<Planete> planetes) {
        this.planetes = planetes;
    }



    public List<Planete> getPlanetes() {
        return planetes;
    }

    public void setPlanetes(List<Planete> planetes) {
        this.planetes = planetes;
    }
}
