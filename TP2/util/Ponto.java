package util;
import java.util.List;

import individuo.Individuo;

public class Ponto {
    public double[] objetivos;
    public List<Ponto> S;
    public int n;
    public int rank;

    private Individuo ind;

    public Ponto(Individuo ind) {
        this.ind = ind;
        objetivos = ind.getObjetivos();
    }

    public Individuo getInd() {
        return this.ind;
    }

    public String toString() {
        return ind.toString() + "n: " + n + " rank: " + rank;
    }
}
